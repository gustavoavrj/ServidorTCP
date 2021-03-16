package Servidor.Operaciones;

public class Piramide implements InterfazOperaciones {
    private double resultado;
    private double altura;
    private double lado;
    public Piramide (double altura, double lado) {
        this.altura = altura;
        this.lado = lado;

    }

    @Override
    public double area() {
        System.out.println("Calculando area de Piramide");
        resultado = lado * (lado + Math.sqrt(4 * Math.pow(altura, 2) + Math.pow(lado, 2)));
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Piramide");
        resultado = (Math.pow(lado, 2) * altura) / 3;
        return resultado;
    }
}
