package LibraryManagementApplication;

import java.util.Scanner;

public class StudentRepository {
    Scanner sc = new Scanner(System.in);

    // View student profile
    public void viewProfile(Student stud) {
        System.out.println("------ Student Profile ------");
        System.out.println("ID: " + stud.getId());
        System.out.println("Name: " + stud.getName());
        System.out.println("Email: " + stud.getEmail());
        System.out.println("Contact: " + stud.getContact());
        System.out.println("Department: " + stud.getDeptname());
        System.out.println("Year: " + stud.getYear());
        System.out.println("-----------------------------");
    }

    // Edit student profile
    public void editProfile(Student stud) {
        while (true) {
            System.out.println("Edit Profile:");
            System.out.println("1. Edit ID");
            System.out.println("2. Edit Name");
            System.out.println("3. Edit Email");
            System.out.println("4. Edit Contact");
            System.out.println("5. Edit Department");
            System.out.println("6. Edit Year");
            System.out.println("0. Exit Editing");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new ID: ");
                    stud.setId(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Enter new Name: ");
                    stud.setName(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Enter new Email: ");
                    stud.setEmail(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Enter new Contact: ");
                    stud.setContact(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter new Department: ");
                    stud.setDeptname(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter new Year: ");
                    stud.setYear(sc.nextLine());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid Input!");
            }

            System.out.println("Profile updated successfully!\n");
        }
    }

    // View all library books
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

    // View available book count
    public void availableBooksCount(Book[] books) {
        int count = 0;
        for (Book b : books) {
            if (b != null && b.isAvailable()) {
                count++;
            }
        }
        System.out.println("Available books for issuing: " + count);
    }

    // View total book count
    public void totalBooksCount(Book[] book) {
        int totalbookcount = 0;
        for (Book b : book) {
            if (b != null) {
                totalbookcount++;
            }
        }
        System.out.println("Total books in library: " + totalbookcount);
    }

    // Issue book
    public void issueBook(Student student, Book[] books) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Book Name to Issue: ");
        String bookName = sc.nextLine();

        for (Book b : books) {
            if (b != null && b.getName().equalsIgnoreCase(bookName)) {
                if (!b.isStatus()) {
                    // Mark book as issued
                    b.setStatus(true);

                    // Assign to student
                    for (int i = 0; i < student.getBook().length; i++) {
                        if (student.getBook()[i] == null) {
                            student.getBook()[i] = b;
                            System.out.println("Book '" + b.getName() + "' issued successfully to " + student.getName());
                            return;
                        }
                    }

                    System.out.println("You have reached your maximum book issuing limit.");
                    return;
                } else {
                    System.out.println("Book is already issued to someone else.");
                    return;
                }
            }
        }

        System.out.println("Book not found.");
    }

    // View issued books
    public void viewIssuedBooks(Student stud) {
        System.out.println("Books you have issued:");
        boolean found = false;
        for (Book b : stud.getBook()) {
            if (b != null) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("You haven't issued any books.");
        }
    }

    // Return book
    public void returnBook(Student stud) {
        System.out.print("Enter the book name to return: ");
        String returnBookName = sc.nextLine();

        for (int i = 0; i < stud.getBook().length; i++) {
            Book b = stud.getBook()[i];
            if (b != null && b.getName().equalsIgnoreCase(returnBookName)) {
                b.setStatus(false); // mark as available
                stud.getBook()[i] = null;
                System.out.println("Book returned successfully.");
                return;
            }
        }

        System.out.println("You have not issued this book.");
    }
}
