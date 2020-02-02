package br.com.alura.leilao.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void getDescricao() {
        Leilao leilao = new Leilao("Console");
        String descricaoDevolvida = leilao.getDescricao();
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLanceComUmLanceDevolveMaiorLance() {
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(200.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceComMaisDeUmLanceEmOrdemCrescenteDevolveMaiorLance() {
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 200.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 300.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 430.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(430.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceComMaisDeUmLanceEmOrdemDecrescenteDevolveMaiorLance() {
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(500.0, maiorLanceDevolvido, 0.0001);
    }

    @Test
    public void getMaiorLanceComMaisDeUmLanceEmOrdemAleatoriaDevolveMaiorLance() {
        Leilao leilao = new Leilao("Console");
        leilao.propoe(new Lance(new Usuario("Rodrigo"), 500.0));
        leilao.propoe(new Lance(new Usuario("Luiza"), 220.0));
        leilao.propoe(new Lance(new Usuario("Olavo"), 130.0));
        leilao.propoe(new Lance(new Usuario("Steve"), 300.0));
        leilao.propoe(new Lance(new Usuario("Marta"), 200.0));
        leilao.propoe(new Lance(new Usuario("Flavio"), 600.0));

        double maiorLanceDevolvido = leilao.getMaiorLance();

        assertEquals(600.0, maiorLanceDevolvido, 0.0001);
    }
}