package ma.ensa.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.ensa.Transaction;
import ma.ensa.dao.TransactionDao;


public class TransactionDaoImpl implements TransactionDao{

	public int save(Transaction Transaction) {
		int r = 0;
		ConnDB db = new ConnDB();
		String req = "INSERT INTO Transaction values('" + Transaction.getRef() + "','" + Transaction.getcptDeb() + "',"
				+ Transaction.getmontant() + ",'" + Transaction.getcptCred() + "')";
		try {
			r = db.getSt().executeUpdate(req);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public List<Transaction> selectAll() {
		List<Transaction> Transactions= new ArrayList();
		
		ConnDB db = new ConnDB();
		String req = "SELECT * FROM Transaction;";
		try {
		ResultSet rs=db.getSt().executeQuery(req);
		
		while(rs.next()) {
			Transaction Transaction =new Transaction(rs.getString("ref"), rs.getString("cptDeb"), rs.getString("cptDeb"), rs.getDouble("montant"));
		Transactions.add(Transaction);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return Transactions;
	}
	
}
