package Servidor.Operaciones;

public class Esfera implements InterfazOperaciones{
    private double resultado;
    private double radio;
    public Esfera (double radio) {
        this.radio = radio;
    }
    @Override
    public double area() {
        System.out.println("Calculando area de Esfera");
        resultado =  4 * Math.PI * Math.pow(radio, 2);
        System.out.println(resultado);
        return resultado;

    }
    @Override
    public double volumen() {
        System.out.println("Calculando volumen de Esfera");
        resultado = (4 * Math.PI * Math.pow(radio, 3)) / 3;
        return resultado;
    }
}
