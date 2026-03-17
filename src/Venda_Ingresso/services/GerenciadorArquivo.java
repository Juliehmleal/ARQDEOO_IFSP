package Venda_Ingresso.services;

import Venda_Ingresso.entities.Ingresso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorArquivo {

    public void serializar(List<Ingresso> ingressos, String path){

        try{

            ObjectOutputStream oos =
                    new ObjectOutputStream(new FileOutputStream(path));

            oos.writeObject(ingressos);
            oos.close();

        }catch(IOException e){

            System.out.println("Erro ao salvar dados: " + e.getMessage());

        }finally{

            System.out.println("Operação de serialização finalizada.");

        }
    }

    public List<Ingresso> desserializar(String path){

        List<Ingresso> ingressos = new ArrayList<>();

        try{

            ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream(path));

            ingressos = (List<Ingresso>) ois.readObject();

            ois.close();

        }catch(IOException | ClassNotFoundException e){

            System.out.println("Arquivo não encontrado. Lista inicializada.");

        }

        return ingressos;
    }

}