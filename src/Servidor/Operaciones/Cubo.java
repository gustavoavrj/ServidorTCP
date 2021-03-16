package Servidor.Operaciones;

public class Cubo implements InterfazOperaciones{
    private double resultado;
    private double lado;

    public Cubo (double lado) {
        this.lado = lado;

    }

    @Override
    public double area() {
        System.out.println("Calculando area de Cubo");
        resultado = Math.pow(lado, 2) * 6;
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Cubo");
        resultado = Math.pow(lado, 3);
        return resultado;
    }
}
