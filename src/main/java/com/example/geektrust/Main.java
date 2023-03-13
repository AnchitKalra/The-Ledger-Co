package com.example.geektrust;

import com.example.geektrust.controller.LoanController;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            LoanController controller = new LoanController();
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
               //Add your code here to process input commands
                String s = sc.nextLine();
                String string[] = s.split(" ");
                if(string[0].equalsIgnoreCase("LOAN")) {
                    controller.loan(string);
                }

                if(string[0].equalsIgnoreCase("PAYMENT")) {
                    controller.payment(string);
                }
                if(string[0].equalsIgnoreCase("Balance")) {
                    controller.balance(string);
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
