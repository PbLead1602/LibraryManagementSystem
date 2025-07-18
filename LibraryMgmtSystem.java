package LibraryManagementApplication;

import java.util.*;

public class LibraryMgmtSystem {

	// creating the input object
	static Scanner sc = new Scanner(System.in);

	
	// creating the object of pojo classes
		static	User[] user = new User[100];
			
	static Book[] book = new Book[100];
	static Student[] stud = new Student[100];
	
	// creating the instances of each class
	
		static ValidateUserImp validator;
		static StudentRepository sr = new StudentRepository();
		static LibrarianRepository lr = new LibrarianRepository(user);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		// initializing books 
		book[0]= new Book("b1","ABC","P","AAA","isbn001",true);
		book[1]= new Book("b2","DC","M","CCC","isbn002",false);
		book[2]= new Book("b3","EER","Q","KKK","isbn003",true);

		//initalizing some students 
		
		validator = new ValidateUserImp(user,stud);
		
		while(true) {
			
			System.out.println("\n --------Welcome to Library Management System------------");
			System.out.println();
			System.out.println("To Login As Librarian/Admin   PRESS -------> 1");
			System.out.println("To Login AS Student           PRESS -------> 2");
			System.out.println("To exit from System           PRESS -------> 0");
			int input= sc.nextInt();
			sc.nextLine(); // consume newline
			
			switch (input) {
			case 1:
			case 2:
				System.out.print("Enter your Email: ");
				String email = sc.nextLine();

				System.out.print("Enter your Contact Number: ");
				String contact = sc.nextLine();

				User loggedInUser = validator.validateUser(email, contact);

				if (loggedInUser != null) {
				    if ("Librarian".equalsIgnoreCase(loggedInUser.getUserType())) {
				        librarianMenu();
				    } else if ("Student".equalsIgnoreCase(loggedInUser.getUserType())) {
				        // Find student by email
				        for (Student s : stud) {
				            if (s != null && s.getEmail().equalsIgnoreCase(email)) {
				                studentMenu(s); // pass the specific student
				                break;
				            }
				        }
				    }
				}
				 
				break;

			case 0:
				System.out.println("Exiting system. Goodbye!");
				return;
			default:
				System.out.println("Invalid option. Try again.");
			}
			
		}
      
     }

	static void librarianMenu() {
		
		while(true) {
				
			System.out.println("its librarian Repository!");
			System.out.println();
			
	        // Add librarian options
			
			System.out.println("Enter your choice :\n");
			System.out.println("1. To Add Books into Library");
			System.out.println("2. To Add Student as member of  Library");
			System.out.println("3. View All Books");
			System.out.println("4. View All students");
			System.out.println("5. To Search Student by its name");
			System.out.println("6. To Search book by its name");
			System.out.println("7. To Search students who issued book");
			System.out.println("8. To Get total Books count ");
			System.out.println("9. To Get Total Issued Books count ");
			System.out.println("10. To Get Available Books Count");
			System.out.println("To exit from system   PRESS -------> 0");
		
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					lr.addBook(book);
					break;
				
				case 2:
					lr.addStudent(stud);
					break;
				case 3:
					lr.viewAllBooks(book);
					break;
				case 4:
					lr.viewAllStudents(stud);
					break;
				case 5:
					lr.searchStudent(stud);
					break;
				case 6:
					lr.searchBook(book);
					break;
				case 7:
					lr.searchStudentsWithIssuedBooks(stud);
					break;
				case 8:
					lr.totalBooksCount(book);
					break;
				case 9:
					lr.totalIssuedBooksCount(book);
					break;
				case 10:
					lr.availableBooksCount(book);
					break;
				case 0:
	                System.out.println("Logging out...");
	                return; // go back to main menu
				default:
					System.out.println("Invalid Input!");
			}
		}
		
		
    }

	//student menu 
	public static void studentMenu(Student stud) {
	    while (true) {
	        System.out.println("\n--- Student Menu ---");
	        System.out.println("1. View Profile");
	        System.out.println("2. Edit Profile");
	        System.out.println("3. View All Books");
	        System.out.println("4. Issue a Book");
	        System.out.println("5. View Issued Books");
	        System.out.println("6. View Total Books Count");
	        System.out.println("7. View Available Books Count");
	        System.out.println("8. Return a Book");
	        System.out.println("0. Logout");
	        System.out.print("Enter your choice: ");
	        
	        int option = sc.nextInt();
	        sc.nextLine(); // consume newline
	        
	        switch (option) {
	            case 1:
	                sr.viewProfile(stud);
	                break;
	            case 2:
	                sr.editProfile(stud);
	                break;
	            case 3:
	                sr.viewAllBooks(book);
	                break;
	            case 4:
	                sr.issueBook(stud, book);
	                break;
	            case 5:
	                sr.viewIssuedBooks(stud);
	                break;
	            case 6:
	                sr.totalBooksCount(book);
	                break;
	            case 7:
	                sr.availableBooksCount(book);
	                break;
	            case 8:
	                sr.returnBook(stud);
	                break;
	            case 0:
	                System.out.println("Logging out...");
	                return;
	            default:
	                System.out.println("Invalid input. Please try again.");
	        }
	    }
	}


	
}
	
