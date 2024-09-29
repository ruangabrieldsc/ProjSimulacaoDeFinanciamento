package modelo;

import util.InterfaceUsuario;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Financiamento implements Serializable {
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxadeJurosAnual;

    public Financiamento(double valor, int prazo, double taxa){
        this.valorImovel=valor;
        this.prazoFinanciamento=prazo;
        this.taxadeJurosAnual=taxa;

    }

    public double pagamentoMensal(){
        double mensalidade=(valorImovel/(prazoFinanciamento*12))*(1+((taxadeJurosAnual/100)/12));
        return mensalidade;
    }

    public abstract double totalPagamento(); //método abstrato

    public double getTaxaMensal(){
        return this.taxadeJurosAnual/12;
    }


    public double getValorImovel(){
        return this.valorImovel;
    }
    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }
    public double getTaxadeJurosAnual(){
        return this.taxadeJurosAnual;
    }


    public void dados(){
        System.out.println("----------------------------------");
        System.out.printf("Valor do imóvel: "+"%.2f \n", getValorImovel());
        System.out.printf("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        System.out.print("% \n");
        System.out.printf("Valor do financiamento: "+"%.2f \n", totalPagamento());
        System.out.printf("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        System.out.println();

    }

    public abstract String dadosA(); //este método serve para mandar os dados para o txt


}

