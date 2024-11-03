package at.fh_burgenland.bswe.algo;

import java.util.Arrays;

public class BinaryRecursiveSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] list, int searchedInteger) {
        while (true) {
            if (list[list.length/2] == searchedInteger)
                return list.length/2;
            else if (list[list.length/2] < searchedInteger)
                list = Arrays.copyOfRange(list, list.length/2, list.length);
            else
                list  = Arrays.copyOfRange(list, 0, list.length/2);

            if (list.length == 1 && list[0] != searchedInteger)
                return -1;
        }
    }
}
