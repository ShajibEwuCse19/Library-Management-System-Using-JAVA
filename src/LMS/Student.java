package LMS;

public class Student {
    private String name;
    private String id;
    private String address;
    private String password;

    public Student(String name, String id, String address, String password) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.password = password;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAddress() {
        return this.address;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Student Id: " + id);
        System.out.println("Address: " + address);
        System.out.println();
    }

    public void adminDisplay() {
        System.out.println("Name: " + name);
        System.out.println("Student Id: " + id);
        System.out.println("Address: " + address);
        System.out.println("Password: " + password);
        System.out.println();
    }
}
