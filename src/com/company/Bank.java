package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.io.IOException;
import java.util.Scanner;

public class Bank {

    public Bank(String gAccountCode) throws IOException {

        int option = Bank.customerOptions();

        do {
            switch (option) {
                case 1:
                    PayLogs transaction1 = new PayLogs();
                    transaction1.Lodge(gAccountCode);
                    break;
                case 2:
                    PayLogs transaction2 = new PayLogs();
                    transaction2.Withdraw(gAccountCode);
                    break;
                case 3:
                    PayLogs transaction3 = new PayLogs();
                    transaction3.transactionHistory(gAccountCode);
                    break;
            }
        } while( option > 0 && option < 4);
    }
    private static int customerOptions(){

        int selection;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose one option:" + "\n" + "1.Lodge" + "\n" + " 2.Withdraw" + "\n" + " 3.Get Statement");
        selection = sc.nextInt();
        return selection;
    }

}

