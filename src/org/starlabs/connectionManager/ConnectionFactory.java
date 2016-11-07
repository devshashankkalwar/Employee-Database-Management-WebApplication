package org.starlabs.connectionManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	
	private static Connection con;
	
	
		
	public static Connection getConnection(String db){
		ConnectionFactory connfact = new ConnectionFactory();
		String host= "localhost";
		String port= "3306";
		String uname= "starlabsdev";
		String pass= "starlabs";
			
			
				try{
				Class.forName("com.mysql.jdbc.Driver");									
				con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?useSSL=false", uname,pass);
				return con;
				}
				
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					return null;
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
					
	}
}


