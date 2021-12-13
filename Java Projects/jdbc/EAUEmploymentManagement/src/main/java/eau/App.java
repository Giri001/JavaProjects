package eau;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/***
 * This class serves our homepage with all the user data available in our
 * database table named staff
 *
 */
@WebServlet("/home")
public class App extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try {
//		 	Here we get List<Employee> from the Database
			List<Employee> employeeList = Database.getAll();
			
//			Converstion of List<Employee> -> Employee[]
			Employee[] employeeArr = listToArray(employeeList);
			
//			getting current session 
			HttpSession session = req.getSession(true);
			
//			putting the Employee[] to current session
			session.setAttribute("employeeArr", employeeArr);

//			Rendering index.jsp page to show the data to user
			req.getRequestDispatcher("index.jsp").forward(req, res);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
//	This method converts List<Employee> -> Employee[]
	static Employee[] listToArray(List<Employee> employeeList) {
		Employee[] employeeArr = new Employee[employeeList.size()];
		for(int i=0;i<employeeList.size();i++) {
			employeeArr[i] = employeeList.get(i);
		}
		return employeeArr;
	}
	
}
