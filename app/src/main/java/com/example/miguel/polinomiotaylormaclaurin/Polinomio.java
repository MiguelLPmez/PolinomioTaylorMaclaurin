package com.example.miguel.polinomiotaylormaclaurin;

public class Polinomio {

    private int n, x, derivada, resultadoDerivada;
    private double resultado;

    public enum Funcion{
        COSENO,
        SENO,
        EULER
    }

    private double polinomios(Funcion funcion, int x, int n){
        resultado = 0;
        for(int i = 0; i < n; i++){
            resultado += derivada(funcion, i) * Math.pow(x, i) / factorial(i);
        }
        return resultado;
    }

    private int derivada(Funcion funcion, int i){

        switch(funcion){
            case SENO:
                resultadoDerivada = (i%2 == 0)? 0 : (int) Math.pow(-1,i+1);// Si es par = 0      Si es impar alterna entre 1 y -1
                break;
            case COSENO:
                resultadoDerivada = (i%2 == 1)? 0 : (int) Math.pow(-1,i);// Si es impar = 0      Si es par alterna entre 1 y -1
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
