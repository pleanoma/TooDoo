package com.sck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConnectorIntegrationTest {
	
	private Connector connector;
	private Connection con;

	@Before
	public void setup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/TooDoo?user=root&password=1234");
		con.setAutoCommit(false);
		
		connector = new Connector(con);
		PreparedStatement statement = con.prepareStatement("insert into TooDoo.TooDooList (Subject,Due_date,UserID,CatID,Priority,Create_date) values	('subject 1',NULL,'Tin',NULL,NULL,'2013-11-27');");
		statement.executeUpdate();
		
		statement = con.prepareStatement("insert into TooDoo.TooDooList (Subject,Due_date,UserID,CatID,Priority,Create_date) values	('subject 2',NULL,'Tin',NULL,NULL,'2013-11-28');");
		statement.executeUpdate();
		
		statement = con.prepareStatement("insert into TooDoo.TooDooList (Subject,Due_date,UserID,CatID,Priority,Create_date) values	('subject 3',NULL,'Tin',NULL,NULL,'2013-11-29');");
		statement.executeUpdate();
	}
	
	@Test
	public void findAllTodoByUserIDUsingMySQL() throws SQLException {
		
		TooDooItem[] items = connector.findAllTodoByUserID("Tin");
		Assert.assertEquals(3, items.length);
	}
	
	@After
	public void tearDown() throws SQLException {
		con.rollback();
		con.close();
	}

}
