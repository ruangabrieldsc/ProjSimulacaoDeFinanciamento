package modelo;

import modelo.Financiamento;
import util.AcrescimoMQJurosException;

import java.io.Serializable;
import java.sql.SQLOutput;

public class Casa extends Financiamento {

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valor, int prazo, double taxa, double areaC, double tamanhoT) {
        super(valor, prazo, taxa);
        this.areaConstruida=areaC;
        this.tamanhoTerreno=tamanhoT;
    }
    //tratamento de exceção
    public void verfificarAcrescimo(double jurosMensal, double Acrescimo) throws AcrescimoMQJurosException {
        if (jurosMensal<Acrescimo){
            throw new AcrescimoMQJurosException("");
        }

    }

    public double pagamentoMensal(){
        double Acrescimo = 80;
        double juros = getValorImovel()*(getTaxaMensal()/100);
        try{
            verfificarAcrescimo(juros, Acrescimo);
        } catch(AcrescimoMQJurosException e){
            Acrescimo=juros;


        }
        return super.pagamentoMensal()+Acrescimo;

    }

    public double totalPagamento(){
        double x=pagamentoMensal();
        return this.pagamentoMensal()*prazoFinanciamento*12;
    }

    public void dados(){
        double juros = getValorImovel()*(getTaxaMensal()/100);
        if(juros>80){
            System.out.println("O valor do acréscimo foi reajustado para ser equivalente ao seu juros mensal.");
        }
        System.out.println("----------------------------------");
        System.out.println("Casa:");
        System.out.printf("Valor do imóvel: "+"%.2f \n", getValorImovel());
        System.out.printf("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        System.out.print("% \n");
        System.out.printf("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        System.out.printf("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        System.out.println();}

    public String dadosA(){
        String a="----------------------------------\n";
        String b="Casa: \n";
        String c=String.format("Valor do imóvel: "+"%.2f \n", getValorImovel());
        String d=String.format("Taxa de juros anual: "+"%.2f", getTaxadeJurosAnual());
        String e="% \n";
        String f=String.format("Valor do financiamento: "+"%.2f \n", this.totalPagamento());
        String g=String.format("Valor do pagamento mensal: "+"%.2f \n", this.pagamentoMensal());
        String test=a+b+c+d+e+f+g;
        return test;
    }


    }




