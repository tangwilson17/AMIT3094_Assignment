<%@page import="java.util.Base64"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="entity.Product"%>
<%@page import="entity.OrderList"%>
<%@page import="java.time.ZoneId"%>
<%@page import="java.time.YearMonth"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.sun.xml.wss.util.DateUtils"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entity.Payment"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="zxx" class="js">

    <%@ include file = "header.jsp" %>

    <body class="nk-body bg-lighter npc-default has-sidebar ">
        <div class="nk-app-root">
            <!-- main @s -->
            <div class="nk-main ">
                <%@ include file = "sidebar.jsp" %>


                <!-- wrap @s -->
                <div class="nk-wrap ">
                    <%@ include file = "navbar.jsp" %>
                    <jsp:include page="/admin/GetReportData"></jsp:include>

                    <%
                        if (session.getAttribute("redirect") != null) {
                            String redirect = (String) session.getAttribute("redirect");
                            session.removeAttribute("redirect");
                            response.sendRedirect(redirect);
                            return;
                        }

                        List<Payment> paymentList = (List<Payment>) session.getAttribute("payment-list");
                        List<OrderList> orderList = (List<OrderList>) session.getAttribute("orders-list-report");
                        List<Double> paymentsByDay = new ArrayList<Double>();

                        // create a Map to store the total quantity sold for each product
                        Map<Product, Integer> productQuantities = new HashMap<Product, Integer>();

                        // loop through each order and update the productQuantities map
                        for (OrderList order : orderList) {
                            Product product = order.getProductId();
                            int quantity = order.getQty();

                            // check if the product ID is already in the map
                            if (productQuantities.containsKey(product)) {
                                int currentQuantity = productQuantities.get(product);
                                productQuantities.put(product, currentQuantity + quantity);
                            } else {
                                productQuantities.put(product, quantity);
                            }
                        }

                        // create a list of map entries
                        List<Map.Entry<Product, Integer>> entries = new ArrayList<Map.Entry<Product, Integer>>(productQuantities.entrySet());

                        // sort the list using a comparator
                        Collections.sort(entries, new Comparator<Map.Entry<Product, Integer>>() {
                            @Override
                            public int compare(Map.Entry<Product, Integer> e1, Map.Entry<Product, Integer> e2) {
                                return e2.getValue().compareTo(e1.getValue()); // sort in descending order by value
                            }
                        });

                        // create a new map using the sorted entries
                        Map<Product, Integer> sortedMap = new LinkedHashMap<Product, Integer>();
                        for (Map.Entry<Product, Integer> entry : entries) {
                            sortedMap.put(entry.getKey(), entry.getValue());
                        }

                        Calendar calendar = Calendar.getInstance();
                        int currentMonth = calendar.get(Calendar.MONTH);
                        int currentYear = calendar.get(Calendar.YEAR);
                        calendar.set(currentYear, currentMonth, 1);

                        // Get number of days in the current month
                        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        // Loop through each day in the month
                        for (int i = 1; i <= numDays; i++) {
                            LocalDate currentDate = LocalDate.of(currentYear, currentMonth + 1, i);

                            // Create a list to store payments for the current day
                            double paymentsForDay = 0;

                            // Loop through each payment and compare dates
                            for (Payment payment : paymentList) {
                                LocalDate paymentDate = payment.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                                if (paymentDate.compareTo(currentDate) == 0) {
                                    paymentsForDay += payment.getAmount();
                                }
                            }
                            paymentsByDay.add(paymentsForDay);
                        }


                    %>
                    <!-- content @s -->
                    <div class="nk-content ">
                        <div class="container-fluid">
                            <div class="nk-content-inner">
                                <div class="nk-content-body">
                                    <div class="nk-block-head nk-block-head-sm">
                                        <div class="nk-block-between">
                                            <div class="nk-block-head-content">
                                                <h3 class="nk-block-title page-title">Website Analytics</h3>
                                            </div><!-- .nk-block-head-content -->
                                            <div class="nk-block-head-content">
                                                <div class="toggle-wrap nk-block-tools-toggle">
                                                    <a href="#" class="btn btn-icon btn-trigger toggle-expand me-n1" data-target="pageMenu"><em class="icon ni ni-more-v"></em></a>
                                                    <div class="toggle-expand-content" data-content="pageMenu">
                                                        <ul class="nk-block-tools g-3">
                                                            <li class="nk-block-tools-opt"><button type="button" onclick="window.print()" class="btn btn-primary"><em class="icon ni ni-reports"></em><span>Print</span></button></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div><!-- .nk-block-head-content -->
                                        </div><!-- .nk-block-between -->
                                    </div><!-- .nk-block-head -->
                                    <div class="nk-block">
                                        <div class="row g-gs">
                                            <div class="col-lg-12 col-xxl-12">
                                                <div class="card h-100">
                                                    <div class="card-inner">
                                                        <div class="card-title-group pb-3 g-2">
                                                            <div class="card-title card-title-sm">
                                                                <h6 class="title">Revenue Overview</h6>
                                                                <p>The website monthly revenue graphed and calculated</p>
                                                            </div>
                                                        </div>
                                                        <div class="analytic-ov">
                                                            <div class="analytic-data-group analytic-ov-group g-3">
                                                                <div class="analytic-data analytic-ov-data">
                                                                    <div class="title">Total Revenue</div>
                                                                    <div class="amount"><%= String.format("%.2f", session.getAttribute("total-revenue"))%> MYR</div>
                                                                </div>
                                                                <div class="analytic-data analytic-ov-data">
                                                                    <div class="title">Today's Revenue</div>
                                                                    <div class="amount"><%= String.format("%.2f", session.getAttribute("today-revenue"))%> MYR</div>
                                                                </div>

                                                            </div>
                                                            <div class="analytic-ov-ck">
                                                                <canvas class="sales-data" id="analyticOvData"></canvas>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div><!-- .card -->
                                            </div><!-- .col -->

                                            <div class="col-lg-7 col-xxl-6">
                                                <div class="card h-100">
                                                    <div class="card-inner mb-n2">
                                                        <div class="card-title-group">
                                                            <div class="card-title card-title-sm">
                                                                <h6 class="title">Top Selling Products</h6>
                                                                <p>Top 5 products sold in this month.</p>
                                                            </div>

                                                        </div>
                                                    </div>

                                                    <div class="nk-tb-list is-loose traffic-channel-table">
                                                        <div class="nk-tb-item nk-tb-head">
                                                            <div class="nk-tb-col nk-tb-channel"><span>Product Image</span></div>
                                                            <div class="nk-tb-col nk-tb-sessions"><span>Product Name</span></div>
                                                            <div class="nk-tb-col nk-tb-prev-sessions"><span>Quantity Sold</span></div>
                                                            <div class="nk-tb-col nk-tb-change"><span>Total</span></div>
                                                        </div><!-- .nk-tb-head -->
                                                        <%                                                        for (Map.Entry<Product, Integer> entry : sortedMap.entrySet()) {
                                                                Product product = entry.getKey();
                                                                int quantity = entry.getValue();

                                                                String base64img = Base64.getEncoder().encodeToString(product.getImage());
                                                        %>
                                                        <div class="nk-tb-item">
                                                            <div class="nk-tb-col nk-tb-channel col-4">
                                                                <img src="data:image/png;base64, <%= base64img%>" alt="" class="thumb w-25">
                                                            </div>
                                                            <div class="nk-tb-col nk-tb-sessions">
                                                                <span class="tb-sub tb-amount"><span><%= product.getProductname()%></span></span>
                                                            </div>
                                                            <div class="nk-tb-col nk-tb-prev-sessions">
                                                                <span class="tb-sub tb-amount"><span><%= quantity%></span></span>
                                                            </div>
                                                            <div class="nk-tb-col nk-tb-change">
                                                                <span class="tb-sub"><span><%= String.format("%.2f MYR", product.getPrice() * quantity)%></span></span>
                                                            </div>

                                                        </div><!-- .nk-tb-item -->
                                                        <%
                                                            }
                                                        %>
                                                    </div><!-- .nk-tb-list -->

                                                </div><!-- .card -->
                                            </div><!-- .col -->



                                        </div><!-- .row -->
                                    </div><!-- .nk-block -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- content @e -->
                    <%@ include file = "footer.jsp" %>
                </div>
                <!-- wrap @e -->
            </div>
            <!-- main @e -->
        </div>
        <!-- app-root @e -->
        <!-- JavaScript -->
        <script src="./assets/js/bundle.js?ver=3.1.0"></script>
        <script src="./assets/js/scripts.js?ver=3.1.0"></script>
        <script src="./assets/js/charts/chart-analytics.js?ver=3.1.0"></script>
        <script src="./assets/js/libs/jqvmap.js?ver=3.1.0"></script>
        <script>


                                                                $(document).ready(function () {
                                                                    // get current month and year
                                                                    var today = new Date();
                                                                    var currentMonth = today.getMonth();
                                                                    var currentYear = today.getFullYear();
                                                                    var month = new Date().toLocaleString('default', {month: 'short'});

                                                                    // get number of days in current month
                                                                    var daysInMonth = new Date(currentYear, currentMonth + 1, 0).getDate();

                                                                    // generate array of days
                                                                    var days = [];
                                                                    for (var i = 1; i <= daysInMonth; i++) {
                                                                        var day = ('0' + i).slice(-2); // add leading zero if necessary
                                                                        days.push(day + ' ' + month);
                                                                    }

                                                                    console.log(days);

                                                                    var analyticOvData = {
                                                                        labels: days,
                                                                        dataUnit: 'People',
                                                                        lineTension: .1,
                                                                        datasets: [{
                                                                                label: "Current Month",
                                                                                color: "#9d72ff",
                                                                                dash: 0,
                                                                                background: NioApp.hexRGB('#9d72ff', .15),
                                                                                data: [<%
                                                                                    for (Double payment : paymentsByDay) {
                                                                                        out.print(String.format("%.2f",payment) + ", ");
                                                                                    }
            %>
                                                                                ]
                                                                            }]
                                                                    };

                                                                    function analyticsLineLarge(selector, set_data) {
                                                                        var $selector = selector ? $(selector) : $('.sales-data');
                                                                        $selector.each(function () {
                                                                            var $self = $(this),
                                                                                    _self_id = $self.attr('id'),
                                                                                    _get_data = typeof set_data === 'undefined' ? eval(_self_id) : set_data;
                                                                            var selectCanvas = document.getElementById(_self_id).getContext("2d");
                                                                            var chart_data = [];
                                                                            for (var i = 0; i < _get_data.datasets.length; i++) {
                                                                                chart_data.push({
                                                                                    label: _get_data.datasets[i].label,
                                                                                    tension: _get_data.lineTension,
                                                                                    backgroundColor: _get_data.datasets[i].background,
                                                                                    borderWidth: 2,
                                                                                    borderDash: _get_data.datasets[i].dash,
                                                                                    borderColor: _get_data.datasets[i].color,
                                                                                    pointBorderColor: 'transparent',
                                                                                    pointBackgroundColor: 'transparent',
                                                                                    pointHoverBackgroundColor: "#fff",
                                                                                    pointHoverBorderColor: _get_data.datasets[i].color,
                                                                                    pointBorderWidth: 2,
                                                                                    pointHoverRadius: 4,
                                                                                    pointHoverBorderWidth: 2,
                                                                                    pointRadius: 4,
                                                                                    pointHitRadius: 4,
                                                                                    data: _get_data.datasets[i].data
                                                                                });
                                                                            }
                                                                            var chart = new Chart(selectCanvas, {
                                                                                type: 'line',
                                                                                data: {
                                                                                    labels: _get_data.labels,
                                                                                    datasets: chart_data
                                                                                },
                                                                                options: {
                                                                                    legend: {
                                                                                        display: _get_data.legend ? _get_data.legend : false,
                                                                                        rtl: NioApp.State.isRTL,
                                                                                        labels: {
                                                                                            boxWidth: 12,
                                                                                            padding: 20,
                                                                                            fontColor: '#6783b8'
                                                                                        }
                                                                                    },
                                                                                    maintainAspectRatio: false,
                                                                                    tooltips: {
                                                                                        enabled: true,
                                                                                        rtl: NioApp.State.isRTL,
                                                                                        callbacks: {
                                                                                            title: function title(tooltipItem, data) {
                                                                                                return data['labels'][tooltipItem[0]['index']];
                                                                                            },
                                                                                            label: function label(tooltipItem, data) {
                                                                                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']];
                                                                                            }
                                                                                        },
                                                                                        backgroundColor: '#1c2b46',
                                                                                        titleFontSize: 13,
                                                                                        titleFontColor: '#fff',
                                                                                        titleMarginBottom: 6,
                                                                                        bodyFontColor: '#fff',
                                                                                        bodyFontSize: 12,
                                                                                        bodySpacing: 4,
                                                                                        yPadding: 10,
                                                                                        xPadding: 10,
                                                                                        footerMarginTop: 0,
                                                                                        displayColors: false
                                                                                    },
                                                                                    scales: {
                                                                                        yAxes: [{
                                                                                                display: true,
                                                                                                position: NioApp.State.isRTL ? "right" : "left",
                                                                                                ticks: {
                                                                                                    beginAtZero: true,
                                                                                                    fontSize: 12,
                                                                                                    fontColor: '#9eaecf',
                                                                                                    padding: 8,
                                                                                                    stepSize: 2400
                                                                                                },
                                                                                                gridLines: {
                                                                                                    color: NioApp.hexRGB("#526484", .2),
                                                                                                    tickMarkLength: 0,
                                                                                                    zeroLineColor: NioApp.hexRGB("#526484", .2)
                                                                                                }
                                                                                            }],
                                                                                        xAxes: [{
                                                                                                display: false,
                                                                                                ticks: {
                                                                                                    fontSize: 12,
                                                                                                    fontColor: '#9eaecf',
                                                                                                    source: 'auto',
                                                                                                    padding: 0,
                                                                                                    reverse: NioApp.State.isRTL
                                                                                                },
                                                                                                gridLines: {
                                                                                                    color: "transparent",
                                                                                                    tickMarkLength: 0,
                                                                                                    zeroLineColor: 'transparent',
                                                                                                    offsetGridLines: true
                                                                                                }
                                                                                            }]
                                                                                    }
                                                                                }
                                                                            });
                                                                        });
                                                                    }

                                                                    analyticsLineLarge(".sales-data", analyticOvData);
                                                                });





        </script>
    </body>



</html>

<!--SQL CODE FOR AUTO INCREMENT ID
CREATE TABLE Product (product_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
product_name VARCHAR(140) NOT NULL,
product_price DOUBLE,
product_image BLOB);






fix list
1) product edit spinner
2) product edit success message
-->