package ma.ensa.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnDB {

	private Connection con;
	private Statement st;
	
	public ConnDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/produit","root","");
		st=con.createStatement();	
		}catch (ClassNotFoundException|SQLException e) {
				e.printStackTrace();
			}
		}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public Statement getSt() {
		return st;
	}

	public void setSt(Statement st) {
		this.st = st;
	}
	
}
