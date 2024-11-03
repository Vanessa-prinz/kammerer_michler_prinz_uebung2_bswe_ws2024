package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryIterativeSearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryIterativeSearchAlgorithmTests {

    @Test
    public void BinaryIterativeSearchTest_Success_NumberFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                231, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryIterativeSearchTest_Success_NumberFoundNegative() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListSorted = TestData.getListSortedNegative();

        Assertions.assertEquals(
                209, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryIterativeSearchTest_Failure_NumberNotFound() {
        int searchedNumber = 274;
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryIterativeSearchTest_Failure_NullList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = null;

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryIterativeSearchTest_Failure_EmptyList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = new int[0];

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }
}
