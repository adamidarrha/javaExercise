package ma.ensa;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.dao.TransactionDao;
import ma.ensa.dao.impl.TransactionDaoImpl;
@WebServlet("/list")

public class ListTransactionsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TransactionDao dao=new TransactionDaoImpl();
		List<Transaction> Transactions=dao.selectAll();
		
		Writer writer =resp.getWriter();
		String trs="";
		for(Transaction p:Transactions) trs+="<tr><td>"+p.getRef()+"</td>"+
				"<td>"+p.getcptDeb()+"</td>"+
				"<td>"+p.getcptCred()+"</td>"+
				"<td>"+p.getmontant()+"</td></tr>";
				
		writer.write("<html>"
					+ "<body><h2>List of Transactions"
					+ "</h2></body></html>"
					+ "<table>"+
					trs
					+ "</table>");
		
		
		
	}
}
