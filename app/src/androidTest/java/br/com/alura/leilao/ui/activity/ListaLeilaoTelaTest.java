package br.com.alura.leilao.ui.activity;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

public class ListaLeilaoTelaTest {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(ListaLeilaoActivity.class, true, true);

    @Test
    public void deve_AparecerUmLeilao_QuandoCarregarUmLeilaoNaAPI() {
        Espresso.onView(ViewMatchers.withText("Casa"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}