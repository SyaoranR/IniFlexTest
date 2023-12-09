package classes;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
    
    public Funcionario(String nome, LocalDate dtNasc, 
                BigDecimal salario, String funcao) {
        super(nome, dtNasc);
        this.salario = salario;
        this.funcao = funcao;
    }

    public void setSalario (BigDecimal salario) {
        this.salario = salario;
    }
    
    public BigDecimal getSalario () {
        return this.salario;
    }

    public void setFuncao (String funcao) {
        this.funcao = funcao;
    }
    
    public String getFuncao () {
        return this.funcao;
    }

    public void aumentoSalario(double porc) {
        BigDecimal valorAdc = salario.multiply(BigDecimal.valueOf(porc / 100));
        salario = salario.add(valorAdc);
    }  
    
}
