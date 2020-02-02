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
}