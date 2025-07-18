package LibraryManagementApplication;

public class ValidateUserImp implements ValidateUser {

    User[] user = new User[100];
    Student[] stud = new Student[100];

    /**
     * Constructor
     */
    public ValidateUserImp(User[] user, Student[] stud) {
        this.user = user;
        this.stud = stud;
    }

    @Override
    public User validateUser(String email, String contact) {
        int userIndex = 0;
        int studentIndex = 0;

        // Hardcoded data
        user[userIndex++] = new Librarian("L01", "Admin User", "admin@gmail.com", "8888444422", "Librarian", "admin");
        user[userIndex++] = new Librarian("L02", "Library Staff", "admin@gmail.com", "8888444422", "Librarian", "staff");

        Student s1 = new Student("Fy01", "Amit", "amit@gmail.com", "9999999999", "Student", "CS", "1st", null, 3);
        Student s2 = new Student("Fy02", "Gopal", "gopal@gmail.com", "7878787878", "Student", "Mech", "1st", null, 3);

        stud[studentIndex++] = s1;
        user[userIndex++] = s1;

        stud[studentIndex++] = s2;
        user[userIndex++] = s2;

        // Validate login
        for (User u : user) {
            if (u == null) continue;

            if (u.getEmail().equals(email) && u.getContact().equals(contact)) {
                System.out.println("\n \n Login successful!" + "\n  Name: " + u.getName() + "\n");
                return u;
            }
        }

        // If no match found
        System.out.println("\nInvalid username or password.\n");
        return null;
    }
}
