package at.fh_burgenland.bswe.algo;

import at.fh_burgenland.bswe.algo.SearchAlgorithm.BinaryIterativeSearchAlgorithm;
import at.fh_burgenland.bswe.algo.SearchAlgorithm.SearchAlgorithm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class SearchAlgorithmTests {
    //TODO: write
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void executeAlgorithm_Failure_CalledInSearchAlgorithm() {
//        SearchAlgorithm searchAlgorithm = new BinaryIterativeSearchAlgorithm();
//        Assertions.assertThrows(Exception.class, () -> ((SearchAlgorithm)searchAlgorithm).executeAlgorithm(new int[]{1, 2, 3, 5, 6, 6, 9}, 6));

//        not possible weil nicht aufrufbar
    }

    @Test
    public void runSearchAlgorithm_Success_SortedList() {
//        auch nicht testbar wegen zeitangabe der ausgabe

//        SearchAlgorithm.runSearchAlgorithm(new int[]{1, 2, 4, 4, 5, 6, 8, 10, 11, 14, 16, 18, 19, 22}, 6, new BinaryIterativeSearchAlgorithm());
//        Assertions.assertEquals("", outContent.toString());
    }

    @Test
    public void runSearchAlgorithm_Success_UnsortedListLinearSearch() {

    }

    @Test
    public void runSearchAlgorithm_Success_UnsortedListNotLinearSearch() {

    }
}
