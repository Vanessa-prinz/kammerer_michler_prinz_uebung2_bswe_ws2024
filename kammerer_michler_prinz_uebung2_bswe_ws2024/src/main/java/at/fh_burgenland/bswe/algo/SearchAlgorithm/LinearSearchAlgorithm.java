package at.fh_burgenland.bswe.algo.SearchAlgorithm;

/**
 * This class implements the linear search algorithm.
 */
public class LinearSearchAlgorithm extends SearchAlgorithm {

    /**
     * This method implements the logic of the linear search algorithm.
     * It trys to find the index of a specific integer in an unsorted or sorted list.
     * @param list the unsorted or sorted integer array to search in
     * @param searchedNumber the integer value to find in the list
     * @return the index of searchedNumber if found, -1 if not or if the list is empty
     */
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