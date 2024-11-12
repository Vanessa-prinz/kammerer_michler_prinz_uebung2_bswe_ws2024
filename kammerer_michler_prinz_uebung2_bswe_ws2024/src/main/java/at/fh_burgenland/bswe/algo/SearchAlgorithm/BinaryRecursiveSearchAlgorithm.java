package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

/**
 * This class implements the recursive version of the binary search algorithm.
 */
public class BinaryRecursiveSearchAlgorithm extends SearchAlgorithm {

    /**
     * This method executes the binary recursive search algorithm.
     * @param sortedList the sorted integer array to search in
     * @param searchedNumber the integer to search for in sortedList
     * @return the index of searchedNumber if found, -1 if not or if the list is empty
     */
    @Override
    public int execute(int[] sortedList, int searchedNumber) {
        return execute(sortedList, searchedNumber, 0);
    }

    /**
     * This method implements the logic of the binary recursive search algorithm.
     * It trys to find the index of a specific integer in a sorted list.
     * @param sortedList the sorted integer array to search in
     * @param searchedNumber the integer to search for
     * @param numbersInFront the number of elements before the current subarray
     * @return the index of the searchedNumber if it's found, -1 if it's not or if the list is empty
     */
    private int execute(int[] sortedList, int searchedNumber, int numbersInFront) {
        if (sortedList == null
                || sortedList.length == 0
                || (sortedList.length == 1 && sortedList[0] != searchedNumber))
            return -1;
        if (sortedList[sortedList.length/2] == searchedNumber)
            return sortedList.length/2 + numbersInFront;
        else if (sortedList[sortedList.length/2] > searchedNumber)
            return execute(
                    Arrays.copyOfRange(sortedList, 0, sortedList.length/2), searchedNumber, numbersInFront);
        else
            return execute(
                    Arrays.copyOfRange(sortedList, sortedList.length/2, sortedList.length),
                    searchedNumber,
                    numbersInFront + sortedList.length/2);
    }
}