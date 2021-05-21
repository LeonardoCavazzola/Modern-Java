package lambdas;

import java.util.*;

public class OrdenaStrings {

    public static void main(String[] args) {
        jeitoAntigo1();
        jeitoAntigo2();
        comLambda1();
        comLambda2();
        comMethodReference1();
    }

    public static void jeitoAntigo1() {

        List<String> palavras = new ArrayList<>(Arrays.asList("alura online", "casa do código", "caelum"));
        System.out.println(palavras);

        Comparator<String> comparador = new ComparadorDeStringPorTamanho();
        Collections.sort(palavras, comparador);
        System.out.println(palavras);
    }

    public static void jeitoAntigo2() {

        List<String> palavras = new ArrayList<>(Arrays.asList("alura online", "casa do código", "caelum"));
        System.out.println(palavras);

        Comparator<String> comparador = new ComparadorDeStringPorTamanho();
        palavras.sort(comparador);
        System.out.println(palavras);
    }


    //java8
    public static void comLambda1() {

        List<String> palavras = new ArrayList<>(Arrays.asList("alura online", "casa do código", "caelum"));
        System.out.println(palavras);

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(palavras);
    }

    //java8
    public static void comLambda2() {

        List<String> palavras = new ArrayList<>(Arrays.asList("alura online", "casa do código", "caelum"));
        System.out.println(palavras);

        palavras.sort(Comparator.comparing(palavra -> palavra.length()));
        System.out.println(palavras);
    }

    //java8
    public static void comMethodReference1(){
        List<String> palavras = new ArrayList<>(Arrays.asList("alura online", "casa do código", "caelum"));
        System.out.println(palavras);

        palavras.sort(Comparator.comparing(String::length));
        System.out.println(palavras);
    }
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }

}
