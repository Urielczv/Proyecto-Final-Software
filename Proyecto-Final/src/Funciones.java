import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.*;
public class Funciones {
    private List<Llamada> llamadas; //se crea el arrylist

    public void LeerArchivoXML(String archivo) {
        llamadas = new ArrayList<>(); //se inicializa el arrylist

        //se carga el xml en un documentBulider para despues ser analizado
        try {
            File XML = new File(archivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(archivo);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("llamada");//se indica en que etiquetas se debe fijar

            //se guardan los datos del xml en las variables de la clase "LLAMADA"
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                Llamada llamada = new Llamada();
                llamada.setContacto(element.getElementsByTagName("contacto").item(0).getTextContent());
                llamada.setCompania(element.getElementsByTagName("compañia").item(0).getTextContent());
                llamada.setHorario(element.getElementsByTagName("horario").item(0).getTextContent());
                llamada.setZona(element.getElementsByTagName("zona").item(0).getTextContent());
                llamada.setISBN(element.getElementsByTagName("ISBN").item(0).getTextContent());
                llamadas.add(llamada);//por ultimo lo que se guardo en las variables se inserta en el arrylist como un registro exitoso
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarZona() {
        //se crea el catalogo de "zona" con tablas hash/mapa hash
        Map<Integer, String> catalogo = new HashMap<>();
        catalogo.put(1, "Sur");
        catalogo.put(2, "Norte");
        catalogo.put(3, "Oeste");
        catalogo.put(4, "Este");

        //cambiamos los valores de la etiqueta zona del xml al valor que le toca
        //de acuerdo al catalogo
        //todos estos cambios se hacen a nivel de la lista
        for (Llamada llamada : llamadas) {
            String zona = llamada.getZona();
            int numeroZona = Integer.parseInt(zona); //convertimos el string en int
            String direccion = catalogo.get(numeroZona);
            llamada.setZona(direccion);
        }
    }

    /*public void imprimirLlamadas() {
        //Imprime lo que tenemos en el arrylist
        for (Llamada llamada : llamadas) {
            System.out.println("Contacto: " + llamada.getContacto());
            System.out.println("Compañía: " + llamada.getCompania());
            System.out.println("Horario: " + llamada.getHorario());
            System.out.println("Zona: " + llamada.getZona());
            System.out.println("ISBN: " + llamada.getISBN());
            System.out.println("----------------------");
        }
    }*/

    public void imprimirAlfabetico() {
        // Ordenar el ArrayList por clave ISBN
        Collections.sort(llamadas, new Comparator<Llamada>() {
            @Override
            public int compare(Llamada llamada1, Llamada llamada2) {
                return llamada1.getISBN().compareToIgnoreCase(llamada2.getISBN());
            }
        });

        // Imprimir los registros ordenados
        for (Llamada llamada : llamadas) {
            System.out.println("Contacto: " + llamada.getContacto());
            System.out.println("Compañía: " + llamada.getCompania());
            System.out.println("Horario: " + llamada.getHorario());
            System.out.println("Zona: " + llamada.getZona());
            System.out.println("ISBN: " + llamada.getISBN());
            System.out.println("----------------------");
        }
    }

    public void buscarPorISBN(String isbn) {
        boolean encontrado = false; // Variable para controlar si se encontró un registro

        for (Llamada llamada : llamadas) {
            if (llamada.getISBN().equals(isbn)) {
                encontrado = true; // Se encontró el registro
                System.out.println("REGISTRO ENCONTRADO CON ÉXITO");
                System.out.println("Contacto: " + llamada.getContacto());
                System.out.println("Compañía: " + llamada.getCompania());
                System.out.println("Horario: " + llamada.getHorario());
                System.out.println("Zona: " + llamada.getZona());
                System.out.println("ISBN: " + llamada.getISBN());
                break; // Salir del bucle después de encontrar el registro
            }
        }

        if (!encontrado) {
            System.out.println("El registro con el ISBN: " + isbn + " no existe");
        }
    }

    public void actualizarPorISBN(String isbn) {
        Scanner scanner = new Scanner(System.in);
        for (Llamada llamada : llamadas) {
            if (llamada.getISBN().equals(isbn)) {

                System.out.println("Ingresa el nuevo nombre de contacto: ");
                String nuevoContacto = scanner.nextLine();
                llamada.setContacto(nuevoContacto);

                System.out.println("Ingresa la nueva compañía: ");
                String nuevaCompania = scanner.nextLine();
                llamada.setCompania(nuevaCompania);

                System.out.println("Ingresa el nuevo horario: ");
                String nuevoHorario = scanner.nextLine();
                llamada.setHorario(nuevoHorario);

                System.out.println("Ingresa la nueva zona (sur, norte, este y oeste): ");
                String nuevaZona = scanner.nextLine();
                llamada.setZona(nuevaZona);

                System.out.println("Registro actualizado con éxito.");
                return;
            }
        }
        scanner.close();
        System.out.println("No se encontró ningún registro con el ISBN: " + isbn);
    }

    public void eliminarRegistro(String ISBN) {
        Iterator<Llamada> iterator = llamadas.iterator();
        boolean encontrado = false;//para controlar la busqueda

        while (iterator.hasNext()) {
            Llamada llamada = iterator.next();//accede registro x registro
            if (llamada.getISBN().equals(ISBN)) {
                encontrado = true;//se encoentro el registro
                iterator.remove();//se remueve el registro
                System.out.println("Registro eliminado.");
                break;
            }
        }

        if (!encontrado) {
            //cuando encontrado no cambie, se moestrata esta linea
            System.out.println("El registro con el ISBN " + ISBN + " no existe.");
        }
    }


}

