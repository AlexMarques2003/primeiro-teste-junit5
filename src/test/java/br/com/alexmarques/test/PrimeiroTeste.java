package br.com.alexmarques.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PrimeiroTeste {
    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    @BeforeEach
    public void setup(){
        calculadora = new Calculadora();
    }

    @Test
    public void calcularSomaDoisNumeros(){
        // Cenário

        // Execução
        int resultado = calculadora.somar(numero1, numero2);

        // Verificações

        Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test
    @DisplayName("Não deve somar numeros negativos")
    public void naoDeveSomarNumerosNegativos(){
        int num1 = -10, num2 = 5;

        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> calculadora.somar(num1, num2));
    }



    @Test
    @DisplayName("Deve subtrair 2 numeros")
    public void deveSubtrair2Numeros(){
        int resultado = calculadora.subtrair(numero1, numero2);
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test
    public void deveMultiplicar2Numeros(){
        int resultado = calculadora.multiplicar(numero1, numero2);
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    public void deveDividir2Numeros(){
        float resultado = calculadora.dividir(numero1,numero2);
        Assertions.assertThat(resultado).isEqualTo(2);
    }

    @Test
    @DisplayName("Não deve dividir por zero")
    public void naoDeveDividirPorZero(){
        int numero1 = 10, numero2 = 0;
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> calculadora.dividir(numero1,numero2) );
    }

}

class Calculadora{

    int somar(int num1, int num2){
        if(num1 < 0 || num2 < 0 ){
           throw new RuntimeException("Não é permitido somar números negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido subtrair números negativos");
        }
        return num1 - num2;
    }

    int multiplicar(int num1, int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido multiplicar números negativos");
        }
        return num1 * num2;
    }

    float dividir(int num1, int num2){
        return num1 / num2;
    }

}