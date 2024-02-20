package LMS;

public class StudentDataSource {
    public static void loadInitialStudents(LibraryManagementSystem lms) {
        lms.registerStudent(new Student("John Doe", "101", "123 Main St", "101"));
        lms.registerStudent(new Student("John Doe", "S001", "123 Main St", "password123"));
        lms.registerStudent(new Student("Alice Smith", "S002", "456 Elm St", "password456"));
        lms.registerStudent(new Student("Bob Johnson", "S003", "789 Oak St", "password789"));
        lms.registerStudent(new Student("Emily Brown", "S004", "321 Pine St", "password321"));
        lms.registerStudent(new Student("Michael White", "S005", "654 Maple St", "password654"));
        lms.registerStudent(new Student("Emma Lee", "S006", "987 Cedar St", "password987"));
        lms.registerStudent(new Student("Sophia Jones", "S007", "135 Walnut St", "password135"));
        lms.registerStudent(new Student("William Taylor", "S008", "246 Birch St", "password246"));
        lms.registerStudent(new Student("Olivia Clark", "S009", "579 Spruce St", "password579"));
        lms.registerStudent(new Student("Daniel Martinez", "S010", "864 Fir St", "password864"));
    }
}
