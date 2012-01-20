package com.twelvetwentyseven.regdar.server.db;

import java.sql.*;   // All we need for JDBC
import java.text.*;
import java.io.*;

public class olddb
{
  Connection       db;        // A connection to the database
  Statement        sql;       // Our statement to run queries with
  DatabaseMetaData dbmd;      // This is basically info the driver delivers
                              // about the DB it just connected to. I use
                              // it to get the DB version to confirm the
                              // connection in this example.

  public olddb()
    throws ClassNotFoundException, SQLException
  {
    String database = "Regdar";
    String username = "regdar";
    String password = "sadie23";
    Class.forName("org.postgresql.Driver"); //load the driver
    db = DriverManager.getConnection("jdbc:postgresql:"+database,
                                     username,
                                     password); //connect to the db
    dbmd = db.getMetaData(); //get MetaData to confirm connection
    System.out.println("Connection to "+dbmd.getDatabaseProductName()+" "+
                       dbmd.getDatabaseProductVersion()+" successful.\n");
    sql = db.createStatement(); //create a statement that we can use later


    String sqlText = "select * from regdarusers";
    System.out.println("Executing this command: "+sqlText+"\n");
    //ResultSet results =  sql.executeUpdate(sqlText);

 
 
    System.out.println("Now executing the command: "+
                       "select * from jdbc_demo");
    
    ResultSet results = sql.executeQuery(sqlText);
    if (results != null)
    { 
      while (results.next())
      {
        System.out.println("id = "+results.getInt("id")+
                           "; name = "+results.getString(2)+"\n");
      }
    }
    results.close();
  }
  
  
public static void main (String args[]) throws Exception, SQLException
{
	olddb demo = new olddb();

}
}