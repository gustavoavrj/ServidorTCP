package Servidor.Operaciones;

public class Cono implements InterfazOperaciones {
    private double resultado;
    private double radio;
    private double altura;
    public Cono (double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }
    @Override
    public double area() {
        System.out.println("Calculando area de Cono");
        resultado = Math.PI * radio * (Math.sqrt(Math.pow(altura, 2) + Math.pow(radio, 2)) + radio);
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Cono");
        resultado = (Math.PI * Math.pow(radio, 2) * altura) / 3;
        return resultado;
    }

}
