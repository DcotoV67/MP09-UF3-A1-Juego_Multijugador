package com.company;

import java.io.*;
import java.net.Socket;

public class ClienteTCP {
        public static void main(String[] args)  throws IOException {
            Socket socketCliente = null;
            BufferedReader entrada = null;
            PrintWriter salida = null;

            // Creamos un socket en el lado cliente, enlazado con un
            // servidor que está en la misma máquina que el cliente
            // y que escucha en el puerto 4444
            try {
                socketCliente = new Socket("localhost", 4444);
                // Obtenemos el canal de entrada
                entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
                // Obtenemos el canal de salida
                salida = new PrintWriter(new BufferedWriter(new
                        OutputStreamWriter(socketCliente.getOutputStream())),true);
            } catch (IOException e) {
                System.err.println("No se pueden establecer canales de E/S para la conexión");
                System.exit(-1);
            }
            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));

            String linea;
            int num;
            int rondas;
            int i = 0;
            int resp = 0;
            try {

                linea = entrada.readLine();
                System.out.println(linea);
                num = entrada.read();
                rondas = num;
                salida.println(linea);
                linea = entrada.readLine();
                System.out.println(linea);

                while (true) {
                    linea = entrada.readLine();
                    System.out.println(linea);

                    linea = entrada.readLine();
                    System.out.println(linea);

                    linea = entrada.readLine();
                    System.out.println(linea);

                    linea = entrada.readLine();
                    System.out.println(linea);

                    resp = entrada.read();
                    if (i == rondas){
                    break;
                    }
                }
                System.out.println(entrada.readLine());
                System.out.println(entrada.readLine());

            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }

            // Libera recursos
            salida.close();
            entrada.close();
            stdIn.close();
            socketCliente.close();
        }

}
