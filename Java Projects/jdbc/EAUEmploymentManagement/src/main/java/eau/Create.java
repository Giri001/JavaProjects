package eau;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * This servlet takes user data received from form
 * and crate a Employee object and insert the employee data to Database
 *
 */
@WebServlet("/create")
public class Create extends HttpServlet{
	
//	POST method to fetching the data from user form and persisting it to database
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
//			Creating Employee object with form data
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
			
//			Passing the employee data to Database.insert() method to persist data to DB
			Database.insert(employee);
			
//			After data has been successfully persisted we redirect the user to home page again
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
