package nl.hva.ict.ss;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {
    @Test
    public void testArraySorted() {
        Player jack = new Player("Jack", "Jones", 5000);
        Player james = new Player("James", "Bond", 3000);
        Player john = new Player("John ", "Doe", 7000);

        Player[] players = new Player[]{jack,james,john};
        Player[] sorted = AdvancedSorts.quickSort(players);

        assertEquals(sorted[0], james);
        assertEquals(sorted[1], jack);
        assertEquals(sorted[2], john);
    }
}
