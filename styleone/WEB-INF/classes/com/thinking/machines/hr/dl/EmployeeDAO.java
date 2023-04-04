package com.thinking.machines.hr.dl;

import java.util.*;
import java.sql.*;
import java.math.*;

public class EmployeeDAO
{
public List<EmployeeDTO> getAll() throws DAOException
{
List<EmployeeDTO> list=new LinkedList<>();
try
{
Connection connection = DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet = statement.executeQuery("select employee.employee_Id, employee.name, designation.title, employee.date_Of_Birth, employee.gender, employee.is_Indan, employee.basic_Salary, employee.pan_Card_Number, employee.aadhar_Card_Number from employee inner join designation on employee.designation_code=designation.code");

EmployeeDTO employeeDTO;
int employeeId;
String name;
String designation;
String dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panCardNumber;
String aadharCardNumber;


while(resultSet.next())
{
employeeId=resultSet.getInt("employee_id");
name=resultSet.getString("name").trim();
designation=resultSet.getString("title").trim();
dateOfBirth=resultSet.getString("date_of_birth").trim();
gender=resultSet.getString("gender").trim();
isIndian=resultSet.getBoolean("is_indan");
basicSalary=resultSet.getBigDecimal("basic_salary");
panCardNumber=resultSet.getString("pan_card_number").trim();
aadharCardNumber=resultSet.getString("aadhar_card_Number").trim();

employeeDTO=new EmployeeDTO();
employeeDTO.setEmployeeId("A"+employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignation(designation);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPanCardNumber(panCardNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
list.add(employeeDTO);
}
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return list;
}

public void add(EmployeeDTO employeeDTO) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = connection.prepareStatement("select * from employee where pan_card_number=? or aadhar_card_number=?");
preparedStatement.setString(1, employeeDTO.getPanCardNumber());
preparedStatement.setString(2, employeeDTO.getAadharCardNumber());
ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Data already Exists");
}
resultSet.close();
preparedStatement.close();

preparedStatement = connection.prepareStatement("insert into employee (name,designation_code,date_Of_Birth, gender, is_Indan, basic_Salary, pan_Card_Number, aadhar_Card_Number) values (?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);

preparedStatement.setString(1, employeeDTO.getName());
preparedStatement.setInt(2, employeeDTO.getDesignationCode());
preparedStatement.setString(3, employeeDTO.getDateOfBirth());
preparedStatement.setString(4, employeeDTO.getGender());
preparedStatement.setBoolean(5, employeeDTO.getIsIndian());
preparedStatement.setBigDecimal(6, employeeDTO.getBasicSalary());
preparedStatement.setString(7, employeeDTO.getPanCardNumber());
preparedStatement.setString(8, employeeDTO.getAadharCardNumber());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
resultSet.next();
int id = resultSet.getInt(1);
employeeDTO.setEmployeeId("A"+id);
resultSet.close();
preparedStatement.close();
connection.close();
}catch(SQLException e)
{
throw new DAOException(e.getMessage());
}

}

public boolean panCardNumberExists(String panCardNumber) throws DAOException
{
boolean exists=false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement("select gender from Employee where Pan_card_number = ?");
preparedStatement.setString(1,panCardNumber);
ResultSet resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
System.out.println(e);
}
return exists;
}

public boolean aadharCardNumberExists(String aadharCardNumber) throws DAOException
{
boolean exists=false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement("select gender from employee where aadhar_card_number = ?");
preparedStatement.setString(1,aadharCardNumber);
ResultSet resultSet=preparedStatement.executeQuery();
exists=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
System.out.println(e);
}
return exists;
}

public void delete(int employeeId) throws DAOException
{
try{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select gender from employee where employee_Id=?");
preparedStatement.setInt(1, employeeId);
ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid employee Id");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from employee where employee_id=?");
preparedStatement.setInt(1, employeeId);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
System.out.println(e);
}


}




public EmployeeDTO getByEmployeeId(String employeesId) throws DAOException
{
EmployeeDTO employeeDTO=new EmployeeDTO();
int employeeId=0;
try
{
employeeId=Integer.parseInt(employeesId.substring(2,8));
System.out.println(employeeId);
}catch(NumberFormatException nfe)
{
System.out.println(nfe);
}
try{

Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select gender from employee where employee_Id=?");
preparedStatement.setInt(1, employeeId);
ResultSet resultSet=preparedStatement.executeQuery();
while(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid employee Id");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select employee.employee_Id, employee.name, designation.title, employee.date_Of_Birth, employee.gender, employee.is_Indan, employee.basic_Salary, employee.pan_Card_Number, employee.aadhar_Card_Number from employee inner join designation on employee.designation_code=designation.code and employee_Id=?");
preparedStatement.setInt(1, employeeId);
resultSet=preparedStatement.executeQuery();


int id;
String name;
String designation;
String dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panCardNumber;
String aadharCardNumber;


while(resultSet.next())
{
id=resultSet.getInt("employee_id");
name=resultSet.getString("name").trim();
designation=resultSet.getString("title").trim();
dateOfBirth=resultSet.getString("date_of_birth").trim();
gender=resultSet.getString("gender").trim();
isIndian=resultSet.getBoolean("is_indan");
basicSalary=resultSet.getBigDecimal("basic_salary");
panCardNumber=resultSet.getString("pan_card_number").trim();
aadharCardNumber=resultSet.getString("aadhar_card_Number").trim();

employeeDTO.setEmployeeId("A"+id);
employeeDTO.setName(name);

employeeDTO.setDesignation(designation);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPanCardNumber(panCardNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
}

preparedStatement.close();
connection.close();

}catch(Exception e)
{
System.out.println(e);
}
return employeeDTO;
}

}