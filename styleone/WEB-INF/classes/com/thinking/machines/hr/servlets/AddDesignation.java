package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddDesignation extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
PrintWriter pw=null;
String title=null;
try
{
pw=rs.getWriter();
rs.setContentType("text/html");
title=rq.getParameter("title");
DesignationDTO designation=new DesignationDTO();
designation.setTitle(title);

DesignationDAO designationDAO;
designationDAO=new DesignationDAO();
designationDAO.add(designation);

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
pw.println("<a href='/styleone/designationView'>Home</a>");

pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Notification*</h3>");
pw.println("Designation Added<br><br>");
pw.println("<h4>Do you want to add more designations<h4><br>");

pw.println("<form action='/styleone/AddDesignation.html' style='float:left;'>");
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

}catch(DAOException daoException)
{

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("function validateForm(frm)");
pw.println("{");
pw.println("var title=frm.title.value.trim();");
pw.println("var titleErrorSection=document.getElementById('titleErrorSection');");
pw.println("titleErrorSection.innerHTML='';");
pw.println("if(title.length==0)");
pw.println("{");
pw.println("titleErrorSection.innerHTML='required';");
pw.println("frm.title.focus();");
pw.println("return false;");
pw.println("}");
pw.println("return true;");
pw.println("}");
pw.println("function cancelAddition(){");
pw.println("documnet.getElementById('cancelEditingForm').submit();");
pw.println("}");

pw.println("</script>");
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
pw.println("<a href ='/styleone/designationView' style='padding : 5px'> Designations</a><br>");
pw.println("<a href ='/styleone/employeesView' style='padding : 5px'> Employees</a>");

pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Add Designation Module</h3><br>");
pw.println("<div style='color:red'>"+daoException.getMessage()+"</div>");

pw.println("<form action='/styleone/addDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation");
pw.println("<input type='text' id='title' name='title' maxlength='35' value='"+title+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>Save</button>");
pw.println("<button type='button' onclick='cancelAddition'>cancel</button>");
pw.println("</form>");
pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("<center style='margin-top:18px;'>&#169; Thinking Machines</center>");

pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");
pw.println("<form action='/styleone/designationView' id='cancelAdditionForm'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");
}
catch(Exception e)
{
System.out.println(e);
}

}
public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq,rs);
}

}