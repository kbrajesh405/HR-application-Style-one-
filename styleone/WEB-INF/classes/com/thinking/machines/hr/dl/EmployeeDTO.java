package com.thinking.machines.hr.dl;

import java.util.*;
import java.math.*;
import java.io.*;

public class EmployeeDTO implements java.io.Serializable, Comparable<EmployeeDTO>
{
private String employeeId;
private String name;
private String designation;
private int designationCode;
private String dateOfBirth;
private String gender;
private boolean isIndian;
private BigDecimal basicSalary;
private String panCardNumber;
private String aadharCardNumber;

public EmployeeDTO()
{

this.employeeId="";
this.name="";
this.designation="";
this.designationCode=0;
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=null;
this.panCardNumber="";
this.aadharCardNumber="";
}
public void setDesignationCode(int designationCode)
{
this.designationCode=designationCode;
}
public int getDesignationCode()
{
return this.designationCode;
}

public void setEmployeeId(String employeeId)
{
this.employeeId=employeeId;
}
public String getEmployeeId()
{
return this.employeeId;
}

public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}

public void setDesignation(String designation)
{
this.designation=designation;
}
public String getDesignation()
{
return this.designation;
}

public void setDateOfBirth(String dateOfBirth)
{
this.dateOfBirth=dateOfBirth;
}
public String getDateOfBirth()
{
return this.dateOfBirth;
}

public void setGender(String gender)
{
this.gender=gender;
}
public String getGender()
{
return this.gender;
}

public void setIsIndian(boolean isIndian)
{
this.isIndian=isIndian;
}
public boolean getIsIndian()
{
return this.isIndian;
}

public void setBasicSalary(BigDecimal basicSalary)
{
this.basicSalary=basicSalary;
}
public BigDecimal getBasicSalary()
{
return this.basicSalary;
}

public void setAadharCardNumber(String aadharCardNumber)
{
this.aadharCardNumber=aadharCardNumber;
}
public String getAadharCardNumber()
{
return this.aadharCardNumber;
}

public void setPanCardNumber(String pan)
{
this.panCardNumber=pan;
}
public String getPanCardNumber()
{
return this.panCardNumber;
}

public int hashCode()
{
return this.employeeId.hashCode();
}

public boolean equals(Object object)
{
if(!(object instanceof EmployeeDTO)) return false;
EmployeeDTO employee=(EmployeeDTO)object;
return this.employeeId.equalsIgnoreCase(employee.employeeId);
}

public int compareTo(EmployeeDTO employee)
{
return this.employeeId.compareTo(employee.employeeId);
}
}