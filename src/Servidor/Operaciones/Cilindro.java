package Servidor.Operaciones;

public class Cilindro implements InterfazOperaciones {
    private double resultado;
    private final double radio;
    private final double altura;

    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;

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
