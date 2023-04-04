package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ConfirmDeleteDesignation extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
int code=0;
String title="";
PrintWriter pw=null;
try
{
try
{
code=Integer.parseInt(rq.getParameter("code"));
}catch(NumberFormatException nfe)
{
// alot to do
}
DesignationDTO designation=new DesignationDTO();
DesignationDAO designationDAO=new DesignationDAO();
designation=designationDAO.getByCode(code);
title=designation.getTitle();
pw=rs.getWriter();
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

pw.println("<!--header starts here-->");
pw.println("<div style='width:90hw; height : auto;  border: 1px solid white; padding : 5pt'>");
pw.println("<img src='/styleone/images/logo.jpg' style='padding : 5px; float:left;'><div style='font-size:20pt; margin-top:12px; margin-bottom:12px'>Thinking Machines</div></img>");

pw.println("</div> <!--header ends here-->");
pw.println("<!--Content container starts here-->");
pw.println("<div style='width : 90hw; height:75vh; border:1px solid white; padding : 5px'>");
pw.println("<!--Left panel starts here--->");
pw.println("<div style='height:73vh; width : auto; border:1px solid black; padding : 5px; float:left'>");
pw.println("<b> Designations</b><br>");
pw.println("<a href ='/styleone/employeesView' style='padding : 5px'> Employees</a> <br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");

pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Notification*</h3>");
pw.println("<p>Designation : "+title+"</p><br><br>");
pw.println("<h4>Are you sure, want to delete?<h4><br>");

pw.println("<form action='/styleone/deleteDesignation' style='float:left;'>");
pw.println("<input type='hidden' name='code' id='code' value='"+code+"'>");
pw.println("<input type='hidden' name='title' id='title' value='"+title+"'>");

pw.println("<button type='submit'>Yes</button>");
pw.println("</form>");

pw.println("<form action='/styleone/designationView'>");
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


}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq, rs);
}

}