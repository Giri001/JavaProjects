package eau;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/***
 * Database Class perform database functions like insertion, updation, deletion, and fetching 
 * data from database
 *
 */
public class Database {

//	Creating Connectioon object which helps us to connect database with mysql driver
	private static Connection createCon() throws ClassNotFoundException, SQLException{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/eaustaff";
			String user = "root";
			String password = "Mysql@9131";
			
			con = DriverManager.getConnection(url,user,password);			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}
	
//	insert() method helps us in data insertion to database
	public static boolean insert(Employee employee) throws ClassNotFoundException, SQLException {
		Connection con = createCon();
		try {
			String q = String.format("insert into staff (firstname, lastname,"
					+ " department, year, email, address, city, country) "
					+ "values('%s', '%s', '%s', %d, '%s', '%s', '%s', '%s')"
					,employee.getFirstName()
					,employee.getLastName()
					,employee.getDepartment()
					,employee.getJoiningYear()
					,employee.getEmail()
					,employee.getAddress()
					,employee.getCity()
					,employee.getCountry());
			
			Statement pstmt = con.createStatement();
			pstmt.executeUpdate(q);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	getById(int) helps us to get a Employee by a particular eauid
	public static Employee getById(int id) throws ClassNotFoundException, SQLException {
		Connection con = createCon();
		Employee employee = null;
		try {
			String q = String.format("select * from staff where eauid=%d",id);
			Statement pstmt = con.createStatement();
			ResultSet set = pstmt.executeQuery(q);
			set.next();
			employee = new Employee(
						set.getInt("eauid")
						,set.getString("firstname")
						,set.getString("lastname")
						,set.getString("department")
						,set.getInt("year")
						,set.getString("email")
						,set.getString("address")
						,set.getString("city")
						,set.getString("country")
						);
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return employee;	
	}
	
//	getAll() method gets all the user registered in database
	public static List<Employee> getAll() throws ClassNotFoundException, SQLException {
		Connection con = createCon();
		List<Employee> employees = new ArrayList<>();
		try {
			String q = "select * from staff";
			Statement pstmt = con.createStatement();
			ResultSet set = pstmt.executeQuery(q);
			
			while(set.next()) {
				Employee employee = new Employee(
						set.getInt("eauid")
						,set.getString("firstname")
						,set.getString("lastname")
						,set.getString("department")
						,set.getInt("year")
						,set.getString("email")
						,set.getString("address")
						,set.getString("city")
						,set.getString("country")
						);
				
				employees.add(employee);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return employees;
		}
		return employees;
	}
	
//	update(id,Employee) method helps us to update the data of database
	public static boolean update(int id, Employee employee) throws ClassNotFoundException, SQLException {
		Connection con = createCon();
	
		try {
			String q = String.format("update staff set "
					+ "firstname='%s'"
					+ ",lastname='%s'"
					+ ",department='%s'"
					+ ",year=%d"
					+ ",email='%s'"
					+ ",address='%s'"
					+ ",city='%s'"
					+ ",country='%s' where eauid=%d"
					,employee.getFirstName()
					,employee.getLastName()
					,employee.getDepartment()
					,employee.getJoiningYear()
					,employee.getEmail()
					,employee.getAddress()
					,employee.getCity()
					,employee.getCountry()
					,id
					);
			Statement pstmt = con.createStatement();
			pstmt.executeUpdate(q);
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
//	delete(int) method deletes an Employee record from database by eauid (primary key)
	public static boolean delete(int id) throws ClassNotFoundException, SQLException{
		Connection con = createCon();
		try {
			String q = String.format("delete from staff where eauid=%d",id);
			Statement pstmt = con.createStatement();
			pstmt.executeUpdate(q);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
