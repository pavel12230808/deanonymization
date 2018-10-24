package org.prairieview.relinkingdata;
// Adapted from http://www.vogella.com/tutorials/MySQLJava/article.html
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TargetUsersProfile {
        
  private Connection connect = null;
  private Statement statement = null;
  private ResultSet resultSet = null;
  private Statement statement2 = null;
  private ResultSet resultSet2 = null;
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
      statement2 = connect.createStatement();
      // Result set get the result of the SQL query
      String fileName = "user_profile.txt";
      
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
        	  resultSet = statement
                      .executeQuery("select * from TargetUsers where user1 ="+arr[0]);
        	  resultSet2 = statement2
                      .executeQuery("select * from TargetUsers where user2 ="+arr[0]);
        	  if(resultSet.next() || resultSet2.next()) {
        		  //System.out.println(arr[0]);
        		  if(arr[1].matches("0-(.*)") || arr[1].matches("1-(.*)") || arr[1].matches("2-(.*)"))
        			  arr[1] = "0";
        		  sql = "INSERT INTO UsersProfile " +
                          "VALUES ("+arr[0]+","+arr[1]+","+arr[2]+","+arr[3]+")";
        		  System.out.println(sql);
                  statement.executeUpdate(sql);	          
        	  }
              
              
          
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