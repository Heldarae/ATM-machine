import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class MenuOptions extends Account {
    private int selection;
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(653486, 39740);
                data.put(743691, 241679);
                System.out.println("Welcome to ATM.");
                System.out.print("Please enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter your password: ");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Please enter valid character(s).");
                x = 2;
            }
            for (Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong customer number or password.\n");
        } while (x == 1);
    }

    private void getAccountType() {
        System.out.println("Please choose account type: ");
        System.out.println("1 - Checking Account");
        System.out.println("2 - Saving Account");
        System.out.println("3 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Exiting...");
                exit();
                break;
            default:
                System.out.println("\n" + "Invalid selection! \n");
                getAccountType();
        }
    }

    private void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("You have " + moneyFormat.format(getCheckingBalance()));
                getChecking();
                break;
            case 2:
                getCheckingWithdrawInput();
                getChecking();
                break;
            case 3:
                getCheckingDepositInput();
                getChecking();
                break;
            case 4:
                System.out.println("Exiting...");
                getAccountType();
                break;
            default:
                System.out.println("\n Invalid selection! \n");
                getChecking();
        }
    }

    private void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println("1 - View Balance");
        System.out.println("2 - Withdraw Funds");
        System.out.println("3 - Deposit Funds");
        System.out.println("4 - Exit");

        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("You have " + moneyFormat.format(getSavingBalance()));
                getSaving();
                break;
            case 2:
                getSavingWithdrawInput();
                getSaving();
                break;
            case 3:
                getSavingDepositInput();
                getSaving();
                break;
            case 4:
                System.out.println("Exiting...");
                getAccountType();
                break;
            default:
                System.out.println("\n Invalid selection! \n");
                getSaving();
        }
    }

    private void exit() {
        System.exit(1);
    }
}
