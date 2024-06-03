import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CSVScanner {
    public static void main(String[] args) {
        // Ruta del archivo CSV
        String filePath = "C:\\Users\\guillote\\Documents\\UM\\3 año\\PRIMER SEMESTRE\\Prog II\\universal_top_spotify_songs.csv";

        // Crear el HashMap para almacenar los datos del CSV
        Map<String, String> dataMap = new HashMap<>();

        try {
            // Crear el objeto Scanner para leer el archivo
            Scanner scanner = new Scanner(new File(filePath));

            // Leer el archivo línea por línea
            while (scanner.hasNextLine()) {
                // Leer la línea completa
                String line = scanner.nextLine();

                // Separar la línea en columnas (suponiendo que está separada por comas)
                String[] columns = line.split(",");

                // Suponiendo que la primera columna es la clave y la segunda es el valor
                if (columns.length >= 2) {
                    String key = columns[0];
                    String value = columns[1];

                    // Insertar los datos en el HashMap
                    dataMap.put(key, value);
                }
            }

            // Cerrar el scanner
            scanner.close();

            // Mostrar el contenido del HashMap
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                System.out.println("Clave: " + entry.getKey() + " | Valor: " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        }
    }
}
