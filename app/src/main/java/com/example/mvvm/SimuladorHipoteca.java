package com.example.mvvm;

public class SimuladorHipoteca {

    public void main(String[] args) {
        int num = -3;

        int precio = 0;

        try {
            precio = calcularPrecio(num);
            System.out.println(precio);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public double calcular(SolicitudHipoteca solicitud) {
        double interes = 0;
        try {
            Thread.sleep(10000);   // simular operacion de larga duracion (10s)
            interes = 0.01605;
        } catch (InterruptedException e) {}

        return solicitud.capital*interes/12/(1-Math.pow(1+(interes/12),-solicitud.plazo*12));
    }

    int calcularPrecio(int numarticulos) throws Exception {
        if(numarticulos < 0){
            throw new Exception();
        }
        return numarticulos*10;
    }
}

