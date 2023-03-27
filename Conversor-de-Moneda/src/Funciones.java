/*CREADOR: URIEL CRUZ VALDES

        **REDES SOCIALES**
        HitGub: Urielczv
        twitter: @Uriel_cruzv
        Discord: Uriel交 #6555
        Correo: urieazul907@gmail.com*/

import javax.swing.JOptionPane;

public class Funciones {

    /*EN ESTA PRIMERA PARTE SE ENCUENTRAN LAS FUNCIONES DE LOS MENUS Y UNA FUNCION QUE SIRVE PARA PREGUNTAR SI EL 
     * USUARIO DESEA REALIZAR MAS CONVERSIONES
     */
    public void Menu_Principal(){
        //esta son las opciones que tiene el menu principal
        String[] menu = {"Conversor de Monedas", "Conversor de temperatura", "Salir"};

        //en el while creamos el menu con ayuda de "JOptionPane"
        while (true) {
            int choice = JOptionPane.showOptionDialog(null, "Selecciona una opcion ", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, menu, menu[0]);

            //el switch es para entrar en uno de los 3 posibles casos que pueda escoger el usuario
            switch (choice) {
                case 0:
                Menu_Conversor();
                    break;
                case 1:
                JOptionPane.showMessageDialog(null, "Esta Funcion sigue en desarrollo");
                Validar();
                    break;
                case 2:
                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }


    public void Menu_Conversor(){
        //aquí tenemos todas las posibles conversiones que puede escoger el usario
        Object[] opciones = { "MXN a Dolar", "MXN a Libras", "MXN a Euro", "MXN a Yen", "MXN a Won coreano", "Dolar a MXN", "Libras a MXN", "Euro a MXN" };
        
        //se crea el menu para que el usario y la opcion que elija se guardara en la variable "seleccion"
        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un tipo de conversion:", "Conversion",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
        
        //de acuerdo a la seleccion que haga el usario se ingresara a una de las diferentes opciones
        //para asegurarnos que es la opcion que elijio el usario validamos con IF
        if(seleccion == null){
            // El usuario cerró el cuadro de diálogo
            System.out.println("Operación cancelada");
        }
        if(seleccion == "MXN a Dolar"){
            MXN_Dolar();
        }
        if(seleccion == "MXN a Libras"){
            MXN_Libras();
        }
        if(seleccion == "MXN a Euro"){
            MXN_Euro();
        }
        if(seleccion == "MXN a Yen"){
            MXN_Yen();
        }
        if(seleccion == "MXN a Won coreano"){
            MXN_Won();
        }
        if(seleccion == "Dolar a MXN"){
            Dolar_MXN();
        }
        if(seleccion == "Libras a MXN"){
            Libras_MXN();
        }
        if(seleccion == "Euro a MXN"){
            Euro_MXN();
        }
    }

    public void Validar(){
        //Esta función sirve para preguntarle al usario si desea hacer más conversiones y solo tiene dos posibles casos los cuales son "SI" y "NO"
        //si es "SI" lo mandaremos al menu principal para que elija que tipo de conversión quiere hacer
        //si es "NO" le mostraremos un mensaje indicandole que el programa finalizo y se cerrara el programa
        int opcion = JOptionPane.showConfirmDialog(null, "¿Quiere hacer otra conversion?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            Menu_Principal();
        }
        if(opcion == JOptionPane.NO_OPTION){
            JOptionPane.showMessageDialog(null, "Fin del programa. ");
            System.exit(0);
        }
    }
    
    
    /*CON ESTO SE TERMINAN LAS FUNCIONES CON LAS CUALES SE CONSTRUYEN LOS MENUS Y VALIDACIONES
     * EN ESTA SIGUIENTE PARTE SE ENCUENTRAN TODAS LAS FUNCIONES QUE TIENEN QUE VER CON LAS CONVERSIONES DE MONEDA
     */

    /*TODAS LAS FUNCIONES SIGUEN UNA MISMA ESTRUCTUA LA CUAL ES:
     * 
     * -una variable de tipo "final double" que lleva se llama igual a la moneda que se desea convertir y tiene el valor de esa moneda
     * -un bloque "try catch" que sirve para revisar que el usario ingrese solo caracteres de tipo numerico
     * -un "showInputDialog" en donde le pediremos al usario que ingrese la cantidad a convertir y se guardara en una variable de tipo double
     * que lleva por nombre el nombre de la moneda base a convertir
     * -una variable de tipo double que se llama "resultado" la cual guardara el resultado de la conversión
     * -un "showMessageDialog" que sirve para mostrar el resultado de la conversión al usario
     * -Por ultimo se manda a llamar la función "Validar" para preguntarle al usario que desea hacer
     * 
     * TODAS LAS FUNCIONES CUMPLEN CON EL MISMO FORMATO
     */
    
    public void MXN_Dolar(){
        final double dolar = 0.054;
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en pesos MXN:"));
            double resultado = peso *dolar;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " Dolares");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void MXN_Libras(){
        final double libra = 0.044;
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en pesos MXN:"));
            double resultado = peso *libra;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " Libras Esterlinas");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void MXN_Yen(){
        final double yen = 7;
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en pesos MXN:"));
            double resultado = peso *yen;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " yenes");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void MXN_Won(){
        final double won = 70;
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en pesos MXN:"));
            double resultado = peso *won;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " Wones");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void Dolar_MXN(){
        final double peso = 18.43;
        try {
            double dolar = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en dolares:"));
            double resultado = dolar *peso;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " pesos mexicanos");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void Libras_MXN(){
        final double peso = 22.56;
        try {
            double libras = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en libras esterlinas:"));
            double resultado = libras *peso;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " pesos mexicanos");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void Euro_MXN(){
        final double peso = 19.85;
        try {
            double euro = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en euros:"));
            double resultado = euro *peso;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " pesos mexicanos");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

    public void MXN_Euro(){
        final double euro = 0.051;
        try {
            double peso = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la cantidad en pesos MXN:"));
            double resultado = peso *euro;
            JOptionPane.showMessageDialog(null, "El resultado es: " + resultado + " euros");
            Validar();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos ingresados, no numericos", "mensaje", 0);
        }
    }

}
