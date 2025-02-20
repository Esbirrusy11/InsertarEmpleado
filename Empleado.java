//Raúl Martínez Parra
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Empleado {
    String idEmpleado;
    Double salario;
    String nombre;
    String puesto;

    public Empleado(String idEmpleado, Double salario, String nombre, String puesto) {
        this.idEmpleado = idEmpleado;
        this.salario = salario;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    public Empleado() {
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return
                nombre+" \u2192 "+
                        idEmpleado + " \u2192 "+
                        salario + " \u2192 "+
                        puesto;

    }

    ArrayList<Empleado> Empleados=new ArrayList<>();

    private int findEmpleado(Empleado empleado){
        if (Empleados.contains(empleado)){
            return 1;
        }else {
            return -1;
        }
    }

    public int findEmpleado(String idEmpleado){
        if (Empleados.contains(idEmpleado)){
            return 1;
        }else {
            return -1;
        }
    }

    public boolean addNewEmpleado(Empleado empleado){
        boolean boo;
        if (findEmpleado(empleado)<=0){
            boo=false;
            Empleados.add(empleado);

        }else {
            boo=true;
        }
        return boo;
    }

    public boolean updateEmpleado(Empleado antiguo,Empleado nuevo){
        boolean bolano;
        if (findEmpleado(antiguo)<=0){
            bolano=false;
        }else {
            Empleados.remove(antiguo);
            Empleados.add(nuevo);
            bolano=true;
        }
        return bolano;
    }

    public boolean removeEmpleado(Empleado empleado){
        boolean boo;
        if (findEmpleado(empleado)>=0){
            Empleados.remove(empleado);
            boo=true;
        }else {
            boo=false;
        }
        return boo;
    }

    public Empleado queryEmpleado(String IdEmpleado){
        for (Empleado conta:Empleados){
            if (conta.getIdEmpleado().equalsIgnoreCase(IdEmpleado)){
                return conta;
            }
        }
        return null;
    }

    public void printEmpleados(){
        int cont =1;
        System.out.println("Lista de empleados :");
        if (Empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
        }
        for (Empleado con:Empleados){
            System.out.println(cont+". "+con);
            cont++;

        }
    }

    public String validarIDEmpleado() {
        Scanner sc = new Scanner(System.in);
        String idEmpleado;
        boolean esValido;
        do {
            esValido = true;
            System.out.println("¿Cuál es el nuevo id del empleado?");
            idEmpleado = sc.nextLine();

            for (Empleado empleados : Empleados) {
                if (idEmpleado.equalsIgnoreCase(empleados.idEmpleado)||idEmpleado.equals(empleados.idEmpleado)) {
                    System.out.println("Error no se pueden añadir empleados con ID's iguales");
                    System.out.println();
                    esValido=false;
                }
            }
            if (idEmpleado.length() != 9) {
                System.out.println("Error: El idEmpleado debe tener exactamente 9 caracteres");
                System.out.println();
                esValido = false;
            } else {

                for (int i = 0; i < 8; i++) {
                    if (!Character.isDigit(idEmpleado.charAt(i))) {
                        System.out.println("Error: Los 8 primeros caracteres deben ser números");
                        esValido = false;
                        break;
                    }
                }

                char letra = idEmpleado.charAt(8);
                if (!Character.isLetter(letra)) {
                    System.out.println("Error: El último carácter debe ser una letra");
                    esValido = false;
                }
            }

            if (esValido) {
                System.out.println("ID Empleado Correcto");
                System.out.println();
            }

        } while (!esValido);
        return idEmpleado;

    }

    public String validarNombre() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        boolean esValido;

        do {
            esValido = true;
            System.out.println("¿Cuál es el nombre del empleado?");
            nombre = sc.nextLine();

            for (char c : nombre.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') {
                    System.out.println("Error: El nombre solo puede contener letras y espacios.");
                    esValido = false;
                    break;
                }
            }
            if (esValido) {
                System.out.println(nombre + " → Es válido");
                System.out.println();
            }

        } while (!esValido);
        return  nombre;
    }

    public double validarSalario() {
        Scanner sc=new Scanner(System.in);
        double salario=0;
        boolean esValido;
        do {
            esValido=true;
            System.out.println("¿Cuál es el salario del Empleado?");
            try {
                salario= sc.nextDouble();

                if (salario<0||salario==0){
                    System.out.println("El salario no puede ser negativo ni 0.");
                    System.out.println();
                    esValido=false;

                }if (esValido){
                    System.out.println("Salario Correcto");
                    System.out.println();

                }
            }catch (InputMismatchException e){
                System.out.println("Error: El salario no puede contener letras");
                System.out.println();
                esValido=false;
                sc.next();
            }
        }while (!esValido);
        return salario;
    }

    public String validarPuesto() {
        Scanner sc=new Scanner(System.in);
        String puesto;
        boolean esValido;
        do {
            esValido=true;
            System.out.println("¿Cuál es el puesto del Empleado?");
            puesto= sc.next();
            if (puesto==null||puesto.isEmpty()) {
                System.out.println("Error: El puesto no puede estar vacío");
            }
            if (esValido){
                System.out.println("Puesto Correcto");
                System.out.println();
            }
        }while (!esValido);
        return puesto;
    }
    public Empleado añadirEmpleado() {

        String idEmpleado = validarIDEmpleado();
        String nombre = validarNombre();
        double salario = validarSalario();
        String puesto = validarPuesto();

        System.out.println("Empleado añadido con éxito:");
        System.out.println("ID: " + idEmpleado);
        System.out.println("Nombre: " + nombre);
        System.out.println("Salario: " + salario);
        System.out.println("Puesto: " + puesto);
        Empleado em=new Empleado(idEmpleado,salario,nombre,puesto);
        return em;
    }
}
