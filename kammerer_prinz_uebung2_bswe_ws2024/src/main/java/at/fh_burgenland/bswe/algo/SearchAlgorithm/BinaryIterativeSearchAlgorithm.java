package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

/**
 * This class implements the iterative version of the binary search algorithm.
 */
public class BinaryIterativeSearchAlgorithm extends SearchAlgorithm {

    /**
     * This method implements the logic of the binary iterative search algorithm and executes it.
     *  It trys to find the index of a specific integer in a sorted list.
     * @param sortedList the sorted integer array to search in
     * @param searchedInteger the integer to search for
     * @return the index of the searchedInteger if it's found, -1 if it's not or if the list is empty
     */
    @Override
    public int execute(int[] sortedList, int searchedInteger) {
        if (sortedList == null || sortedList.length == 0 || sortedList.length == 1 && sortedList[0] != searchedInteger)
            return -1;

        int lengthBeforeSubArray = 0;
        while (true) {
            if (sortedList[sortedList.length/2] == searchedInteger)
                return sortedList.length/2 + lengthBeforeSubArray;
            else if (sortedList[sortedList.length/2] < searchedInteger) {
                lengthBeforeSubArray += sortedList.length/2;
                sortedList = Arrays.copyOfRange(sortedList, sortedList.length / 2, sortedList.length);
            } else {
                sortedList = Arrays.copyOfRange(sortedList, 0, sortedList.length / 2);
            }
        }
    }
}