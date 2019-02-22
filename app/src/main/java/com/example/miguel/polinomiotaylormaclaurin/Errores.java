package com.example.miguel.polinomiotaylormaclaurin;

public final class Errores {

    private Errores(){

    }

    // - El valor del parámetro -función- determina el tipo de función a evaluar:
    //   SEN : 0,
    //   COS : 1,
    //   EXPONENCIAL : 2.

    private static double valorReal(int funcion, double punto){
        switch(funcion){
            case 0:
                return Math.sin(punto);
            case 1:
                return Math.cos(punto);
            case 2:
                return Math.exp(punto);
            default:
                return 0.0;
        }
    }

    public static double absoluto(int funcion, double punto, double resultadoEstimado){
        return Math.abs(resultadoEstimado - valorReal(funcion,punto));
    }

    public static double relativo(int funcion, double punto, double resultadoEstimado){
        return absoluto(funcion, punto, resultadoEstimado)/valorReal(funcion, punto);
    }

    public static double porcentual(int funcion, double punto, double resultadoEstimado){
        return absoluto(funcion, punto, resultadoEstimado) * 100;
    }

}
