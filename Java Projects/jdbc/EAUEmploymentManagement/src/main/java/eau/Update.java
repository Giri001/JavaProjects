package eau;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			int eauid = Integer.parseInt(req.getParameter("eauid"));
			Employee employee = new Employee(
					req.getParameter("firstname")
					,req.getParameter("lastname")
					,req.getParameter("department")
					,Integer.parseInt(req.getParameter("year"))
					,req.getParameter("email")
					,req.getParameter("address")
					,req.getParameter("city")
					,req.getParameter("country")
					);
			
			Database.update(eauid, employee);
			
			res.sendRedirect("home");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
