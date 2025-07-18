package LibraryManagementApplication;

public class User {

	//feilds
	
	String id;
	String name;
	String email;
	String contact;
	String userType;
	
	//constructor
	/**
	 * @param id
	 * @param name
	 * @param email
	 * @param contact
	 * @param userType
	 */
	public User(String id, String name, String email, String contact, String userType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.userType = userType;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}
