import java.io.IOException;
import Servidor.Servidor;
public class main {
    public static void main(String[] args) throws IOException
    {
        Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}
