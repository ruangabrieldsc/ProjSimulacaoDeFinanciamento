package main;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;
import modelo.Financiamento;

import java.io.*;

//RUAN GABRIEL DOS SANTOS CUNHA
//Análise e Desenvolvimento de Sistemas
//PUCPR

public class Main {
    public static void main(String[] args){
        InterfaceUsuario user = new InterfaceUsuario();

        //Financiamentos sendo criados

        Casa casinha = new Casa(50, 10, 1, 60, 89);
        //casinha.dados();
        user.addFinanciamento(casinha);
        InterfaceUsuario.salvarArquivos(casinha);

        Casa casinha2 = new Casa(70000, 45, 18, 60, 89);
        //casinha2.dados();
        user.addFinanciamento(casinha2);
        InterfaceUsuario.salvarArquivos(casinha2);

        Casa casinha3 = new Casa(350000, 32, 23, 690, 898);
        //casinha3.dados();
        user.addFinanciamento(casinha3);
        InterfaceUsuario.salvarArquivos(casinha3);

        Financiamento terreno = new Terreno(500000, 10, 10, "Comercial");
        //terreno.dados();
        user.addFinanciamento(terreno);
        InterfaceUsuario.salvarArquivos(terreno);

        Financiamento terreno2 = new Terreno(6090000, 30, 15, "Comercial");
        //terreno2.dados();
        user.addFinanciamento(terreno2);
        InterfaceUsuario.salvarArquivos(terreno2);

        Financiamento terreno3 = new Terreno(580000, 20, 25, "Residencial");
        //terreno3.dados();
        user.addFinanciamento(terreno3);
        InterfaceUsuario.salvarArquivos(terreno3);

        Financiamento ape1 = new Apartamento(56000, 5, 12, 50, 3);
        //ape1.dados();
        user.addFinanciamento(ape1);
        InterfaceUsuario.salvarArquivos(ape1);

        Financiamento ape2 = new Apartamento(56000, 5, 12, 50, 3);
        //ape2.dados();
        user.addFinanciamento(ape2);
        InterfaceUsuario.salvarArquivos(ape2);

        Financiamento ape3 = new Apartamento(56000, 5, 12, 50, 3);
        //ape3.dados();
        user.addFinanciamento(ape3);
        InterfaceUsuario.salvarArquivos(ape3);

        //Fazer financiamento com scanner
        user.fazerFinanciamento();

        //Retirar o comentário para mostrar o financiamento
        //user.mostrarFinanciamentos();
        user.mostrarValores();

        //Retirar comentário para ler o arquivo txt
        //InterfaceUsuario.lerArquivos();



        //Escrevendo e lendo objetos
        ObjectOutputStream escritor = null;

        try{
            escritor = new ObjectOutputStream(new FileOutputStream("Objetos.test", true));

            escritor.writeObject(casinha);
            escritor.writeObject(casinha2);
            escritor.writeObject(casinha3);
            escritor.writeObject(terreno);
            escritor.writeObject(terreno2);
            escritor.writeObject(terreno3);
            escritor.writeObject(ape1);
            escritor.writeObject(ape2);
            escritor.writeObject(ape3);
            escritor.writeObject(user.getFinanEspec(9)); //escreve o financiamento feito no scanner


            escritor.flush();
            escritor.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();

        }

        //lê os objetos
        InterfaceUsuario.lerObjetos();



    }
}

