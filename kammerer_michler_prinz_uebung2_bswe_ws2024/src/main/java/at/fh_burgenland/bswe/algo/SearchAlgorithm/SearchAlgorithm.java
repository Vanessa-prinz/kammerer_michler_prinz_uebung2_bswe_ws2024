package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;

/**
 * This abstract class provides methods for implementing different search algorithms and printing their results.
 */
public abstract class SearchAlgorithm {

    /**
     * This method executes the search algorithm.
     * @param list the array of integers to search in
     * @param searchedInteger the integer value to search for in the list
     * @return the index of searchedInteger if found, -1 if not
     */
    public abstract int execute(int[] list, int searchedInteger);

    //TODO: javadoc wenn logging implementiert
    public int executeAlgorithm(int[] list, int searchedInteger) {
        long startTime = System.nanoTime();
        int result = this.execute(list, searchedInteger);  // Der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }

    /**
     * This helper method prints the result of the search algorithm to the console.
     * @param list the array of integers that was searched in
     * @param searchedInteger the integer that was searched for
     * @param index the index of searchedInteger in list or -1 if not found or -2 if search algorithm is not implemented yet
     */
    private static void printSearchResult(int[] list, int searchedInteger, int index) {
        System.out.println("List: " + ListProcessor.getListAsString(list));
        System.out.println("Number to search for: " + searchedInteger);
        if (index >= 0) {
            System.out.println("Found at index number: " + index);
        } else if (index == -1) {
            System.out.println("Number not found.");
        } else if (index == -2) {
            System.out.println("Search algorithm not implemented yet.");
        }
    }

    //TODO test runSearch bzw executeAlgorithm!
    /**
     * This method runs the given search algorithm on the specific list for the given number and displays the result.
     * @param list the array of integers to search in
     * @param searchedInteger the integer to search for within the list
     * @param searchAlgorithm the search algorithm to execute
     */
    public static void runSearchAlgorithm(int[] list, int searchedInteger, SearchAlgorithm searchAlgorithm) {
        if (ListProcessor.isSortedAscending(list)) {
            int index = searchAlgorithm.executeAlgorithm(list, searchedInteger);
            printSearchResult(list, searchedInteger, index);
        } else {
            if (!(searchAlgorithm instanceof LinearSearchAlgorithm)) {
                System.out.println("Unsorted list! Is sorting now...");
                int index = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                printSearchResult(list, searchedInteger, index);
            } else {
                System.out.println("Unsorted list!");
                int indexUnsorted = searchAlgorithm.executeAlgorithm(list, searchedInteger);
                printSearchResult(list, searchedInteger, indexUnsorted);
                System.out.println("Sorted list!");
                int indexSorted = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                printSearchResult(list, searchedInteger, indexSorted);
            }
        }
    }
}