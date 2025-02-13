import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean menu=true;
        Empleado em=new Empleado("12345678p",123.21,"Pepe","Cocinero");
        Empleado emple=new Empleado();
        Imprimirmenu();
        do {

            Scanner sc=new Scanner(System.in);

            try {
                int i= sc.nextInt();

                switch (i){
                    case 0:
                        System.out.println("Gracias");
                        menu=false;
                        break;
                    case 1:
                        emple.addNewEmpleado(emple.añadirEmpleado());
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        emple.printEmpleados();
                        break;
                    case 5:
                        Imprimirmenu();
                        break;

                    default:
                        System.out.println("Elige una opción válida");
                        System.out.println();
                }
            }catch (InputMismatchException e){
                System.out.println("Elige una opción válida");
                System.out.println(" ");
                sc.nextLine();
            }
        }while (menu);
        System.out.println(" ");
    }
    public static void Imprimirmenu(){
        System.out.println("Elige una opción: ");
        System.out.println("0.Salir");
        System.out.println("1.Insertar un Empleado");
        System.out.println("2.Eliminar un Empleado");
        System.out.println("3.Actualizar un Empleado existente");
        System.out.println("4.Consultar Empleados");
        System.out.println("5.Imprimir menú");
    }
}
