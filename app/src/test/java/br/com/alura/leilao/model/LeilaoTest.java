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
}