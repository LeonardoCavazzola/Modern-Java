package streams;

import java.math.BigDecimal;

public class Conta {
    private int numero;
    private String titular;
    private BigDecimal saldo = BigDecimal.valueOf(0);

    public Conta(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal sacar(BigDecimal valorDoSaque) {
        this.saldo = this.saldo.subtract(valorDoSaque);
        return this.saldo;
    }

    public BigDecimal depositar(BigDecimal valorDoSaque) {
        this.saldo = this.saldo.subtract(valorDoSaque);
        return this.saldo;
    }
}
