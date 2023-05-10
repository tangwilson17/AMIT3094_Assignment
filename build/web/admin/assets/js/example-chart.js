"use strict";

!function (NioApp, $) {
    "use strict";

    //////// for developer - barchart //////// 
    // Avilable options to pass from outside 
    // labels: array,
    // stacked: false - boolean,
    // legend: false - boolean,
    // dataUnit: string, (Used in tooltip or other section for display) 
    // datasets: [{label : string, color: string (color code with # or other format), data: array}]
    var barChartData = {
        labels: ["01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"],
        dataUnit: 'People',
        datasets: [{
            label: "join",
            color: "#b695ff",
            data: [110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 75, 90]
        }, {
            label: "join",
            color: "#b695ff",
            data: [110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95, 75, 90, 75, 90]
        }]
    };
    var barChartMultiple = {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dataUnit: 'USD',
        datasets: [{
            label: "Income",
            color: "#b695ff",
            data: [222, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95]
        }, {
            label: "Expense",
            color: "#f4aaa4",
            data: [222, 90, 110, 80, 125, 55, 95, 75, 90, 110, 80, 125]
        }]
    };
    var barChartStacked = {
        labels: ["Jan 1", "Jan 2", "Jan 3", "Jan 4", "Jan 5", "Jan 6", "Jan 7", "Jan 8", "Jan 9", "Jan 10", "Jan 11", "Jan 12", "Jan 13", "Jan 14", "Jan 15", "Jan 16", "Jan 17", "Jan 18", "Jan 19", "Jan 20", "Jan 21", "Jan 22", "Jan 23", "Jan 24", "Jan 25", "Jan 26", "Jan 27", "Jan 28", "Jan 29", "Jan 30"],
        stacked: true,
        dataUnit: 'MYR',
        datasets: [{
            label: "Product Placement",
            color: "#b695ff",
            data: [732, 500, 900, 600, 250, 850, 300, 720, 150, 800, 400, 200, 450, 650, 500, 800, 450, 600, 250, 800, 350, 500, 550, 300, 650, 200, 400, 700, 400, 600]
        }, {
            label: "Live Event",
            color: "#94c7e6",
            data: [500, 350, 700, 550, 450, 200, 650, 300, 550, 250, 600, 800, 450, 500, 650, 800, 150, 720, 300, 850, 250, 600, 400, 800, 400, 200, 700, 500, 600, 732]
        }, {
            label: "Coaching",
            color: "#f3cd49",
            data: [400, 650, 250, 700, 600, 500, 350, 500, 800, 200, 600, 400, 200, 400, 700, 250, 650, 300, 550, 250, 600, 400, 800, 400, 200, 700, 500, 600, 732, 500]
        }, {
            label: "Others",
            color: "#f9cad3",
            data: [650, 300, 550, 250, 600, 400, 800, 400, 200, 700, 500, 600, 732, 500, 350, 700, 550, 450, 200, 650, 300, 550, 250, 600, 800, 450, 500, 650, 800, 150]
        }]
    };

    function barChart(selector, set_data) {
        var $selector = selector ? $(selector) : $('.bar-chart');
        $selector.each(function () {
            var $self = $(this),
                _self_id = $self.attr('id'),
                _get_data = barChartStacked,
                _d_legend = typeof _get_data.legend === 'undefined' ? false : _get_data.legend;
            var selectCanvas = document.getElementById(_self_id).getContext("2d");
            var chart_data = [];
            for (var i = 0; i < _get_data.datasets.length; i++) {
                chart_data.push({
                    label: _get_data.datasets[i].label,
                    data: _get_data.datasets[i].data,
                    // Styles
                    backgroundColor: _get_data.datasets[i].color,
                    borderWidth: 2,
                    borderColor: 'transparent',
                    hoverBorderColor: 'transparent',
                    borderSkipped: 'bottom',
                    barPercentage: .6,
                    categoryPercentage: .7
                });
            }
            var chart = new Chart(selectCanvas, {
                type: 'bar',
                data: {
                    labels: _get_data.labels,
                    datasets: chart_data
                },
                options: {
                    legend: {
                        display: _get_data.legend ? _get_data.legend : false,
                        rtl: NioApp.State.isRTL,
                        labels: {
                            boxWidth: 30,
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
                                return data.datasets[tooltipItem[0].datasetIndex].label;
                            },
                            label: function label(tooltipItem, data) {
                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']] + ' ' + _get_data.dataUnit;
                            }
                        },
                        backgroundColor: '#eff6ff',
                        titleFontSize: 13,
                        titleFontColor: '#6783b8',
                        titleMarginBottom: 6,
                        bodyFontColor: '#9eaecf',
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
                            stacked: _get_data.stacked ? _get_data.stacked : false,
                            position: NioApp.State.isRTL ? "right" : "left",
                            ticks: {
                                beginAtZero: true,
                                fontSize: 12,
                                fontColor: '#9eaecf'
                            },
                            gridLines: {
                                color: NioApp.hexRGB("#526484", .2),
                                tickMarkLength: 0,
                                zeroLineColor: NioApp.hexRGB("#526484", .2)
                            }
                        }],
                        xAxes: [{
                            display: true,
                            stacked: _get_data.stacked ? _get_data.stacked : false,
                            ticks: {
                                fontSize: 12,
                                fontColor: '#9eaecf',
                                source: 'auto',
                                reverse: NioApp.State.isRTL
                            },
                            gridLines: {
                                color: "transparent",
                                tickMarkLength: 10,
                                zeroLineColor: 'transparent'
                            }
                        }]
                    }
                }
            });
        });
    }
    // init bar chart
    barChart();

    //////// for developer - linechart //////// 
    // Avilable options to pass from outside 
    // labels: array,
    // legend: false - boolean,
    // dataUnit: string, (Used in tooltip or other section for display) 
    // datasets: [{label : string, color: string (color code with # or other format), data: array}]
    var solidLineChart = {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dataUnit: 'BTC',
        lineTension: .4,
        legend: true,
        datasets: [{
            label: "Total Received",
            color: "#5ce0aa",
            background: 'transparent',
            data: [110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95]
        }, {
            label: "Total Send",
            color: "#9d72ff",
            background: 'transparent',
            data: [80, 54, 105, 120, 82, 85, 60, 80, 54, 105, 120, 82]
        }]
    };
    var filledLineChart = {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dataUnit: 'BTC',
        lineTension: .4,
        datasets: [{
            label: "Total Received",
            color: "#9d72ff",
            background: NioApp.hexRGB('#9d72ff', .4),
            data: [110, 80, 125, 65, 95, 75, 90, 110, 80, 125, 70, 95]
        }]
    };
    var straightLineChart = {
        labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        dataUnit: 'BTC',
        lineTension: 0,
        datasets: [{
            label: "Total Received",
            color: "#9d72ff",
            background: NioApp.hexRGB('#9d72ff', .3),
            data: [110, 80, 125, 55, 95, 75, 90, 110, 80, 125, 55, 95]
        }]
    };
    function lineChart(selector, set_data) {
        var $selector = selector ? $(selector) : $('.line-chart');
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
                    borderColor: _get_data.datasets[i].color,
                    pointBorderColor: _get_data.datasets[i].color,
                    pointBackgroundColor: '#fff',
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
                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']] + ' ' + _get_data.dataUnit;
                            }
                        },
                        backgroundColor: '#eff6ff',
                        titleFontSize: 13,
                        titleFontColor: '#6783b8',
                        titleMarginBottom: 6,
                        bodyFontColor: '#9eaecf',
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
                                beginAtZero: false,
                                fontSize: 12,
                                fontColor: '#9eaecf',
                                padding: 10
                            },
                            gridLines: {
                                color: NioApp.hexRGB("#526484", .2),
                                tickMarkLength: 0,
                                zeroLineColor: NioApp.hexRGB("#526484", .2)
                            }
                        }],
                        xAxes: [{
                            display: true,
                            ticks: {
                                fontSize: 12,
                                fontColor: '#9eaecf',
                                source: 'auto',
                                padding: 5,
                                reverse: NioApp.State.isRTL
                            },
                            gridLines: {
                                color: "transparent",
                                tickMarkLength: 10,
                                zeroLineColor: NioApp.hexRGB("#526484", .2),
                                offsetGridLines: true
                            }
                        }]
                    }
                }
            });
        });
    }

    // init line chart
    lineChart();

    //////// for developer - pieChart //////// 
    // Avilable options to pass from outside 
    // labels: array,
    // legend: false - boolean,
    // dataUnit: string, (Used in tooltip or other section for display) 
    // datasets: [{label : string, color: string (color code with # or other format), data: array}]
    var pieChartData = {
        labels: ["Send", "Receive", "Withdraw"],
        dataUnit: 'BTC',
        legend: false,
        datasets: [{
            borderColor: "#fff",
            background: ["#b695ff", "#f4aaa4", "#8feac5"],
            data: [110, 80, 125]
        }]
    };
    function pieChart(selector, set_data) {
        var $selector = selector ? $(selector) : $('.pie-chart');
        $selector.each(function () {
            var $self = $(this),
                _self_id = $self.attr('id'),
                _get_data = typeof set_data === 'undefined' ? eval(_self_id) : set_data;
            var selectCanvas = document.getElementById(_self_id).getContext("2d");
            var chart_data = [];
            for (var i = 0; i < _get_data.datasets.length; i++) {
                chart_data.push({
                    backgroundColor: _get_data.datasets[i].background,
                    borderWidth: 2,
                    borderColor: _get_data.datasets[i].borderColor,
                    hoverBorderColor: _get_data.datasets[i].borderColor,
                    data: _get_data.datasets[i].data
                });
            }
            var chart = new Chart(selectCanvas, {
                type: 'pie',
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
                    rotation: -.2,
                    maintainAspectRatio: false,
                    tooltips: {
                        enabled: true,
                        rtl: NioApp.State.isRTL,
                        callbacks: {
                            title: function title(tooltipItem, data) {
                                return data['labels'][tooltipItem[0]['index']];
                            },
                            label: function label(tooltipItem, data) {
                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']] + ' ' + _get_data.dataUnit;
                            }
                        },
                        backgroundColor: '#eff6ff',
                        titleFontSize: 13,
                        titleFontColor: '#6783b8',
                        titleMarginBottom: 6,
                        bodyFontColor: '#9eaecf',
                        bodyFontSize: 12,
                        bodySpacing: 4,
                        yPadding: 10,
                        xPadding: 10,
                        footerMarginTop: 0,
                        displayColors: false
                    }
                }
            });
        });
    }

    // init pie chart
    pieChart();
    var doughnutChartData = {
        labels: ["Send", "Receive", "Withdraw"],
        dataUnit: 'BTC',
        legend: false,
        datasets: [{
            borderColor: "#fff",
            background: ["#b695ff", "#f4aaa4", "#8feac5"],
            data: [110, 80, 125]
        }]
    };
    function doughnutChart(selector, set_data) {
        var $selector = selector ? $(selector) : $('.doughnut-chart');
        $selector.each(function () {
            var $self = $(this),
                _self_id = $self.attr('id'),
                _get_data = typeof set_data === 'undefined' ? eval(_self_id) : set_data;
            var selectCanvas = document.getElementById(_self_id).getContext("2d");
            var chart_data = [];
            for (var i = 0; i < _get_data.datasets.length; i++) {
                chart_data.push({
                    backgroundColor: _get_data.datasets[i].background,
                    borderWidth: 2,
                    borderColor: _get_data.datasets[i].borderColor,
                    hoverBorderColor: _get_data.datasets[i].borderColor,
                    data: _get_data.datasets[i].data
                });
            }
            var chart = new Chart(selectCanvas, {
                type: 'doughnut',
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
                    rotation: 1,
                    cutoutPercentage: 40,
                    maintainAspectRatio: false,
                    tooltips: {
                        enabled: true,
                        rtl: NioApp.State.isRTL,
                        callbacks: {
                            title: function title(tooltipItem, data) {
                                return data['labels'][tooltipItem[0]['index']];
                            },
                            label: function label(tooltipItem, data) {
                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']] + ' ' + _get_data.dataUnit;
                            }
                        },
                        backgroundColor: '#eff6ff',
                        titleFontSize: 13,
                        titleFontColor: '#6783b8',
                        titleMarginBottom: 6,
                        bodyFontColor: '#9eaecf',
                        bodyFontSize: 12,
                        bodySpacing: 4,
                        yPadding: 10,
                        xPadding: 10,
                        footerMarginTop: 0,
                        displayColors: false
                    }
                }
            });
        });
    }

    // init doughnut chart
    doughnutChart();
    var polarChartData = {
        labels: ["Send", "Receive", "Withdraw"],
        dataUnit: 'BTC',
        legend: false,
        datasets: [{
            borderColor: "#fff",
            background: [NioApp.hexRGB("#b695ff", .8), NioApp.hexRGB("#f4aaa4", .8), NioApp.hexRGB("#8feac5", .8)],
            data: [110, 80, 125]
        }]
    };
    function polarAreaChart(selector, set_data) {
        var $selector = selector ? $(selector) : $('.polar-chart');
        $selector.each(function () {
            var $self = $(this),
                _self_id = $self.attr('id'),
                _get_data = typeof set_data === 'undefined' ? eval(_self_id) : set_data;
            var selectCanvas = document.getElementById(_self_id).getContext("2d");
            var chart_data = [];
            for (var i = 0; i < _get_data.datasets.length; i++) {
                chart_data.push({
                    backgroundColor: _get_data.datasets[i].background,
                    borderWidth: 2,
                    borderColor: _get_data.datasets[i].borderColor,
                    hoverBorderColor: _get_data.datasets[i].borderColor,
                    data: _get_data.datasets[i].data
                });
            }
            var chart = new Chart(selectCanvas, {
                type: 'polarArea',
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
                                return data.datasets[tooltipItem.datasetIndex]['data'][tooltipItem['index']] + ' ' + _get_data.dataUnit;
                            }
                        },
                        backgroundColor: '#eff6ff',
                        titleFontSize: 13,
                        titleFontColor: '#6783b8',
                        titleMarginBottom: 6,
                        bodyFontColor: '#9eaecf',
                        bodyFontSize: 12,
                        bodySpacing: 4,
                        yPadding: 10,
                        xPadding: 10,
                        footerMarginTop: 0,
                        displayColors: false
                    }
                }
            });
        });
    }

    // init line chart
    polarAreaChart();
}(NioApp, jQuery);