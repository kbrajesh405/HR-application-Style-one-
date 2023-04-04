package com.thinking.machines.hr.servlets;

import java.io.*;
import com.thinking.machines.hr.dl.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java .util.*;
import java.math.*;

public class UpdateEmployees extends HttpServlet
{
public void doGet(HttpServletRequest rq, HttpServletResponse rs)
{
try{
EmployeeDTO employeeDTO=new EmployeeDTO();
String employeeId=rq.getParameter("employeeId");
int designationCode= Integer.parseInt(rq.getParameter("designationCode"));
String name=rq.getParameter("name");
String dateOfBirth=rq.getParameter("dateOfBirth");
String gender=rq.getParameter("gender");
boolean isIndian=false;
if(rq.getParameter("isIndian")=="Y") isIndian=true;
BigDecimal basicSalary=new BigDecimal((rq.getParameter("basicSalary")));
String panCardNumber=rq.getParameter("panCardNumber");
String aadharCardNumber=rq.getParameter("aadharCardNumber");


employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setAadharCardNumber(aadharCardNumber);
employeeDTO.setPanCardNumber(panCardNumber);



EmployeeDAO employeeDAO = new EmployeeDAO();
employeeDAO.update(employeeDTO);

}catch(Exception e)
{

}
}

public void doPost(HttpServletRequest rq, HttpServletResponse rs)
{
doGet(rq, rs);
}

}