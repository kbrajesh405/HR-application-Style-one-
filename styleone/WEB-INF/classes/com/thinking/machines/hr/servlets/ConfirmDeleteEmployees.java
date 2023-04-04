package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;

public class ConfirmDeleteEmployees extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs){

try{

EmployeeDAO employeeDAO=new EmployeeDAO();
EmployeeDTO employeeDTO=employeeDAO.getByEmployeeId(rq.getParameter("employeeId"));
String employeeId=employeeDTO.getEmployeeId();
System.out.println(employeeId);
String name=employeeDTO.getName();
String designation=employeeDTO.getDesignation();
String dateOfBirth=employeeDTO.getDateOfBirth();
String gender=employeeDTO.getGender();
boolean isIndian=employeeDTO.getIsIndian();
BigDecimal basicSalary=employeeDTO.getBasicSalary();
String panCardNumber=employeeDTO.getPanCardNumber();
String aadharCardNumber=employeeDTO.getAadharCardNumber();


PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function cancelDeletion()");
pw.println("{");
pw.println("document.getElementById('cancelDeletionForm').submit();");
pw.println("}");
pw.println("</script>");
pw.println("</head>");
pw.println("<body>");
pw.println("<!--Main Container starts here-->");
pw.println("<div style='width:90hw; height:95vh; border: 1px solid black'>");
pw.println("");
pw.println("<!--header starts here-->");
pw.println("<div style='width:90hw; height : auto;  border: 1px solid white; padding : 5pt'>");
pw.println("<img src='/styleone/images/logo.jpg' style='padding : 5px; float:left;'><div style='font-size:20pt; margin-top:12px; margin-bottom:12px'>Thinking Machines</div></img>");
pw.println("");
pw.println("</div> <!--header ends here-->");
pw.println("<!--Content container starts here-->");
pw.println("<div style='width : 90hw; height:75vh; border:1px solid white; padding : 5px'>");
pw.println("<!--Left panel starts here--->");
pw.println("<div style='height:73vh; width : auto; border:1px solid black; padding : 5px; float:left'>");
pw.println("<a href ='/styleone/designationView' style='padding : 5px'> Designations</a><br>");
pw.println("<b style='padding : 5px'> Employees</b><br><br>");
pw.println("<a href='/styleone/index.html' style='padding : 5px;'>Home </a>");
pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h2>Notification*</h2><br><br>");



pw.println("<form action='/styleone/deleteEmployee'>");
pw.println("Employee Id : <span><b>"+rq.getParameter("employeeId")+"</b></span><br>");
pw.println("<input type='hidden' name='employeeId' id='employeeId' value='"+employeeId+"'>");
pw.println("Name : <span><b>"+name+"</b></span><br>");
pw.println("Designation : <span><b>"+designation+"</b></span><br>");
pw.println("Date of Birth : <span><b>"+dateOfBirth+"</b></span><br>");

pw.println("Gender : ");
if(gender.equals("M"))
pw.println("<span><b>Male</b></span><br>");
else
pw.println("<span><b>Female</b></span><br>");
pw.println("Is Indian : ");
if(isIndian) 
pw.println("<span><b>indian</b></span><br>");
else
pw.println("<span><b>Not an indian</b></span><br>");
pw.println("PAN Card number : <span><b>"+panCardNumber+"</b></span><br>");
pw.println("Aadhar Card Number : <span><b>"+aadharCardNumber+"</b></span><br>");
pw.println("<h3>Are you sure want to delete this employee?</h3><br><br>");
pw.println("<button type='submit'>Yes</button> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
pw.println("<button type='button' onclick='cancelDeletion()'>Nopes</button>");
pw.println("</form>");
pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("	<center style='margin-top:18px;'>&#169; Thinking Machines</center>");
pw.println("");
pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");
pw.println("<form id='cancelDeletionForm' action='/styleone/employeesView'>");

pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest rq, HttpServletResponse rs){
doGet(rq, rs);
}

}
