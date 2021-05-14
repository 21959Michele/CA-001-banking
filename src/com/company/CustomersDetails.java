package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;

public class CustomersDetails {

    LocalDate localDate = LocalDate.now();

    public CustomersDetails() throws IOException{

        Scanner sc = new Scanner(System.in);

        String encrypt = new String("abcdefghijklmnopquvwxyz");
        System.out.print("Enter customer's first name:\t");
        String fName = sc.nextLine();
        System.out.print("Enter customer's last name:\t");
        String lName = sc.nextLine();
        System.out.print("Enter customer's email:\t");
        String eMail = sc.nextLine();

        String new_fName = fName.substring(0, 1).toUpperCase() + fName.substring(1).toLowerCase();
        String new_lName = lName.substring(0, 1).toUpperCase() + lName.substring(1).toLowerCase();

        String firstCode = fName.substring(0, 1).toLowerCase() + lName.substring(0, 1).toLowerCase();
        String secondCode = String.valueOf(fName.length() + lName.length());
        String thirdCode = String.valueOf((encrypt.indexOf(new_fName.charAt(0))) + 1);
        String fourthCode = String.valueOf((encrypt.indexOf(new_lName.charAt(0))) + 1);
        String accountNumber = String.join("-", firstCode, secondCode, thirdCode, fourthCode);
        String password = String.join("", thirdCode, fourthCode);

        System.out.printf("Customer's account number is : %s and password is : %s\n", accountNumber, password);

        double savingBalance = 0.0;
        double currentBalance = 0.0;

        try {
            FileWriter fw = new FileWriter("customersDetails.txt", true);
            BufferedWriter customerList = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(customerList);
            pw.print(new_fName  + "," + new_lName + "," + accountNumber+ "," + password + "," + eMail + "," +  currentBalance + ","+ savingBalance + "\n");
            pw.close();
            FileWriter saving = new FileWriter(accountNumber + "-saving.txt", true);
            BufferedWriter s = new BufferedWriter(saving);
            PrintWriter pws = new PrintWriter(s);
            pws.print(localDate + "," + "Created" + "," + "€0.0" + "," + savingBalance + "\n");
            pws.close();
            FileWriter current = new FileWriter(accountNumber + ".current.txt", true);
            BufferedWriter c = new BufferedWriter(current);
            PrintWriter pwc = new PrintWriter(c);
            pwc.print(localDate + "," + "Created" + "," + "0.0" + "," + currentBalance + "\n");

            pwc.close();

        } catch (
                IOException e) {

            System.out.println("Error, try again.");
        }
    }
}
