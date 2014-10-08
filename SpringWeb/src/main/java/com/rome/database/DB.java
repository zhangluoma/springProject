package com.rome.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DB
{
	private DataSource dataSource;
	private String databaseName;
	private Statement stmt;
	private Connection conn;
	public void setDatabaseName(String name){
		databaseName=name;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public DataSource getDataSource(){
		return dataSource;
	}
	public void connect(){
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			if(databaseName!=null){
			stmt.execute("use "+databaseName);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		}
	}
	public void close(){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
	public String getName(){
		String name=null;
		try {
			ResultSet rset=stmt.executeQuery("select * from users");
			while(rset.next()){
				System.out.println(name = rset.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
}
