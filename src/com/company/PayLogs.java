package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College


import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class PayLogs extends Accounts{

    public PayLogs(){
    }

        public void Lodge(String inAccountCode) throws IOException {

            int option = PayLogs.option();

            LocalDate localDate = LocalDate.now();
            Scanner sc = new Scanner(System.in);

            switch(option){
                case 1:
                    System.out.println("Enter the value");
                    double amountMoney = sc.nextDouble();

                    try {
                        inFile(readFromCur);
                        FileWriter currentFile = new FileWriter(readFromCur, true);
                        BufferedWriter currentAccountFile = new BufferedWriter(currentFile);
                        PrintWriter pwc = new PrintWriter(currentAccountFile);

                        currentBF += amountMoney;
                        pwc.print(localDate + ","+ "Lodge" +"," +  amountMoney + "," + currentBF + "\n");
                        pwc.close();

                        reWriteFileCur(readFromCur, inAccountCode, currentBF);
                    }catch (IOException e){
                    }
                    break;
                case 2:
                    System.out.println("Enter the Value");
                    amountMoney = sc.nextDouble();
                    try {
                        inFile(readFromSav);
                        FileWriter savingFile = new FileWriter(readFromSav, true);
                        BufferedWriter savingAccountFile = new BufferedWriter(savingFile);
                        PrintWriter printWriter = new PrintWriter(savingAccountFile);

                        savingBF += amountMoney;

                        printWriter.print(localDate + ","+ "Lodge" +"," +  amountMoney + "," + savingBF + "\n");

                        printWriter.close();
                        reWriteFileSav(readFromSav, inAccountCode, savingBF);
                    } catch (IOException e) {
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }

        public void Withdraw(String inAccountCode) throws IOException{
            // declare variable to get system time data
            LocalDate localDate = LocalDate.now();
            Scanner sc = new Scanner(System.in);
            // call option method
            int option = PayLogs.option();
            // open switch by option
            switch(option) {
                case 1:
                    // ask to user to get data
                    System.out.println("Please enter the amount");
                    double amountMoney = sc.nextDouble();
                    // open try to change and add data in saving account file
                    try {
                        // call method to read from file
                        inFile(readFromCur);
                        // declare filewriter, bufferedwriter, printwriter to add data in file
                        FileWriter currentFile = new FileWriter(readFromCur, true);
                        BufferedWriter currentAccountFile = new BufferedWriter(currentFile);
                        PrintWriter pwc = new PrintWriter(currentAccountFile);
                        // open if to change data
                        if ( currentBF-amountMoney >=0){
                            // if is true, change data
                            currentBF -= amountMoney;
                            // add data to file
                            pwc.print(localDate + ","+ "Withdraw" +"," +  amountMoney + "," + currentBF + "\n");
                            // close printwriter
                            pwc.close();
                            // call method to change customers.txt file
                            reWriteFileCur(readFromCur, inAccountCode, currentBF);
                        }
                        else {
                            // print error message
                            System.out.print("Balance can not be negative");
                        }

                    } catch (IOException e) {
                    }
                    break;

                case 2:
                    // ask to user to get data
                    System.out.println("Please enter the amount");
                    amountMoney = sc.nextDouble();
                    // open try to change and add data in saving account file
                    try {
                        // call method to read from file
                        inFile(readFromSav);
                        // declare filewriter, bufferedwriter, printwriter to add data in file
                        FileWriter savingFile = new FileWriter(readFromSav, true);
                        BufferedWriter savingAccountFile = new BufferedWriter(savingFile);
                        PrintWriter printWriter = new PrintWriter(savingAccountFile);
                        // open if to change data
                        if ( savingBF -amountMoney >=0 ){
                            // change the data
                            savingBF -= amountMoney;
                            // add data to file
                            printWriter.print(localDate + ","+ "Withdraw" +"," +  amountMoney + "," + savingBF + "\n");
                            // close printwriter
                            printWriter.close();
                            // call method to change the customers.txt file
                            reWriteFileSav(readFromSav, inAccountCode, savingBF);
                        } else {
                            // print the error message
                            System.out.print("Balance can not be negative");
                        }
                    } catch (IOException e) {
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }

        private static int option(){
            // initialize variable
            int selection;
            Scanner sc = new Scanner(System.in);
            // print option for choice
            System.out.println("Please choose one option : 1.Current account | 2.Saving account | 3.Exit");
            // get option
            selection = sc.nextInt();
            return selection;
        }

        public void CustomerList(){
            // declare variable
            String firstName = "";
            String lastName = "";
            String accountCode = "";
            String pinNumber = "";
            String eMail = "";
            String currentBalance = "";
            String savingBalance = "";
            // declare file to read
            File customerFile = new File("customers.txt");
            // open try to read data from file
            try {
                // call scanner to read file
                Scanner sc = new Scanner(customerFile);
                sc.useDelimiter("[,\n]");
                //open while to read from file
                while(sc.hasNext()){
                    // implement data
                    firstName = sc.next();
                    lastName = sc.next();
                    accountCode = sc.next();
                    pinNumber = sc.next();
                    eMail = sc.next();
                    currentBalance = sc.next();
                    savingBalance = sc.next();
                    // print data in console to show data from file
                    System.out.printf("%s %s %s %s %s %s %s \n", firstName, lastName, accountCode, pinNumber, eMail, currentBalance, savingBalance);
                }
            } catch (IOException e){
            }
        }

        public void transactionHistory(String inAccountCode) throws IOException{
            // call localdate from system
            LocalDate localDate = LocalDate.now();
            File(inAccountCode);
            // declare variable
            String date = "";
            String transaction = "";
            String type = "";
            String balance = "";
            // call option method
            int option = PayLogs.option();
            // switch by option
            switch (option){
                case 1:
                    // print in console to show which data
                    System.out.println("Current account transaction history");
                    File cuFile = new File(readFromCur);
                    // open try-catch to read from file
                    try {
                        Scanner sc= new Scanner(cuFile);
                        sc.useDelimiter("[,\n]");
                        // open while to read from file
                        while(sc.hasNext()){
                            // implement data
                            date = sc.next();
                            transaction = sc.next();
                            type = sc.next();
                            balance = sc.next();
                            // print data to console from file
                            System.out.println(date + " | " + transaction + " | " + type + " | " + balance);
                        }
                    }
                    catch (IOException e){
                    }

                    break;
                case 2:
                    // print in console to show which data
                    System.out.println("Saving account transaction history");
                    File savFile = new File(readFromSav);
                    // open try-catch to read from file
                    try {
                        Scanner sc = new Scanner(savFile);
                        sc.useDelimiter("[,\n]");
                        // open while to read from file
                        while(sc.hasNext()){
                            // implement data
                            date = sc.next();
                            transaction = sc.next();
                            type = sc.next();
                            balance = sc.next();
                            // print data to console from file
                            System.out.println(date + " | " + transaction + " | " + type + " | " + balance );
                        }
                    } catch (IOException e){
                    }
                    break;
                case 3:
                    LoginPage login = new LoginPage();
                    break;
            }

        }
    }


