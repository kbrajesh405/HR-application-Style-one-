package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.math.*;

public class DeleteEmployee extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs){

try{
String id=rq.getParameter("employeeId");
int employeeId=0;
try
{
employeeId=Integer.parseInt(id.substring(1));
}catch(NumberFormatException nfe)
{
System.out.println(nfe);
}
EmployeeDAO employeeDAO=new EmployeeDAO();
employeeDAO.delete(employeeId);

PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
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
pw.println("<b  style='padding : 5px'> Employees</b><br><br>");
pw.println("<a href='/styleone/index.html' style='padding :5px'>Home</a>");
pw.println("");
pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h2>Notification*</h2>");
pw.println("<form action='/styleone/employeesView' >");
pw.println("Record deleted successfully");
pw.println("<button type='submit'>ok</button>");
pw.println("</form>");
pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("	<center style='margin-top:18px;'>&#169; Thinking Machines</center>");
pw.println("");
pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");
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
