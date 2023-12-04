import java.util.InputMismatchException;
import java.util.Random;

public class CredentialManagerServiceImpl implements ICredentialsManagerService{

    /**
     * @return
     */
    final String emailSuffix = ".greatlearning.com";

    String findDeptName(int deptCode) {
        String deptName;
        switch (deptCode) {
            case 1: deptName = "tech";
                break;
            case 2: deptName = "admin";
                break;
            case 3: deptName = "hr";
                break;
            case 4: deptName = "legal";
                break;
            default:
                throw new InputMismatchException("Unknown department provided");
        }
        return deptName;
    }

    private char getRandomLowercaesChar() {
        Random randomObj = new Random();
        return (char) (randomObj.nextInt(123-97) + 97);
    }

    private char getRandomUppercaesChar() {
        Random randomObj = new Random();
        return (char) (randomObj.nextInt(91-65) + 65);
    }

    private char getRandomNumberChar() {
        Random randomObj = new Random();
        return (char) (randomObj.nextInt(58-48) + 48);
    }

    private char getRandomSpecialChar() {
        Random randomObj = new Random();
        return (char) (randomObj.nextInt(65-58) + 58);
    }

    @Override
    public String generatePassword() {

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            Random randomObj = new Random();
            int tmp = randomObj.nextInt(5);
            switch (tmp) {
                case 1: password.append(getRandomLowercaesChar());
                    break;
                case 2: password.append(getRandomUppercaesChar());
                    break;
                case 3: password.append(getRandomNumberChar());
                    break;
                case 4: password.append(getRandomSpecialChar());
                    break;
            }
        }

        return password.toString();
    }

    /**
     * @param fname
     * @param lname
     * @param deptCode
     * @return
     */
    @Override
    public String generateEmailAddress(String fname, String lname, int deptCode) {
        fname = fname.replaceAll("\\s", "");
        lname = lname.replaceAll("\\s", "");
        return fname.toLowerCase() + "." + lname.toLowerCase() + "@" + findDeptName(deptCode) + emailSuffix;
    }
}
