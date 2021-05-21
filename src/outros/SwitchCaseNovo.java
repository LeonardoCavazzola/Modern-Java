package outros;

public class SwitchCaseNovo {

    //Requer java 14
    public static void main(String[] args) {
        String nome = "fulano";
        switch (nome) {
            case "fulano" -> System.out.println("nome = " + nome);
            case "ciclano" -> {
                System.out.println("nome = " + nome);
                System.out.println("nome = " + nome);}
            default -> System.out.println("nada");
        }
    }
}
