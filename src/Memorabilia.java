package src;

import java.util.Scanner;

public class Memorabilia {

    public static void main(String[] args) {
        Memorabilia memoria = new Memorabilia();
    }
    int cantDip = 0, cantpr = 0;
    Scanner entrada = new Scanner(System.in);
    /**
     * Declaracion de variables Globales
     */
    //arreglos para el cliente 
    final int NUM_CLIENTES = 30;
    String nombreClientes[] = new String[NUM_CLIENTES];
    int idCliente[] = new int[NUM_CLIENTES];
    int telefonoC[] = new int[NUM_CLIENTES];
    boolean estadoPres[] = new boolean[NUM_CLIENTES];
    //arreglos para las peliculas
    final int NUM_PELICULAS = 30;
    int idPelicula[] = new int[NUM_PELICULAS];
    String nombrePeliculas[] = new String[NUM_PELICULAS];
    String categoria[] = new String[NUM_PELICULAS];
    int[] añoP = new int[NUM_PELICULAS];
    boolean estadoDis[] = new boolean[NUM_PELICULAS];
    //arreglos para el prestamo
    int diasPresta[] = new int[NUM_PELICULAS];
    int idPeliculaP[] = new int[NUM_PELICULAS];
    int idClienteP[] = new int[NUM_PELICULAS];

    public Memorabilia() {
        iniciarDias();
        menuPrincipal();

    }

    /**
     * Menu del programa, logica del programa, convoca otros metodos
     */
    public void menuPrincipal() {
        int op = 0;

        System.out.println("\n \n ***Bienvenido al programa de control de prestamos de Pelicula***\n \n ");

        do {
            System.out.println("-----Menu Principal-----\n");
            System.out.println("0.---- **SALIR** ");
            System.out.println("1.--- Prestamos de Peliculas");
            System.out.println("2.--- Devolucion de Peliculas");
            System.out.println("3.--- Mostrar las Peliculas");
            System.out.println("4.--- Ingreso de Peliculas");
            System.out.println("5.--- Ordenar las Peliculas");
            System.out.println("6.--- Ingresar Clientes nuevos");
            System.out.println("7.--- Mostrar clientes");
            System.out.println("8.--- Reportes\n ");
            System.out.print("Digite el numero de la opcion correspondiente que desea realizar ");
            op = entrada.nextInt();

            switch (op) {
                case (1):
                    prestamoPeli();
                    break;
                case (2):
                    devolucionPeli();
                    break;
                case (3):
                        
                    break;
                case (4):
                    ingresoPelis();
                    break;
                case (5):

                    break;
                case (6):
                    ingresoClientes();
                    break;
                case (7):

                    break;
                case (8):

            }

        } while (op != 0);

    }

    /**
     * ingresa las peliculas al arreglo, llamado a las funciones que necesite
     */
    public void ingresoPelis() {
        int idAux = 0;
        int op = 2;
        while (nombrePeliculas[NUM_PELICULAS - 1] == null && op == 2) {
            System.out.print("\ningrese el ID de la pelicula ");
            idAux = entrada.nextInt();
            if (validez(idAux, idPelicula)) {
                for (int i = 0; i < NUM_PELICULAS; i++) {
                    if (nombrePeliculas[i] == null) {
                        idPelicula[i] = idAux;
                        datosPeli(i);
                        break;
                    }

                }

            } else {
                System.out.println("ERROR, El ID de la pelicula ya existe\n");

            }
            System.out.println("\n***desea agreagar otra pelicula***");
            System.out.println("1-Regresar al menu principal");
            System.out.println("2-Agregar otra pelicula");
            System.out.print("Digite la opcion ");
            op = entrada.nextInt();

        }
        if (nombrePeliculas[NUM_PELICULAS - 1] != null) {
            System.out.println("\nYa no cuenta con espacios para mas Peliculas!!!, SORRY\n");
        }

    }

    /**
     * valida que no exista otro id en el arreglo
     *
     * @param idE es el id que recive
     * @return boolean falso si ya existe un id true si no hay id
     */
    public boolean validez(int idE, int arreglo[]) {
        boolean vald = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == idE) {
                vald = false;
                break;
            }

        }
        return vald;

    }

    /**
     * inicializa los datos de la peli
     *
     * @param pos
     */
    public void datosPeli(int pos) {
        int categ = 0;
        estadoDis[pos] = false;
        System.out.print("Igrese el nombre de la pelicula ");
        nombrePeliculas[pos] = entrada.next();
        entrada.nextLine();
        System.out.print("Ingrese el año de la Pelicual ");
        añoP[pos] = entrada.nextInt();
        System.out.println("Ingrese la categoria de la Pelicual ");
        System.out.println("categorias disponible \n");
        System.out.println("1. Familiar\n2. Accion\n3. Romance\n4. Terror\n5. Comedia\n");
        System.out.print("Digite el numero de la categoria en que lo deasea agregar ");
        categ = entrada.nextInt();
        switch (categ) {
            case 1:
                categoria[pos] = "Familiar";
                break;
            case 2:
                categoria[pos] = "Accion";
                break;
            case 3:
                categoria[pos] = "Romance";
                break;
            case 4:
                categoria[pos] = "Terror";
                break;
            case 5:
                categoria[pos] = "Comedia";
                break;
        }

    }

    /**
     * Agraga clientes al arreglo
     */
    public void ingresoClientes() {
        int op = 2;
        int idAux = 0;
        while (nombreClientes[NUM_CLIENTES - 1] == null && op == 2) {
            System.out.print("\ningrese el ID de la Persona que desea registrar ");
            idAux = entrada.nextInt();
            if (validez(idAux, idCliente)) {
                for (int i = 0; i < NUM_CLIENTES; i++) {
                    if (nombreClientes[i] == null) {
                        idCliente[i] = idAux;
                        datosCliente(i);
                        break;
                    }

                }

            } else {
                System.out.println("ERROR, El ID del Cliente ya existe\n");

            }
            System.out.println("***desea agreagar otro clientre***");
            System.out.println("1-Regresar al menu principal");
            System.out.println("2-Agregar otro clientre");
            System.out.print("Digite la opcion ");
            op = entrada.nextInt();

        }
        if (nombreClientes[NUM_CLIENTES - 1] != null) {
            System.out.println("\nYa no cuenta con espacios para agregar mas clientes!!!, SORRY\n");
        }

    }

    /**
     *
     * @param pos posicion donde agregar los datos en el arreglo
     */
    public void datosCliente(int pos) {
        estadoPres[pos] = false;
        System.out.print("\nIngrese el nombre del Cliente ");
        nombrePeliculas[pos] = entrada.next();
        System.out.print("\nIngrese el numero de telefono ");
        telefonoC[pos] = entrada.nextInt();
        entrada.nextLine();
    }

    /**
     * llama a las tabals de diponibles y prestamos hace prestamo
     */
    public void prestamoPeli() {
        cantDip = imprimirTablaDis();
        llenarDatosPres(cantDip);
        cantpr = imprimirTablaPres();

    }

    public void llenarDatosPres(int cantDip) {
        int idC = 0, idP = 0, pos = 0;
        boolean idEx = true, idPx = true;
        if (cantDip != 0) {
            do {
                System.out.println("-El cliente solo puede prestar una pelicula\nPor favor ingreasar dastos correctos o existentes\n");
                System.out.print("ingrese el id del cliente que desea alquilar la pelicula ");
                idC = entrada.nextInt();
                for (int i = 0; i < NUM_PELICULAS; i++) {
                    if (idCliente[i] == idC && estadoPres[i] == false) {
                        estadoPres[i] = true;
                        idPx = false;
                        break;

                    }
                }
                System.out.print("Ingrese el id de la pelicula que desea alquilar ");
                idP = entrada.nextInt();
                for (int i = 0; i < NUM_PELICULAS; i++) {
                    if (idPelicula[i] == idP && estadoDis[i] == false) {
                        idPeliculaP[i] = idP;
                        estadoDis[i] = true;
                        pos = i;
                        idEx = false;
                        break;

                    }
                }

                if (idPx && idEx) {
                    System.out.println("Datos incorrectos");
                } else {
                    System.out.print("Ingrese el los dias de prestamo");
                    diasPresta[pos] += entrada.nextInt();
                    idClienteP[pos] = idC;
                }

            } while (idEx && idPx);
            System.out.println("\n\n***Prestamo Exitoso***\n");

        } else {
            System.out.println("No cuenta con peliculas ");
        }

    }

    /**
     * imprime la tabla de las peliculas prestadas
     */
    public int imprimirTablaPres() {
        String nombreC = "";
        int cantDisp = 0;
        System.out.println("\n***peliculas prestadas***\n");
        System.out.println("______________________________________________________");
        System.out.println("|id | Pelicula | año   | categoria | Dias | Cliente |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯ ");
        for (int i = 0; i < NUM_PELICULAS; i++) {
            if (nombrePeliculas[i] != null && estadoDis[i] == true) {
                for (int j = 0; i < idPeliculaP.length; j++) {
                    if (idClienteP[i]== idCliente[j]) {
                        nombreC = nombreClientes[j];
                        break;
                    }
                   
                }
                System.out.println("|" + idPelicula[i] + "  " + nombrePeliculas[i] + " " + añoP[i] + "  " + categoria[i] + " " + diasPresta[i] +"  "+nombreC +"  |\n");
                cantDisp++;
            }
        }
        return cantDisp;
    }

    public void iniciarDias() {
        for (int i = 0; añoP.length < 10; i++) {
            añoP[i] = 0;
        }
    }

    public void devolucionPeli() {
        cantpr = imprimirTablaPres();
        llenarDatosDevo(cantpr);
        cantDip=imprimirTablaDis();

    }

    public int imprimirTablaDis() {
        String nombreC = "";
        int cantDisp = 0;
        System.out.println("***Peliculas Disponibles***\n");
        System.out.println("____________________________________");
        System.out.println("|id  | Pelicula   | año   | categoria |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for (int i = 0; i < NUM_PELICULAS; i++) {
            if (nombrePeliculas[i] != null && estadoDis[i] == false) {
                System.out.println("|" + idPelicula[i] + "     " + nombrePeliculas[i] + "    " + añoP[i] + "    " + categoria[i] + " |\n");
                cantDisp++;
            }
        }
        return cantDisp;
    }

    public void llenarDatosDevo(int cantpr) {
        int idC = 0, idP = 0, pos = 0;
        boolean idEx = true, idPx = true;
        if (cantpr != 0) {
            do {
                
                System.out.print("Ingrese el id de la pelicula");
                idP= entrada.nextInt();
                for (int i = 0; i < NUM_PELICULAS; i++) {
                    if (idPelicula[i] == idP && estadoDis[i] == true){
                        estadoDis[i] = false;
                        idEx = false;
                        break;
                    }
                }
                System.out.print("ingrese el id del cliente");
                idC=entrada.nextInt();
                for (int i = 0; i < NUM_PELICULAS; i++) {
                    if (idCliente[i] == idC && estadoPres[i] == true){
                        estadoPres[i] = false;
                        idPx = false;
                        break;
                    }
                }
                
                
                
                if (idPx && idEx) {
                    System.out.println("Datos incorrectos");
                }
            } while (idEx && idPx);
            
        }else {
            System.out.println("No cuenta con peliculas ");
        }

    }
    
    public void mostrasPelicuals(){
        System.out.println("\n****Datos de las Peliculas Registradas*****\n ");
        System.out.println("_____________________________________");
        System.out.println("|id | Pelicula | año   | categoria  |");
        System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
        for (int i = 0; i < NUM_PELICULAS; i++) {
            if (nombrePeliculas != null) {
                System.out.println("|"+idPelicula[i]+" |"+nombrePeliculas[i]+" |"+añoP[i]+" |"+categoria[i]+" |");  
            }
            
        }
    }
}
