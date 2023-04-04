package com.thinking.machines.hr.dl;

import java.util.*;
import java.sql.*;

public class DesignationDAO 
{
public void add(DesignationDTO designation) throws DAOException
{
try
{
Connection con=DAOConnection.getConnection();
PreparedStatement ps;
ps=con.prepareStatement("select * from designation where title=?");
ps.setString(1, designation.getTitle());
ResultSet rs=ps.executeQuery();
if(rs.next()==true)
{
rs.close();
ps.close();
con.close();
throw new DAOException("Designation "+designation.getTitle()+" exists.");
}
rs.close();
ps.close();
ps=con.prepareStatement("insert into designation (title) values(?)", Statement.RETURN_GENERATED_KEYS);
ps.setString(1, designation.getTitle());
ps.executeUpdate();
rs=ps.getGeneratedKeys();
rs.next();
int code=rs.getInt(1);
rs.close();
ps.close();
con.close();
designation.setCode(code);
}catch(SQLException sql)
{
throw new DAOException(sql.getMessage());
}
}
public List<DesignationDTO> getAll() throws DAOException
{
List<DesignationDTO> designations = new LinkedList<>();
try
{
Connection con=DAOConnection.getConnection();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from designation order by title");
DesignationDTO designationDTO;
int code;
String title;
while(rs.next())
{
code=rs.getInt("code");
title=rs.getString("title").trim();
designationDTO=new DesignationDTO();
designationDTO.setCode(code);
designationDTO.setTitle(title);
designations.add(designationDTO);

}
rs.close();
stmt.close();
con.close();
return designations;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}

}
public DesignationDTO getByCode(int code) throws DAOException 
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = connection.prepareStatement("select * from designation where code = ?");
preparedStatement.setInt(1, code);
System.out.println(code);
ResultSet resultSet;
resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Designation Code : "+code);
}
DesignationDTO designationDTO=new DesignationDTO();
designationDTO.setCode(resultSet.getInt("code"));
designationDTO.setTitle(resultSet.getString("title").trim());
resultSet.close();
preparedStatement.close();
connection.close();

return designationDTO;
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}

public static void update(DesignationDTO designation) throws DAOException
{
try
{
int code = designation.getCode();
String title = designation.getTitle();
Connection connection = DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = connection.prepareStatement(" select * from designation where code = ?");
preparedStatement.setInt(1, code);
ResultSet resultSet = preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Designation Code : "+code);
}
preparedStatement=connection.prepareStatement("select * from designation where title =? and code !=?");
preparedStatement.setString(1, title);
preparedStatement.setInt(2, code);
resultSet = preparedStatement.executeQuery();
if(resultSet.next()==true)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException(title + " exits.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update designation set title = ? where code = ?");
preparedStatement.setString(1, title);
preparedStatement.setInt(2, code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
}
public static void delete(DesignationDTO designation) throws DAOException
{
int code = designation.getCode();
try
{
Connection con = DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement = con.prepareStatement("delete from designation where code = ?");
preparedStatement.setInt(1, code);
preparedStatement.executeUpdate();
preparedStatement.close();
con.close();
}
catch(SQLException sql)
{
System.out.println(sql);
}
catch(Exception e)
{
System.out.println(e);
}
}

public boolean designationCodeExists(int code) throws DAOException
{
boolean exists=false;
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement = connection.prepareStatement("select * from Designation where code = ?");
preparedStatement.setInt(1,code);
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

}