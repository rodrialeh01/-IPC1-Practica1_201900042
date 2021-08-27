package pra1;
import java.io.*;
public class Reportaje {
    public void archivonuevo(String contenido, String archivo){
        File reporte1 = new File(archivo);
        try{
            FileWriter escribir = new FileWriter(reporte1);
            escribir.write(contenido);
            escribir.close();
            System.out.println("Reporte1 creado con éxito");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
