package org.prairieview.relinkingdata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class AuxillaryDataClass {

    
	  private Connection connect = null;
	  private Statement statement = null;
	  private Statement statement2 = null;
	  private ResultSet resultSet = null;
	  private String sql = null;
	  int target = 500;
	  int count = 0;
	  int s = 100001;
	  int V = 10000000;

	  
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
	      
	      while(count < target) {
	    	  
	    	  boolean visited[] = new boolean[V];
	    	  
	          // Create a queue for BFS
	          LinkedList<Integer> queue = new LinkedList<Integer>();
	   
	          // Mark the current node as visited and enqueue it
	          visited[s]=true;
	          queue.add(s);
	   
	          while (queue.size() != 0)
	          {
	              // Dequeue a vertex from queue and print it
	              s = queue.poll();
	              System.out.println(s+" "+count);
	   
	              // Get all adjacent vertices of the dequeued vertex s
	              // If a adjacent has not been visited, then mark it
	              // visited and enqueue it
	              resultSet = statement
	                      .executeQuery("select * from Users where user1 ="+s);
	              while (resultSet.next())
	              {
	                  int n = resultSet.getInt(2);
	                  if (!visited[n] && count < target)
	                  {
	                      visited[n] = true;
	                      queue.add(n);
	                      count++;
	                      sql = "INSERT INTO AuxiliaryUsers " +
	                              "VALUES ("+s+","+n+","+0+")";
	                      statement2.executeUpdate(sql);
	                  }
	              }
	          }
	    	  	
	      }    
	    } catch (Exception e) {
	      throw e;
	    }
	    close();

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
