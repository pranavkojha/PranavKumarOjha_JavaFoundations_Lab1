import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static String getName(String type) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + type + " name of Employee");
        return (String) sc.nextLine();
    }

    private static int getDeptCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee's department");
        System.out.println("1. Technical");
        System.out.println("2. Admin");
        System.out.println("3. Human Resource");
        System.out.println("4. Legal");
        System.out.println("Choose between 1 to 4: ");
        return (int) sc.nextInt();
    }
    public static void main(String[] args) {
        int choice = 1;
        do {
            String fName = getName("First");
            String lName = getName("Second");
            int deptCode = getDeptCode();

            Employee e = new Employee(fName, lName, deptCode);
            e.showCredetials();
            System.out.println("Continue?");
            System.out.println("Press 1 to continue or 0 to exit...");
            Scanner sc = new Scanner(System.in);
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException ime) {
                choice = 3;
            }
        } while(choice==1);
        System.out.println("Thank you, exiting...");
    }
}