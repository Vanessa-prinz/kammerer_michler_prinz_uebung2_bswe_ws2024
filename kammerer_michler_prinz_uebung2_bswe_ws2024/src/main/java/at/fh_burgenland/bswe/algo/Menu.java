package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryIterativeSearchAlgorithm;
import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryRecursiveSearchAlgorithm;
import at.fh_burgenland.bswe.algo.SearchAlgorithm.ExponentialSearchAlgorithm;
import at.fh_burgenland.bswe.algo.SearchAlgorithm.LinearSearchAlgorithm;
import lombok.extern.log4j.Log4j2;

import java.util.Scanner;

import static at.fh_burgenland.bswe.algo.SearchAlgorithm.SearchAlgorithm.runSearchAlgorithm;

/**
 * This class provides a menu to allow interactions with the user.
 */
@Log4j2
public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * This method runs the menu in loops where the user can input a list and the integer to search for.
     * After selecting the search algorithm to execute the user can view the results.
     */
    public static void run() {
        System.out.println("Welcome to our search algorithms!");
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Enter the list in the following format: 1,2,3,... (only integer, seperated by ',', spacing is removed)");
            System.out.println("Please give me your list:");
            String listInput = scanner.nextLine();
            int[] list = ListProcessor.getList(listInput);
            if (list == null) {
                System.out.println("Invalid input! Please enter again.");
                continue;
            }

            System.out.print("Please enter your integer to search for: ");
            int searchedInteger = checkInputMisMatch();

            String menu = """
                You have the following options:
                1 - use the binary search (rekursive)
                2 - use the binary search (iterative)
                3 - use the exponential search
                4 - use the linear search
                5 - enter new list
                6 - exit program
                """;
            boolean runSearch = true;

            while (runSearch) {
                System.out.println(menu);
                System.out.print("Please enter your choice: ");
                int userChoice = checkInputMisMatch();

                switch (userChoice) {
                    case 1:
                        runSearchAlgorithm(list, searchedInteger, new BinaryRecursiveSearchAlgorithm());
                        break;
                    case 2:
                        runSearchAlgorithm(list, searchedInteger, new BinaryIterativeSearchAlgorithm());
                        break;
                    case 3:
                        runSearchAlgorithm(list, searchedInteger, new ExponentialSearchAlgorithm());
                        break;
                    case 4:
                        runSearchAlgorithm(list, searchedInteger, new LinearSearchAlgorithm());
                        break;
                    case 5:
                        runSearch = false;
                        break;
                    case 6:
                        runSearch = false;
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid number.");
                        break;
                }
            }
        }
    }

    /**
     * This method checks for input mismatch exceptions and ensures valid integer input.
     * @return the valid integer input from the user
     */
    private static int checkInputMisMatch() {
        boolean runLoop = true;
        int input = 0;

        while (runLoop) {
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                runLoop = false;
            } catch (Exception e) {
                System.err.println("Invalid Input! Please enter a valid integer.");
                scanner.nextLine();
            }
        }
        return input;
    }
}