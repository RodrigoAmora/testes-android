package br.com.alura.leilao.util;

import java.util.Comparator;

import br.com.alura.leilao.model.Lance;

public class Comparador implements Comparator<Lance> {
    @Override
    public int compare(Lance lance, Lance lance1) {
        if (lance.getValor() < lance1.getValor()) return +1;
        else if (lance.getValor() > lance1.getValor()) return -1;
        else return 0;
    }
}
