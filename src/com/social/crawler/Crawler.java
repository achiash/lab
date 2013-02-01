package com.social.crawler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import org.apache.commons.io.IOUtils;

public class Crawler {
	
	static Connection con = null;
	

	private static final int MAX_USERS_TO_CRAWL = 1000;
	private static final int TWEETS_PER_USER = 5;
	private static final String DB_URL = "labdb.cqjs1hdgjqsd.us-east-1.rds.amazonaws.com/social";
	
	//TODO initialize this variables from database
	private static long userAttributeId = 0;
	private static long tweetAttributeId = 0;
	private static long listAttributeId = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection("jdbc:mysql://"+DB_URL, "labuser", "1qaz!QAZ");
			//System.out.println(con.getMetaData().getMaxConnections());
			
			insertUser(5,null,null,null);
		}
		catch (SQLException ex){
			// handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void crawlUsers() {
		
	}
	
	public static void crawlTweets() {
		
	}
	
	private static void insertUser(long id, String location, String userName, String fullName) throws SQLException {
		if (con == null) {
			con = DriverManager.getConnection("jdbc:mysql://"+DB_URL, "labuser", "1qaz!QAZ");
		}
		PreparedStatement stmt;
		ResultSet res;
		String query = "insert into Node() values();";
		stmt = con.prepareStatement(query);
		stmt.execute();
		stmt.close();
		Long userId = new Long(-1);
		Long attId = new Long(-1);
		userId = getLastInsertId();
		
		query = "insert into Attribute(name,val) values ('userId',"+id+");";
		stmt = con.prepareStatement(query);
		stmt.execute();
		stmt.close();
		attId = getLastInsertId();
		query = "select last_insert_id()";
		
		//insert into Node() values();
		//select last_insert_id();
		//insert into 
	}

	private static Long getLastInsertId() throws SQLException {
		String query = "select last_insert_id()";
		Long id = new Long(-1);
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.execute();
		ResultSet res = stmt.getResultSet();
		while (res.next()) {
			id = res.getLong(1);
		}
		res.close();
		stmt.close();
		return id;
	}
	

}
