package com.company;

import java.util.Scanner;

public class Master {
    Scanner scanner = new Scanner(System.in);
    int digito1;
    int digito2;
    int selectOperador;
    int solucion;
    int respuesta;
    String[] operador = {"+","-","x"};

    void crearOperacion(){
        digito1 = (int) (Math.random() * 99);
        digito2 = (int) (Math.random() * 99);
        selectOperador = (int) (Math.random() * 3);

        System.out.println("Operacion:");
        System.out.println(digito1 +" "+ operador[selectOperador] +" "+ digito2);

        if (selectOperador == 0){
            solucion = digito1+digito2;
        }else if (selectOperador == 1){
            solucion = digito1-digito2;
        }else{
            solucion = digito1*digito2;
        }

        respuesta = scanner.nextInt();
    }
}
