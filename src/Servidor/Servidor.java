package Servidor;

import Conexion.Conexion;
import Servidor.Operaciones.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class Servidor extends Conexion {
    double resultado;

    public Servidor() throws IOException {
        super("servidor");
    } //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        while (!ss.isClosed()) {
            try {
                System.out.println("Esperando..."); //Esperando conexión

                cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

                System.out.println("Cliente en línea");

                //Se obtiene el flujo de salida del cliente para enviarle mensajes
                salidaCliente = new DataOutputStream(cs.getOutputStream());
//
//            //Se le envía un mensaje al cliente usando su flujo de salida
//            salidaCliente.writeUTF("Petición recibida y aceptada");

                //Se obtiene el flujo entrante desde el cliente
                DataInputStream entradaCliente = new DataInputStream(new BufferedInputStream(cs.getInputStream()));
                char tipoFigura = entradaCliente.readChar();
                char tipoOperacion = entradaCliente.readChar();


                if (tipoFigura == 0) {
                    System.out.println("Operacion con Cilindro: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Cilindro cilindro = new Cilindro(radio, altura, lado);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = cilindro.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = cilindro.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                } else if (tipoFigura == 1) {
                    System.out.println("Operacion con Esfera: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Esfera esfera = new Esfera(radio);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = esfera.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = esfera.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                } else if (tipoFigura == 2) {
                    System.out.println("Operacion con Cono: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Cono cono = new Cono(radio, altura);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = cono.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = cono.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                } else if (tipoFigura == 3) {
                    System.out.println("Operacion con Cubo: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Cubo cubo = new Cubo(lado);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = cubo.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = cubo.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                } else if (tipoFigura == 4) {
                    System.out.println("Operacion con Prisma: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Prisma prisma = new Prisma(altura, lado);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = prisma.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = prisma.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                } else if (tipoFigura == 5) {
                    System.out.println("Operacion con Piramide: ");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    double lado = entradaCliente.readDouble();
                    Piramide piramide = new Piramide(altura, lado);
                    if (tipoOperacion == 0) {
                        System.out.print("Area");
                        resultado = piramide.area();
                    } else if (tipoOperacion == 1) {
                        System.out.print("Volumen");
                        resultado = piramide.volumen();
                    }
                    salidaCliente.writeDouble(resultado);

                }

//            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
//            {
//                //Se muestra por pantalla el mensaje recibido
//                System.out.println(mensajeServidor);
//            }

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
