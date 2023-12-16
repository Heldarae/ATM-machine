import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance;
    private double savingBalance;
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    Scanner input = new Scanner(System.in);

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance) {
        this.checkingBalance = checkingBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public void setSavingBalance(double savingBalance) {
        this.savingBalance = savingBalance;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = checkingBalance - amount;
        return checkingBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = checkingBalance + amount;
        return checkingBalance;
    }

    public double calcSavingWithdraw(double amount) {
        savingBalance = savingBalance - amount;
        return savingBalance;
    }

    public double calcSavingDeposit(double amount) {
        savingBalance = savingBalance + amount;
        return savingBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
        System.out.print("Please enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking account balance: " + moneyFormat.format(getCheckingBalance()) + "\n");
        } else {
            System.out.println("Amount cannot be negative or greater than account balance!\n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Checking account balance: " + moneyFormat.format(getCheckingBalance()));
        System.out.print("Please enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking account balance: " + moneyFormat.format(getCheckingBalance()) + "\n");
        } else {
            System.out.println("Amount cannot be negative!\n");
        }
    }

    public void getSavingWithdrawInput() {
        System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
        System.out.print("Please enter the amount you want to withdraw: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New Saving account balance: " + moneyFormat.format(getSavingBalance()) + "\n");
        } else {
            System.out.println("Amount cannot be negative or greater than account balance!\n");
        }
    }

    public void getSavingDepositInput() {
        System.out.println("Saving account balance: " + moneyFormat.format(getSavingBalance()));
        System.out.print("Please enter the amount you want to deposit: ");
        double amount = input.nextDouble();

        if (amount >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New Saving account balance: " + moneyFormat.format(getSavingBalance()) + "\n");
        } else {
            System.out.println("Amount cannot be negative!\n");
        }
    }

}
