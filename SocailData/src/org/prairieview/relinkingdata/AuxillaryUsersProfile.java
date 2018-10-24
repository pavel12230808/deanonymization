package org.prairieview.relinkingdata;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AuxillaryUsersProfile {
    
private Connection connect = null;
private Statement statement = null;
private ResultSet resultSet = null;
private Statement statement2 = null;
private ResultSet resultSet2 = null;
private Statement statement3 = null;
private ResultSet resultSet3 = null;
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
  statement3 = connect.createStatement();
  // Result set get the result of the SQL query      
  resultSet = statement
          .executeQuery("select userID from UsersProfile");
  List<Integer> tempList = new LinkedList<Integer>();
  	  while(resultSet.next()) {
    	  int x = resultSet.getInt("userID");
    	  tempList.add(x);
  	  }
  	  resultSet.close();
  	List<Integer> randomPicks = pickNRandom(tempList, 400);
  	Iterator<Integer> li = randomPicks.iterator();
  	while(li.hasNext()) {
  		int i = (Integer)li.next();
  		int gender =  0;
  		int yob = 0;
  		int yb = 0;
  		int temp = 0;
  		Random random = new Random();
  		resultSet3 = statement3
    	          .executeQuery("select Gender, YOB from UsersProfile where userID="+i);
  		if(resultSet3.next()) {
  		gender = resultSet3.getInt("Gender");
  		yb = resultSet3.getInt("YOB");
  		if(yb != 0) {
	  		temp = (yb % 10);
	  		/*yb = yb - temp;
	  		yob = random.nextInt((yb + 20) - (yb - 20)) + (yb - 20);*/
	  		temp= temp*10;
	  		int p=yb-temp;
	  		if(p<5) {
	  			yb=temp;
	  		}else 
	  		    yb=temp+10;
	  	}else
	  		yob = yb;
  		}
  		if(gender == 1 || gender == 0)
  			gender = 2;
  		else
  			gender = 1;
  		int tweetCount = random.nextInt(1000 - 50) + 50;
  		sql = "INSERT INTO AuxiliaryUsersProfile " +
                "VALUES ("+i+","+yob+","+gender+","+tweetCount+")";
		  System.out.println(sql);
        statement3.executeUpdate(sql);
  		
  	}
    	  resultSet2 = statement2
                  .executeQuery("select * from UsersProfile where userID NOT IN (select userID from AuxiliaryUsersProfile)");
    	  while(resultSet2.next()) {
    		  sql = "INSERT INTO AuxiliaryUsersProfile " +
    	                "VALUES ("+resultSet2.getInt(1)+","+resultSet2.getInt(2)+","+resultSet2.getInt(3)+","+resultSet2.getInt(4)+")";
    			  System.out.println(sql);
    	        statement.executeUpdate(sql);
    	  		 
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

public static List<Integer> pickNRandom(List<Integer> lst, int n) {
    List<Integer> copy = new LinkedList<Integer>(lst);
    Collections.shuffle(copy);
    return copy.subList(0, n);
}



}
