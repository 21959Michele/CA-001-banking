package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.io.IOException;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage {

    public LoginPage() throws IOException {

        Scanner sc = new Scanner(System.in);

        int codeNumber;
        String password = "";
        final String pinNumber = "A1234";
        String firstName, lastName, accountNumber, customerPassword;

        do {

            System.out.println("------------ WELCOME -----------" + " \n" + "Are you employee?        Enter 1."+ " \n"+"If you are a Customer:   Enter 2.");

            codeNumber = sc.nextInt();

            if (codeNumber == 1) {

                do {
                    System.out.println("Enter your password:");
                    password = sc.next();
                }
                while (password == pinNumber);
                System.out.println("You are successfully logged in as an employee!" + "\n");
                Employees employees = new Employees();

            } else if (codeNumber == 2) {
                sc.nextLine();
                System.out.println("Enter your first name: \t");
                firstName = sc.nextLine();
                System.out.println("Enter your last name: \t");
                lastName = sc.nextLine();
                System.out.println("Enter your account number: \t");
                accountNumber = sc.nextLine();
                System.out.println("Enter your password: \t");
                customerPassword = sc.nextLine();

                Customers.check(firstName, lastName, accountNumber, customerPassword);

            }
        }
        while (codeNumber < 1 && codeNumber > 2) ;

    }
}