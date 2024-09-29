package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento {
    private int numeroVagas;
    private int andares;

    public Apartamento(double valor, int prazo, double taxa, int vagas, int andar) {
        super(valor, prazo, taxa);
        this.numeroVagas=vagas;
        this.andares=andar;
    }
    //Cálculo pagamento mensal
    public double pagamentoMensal(){
        double taxaMensal=(this.getTaxadeJurosAnual()/100)/12;
        int meses=this.getPrazoFinanciamento()*12;
        double Cima=this.getValorImovel()*taxaMensal;
        double Baixo=1- Math.pow((1+taxaMensal), -meses);
        double MonthBill=Cima/Baixo;
        return MonthBill;

    }

    public double totalPagamento(){
        return this.pagamentoMensal()*prazoFinanciamento*12;
    }

    public void dados(){
        System.out.println("----------------------------------");
        System.out.println("Apartamento: ");
        System.out.printf("Valor do imóvel: "+"%.2f \n", getValorImovel());
        System.out.printf("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        System.out.print("% \n");
        System.out.printf("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        System.out.printf("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        System.out.println();

    }

    public String dadosA(){
        String a="----------------------------------\n";
        String b="Apartamento: \n";
        String c=String.format("Valor do imóvel: "+"%.2f \n", getValorImovel());
        String d=String.format("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        String e="% \n";
        String f=String.format("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        String g=String.format("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        String test=a+b+c+d+e+f+g;
        return test;
    }

}
