package org.astronutRunner.consoleUtils;

public class ConsoleHelper {

    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";

    // Method to print the menu with cyan color
    public void printMenu(String message) {
        System.out.println(CYAN + message + RESET);
    }

    // Method to print input prompts in yellow color
    public void printInput(String message) {
        System.out.print(YELLOW + message + RESET);
    }

    // Method to print success messages in green color
    public void printSuccess(String message) {
        System.out.println(GREEN + message + RESET);
    }

    // Method to print warnings in yellow color
    public void printWarning(String message) {
        System.out.println(YELLOW + message + RESET);
    }

    // Method to print error messages in red color
    public void printError(String message) {
        System.out.println(RED + message + RESET);
    }
}
