package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class PrintStrings {

    public static void main(String[] args) {
        jeitoAntigo1();
        jeitoAntigo2();
        jeitoAntigo2Diferente();
        comLambda();
        comMethodReference();
    }

    public static void jeitoAntigo1(){
        List<String> palavras = new ArrayList<>(Arrays.asList("aa", "cc", "ca"));
        System.out.println(palavras);
        for(String palavra:palavras) {
           System.out.println(palavra);
        }

    }

    public static void jeitoAntigo2(){
        List<String> palavras = new ArrayList<>(Arrays.asList("aa", "cc", "ca"));
        System.out.println(palavras);

        Consumer<String> consumidor = new ConsumidorDeString(); // new na classe escrita no fim dessa classe
        palavras.forEach(consumidor);
    }

    public static void jeitoAntigo2Diferente(){ //Outra maneira de escrever o mesmo codigo de cima, Errado Também
        List<String> palavras = new ArrayList<>(Arrays.asList("aa", "cc", "ca"));
        System.out.println(palavras);

        Consumer<String> consumidor = new Consumer<String>() { // new no interface e implementa o metodo do interface

            public void accept(String s) {// Metodo do interface
                System.out.println(s);
            }

        };
        palavras.forEach(consumidor);
    }

    //java8
    public static void comLambda(){ // Lambda
        List<String> palavras = new ArrayList<>(Arrays.asList("aa", "cc", "ca"));
        System.out.println(palavras);

        palavras.forEach(palavra -> {
            System.out.println(palavra);
        });
    }

    //java8
    public static void comMethodReference(){
        List<String> palavras = new ArrayList<>(Arrays.asList("aa", "cc", "ca"));
        System.out.println(palavras);

        palavras.forEach(System.out::println);
    }
}

class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}

