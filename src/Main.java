import java.util.Scanner;
public class Main {

    public static void Menu(){
        Scanner in = new Scanner(System.in);

        //Centinela que nos permitirá salir
        boolean salir = false;

        do {
            System.out.println("Bienvenido a la aplicación \n ¿Como desea acceder?");
            System.out.println("1. Login de administrador");
            System.out.println("2. Login de administrador");
            System.out.println("3. Login de administrador");
        }while(!salir);
    };
    public static void main(String[] args) {
        Main.Menu();
    }
}