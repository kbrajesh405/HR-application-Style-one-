package com.thinking.machines.hr.servlets;

import com.thinking.machines.hr.dl.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

public class EmployeesView extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
try
{
EmployeeDAO employeeDAO=new EmployeeDAO();
List<EmployeeDTO> list=employeeDAO.getAll();

PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");

pw.println("function Employees()");
pw.println("{");
pw.println("this.employeeId=\"\";");
pw.println("this.name=\"\";");
pw.println("this.designation=\"\";");
pw.println("this.dateOfBirth=\"\";");
pw.println("this.gender=\"\";");
pw.println("this.isIndian=true;");
pw.println("this.basicSalary=0;");
pw.println("this.panCardNumber=\"\";");
pw.println("this.aadharCardNumber=\"\";");
pw.println("}");
pw.println("");
pw.println("var employee=[];");
pw.println("var e=new Employees();");
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
int x=0;
for(EmployeeDTO lists:list)
{
pw.println("e=new Employees();");
pw.println("e.employeeId=\""+lists.getEmployeeId()+"\";");
pw.println("e.name=\""+lists.getName()+"\";");
pw.println("e.designation='"+lists.getDesignation()+"';");
pw.println("e.gender='"+lists.getGender()+"';");
pw.println("e.dateOfBirth='"+lists.getDateOfBirth()+"';");
pw.println("e.isIndian="+lists.getIsIndian()+";");
pw.println("e.basicSalary="+lists.getBasicSalary().toPlainString()+";");
pw.println("e.panCardNumber=\""+lists.getPanCardNumber()+"\";");
pw.println("e.aadharCardNumber=\""+lists.getAadharCardNumber()+"\";");
pw.println("employee["+x+"]=e;");
x++;
}

pw.println("var selectedRow=null;");

pw.println("function selectEmployee(row, employeesId)");
pw.println("{");
pw.println("if(row==selectedRow) return;");
pw.println("if(selectedRow!=null)");
pw.println("{");
pw.println("selectedRow.style.background='white';");
pw.println("selectedRow.style.color='black';");
pw.println("}");
pw.println("row.style.background=\"#7c7b7b\";");
pw.println("row.style.color='white';");
pw.println("selectedRow=row;");
pw.println("var i;");
pw.println("for(i=0; i<employee.length; i++)");
pw.println("{");
pw.println("if(employee[i].employeeId==employeesId)");
pw.println("{");
pw.println("break;");
pw.println("}");
pw.println("}");
pw.println("var emp=employee[i];");
pw.println("document.getElementById(\"_employeeId\").innerHTML=emp.employeeId;");
pw.println("document.getElementById(\"_name\").innerHTML=emp.name;");
pw.println("document.getElementById(\"_designation\").innerHTML=emp.designation;");
pw.println("document.getElementById(\"_dateOfBirth\").innerHTML=emp.dateOfBirth;");
pw.println("document.getElementById(\"_gender\").innerHTML=emp.gender;");
pw.println("document.getElementById(\"_isIndian\").innerHTML=emp.isIndian;");
pw.println("document.getElementById(\"_basicSalary\").innerHTML=emp.basicSalary;");
pw.println("document.getElementById(\"_panCardNumber\").innerHTML=emp.panCardNumber;");
pw.println("document.getElementById(\"_aadharCardNumber\").innerHTML=emp.aadharCardNumber;");
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
pw.println("<div style='height:73vh; width : auto; border:1px solid black; padding : 7px; float:left'>");
pw.println("<a href='/styleone/designationView'> Designations</a><br>");
pw.println("<b> Employees</b> <br><br>");
pw.println("<a href='/styleone/index.html' style='padding : 5px;'>Home</a>");
pw.println("</div><!--Left panel left here--->");
pw.println("<!--Right panel starts here--->");
pw.println("<div style='height:74.3vh; width:60hw; margin-left:105px; border:1px solid black'>");
pw.println("<h3>Employees</h3><br>");
pw.println("");
pw.println("<div style='height:40vh; width:100%; border:1px solid black; overflow:scroll;'>");
pw.println("");
pw.println("<table border='1' width='100%'>");
pw.println("<thead>");
pw.println("<tr>");
pw.println("<th colspan='6' style='text-align:right'> <a href='/styleone/getAddEmployeeForm'>Add Employee</a></th>");
pw.println("");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<th style='width:80px; text-align:center'>S.No</th>");
pw.println("<th style='width:200px; text-align:center'>Employee Id</th>");
pw.println("<th style='width:200px; text-align:center'>Name</th>");
pw.println("<th style='width:200px; text-align:center'>Designations</th>");
pw.println("<th style='width:80px; text-align:center'>Edit</th>");
pw.println("<th style='width:80px; text-align:center'>Delete</th>");
pw.println("");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");

int sno=1;
for(EmployeeDTO lists:list)
{
pw.println("<tr style='cursor:pointer' onclick='selectEmployee(this,\""+lists.getEmployeeId()+"\")'>");
pw.println("<td style='text-align:right;'>"+sno+".</td>");
pw.println("<td >"+lists.getEmployeeId()+"</td>");
pw.println("<td >"+lists.getName()+"</td>");
pw.println("<td >"+lists.getDesignation()+"</td>");
pw.println("<td style='text-align:center;'><a href='/styleone/editEmployees?employeeId=\""+lists.getEmployeeId()+"\"'>edit</a></td>");
pw.println("<td style='text-align:center;'><a href='/styleone/confirmDeleteEmployees?employeeId=\""+lists.getEmployeeId()+"\"'>delete</a></td>");
pw.println("</tr>");
pw.println("");
sno++;
}

pw.println("</tbody>");
pw.println("</table>");
pw.println("");
pw.println("</div >");
pw.println("");
pw.println("<div style='height:30vh; width:100%; border:1px solid white;'>");
pw.println("");
pw.println("<table >");
pw.println("<thead >");
pw.println("<tr style='background:gray; color:white;'>");
pw.println("<th>Details</th>");
pw.println("</tr>");
pw.println("</thead>");
pw.println("<tbody>");
pw.println("<tr>");
pw.println("<td style='width:450px; padding:5px;'>Employee Id : <span id='_employeeId'></span></td>");
pw.println("<td style='width:450px; padding:5px;'>Name : <span id='_name'></span></td>");
pw.println("<td style='width:450px; padding:5px;'>Designation : <span id='_designation'></span></td>");
pw.println("</tr>");
pw.println("<tr >");
pw.println("<td style='width:450px; padding:5px;'>Date of Birth : <span id='_dateOfBirth'></span></td>");
pw.println("<td style='width:450px; padding:5px;'>Gender : <span id='_gender'></span ></td>");
pw.println("<td style='width:450px; padding:5px;'>Basic Salary : <span id='_basicSalary'></span></td>");
pw.println("</tr>");
pw.println("<tr>");
pw.println("<td style='width:450px; padding:5px;'>Is Indian : <span id='_isIndian'></span></td>");
pw.println("<td style='width:450px; padding:5px;'>Pan Card Number : <span id='_panCardNumber'></span></td>");
pw.println("<td style='width:450px; padding:5px;'>Aadhar Card Number : <span id='_aadharCardNumber'></span></td>");
pw.println("</tr>");
pw.println("</tbody>");
pw.println("</table>");
pw.println("");
pw.println("</div>");
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
public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq, rs);
}

}