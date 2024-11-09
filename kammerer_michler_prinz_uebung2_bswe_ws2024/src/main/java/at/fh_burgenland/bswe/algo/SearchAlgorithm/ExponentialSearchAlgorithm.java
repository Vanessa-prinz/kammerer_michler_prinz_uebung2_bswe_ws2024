package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

public class ExponentialSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] sortedList, int searchedNumber) {
        if (sortedList == null || sortedList.length == 0 || (sortedList.length == 1 && sortedList[0] != searchedNumber)) {
            return -1;
        }

        int exponentialBound = 1;
        while (exponentialBound < sortedList.length && sortedList[exponentialBound] <= searchedNumber) {
            exponentialBound *= 2; //Bereich der Suche wird in Potenzen von 2 erweitert
        }

        int startIndex = exponentialBound / 2;
        int endIndex = Math.min(exponentialBound, sortedList.length);

        BinaryIterativeSearchAlgorithm binarySearch = new BinaryIterativeSearchAlgorithm();
        int resultIndex = binarySearch.execute(Arrays.copyOfRange(sortedList, startIndex, endIndex), searchedNumber);
        //return Arrays.binarySearch(sortedList, startIndex, endIndex, searchedNumber); //int[], low, high

        if (resultIndex != -1) {
            return startIndex + resultIndex; //Umrechnung des Index auf das ursprüngliche Array
        } else {
            return -1;
        }
    }
}