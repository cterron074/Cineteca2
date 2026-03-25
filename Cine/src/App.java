import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class App {
    final static Scanner SC = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Bienvenido a KATACINEMA");
        System.out.println("Bienvenido a KATACINEMA");
        /*
        Como de momento el cine solo tiene una sala, tendremos que tener en cuenta la siguiente
        información.
            - Debemos almacenar las películas en un arrayList.
            - Debemos almacenar toda la información referente a las sesiones en un mapa. La clave del mapa
            será el nombre de la película, y el valor será un arrayList con las sesiones que tiene esa película.   
        */

       //inicializo pelis
            Pelicula p1= new Pelicula("Harry Potter y el Prisionero de Azkaban", "Alfondo Cuarón", 141);
            Pelicula p2= new Pelicula("Parasitos", "Bong Joon-ho", 132);
            Pelicula p3= new Pelicula("Dirty Dancing",  "Emile Ardolino", 100);
            //creo ArrayList que guarda mis pelis
            ArrayList <Pelicula> pelis = new ArrayList<>();
            //Añado mis pelis
            pelis.add(p1);
            pelis.add(p2);
            pelis.add(p3);

            System.out.println("Tus pelis son :");
            imprimirPelis(pelis);

            //Creo las sesiones para cada peli
            Sesion ses1p1= new Sesion(p1, "18:00");
            Sesion ses2p1= new Sesion(p1, "21:30");
            Sesion ses1p2= new Sesion(p2, "18:00");
            Sesion ses1p3= new Sesion(p3, "18:00");

            System.out.println("Tus sesiones son:");
            //creo un arrayList de sesiones para guardar las sesiones de cada peli y añado las sesiones de cada peli
            ArrayList<Sesion> sesionesPeli1 =new ArrayList<>();
            sesionesPeli1.add(ses1p1);
            sesionesPeli1.add(ses2p1);
            imprimirSesiones(sesionesPeli1);
            

            ArrayList<Sesion> sesionesPeli2 =new ArrayList<>();
            sesionesPeli2.add(ses1p2);
            imprimirSesiones(sesionesPeli2);
            

            ArrayList<Sesion> sesionesPeli3 =new ArrayList<>();
            sesionesPeli3.add(ses1p3);

            imprimirSesiones(sesionesPeli3);
            
            Map <String,ArrayList<Sesion>> cartelera = new HashMap<>();

            System.out.println("Tu cartelera es: ");
            cartelera.put(p1.getNombre(), sesionesPeli1);
            cartelera.put(p2.getNombre(), sesionesPeli2);
            cartelera.put(p3.getNombre(), sesionesPeli3);

             for (Entry<String,ArrayList<Sesion>> entrada: cartelera.entrySet()) {
                String str="--------Pelicula: "+entrada.getKey()+"--------";
                System.out.println(str);
                for (Sesion sesion : entrada.getValue()) {
                    System.out.println(sesion.toString());
                    System.out.println();
                    
                }
                     System.out.println();
                 
                
                     }
    /*
     Además, debemos implementar un menú que nos permita realizar lo siguiente:
            - Añadir película.
            - Añadir sesión: Nos preguntará qué película va a ser proyectada.
            - Ver películas disponibles: Nos mostrará solo las películas con sesiones asociadas.
            - Comprar entradas. Elegiremos la película y nos mostrará las sesiones en las que se proyecta para
             elegir una. Si no quedan entradas disponibles no nos dejará comprarla.
            - Salir.
    */

   boolean seguirMenu=true;
   while (seguirMenu==true) {
        int menu=-1;
        System.out.println("==================================");
        System.out.println("=========MENU KATACINEMA==========");
        System.out.println("==================================");
        System.out.println("1 - AÑADIR PELI");
        System.out.println("2 - AÑADIR SESIÓN");
        System.out.println("3 - VER PELIS PARA ESA SESION");
        System.out.println("4 - COMPRAR ENTRADAS PARA ESA SESION");
        System.out.println("0 - SALIR");
        System.out.println("==================================");
        System.out.println("Elige una opcion");
        menu=validarEntero(menu);

        switch (menu) {
            case 1:
                 System.out.println("Vamos a Crear tu Pelicula:");
                    System.out.println("Dime Nombre de tu película.");
                    String nombrePeliAux=SC.nextLine();
                    boolean PeliEncontrada=false;
                    for (Pelicula pelicula : pelis) {
                        if (nombrePeliAux==pelicula.getNombre()) {
                            PeliEncontrada=true;
                        }
                    }
                    if (PeliEncontrada==true) {
                        System.out.println("Tu pelicula ya estaba.");
                    }
                    System.out.println("Dime nombre de director.");
                    String directorPeliAux= SC.nextLine();
                    System.out.println("Indica la duracion en minutos");
                    int duracion=0;
                    duracion=validarEntero(duracion);

                    Pelicula aux=new Pelicula(nombrePeliAux, directorPeliAux,duracion);
                    pelis.add(aux);
                    ArrayList <Sesion> sesionesAux=new ArrayList<>();
                    cartelera.put(aux.getNombre(), sesionesAux);
                    System.out.println("Tus pelis actuales son: ");
                    imprimirPelis(pelis);

                break;
                case 2:
                    //Añadir Sesion
                    System.out.println("Indica la peli de la que quieres añadir una sesion");
                    String peliSesion=SC.nextLine();
                    if (cartelera.containsKey(peliSesion)==true) {
                        
                        System.out.println("Pelicula encontrada");
                        System.out.println("Indica hora de la sesion");
                        String horaSesion=SC.nextLine();
                                      
                        for (int i = 0; i < pelis.size(); i++) {
                        if (peliSesion.equals(pelis.get(i).getNombre())==true) {
                            Pelicula auxi= pelis.get(i); //accedo a la peli de la cartelera
                            Sesion s = new Sesion(auxi, horaSesion); //accedo a la peli de la cartelera
                            cartelera.get(peliSesion).add(s);
                            System.out.println("Sesión añadida con éxito.");
                        }

                       
        }
                    }
                    else{
                        System.out.println("Peli no encontrada");
                    }
                    System.out.println("Tus sesiones actuales son: ");
                    imprimirSesiones(cartelera.get(peliSesion));

                break;
                    case 3:
                        System.out.println("Para qué peli quieres ver sesiones?");
                        String verPeli=SC.nextLine();
                        boolean encontrada=false;
                        for (Entry <String,ArrayList<Sesion>> ses : cartelera.entrySet()) {
                            if (ses.getKey().equals(verPeli)==true) {
                                for (int i = 0; i < ses.getValue().size(); i++) {
                                    System.out.println(ses.getValue().toString());
                                }
                               encontrada=true;
                                
                            }
                        } 
                        if (encontrada==false) {
                            System.out.println("Peli no encontrada");
                        }
                       
                        break;
            case 4:
                System.out.println("Para qué peli quieres ver sesiones?");
                        verPeli=SC.nextLine();
                        encontrada=false;
                        System.out.println("Tus sesiones son: ");
                        for (Entry <String,ArrayList<Sesion>> ses : cartelera.entrySet()) {
                            if (ses.getKey().equals(verPeli)==true) {
                                for (int i = 0; i < ses.getValue().size(); i++) {
                                    System.out.println("---Sesion "+i+"----");
                                    System.out.println(ses.getValue().toString());
                                    //Sesion auxSes= ses.getValue().get(i);
                                }
                               encontrada=true;
                                
                            }
                        } 
                        System.out.println("Qué sesion quieres, pon el numero");
                        int nSesion=-1;
                        nSesion=validarEntero(nSesion);
                        for (Entry <String,ArrayList<Sesion>> ses : cartelera.entrySet()) {
                            if (ses.getKey().equals(verPeli)==true) {
                                for (int i = 0; i < ses.getValue().size(); i++) {
                                    if (nSesion==i) {
                                        System.out.println("¿Cuantas entradas?");
                                        int numEntr=-1;
                                        numEntr=validarEntero(numEntr);
                                        ses.getValue().get(i).comprar(numEntr);
                                        System.out.println(ses.getValue().toString());
                                    }
                                    //Sesion auxSes= ses.getValue().get(i);
                                }
                               encontrada=true;
                                
                            }
                        } 

                        
                        



                break;
            case 0:
                seguirMenu=false;
                break;
        }

    }


    SC.close();
    }
    public static int validarEntero(int escanner) {
        /* en el menu:
        int menu=-1;
        menu=validarEntero(menu);
         */
        while (true) { // Bucle infinito hasta que el dato sea correcto
            try {
                escanner=SC.nextInt();
                SC.nextLine();
                return escanner; // Si es un entero, lo devuelve y sale del método
            } catch (Exception e) {
                System.err.println(" Entrada no válida. Por favor, introduce un número:");
                SC.nextLine(); // Limpiamos el "aire" (buffer) para que no se quede trabado
            }
        }
    }
    public static void imprimirPelis(ArrayList<Pelicula> paux){
                for (int i = 0; i < paux.size(); i++) {
                    System.out.println(paux.get(i).toString());
                }
                
            }
    public static void imprimirSesiones(ArrayList<Sesion> Saux){
                for (int i = 0; i < Saux.size(); i++) {
                    System.out.println(Saux.get(i).toString());
                }
                
            }
    public static void imprimirMapa(Map <String,ArrayList<Sesion>> cartelera){
            for (Entry<String,ArrayList<Sesion>> entrada: cartelera.entrySet()) {
                String str="--------Pelicula: "+entrada.getKey()+"--------";
                System.out.println(str);
                for (Sesion sesion : entrada.getValue()) {
                    System.out.println(sesion.toString());
                    System.out.println();
                        
                }
                System.out.println();
            }
    

        }
    }
