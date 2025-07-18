package LibraryManagementApplication;

import java.util.Arrays;

public class Librarian extends User{

	Book[] book;
	LibrarianRepository lr;
	
	//fields
	String designation;//eg(Admin , staff , supervisor)

	//constructor
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param contact
	 * @param userType
	 * @param book
	 * @param designation
	 */
	public Librarian(String id, String name, String email, String contact, String userType,
			String designation) {
		super(id, name, email, contact, userType);
		this.designation = designation;
	}

	
	//setters and getters
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Book[] getBook() {
		return book;
	}
	public void setBook(Book[] book) {
		this.book = book;
	}


	@Override
	public String toString() {
		return "Librarian [ id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", userType=" + userType+ ", designation=" + designation + " book=" + Arrays.toString(book) + "]";
	}


	
	
	
}
