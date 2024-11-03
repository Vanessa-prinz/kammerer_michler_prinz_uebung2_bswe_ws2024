package at.fh_burgenland.bswe.algo;

public abstract class SearchAlgorithm {
    //TODO: Zeitlogging Methode (von außen aufrufen können), Start, Execute, Ende, Dauer -> Ausgabe
    //TODO: getListAsString

    public abstract int execute(int[] list, int searchedInteger);

    public static void runSearchAlgorithm(int[] list, int searchedInteger, SearchAlgorithm searchAlgorithm) {
        if (ListProcessor.isSortedAscending(list)) {
            int index = searchAlgorithm.execute(list, searchedInteger);
            printSearchResult(list, searchedInteger, index);
        } else {
            if (!(searchAlgorithm instanceof LinearSearchAlgorithm)) {
                System.out.println("Unsorted list! Is sorting now...");
                int index = searchAlgorithm.execute(ListProcessor.getSortedList(list), searchedInteger);
                printSearchResult(list, searchedInteger, index);
            } else {
                System.out.println("Unsorted list!");
                int indexUnsorted = searchAlgorithm.execute(list, searchedInteger);
                printSearchResult(list, searchedInteger, indexUnsorted);
                System.out.println("Sorted list!");
                int indexSorted = searchAlgorithm.execute(ListProcessor.getSortedList(list), searchedInteger);
                printSearchResult(list, searchedInteger, indexSorted);
            }
        }
    }

    private static void printSearchResult(int[] list, int searchedInteger, int index) {
        System.out.println("List: " + list.getListAsString());
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
