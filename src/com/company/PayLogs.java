package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College


import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class PayLogs extends Accounts{

    public PayLogs(){
    }

        public void Lodge(String inAccountNumber) throws IOException {

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

                        reWriteFileCur(readFromCur, inAccountNumber, currentBF);
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
                        reWriteFileSav(readFromSav, inAccountNumber, savingBF);
                    } catch (IOException e) {
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    break;
            }
        }

        public void Withdraw(String inAccountNumber) throws IOException{

            LocalDate localDate = LocalDate.now();
            Scanner sc = new Scanner(System.in);
            int option = PayLogs.option();

            switch(option) {
                case 1:

                    System.out.println("Please enter the amount");
                    double amountMoney = sc.nextDouble();

                    try {
                        inFile(readFromCur);
                        FileWriter currentFile = new FileWriter(readFromCur, true);
                        BufferedWriter currentAccountFile = new BufferedWriter(currentFile);
                        PrintWriter pwc = new PrintWriter(currentAccountFile);
                        if ( currentBF-amountMoney >=0){
                            currentBF -= amountMoney;
                            pwc.print(localDate + ","+ "Withdraw" +"," +  amountMoney + "," + currentBF + "\n");
                            pwc.close();
                            reWriteFileCur(readFromCur, inAccountNumber, currentBF);
                        }
                        else {
                            System.out.print("Balance can not be negative");
                        }

                    } catch (IOException e) {
                    }
                    break;

                case 2:
                    System.out.println("Please enter the amount");
                    amountMoney = sc.nextDouble();
                    try {
                        inFile(readFromSav);
                        FileWriter savingFile = new FileWriter(readFromSav, true);
                        BufferedWriter savingAccountFile = new BufferedWriter(savingFile);
                        PrintWriter printWriter = new PrintWriter(savingAccountFile);
                        if ( savingBF -amountMoney >=0 ){
                            savingBF -= amountMoney;
                            printWriter.print(localDate + ","+ "Withdraw" +"," +  amountMoney + "," + savingBF + "\n");
                            printWriter.close();
                            reWriteFileSav(readFromSav, inAccountNumber, savingBF);
                        } else {
                            System.out.print("You don't have enough balance" + " \n");
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
            int selection;
            Scanner sc = new Scanner(System.in);
            System.out.println("Try again:" + " \n" + " 1.Current account" + " \n" + " 2.Saving account" + " \n" + " 3.Exit");
            selection = sc.nextInt();
            return selection;
        }

        public void CustomerList(){
            String firstName = "";
            String lastName = "";
            String accountNumber = "";
            String pinNumber = "";
            String eMail = "";
            String currentBalance = "";
            String savingBalance = "";File customerFile = new File("customersDetails.txt");
            try {
                Scanner sc = new Scanner(customerFile);
                sc.useDelimiter("[,\n]");
                while(sc.hasNext()){
                    firstName = sc.next();
                    lastName = sc.next();
                    accountNumber = sc.next();
                    pinNumber = sc.next();
                    eMail = sc.next();
                    currentBalance = sc.next();
                    savingBalance = sc.next();
                    System.out.printf("%s %s %s %s %s %s %s \n", firstName, lastName, accountNumber, pinNumber, eMail, currentBalance, savingBalance);
                }
            } catch (IOException e){
            }
        }

        public void transactionHistory(String inAccountNumber) throws IOException{
            LocalDate localDate = LocalDate.now();
            File(inAccountNumber);
            String date = "";
            String transaction = "";
            String type = "";
            String balance = "";
            int option = PayLogs.option();
            switch (option){
                case 1:
                    System.out.println("Current account transaction history");
                    File cuFile = new File(readFromCur);
                    try {
                        Scanner sc= new Scanner(cuFile);
                        sc.useDelimiter("[,\n]");while(sc.hasNext()){
                            // implement data
                            date = sc.next();
                            transaction = sc.next();
                            type = sc.next();
                            balance = sc.next();
                            System.out.println(date + " -- " + transaction + " -- " + type + " -- " + balance);
                        }
                    }
                    catch (IOException e){
                    }

                    break;
                case 2:
                    System.out.println("Saving account transaction history");
                    File savFile = new File(readFromSav);
                    try {
                        Scanner sc = new Scanner(savFile);
                        sc.useDelimiter("[,\n]");
                        while(sc.hasNext()){
                            date = sc.next();
                            transaction = sc.next();
                            type = sc.next();
                            balance = sc.next();
                            System.out.println(date + " -- " + transaction + " -- " + type + " -- " + balance );
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


