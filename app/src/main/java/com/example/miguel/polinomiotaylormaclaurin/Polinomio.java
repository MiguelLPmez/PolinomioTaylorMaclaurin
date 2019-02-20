package com.example.miguel.polinomiotaylormaclaurin;

public class Polinomio {

    private int n, x, resultado, derivada, resultadoDerivada;

    private enum Funcion{
        COSENO,
        SENO,
        EULER
    }

    private void polinomios(Funcion funcion){
        resultado = 0;
        for(int i = 0; i < n; i++){
            resultado += derivada(funcion) * Math.pow(x, i) / factorial(i);
        }
    }

    private int derivada(Funcion funcion){

        switch(funcion){
            case SENO:
                break;
            case COSENO:
                break;
            case EULER:
                resultadoDerivada = 1;
                break;
            default: assert funcion != null;
        }
        return resultadoDerivada;
    }

    private int factorial(int numero){
        if(numero == 0) return 1;
        else return numero * factorial(numero-1);
    }


}
