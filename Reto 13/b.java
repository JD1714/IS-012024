/*Un centro de investigación requiere el registro de los equipos adquiridos, el costo de adquisición
y el responsable del equipo, contabilizando el número total de equipos y el monto total en bolívares
de los equipos del centro. Se define el siguiente formato para registrar la data de los equipos y del
responsable: desc#ct#mu#"dd"/"mm"/"aaaa"#nf#ci;.
De este formato se desprende que:
• desc es una cadena de caracteres que corresponde a la descripción del equipo (CPU, monitor,
mouse, teclado, UPS, pen-drive, cámara, impresora, fotocopiadora)
• ct representa la cantidad de equipos y es un número entero
• mu representa el costo unitario de adquisición del equipo y es un número real
• dd es el día de la fecha de la adquisición, número entero de dos dígitos entre 01 y 31
• mm es el mes de la fecha de la adquisición, número entero de dos dígitos entre 01 y 12
• aaaa es el año de la fecha de la adquisición, número entero de cuatro dígitos empezando en
1968
• nf es una cadena de caracteres que corresponde al número de la factura
• ci es una cadena de caracteres que corresponde a la CI del profesor responsable del equipo
Se requiere un programa en Java que:
• Lea de consola la data de los equipos y la CI del correspondiente responsable del equipo
• Incorpore instrucciones en el programa para registrar en un archivo inventario.txt la data que
leyó por consola según el formato especificado
• Incorpore en el programa instrucciones para generar por consola un reporte en el cual para
cada profesor se indique el número total de los equipos y el monto total en bolívares que tiene
bajo su responsabilidad
• Incorpore manejo de excepciones para las operaciones con el archivo inventario.txt */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class b {
    public static void main(){
        Scanner num = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        String catcher = "Y";
        while (catcher!="N")          
        {
            System.out.println("Descripción del equipos:");
            String desc = text.nextLine();
            System.out.println("Cantidad de Equipos:");
            int ct = num.nextInt();
            System.out.println("Costo unitario:");
            float mu = num.nextFloat();
            System.out.println("Día:");
            int dd = num.nextInt();
            System.out.println("Mes:");
            int mm = num.nextInt();
            System.out.println("Año:");
            int aaaa = num.nextInt();
            System.out.println("Numero de factura:");
            String nf = text.nextLine();
            System.out.println("Cédula de Identidad:");
            String ci = text.nextLine();

            String formato = "Descripción: " + desc + ". Cant. de Equipos: " + ct + ". Costo x unidad: " + mu + ". Fecha: " + dd+"/"+mm+"/"+aaaa + ". Num. factura: " + nf + ". C.I: " + ci;

            System.out.println(formato);

            try {
                // create a FileWriter object with the file name
                FileWriter writer = new FileWriter("inventario.txt");

                // write the string to the file
                writer.write(formato);

                // close the writer
                writer.close();

                System.out.println("Base de datos actualizada.");

            } catch (IOException e) {
                System.out.println("Error ha pasao.");
                e.printStackTrace();
            }

            System.out.println("Desea registrar otra factura? Y/N");
            catcher = text.nextLine();
            
            num.close();
            text.close();
        }
    }
}
