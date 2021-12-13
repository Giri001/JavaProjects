package eau;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/getbyid")
public class GetById extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
			int id = Integer.parseInt(req.getParameter("eauid"));
			Employee employee = Database.getById(id);
			Employee[] employeeArr = {employee};
			HttpSession session = req.getSession(true);
			session.setAttribute("employeeArr", employeeArr);
			
			req.getRequestDispatcher("index.jsp").forward(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
