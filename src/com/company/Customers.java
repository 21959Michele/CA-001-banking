package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Customers extends Accounts{
    Scanner sc = new Scanner(System.in);

    public static void check(String firstName, String lastName, String accountCode, String customerPinNumber) throws IOException{

        String getFName = firstName;
        String getLName = lastName;
        String gAccountCode = accountCode;
        String gPinNumber = customerPinNumber;
        File(gAccountCode);

        checkCustomer(getFName, getLName, gAccountCode, gPinNumber);
    }

    public static void checkCustomer(String getFName, String getLName, String gAccountCode, String gPinNumber) throws IOException{

        String firstName = "";
        String lastName = "";
        String accountCode = "";
        String pinNumber = "";
        String eMail = "";
        double currentBalance = 0.0;
        double savingBalance = 0.0;

        File customerFile = new File("customersDetails.txt");

        try {

            Scanner sc = new Scanner(customerFile);

            sc.useDelimiter("[,\n]");

            while (sc.hasNext()) {

                firstName = sc.next();
                lastName = sc.next();
                accountCode = sc.next();
                pinNumber = sc.next();
                eMail = sc.next();
                currentBalance = sc.nextDouble();
                savingBalance = sc.nextDouble();
            }
        }catch (IOException e){

        }

        if (firstName.equals(getFName) && lastName.equals(getLName) && accountCode.equals(gAccountCode) && pinNumber.equals(gPinNumber)){
            Bank bank = new Bank(gAccountCode);
        } else{
            System.out.println("Please try another option.");
        }
    }
}