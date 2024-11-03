package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import at.fh_burgenland.bswe.algo.ListProcessor;

public abstract class SearchAlgorithm {
    //TODO: getListAsString

    public abstract int execute(int[] list, int searchedInteger);

    //TODO test runSearch bzw executeAlgorithm!
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

    public int executeAlgorithm(int[] list, int searchedInteger) {
        long startTime = System.nanoTime();
        int result = this.execute(list, searchedInteger);  // Der ursprüngliche execute-Aufruf
        long endTime = System.nanoTime();
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        return result;
    }

    private static void printSearchResult(int[] list, int searchedInteger, int index) {
//        System.out.println("List: " + list.getListAsString());
        System.out.println("Number to search for: " + searchedInteger);
        if (index >= 0) {
            System.out.println("Found at index number: " + index);
        } else if (index == -1) {
            System.out.println("Number not found.");
        } else if (index == -2) {
            System.out.println("Search algorithm not implemented yet.");
        }
    }
}
