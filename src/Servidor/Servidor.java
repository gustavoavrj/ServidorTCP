package Servidor;

import Conexion.Conexion;
import Protocolo.Protocolo;
import Servidor.Operaciones.*;

import java.io.*;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Servidor extends Conexion {
    double resultado;

    public Servidor() throws IOException {
        super("servidor");
    } //Se usa el constructor para servidor de Conexion

    private static void logger(InetAddress ipRemitente, int puertoRemitente, String entradas, String resultado) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-dyyyy HH:mm:ss:SS");
            File archivo = new File("serverlogs.log");
            FileHandler fh;
            Logger logger = Logger.getLogger("MyLog");
            fh = new FileHandler(archivo.getAbsolutePath(), true);
            logger.addHandler(fh);
            SimpleFormatter logs = new SimpleFormatter();
            fh.setFormatter(logs);

            System.out.println(formatter.format(new Date()) + "\tCliente = " + ipRemitente
                    + ":" + puertoRemitente + "\tEntradas = " + entradas + "\tSalida = " + resultado);
            logger.info(formatter.format(new Date()) + "\tCliente = " + ipRemitente
                    + ":" + puertoRemitente + "\tEntradas = " + entradas + "\tSalida = " + resultado);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startServer()//Método para iniciar el servidor
    {
        Protocolo protocolo = new Protocolo();

        while (!ss.isClosed()) {
            try {
                System.out.println("Esperando..."); //Esperando conexión

                cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

                System.out.println("Cliente en línea");

                //Se obtiene el flujo de salida del cliente para enviarle mensajes
                salidaCliente = new DataOutputStream(cs.getOutputStream());

                //Se obtiene el flujo entrante desde el cliente
                DataInputStream entradaCliente = new DataInputStream(new BufferedInputStream(cs.getInputStream()));
                InetAddress ipRemitente = cs.getInetAddress();
                int puertoRemitente = cs.getPort();

                String cadena = entradaCliente.readUTF();
                protocolo.decodificarCadena(cadena);
                String tipoFigura = protocolo.figura();
                System.out.println(tipoFigura);
                String tipoOperacion = protocolo.operacion();
                System.out.println(tipoOperacion);

                double altura = protocolo.getAltura();
                double lado = protocolo.getLado();
                double radio = protocolo.getRadio();


                switch (tipoFigura) {
                    case "CL":
                        System.out.println("Operacion con Cilindro: ");
                        Cilindro cilindro = new Cilindro(radio, altura);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = cilindro.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = cilindro.volumen();
                        }

                        break;
                    case "ES":
                        System.out.println("Operacion con Esfera: ");
                        Esfera esfera = new Esfera(radio);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = esfera.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = esfera.volumen();
                        }

                        break;
                    case "CO":
                        System.out.println("Operacion con Cono: ");
                        Cono cono = new Cono(radio, altura);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = cono.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = cono.volumen();
                        }

                        break;
                    case "CU":
                        System.out.println("Operacion con Cubo: ");
                        Cubo cubo = new Cubo(lado);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = cubo.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = cubo.volumen();
                        }

                        break;
                    case "PR":
                        System.out.println("Operacion con Prisma: ");
                        Prisma prisma = new Prisma(altura, lado);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = prisma.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = prisma.volumen();
                        }

                        break;
                    case "PI":
                        System.out.println("Operacion con Piramide: ");
                        Piramide piramide = new Piramide(altura, lado);
                        if (tipoOperacion.equals("A")) {
                            System.out.print("Area");
                            resultado = piramide.area();
                        } else if (tipoOperacion.equals("V")) {
                            System.out.print("Volumen");
                            resultado = piramide.volumen();
                        }

                        break;
                }
                System.out.println(resultado);
                String cadenaCodificada = protocolo.codificarCadena(resultado);
                System.out.println(cadenaCodificada);

                salidaCliente.writeUTF(cadenaCodificada);
                logger(ipRemitente, puertoRemitente, "Operacion: " + tipoOperacion + " Figura: " + tipoFigura, " Resultado: " + resultado);

//
                System.out.println("Fin de la conexión");
                //ss.close();//Se finaliza la conexión con el cliente
            }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    }
}
