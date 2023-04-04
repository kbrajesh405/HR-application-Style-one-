package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class EditDesignation extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
try
{
int code = 0;
try
{
code = Integer.parseInt(rq.getParameter("code"));

}catch(NumberFormatException nfe)
{
sendBackView(rs);
return;
}
DesignationDAO designationDAO=new DesignationDAO();
try
{
DesignationDTO designation=designationDAO.getByCode(code);
PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

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
pw.println("function cancelEditing()");
pw.println("{");
pw.println("document.getElementById('cancelEditingForm').submit();");
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
pw.println("<b > Designations</b><br>");
pw.println("<a href ='/styleone/employeesView' style='padding : 5px'> Employees</a><br><br>");
pw.println("<a href='/styleone/index.html'>Home</a>");
pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Edit Designation Module</h3><br>");
pw.println("<form action='/styleone/updateDesignation' onsubmit='return validateForm(this)'>");
pw.println("Designation");
pw.println("<input type='hidden' name='code' id='code' value='"+code+"'>");
pw.println("<input method='post' type='text' id='title' name='title' maxlength='35' value='"+designation.getTitle()+"'>");
pw.println("<span id='titleErrorSection' style='color:red'></span><br>");
pw.println("<button type='submit'>Update</button>");
pw.println("<button type='button' onclick='cancelEditing()'> cancel</button>");
pw.println("</form>");
pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("	<center style='margin-top:18px;'>&#169; Thinking Machines</center>");

pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");

pw.println("<form action='/styleone/designationView' id='cancelEditingForm'>");
pw.println("</form>");
pw.println("</body>");
pw.println("</html>");


}catch(DAOException dao)
{
sendBackView(rs);
return;
}
}catch(Exception e)
{
System.out.println(e);
}

}
public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq, rs);
}
private void sendBackView(HttpServletResponse rs)
{
try
{
DesignationDAO designationDAO=new DesignationDAO();

List <DesignationDTO> designations;
designations=designationDAO.getAll();
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

pw.println("<!--header starts here-->");
pw.println("<div style='width:90hw; height : auto;  border: 1px solid white; padding : 5pt'>");
pw.println("<img src='/styleone/images/logo.jpg' style='padding : 5px; float:left;'><div style='font-size:20pt; margin-top:12px; margin-bottom:12px'>Thinking Machines</div></img>");

pw.println("</div> <!--header ends here-->");
pw.println("<!--Content container starts here-->");
pw.println("<div style='width : 90hw; height:75vh; border:1px solid white; padding : 5px'>");
pw.println("<!--Left panel starts here--->");
pw.println("<div style='height:73vh; width : auto; border:1px solid black; padding : 7px; float:left'>");
pw.println("<b> Designations</b><br>");
pw.println("<a href='/styleone/employeesView' style='padding : 5px'> Employees</a> <br><br>");
pw.println("<a href='/styleone/index.html' style='padding : 5px;'>Home</a>");
pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:75vh; width:60hw; overflow:scroll; margin-left:105px; border:1px solid black'>");
pw.println("<h2>Designations</h2><br>");
pw.println("<table border='1'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='4' style='text-align:right'> <a href='/styleone/AddDesignation.html'>Add New Designation</a></th>");

pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:80px; text-align:center'>S.No</th>");
pw.println("<th style='width:200px; text-align:center'>Designations</th>");
pw.println("<th style='width:80px; text-align:center'>Edit</th>");
pw.println("<th style='width:80px; text-align:center'>Delete</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
DesignationDTO designationDTO;
int x;
int sno=0;
int code;
String title;
for(x=0; x<designations.size(); x++)
{
sno++;
designationDTO = designations.get(x);
code=designationDTO.getCode();
title=designationDTO.getTitle();

pw.println("<tr>");
pw.println("<td style='text-align:right;'>"+sno+".</td>");
pw.println("<td >"+title+"</td>");
pw.println("<td style='text-align:center;'> <a href='/styleone/editDesignation?code="+code+"'>edit</a></td>");
pw.println("<td style='text-align:center;'><a href='/styleone/deleteDesignation?code="+code+"'>delete</a></td>");
pw.println("<tr>");
}
pw.println("</tbody>");
pw.println("</table>");

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
System.out.println(e.getMessage());
}


}

}