package LMS;

public class Admin {
    private String name;
    private String employeeId;
    private String contact;
    private String address;
    private String password;

    public Admin(String name, String employeeId, String contact, String address, String password) {
        this.name = name;
        this.employeeId = employeeId;
        this.address = address;
        this.contact = contact;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}
