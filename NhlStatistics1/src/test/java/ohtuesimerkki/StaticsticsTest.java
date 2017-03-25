package ohtuesimerkki;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author noora
 */
public class StaticsticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void pelaajaOnListalla() {
        assertNotNull(stats.search("Semenko"));
    }

    @Test
    public void pelaajaEiListalla() {
        assertNull(stats.search("Pasi"));
    }

    @Test
    public void listaltaEnitenPisteita() { 
        assertNotNull(stats.topScorers(0));
    }
    
    @Test
    public void tiimissaPelaajia() {
        List<Player> tiimi = stats.team("EDM");
        assertEquals(3, tiimi.size());
    }

}
