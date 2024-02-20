package LMS;

public final class BookDataSource {
    public static void loadInitialBooks(LibraryManagementSystem lms) {
        lms.addBook("01", "Java Programming", "John Smith", "ABC Publications", "2020-01-03");
        lms.addBook("02", "Advanced Java Programming", "John Smith", "ABC Publications", "2021-02-15");
        lms.addBook("03", "Python Programming", "Emily Johnson", "XYZ Books", "2019-11-20");
        lms.addBook("04", "JavaScript Basics", "John Smith", "ABC Publications", "2018-06-10");
        lms.addBook("05", "Data Structures and Algorithms", "John Smith", "ABC Publications", "2017-09-05");
        lms.addBook("06", "Java Programming", "Alice Jones", "DEF Press", "2016-03-25");
        lms.addBook("07", "Advanced Java Programming", "John Doe", "GHI Publications", "2015-08-12");
        lms.addBook("08", "Python Programming", "Emily Johnson", "XYZ Books", "2014-04-30");
        lms.addBook("09", "Java Programming", "John Smith", "ABC Publications", "2013-10-18");
        lms.addBook("10", "Data Structures and Algorithms", "John Smith", "ABC Publications", "2012-12-01");

        lms.returnBook1("01");
        lms.returnBook1("02");
        lms.returnBook1("03");
        lms.returnBook1("04");
        lms.returnBook1("05");
        lms.returnBook1("06");
        lms.returnBook1("07");
        lms.returnBook1("08");
        lms.returnBook1("09");
        lms.returnBook1("10");
    }
}
