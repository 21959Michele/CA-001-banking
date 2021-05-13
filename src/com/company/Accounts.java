package com.company;

//Michele Sousa - ID 21959
//OOP - Dorset College

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Accounts {

    public static String line, firstNameF, lastNameF, pinNumberF, eMailF, accountCodeF, dateF, actionF;
    public static double currentBF, savingBF;
    public static double balanceF, lastTransaction;
    public static String readFromSav;
    public static String readFromCur;
    public static String readFromCustomer;
    private static Scanner s;

    public static void File(String gAccountCode){

        String sType = "-saving.txt";
        String cType = ".current.txt";
        readFromCustomer = "customersDetails.txt";
        readFromCur = gAccountCode + cType;
        readFromSav = gAccountCode + sType;
    }
    public static void inFile(String Filepath) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(Filepath));

        line = null;

        while((line=reader.readLine())!=null){

            String[] accountData= line.split(",");

            if (Filepath == readFromCustomer){

                firstNameF = accountData[0];
                lastNameF = accountData[1];
                accountCodeF = accountData[2];
                pinNumberF = accountData[3];
                eMailF = accountData[4];
                currentBF = Double.parseDouble(accountData[5]);
                savingBF = Double.parseDouble(accountData[6]);
            }

            else if (Filepath == readFromCur){

                dateF = accountData[0];
                actionF = accountData[1];
                lastTransaction = Double.parseDouble(accountData[2]);
                currentBF = Double.parseDouble(accountData[3]);
            }
            else if (Filepath == readFromSav){

                dateF = accountData[0];
                actionF = accountData[1];
                lastTransaction = Double.parseDouble(accountData[2]);
                savingBF = Double.parseDouble(accountData[3]);
            }
        }
    }

    public static void reWriteFileCur(String File, String gAccountCode, double currentBF){

        String samFile = "newFile.txt";
        File oldFile = new File("customersDetails.txt");

        File newFile = new File(samFile);

        String newAccount = "";
        String newFName = "";
        String newLName = "";
        String newEmail = "";
        String newPinNumber = "";
        String newCurrentBalance = "";
        String newSavingBalance = "";

        try {
            FileWriter fw = new FileWriter(samFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            s = new Scanner(new File(File));

            s.useDelimiter("[,\n]");

            while (s.hasNext()) {
                newFName = s.next();
                newLName = s.next();
                newAccount = s.next();
                newPinNumber = s.next();
                newEmail = s.next();
                newCurrentBalance = s.next();
                newSavingBalance = s.next();

                if (newAccount.equals(gAccountCode)) {

                    pw.print(newFName + "," + newLName + "," + newAccount + "," + newPinNumber + "," + newEmail + "," + currentBF + "," + newSavingBalance + "\n");
                } else {

                    pw.print(newFName + "," + newLName + "," + newAccount + "," + newPinNumber + "," + newEmail + "," + newCurrentBalance + "," + newSavingBalance + "\n");
                }
            }

            s.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File sample = new File(File);
            newFile.renameTo(sample);
        }
        catch (Exception e){
        }
    }

    public static void reWriteFileSav(String File, String gAccountCode, double savingBF){

        String samFile = "newFile.txt";
        File oldFile = new File("customersDetails.txt");
        File newFile = new File(samFile);

        String newAccount = "";
        String newFName = "";
        String newLName = "";
        String newEmail = "";
        String newPinNumber = "";
        String newCurrentBalance = "";
        String newSavingBalance = "";

        try {
            FileWriter fw = new FileWriter(samFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            s = new Scanner(new File(File));

            s.useDelimiter("[,\n]");

            while(s.hasNext()){
                newFName = s.next();
                newLName = s.next();
                newAccount = s.next();
                newPinNumber = s.next();
                newEmail = s.next();
                newCurrentBalance = s.next();
                newSavingBalance = s.next();

                if (newAccount.equals(gAccountCode)){

                    pw.print(newFName + "," + newLName + "," + newAccount + "," + newPinNumber + "," + newEmail + "," + newCurrentBalance + "," + savingBF + "\n");
                }
                else {

                    pw.print(newFName + "," + newLName + "," + newAccount + "," + newPinNumber + "," + newEmail + "," + newCurrentBalance + "," + newSavingBalance + "\n");
                }
            }

            s.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File sample = new File(File);
            newFile.renameTo(sample);
        }
        catch (Exception e){
        }
    }
}


