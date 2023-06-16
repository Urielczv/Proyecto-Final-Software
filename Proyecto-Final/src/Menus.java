import java.util.Scanner;

public class Menus {
    public void MenuPrincipal(){
        Funciones funcion = new Funciones(); // objeto para usar la clase Funciones
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while(!salir){
            System.out.println("Registro de llamadas");
            System.out.println("1. Cargar XML a la lista");
            System.out.println("2. Buscar registro");
            System.out.println("3. Actualizar registro");
            System.out.println("4. Eliminar registro");
            System.out.println("5. Imprimir registros ordenados");
            System.out.println("6. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();//limpia el buffer de entrada

            switch (opcion) {
                case 1 -> {
                    funcion.LeerArchivoXML("Archivos/Registros.xml");
                    funcion.ActualizarZona();
                    System.out.println("Lista cargada exitosamente");
                }
                case 2 -> {
                    System.out.println("Ingresa la clave (ISBN) del registro a buscar: ");
                    String buscar = scanner.nextLine();
                    funcion.buscarPorISBN(buscar);
                }
                case 3 -> {
                    System.out.println("Ingresa la clave (ISBN) del registro a actualizar: ");
                    String actualizar = scanner.nextLine();
                    funcion.actualizarPorISBN(actualizar);
                }
                case 4 -> {
                    System.out.println("Ingresa la clave (ISBN) del registro a eliminar: ");
                    String borrar = scanner.nextLine();
                    funcion.eliminarRegistro(borrar);
                }
                case 5 -> {
                    System.out.println("IMPRIMIENDO REGISTROS");
                    funcion.imprimirAlfabetico();
                }
                case 6 -> {
                    System.out.println("Gracias por usar el programa :)");
                    System.out.println("Hasta la proxima...");
                    salir = true;
                }
                default -> System.out.println("Opcion invalida, por favor de ingresa una opcion valida");
            }
        }
        scanner.close();
    }
}
