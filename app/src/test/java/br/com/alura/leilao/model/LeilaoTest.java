package br.com.alura.leilao.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeilaoTest {

    private Leilao leilao;

    @Before
    public void init() {
        leilao = new Leilao("Console");
    }

    @Test
    public void deve_DevolverDescricao_QuandoReceberDescricao() {
        String descricaoDevolvida = leilao.getDescricao();
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolverMaiorLance_QaundoMaiorLanceComUmLance() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemCrescente() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 300.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 430.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(430.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemDecrescente() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemAleatoria() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));
        leilao.propoe(new Lance(new Usuario("Steve"), 300.0));
        leilao.propoe(new Lance(new Usuario("Marta"), 200.0));
        leilao.propoe(new Lance(new Usuario("Flavio"), 600.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(600.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QaundoMaiorLanceComUmLance() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemCrescente() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 300.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 430.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(200, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemDecrescente() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(130, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenoorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemAleatoria() {
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));
        leilao.propoe(new Lance(new Usuario("Steve"), 300.0));
        leilao.propoe(new Lance(new Usuario("Marta"), 200.0));
        leilao.propoe(new Lance(new Usuario("Flavio"), 600.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(130, menorLanceDevolvido, 0.0001);
    }
}