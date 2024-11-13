package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This abstract class provides methods for implementing different search algorithms and printing their results.
 */
public abstract class SearchAlgorithm {

    //TODO: javadoc
    private static final Logger logger = LogManager.getLogger(SearchAlgorithm.class);

    /**
     * This method executes the search algorithm.
     * @param list the array of integers to search in
     * @param searchedInteger the integer value to search for in the list
     * @return the index of searchedInteger if found, -1 if not
     */
    public abstract int execute(int[] list, int searchedInteger);

    //TODO: javadoc wenn logging implementiert
    public int executeAlgorithm(int[] list, int searchedInteger) {
        if (this.getClass() == SearchAlgorithm.class) {
            //TODO: logging und -1 ausreichend?
            logger.error("ecexuteAlgorithm called from SearchAlgorithm. This can only be called from its Childclasses.");
            return -1;
        }
        long startTime = System.nanoTime();
        logger.info("StartTime: " + startTime);
        int result = this.execute(list, searchedInteger);  // Der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        logger.info("EndTime: " + endTime);
//        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        logger.info("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }

    /**
     * This helper method prints the result of the search algorithm to the console.
     * @param list the array of integers that was searched in
     * @param searchedInteger the integer that was searched for
     * @param index the index of searchedInteger in list or -1 if not found or -2 if search algorithm is not implemented yet
     */
    private void printSearchResult(int[] list, int searchedInteger, int index) {
//        System.out.println("List: " + ListProcessor.getListAsString(list));
        logger.info("List: " + ListProcessor.getListAsString(list));
//        System.out.println("Number to search for: " + searchedInteger);
        logger.info("Number to search for: " + searchedInteger);
        if (index >= 0) {
            logger.info("Number found at index number: " + index);
//            System.out.println("Found at index number: " + index);
        } else if (index == -1) {
            logger.warn("Number not found in list: " + ListProcessor.getListAsString(list)
                    + ". Searched number: " + searchedInteger);
//            System.out.println("Number not found.");
        } else if (index == -2) {
            logger.error("Search algorithm not implemented yet: " + this.getClass().getSimpleName());
//            System.out.println("Search algorithm not implemented yet.");
        }
    }

    //TODO test runSearch bzw executeAlgorithm!
    //TODO souts entfernen??
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
//                System.out.println("Unsorted list! Is sorting now...");
//                logger.info("Sorted list: " + ListProcessor.getListAsString(list));
                int index = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, index);
            } else {
                System.out.println("Unsorted list!");
//                logger.info("Unsorted list: " + ListProcessor.getListAsString(list));
                int indexUnsorted = searchAlgorithm.executeAlgorithm(list, searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, indexUnsorted);
                System.out.println("Sorted list!");
//                logger.info("Sorted list: " + ListProcessor.getListAsString(list));
                int indexSorted = searchAlgorithm.executeAlgorithm(ListProcessor.getSortedList(list), searchedInteger);
                searchAlgorithm.printSearchResult(list, searchedInteger, indexSorted);
            }
        }
    }
}