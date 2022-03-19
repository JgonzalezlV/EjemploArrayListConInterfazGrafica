import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PricipalGUI {

    private static ArrayList<Integer> numeros = new ArrayList<Integer>();
    private static boolean salir = false;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        numeros.add(5);
        numeros.add(5);
        numeros.add(5);
        numeros.add(5);
        int eleccion = 0;
        do {
        String lectura = JOptionPane.showInputDialog(null,"************************\nElige opción:\n1.- Insertar un número" +
                "\n2.- Borrar un número\n" +
                "3.- Modificar un número\n" +
                "4.- Buscar un número\n" +
                "5.- Mostrar los números\n" +
                "6.- Salir\n************************");
        eleccion = Integer.parseInt(lectura);
            switch (eleccion) {
                case 1 -> insertarNumero();
                case 2 -> borrarNumero();
                case 3 -> modificarNumero();
                case 4 -> buscarNumero();
                case 5 -> JOptionPane.showMessageDialog(null,"Los números que hay son: " + numeros);
                case 6 -> salir = true;
            }
        }while (!salir);
    }
    public static void insertarNumero() throws IOException{
        int numero = 0;
        String lectura = JOptionPane.showInputDialog("Introduce el número que quieras introducir. ");
        numero = Integer.parseInt(lectura);
        numeros.add(numero);
    }

    public static void borrarNumero() throws IOException{
        int posicion = 0;
        String lectura = JOptionPane.showInputDialog("Introduce la posición en la que se encuentra el número. ");
        posicion = Integer.parseInt(lectura);
        numeros.remove(posicion);

    }

    public static void modificarNumero() throws IOException{
        int numero = 0;
        int nuevoNumero = 0;
        String lectura = JOptionPane.showInputDialog("Introduzca el número que deseas modificar. ");
        numero = Integer.parseInt(lectura);
        String lectura2 = JOptionPane.showInputDialog("Introduce el nuevo numero. ");
        nuevoNumero = Integer.parseInt(lectura2);
        boolean encontrado = numeros.contains(numero);
        if (encontrado){
            int posicion = numeros.indexOf(numero);
            numeros.set(posicion,nuevoNumero);
            JOptionPane.showMessageDialog(null,"Se ha modificado perfectamente. ");
        }else{
            JOptionPane.showMessageDialog(null,"No se ha podido modificar, por que el número no existe. ");
        }
    }

    public static void buscarNumero() throws IOException{
        int numero = 0;
        String lectura = JOptionPane.showInputDialog("Introduce el número que desees buscar. ");
        numero = Integer.parseInt(lectura);
        boolean encontrado = numeros.contains(numero);
        if (encontrado) {
            int posicion = numeros.indexOf(numero);
            JOptionPane.showMessageDialog(null,"La posición en la que se encuentra el número " + numero +" es la: " + posicion);
        }else{
            JOptionPane.showMessageDialog(null,"El número no se encuentra. ");
        }
    }


}


