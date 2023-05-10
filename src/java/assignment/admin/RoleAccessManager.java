/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment.admin;

import entity.Staff;
import java.util.Objects;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LocalMachine
 */
public class RoleAccessManager {

    public static boolean AllowManagerOnly(HttpSession session) {
        try {
            Staff staff = (Staff) session.getAttribute("staff");
            if (staff.getRole() != 0) {
                System.out.println("Rejected");
                return true;
            }
        } catch (Exception e) { 
            return true;
        }
        return false;
    }

    public static boolean AllowManagerAndSameStaffOnly(Staff staff, HttpSession session) {
        try {
            Staff loggedStaff = (Staff) session.getAttribute("staff");
            if (loggedStaff.getRole() != 0 && !Objects.equals(loggedStaff.getStaffId(), staff.getStaffId())) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
