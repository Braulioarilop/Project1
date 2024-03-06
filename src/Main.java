import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {

    public static void menu(){
        Scanner in = new Scanner(System.in);

        //Centinela que nos permitirá salir
        boolean salir = false;
        String opcion;
        do {
            System.out.println("Bienvenido a la aplicación \n ¿Como desea acceder?");
            System.out.println("1. Login de administrador");
            System.out.println("2. Login de departamento");
            System.out.println("3. Salir del programa");

            opcion = in.nextLine();

            switch(opcion){
                case "1":
                    String passwd;
                    System.out.println("Indicame la contraseña de administrador:");
                    passwd = in.nextLine();
                    if (passwd.matches(Administrador.contraseña)){
                        Administrador.menuadmin();
                    }else{
                        System.out.println("Contraseña incorrecta");
                    }
                    break;
                case "2":
                    System.out.println("Has seleccionado la opcion 2");
                    break;
                case "3":
                    System.out.println("Saliendo");
                    salir=true;
                    break;
                default:
                System.out.println("No has indicado una opcion correcta");
                    break;
            }

        }while(!salir);
    };
    public static void main(String[] args) {
        try {
            Main.menu();
        }catch (NoSuchElementException nsee){
        }
        System.out.println("Programa finalizado por error");

    }
}
