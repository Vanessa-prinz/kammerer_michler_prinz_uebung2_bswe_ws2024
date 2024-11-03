package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

public class BinaryRecursiveSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] sortedList, int searchedNumber) {
        return execute(sortedList, searchedNumber, 0);
    }

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
