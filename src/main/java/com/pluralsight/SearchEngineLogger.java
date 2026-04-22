package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
// create main
    public static void main(String[] args) {
        // I created scanner named theScanner
        Scanner theScanner = new Scanner(System.in);

        // this is method call that send a s tring text called launch
        logAction("launch");
// create while loop
        while (true) {
            System.out.print("Enter a search term (X to exit): ");
            String input = theScanner.nextLine();

            // Exit condition
            if (input.equalsIgnoreCase("X")) {
                logAction("exit");
                break;
            }

            // Log search action
            logAction("search : " + input);
        }
// closing scanner
        theScanner.close();
    }

    // I created method inside the class
    public static void logAction(String action) {
// creating try and catch
        try {
            FileWriter amaniWriter = new FileWriter("logs.txt", true);
// creating date and time format
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String timestamp = LocalDateTime.now().format(formatter);

            amaniWriter.write(timestamp + " " + action + "\n");
// closing my writer
            amaniWriter.close();

        } catch (IOException e) {
            System.out.println("Error writing to log file.");
        }
    }
}