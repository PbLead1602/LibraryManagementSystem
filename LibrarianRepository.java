package LibraryManagementApplication;

import java.util.Scanner;

public class LibrarianRepository {
		StudentRepository sr;
		Librarian librarian;
		ValidateUserImp validator;
		
		Scanner sc= new Scanner(System.in);
		
		
		int bookcount=0;
		
		User[] users;

		public LibrarianRepository(User[] users) {
		    this.users = users;
		}

		
		//to Add new book to library
		public void addBook(Book[] books) {
		    
		    System.out.print("Enter Book ID: (eg..b1 , b2 ) : ");
		    String id = sc.nextLine();
		    System.out.print("Enter Book Name: ");
		    String name = sc.nextLine();
		    System.out.print("Enter Author: ");
		    String author = sc.nextLine();
		    System.out.print("Enter Subject: ");
		    String subject = sc.nextLine();
		    System.out.print("Enter ISBN: (eg.. isbn01 ,isbn01) :");
		    String isbn = sc.nextLine();

		    Book newBook = new Book(id, name, author, subject, isbn); // status = false by default

		    for (int i = 0; i < books.length; i++) {
		        if (books[i] == null) {
		            books[i] = newBook;
		            System.out.println("Book added successfully.");
		            return;
		        }
		    }

		    System.out.println("Library is full. Cannot add more books.");
		}

		//to add new Student in system 
		public void addStudent(Student[] stud) {
		    System.out.println("\n---Add new Student--- \n");

		    System.out.println("Enter Id: ");
		    String id = sc.nextLine();
		    System.out.println("Enter Name: ");
		    String name = sc.nextLine();
		    System.out.println("Enter Email: ");
		    String email = sc.nextLine();
		    System.out.println("Enter Contact Number: ");
		    String contact = sc.nextLine();
		    System.out.println("Enter Department: ");
		    String dept = sc.nextLine();
		    System.out.println("Enter Year: ");
		    String year = sc.nextLine();

		    int maxBooks = 3;
		    Book[] emptyBooks = new Book[maxBooks];

		    Student newStudent = new Student(id, name, email, contact, "Student", dept, year, emptyBooks, maxBooks);

		    // Add to Student[]
		    for (int i = 0; i < stud.length; i++) {
		        if (stud[i] == null) {
		            stud[i] = newStudent;
		            System.out.println("Student Added Successfully...");

		            // ✅ Add to User[]
		            for (int j = 0; j < users.length; j++) {
		                if (users[j] == null) {
		                    users[j] = newStudent; // Student is a subclass of User
		                    break;
		                }
		            }

		            return;
		        }
		    }

		    System.out.println("Student list is full. Cannot add more students.");
		}

		
		//to viewAll books 
		public static void viewAllBooks(Book[] books) {
		    System.out.println("------ Books List ------");
		    boolean found = false;

		    for (Book book : books) {
		        if (book != null) {
		            System.out.println(book);
		            found = true;
		        }
		    }

		    if (!found) {
		        System.out.println("No books found in the library.");
		    }
		}

		//view All student 
		public static void viewAllStudents(Student[] stud) {
		    System.out.println("------ Students List ------");
		    boolean found = false;

		    for (Student s:stud) {
		        if (s != null) {
		            System.out.println(s);
		            found = true;
		        }
		    }

		    if (!found) {
		        System.out.println("No Student registerd as a member of library.");
		    }
		}

		//to search the student
		public void searchStudent(Student[] stud) {
			// TODO Auto-generated method stub
			
			System.out.println("Search Student... ");
			System.out.println("enter student name : ");
			String findname=sc.nextLine();
			
			boolean found = false;
			
			for(int i=0;i<stud.length;i++)
			{
				if (stud[i]!=null && stud[i].getName().equalsIgnoreCase(findname))
				{
					System.out.println("Student found:\n");
		            System.out.println(stud[i]);
		            found = true;
		            return;
				}
			}
			if (!found) {
		        System.out.println("No student found with the name:\n " + findname);
		    }
		}

		// to search the books
		public void searchBook(Book[] book) {
			// TODO Auto-generated method stub
			System.out.println("Search Book... ");
			System.out.println("enter Book name : ");
			String findbook=sc.nextLine();
			
			boolean found = false;
			
			for(int i=0;i<book.length;i++)
			{
				if (book[i]!=null && book[i].getName().equalsIgnoreCase(findbook))
				{
					System.out.println("Book found:\n");
		            System.out.println(book[i]);
		            found = true;
		            return;
				}
			}
			if (!found) {
		        System.out.println("No Book found with the name:\n " + findbook);
		    }
		}

		//total book count
		public void totalBooksCount(Book[] book) {
			// TODO Auto-generated method stub
			
			int totalbookcount=0;
			for(Book b:book)
			{
				if(b!= null)
				{
					totalbookcount++;
					
				}
			}
			System.out.println("Total books in library: " + totalbookcount);
		}

		//searchig student who isued book
		public void searchStudentsWithIssuedBooks(Student[] students) {
		    System.out.println("---- Students Who Issued Books ----");
		    boolean found = false;

		    for (Student s : students) {
		        if (s != null) {
		            Book[] issuedBooks = s.getBook();
		            boolean studentHasBooks = false;

		            for (Book b : issuedBooks) {
		                if (b != null) {
		                    if (!studentHasBooks) {
		                        System.out.println(s.getName() + " has issued:");
		                        studentHasBooks = true;
		                        found = true;
		                    }
		                    System.out.println("  → " + b.getName());
		                }
		            }
		        }
		    }

		    if (!found) {
		        System.out.println("No students have issued books.");
		    }
		}


		// serch to tal no of issued count 
		public void totalIssuedBooksCount(Book[] books) {
		    int count = 0;
		    for (Book b : books) {
		        if (b != null && b.isStatus()) {  // Book is issued
		            count++;
		        }
		    }
		    System.out.println("Total issued books: " + count);
		}

		
		//find total no of avialable books count
		public void availableBooksCount(Book[] books) {
		    int count = 0;
		    for (Book b : books) {
		        if (b != null && !b.isStatus()) {  // Book is available
		            count++;
		        }
		    }
		    System.out.println("Total available books: " + count);
		}


		
}
