package LibraryManagementApplication;

public class Book {

	//fields
	String id,name,author,subject,isbn;
	boolean status;
;
	
	
	//constructor
	/**
	 * @param id
	 * @param name
	 * @param author
	 * @param subject
	 * @param isbn
	 * @param status
	 */
	public Book(String id, String name, String author, String subject, String isbn,boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.isbn = isbn;
		this.status = status;
	}


	// NEW constructor with default status
	public Book(String id, String name, String author, String subject, String isbn) {
	    this(id, name, author, subject, isbn, false); // default: available
	}


	//setters and getters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public boolean isAvailable() {
	    return !status; // true means available
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", subject=" + subject + ", isbn=" + isbn
				+ "]";
	}

}
