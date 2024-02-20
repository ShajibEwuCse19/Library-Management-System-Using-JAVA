package LMS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        LibraryManagementSystem lms = LibraryManagementSystem.getInstance();
        BookDataSource.loadInitialBooks(lms);
        StudentDataSource.loadInitialStudents(lms);
        Scanner scanner = new Scanner(System.in);
        lms.registerAdmin(new Admin("admin", "101", "101", "Dhaka", "101"));

        while (true) {
            System.out.println("--------------------Library Management System-----------------------");
            System.out.println("1. Student Registration (New Student)");
            System.out.println("2. Student Login ");
            System.out.println("3. Guest User");
            System.out.println("4. Librarian (Admin)");
            System.out.println("5. Exit from the application");
            System.out.print("Enter your choices: ");
            String input1 = scanner.nextLine();

            if (input1.equals("1")) {
                while (true) {
                    System.out.println("--------Student Registration-------------");
                    String name, id, address, password;
                    while (true) {
                        System.out.print("Name: ");
                        name = scanner.nextLine().trim();

                        if (name.isEmpty()) {
                            System.out.println("Name can't be empty.");
                            continue;
                        } else break;
                    }
                    while (true) {
                        System.out.print("Student Id: ");
                        id = scanner.nextLine().trim();

                        if (id.isEmpty()) {
                            System.out.println("Id can't be empty");
                            continue;
                        } else if (lms.checkStudentId(id)) {
                            System.out.println("You have entered another student's id. Enter your unique id.");
                            continue;
                        } else break;
                    }
                    while (true) {
                        System.out.print("Address: ");
                        address = scanner.nextLine().trim();

                        if (address.isEmpty()) {
                            System.out.println("Address can't be empty. Enter your address.");
                            continue;
                        } else break;
                    }
                    while (true) {
                        System.out.print("Password: ");
                        password = scanner.nextLine().trim();

                        if (password.isEmpty()) {
                            System.out.println("Password can't be empty. Enter password.");
                            continue;
                        } else if (password.contains(" ")) {
                            System.out.println("Password can't contain white space. Enter password again.");
                            continue;
                        } else if (password.length() < 6) {
                            System.out.println("Weak password. You need to provide minimum six digits password.");
                            continue;
                        } else break;
                    }
                    System.out.println("============>Registration Successful");
                    lms.registerStudent(new Student(name, id, address, password));
                    lms.viewProfile(id.trim());
                    break;
                }

            } else if (input1.equals("2")) {
                String id;
                while (true) {
                    System.out.println("-----------Login Page----------------");
                    String password;
                    while (true) {
                        System.out.print("Enter your id: ");
                        id = scanner.nextLine();

                        if (id.isEmpty()) {
                            System.out.println("Id can't be empty.");
                            continue;
                        } else break;
                    }
                    while (true) {
                        System.out.print("Enter your password: ");
                        password = scanner.nextLine();

                        if (password.contains(" ")) {
                            System.out.println("Password can't contain white space.");
                            continue;
                        } else if (password.isEmpty()) {
                            System.out.println("Password can't be empty.");
                            continue;
                        } else break;
                    }

                    if (lms.authenticateStudent(id, password)) {
                        System.out.println("================>Login Successful");
                        while (true) {
                            System.out.println("1. View Profile.");
                            System.out.println("2. Edit Profile.");
                            System.out.println("3. Delete Profile");
                            System.out.println("4. Search Book by Title.");
                            System.out.println("5. Search Book by Author.");
                            System.out.println("6. Search Book by Publisher.");
                            System.out.println("7. Book List.");
                            System.out.println("8. Author List.");
                            System.out.println("9. Publisher List.");
                            System.out.println("10. Checkout Book.");
                            System.out.println("11. Return Book.");
                            System.out.println("12. List of Checkout Books.");
                            System.out.println("13. Check Available Book Id [for checkout].");
                            System.out.println("14. Logout");
                            System.out.print("Enter your choice: ");
                            String input3 = scanner.nextLine();

                            if (input3.equals("14")) {
                                System.out.println("============>Program Terminated...");
                                break;
                            } else {
                                switch (input3) {
                                    case "1":
                                        System.out.println("------Your Profile-------");
                                        lms.viewProfile(id);
                                        break;
                                    case "2":
                                        System.out.println("------Edit Profile-------");
                                        System.out.println("Current Profile: ");
                                        lms.viewProfile(id);
                                        String editName, editAddress;
                                        while (true) {
                                            System.out.print("New name : ");
                                            editName = scanner.nextLine();

                                            if (editName.isEmpty()) {
                                                System.out.println("Name can't be empty.");
                                                continue;
                                            } else break;

                                        }
                                        while (true) {
                                            System.out.print("New Address: ");
                                            editAddress = scanner.nextLine();

                                            if (editAddress.isEmpty()) {
                                                System.out.println("Address can't be empty.");
                                                continue;
                                            } else break;
                                        }
                                        lms.updateProfile(editName, id, editAddress, password);
                                        break;
                                    case "3":
                                        System.out.println("------Delete Profile-------");
                                        lms.removeProfile(id);
                                        break;
                                    case "4":
                                        System.out.println("------Search Book by Title-------");
                                        String bookTitle;
                                        while (true) {
                                            System.out.print("Enter a book title: ");
                                            bookTitle = scanner.nextLine();
                                            if (bookTitle.isEmpty()) {
                                                System.out.println("Fields can't be empty. Back to choice list.");
                                                continue;
                                            } else break;
                                        }
                                        lms.searchBookByTitle(bookTitle);
                                        break;
                                    case "5":
                                        System.out.println("------Search Book by Author-------");
                                        String bookAuthor;
                                        while (true) {
                                            System.out.print("Enter a book title: ");
                                            bookAuthor = scanner.nextLine();
                                            if (bookAuthor.isEmpty()) {
                                                System.out.println("Fields can't be empty. Back to choice list.");
                                                continue;
                                            } else break;
                                        }
                                        lms.searchBookByAuthor(bookAuthor);
                                        break;
                                    case "6":
                                        System.out.println("------Search Book by Publisher-------");
                                        String bookPublisher;
                                        while (true) {
                                            System.out.print("Enter a book publisher name: ");
                                            bookPublisher = scanner.nextLine();
                                            if (bookPublisher.isEmpty()) {
                                                System.out.println("Fields can't be empty. Back to choice list.");
                                                continue;
                                            } else break;
                                        }
                                        lms.searchBookByPublisher(bookPublisher);
                                        break;
                                    case "7":
                                        System.out.println("------Book List-------");
                                        lms.bookList();
                                        break;
                                    case "8":
                                        System.out.println("------Author List-------");
                                        lms.authorList();
                                        break;
                                    case "9":
                                        System.out.println("------Publisher List-------");
                                        lms.publisherList();
                                        break;
                                    case "10":
                                        System.out.println("------Checkout Book-------");
                                        String checkoutId;
                                        while (true) {
                                            System.out.print("Collect a book id from librarian and enter the id : ");
                                            checkoutId = scanner.nextLine();
                                            if (checkoutId.isEmpty()) {
                                                System.out.println("Enter book id for checkout the book.");
                                                continue;
                                            } else break;
                                        }
                                        lms.checkoutBook(checkoutId, id);
                                        lms.searchBookByBookId(checkoutId);
                                        break;
                                    case "11":
                                        System.out.println("------Return Book-------");
                                        String returnId;
                                        while (true) {
                                            System.out.print("Enter book id: ");
                                            returnId = scanner.nextLine();
                                            if (returnId.isEmpty()) {
                                                System.out.println("Enter book id for return the book.");
                                                continue;
                                            } else break;
                                        }
                                        lms.returnBook(returnId);
                                        break;
                                    case "12":
                                        System.out.println("--------------Checkout Book List---------------");
                                        lms.checkoutBookList(id);
                                        break;
                                    case "13":
                                        System.out.println("--------------Available Book id list---------------");
                                        lms.availableBookId();
                                        break;
                                    default:
                                        System.out.println("Invalid Input");
                                }
                            }
                        }
                    } else {
                        System.out.println("Wrong Input. Try again.....l");
                    }
                    break;
                }
            } else if (input1.equals("3")) {
                System.out.println("-----------Guest Page----------------");
                while (true) {
                    System.out.println("1. Search Book by Title.");
                    System.out.println("2. Search Book by Author.");
                    System.out.println("3. Search Book by Publisher.");
                    System.out.println("4. Book List.");
                    System.out.println("5. Author List.");
                    System.out.println("6. Publisher List.");
                    System.out.println("7. Back to Home Page");
                    System.out.print("Enter your choice: ");
                    String guestChoice = scanner.nextLine();

                    if (guestChoice.equals("7")) break;
                    else {
                        switch (guestChoice) {
                            case "1":
                                System.out.println("------Search Book by Title-------");
                                String guestBookTitle;
                                while (true) {
                                    System.out.print("Enter a book title: ");
                                    guestBookTitle = scanner.nextLine();
                                    if (guestBookTitle.isEmpty()) {
                                        System.out.println("Fields can't be empty. Back to choice list.");
                                        continue;
                                    } else break;
                                }
                                lms.searchBookByTitle(guestBookTitle);
                                break;
                            case "2":
                                System.out.println("------Search Book by Author-------");
                                String guestBookAuthor;
                                while (true) {
                                    System.out.print("Enter a author name: ");
                                    guestBookAuthor = scanner.nextLine();
                                    if (guestBookAuthor.isEmpty()) {
                                        System.out.println("Fields can't be empty. Back to choice list.");
                                        continue;
                                    } else break;
                                }
                                lms.searchBookByAuthor(guestBookAuthor);
                                break;
                            case "3":
                                System.out.println("------Search Book by Publisher-------");
                                String guestBookPublisher;
                                while (true) {
                                    System.out.print("Enter a publisher name: ");
                                    guestBookPublisher = scanner.nextLine();
                                    if (guestBookPublisher.isEmpty()) {
                                        System.out.println("Fields can't be empty. Back to choice list.");
                                        continue;
                                    } else break;
                                }
                                lms.searchBookByPublisher(guestBookPublisher);
                                break;
                            case "4":
                                System.out.println("------Book List-------");
                                lms.bookList();
                                break;
                            case "5":
                                System.out.println("------Author List-------");
                                lms.authorList();
                                break;
                            case "6":
                                System.out.println("------Publisher List-------");
                                lms.publisherList();
                                break;
                            default:
                                System.out.println("------------Invalid Choice--------------");
                        }
                    }
                }
            } else if (input1.equals("4")) {
                System.out.println("------------------Admin Page-------------");
                String adminId, adminPass;
                while (true) {
                    System.out.print("Enter Employee Id: ");
                    adminId = scanner.nextLine();
                    if (adminId.isEmpty()) {
                        System.out.println("Id can't be empty.");
                        continue;
                    } else break;
                }
                while (true) {
                    System.out.print("Enter Password: ");
                    adminPass = scanner.nextLine();

                    if (adminPass.isEmpty()) {
                        System.out.println("Password can't be empty.");
                        continue;
                    } else break;
                }

                if (lms.authenticatedAdmin(adminId, adminPass)) {
                    System.out.println("=============> Login Successful...");
                    while (true) {
                        System.out.println("1. Create and add new book.");
                        System.out.println("2. Modify Existing book.");
                        System.out.println("3. Remove book.");
                        System.out.println("4. Add new user.");
                        System.out.println("5. Remove user.");
                        System.out.println("6. User information (Confidential).");
                        System.out.println("7. Book information (Confidential).");
                        System.out.println("8. Student List (Borrower)");
                        System.out.println("9. Logout");
                        System.out.print("Enter your choice: ");
                        String adminChoice = scanner.nextLine();

                        if (adminChoice.equals("9")) {
                            System.out.println("===========> Logout Successful.......");
                            break;
                        } else {
                            switch (adminChoice) {
                                case "1":
                                    System.out.println("-----------Create and add new book--------------");
                                    String bookId, bookTitle, bookAuthor, bookPublisher, dateString;
                                    while (true) {
                                        System.out.print("Book Id: ");
                                        bookId = scanner.nextLine();

                                        if (bookId.isEmpty()) {
                                            System.out.println("Id can't be empty.");
                                            continue;
                                        } else if (lms.checkBookId(bookId)) {
                                            System.out.println("This  id is available for another book. Enter an unique id.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Book Title: ");
                                        bookTitle = scanner.nextLine();
                                        if (bookTitle.isEmpty()) {
                                            System.out.println("Title can't be empty.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Author name: ");
                                        bookAuthor = scanner.nextLine();
                                        if (bookAuthor.isEmpty()) {
                                            System.out.println("Author name can't be empty.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Book Publisher: ");
                                        bookPublisher = scanner.nextLine();

                                        if (bookPublisher.isEmpty()) {
                                            System.out.println("Publisher can't be empty.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Enter date in format (yyyy-MM-dd): ");
                                        dateString = scanner.nextLine();

                                        if (dateString.isEmpty()) {
                                            System.out.println("Date field can't be empty.");
                                            continue;
                                        }
                                        boolean dateCheck = lms.addBook(bookId.trim(), bookTitle, bookAuthor, bookPublisher, dateString);
                                        if (dateCheck) {
                                            lms.returnBook1(bookId);
                                            System.out.println("============> Book Added Successfully...");
                                            lms.searchBookByTitle(bookTitle);
                                        } else continue;
                                        break;
                                    }
                                    break;
                                case "2":
                                    System.out.println("---------------Modify Existing book-------------------");
                                    String bookId1, bookTitle1, bookAuthor1, bookPublisher1, updateDateString;
                                    while (true) {
                                        System.out.print("Book Id: ");
                                        bookId1 = scanner.nextLine();

                                        if (bookId1.isEmpty()) {
                                            System.out.println("Book id can't be empty.");
                                            continue;
                                        }
                                        if (!lms.checkBookId(bookId1)) {
                                            System.out.println("There is no book using this id. Enter valid id.");
                                            continue;
                                        }
                                        break;
                                    }
                                    while (true) {
                                        System.out.print("Book Title: ");
                                        bookTitle1 = scanner.nextLine();

                                        if (bookTitle1.isEmpty()) {
                                            System.out.println("Title can't be empty.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Author name: ");
                                        bookAuthor1 = scanner.nextLine();

                                        if (bookAuthor1.isEmpty()) {
                                            System.out.println("You need to enter an author name.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Book Publisher: ");
                                        bookPublisher1 = scanner.nextLine();

                                        if (bookPublisher1.isEmpty()) {
                                            System.out.println("You need to enter a publisher name.");
                                            continue;
                                        } else break;
                                    }

                                    while (true) {
                                        System.out.print("Enter date in format (yyyy-MM-dd): ");
                                        updateDateString = scanner.nextLine();

                                        if (updateDateString.isEmpty()) {
                                            System.out.println("Date can't be empty.");
                                            continue;
                                        }
                                        boolean editBook = lms.updateBook(bookId1.trim(), bookTitle1, bookAuthor1, bookPublisher1, updateDateString);
                                        if (!editBook) continue;
                                        break;
                                    }
                                    lms.searchBookByTitle(bookTitle1);
                                    break;
                                case "3":
                                    System.out.println("-------------Remove book--------------------");
                                    System.out.print("Enter a book id: ");
                                    String bookIds = scanner.nextLine();
                                    if (bookIds.isEmpty()) {
                                        System.out.println("Fields can't be empty. Back to choice list.");
                                        continue;
                                    }
                                    lms.removeBook(bookIds);
                                    break;
                                case "4":
                                    System.out.println("--------------Add new user----------------");
                                    String name, id, address, password;
                                    while (true) {
                                        System.out.print("Name: ");
                                        name = scanner.nextLine();

                                        if (name.isEmpty()) {
                                            System.out.println("Name can't be empty.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Student Id: ");
                                        id = scanner.nextLine();

                                        if (id.isEmpty()) {
                                            System.out.println("Id can't be empty");
                                            continue;
                                        } else if (lms.checkStudentId(id)) {
                                            System.out.println("You have entered another student's id. Enter your unique id.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Address: ");
                                        address = scanner.nextLine();

                                        if (address.isEmpty()) {
                                            System.out.println("Address can't be empty. Enter your address.");
                                            continue;
                                        } else break;
                                    }
                                    while (true) {
                                        System.out.print("Password: ");
                                        password = scanner.nextLine();

                                        if (password.isEmpty()) {
                                            System.out.println("Password can't be empty. Enter password.");
                                            continue;
                                        } else if (password.contains(" ")) {
                                            System.out.println("Password can't contain white space. Enter password again.");
                                            continue;
                                        } else if (password.length() < 6) {
                                            System.out.println("You need to provide minimum 6 digits password.");
                                            continue;
                                        } else break;
                                    }
                                    System.out.println("============>User Added Successfully...");
                                    lms.registerStudent(new Student(name, id.trim(), address, password));
                                    break;
                                case "5":
                                    System.out.println("--------------Remove user---------------");
                                    String userId;
                                    while (true) {
                                        System.out.print("Enter a user id: ");
                                        userId = scanner.nextLine();
                                        if (userId.isEmpty()) {
                                            System.out.println("You need to enter user id.");
                                            continue;
                                        } else break;
                                    }
                                    lms.removeProfile(userId);
                                    break;
                                case "6":
                                    System.out.println("-----------Confidential user information-------------------");
                                    lms.studentInfo();
                                    break;
                                case "7":
                                    System.out.println("-----------Confidential Book information-------------------");
                                    lms.bookList();
                                    break;
                                case "8":
                                    System.out.println("-----------Student List who checked out books-------------------");
                                    lms.borrowerStudent();
                                    break;
                                default:
                                    System.out.println("-----------------------Invalid Choice---------------");
                            }
                        }
                    }
                } else {
                    if (adminPass.contains(" ")) {
                        System.out.println("Password can't contain white space");
                    } else System.out.println("---------------Invalid id or password---------------");
                }
            } else if (input1.equals("5")) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("----------Invalid Input--------------");
            }
        }
    }
}
