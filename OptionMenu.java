package com.java.whistler;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private int selection;
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();
    public void getLogin(){
        int x = 1;
        do {
            try {
                data.put(9876543, 9876);
                data.put(8989898, 1890);

                System.out.println("Welcome To The ATM Project!");
                System.out.print("Enter Your Customer Number : ");
                setCustomerNumber(menuInput.nextInt());
                System.out.print("Enter Your PIN Number : ");
                setPinNumber(menuInput.nextInt());

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(S). Only Numbers." + "\n");
                x=2;
            }
            for (Map.Entry<Integer, Integer>entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
        }while (x == 1);
    }
    public void getAccountType(){

        System.out.println("Select Account You Want To Access : ");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.print("Choice : ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("Thank You For using this ATM, Bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account : ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice : ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
            case 4:
                System.out.println("Thank You For using this ATM, Bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getChecking();
        }
    }
    public void getSaving(){
        System.out.print("Saving Account : ");
        System.out.print("Type 1 - View Balance");
        System.out.print("Type 2 - Withdraw Funds");
        System.out.print("Type 3 - Deposit Funds");
        System.out.print("Type 4 - Exit");
        System.out.print("Choice : ");
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank You For using this ATM, Bye.");
                break;
            default:
                System.out.println("\n" + "Invalid Choice" + "\n");
                getSaving();
        }
    }

}
