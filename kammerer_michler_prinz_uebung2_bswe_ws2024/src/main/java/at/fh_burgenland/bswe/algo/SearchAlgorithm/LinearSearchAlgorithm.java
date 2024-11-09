package at.fh_burgenland.bswe.algo.SearchAlgorithm;

public class LinearSearchAlgorithm extends SearchAlgorithm {

    @Override
    public int execute(int[] list, int searchedNumber) {
        if (list == null || list.length == 0 || (list.length == 1 && list[0] != searchedNumber)) {
            return -1;
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] == searchedNumber) {
                return i;
            }
        }

        return -1;
    }
}