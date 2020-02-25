package br.com.alura.leilao.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeilaoTest {

    private Leilao leilao;
    private Usuario luiza, olavo, rodrigo;

    @Before
    public void init() {
        leilao = new Leilao("Console");

        luiza = new Usuario("Luiza");
        olavo = new Usuario("Olavo");
        rodrigo = new Usuario("Rodrigo");

    }

    @Test
    public void deve_DevolverDescricao_QuandoReceberDescricao() {
        String descricaoDevolvida = leilao.getDescricao();
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolverMaiorLance_QaundoMaiorLanceComUmLance() {
        leilao.propoe(new Lance(rodrigo, 200.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemCrescente() {
        leilao.propoe(new Lance(rodrigo, 200.0));
        leilao.propoe(new Lance(luiza, 300.0));
        leilao.propoe(new Lance(olavo, 430.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(430.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemDecrescente() {
        leilao.propoe(new Lance(rodrigo, 500.0));
        leilao.propoe(new Lance(luiza, 220.0));
        leilao.propoe(new Lance(olavo, 130.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemAleatoria() {
        leilao.propoe(new Lance(rodrigo, 500.0));
        leilao.propoe(new Lance(olavo, 130.0));
        leilao.propoe(new Lance(luiza, 220.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QaundoMaiorLanceComUmLance() {
        leilao.propoe(new Lance(rodrigo, 200.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(200.0, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemCrescente() {
        leilao.propoe(new Lance(rodrigo, 200.0));
        leilao.propoe(new Lance(luiza, 300.0));
        leilao.propoe(new Lance(olavo, 430.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(200, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemDecrescente() {
        leilao.propoe(new Lance(rodrigo, 500.0));
        leilao.propoe(new Lance(luiza, 220.0));
        leilao.propoe(new Lance(olavo, 130.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(130, menorLanceDevolvido, 0.0001);
    }

    @Test
    public void deve_DevolverMenoorLance_QuandoMaiorLanceComMaisDeUmLanceEmOrdemAleatoria() {
        leilao.propoe(new Lance(olavo, 500.0));
        leilao.propoe(new Lance(luiza, 220.0));
        leilao.propoe(new Lance(rodrigo, 130.0));

        double menorLanceDevolvido = leilao.getMenorLance();

        assertEquals(130, menorLanceDevolvido, 0.0001);
    }
}