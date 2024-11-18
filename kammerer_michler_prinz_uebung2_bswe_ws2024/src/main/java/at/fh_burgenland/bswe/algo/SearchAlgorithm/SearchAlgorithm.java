package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This abstract class provides methods for implementing different search algorithms and logging their results.
 */
public abstract class SearchAlgorithm {

    private static final Logger logger = LogManager.getLogger(SearchAlgorithm.class);

    /**
     * This abstract method executes the search algorithm.
     * @param list the array of integers to search in
     * @param searchedInteger the integer value to search for in the list
     * @return the index of searchedInteger if found, -1 if not
     */
    public abstract int execute(int[] list, int searchedInteger);

    /**
     * This method executes the specific search algorithm and logs the start, execution and end time.
     * @param list the array of integers to search in
     * @param searchedInteger the integer value to search for in the list
     * @return the index of searchedInteger in list or -1 if not found
     */
    public int executeAlgorithm(int[] list, int searchedInteger) {
        if (this.getClass() == SearchAlgorithm.class) { //überprüft ob Methode von SearchAlgorithm aufgerufen wird
            return -3;
        }
        long startTime = System.nanoTime();
        logger.info("StartTime: " + startTime);
        int result = this.execute(list, searchedInteger);  // Der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        logger.info("EndTime: " + endTime);
        logger.info("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }

    /**
     * This helper method prints the result of the search algorithm to the console.
     * @param list the array of integers that was searched in
     * @param searchedInteger the integer that was searched for
     * @param index the index of searchedInteger in list or -1 if not found
     *              or -2 if search algorithm is not implemented yet
     *              or -3 if the method is called directly from parent class
     */
    private void printSearchResult(int[] list, int searchedInteger, int index) {
          logger.info("Your given list: " + ListProcessor.getListAsString(list));
        logger.info("Number to search for: " + searchedInteger);
        if (index >= 0) {
            logger.info("Number found at index number: " + index);
        } else if (index == -1) {
            logger.warn("Number not found in list: " + ListProcessor.getListAsString(list)
                    + ". Searched number: " + searchedInteger);
        } else if (index == -2) {
            logger.error("Search algorithm not implemented yet: " + this.getClass().getSimpleName());
        } else if (index == -3) {
            logger.error("executeAlgorithm called from SearchAlgorithm. This can only be called from its child classes.");
        }
    }

    /**
     * This method runs the given search algorithm on the specific list for the given number and displays the result.
     * @param list the array of integers to search in
     * @param searchedInteger the integer to search for within the list
     * @param searchAlgorithm the search algorithm to execute
     */
    public static void runSearchAlgorithm(int[] list, int searchedInteger, SearchAlgorithm searchAlgorithm) {
        logger.info("Searchalgorithm: " + searchAlgorithm.getClass().getSimpleName());
        if (ListProcessor.isSortedAscending(list)) {
            int index = searchAlgorithm.executeAlgorithm(list, searchedInteger);
            searchAlgorithm.printSearchResult(list, searchedInteger, index);
        } else {
            if (!(searchAlgorithm instanceof LinearSearchAlgorithm)) {
                logger.warn("Search algorithm can not handle unsorted list - list getting sorted.");
                int index = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, index);
            } else {
                logger.info("Result with unsorted list!");
                int indexUnsorted = searchAlgorithm.executeAlgorithm(list, searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, indexUnsorted);
                logger.info("Result with sorted list!");
                int indexSorted = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, indexSorted);
            }
        }
    }
}