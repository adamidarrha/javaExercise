package ma.ensa;

import java.io.IOException;
import java.io.Writer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ensa.dao.TransactionDao;
import ma.ensa.dao.impl.TransactionDaoImpl;

@WebServlet("/add")
public class AddTransactionServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		TransactionDao dao=new TransactionDaoImpl();
		int r=dao.save(new Transaction(req.getParameter("ref"), req.getParameter("cptDeb"), req.getParameter("cptCred"), Double.parseDouble(req.getParameter("montant"))));
		
		Writer writer =resp.getWriter();
		if(r==0) {
			writer.write("<html>"
					+ "<body><h2>Error"
					+ "</h2></body></html>"
					+ ""
					+ "");
			
		}else {
			writer.write("<html>"
					+ "<body><h2> bien ajoute"
					+ "</h2></body></html>"
					+ ""
					+ "");
		}
	}
}
