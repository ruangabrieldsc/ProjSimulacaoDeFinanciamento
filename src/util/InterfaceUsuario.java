package util;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceUsuario {
    private ArrayList<Financiamento> financiamentos;

    public InterfaceUsuario(){
        this.financiamentos=new ArrayList<Financiamento>();

    }
    //"submétodos" dedicados ao método FazerFinanciamento
    public static double pedirvalor() {
        double valr=0;
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        while (b){
        System.out.println("Qual é o valor do imóvel? ");
        try{
            valr= scan.nextDouble();
        } catch (Exception e){
            System.out.println("Você digitou um valor inválido.");
            System.out.println("O valor será definido como padrão (1)");
            valr = 1;

        }

        if (valr<0){
            System.out.println("Valor inválido.");
            continue;
        }
        else{
            break;
        }}
        return valr;
    }

    public static int pedirprazo() {
        int prazo=0;
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        while (b){
            System.out.println("Qual é o prazo do financiamento (em anos)? ");
            try{
                prazo= scan.nextInt();
            } catch (Exception e){
                System.out.println("Você digitou um prazo inválido.");
                System.out.println("O prazo será definido como padrão (1)");
                prazo = 1;
            }


            if (prazo<0 || prazo>999){
                System.out.println("Valor inválido.");
                continue;
            }
            else{
                break;
            }}
        return prazo;
    }


    public static double pedirtaxa() {
            double taxa=0;
            Scanner scan = new Scanner(System.in);
            boolean b = true;
            while (b){
                System.out.println("Qual é a taxa de juros? ");

                try{
                    taxa = scan.nextDouble();
                } catch (Exception e){
                    System.out.println("Você digitou uma taxa inválida.");
                    System.out.println("A taxa será definida como padrão (1)");
                    taxa = 1;
                }



                if (taxa<0 || taxa>9999){
                    System.out.println("Valor inválido.");
                    continue;
                }
                else{
                    break;
                }}
            return taxa;
        }

    public static double pedirTamanho() {
        double t=0;
        Scanner scan2 = new Scanner(System.in);
        boolean b = true;
        while (b){
            System.out.println("Qual é o tamanho do terreno? ");

            try{
                t = scan2.nextDouble();
            } catch (Exception e){
                System.out.println("Você digitou um tamanho inválido.");
                System.out.println("O tamanho será definido como padrão (1)");
                t = 1;
            }


            if (t<0){
                System.out.println("Valor inválido.");
                continue;
            }
            else{
                break;
            }}
        return t;
    }

    public static double pedirAreaCons() {
        double a=0;
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        while (b){
            System.out.println("Qual é o tamanho da área construída? ");

            try{
                a= scan.nextDouble();
            } catch (Exception e){
                System.out.println("Você digitou uma área inválida.");
                System.out.println("A área será definida como padrão (1)");
                a = 1;
            }



            if (a<0){
                System.out.println("Valor inválido.");
                continue;
            }
            else{
                break;
            }}
        return a;
    }

    public static int pedirAndares() {
        int an=0;
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        while (b){
            System.out.println("Quantos andares o prédio possui? ");

            try{
                an= scan.nextInt();
            } catch (Exception e){
                System.out.println("Você digitou um número de andares inválido.");
                System.out.println("O número de andares será definido como padrão (1)");
                an = 1;
            }



            if (an<0){
                System.out.println("Valor inválido.");
                continue;
            }
            else{
                break;
            }}
        return an;
    }

    public static int pedirVagas() {
        int v=0;
        Scanner scan = new Scanner(System.in);
        boolean b = true;
        while (b){
            System.out.println("Quantos vagas o estacionamento possui? ");

            try{
                v= scan.nextInt();
            } catch (Exception e){
                System.out.println("Você digitou um número de vagas inválido.");
                System.out.println("O número de vagas será definido como padrão (1)");
                v = 1;
            }


            if (v<0){
                System.out.println("Valor inválido.");
                continue;
            }
            else{
                break;
            }}
        return v;
    }

    public static String Zona(){
        Scanner scan=new Scanner(System.in);
        boolean a=true;
        String choice="";


        while(a){

            System.out.println("----------");
            System.out.println("É uma zona residencial(R) ou comercial(C)? ");
            String escolha=scan.next();


        switch (escolha){

            case "R":
                choice = "Residencial";
                a=false;
                break;

            case "C":
                choice = "Comercial";
                a=false;
                break;

            default:
                System.out.println("Valor inválido.");


        }}


        return choice;
    }






    public void fazerFinanciamento(){
        Scanner scan=new Scanner(System.in);
        boolean v=true;

        while (v){

        System.out.println("----------");
        System.out.println("Qual tipo de Financiamento deseja fazer? ");
        System.out.println("1-Casa");
        System.out.println("2-Terreno");
        System.out.println("3-Apartamento");
        System.out.println();
        System.out.println("----------          ");

        //Menu de escolha e uso de switch

        String escolha=scan.next();

        switch (escolha){

            case "1":
                double vlr= InterfaceUsuario.pedirvalor();
                int prz= InterfaceUsuario.pedirprazo();
                double tx= InterfaceUsuario.pedirtaxa();
                double ta= InterfaceUsuario.pedirAreaCons();
                double tt= InterfaceUsuario.pedirTamanho();
                System.out.println();

                Casa f1 = new Casa(vlr, prz, tx, ta, tt);
                this.financiamentos.add(f1);
                InterfaceUsuario.salvarArquivos(f1);
                v=false;
                break;

            case "2":
                double vlr2= InterfaceUsuario.pedirvalor();
                int prz2= InterfaceUsuario.pedirprazo();
                double tx2= InterfaceUsuario.pedirtaxa();
                String zn= InterfaceUsuario.Zona();
                System.out.println();

                Terreno f2 = new Terreno(vlr2, prz2, tx2, zn);
                this.financiamentos.add(f2);
                InterfaceUsuario.salvarArquivos(f2);
                v=false;
                break;

            case "3":
                double vlr3= InterfaceUsuario.pedirvalor();
                int prz3= InterfaceUsuario.pedirprazo();
                double tx3= InterfaceUsuario.pedirtaxa();
                int vg = InterfaceUsuario.pedirVagas();
                int ad = InterfaceUsuario.pedirAndares();
                System.out.println();

                Apartamento f3 = new Apartamento(vlr3, prz3, tx3, vg, ad);
                this.financiamentos.add(f3);
                InterfaceUsuario.salvarArquivos(f3);
                v=false;
                break;

            default:
                System.out.println("Valor inválido.");
        }}

    }

    public void mostrarFinanciamentos(){
        for (int i = 0; i < this.financiamentos.size(); i++){
            int j=i+1;
            System.out.println("Dados do financiamento "+ j + ":");
            financiamentos.get(i).dados();
            System.out.println("----------------------------------");

        }
    }

    public Object getFinanEspec(int index){
        return financiamentos.get(index);
        //método para ser possível escrever do ArrayList p/ o .test
    }

    public void mostrarValores(){ //mostra o valor de todos os financiamentos somados
        double Y=0;
        double X=0;

        for (int i = 0; i < this.financiamentos.size(); i++){

            Y = Y + financiamentos.get(i).getValorImovel();
        }
        System.out.printf("Valor de todos os Financiamentos: %.2f", Y);
        System.out.println();

        for (int j = 0; j < this.financiamentos.size(); j++){
            X = X + financiamentos.get(j).totalPagamento();
        }
        System.out.printf("Valor de todos os Financiamentos com juros inclusos: %.2f", X);
        System.out.println();
    }

    public void mostrarFinanciamentoEspecifico(int index){
        if (index >=0 && index < this.financiamentos.size()){
            this.financiamentos.get(index).dados();
        }
    }

    public void addFinanciamento(Financiamento X){
        this.financiamentos.add(X);

    }

    public static void salvarArquivos(Financiamento X){
        String textoParaEscrever=X.dadosA();
        FileWriter writer=null;
        int contL=0;


        try{
            writer = new FileWriter("ListaFinanciamentos.txt", true);

            while(contL<textoParaEscrever.length()){
                writer.write(textoParaEscrever.charAt(contL));
                contL++;
            }

            writer.flush();
            writer.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }



    }

    public static void lerArquivos(){
        FileReader leitor = null;

        try{
            leitor = new FileReader("ListaFinanciamentos.txt");

            int cont=0;

            while ((cont= leitor.read()) != -1){
                System.out.print((char)cont);
            }

            leitor.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }


    }

    public static void lerObjetos(){
        ObjectInputStream InputStream = null;

        try{
            InputStream = new ObjectInputStream(new FileInputStream("Objetos.test"));

            Object obj = null;

            while((obj = InputStream.readObject()) != null) {
                if (obj instanceof Financiamento)
                    System.out.println(((Financiamento)obj).dadosA());

            }

            InputStream.close();

        }catch(EOFException e){
            System.out.println("");

        } catch(IOException e){
            e.printStackTrace();

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }



}
