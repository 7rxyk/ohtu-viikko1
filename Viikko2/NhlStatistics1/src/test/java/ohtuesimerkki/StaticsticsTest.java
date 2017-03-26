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
    public void enitenPinnoja() {
        assertEquals(stats.topScorers(0).toString(), "[Gretzky              EDM 35 + 89 = 124]");
    
    }
    
    @Test
    public void joukkueenKoko() {
        List<Player> pelaajat = stats.team("EDM");
        assertEquals(pelaajat.size(), 3);
    }
    
    @Test
    public void pelaajaLoytyy() {
        assertNotNull(stats.search("Gretzky"));
    }
    
        @Test
    public void pelaajaEiLoytyy() {
        assertNull(stats.search("pasi"));
    }
}
