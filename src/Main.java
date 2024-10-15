import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        String archivo = "data.doc";
        checkExtension(archivo);
        printLinkedList(leerGuardarLinked(archivo));
    }
    public static void checkExtension(String path) throws IOException {

        File file = new File(path);
        if(file.exists()){
            String ext = file.getName().substring(file.getName().lastIndexOf(".") + 1);
            //System.out.println(ext);
            if(ext.equals("txt") || ext.equals("doc") || ext.equals("odt") ){
                caracterPorCatarter(path);
                bufferReader(path);
            }else System.out.println("extension not supported");
        }else System.out.println("Extension not found");

    }
    public static void caracterPorCatarter(String archivoTxt){
        try{
            FileReader fr = new FileReader(archivoTxt);
            int caract = fr.read();
            System.out.println("\n***IMPRIMIENDO ARCHIVO CARACTER POR CARACTER "+archivoTxt+"***");
            while(caract != -1){
                System.out.printf("%c",caract);
                caract = fr.read();
            }
            fr.close();

        }catch (Exception e){
            System.out.printf("Error de lectura del fichero");
        }
    }
    public static void bufferReader(String archivoTxt) throws IOException {
        File f = new File(archivoTxt);
        if(f.exists()){
            FileReader fr = new FileReader(archivoTxt);
            BufferedReader bf = new BufferedReader(fr);
            String cad;
            System.out.println("\n***IMPRIMIENDO ARCHIVO BUFFER READER "+archivoTxt+"***");
            while((cad= bf.readLine())!= null){
                System.out.printf(cad+"\n");
            }
        }else System.out.printf("El fichero no existe");
    }

    public static LinkedList<String> leerGuardarLinked(String archivoTxt) throws IOException {
        LinkedList<String> lista = new LinkedList<>();

        File f = new File(archivoTxt);

        if (f.exists()) {
            if (f.isFile()) {
                FileReader fr = new FileReader(archivoTxt);
                BufferedReader bf = new BufferedReader(fr);
                String cad;
                System.out.println("***IMPRIMIENDO ARCHIVO " + archivoTxt + "***");
                while ((cad = bf.readLine()) != null) {
                    //System.out.printf(cad + "\n");
                    lista.add(cad);
                }
            } else System.out.print("Es un directorio");
        }else System.out.println("El fichero no existe");


        return lista;
    }

    public static void printLinkedList(LinkedList<String> lista) {
        for (String s : lista) {
            System.out.println(s);
        }
    }

}