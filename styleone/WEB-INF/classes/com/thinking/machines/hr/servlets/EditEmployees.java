package com.thinking.machines.hr.servlets;

import java.io.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java .util.*;
import java.math.*;

public class EditEmployees extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
String s = rq.getParameter("employeeId");
try{
EmployeeDAO employeeDAO = new EmployeeDAO();
EmployeeDTO employeeDTO = new EmployeeDTO();
employeeDTO=employeeDAO.getByEmployeeId(s);
String name = employeeDTO.getName();
String designation = employeeDTO.getDesignation();
String dateOfBirth = employeeDTO.getDateOfBirth();
String gender =employeeDTO.getGender();
boolean isIndian = employeeDTO.getIsIndian();
BigDecimal basicSalary=employeeDTO.getBasicSalary();
String panCardNumber = employeeDTO.getPanCardNumber();
String aadharCardNumber = employeeDTO.getAadharCardNumber();

PrintWriter pw=rs.getWriter();
rs.setContentType("text/html");

pw.println("<!DOCTYPE html>");
pw.println("<html lang='en'>");
pw.println("<head>");
pw.println("<meta charset='utf-8'>");
pw.println("<title>HR application</title>");
pw.println("<script>");
pw.println("");
pw.println("function formValidation(frm)");
pw.println("{");
pw.println("var valid=true;");
pw.println("var firstInvalidComponent=null;");
pw.println("var name=frm.name.value.trim();");
pw.println("var nameErrorSection=document.getElementById('nameErrorSection');");
pw.println("nameErrorSection.innerHTML=\"\";");
pw.println("if(name.length==0)");
pw.println("{");
pw.println("nameErrorSection.innerHTML='Name required';");
pw.println("valid=false;");
pw.println("firstInvalidComponent=frm.name;");
pw.println("}");
pw.println("");
pw.println("var designation=frm.designationCode.value.trim();");
pw.println("var designationCodeErrorSection=document.getElementById('designationCodeErrorSection');");
pw.println("designationCodeErrorSection.innerHTML=\"\";");
pw.println("if(designation==-1)");
pw.println("{");
pw.println("designationCodeErrorSection.innerHTML='Select Designation';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null) firstInvalidComponent=frm.designationCode;");
pw.println("}");
pw.println("");
pw.println("var dateOfBirth=frm.dateOfBirth.value.trim();");
pw.println("var dateOfBirthErrorSection=document.getElementById('dateOfBirthErrorSection');");
pw.println("dateOfBirthErrorSection.innerHTML=\"\";");
pw.println("if(dateOfBirth.length==0)");
pw.println("{");
pw.println("dateOfBirthErrorSection.innerHTML='Date of Birth required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent=null) firstInvalidComponent=frm.dateOfBirth;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("var genderErrorSection=document.getElementById('genderErrorSection');");
pw.println("genderErrorSection.innerHTML=\"\";");
pw.println("if(frm.gender[0].checked==false && frm.gender[1].checked==false)");
pw.println("{");
pw.println("genderErrorSection.innerHTML='Select Gender';");
pw.println("valid=false;");
pw.println("}");
pw.println("");
pw.println("var basicSalary=frm.basicSalary.value.trim();");
pw.println("var basicSalaryErrorSection=document.getElementById('basicSalaryErrorSection');");
pw.println("basicSalaryErrorSection.innerHTML=\"\";");
pw.println("if(basicSalary.length==0)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Basic Salary required';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("else");
pw.println("{");
pw.println("var bb='0123456789.';");
pw.println("var e=0;");
pw.println("var i;");
pw.println("var isBasicSalaryValid=true;");
pw.println("while(e<basicSalary.length)");
pw.println("{");
pw.println("if(bb.indexOf(basicSalary.charAt(e))==-1)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid Basic Salary';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("e++;");
pw.println("}");
pw.println("if(isBasicSalaryValid)");
pw.println("{");
pw.println("var dot=basicSalary.indexOf(\".\");");
pw.println("if(dot!=-1)");
pw.println("{");
pw.println("var numberOfFractions=basicSalary.length-(dot+1);");
pw.println("if(numberOfFractions>2)");
pw.println("{");
pw.println("basicSalaryErrorSection.innerHTML='Invalid Basic Salary';");
pw.println("valid=false;");
pw.println("if(firstInvalidComponent==null)firstInvalidComponent=frm.basicSalary;");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("}");
pw.println("");
pw.println("var panCardNumber=frm.panCardNumber.value.trim();");
pw.println("var panCardNumberErrorSection=document.getElementById('panCardNumberErrorSection');");
pw.println("panCardNumberErrorSection.innerHTML=\"\";");
pw.println("if(panCardNumber.length==0)");
pw.println("{");
pw.println("panCardNumberErrorSection.innerHTML='PANN card number required';");
pw.println("valid=false;");
pw.println("firstInvalidComponent=frm.panCardNumber;");
pw.println("}");
pw.println("");
pw.println("var aadharCardNumber=frm.aadharCardNumber.value.trim();");
pw.println("var aadharCardNumberErrorSection=document.getElementById('aadharCardNumberErrorSection');");
pw.println("aadharCardNumberErrorSection.innerHTML=\"\";");
pw.println("if(aadharCardNumber.length==0)");
pw.println("{");
pw.println("aadharCardNumberErrorSection.innerHTML='Aadhar card number required';");
pw.println("valid=false;");
pw.println("firstInvalidComponent=frm.aadharCardNumber;");
pw.println("}");
pw.println("");
pw.println("");
pw.println("");
pw.println("");
pw.println("if(!valid) firstInvalidComponent.focus();");
pw.println("return valid;");
pw.println("}");
pw.println("");

pw.println("function cancelAddition()");
pw.println("{");
pw.println("document.getElementById('cancelForm').submit();");
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
pw.println("<h3>Employees (Edit Module)</h3><br>");
pw.println("<table>");
pw.println("<form method='post' action='/styleone/updateEmployee' onsubmit='return formValidation(this)'>");
pw.println("<tr>");
pw.println("<td>Name</td> ");
pw.println("<td><input type='text' id='name' name='name' maxlength='50' value='"+name+"'> <span id='nameErrorSection' style='color:red;'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Designation</td> ");
pw.println("<td><select id='designationCode' name='designationCode'> ");
pw.println("<option value='-1'>&lt; Designation &gt; </option>");
DesignationDAO designationDAO = new DesignationDAO();
List<DesignationDTO> employees= designationDAO.getAll();

for(DesignationDTO employee: employees)
pw.println("<option value='"+employee.getCode()+"'>"+employee.getTitle()+"</option>");

pw.println("</select>");
pw.println("<span id='designationCodeErrorSection' style='color:red;'></span></td>");
pw.println("");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Date of birth</td> ");
pw.println("<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='"+dateOfBirth+"'> <span id='dateOfBirthErrorSection' style='color:red;'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Gender</td> ");
if(gender.equals("M")==false)
pw.println("<td><input type='radio' id='male' name='gender' value='M'> Male");
else
pw.println("<td><input type='radio' checked id='male' name='gender' value='M'> Male");

if(gender.equals("F")==false)
pw.println("<input type='radio' id='female' name='gender' value='F'> Female");
else
pw.println("<input type='radio' checked id='female' name='gender' value='F'> Female");

pw.println("<span id='genderErrorSection' style='color:red;'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Indian ?</td> ");
if(isIndian)
pw.println("<td><input type='checkbox' checked id='isIndian' name='isIndian' value='Y'> </td>");
else
pw.println("<td><input type='checkbox' id='isIndian' name='isIndian' value='Y'> </td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td> Basic Salary</td> ");
pw.println("<td><input type='text' id='basicSalary' name='basicSalary' style='text-align:right' value='"+basicSalary+"'> <span id='basicSalaryErrorSection' style='color:red;'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>PAN Card Number</td> ");
pw.println("<td><input type='text' id='panCardNumber' name='panCardNumber' maxlength='15' value='"+panCardNumber+"'> <span id='panCardNumberErrorSection' style='color:red;'></span></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>Aadhar Card Number</td> ");
pw.println("<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' value='"+aadharCardNumber+"'> <span id='aadharCardNumberErrorSection' style='color:red;'></span></td>");

pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td></td> ");
pw.println("<td></td>");
pw.println("</tr>");
pw.println("");
pw.println("<tr>");
pw.println("<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <button type='submit'>Edit</button></td>");
pw.println("<td><button type='button' onclick='cancelAddition()'> cancel</button></td>");
pw.println("</tr>");
pw.println("</form>");
pw.println("</table>");
pw.println("</div> <!--Right panel ends here--->");
pw.println("</div><!--Content container ends here-->");
pw.println("<!--Footer starts here-->");
pw.println("<div style='width:90hw; heigth:auto'>");
pw.println("	<center style='margin-top:18px;'>&#169; Thinking Machines</center>");
pw.println("");
pw.println("</div> <!--Footer ends here-->");
pw.println("</div> <!--Main Container ends here-->");
pw.println("<form action='/styleone/employeesView' id='cancelForm'>");
pw.println("</form>");
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