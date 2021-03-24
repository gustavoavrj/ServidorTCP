package Protocolo;

public class Protocolo {
    private String cadena;
    private String operacion;
    private String figura;
    private String valores;
    private double radio;
    private double lado;
    private double altura;
    private String newCadena;


    public Protocolo() {

    }


    public void decodificarCadena(String cadena) {
        this.cadena = cadena;
        this.operacion = String.valueOf(cadena.split("\\|")[1].charAt(0));
        this.figura = cadena.split("\\|")[2].substring(0, 2);
        this.valores = cadena.split("\\|")[3];
        this.radio = Double.parseDouble(valores.split(";")[0].split(":")[1]);
        this.altura = Double.parseDouble(valores.split(";")[1].split(":")[1]);
        this.lado = Double.parseDouble(valores.split(";")[2].split(":")[1]);


    }

    public String codificarCadena(Double resultado) {
        this.newCadena = String.format("$#O|%s#F|%s# RES|%f#$", this.operacion, this.figura, resultado);
        return this.newCadena;
    }

    public String decodificarCliente(String cadena) {
        this.newCadena = cadena.split("\\|")[3].split("#")[0];
        return this.newCadena;
    }

    public String operacion() {
        return this.operacion;
    }

    public String figura() {
        return this.figura;
    }

    public double getRadio() {
        return this.radio;
    }

    public double getAltura() {
        return this.altura;
    }

    public double getLado() {
        return this.lado;
    }
}
