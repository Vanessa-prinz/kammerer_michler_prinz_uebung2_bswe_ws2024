package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.LinearSearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the linear search algorithm.
 */
public class LinearSearchAlgorithmTests {

    /**
     * This test method checks if the search algorithm finds a specific number in a sorted list of positive integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void linearSearchTest_Success_NumberFound_Sorted() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                231, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm finds a specific number in an unsorted list of positive integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void linearSearchTest_Success_NumberFound_Unsorted() {
        int searchNumber = TestData.getSearchedNumberPositive();
        int[] searchedListUnsorted = TestData.getListUnsortedOnlyPositive();

        Assertions.assertEquals(
                57, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchNumber)
        );
    }

    /**
     * This test method checks if the search algorithm finds a specific number in a sorted list of negative integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void linearSearchTest_Success_NumberFoundNegative_Sorted() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListSorted = TestData.getListSortedNegative();

        Assertions.assertEquals(
                209, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm finds a specific number in an unsorted list of negative integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void linearSearchTest_Success_NumberFoundNegative_Unsorted() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListUnsorted = TestData.getListUnsortedNegative();

        Assertions.assertEquals(
                183, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm returns the correct index in a single element list.
     */
    @Test
    public void linearSearchTest_Success_SingleElementFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                0, new LinearSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    /**
     * This test method checks if the search algorithm returns -1 if the searchedNumber is not in the single element list.
     */
    @Test
    public void linearSearchTest_Failure_SingleElementNotFound() {
        int searchedNumber = 100;
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    /**
     * This test method checks if the search algorithm returns -1 correctly.
     * searchedNumber is not in the sorted list of positive integer
     */
    @Test
    public void linearSearchTest_Failure_NumberNotFound_Sorted() {
        int searchedNumber = 274;
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm returns -1 correctly.
     * searchedNumber is not in the unsorted list of positive integer
     */
    @Test
    public void linearSearchTest_Failure_NumberNotFound_Unsorted() {
        int searchedNumber = 274;
        int[] searchedListUnsorted = TestData.getListUnsortedOnlyPositive();

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListUnsorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm handles a list with null elements correctly.
     */
    @Test
    public void linearSearchTest_Failure_NullList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = null;

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm handles an empty list correctly.
     */
    @Test
    public void linearSearchTest_Failure_EmptyList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = new int[0];

        Assertions.assertEquals(
                -1, new LinearSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }
}