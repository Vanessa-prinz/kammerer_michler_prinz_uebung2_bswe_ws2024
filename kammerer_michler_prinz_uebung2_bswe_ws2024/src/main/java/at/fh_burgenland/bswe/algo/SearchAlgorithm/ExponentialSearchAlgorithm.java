package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

/**
 * This class implements the exponential search algorithm.
 */
public class ExponentialSearchAlgorithm extends SearchAlgorithm {

    /**
     * This method implements the logic of the exponential search algorithm.
     * It trys to find the index of a specific integer in a sorted list.
     * @param sortedList the sorted integer array to search in
     * @param searchedNumber the integer to search for in sortedList
     * @return the index of searchedNumber if found, -1 if not or if the list is empty
     */
    @Override
    public int execute(int[] sortedList, int searchedNumber) {
        if (sortedList == null || sortedList.length == 0 || (sortedList.length == 1 && sortedList[0] != searchedNumber)) {
            return -1;
        }

        int exponentialBound = 1;
        while (exponentialBound < sortedList.length && sortedList[exponentialBound] <= searchedNumber) {
            exponentialBound *= 2;
        }

        int startIndex = exponentialBound / 2;
        int endIndex = Math.min(exponentialBound, sortedList.length);
        BinaryIterativeSearchAlgorithm binarySearch = new BinaryIterativeSearchAlgorithm();
        int resultIndex = binarySearch.execute(Arrays.copyOfRange(sortedList, startIndex, endIndex), searchedNumber);

        if (resultIndex != -1) {
            return startIndex + resultIndex;
        } else {
            return -1;
        }
    }
}