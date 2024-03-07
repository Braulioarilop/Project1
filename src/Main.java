import java.util.NoSuchElementException;
import java.util.Scanner;
public class Main {

    public static void menu(){
        Scanner in = new Scanner(System.in);

        //Centinela que nos permitirá salir
        boolean salir = false;
        String opcion;
        while(!salir){
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
                    String passwd2;
                    System.out.println("Indicame el codigo del departamento:");
                    passwd2 = in.nextLine();
                    if (passwd2.matches(Departamento.codigo)){
                        Departamento.menuDep();
                    }else{
                        System.out.println("Codigo  incorrecta");
                    }
                    break;
                case "3":
                    System.out.println("Saliendo");
                    salir=true;
                    break;
                default:
                    System.out.println("No has indicado una opcion correcta");
                    break;
            }
        };
    };
    public static void main(String[] args) {

        Main.menu();

    }
}