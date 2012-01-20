package com.twelvetwentyseven.regdar.server.db;

import java.sql.*;   // All we need for JDBC
import java.text.*;
import java.io.*;

import com.esotericsoftware.minlog.Log;

public class DBConnection
{
  private Connection       db;        // A connection to the database
  private Statement        sql;       // Our statement to run queries with
  private DatabaseMetaData dbmd;      // This is basically info the driver delivers
                              // about the DB it just connected to. I use
                              // it to get the DB version to confirm the
                              // connection in this example.

  public DBConnection()
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

    sql = db.createStatement(); //create a statement that we can use later
  }
  
  /*
   * Runs the select returning the result set
   */
  public ResultSet runQuery(String query) throws SQLException{
	  ResultSet resultSet = null;
	  // create a scrollable result set
	  sql = db.createStatement(resultSet.TYPE_SCROLL_INSENSITIVE, resultSet.CONCUR_READ_ONLY);
	  resultSet = sql.executeQuery(query);
	  return resultSet;
  }
  
  public int getQueryCount(String query) throws SQLException{
	  int count;
	  ResultSet resultSet = null;
	  resultSet = sql.executeQuery(query);
	  resultSet.last();
	  count = resultSet.getRow();
	  return count;
  }
  /*
   * Runs the Update / Insert
   * returns the number of rows affected
   */
  public int runUpdate(String query) throws SQLException{
	  // returns rowcount
	  int retVal = 0;
	  retVal = sql.executeUpdate(query);
	  return retVal;
  }
  
  /* 
   * Runs the Insert/Update with autogenerate keys
   * returns the id of the autogenerate - this is only for insert
   */
  public int runInsertAuto(String query) throws SQLException {
	  int retVal = 0;
	  retVal = sql.executeUpdate(query, sql.RETURN_GENERATED_KEYS);
	  return retVal;
  }
  

}
