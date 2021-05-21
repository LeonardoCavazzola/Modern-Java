import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NovoForEach {

    //java8
    public static void main(String[] args){
        List<String> palavras = new ArrayList<>();

        // -*- Adicionando algumas palavras a nossa lista -*-
        palavras.add("Martelo");
        palavras.add("Prego");
        palavras.add("Caneta");

        // -*- ForEach antigo
        for (String palavra:palavras) {
            System.out.println(palavra);
        }

        // -*- ForEach novo
        palavras.forEach(palavra -> System.out.println(palavra));

        // -*- ForEach novo ainda mais resumido
        palavras.forEach(System.out::println);

        List<Integer> itens = Arrays.asList( 11, 10, 16, 5, 85 );

        for(Integer item : itens){
            if ( item > 16 )
                System.out.println(item);
        }

        itens.stream().filter(i -> i > 16).forEach(System.out::println);
    }




}
