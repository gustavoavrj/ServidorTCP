package Servidor.Operaciones;

public class Prisma implements InterfazOperaciones{
    private double resultado;
    private double altura;
    private double lado;

    public Prisma (double altura, double lado) {
        this.altura = altura;
        this.lado = lado;

    }

    @Override
    public double area() {
        System.out.println("Calculando area de Prisma");
        resultado = ((lado * 4) * altura) + 2 * Math.pow(lado, 2);
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Prisma");
        resultado = Math.pow(lado, 2) * altura;
        return resultado;
    }
}
