package org.prairieview.relinking;
import java.io.File;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

public class SeedsPairing {
	  private Connection connect = null;
	  private Statement statement = null;
	  private ResultSet resultSet = null;
	  private Statement statement1 = null;
	  private ResultSet resultSet1 = null;
	  private Statement statement2 = null;
	  private ResultSet resultSet2 = null;
	  private Statement statement3 = null;
	  private ResultSet resultSet3 = null;
	  private Statement statement4 = null;
	  private ResultSet resultSet4 = null;
	  private Statement statement5 = null;
	  private ResultSet resultSet5 = null;
	  private Statement statement6 = null;
	  private ResultSet resultSet6 = null;
	  private Statement statement7 = null;
	  private Statement statement8 = null;
	  private ResultSet resultSet8 = null;
	  private Statement statement9 = null;
	  private ResultSet resultSet9 = null;
	  private ResultSet resultSet10 = null;
	  private Statement statement10 = null;
	  private ResultSet resultSet11 = null;
	  private Statement statement11 = null;
	  private ResultSet resultSet12 = null;
	  private Statement statement12 = null;
	 
	  ResultSet resultSet13 = null;
	  Statement statement13 = null;
	  ResultSet resultSet14 = null;
	  Statement statement14 = null;
	  Statement statement15 = null;
	  Statement statement16 = null;
	  Statement statement17 = null;
	  Statement statement18 = null; 
	  ResultSet resultSet15 = null;
	  ResultSet resultSet16 = null;
	  ResultSet resultSet17 = null;
	  ResultSet resultSet18 = null;
	  ResultSet resultSet19 = null;
	  
	  long startTime, endTime, timeTaken;
	  int count_exact=0;
	  //ArrayList<Seeds> seedsClass = new ArrayList<Seeds>();
	  ArrayList<Similarities> similaritiesClass = new ArrayList<Similarities>();
	  //ListIterator<Seeds> seedsIterator = seedsClass.listIterator();
	  HashSet<Integer> targetConnectionsSet = new HashSet<Integer>();
	  HashSet<Integer> auxiliaryConnectionsSet = new HashSet<Integer>();
	  Calendar calendar = Calendar.getInstance();
	  ArrayList<Seeds> seedsArrayList = new ArrayList<Seeds>();
	  ArrayList<TargetUserConnectionClass> targetUserArrayList = new ArrayList<TargetUserConnectionClass>();
	  ArrayList<AuxiliaryUserConnectionClass> auxiliaryUserArrayList = new ArrayList<AuxiliaryUserConnectionClass>();
	  
	  //URL path=Thread.currentThread().getContextClassLoader().getResource("SocialGraph/WebContent/WEB-INF");
	 
	  
	public void readDataBase(int seeds, boolean keepSeeds, String webinfpath, boolean profileFunction, boolean centralityFunction) throws Exception {
		
		
		System.out.println("create file here" + profileFunction + " "+ centralityFunction);
		
		
		// TODO Auto-generated method stub
		startTime = System.nanoTime();
		int seedsCount;
		boolean keepSeedsBoolean = keepSeeds;
		seedsCount = seeds;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
		      connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/Social","root","");
		      }catch (Exception e) {
		    	  	e.printStackTrace();
		      }
			  
		      statement = connect.createStatement();
		      statement1 = connect.createStatement();
		      statement2 = connect.createStatement();
		      statement3 = connect.createStatement();
		      statement4 = connect.createStatement();
		      statement5 = connect.createStatement();
		      statement6 = connect.createStatement();
		      statement7 = connect.createStatement();
		      statement8 = connect.createStatement();
		      statement9 = connect.createStatement();
		      statement10 = connect.createStatement();
		      statement11 = connect.createStatement();
		      statement12 = connect.createStatement();
		      statement13 = connect.createStatement();
		      statement14 = connect.createStatement();
				statement15 = connect.createStatement();
				statement16 = connect.createStatement();
				statement17 = connect.createStatement();
				statement18 = connect.createStatement();
				
		      //System.out.println(keepSeeds);
		      
		      if(keepSeedsBoolean) {
		    	  resultSet = statement
	                      .executeQuery("select * from InitialSeeds");
    	  	  	  statement5.executeUpdate("DELETE FROM Seeds WHERE 1");   
    	  	  	  //statement5.close();
		    	  while(resultSet.next()) {
			    	  	int a = resultSet.getInt(1);
			    	  	//System.out.println("Random number " +","+a);
			    	  	statement5.executeUpdate("INSERT INTO Seeds (targetUserID, auxiliaryUserID, status) " +
				                "VALUES ("+a+","+a+",0)");
		    	  		targetConnectionsSet.add(a);
		    	  		auxiliaryConnectionsSet.add(a);
			  }
		      }
		      
		      else {
		      resultSet = statement
                      .executeQuery("select DISTINCT user1 from AuxiliaryUsers ORDER BY RAND() LIMIT "+seedsCount);
	    	  	  statement10.executeUpdate("DELETE FROM InitialSeeds WHERE 1");
		      
    	  	  	  statement5.executeUpdate("DELETE FROM Seeds WHERE 1");
		      int i = 0;
		      while(resultSet.next()) {
		    	  	int a = resultSet.getInt(1);
		    	  	statement1.executeUpdate("INSERT INTO InitialSeeds " +
			                "VALUES ("+a+","+a+")");
		    	    statement5.executeUpdate("INSERT INTO Seeds (targetUserID, auxiliaryUserID, status) " +
			                "VALUES ("+a+","+a+",0)");
		    	  	//System.out.println("Random number " + i+","+a);
		    	  	targetConnectionsSet.add(a);
	    	  		auxiliaryConnectionsSet.add(a);
		    	  	i++;
		      }
		      }
		      //seedsIterator = seedsClass.listIterator();
		      do {
		    	  	ArrayList<Integer> targetConnections = new ArrayList<Integer>();
		    	  	ArrayList<Integer> auxiliaryConnections = new ArrayList<Integer>();
		    	  	ArrayList<TargetUserClass> targetUserClasses = new ArrayList<TargetUserClass>();
		    	  	ArrayList<AuxiliaryUserClass> auxiliaryUserClasses = new ArrayList<AuxiliaryUserClass>();
		    	  	//Seeds seedsClassNode = seedsIterator.next();
		    	  	resultSet5 = statement5.executeQuery("select * from Seeds where status = 0 ORDER BY timeStamp ASC");
		    	  	if(resultSet5.next()) {
			    	  	resultSet2 = statement2.executeQuery("select user2 from TargetUsers where user1 = "+ resultSet5.getInt(1));
			    	  	//System.out.print("Target Connections of"+ resultSet5.getInt(1) +":");
			    	  	while(resultSet2.next()) {
			    	  		int value = resultSet2.getInt(1);
			    	  		if(targetConnectionsSet.add(value)) {
			    	  			targetConnections.add(value);
			    	  			//System.out.print(value +" ");
			    	  		}
			    	  	}
			    	  	
			    	  	//System.out.println();
			    	  	resultSet2.close();
			    	  	resultSet2 = statement2.executeQuery("select user2 from AuxiliaryUsers where user1 = "+resultSet5.getInt(2));
			    	  	//System.out.print("Auxiliary Connections of "+resultSet5.getInt(2)+":");
			    	  	while(resultSet2.next()) {
			    	  		int value = resultSet2.getInt(1);
			    	  		if(auxiliaryConnectionsSet.add(value)) {
			    	  			auxiliaryConnections.add(value);
			    	  			//System.out.print(value +" ");
			    	  		}
			    	  	}
			    	  	////System.out.println("UPDATE Seeds SET status = 1 WHERE " +
				     //           "targetUserID = "+resultSet5.getInt(1)+" AND auxiliaryUserID = "+resultSet5.getInt(2)+")");
			    	  	statement6.executeUpdate("UPDATE Seeds SET status = 1 WHERE " +
				                "targetUserID = "+resultSet5.getInt(1)+" AND auxiliaryUserID = "+resultSet5.getInt(2));
		    	  	}
		    	  	//resultSet5.close();
		    	  	//System.out.println();
		    	  	//resultSet2.close();
		    	  	Iterator<Integer> tc1 = targetConnections.iterator();
		    	  	Iterator<Integer> ac1 = auxiliaryConnections.iterator();
		    	  	while(tc1.hasNext()) {
		    	  		////System.out.print(tc1.next()+"   ");
		    	  		
		    	  		resultSet3 = statement3.executeQuery("select YOB, Gender, userID from UsersProfile where userID = " +tc1.next());
				  	while(resultSet3.next()) {
				  		TargetUserClass tuc = new TargetUserClass(resultSet3.getInt(1), resultSet3.getInt(2), resultSet3.getInt(3));
				  		
				  		resultSet17 = statement17.executeQuery("select count(*) from TargetUsers where user1 = " + resultSet3.getInt(3));
				  		
				  		while(resultSet17.next())
				  			tuc.count = resultSet17.getInt(1);
				  		
				  		targetUserClasses.add(tuc);
				  	}
				  	resultSet3.close();
		    	  	}
		    	  	//System.out.println();
		    	  	
		    	  	
		    	  	while(ac1.hasNext()) {
		    	  		////System.out.print(ac1.next()+"   ");
		    	  		resultSet4 = statement4.executeQuery("select YOB, Gender, userID from AuxiliaryUsersProfile where userID = "+ac1.next());
				  	while(resultSet4.next()) {
				  		AuxiliaryUserClass auc = new AuxiliaryUserClass(resultSet4.getInt(1), resultSet4.getInt(2), resultSet4.getInt(3));
				  		resultSet19 = statement17.executeQuery("select count(*) from TargetUsers where user1 = " + resultSet4.getInt(3));
				  		
				  		while(resultSet19.next())
				  			auc.count = resultSet19.getInt(1);
				  		
				  		auxiliaryUserClasses.add(auc);
				  	}
				  	resultSet4.close();
		    	  	}
		    	  	Iterator<TargetUserClass> tuci = targetUserClasses.iterator();
		    	  	while(tuci.hasNext()) {
		    	  		TargetUserClass targetNode = tuci.next();
				  	Iterator<AuxiliaryUserClass> auci = auxiliaryUserClasses.iterator();
				  	while(auci.hasNext()) {
				  		AuxiliaryUserClass auxiliaryNode = auci.next();
				  		if(profileFunction) {
				  		findSimilarityScoreWithAttributes(targetNode, auxiliaryNode);}
				  		if(centralityFunction) {
				  		findSimilarityScoreWithCentrality(targetNode,auxiliaryNode);}
				  	}  
		    	  	}
		    	  	maxMatching();
		    	  	resultSet8 = statement8.executeQuery("select * from Seeds where status = 0");
		    	  }while(resultSet8.next());
	    	  	  resultSet9 = statement9.executeQuery("select * from Seeds");
	    	  	  
	    	  	//EDIT:: Write this in file
	    	  		File file1 = new File(webinfpath + "/TargetUserID.txt");
	    	  		if(file1.exists()) {
	    	  			file1.delete();
	    	  		}
	    	  		
	    	  		File file2 = new File(webinfpath + "/AuxilaryUserID.txt");
	    	  		if(file2.exists()) {
	    	  			file2.delete();
	    	  		}
	    	  	  
	    	  	  while(resultSet9.next()) {
	    	  		resultSet11 = statement11.executeQuery("select YOB, Gender, userID from UsersProfile where userID = "+resultSet9.getInt(1));
	    	  		resultSet12 = statement12.executeQuery("select YOB, Gender, userID from AuxiliaryUsersProfile where userID = "+resultSet9.getInt(2));
				 if(resultSet11.next() && resultSet12.next()) {
					 String targetUser, auxiliaryUser;
					 int targetUserID, auxiliaryUserID, targetUserGender, targetUserDOY, auxiliaryUserDOY, auxiliaryUserGender;
					 targetUser = String.valueOf(resultSet9.getInt(1));
					 auxiliaryUser = String.valueOf(resultSet9.getInt(2));
					 targetUserID = resultSet11.getInt(3);
					 auxiliaryUserID = resultSet12.getInt(3);
					 targetUserGender = resultSet11.getInt(2);
					 auxiliaryUserGender = resultSet12.getInt(2);
					 targetUserDOY = resultSet11.getInt(1);
					 auxiliaryUserDOY = resultSet12.getInt(1);
					 Seeds seedsAL = new Seeds(targetUser+"_T", auxiliaryUser+"_A", targetUserID, auxiliaryUserID, targetUserGender, auxiliaryUserGender, targetUserDOY, auxiliaryUserDOY);
					 seedsArrayList.add(seedsAL);
				 }
	    	  		  //System.out.println("TargetUser ID: "+resultSet9.getInt(1)+", AuxiliaryUser ID: "+resultSet9.getInt(2));
	    	  		  
	    	  		
	    	  		PrintWriter writer1 = new PrintWriter(new FileOutputStream(file1,true));
	    	  		writer1.print(resultSet9.getInt(1) + ",");
	    	  		writer1.close();
	    	  		
	    	  		PrintWriter writer2 = new PrintWriter(new FileOutputStream(file2,true));
	    	  		writer2.print(resultSet9.getInt(2)*10 + ",");
	    	  		writer2.close();
	    	  		  
	    	  	  }
	    	  	//System.out.println(seedsArrayList.toString());
	    	  	resultSet13 = statement13.executeQuery("select * from TargetUsers");
	    	  	
	    	  	File file5 = new File(webinfpath + "/TargetUser_Src.txt");
    	  		if(file5.exists()) {
    	  			file5.delete();
    	  		}
    	  		
    	  		File file6 = new File(webinfpath + "/TargetUser_Dest.txt");
    	  		if(file6.exists()) {
    	  			file6.delete();
    	  		}
	    	  	
	    		while(resultSet13.next()) {
	    			int s = resultSet13.getInt(1);
	    			int t = resultSet13.getInt(2);
	    			TargetUserConnectionClass connectionClass = new TargetUserConnectionClass(s, t);
	    			targetUserArrayList.add(connectionClass);
	    			
	    			
	    			PrintWriter writer1 = new PrintWriter(new FileOutputStream(file5,true));
	    	  		writer1.print( s+ ",");
	    	  		writer1.close();
	    	  		
	    	  		PrintWriter writer2 = new PrintWriter(new FileOutputStream(file6,true));
	    	  		writer2.print( t + ",");
	    	  		writer2.close();
	    			
	    			
	    		}
	    		resultSet13.close();
	    		statement13.close();
	    		
	    		resultSet14 = statement14.executeQuery("select * from AuxiliaryUsers");
	    		
	    		File file3 = new File(webinfpath + "/Auxiliary_Src.txt");
    	  		if(file3.exists()) {
    	  			file3.delete();
    	  		}
    	  		
    	  		File file4 = new File(webinfpath + "/Auxiliary_Dest.txt");
    	  		if(file4.exists()) {
    	  			file4.delete();
    	  		}
	    		
	    		while(resultSet14.next()) {
	    			int s = resultSet14.getInt(1);
	    			int t = resultSet14.getInt(2);
	    			AuxiliaryUserConnectionClass connectionClass = new AuxiliaryUserConnectionClass(s, t);
	    			auxiliaryUserArrayList.add(connectionClass);
	    			
	    			PrintWriter writer1 = new PrintWriter(new FileOutputStream(file3,true));
	    	  		writer1.print( s*10 + ",");
	    	  		writer1.close();
	    	  		
	    	  		PrintWriter writer2 = new PrintWriter(new FileOutputStream(file4,true));
	    	  		writer2.print( t*10 + ",");
	    	  		writer2.close();
	    			
	    		}
	    		resultSet14.close();
	    		statement14.close();
			      endTime = System.nanoTime();
			      timeTaken = endTime - startTime;
			      System.out.println("Time taken: "+ timeTaken/1000000000+" seconds");
	    		resultSet15 = statement15.executeQuery("select count(targetUserID) from Seeds where targetUserID = auxiliaryUserID");
	    		
	    		while(resultSet15.next()) {
	    			   count_exact = resultSet15.getInt(1);
	    			System.out.println("Count of seeds matched exactly "+count_exact);
	    		}
	    		resultSet15.close();
	    		statement15.close();
	    		statement15 = connect.createStatement();
	    		resultSet15 = statement15.executeQuery("select count(targetUserID) from Seeds");
	    		File fileacc = new File(webinfpath + "/Acc.txt");
    	  		if(fileacc.exists()) {
    	  			fileacc.delete();
    	  		}
	    		while(resultSet15.next()) {
	    			float count = resultSet15.getInt(1);
	    			Random rand = new Random();

	    			int  n = rand.nextInt(4)+1;
	    			System.out.println("Count of seeds matched  "+count);
	    			PrintWriter writeracc = new PrintWriter(new FileOutputStream(fileacc,true));
	    	  		writeracc.print(count_exact*100/count +"%" );
	    	  		writeracc.close();
	    	  		
	    		}
	    		statement15.close();
	    		resultSet.close();
	    		resultSet16 = statement16.executeQuery("select * from Seeds");
	    		while(resultSet16.next()) {
	    			int s = resultSet16.getInt(1);
	    			int t = resultSet16.getInt(2);
	    			
	    		}
	    		resultSet16.close();
	    		statement16.close();
	    		
	    		
	    		for(int i=0; i< auxiliaryUserArrayList.size(); i++) {
	    			
	    			int src = auxiliaryUserArrayList.get(i).source;
	    			
	    			resultSet17 = statement17.executeQuery("select count(*) from AuxiliaryUsers where user1 = " + src);
	    			
	    			while(resultSet17.next()) {
	    			
	    				//System.out.println("Auxiliaryuser1: " + src + "  Count: " +  resultSet17.getInt(1));
	    			
	    				statement18.executeUpdate("UPDATE AuxiliaryUsers SET count_aux = " + resultSet17.getInt(1) + " WHERE user1 = " + src);
	    				
	    			}
	    			
	    			
	    		}
	    		
	    		for(int i=0; i< targetUserArrayList.size(); i++) {
	    			
	    			int src = targetUserArrayList.get(i).source;
	    			
	    			resultSet17 = statement17.executeQuery("select count(*) from TargetUsers where user1 = " + src);
	    			
	    			while(resultSet17.next()) {
	    			
	    				//System.out.println("Targetuser1: " + src + "  Count: " +  resultSet17.getInt(1));
	    			
	    				statement18.executeUpdate("UPDATE TargetUsers SET count_tar = " + resultSet17.getInt(1) + " WHERE user1 = " + src);
	    				
	    			}
	    			
	    			
	    		}
	    		
	    		resultSet17.close();
	    		statement17.close();
	    		statement18.close();
	    		

		}catch(Exception e){
			throw e;
		}finally {
			close();
		}
	}
	public ArrayList<Seeds> getSeedsArraayList(){
		////System.out.println(seedsArrayList);
		return seedsArrayList;
	}
	
	public ArrayList<TargetUserConnectionClass> getTargetUsersArrayList() throws SQLException{
		return targetUserArrayList; 
	}
	
	
	public ArrayList<AuxiliaryUserConnectionClass> getAuxiliaryUsersArrayList() throws SQLException{
		return auxiliaryUserArrayList; 
	}
	
	private void maxMatching() throws SQLException {
		// TODO Auto-generated method stub
		ListIterator<Similarities> similiaritiesIterator = similaritiesClass.listIterator();
		while(similiaritiesIterator.hasNext()) {
			Collections.sort(similaritiesClass, new ScoreComparator());
			int i = 0;
			for(Similarities s : similaritiesClass) {
				//if(i == 0) {
					//seedsClass.add(new Seeds(s.targetUserUserID, s.auxiliaryUserUserID));
					ListIterator<Similarities> similiaritiesIterator1 = similaritiesClass.listIterator();
					while(similiaritiesIterator1.hasNext()) {
						//seedsIterator.add(new Seeds(s.targetUserUserID, s.auxiliaryUserUserID));
			    	    		//java.sql.Timestamp timeStamp = new java.sql.Timestamp(calendar.getTime().getTime());
						statement7.executeUpdate("INSERT INTO Seeds (targetUserID, auxiliaryUserID, status) " +
				                "VALUES ("+s.targetUserUserID+","+s.auxiliaryUserUserID+",0)");
						break;
					}
					//System.out.println(s.targetUserUserID+" "+ s.auxiliaryUserUserID);
					ListIterator<Similarities> similiaritiesIteratorForDeletingElements = similaritiesClass.listIterator();
					while(similiaritiesIteratorForDeletingElements.hasNext()) {
						Similarities similarities = similiaritiesIteratorForDeletingElements.next();
						if(similarities.targetUserUserID == s.targetUserUserID || similarities.auxiliaryUserUserID == s.auxiliaryUserUserID) {
							////System.out.println("removed");
							similiaritiesIteratorForDeletingElements.remove();
						}
					}
				//}
				//else
					i++;
					break;
			}
			////System.out.println(i);
		}
	}
	private void findSimilarityScoreWithCentrality(TargetUserClass targetNode, AuxiliaryUserClass auxiliaryNode){
		// TODO Auto-generated method stub
		
		double ss;
		double gScore , yScore;
		if(targetNode.count == auxiliaryNode.count) {
			gScore = 1;
		}
		else 
			gScore = 0.5;
		//yScore = 1 - Math.abs((targetNode.yob - auxiliaryNode.yob)/20);
		Random rand = new Random();

		int  n = rand.nextInt(50) + 1;
		ss = 0.5 * (gScore + (auxiliaryNode.count/(49)));
		Similarities sce = new Similarities(targetNode.yob, targetNode.gender, targetNode.userID, auxiliaryNode.yob, auxiliaryNode.gender, auxiliaryNode.userID, ss);
		similaritiesClass.add(sce);
		////System.out.println(sce);
	}
	private void findSimilarityScoreWithAttributes(TargetUserClass targetNode, AuxiliaryUserClass auxiliaryNode){
		// TODO Auto-generated method stub
		
		double ss;
		double gScore , yScore;
		if(targetNode.gender == auxiliaryNode.gender ) {
			gScore = 1;
		}
		else 
			gScore = 0.5;
		yScore = 1 - Math.abs((targetNode.yob - auxiliaryNode.yob)/20);
		ss = 0.5 * (gScore + yScore );
		Similarities sce = new Similarities(targetNode.yob, targetNode.gender, targetNode.userID, auxiliaryNode.yob, auxiliaryNode.gender, auxiliaryNode.userID, ss);
		similaritiesClass.add(sce);
		////System.out.println(sce);
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
