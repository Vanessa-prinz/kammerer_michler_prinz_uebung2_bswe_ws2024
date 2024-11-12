package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryIterativeSearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class contains unit tests for the binary iterative search algorithm.
 */
public class BinaryIterativeSearchAlgorithmTests {

    /**
     * This test method checks if the search algorithm finds a specific number in a sorted list of positive integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void BinaryIterativeSearchTest_Success_NumberFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                231, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm finds a specific number in a sorted list of negative integers.
     * Checks if the returned number equals the correct index of searchedNumber.
     */
    @Test
    public void BinaryIterativeSearchTest_Success_NumberFoundNegative() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListSorted = TestData.getListSortedNegative();

        Assertions.assertEquals(
                209, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm returns the correct index in a single element list.
     */
    @Test
    public void BinaryIterativeSearchTest_Success_SingleElementFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                0, new BinaryIterativeSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    /**
     * This test method checks if the search algorithm returns -1 if the searchedNumber is not in the single element list.
     */
    @Test
    public void BinaryIterativeSearchTest_Failure_SingleElementNotFound() {
        int searchedNumber = 100;
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    /**
     * This test method checks if the search algorithm returns -1 correctly.
     * searchedNumber is not in the sorted list of positive integer
     */
    @Test
    public void BinaryIterativeSearchTest_Failure_NumberNotFound() {
        int searchedNumber = 274;
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm handles a list with null elements correctly.
     */
    @Test
    public void BinaryIterativeSearchTest_Failure_NullList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = null;

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    /**
     * This test method checks if the search algorithm handles an empty list correctly.
     */
    @Test
    public void BinaryIterativeSearchTest_Failure_EmptyList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = new int[0];

        Assertions.assertEquals(
                -1, new BinaryIterativeSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }
}