package at.fh_burgenland.bswe.algo.SearchAlgorithm;

import java.util.Arrays;

public class BinaryIterativeSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] sortedList, int searchedInteger) {
        if (sortedList == null || sortedList.length == 0)
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

            if (sortedList.length == 1 && sortedList[0] != searchedInteger)
                return -1;
        }
    }
}
