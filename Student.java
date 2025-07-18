package LibraryManagementApplication;

import java.util.Arrays;

public class Student  extends User{
	Book[] book;
	
	//fields
	String deptname;
	String year;
	int bookcount=0;
	//constructor
	
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param contact
	 * @param userType
	 * @param deptname
	 * @param year
	 * @param book
	 * @param bookcount
	 */
	public Student(String id, String name, String email, String contact, String userType,  String deptname,
			String year, Book[] book,int maxBooks) {
		super(id, name, email, contact, userType);
		
		this.book = new Book[maxBooks];
		this.deptname = deptname;
		this.year = year;
		
	}

	//getters and setters 
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	public Book[] getBook() {
		return book;
	}

	public void setBook(Book[] book) {
		this.book = book;
	}


	
	 //to string method
	@Override
	public String toString() {
		return "Student [ id ="+id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", userType=" + userType + ", deptname=" + deptname + ", year=" + year +" , book=" + Arrays.toString(book) + "]";
	}
}
