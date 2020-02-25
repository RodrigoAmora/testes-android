package br.com.alura.leilao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.leilao.util.Comparador;

public class Leilao implements Serializable {

    private final String descricao;
    private final List<Lance> lances;
    private double maiorLance = Double.NEGATIVE_INFINITY;
    private double menorLance = Double.POSITIVE_INFINITY;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void propoe(Lance lance) {
        lances.add(lance);
        Collections.sort (lances, new Comparador());
        double valorLance = lance.getValor();
        calcularMaiorLance(valorLance);
        calcularMenorLance(valorLance);
    }

    public double getMaiorLance() {
        return maiorLance;
    }

    public void setMaiorLance(double maiorLance) {
        this.maiorLance = maiorLance;
    }

    public double getMenorLance() {
        return menorLance;
    }

    public void setMenorLance(double menorLance) {
        this.menorLance = menorLance;
    }

    private void calcularMaiorLance(double valorLance) {
        if (valorLance > maiorLance) {
            maiorLance = valorLance;
        }
    }

    private void calcularMenorLance(double valorLance) {
        if (valorLance < menorLance) {
            menorLance = valorLance;
        }
    }

    public List<Lance> tresMaioresLances() {
        int qtdLances = lances.size();
        if (qtdLances > 3) {
            qtdLances = 3;
        }
        return lances.subList(0, qtdLances);
    }
}
