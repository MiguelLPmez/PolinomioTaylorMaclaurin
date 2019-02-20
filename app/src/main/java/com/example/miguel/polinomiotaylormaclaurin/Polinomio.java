package com.example.miguel.polinomiotaylormaclaurin;

public class Polinomio {

    private int n, x, resultado, derivada;

    private void polinomios(){
        for(int i = 0; i < n; i++){
            resultado += derivada * Math.pow(x, i) / factorial(i);
        }
    }

    private int factorial(int numero){
        if(numero == 0) return 1;
        else return factorial(numero-1);
    }


}
