package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    //java8
    public static void main(String arg[]){
        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta(1,"Leonardo"));
        contas.add(new Conta(2,"Fulano"));
        contas.add(new Conta(3,"Ciclano"));

        contas.sort(Comparator.comparingInt(Conta::getNumero));//Sort por numero

        //printar o nome
        contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .forEach(conta -> System.out.println(conta.getTitular()));//para cada conta filtrada, "printar" o titular

        //printar o numero
        contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .map(Conta::getTitular)//para cada conta filtrada, pegar o titular e retornar em um stream de string
                .forEach(System.out::println); //para cada titular(string), "print"

        //soma e printar o numero
        int soma = contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .mapToInt(Conta::getNumero)//para cada conta filtrada, pegar o numero e retornar em um stream de int e
                .sum();//somar cada valor;

        System.out.println(soma);

//        //soma e printar o saldo
//        BigDecimal soma2 = contas.stream()//Abre o fluxo
//                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
//                .map(Conta::getSaldo)//para cada conta filtrada, pegar o saldo e retornar em um stream de BigDecimal e
//                .sum();//somar cada valor;
//
//        System.out.println(soma);

        //printar um titular
        contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .findAny()//retorna um optional com um valor filtrado, caso nao tenha retorna um optional vazio
                .map(Conta::getTitular)//pega o titular, se o optinal nao for vazio, se nao termina o stream aqui
                .ifPresent(System.out::println);//"Printa o valor"

        //retorna uma lista
        List<Conta> contasFiltradas = contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .collect(Collectors.toList());//transforme numa lista

        //retorna um map e "printa" ele
        Map<Integer, Conta> mapDeContas = contas.stream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .collect(Collectors.toMap(
                        Conta::getNumero,
                        conta -> conta));//transforme num map

        mapDeContas.forEach((numero, conta) -> System.out.println("Numero: " + numero + " Saldo: " + conta.getSaldo()));

        //Junta os dois de cima
        contas.parallelStream()//Abre o fluxo
                .filter(conta -> conta.getNumero() >= 2)//filtre as contas com numero maios ou igual a 2
                .collect(Collectors.toMap(
                        Conta::getNumero,
                        conta -> conta))//transforme num map
                .forEach((numero, conta) -> System.out.println("Numero: " + numero + " Saldo: " + conta.getSaldo()));

    }

}
