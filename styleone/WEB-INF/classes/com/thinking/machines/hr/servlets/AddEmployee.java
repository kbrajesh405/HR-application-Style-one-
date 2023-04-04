package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;
import java.util.*;
import java.text.*;

public class AddEmployee extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
try{
PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

String isIndian=rq.getParameter("isIndian");
if(isIndian==null) isIndian="N";
BigDecimal basicSalary=new BigDecimal(rq.getParameter("basicSalary"));

EmployeeDTO employee=new EmployeeDTO();
employee.setName(rq.getParameter("name"));
employee.setDesignationCode(Integer.parseInt(rq.getParameter("designationCode")));
employee.setDateOfBirth(rq.getParameter("dateOfBirth"));
employee.setGender(rq.getParameter("gender"));
if(isIndian.equals("Y")) 
employee.setIsIndian(true);
else employee.setIsIndian(false);
employee.setBasicSalary(basicSalary);
employee.setPanCardNumber(rq.getParameter("panCardNumber"));
employee.setAadharCardNumber(rq.getParameter("aadharCardNumber"));

EmployeeDAO employeeDAO=new EmployeeDAO();
employeeDAO.add(employee);

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--Main Container starts here-->");
pw.println("<div style='width:90hw; height:95vh; border: 1px solid black'>");

pw.println("<!--header starts here-->");
pw.println("<div style='width:90hw; height : auto;  border: 1px solid white; padding : 5pt'>");
pw.println("<img src='/styleone/images/logo.jpg' style='padding : 5px; float:left;'><div style='font-size:20pt; margin-top:12px; margin-bottom:12px'>Thinking Machines</div></img>");

pw.println("</div> <!--header ends here-->");
pw.println("<!--Content container starts here-->");
pw.println("<div style='width : 90hw; height:75vh; border:1px solid white; padding : 5px'>");
pw.println("<!--Left panel starts here--->");
pw.println("<div style='height:73vh; width : auto; border:1px solid black; padding : 5px; float:left'>");
pw.println("<a href='/styleone/designationView'> Designations</a><br>");
pw.println("<a href='/styleone/employeesView' style='padding : 5px'> Employees</a> <br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");

pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Notification*</h3>");
pw.println("Employee Added<br><br>");
pw.println("<h4>Do you want to add more employees?<h4><br>");

pw.println("<form action='/styleone/getAddEmployeeForm' style='float:left;'>");
pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");

pw.println("<form action='/styleone/employeesView'>");
pw.println("<button type='submit'>Nopes</button>");
pw.println("</form>");

pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("<center style='margin-top:18px;'>&#169; Thinking Machines</center>");

pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");
pw.println("</body>");
pw.println("</html>");
}catch(DAOException dao)
{
System.out.println(dao.getMessage());
}
catch(Exception e)
{
System.out.println(e);
}

}
public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq, rs);
}

}