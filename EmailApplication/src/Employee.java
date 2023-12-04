
public class Employee {
    // Class properties here
    private String firstName;
    private String secondName;
    private String password;
    private int deptCode;
    private String email;
    private CredentialManagerServiceImpl creds;

    // Default constructor
    public Employee(String firstName, String secondName, int deptCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.deptCode = deptCode;
        this.creds = new CredentialManagerServiceImpl();

        // Generate credentials
        CredentialManagerServiceImpl c = new CredentialManagerServiceImpl();
        this.email = c.generateEmailAddress(this.firstName, this.secondName, this.deptCode);
        this.password = c.generatePassword();
    }

    public void showCredetials() {
        System.out.println("============================================");
        System.out.println("Employee " + this.firstName + " credentials are:");
        System.out.println("\tEmail   : " + this.email);
        System.out.println("\tPassword: " + this.password);
        System.out.println("============================================");
    }
    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int deptCode() {
        return deptCode;
    }

    public void deptCode(int deptCode) {
        this.deptCode = deptCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
