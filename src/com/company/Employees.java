package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.io.IOException;
import java.util.Scanner;

public class Employees{

    Scanner sc = new Scanner(System.in);

    int inputNumberFirst = 0;
    public Employees() throws IOException {

        do {
            System.out.println("Please choose one option:" + "\n" + "1.Creating customer" + "\n" + "2.Lodge" + "\n" +  "3.Withdraw" + "\n"+"4.List of customer");
            inputNumberFirst = sc.nextInt();

            if (inputNumberFirst == 1) {
              CustomersDetails customers = new CustomersDetails();
            }

            else if (inputNumberFirst == 1) {

                String firstName, lastName, inAccountCode, inPinNumber;
                System.out.println("Enter customer's first name:\t");
                firstName = sc.next();
                System.out.println("Enter customer's last name:\t");
                lastName = sc.next();
                System.out.println("Enter customer's account number:\t");
                inAccountCode = sc.next();
                System.out.println("Enter customer's password:\t");
                inPinNumber = sc.next();

            }

            else if (inputNumberFirst  == 2){
                sc.nextLine();

                String firstName, lastName, inAccountCode, inPinNumber;
                System.out.println("Enter customer's first name:\t");
                firstName = sc.next();
                System.out.println("Enter customer's last name:\t");
                lastName = sc.next();
                System.out.println("Enter customer's account number:\t");
                inAccountCode = sc.next();
                System.out.println("Enter customer's password:\t");
                inPinNumber = sc.next();

                Customers.check(firstName, lastName, inAccountCode, inPinNumber);
            }

            else if (inputNumberFirst  == 3){
                sc.nextLine();

                String firstName, lastName, inAccountCode, inPinNumber;
                System.out.println("Enter customer's first name:\t");
                firstName = sc.next();

                System.out.println("Enter  customer's last name:\t");
                lastName = sc.next();
                System.out.println("Enter customer's account number:\t");
                inAccountCode = sc.next();
                System.out.println("Enter  customer's password:\t");
                inPinNumber = sc.next();

                Customers.check(firstName, lastName, inAccountCode, inPinNumber);
            }

            else if (inputNumberFirst  == 4){
                PayLogs transaction3 = new PayLogs();
                transaction3.CustomerList();
            }
        }
        while (inputNumberFirst < 1 && inputNumberFirst > 4);

    }
}
