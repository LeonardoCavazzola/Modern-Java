package records;

import java.util.Objects;

public record Pessoa(String nome, String sobrenome) {

    //Gera automaticamente:
    //      * Um construtor público com um argumento para cada atributo
    //      * Métodos getters públicos, cujos nomes correspondem ao nome do nosso atributo
    //      * Equals, retorna verdadeiro se o objeto fornecido for do mesmo tipo e os valores de todos os seus campos corresponderem
    //      * hashCode para todos os atributos
    //      * toString equivalete a: Pessoa[nome=Nome, sobrenome=Sobrenome], para cada atributo

    //Compact constructor, usado para adicionar lógica ao construtor e receber todos os parametros (Substitui o construtor padrão)
    public Pessoa {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(sobrenome);
    }

    //Custom constructor, para mudar os parametros.
    public Pessoa(String nome) {
        this(nome, "Unknown");// equivalente a: new Pessoa(nome, "Unknown");
    }
}
