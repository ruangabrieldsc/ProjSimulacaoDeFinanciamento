package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento{

    private String zona;

    public Terreno(double valor, int prazo, double taxa, String tipodezona) {
        super(valor, prazo, taxa);
        this.zona=tipodezona;
    }

    public double pagamentoMensal(){
        return super.pagamentoMensal()*1.02;

    }

    public double totalPagamento(){
        return this.pagamentoMensal()*prazoFinanciamento*12;
    }

    public void dados(){
        System.out.println("----------------------------------");
        System.out.println("Terreno: ");
        System.out.printf("Valor do imóvel: "+"%.2f \n", getValorImovel());
        System.out.printf("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        System.out.print("% \n");
        System.out.printf("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        System.out.printf("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        System.out.println();}

    public String dadosA(){
        String a="----------------------------------\n";
        String b="Terreno: \n";
        String c=String.format("Valor do imóvel: "+"%.2f \n", getValorImovel());
        String d=String.format("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        String e="% \n";
        String f=String.format("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        String g=String.format("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        String test=a+b+c+d+e+f+g;
        return test;
    }

}
