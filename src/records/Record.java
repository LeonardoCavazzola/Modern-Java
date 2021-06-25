package records;

public class Record {

    public static void main(String[] args) {

        //testa contrutor padrao:
        System.out.println("testa contrutor padrao: = " + new Pessoa("nome", "sobrenome"));

        //testa contrutor custom:
        System.out.println("testa contrutor custom: = " + new Pessoa("nome"));

        Pessoa pessoa = new Pessoa("nome", "sobrenome");
        Pessoa pessoa2 = new Pessoa("nome", "n");

        //testa getter:
        System.out.println("testa getter: = " + pessoa.nome());

        //testa hashcode:
        System.out.println("testa hashcode: = " + pessoa.hashCode());

        //testa equals:
        System.out.println("testa equals: = " + pessoa.equals(pessoa2)); // deve ser false
    }
}
