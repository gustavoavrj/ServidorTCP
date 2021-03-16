package Servidor;
import java.io.*;
import Servidor.Operaciones.Cilindro;
import Conexion.Conexion;
public class Servidor extends Conexion{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
       while(true){
        try
        {
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
            if(tipoFigura == 1){
                if(tipoOperacion == 0){
                    System.out.println("Area de: ");
                    System.out.print("Cilindro");
                    double radio = entradaCliente.readDouble();
                    double altura = entradaCliente.readDouble();
                    Cilindro cilindro = new Cilindro(radio,altura,0.0);
                    double resultado = cilindro.area();
                    salidaCliente.writeDouble(resultado);
                }

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
