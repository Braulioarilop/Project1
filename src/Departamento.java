import java.util.Scanner;
public class Departamento {
    private String nombre;
    private String codigo;
    private String representante;

    public Departamento(String nombre, String codigo, String representante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.representante = representante;
    }

    public void menuDep() {
        Scanner in = new Scanner(System.in);
        String opcionDep;
        boolean salirDep = false;
        do {
            System.out.println("1.Acceso:Departameto");
            System.out.println("2.Escribe el nombre del departamento");
            System.out.println("3.Escribe el codigo del departamento");
            System.out.println("4.escribe el nombre del representante");
            System.out.println("5.Cerrar sesion");
            opcionDep = in.nextLine();

            switch (opcionDep) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
            }
        }while (!salirDep) ;

    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        String DepartaCom = "Nombre de departamento: "+ nombre +
                            "\n Codigo de departamento: "+ codigo +
                            "\n Representante: " + representante;
        return DepartaCom;
    }
}
