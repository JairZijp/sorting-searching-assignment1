package nl.hva.ict.ss;

import java.util.LinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Put your tests that show you implemented the code correctly in this class.
 * Any test placed at a different class will be ignored!
 * Failing to add tests here will result in failing the assignment!
 */
public class ExtendedAdvancedSortingTest extends AdvancedSortingTest {
    
    @Test
    public void sortArray() {
        Player jair = new Player("Jair ", "hva", 9999);
        Player simon = new Player("Simon ", "hva", 7777);
        Player jack = new Player("Jack", "Jones", 5555);
        Player james = new Player("James", "Bond", 3333);
        

        Player[] players = new Player[]{jair,simon,jack,james};
        Player[] sorted = AdvancedSorts.quickSort(players);

        assertEquals(sorted[0], james);
        assertEquals(sorted[1], jack);
        assertEquals(sorted[2], simon);
        assertEquals(sorted[3], jair);
    }
    
    @Test
    public void sortLinkedList() {
        Player jair = new Player("Jair ", "hva", 9999);
        Player simon = new Player("Simon ", "hva", 7777);
        Player jack = new Player("Jack", "Jones", 5555);
        Player james = new Player("James", "Bond", 3333);       

        LinkedList<Player> players = new LinkedList<>();
        players.add(jair);
        players.add(jack);
        players.add(james);
        players.add(simon);

        players = AdvancedSorts.quickSort(players);

        assertEquals(players.get(0), james);
        assertEquals(players.get(1), jack);
        assertEquals(players.get(2), simon);
        assertEquals(players.get(3), jair);    
    }


    @Test
    public void arraySameHighScore() {
        Player jair = new Player("Jair ", "hva", 9999);
        Player simon = new Player("Simon ", "hva", 9999);
        Player jack = new Player("Jack", "Jones", 5555);
        Player james = new Player("James", "Bond", 3333);

        Player[] players = new Player[]{jair,simon,jack,james};
        Player[] sorted = AdvancedSorts.quickSort(players);

        assertEquals(sorted[0], james);
        assertEquals(sorted[1], jack);
        assertEquals(sorted[2], jair);
        assertEquals(sorted[3], simon);
    }
    
    @Test
    public void linkedListSameHighScore() {
        Player jair = new Player("Jair ", "hva", 9999);
        Player simon = new Player("Simon ", "hva", 9999);
        Player jack = new Player("Jack", "Jones", 5555);
        Player james = new Player("James", "Bond", 3333);

        LinkedList<Player> players = new LinkedList<>();
        players.add(jair);
        players.add(simon);
        players.add(jack);
        players.add(james);

        players = AdvancedSorts.quickSort(players);

        assertEquals(players.get(0), james);
        assertEquals(players.get(1), jack);
        assertEquals(players.get(2), jair);
        assertEquals(players.get(3), simon);
    }


}
