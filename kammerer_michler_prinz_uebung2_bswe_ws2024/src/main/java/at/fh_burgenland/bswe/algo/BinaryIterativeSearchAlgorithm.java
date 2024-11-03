package at.fh_burgenland.bswe.algo;

import java.util.Arrays;

public class BinaryIterativeSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] list, int searchedNumber) {
        if (list == null
                || list.length == 0
                || (list.length == 1 && list[0] != searchedNumber))
            return -1;
        if (list[list.length/2] == searchedNumber)
            return list.length/2;
        else if (list[list.length/2] > searchedNumber)
            return execute(Arrays.copyOfRange(list, 0, list.length/2), searchedNumber);
        else
            return execute(Arrays.copyOfRange(list, list.length/2, list.length), searchedNumber);
    }
}
