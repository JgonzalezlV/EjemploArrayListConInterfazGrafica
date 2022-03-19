import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Principal {

    private static ArrayList<Integer> numeros = new ArrayList<Integer>();
    private static boolean salir = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        numeros.add(5);
        numeros.add(5);
        numeros.add(5);
        numeros.add(5);
        menu();
    }

    public static void menu() throws IOException {

        int eleccion = 0;

        do {
            System.out.println("----------------------------- ");
            System.out.println("MENÚ ");
            System.out.println("Que quiere hacer. ");
            System.out.println("1. Insertar. ");
            System.out.println("2. Borrar. ");
            System.out.println("3. Modificar. ");
            System.out.println("4. Buscar. ");
            System.out.println("5. Mostrar. ");
            System.out.println("6. Abandonar programa. ");
            System.out.println("----------------------------- ");
            try {
                eleccion = Integer.parseInt(br.readLine());
            }catch (NumberFormatException nfe){
                System.out.println("Sólo se admiten números. ");
                menu();
            }
            switch (eleccion) {
                case 1 -> {
                    mostrar();
                    insertarNumero();
                }
                case 2 -> {
                    mostrar();
                    borrarNumero();
                }
                case 3 -> {
                    mostrar();
                    modificarNumero();
                }
                case 4 -> buscarNumero();
                case 5 -> mostrar();
                case 6 -> salir = true;
            }
        }while (!salir);
    }

    public static void mostrar(){
        for (Integer numeros : numeros){
            int numero = numeros;
            System.out.println(numero);
        }
    }

    public static void insertarNumero() throws IOException{
        int numero = 0;
        System.out.println("¿Qué número quieres insertar? ");
        try{
            numero = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Sólo se admiten números. ");
            insertarNumero();
        }
        numeros.add(numero);
        mostrar();
    }

    public static void borrarNumero() throws IOException{
        int posicion = 0;
        System.out.println(" Introduzca la posición en la que se encuentra el número. ");
        try {
            posicion = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Sólo se admiten números. ");
            borrarNumero();
        }
        numeros.remove(posicion);
        mostrar();
    }


    public static void modificarNumero() throws IOException{
        int numero = 0;
        int nuevoNumero = 0;
        System.out.println("Introduzca el número que deseas modificar. ");
        try {
            numero = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Sólo se admiten números. ");
            modificarNumero();
        }
        System.out.println("Introduce el nuevo numero. ");
        try {
            nuevoNumero = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe){
            System.out.println("Sólo se admiten números. ");
            modificarNumero();
        }
        boolean encontrado = numeros.contains(numero);
        if (encontrado){
            int posicion = numeros.indexOf(numero);
            numeros.set(posicion,nuevoNumero);
            System.out.println("Se ha modificado perfectamente. ");
        }else{
            System.out.println("No se ha podido modificar, por que el número no existe. ");
        }
        mostrar();
    }

    public static void buscarNumero() throws IOException{
        int numero = 0;
        System.out.println("Introduce el número que desees buscar. ");
        try {
            numero = Integer.parseInt(br.readLine());
        }catch (NumberFormatException nfe) {
            System.out.println("Sólo se admiten números. ");
        }
        boolean encontrado = numeros.contains(numero);
        if (encontrado) {
            int posicion = numeros.indexOf(numero);
            System.out.println("La posición en la que se encuentra el número " + numero +" es la: " + posicion);
        }else{
            System.out.println("El número no se encuentra. ");
        }
    }


}
