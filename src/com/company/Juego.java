//package com.company;
//
//import java.util.Scanner;
//
//public class Juego {
//    int rondas;
//    Jugador jugador = new Jugador();
//    Master master = new Master();
//    Scanner scanner = new Scanner(System.in);
//    void jugar(){
//
//        System.out.println("Dime tu nombre: ");
//        jugador.nombre = scanner.nextLine();
//        System.out.println("Cuantas rondas quieres jugar?");
//        rondas = scanner.nextInt();
//
//        System.out.println("\nComenzamos la partida");
//        for (int i = 0; i < rondas; i++) {
//            System.out.println("Ronda " + (i+1));
//            System.out.println("--------");
//
//            master.crearOperacion();
//
//            if (master.respuesta == master.solucion){
//                jugador.puntuacion++;
//                System.out.println("Respuesta CORRECTA");
//            }else{
//                System.out.println("Respuesta ERRONEA");
//            }
//
//        }
//
//        System.out.println("Fin de la partida");
//        System.out.println("\nHas conseguido: " + jugador.puntuacion + " puntos");
//    }
//}
