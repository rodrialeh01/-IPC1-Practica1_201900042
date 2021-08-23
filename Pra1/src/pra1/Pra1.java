package pra1;
//IMPORTAR LAS LIBRERIAS CORRESPONDIENTES
import java.util.Random;
import java.util.Scanner;

//CLASE PRINCIPAL LA CUAL DESDE AQUI INICIA TODO EL PROCESO DEL PROGRAMA
public class Pra1 {    
    public static void main(String[] args) {
        //Se manda a llamar la clase programap para ejecutar las instrucciones de esa clase
        programap m = new programap();
        m.menu();
    }
    
}
//Clase donde se desarrollará el programa
class programap{
    static int[][] tablero;
    static int[][] penalizaciones;
    //Procedimiento donde se ejecutara el menu principal
    public void menu(){
        //Se manda a llamar a la libreria Scanner
        Scanner leerm = new Scanner(System.in);
        //Se inicializa la variable que va a leer las opciones del menu principal
        int opcion=0;
        //Se imprime el Título del juego
        System.out.println("    ______                __                        __  ___      __                       __  _                \n" +
"   / ____/_____________ _/ /__  _________ ______   /  |/  /___ _/ /____  ____ ___  ____ _/ /_(_)________ ______\n" +
"  / __/ / ___/ ___/ __ `/ / _ \\/ ___/ __ `/ ___/  / /|_/ / __ `/ __/ _ \\/ __ `__ \\/ __ `/ __/ / ___/ __ `/ ___/\n" +
" / /___(__  ) /__/ /_/ / /  __/ /  / /_/ (__  )  / /  / / /_/ / /_/  __/ / / / / / /_/ / /_/ / /__/ /_/ (__  ) \n" +
"/_____/____/\\___/\\__,_/_/\\___/_/   \\__,_/____/  /_/  /_/\\__,_/\\__/\\___/_/ /_/ /_/\\__,_/\\__/_/\\___/\\__,_/____/");
        //System.out.println("============================================");
        //System.out.println("=========== ESCALERAS MATEMÁTICAS ==========");
        //System.out.println("==         =======================        ==");
        //Se usa un do-while para que el menu se ejecute varias veces
        do {
            //
            try{
                
                System.out.println("===========     MENÚ PRINCIPAL    ==========");
                System.out.println("== 1. Iniciar Juego                       ==");
                System.out.println("== 2. Reanudar Juego                      ==");
                System.out.println("== 3. Generar Reportes                    ==");
                System.out.println("== 4. Salir                               ==");
                System.out.println("============================================");
                opcion = leerm.nextInt();
                switch(opcion){
                    //OPCION PARA INICIAR EL JUEGO
                    case 1: 
                        tablero();
                        System.out.println("");
                        System.out.println("");
                        break;
                    //OPCION REANUDAR JUEGO
                    case 2:
                        break;
                    //OPCION GENERAR REPORTES
                    case 3:
                        break;
                    //OPCION SALIR
                    case 4:
                        System.out.println("============================================");
                        System.out.println("==         Adiós, vuelve pronto :3        ==");
                        break;
                    //SI NINGUNA DE LAS ANTERIORES SE CUMPLE ENTONCES MOSTRARA UN MENSAJE DE ERROR
                    default:
                        System.out.println("INGRESA LA OPCIÓN CORRECTA");
                        break;
                }
            }catch(Exception e){
                //MUESTRA UN MENSAJE DE ERROR PARA LOS QUE INGRESEN UN CARACTER NO NUMERICO
                leerm.nextLine();
                System.out.println("UNICAMENTE INGRESAR NUMEROS ENTEROS");
            }
        //EL CICLO TERMINA CUANDO ELIJAN LA OPCION 4
        }while (opcion != 4);
    }
    
    //Procedimiento para generar el tablero
    public void tablero(){
        tablero = new int[8][8];
        penalizaciones = new int[8][8];
        
        int contador = 1;
        boolean izquierda = false;
        for (int i = 8-1; i >=0; i--) {
            if (izquierda) {
                for (int j = 0; j <tablero[i].length ; j++) {
                    tablero[i][j]= contador;
                    contador++;
                }
            }else{
                for (int j = tablero[i].length-1; j >=0 ; j--) {
                    tablero[i][j]= contador;
                    contador++;
                }
                
            }
            izquierda = !izquierda;
        }
        /*
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("\t|" + tablero[i][j]);
                
            }  
            System.out.println("");
        }
        */
        Random rd = new Random();
        int p;
        for (int i = 8-1; i >=0; i--) {
            if (izquierda) {
                for (int j = 0; j <penalizaciones[i].length ; j++) {
                    if (rd.nextBoolean()==true) {
                        p = 1;
                    }else{
                        p=0;
                    }
                    penalizaciones[i][j]=p;
                }
            }else{
                for (int j = penalizaciones[i].length-1; j >=0 ; j--) {
                    if (rd.nextBoolean()==true) {
                        p = 1;
                    }else{
                        p=0;
                    }
                    penalizaciones[i][j]=p;
                }
                
            }
            izquierda = !izquierda;
        }
        /*
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print("\t|" + penalizaciones[i][j]);
                
            }  
            System.out.println("");
        }
        System.out.println("-----------------------");
        */
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (penalizaciones[i][j]==1) {
                    System.out.print("# " + tablero[i][j] + "\t|");
                }else{
                    System.out.print("  " + tablero[i][j] + "\t|");
                }
            }  
            System.out.println("");
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que quieres hacer?");
        System.out.println("1. Tirar el dado");
        System.out.println("2. Pausa");
        int o = sc.nextInt();
        if (o == 1) {
            System.out.println("Dado: " + Dado());
        }else if (o == 2) {
            
        }else{
            System.out.println("INGRESE LA OPCION CORRECTA");
        }
        
    }
    //FUNCION PARA QUE TIRE UN NUMERO ALEATORIO ENTRE 2 Y 6
    public int Dado(){
        Random r = new Random();
        //int dado = 2;
        int dado = 2+r.nextInt((6-2)+1);
        return dado;
    }
}
