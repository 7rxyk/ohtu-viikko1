package ohtu.ohtuvarasto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
        @Test
    public void lisataaLiikaa() {
        varasto.lisaaVarastoon(13);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
        @Test
    public void otetaanLiikaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(9);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
            @Test
    public void otetaanNegatiivisesti() {
        varasto.lisaaVarastoon(-8);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
    
    

}