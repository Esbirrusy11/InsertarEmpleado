//Raúl Martínez Parra
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean menu=true;
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
                        System.out.println("¿Cuál es el id del empleado que quieres borrar?");
                        String IdEMpleado= sc.next();
                        if (emple.Empleados.contains(emple.queryEmpleado(IdEMpleado))) {
                            emple.removeEmpleado(emple.queryEmpleado(IdEMpleado));
                            System.out.println("El empleado fue borrado correctamente");
                            System.out.println();
                        }else {
                            System.out.println("El empleado no existe en la lista");
                            System.out.println();
                        }
                        break;
                    case 3:
                        System.out.println("¿Cual es el id del Empleado que quieres actualizar?");
                        String respuesta= sc.next();
                        System.out.println();
                        if (emple.Empleados.contains(emple.queryEmpleado(respuesta))){
                            emple.updateEmpleado(emple.queryEmpleado(respuesta),emple.añadirEmpleado());
                            System.out.println("Empleado actualizado correctamente");
                            System.out.println();
                        }else {
                            System.out.println("Ese id no está en la lista de empleados");
                        }
                        break;
                    case 4:
                        emple.printEmpleados();
                        break;
                    case 5:
                        Imprimirmenu();
                        break;

                    default:
                        System.out.println("Elige una opción válida");
                        Imprimirmenu();
                        System.out.println();
                }
            }catch (InputMismatchException e){
                System.out.println("Elige una opción válida");
                Imprimirmenu();
                System.out.println();
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
