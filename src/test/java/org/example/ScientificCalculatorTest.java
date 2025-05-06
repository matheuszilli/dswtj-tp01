package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScientificCalculatorTest {

    @Test
    void testAddition() {
        ScientificCalculator calculadora = new ScientificCalculator();
        double result = calculadora.add(5, 3);
        assertEquals(8, result);
    }

    @Test
    void testSubtraction() {
        // Setup
        ScientificCalculator calculadora = new ScientificCalculator();
        double a = 10, b = 5;

        //Execution
        double diff = calculadora.subtract(a, b);

        //Assertion
        assertEquals(5, diff);

        //Teardown -> nada porque não tem nada a deslocar, e nao usamos recursos externos
    }

    private ScientificCalculator calculadora;

    @BeforeEach
    void init() {
        calculadora = new ScientificCalculator();
    }

    @Test
    void add_DoisNumerosPositivos_RetornaSoma() {
        assertEquals(5, calculadora.add(2, 3));
    }

    @Test
    void diff_doisNumerosPositivos_RetornaSubtracao() {
        assertEquals(5, calculadora.subtract(8, 3));
    }

    @Test
    void testSquareRootPositive() {
        assertEquals(4.0, calculadora.squareRoot(16.0), 1e-9);
    }

    @Test
    void testSquareRootNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.squareRoot(-9));
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.divide(10, 0));
    }

    @Test
    void log_NumeroPositivo_RetornaLogaritmo() {
        assertEquals(Math.log(2), calculadora.log(2), 1e-9);
    }

    @Test
    void seno_TrintaGraus_RetornaMeio() {
        assertEquals(0.5, calculadora.sin(30), 1e-9);
    }

    /**
     * Exercicio 09
     *
     * Na calculadora penso que os testes que merecem mais atenção são os que validam entrada, porque lançam exceções
     * que podem vir a interromper o fluxo do programa.
     *
     * Ja funçoes que dependem de ponto fluenbte, como seno, coseno e logaritmo, são mais complicadas de testar
     * e merecem casos adicionar para garantir uma maior tolerância numerica.
     *
     * O relatório de cobertura pinta de vermelho instruções nao executadas, revelando problemas ou metodos ainda nao testados.
     * A meta é utilizar esse relatório como uma mapa, para encontrar os pontos que ainda não foram testados.
     */

}
