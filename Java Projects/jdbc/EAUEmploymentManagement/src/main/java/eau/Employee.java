package eau;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/***
 * 
 * Employee class is a model for our data
 *
 */
public class Employee {
	private long eauid;
	private String firstName;
	private String lastName;
	private String department;
	private int joiningYear;
	private String email;
	private String address;
	private String city;
	private String country;
	public Employee(String firstName, String lastName, String department, int joiningYear, String email,
			String address, String city, String country) throws IOException {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningYear = joiningYear;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
	}
	
	
public Employee(long eauid, String firstName, String lastName, String department, int joiningYear, String email,
			String address, String city, String country) {
		super();
		this.eauid = eauid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.joiningYear = joiningYear;
		this.email = email;
		this.address = address;
		this.city = city;
		this.country = country;
	}


	@Override
public String toString() {
	return "Employee [eauId=" + eauid + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
			+ department + ", joiningYear=" + joiningYear + ", email=" + email + ", address=" + address + ", city="
			+ city + ", country=" + country + "]";
}


	public long getEauid() {
		return eauid;
	}

	public void setEauid(long eauid) {
		this.eauid = eauid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getJoiningYear() {
		return joiningYear;
	}

	public void setJoiningYear(int joiningYear) {
		this.joiningYear = joiningYear;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
