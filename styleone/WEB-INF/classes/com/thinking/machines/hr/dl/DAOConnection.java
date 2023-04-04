package com.thinking.machines.hr.dl;

import java.sql.*;

public class DAOConnection
{
private DAOConnection(){}

public static Connection getConnection() throws DAOException
{
Connection con=null;
try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/tmdb","tmdbuser","tmdbuser");

}catch(Exception e)
{
throw new DAOException(e.getMessage());
}
return con;
}
}