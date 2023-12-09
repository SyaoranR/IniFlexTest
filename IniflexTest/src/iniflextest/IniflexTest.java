/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniflextest;

import classes.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author Alessandro Fraga Gomes
 */
public class IniflexTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        // Employees' Birth

        LocalDate dt1 = LocalDate.parse("18/10/2000", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt2 = LocalDate.parse("12/05/1990", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt3 = LocalDate.parse("02/05/1961", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt4 = LocalDate.parse("14/10/1988", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt5 = LocalDate.parse("05/01/1995", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt6 = LocalDate.parse("19/11/1999", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt7 = LocalDate.parse("31/03/1993", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt8 = LocalDate.parse("08/07/1994", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt9 = LocalDate.parse("24/05/2003", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        LocalDate dt10 = LocalDate.parse("02/09/1996", 
        DateTimeFormatter.ofPattern("dd/MM/yyyy"));    
        
        // Employees List
        
        Funcionario[] funcionarios = {
            new Funcionario("Maria", dt1, new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", dt2, new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", dt3, new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", dt4, new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", dt5, new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", dt6, new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", dt7, new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", dt8, new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", dt9, new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", dt10, new BigDecimal("2799.93"), "Gerente"),
        };

        // Removes employee if NAME equals João

        List<Funcionario> funcList = new ArrayList<>(Arrays.asList(funcionarios));
        funcList.removeIf(funcionario -> funcionario.getNome().equals("João"));

        // Picks print method to print employees before new salary of 10%

        System.out.println("Empregados antes do reajuste salarial:");
        printFuncionarios(funcList);

        funcList.forEach(funcionario -> funcionario.aumentoSalario(10));

         // Picks print method to print employees with new salary of 10%

        System.out.println("\nEmpregados após o reajuste salarial:");
        printFuncionarios(funcList);

        // Group Employees by Role

        Map<String, List<Funcionario>> funcionarioMap = funcList.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        // Print Employees by Role

        System.out.println("\nEmpregados agrupados por função:");
        printFuncionarioMap(funcionarioMap);

        // Print Employees with birthdays at October and December

        System.out.println("\nEmpregados cujos aniversários estão no 10º e 12º mês:");
        printFuncionariosMesNiver(funcList, 10, 12);

        // Print oldest Employee

        Funcionario funcMaisVeio = Collections.max(funcList, Comparator.comparingInt(Funcionario::getIdade));
        System.out.println("\nEmpregado mais velho: " + funcMaisVeio.getNome() + ", idade: " + funcMaisVeio.getIdade());

        // Order Employees alphabetically

        funcList.sort(Comparator.comparing(Funcionario::getNome));
        System.out.println("\nEmpregados em ordem alfabética:");
        printFuncionarios(funcList);

        // Total employees salary

        System.out.println("\nTotal de salários dos empregados: " + totalSalarios(funcList));
    }

    // Employees print method, with BRL formatted salary

    public static void printFuncionarios(List<Funcionario> funcionarios) {
        for (Funcionario funcionario : funcionarios) {
            DecimalFormat dcFormat = new DecimalFormat("R$ #,##0.00");
            System.out.println(funcionario.getNome() + ", " + funcionario.getFuncao() + ", " + dcFormat.format((funcionario.getSalario())));
        }
    }

    // Employees print method (for grouping by prints)
   
    public static void printFuncionarioMap(Map<String, List<Funcionario>> funcionarioMap) {
        for (Map.Entry<String, List<Funcionario>> entry : funcionarioMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
        }
    }

    // Printing Employees by Birthday months

    public static void printFuncionariosMesNiver(List<Funcionario> funcionarios, int... meses) {
        for (Funcionario funcionario : funcionarios) {
            for (int mes : meses) {
                if (funcionario.getDtNasc().getMonthValue() == mes) {
                    System.out.println(funcionario.getNome() + ", " + funcionario.getFuncao());
                    break;
                }
            }
        }
    }

    // Printing employees total salary (formatted)

    public static String totalSalarios(List<Funcionario> funcionarios) {
        BigDecimal total = BigDecimal.ZERO;
        DecimalFormat dcFormat = new DecimalFormat("R$ #,##0.00");
        for (Funcionario funcionario : funcionarios) {
            total = total.add(funcionario.getSalario());
        }
        return dcFormat.format(total);
    }

}

    

