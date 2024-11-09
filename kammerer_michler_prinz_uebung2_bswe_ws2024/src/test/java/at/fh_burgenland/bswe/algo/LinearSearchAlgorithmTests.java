package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.LinearSearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinearSearchAlgorithmTests {

    @Test
    public void linearSearchTest_Success_NumberFound_Sorted() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                231, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Success_NumberFound_Unsorted() {
        int searchNumber = TestData.getSearchedNumberPositive();
        int[] searchedListUnsorted = TestData.getListUnsortedOnlyPositive();

        Assertions.assertEquals(
                57, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchNumber)
        );
    }

    @Test
    public void linearSearchTest_Success_NumberFoundNegative_Sorted() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListSorted = TestData.getListSortedNegative();

        Assertions.assertEquals(
                209, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Success_NumberFoundNegative_Unsorted() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListUnsorted = TestData.getListUnsortedNegative();

        Assertions.assertEquals(
                183, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Failure_NumberNotFound_Sorted() {
        int searchedNumber = 274;
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Failure_NumberNotFound_Unsorted() {
        int searchedNumber = 274;
        int[] searchedListUnsorted = TestData.getListUnsortedOnlyPositive();

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Failure_NullList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = null;

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void linearSearchTest_Failure_EmptyList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = new int[0];

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }
}