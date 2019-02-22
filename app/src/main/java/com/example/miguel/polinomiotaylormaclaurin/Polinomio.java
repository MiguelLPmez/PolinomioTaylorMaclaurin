package com.example.miguel.polinomiotaylormaclaurin;

public class Polinomio {

    public enum Funcion{
        COSENO,
        SENO,
        EULER
    }

    public double polinomios(Funcion funcion, double x, int n){
        double resultado = 0;
        for(int i = 0; i < n; i++){
            resultado += derivada(funcion, i) * Math.pow(x, i) / factorial(i);
        }
        return resultado;
    }

    private int derivada(Funcion funcion, int i){
        switch(funcion){
            case SENO:
                return (i%2 == 0)? 0 : (int) Math.pow(-1,(i-1)/2);
            case COSENO:
                return (i%2 == 0)? (int) Math.pow(-1,(i+1)/2): 0;
            case EULER:
                return 1;
            default: assert funcion != null;
        }
        return 0;
    }

    private int factorial(int numero){
        return (numero <= 1)? 1: numero * factorial(numero-1);
    }
}
