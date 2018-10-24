package org.prairieview.relinkingdata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Users {
	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	private String sql = null;
	
	
	public void readDataBase() throws Exception {
	  try {
	    // This will load the MySQL driver, each DB has its own driver
	    Class.forName("com.mysql.jdbc.Driver");
	    
	    // Setup the connection with the DB
	    try {
	    connect = DriverManager
	        .getConnection("jdbc:mysql://localhost:3306/Social","root","");
	    }catch (Exception e) {
			// TODO: handle exception
	  	  e.printStackTrace();
		}
	    // Statements allow to issue SQL queries to the database
	    statement = connect.createStatement();
	    // Result set get the result of the SQL query
	    String fileName = "user_sns.txt";
	    
	    String line = null;
	    FileReader fileReader;
	    BufferedReader bufferedReader;
	    
	    try {
	        fileReader = 
	            new FileReader(fileName);
	        bufferedReader = 
	            new BufferedReader(fileReader);
	
	        
	        
	        while((line = bufferedReader.readLine()) != null) {
	      	  String arr[] = line.split("	");
	      	    sql = "INSERT INTO Users " +
	                        "VALUES ("+arr[0]+","+arr[1]+")";
	      		  //System.out.println(sql);
	                statement.executeUpdate(sql);	          
	      	    
	            
	        
	        }
	        
	
	        bufferedReader.close(); 
	            
	
	            
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");                  
	        ex.printStackTrace();
	    }      
	  } catch (Exception e) {
	    throw e;
	  } finally {
	    close();
	  }
	
	}
	
	
	// You need to close the resultSet
	private void close() {
	  try {
	    if (resultSet != null) {
	      resultSet.close();
	    }
	
	    if (statement != null) {
	      statement.close();
	    }
	
	    if (connect != null) {
	      connect.close();
	    }
	  } catch (Exception e) {
	
	  }
	}

}
