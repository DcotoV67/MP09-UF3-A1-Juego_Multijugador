package com.company;

import javax.swing.plaf.basic.BasicListUI;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
    public static final int PORT = 4444;
    public static int rondas;
    public static Jugador jugador = new Jugador();
    public static int digito1;
    public static int digito2;
    public static int selectOperador;
    public static int solucion;
    public static int respuesta;
    public static String[] operador = {"+","-","x"};

    public static void main(String[] args) throws IOException {
        // Establece el puerto en el que escucha peticiones
        ServerSocket socketServidor = null;
        try {
            socketServidor = new ServerSocket(PORT);
        } catch (IOException e) {
            System.out.println("No se puede escuchar en el puerto: " + PORT);
            System.exit(-1);
        }

        Socket socketCliente = null;
        BufferedReader entrada = null;
        PrintWriter salida = null;

        System.out.println("Escuchando: " + socketServidor);
        try {
            // Se bloquea hasta que recibe alguna petición de un cliente
            // abriendo un socket para el cliente
            socketCliente = socketServidor.accept();
            System.out.println("Connexión acceptada: "+ socketCliente);
            // Establece canal de entrada
            entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            // Establece canal de salida
            salida = new PrintWriter(new BufferedWriter(new
                    OutputStreamWriter(socketCliente.getOutputStream())),true);

            // Comienza el juego
            salida.println("Cuantas rondas quieres jugar?");
            rondas = entrada.read();
            entrada.readLine();
            salida.println("\nComenzamos la partida");
            int i = 1;

            while (true) {
                //comienza el juego - bucle
                digito1 = (int) (Math.random() * 99);
                digito2 = (int) (Math.random() * 99);
                selectOperador = (int) (Math.random() * 3);

                //Pinta ronda + operacion
                salida.println("Ronda " + i );
                salida.println("--------");
                salida.println("Operacion: ");
                salida.println(digito1 +" "+ operador[selectOperador] +" "+ digito2);

                //calcula la solucion
                i++;
                if (selectOperador == 0){
                    solucion = digito1+digito2;
                }else if (selectOperador == 1){
                    solucion = digito1-digito2;
                }else{
                    solucion = digito1*digito2;
                }

                respuesta = entrada.read();

                if (respuesta == solucion){
                    jugador.puntuacion++;
                    salida.println("Respuesta CORRECTA");
                }else{
                    salida.println("Respuesta ERRONEA");
                }

                if (i == rondas){
                    break;
                }
            }

            salida.println("Fin de la partida");
            salida.println("\nHas conseguido: " + jugador.puntuacion + " puntos");


        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        salida.close();
        entrada.close();
        socketCliente.close();
        socketServidor.close();
    }

}
