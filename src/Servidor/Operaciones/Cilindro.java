package Servidor.Operaciones;
import Servidor.Operaciones.InterfazOperaciones;

public class Cilindro implements InterfazOperaciones {
    private double resultado;
    private double radio;
    private double altura;
    private double lado;
    public Cilindro (double radio, double altura, double lado) {
        this.radio = radio;
        this.altura = altura;
        this.lado = lado;

    }

    @Override
    public double area() {
        System.out.println("Calculando area de Cilindro");
        resultado = 2 * (Math.PI * (radio * (altura + radio)));
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Cilindro");
        resultado = Math.PI * Math.pow(radio, 2) * altura;
        return resultado;
    }
}
