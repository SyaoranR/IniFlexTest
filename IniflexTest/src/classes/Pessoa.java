package classes;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dtNasc; 

    public Pessoa(String nome, LocalDate dtNasc) {
        this.nome = nome;
        this.dtNasc = dtNasc;
    }
        
    public void setNome (String nome) {
        this.nome = nome;
    }
    
    public String getNome () {
        return this.nome;
    }

    public void setDtNasc (LocalDate dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    public LocalDate getDtNasc () {
        return this.dtNasc;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - dtNasc.getYear();
    }
    
}
