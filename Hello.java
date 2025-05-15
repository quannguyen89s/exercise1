/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Hello", urlPatterns={"/Hello"})
public class Hello extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Hello</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Hello at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        //lấy ra
        String number1_raw = request.getParameter("num1");
        String number2_raw = request.getParameter("num2");
        //Xử lí
        try{
            int number1 = Integer.parseInt(number1_raw);
            int number2 = Integer.parseInt(number2_raw);
            int total = number1 + number2;
            //in ra 
            pw.println(total);
        }catch(Exception e){
            e.printStackTrace();
            pw.println("Nhap du kieu kieu chu so");
        }   
    } */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        //lấy ra
        String number1_raw = request.getParameter("num1");
        String number2_raw = request.getParameter("num2");
        String operator = request.getParameter("operator");
        
        //Xử lí  
        try{
            int number1 = Integer.parseInt(number1_raw);
            int number2 = Integer.parseInt(number2_raw);
            int result = 0;
            String err = "Mẫu số không được là số 0";
            switch(operator){
                case "+":
                    result = number1 + number2;
                    request.setAttribute("toys", String.valueOf(result));  //đóng gói món đồ
                    break;
                case "-":
                    result = number1 - number2;
                    request.setAttribute("toys", String.valueOf(result));  //đóng gói món đồ
                    break;
                case "*":
                    result = number1 * number2;
                    request.setAttribute("toys", String.valueOf(result));  //đóng gói món đồ
                    break;
                case "/":
                    if(number2 != 0){
                        result = number1 / number2;
                        request.setAttribute("toys", String.valueOf(result));  //đóng gói món đồ
                    }else{
                        request.setAttribute("msg", err);
                    }
                    break;
            } 
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            pw.println("Nhập kiểu dữ liệu chữ số");
        }   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }


}