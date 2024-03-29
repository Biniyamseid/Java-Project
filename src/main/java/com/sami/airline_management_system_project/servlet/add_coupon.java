package com.sami.airline_management_system_project.servlet;

import com.sami.airline_management_system_project.db.DataBaseConnector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/add_coupon")
public class add_coupon extends HttpServlet {
    private static final long serialVersionUID = 1L;
     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("add coupon");
         response.setContentType("text/html");
         try {
             int count=0;
             Connection connection = DataBaseConnector.getConnection();
             System.out.println("connected!.....");
             String coupon_name = request.getParameter("cname");
             String discountpercentage = request.getParameter("discountpercentage");
             HttpSession session = request.getSession();
             session.setAttribute("cname", coupon_name);

             Statement st=connection.createStatement();
             ResultSet rs=st.executeQuery("SELECT * FROM coupon_table WHERE coupon_name='"+coupon_name+"'");
             while(rs.next()){
                 count++;
             }
             if(count>0){
                 RequestDispatcher view = request.getRequestDispatcher("coupon_add_failed");
                 view.forward(request, response);
                 System.out.print("Record NOt Inserted");
             }
             else{
                 int i=st.executeUpdate("INSERT INTO coupon_table (coupon_name, discountpercentage) values('" + coupon_name + "','" + discountpercentage + "')");
                 RequestDispatcher view = request.getRequestDispatcher("coupon_add_success");
                 view.forward(request, response);
                 System.out.print("Record Inserted");
             }
         }
         catch(IOException | SQLException | ServletException e){
             System.out.print(e);
         }

     }

}
