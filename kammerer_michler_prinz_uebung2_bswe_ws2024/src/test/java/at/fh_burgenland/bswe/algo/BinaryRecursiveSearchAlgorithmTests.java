package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryRecursiveSearchAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryRecursiveSearchAlgorithmTests {

    @Test
    public void BinaryRecursiveSearchTest_Success_NumberFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                231, new BinaryRecursiveSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryRecursiveSearchTest_Success_NumberFoundNegative() {
        int searchedNumber = TestData.getSearchedNumberNegative();
        int[] searchedListSorted = TestData.getListSortedNegative();

        Assertions.assertEquals(
                209, new BinaryRecursiveSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryRecursiveSearchTest_Success_SingleElementFound() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                0, new BinaryRecursiveSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    @Test
    public void BinaryRecursiveSearchTest_Failure_SingleElementNotFound() {
        int searchedNumber = 100;
        int[] searchedList = TestData.getListSingleElement();

        Assertions.assertEquals(
                -1, new BinaryRecursiveSearchAlgorithm().execute(searchedList, searchedNumber)
        );
    }

    @Test
    public void BinaryRecursiveSearchTest_Failure_NumberNotFound() {
        int searchedNumber = 274;
        int[] searchedListSorted = TestData.getListSortedOnlyPositive();

        Assertions.assertEquals(
                -1, new BinaryRecursiveSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryRecursiveSearchTest_Failure_NullList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = null;

        Assertions.assertEquals(
                -1, new BinaryRecursiveSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }

    @Test
    public void BinaryRecursiveSearchTest_Failure_EmptyList() {
        int searchedNumber = TestData.getSearchedNumberPositive();
        int[] searchedListSorted = new int[0];

        Assertions.assertEquals(
                -1, new BinaryRecursiveSearchAlgorithm().execute(searchedListSorted, searchedNumber));
    }
}
