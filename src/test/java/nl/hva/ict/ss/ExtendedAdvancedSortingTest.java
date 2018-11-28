package nl.hva.ict.ss;

import org.junit.Test;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {
    
    
    @Test
    public void checkIfSorted() {
   
        Player[] players = null;
        Player[] players2 = null;
        for (int numberOfPlayers = 1; numberOfPlayers < 100; numberOfPlayers++) {
            players = getSubList(unsortedPlayers, numberOfPlayers).toArray(new Player[numberOfPlayers]);
             
        }
        players2 = AdvancedSorts.quickSort(players);   
        for (int i = 0; i < players2.length; i++) {
            System.out.print("\nPlayer " + i + ": "+ players2[i].getHighScore());
        }
   
    }

}
