package LMS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LibraryManagementSystem {
    private final List<Book> books = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Admin> admins = new ArrayList<>();
    private final HashMap<String, Boolean> bookAvailability = new HashMap<>();
    private final HashMap<String, Student> checkoutStudentList = new HashMap<>();

    private static LibraryManagementSystem instance;

    private LibraryManagementSystem() {
        //instance = new LibraryManagementSystem();
    }

    public static LibraryManagementSystem getInstance() {
        if (instance == null) {
            instance = new LibraryManagementSystem();
        }
        return instance;
    }

    //--------------------------Books Methods-------- ----------------------------
    public void checkoutBook(String id, String student_id) {
        Boolean availability = bookAvailability.get(id);
        if (availability != null) {
            if (bookAvailability.get(id) || bookAvailability.isEmpty()) {
                bookAvailability.put(id, false);
                for (Student student : students) {
                    if (student.getId().equals(student_id)) {
                        checkoutStudentList.put(id, student);
                        break;
                    }
                }
                System.out.println("You have successfully checkout the book with id " + id);
                return;
            }
        }

        if (availability != null) {
            for (Book book : books) {
                if (book.getId().equals(id)) {
                    System.out.println("This book is not available for checkout. You can collect another id from the librarian...");
                    return;
                }
            }
        }

        System.out.println("This book is not available in our library right now........");
    }

    public void returnBook1(String id) {
        bookAvailability.put(id, true);
    }

    public void returnBook(String id) {
        for (Book book : books) {
            if (book.getId().equals(id) && bookAvailability.get(id) != null && !bookAvailability.get(id)) {
                bookAvailability.put(id, true);
                System.out.println("Thank you for return the book.....");
                System.out.println("============> Book Information");
                book.display();
                if (checkoutStudentList.get(id) != null && !checkoutStudentList.isEmpty())
                    checkoutStudentList.remove(id);
                return;
            }
        }
        for (Book book : books) {
            if (book.getId().equals(id)) {
                System.out.println("This book is available in the library. You have entered a wrong book id.");
                return;
            }
        }
        System.out.println("You have entered a wrong book id........");
    }

    public boolean addBook(String id, String title, String author, String publisher, String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try {
            Date publishedDate = dateFormat.parse(date);
            books.add(new Book(id, title, author, publisher, publishedDate));
        } catch (ParseException e) {
            System.out.println("Wrong format of date. Please use yyyy-MM-dd format.");
            return false;
        }
        return true;
    }

    public boolean updateBook(String id, String title, String author, String publisher, String date) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            if (book.getId().equals(id)) {
                it.remove();
                break;
            }
        }
        boolean ret = addBook(id, title, author, publisher, date);
        if (ret) {
            System.out.println("============> book updated successfully...");
            return true;
        } else System.out.println("Can't update because of wrong date format.");
        return false;
    }

    public void removeBook(String id) {
        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book book = it.next();

            if (book.getId().equals(id)) {
                it.remove();
                break;
            }
        }
    }

    public void bookList() {
        for (Book book : books) {
            book.display();
        }
    }

    public void authorList() {
        int x = 1;
        for (Book book : books) {
            System.out.println(x + ". " + book.getAuthor());
            x++;
        }
        System.out.println();
    }

    public void publisherList() {
        int x = 1;
        for (Book book : books) {
            System.out.println(x + ". " + book.getPublisher());
            x++;
        }
        System.out.println();
    }

    public boolean checkBookId(String id) {
        for (Book book : books) {
            if (book.getId().equals(id)) return true;
        }
        return false;
    }

    public void searchBookByBookId(String id) {
        boolean flag = false;
        for (Book book : books) {
            if (book.getId().equals(id)) {
                System.out.println("============> Book Information");
                book.display();
                flag = true;
                return;
            }
        }
    }

    public void searchBookByTitle(String title) {
        boolean flag = false;
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("----------------This book is not available-----------");
        }
    }

    public void searchBookByAuthor(String author) {
        boolean flag = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                book.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("----------------There is no book of this author-----------");
        }
    }

    public void searchBookByPublisher(String publisher) {
        boolean flag = false;
        for (Book book : books) {
            if (book.getPublisher().equals(publisher)) {
                book.display();
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("----------------There is no book of this publisher-----------");
        }
    }
    public void availableBookId() {
        int total = 0;
        System.out.print("Book Id List: ");
        for(Book book: books) {
            if(bookAvailability.get(book.getId()) == null || !bookAvailability.get(book.getId())) continue;
            else {
                System.out.print(book.getId() + "  ");
                total++;
            }
        }
        System.out.println("\nTotal Available Books for checkout: " + total);
    }

    //-------------------------Student Methods------------------------
    public void registerStudent(Student student) {
        students.add(student);
    }

    public boolean authenticateStudent(String id, String pass) {
        for (Student student : students) {
            if (student.getId().equals(id) && student.getPassword().equals(pass)) return true;
        }
        return false;
    }

    public void viewProfile(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.display();
                return;
            }
        }
        System.out.println("=========>Invalid id\n");
    }

    public void studentInfo() {
        for (Student student : students) {
            student.adminDisplay();
        }
    }

    public void updateProfile(String name, String id, String address, String password) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.getId().equals(id)) {
                it.remove();
                break;
            }
        }
        registerStudent(new Student(name, id, address, password));
        System.out.println("===========>Profile updated....");
        return;
    }

    public void removeProfile(String id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student student = it.next();
            if (student.getId().equals(id)) {
                it.remove();
                System.out.println("===========>Profile removed...\n");
                return;
            }
        }
    }

    public boolean checkStudentId(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) return true;
        }
        return false;
    }

    public void borrowerStudent() {
        if (bookAvailability.isEmpty()) {
            System.out.println("No students checked out books yet.");
            return;
        }
        for (String key : checkoutStudentList.keySet()) {
            Student student = checkoutStudentList.get(key);
            student.adminDisplay();
            searchBookByBookId(key);
            System.out.println("==========================================================================================");
        }
    }

    public void checkoutBookList(String studentId) {
        boolean flag = false;
        int totalBook = 0;
        for (String key : checkoutStudentList.keySet()) {
            Student student = checkoutStudentList.get(key);

            if (student.getId().equals(studentId)) {
                searchBookByBookId(key);
                totalBook++;
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("There is no book checked out by you.");
        } else System.out.println("Total books: " + totalBook);
    }

    //-------------------------Admin Methods--------------------------
    public void registerAdmin(Admin admin) {
        admins.add(admin);
    }

    public boolean authenticatedAdmin(String id, String pass) {
        for (Admin admin : admins) {
            if (admin.getEmployeeId().equals(id) && admin.getPassword().equals(pass)) return true;
        }
        return false;
    }

}
