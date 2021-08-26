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
                System.out.println("============================================");                
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
    
    static int[][] tablero = new int[8][8];
    static String[][] movimiento = new String[8][8];
    static int[][] penalizaciones = new int[8][8];
    static int estado;
    public void tablero(){
        //PENALIZACIONES
        Scanner leer = new Scanner(System.in);
        Random r = new Random();
        int p ;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < penalizaciones[i].length; j++) {
                    if (r.nextBoolean() == true) {
                        p = 1;
                    } else {
                        p = 0;
                    }
                    penalizaciones[i][j] = p;                    
            }
        }
        penalizaciones[7][7] = 0;
        
        //TABLERO
        boolean izquierda = false;
        int contador = 1;
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
        
        //TABLERO DE MOVIMIENTOS
        for (int i = 0; i <8; i++) {            
            for (int j = 0; j < 8; j++) {
                movimiento[i][j] = " ";
            }
        }
        movimiento[7][7] = "@";
        
        //VARIABLE OPCION
        int o;
        //VARIABLE PARA EL NUMERO QUE VA A TOMAR COMO BASE PARA EL MOVIMIENTO
        int base = 1;
        
        
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // IMPRIMIR LAS PENALIZACIONES
                    if (penalizaciones[i][j] == 1) {
                        System.out.print("# " + tablero[i][j] + "\t|");
                    } else {
                        System.out.print("  " + tablero[i][j] + "\t|");
                    }

                }
                System.out.println("");
                // IMPRIMIR LA MATRIZ DE MOVIMIENTOS
                for (int j = 0; j < 8; j++) {
                    
                    System.out.print(movimiento[i][j] + "\t|");
                }
                System.out.println("");
                System.out.println("-----------------------------------------------------------------");
            }
        
        do {
            
            
            //MENU PARA DAR INSTRUCCIONES DEL JUEGO
            System.out.println("¿Que quiere hacer?");
            System.out.println("1. Tirar el dado");
            System.out.println("2. Pausa");
            o = leer.nextInt();
            
            //VARIABLE PARA GUARDAR LO QUE DEVOLVIO LA FUNCION DADO
            int d = Dado();
            
            //VALIDAR LA OPCION 1
            if (o == 1) {                
                System.out.println("======================================================================");
                //MUESTRA EL RESULTADO DEL DADO
                System.out.println("    DADO: " + d);
                System.out.println("");
                
                //----------MOVIMIENTOS DE LA FICHA-----------
                //IMPRIME EL TABLERO COMO VACIO
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        movimiento[i][j] = " ";
                    }
                }
                
                //La variable base va a ser igual a la suma de ese numero con lo que muestre el dado
                base = base + d;
                //Se crea una variable String para leer la duncion posicion
                String sp = posicion(base);
                //Se guarda en un arreglo de string los numeros sacados de la funcion
                String[] coordenadas = sp.split(",");
                //Se guarda las coordenadas de la nueva posicion de la ficha
                int x = Integer.parseInt(coordenadas[0]);
                int y = Integer.parseInt(coordenadas[1]);
                //SI EL TABLERO NO PASA DE 64 ENTONCES QUE VAYA MOVIENDOSE LA FICHA
                if (y < 8) {
                    //IMPRIME LA FICHA
                    movimiento[x][y] = "@";
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            // IMPRIMIR LAS PENALIZACIONES
                            if (penalizaciones[i][j] == 1) {
                                System.out.print("# " + tablero[i][j] + "\t|");
                            } else {
                                System.out.print("  " + tablero[i][j] + "\t|");
                            }

                        }
                        System.out.println("");
                        // IMPRIMIR LA MATRIZ DE MOVIMIENTOS
                        for (int j = 0; j < 8; j++) {

                            System.out.print(movimiento[i][j] + "\t|");
                        }
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------");
                    }
                    //----VALIDACION DE LA POSICION DE LA FICHA CON LAS PENALIZACIONES----
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < penalizaciones[i].length; j++) {
                            if (penalizaciones[i][j] == 1) {
                                //SI LAS PENALIZACIONES SON 1 Y ESTAN EN LA MISMA POSICION DE LA FICHA ENTONCES QUE SE EJECUTEN LAS FUNCIONES
                                /**
                                 * SI ESTA EN LA FILA 7 Y 6: SE LLAMA A LA PENALIZACIÓN FACIL
                                 * SI ESTA EN LA FILA 5, 4 y 3: SE LLAMA A LA PENALIZACIÓN INTERMEDIA
                                 * SI ESTA EN LA FILA 2, 1 Y 0: SE LLAMA A LA PENALIZACIÓN DIFICIL
                                **/
                                if (i == x && j == y) {
                                    if (i == 0 || x == 0) {
                                        penalizaciondificil();
                                    }else if (i == 1 || x == 1) {
                                        penalizaciondificil();
                                    }else if (i == 2 || x == 2) {
                                        penalizaciondificil();
                                    }else if (i == 3 || x == 3) {
                                        penalizacionIntermedia();
                                    }else if (i == 4 || x == 4) {
                                        penalizacionIntermedia();
                                    }else if (i == 5 || x == 5) {
                                        penalizacionIntermedia();
                                    }else if (i == 6 || x == 6) {
                                        penalizacionfacil();
                                    }else if (i == 7 || x == 7) {
                                        penalizacionfacil();
                                    }
                                    
                                }
                            }                            
                        }
                    }
                }else{
                    //SI SUPERA AL TAMAÑO DEL TABLERO ENTONCES SE FINALIZA EL JUEGO
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            // IMPRIMIR LAS PENALIZACIONES
                            if (penalizaciones[i][j] == 1) {
                                System.out.print("# " + tablero[i][j] + "\t|");
                            } else {
                                System.out.print("  " + tablero[i][j] + "\t|");
                            }

                        }
                        System.out.println("");
                        // IMPRIMIR LA MATRIZ DE MOVIMIENTOS
                        for (int j = 0; j < 8; j++) {

                            System.out.print("" + "\t|");
                        }
                        System.out.println("");
                        System.out.println("-----------------------------------------------------------------");
                    }
                    System.out.println("");
                    System.out.println("$$$$$$$$\\ $$$$$$\\ $$\\   $$\\       $$$$$$$\\  $$$$$$$$\\ $$\\                $$$$$\\ $$\\   $$\\ $$$$$$$$\\  $$$$$$\\   $$$$$$\\  \n" +
"$$  _____|\\_$$  _|$$$\\  $$ |      $$  __$$\\ $$  _____|$$ |               \\__$$ |$$ |  $$ |$$  _____|$$  __$$\\ $$$ __$$\\ \n" +
"$$ |        $$ |  $$$$\\ $$ |      $$ |  $$ |$$ |      $$ |                  $$ |$$ |  $$ |$$ |      $$ /  \\__|$$$$\\ $$ |\n" +
"$$$$$\\      $$ |  $$ $$\\$$ |      $$ |  $$ |$$$$$\\    $$ |                  $$ |$$ |  $$ |$$$$$\\    $$ |$$$$\\ $$\\$$\\$$ |\n" +
"$$  __|     $$ |  $$ \\$$$$ |      $$ |  $$ |$$  __|   $$ |            $$\\   $$ |$$ |  $$ |$$  __|   $$ |\\_$$ |$$ \\$$$$ |\n" +
"$$ |        $$ |  $$ |\\$$$ |      $$ |  $$ |$$ |      $$ |            $$ |  $$ |$$ |  $$ |$$ |      $$ |  $$ |$$ |\\$$$ |\n" +
"$$ |      $$$$$$\\ $$ | \\$$ |      $$$$$$$  |$$$$$$$$\\ $$$$$$$$\\       \\$$$$$$  |\\$$$$$$  |$$$$$$$$\\ \\$$$$$$  |\\$$$$$$  /\n" +
"\\__|      \\______|\\__|  \\__|      \\_______/ \\________|\\________|       \\______/  \\______/ \\________| \\______/  \\______/");
                    System.out.println("");
                    break;                
                }
            }else{
                System.out.println("");
            }            
            
            
        } while (o == 1 || o != 2);        
    }
     
    //FUNCION PARA RETORNAR UN VALOR ALEATORIO ENTRE 2 Y 6
    public int Dado(){
        Random r = new Random();
        int dado = 2+r.nextInt((6-2)+1);
        return dado;
    }
    
    //FUNCION PARA RETORNAR LAS COORDENADAS DE LA FICHA
    public String posicion(int b){
        switch(b){
            case 2:                
                return "7,6";
            case 3:
                return "7,5";
            case 4:
                return "7,4";
            case 5:
                return "7,3";
            case 6:
                return "7,2";
            case 7:
                return "7,1";
            case 8:
                return "7,0";
            case 9:
                return "6,0";
            case 10:
                return "6,1";
            case 11:
                return "6,2";
            case 12:
                return "6,3";
            case 13:
                return "6,4";
            case 14:
                return "6,5";
            case 15:
                return "6,6";
            case 16:
                return "6,7";
            case 17:
                return "5,7";
            case 18:
                return "5,6";
            case 19:
                return "5,5";
            case 20:
                return "5,4";
            case 21:
                return "5,3";
            case 22:
                return "5,2";
            case 23:
                return "5,1";
            case 24:
                return "5,0";
            case 25:
                return "4,0";
            case 26:
                return "4,1";
            case 27:
                return "4,2";
            case 28:
                return "4,3";
            case 29:
                return "4,4";
            case 30:
                return "4,5";
            case 31:
                return "4,6";
            case 32:
                return "4,7";
            case 33: 
                return "3,7";
            case 34:
                return "3,6";
            case 35:
                return "3,5";
            case 36:
                return "3,4";
            case 37:
                return "3,3";
            case 38:
                return "3,2";
            case 39:
                return "3,1";
            case 40:
                return "3,0";
            case 41:
                return "2,0";
            case 42:
                return "2,1";
            case 43:
                return "2,2";
            case 44:
                return "2,3";
            case 45:
                return "2,4";
            case 46:
                return "2,5";
            case 47:
                return "2,6";
            case 48:
                return "2,7";
            case 49:
                return "1,7";
            case 50:
                return "1,6";
            case 51:
                return "1,5";
            case 52:
                return "1,4";
            case 53:
                return "1,3";
            case 54:
                return "1,2";
            case 55:
                return "1,1";
            case 56:
                return "1,0";
            case 57:
                return "0,0";
            case 58:
                return "0,1";
            case 59:
                return "0,2";
            case 60:
                return "0,3";
            case 61:
                return "0,4";
            case 62:
                return "0,5";
            case 63:
                return "0,6";
            case 64:
                return "0,7";
            default:
                return "0,8";
        }
    }
    
    //------------------------------------------- PENALIZACIONES ----------------------------------------------
    //-----------------------------------------PENALIZACIÓN FACIL-------------------------------------
    //METODO PARA EL MENU DE LA PENALIZACION FACIL
    public void penalizacionfacil(){
        Random rf = new Random();
        int opn = 1+rf.nextInt((3-1)+1);
        System.out.println("=================================================");
        System.out.println("===     ¡HAS CAIDO EN UNA PENALIZACIÓN!       ===");
        System.out.println("===             MODALIDAD: FACIL              ===");
        System.out.println("=================================================");
        switch (opn) {
            case 1:
                opcionaf();
                break;
            case 2:
                opcionbf();
                break;
            case 3:
                opcioncf();
                break;
        }
    }
    
    //METODO PARA LA OPCION A DE LA PENALIZACION FACIL
    public void opcionaf(){
        Scanner sc = new Scanner(System.in);
        double lbi1, ancybi, anaybi;
        int a1 = 15;
        double b1, beta1,gama1;
        int c1 = 20;
        int alpha1 = 25;
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado A = 15                                                ===");
        System.out.println("===Lado C = 20                                                ===");
        System.out.println("===Ángulo entre A y C = 25°                                   ===");
        System.out.println("=================================================================");
        //PIDE LOS DATOS AL USUARIO
        System.out.print("¿Cuál es el valor del lado B?(APROXIME A TRES DECIMALES ) :  ");
        lbi1 = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"B\" y \"C\"? (REDONDEE A TRES DECIMALES) (EN GRADOS) : ");
        ancybi = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"A\" y \"B\"? (REDONDEE A TRES DECIMALES) (EN GRADOS) : ");
        anaybi = sc.nextDouble();      
        
        //LA PROGRAMACIÓN DEL CALCULO HECHO EN EL PROGRAMA PARA LA RESPUESTA CORRECTA
        b1 = Math.sqrt(((a1*a1)+(c1*c1)-2*a1*c1*(Math.cos(Math.toRadians(alpha1)))));
        beta1 = Math.toDegrees(Math.acos(((b1*b1)-(a1*a1)+(c1*c1))/(2*b1*c1)));
        gama1 = Math.toDegrees(Math.acos(((b1*b1)+(a1*a1)-(c1*c1))/(2*b1*a1)));
        
        //VALIDACION SI ES CORRECTO O NO
        if ((Math.round(lbi1*1000.0)/1000.0) == (Math.round(b1*1000.0)/1000.0) && (Math.round(ancybi*1000.0)/1000.0) == (Math.round(beta1*1000.0)/1000.0) && (Math.round(anaybi*1000.0)/1000.0) == (Math.round(gama1*1000.0)/1000.0)) {
            System.out.println("===========");
            System.out.println("ES CORRECTO");
            System.out.println("===========");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO B: " + lbi1);
            System.out.println("    ANGULO ENTRE B Y C: " + ancybi);
            System.out.println("    ANGULO ENTRE A Y B: " + anaybi);
            System.out.println("");
            System.out.println("LA RESPUESTA DEL SISTEMA: ");
            System.out.println("    LADO B: " + (Math.round(b1*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta1*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama1*1000.0)/1000.0)));
            System.out.println("");
        }else{
            System.out.println("=============");
            System.out.println("ES INCORRECTO");
            System.out.println("=============");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO B: " + lbi1);
            System.out.println("    ANGULO ENTRE B Y C: " + ancybi);
            System.out.println("    ANGULO ENTRE A Y B: " + anaybi);
            System.out.println("");
            System.out.println("LA RESPUESTA CORRECTA ES: ");
            System.out.println("    LADO B: " + (Math.round(b1*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta1*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama1*1000.0)/1000.0)));
            System.out.println("");
        }
    }
    
    //METODO PARA LA OPCION B DE LA PENALIZACION FACIL
    public void opcionbf(){
        Scanner sc = new Scanner(System.in);
        double lai2, ancyai, anaybi;
        int b2 = 10;
        double a2, alpha2,gama2;
        int c2 = 25;
        int beta2 = 30;
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado B = 10                                                ===");
        System.out.println("===Lado C = 25                                                ===");
        System.out.println("===Ángulo entre B y C = 30°                                   ===");
        System.out.println("=================================================================");
        //SE LE PIDEN LOS DATOS AL USUARIO
        System.out.print("¿Cuál es el valor del lado A?(APROXIME A 3 DECIMALES ) :  ");
        lai2 = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"A\" y \"C\"? (REDONDEE A 3 DECIMALES) (EN GRADOS) : ");
        ancyai = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"A\" y \"B\"? (REDONDEE A 3 DECIMALES) (EN GRADOS) : ");
        anaybi = sc.nextDouble();      
        
        //SE REALIZA LA PROGRAMACIÓN PARA ENCONTRAR LA RESPUESTA CORRECTA
        a2 = Math.sqrt(((b2*b2)+(c2*c2)-2*b2*c2*(Math.cos(Math.toRadians(beta2)))));
        alpha2 = Math.toDegrees(Math.acos(((a2*a2)-(b2*b2)+(c2*c2))/(2*a2*c2)));
        gama2 = Math.toDegrees(Math.acos(((b2*b2)+(a2*a2)-(c2*c2))/(2*b2*a2)));
        
        //SE VALIDA LA RESPUESTA
        if ((Math.round(lai2*1000.0)/1000.0) == (Math.round(a2*1000.0)/1000.0) && (Math.round(ancyai*1000.0)/1000.0) == (Math.round(alpha2*1000.0)/1000.0) && (Math.round(anaybi*1000.0)/1000.0) == (Math.round(gama2*1000.0)/1000.0)) {
            System.out.println("===========");
            System.out.println("ES CORRECTO");
            System.out.println("===========");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO A: " + lai2);
            System.out.println("    ANGULO ENTRE A Y C: " + ancyai);
            System.out.println("    ANGULO ENTRE A Y B: " + anaybi);
            System.out.println("");
            System.out.println("LA RESPUESTA DEL SISTEMA: ");
            System.out.println("    LADO A: " + (Math.round(a2*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha2*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama2*1000.0)/1000.0)));
            System.out.println("");
        }else{
            System.out.println("=============");
            System.out.println("ES INCORRECTO");
            System.out.println("=============");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO A: " + lai2);
            System.out.println("    ANGULO ENTRE A Y C: " + ancyai);
            System.out.println("    ANGULO ENTRE A Y B: " + anaybi);
            System.out.println("");
            System.out.println("LA RESPUESTA CORRECTA ES: ");
            System.out.println("    LADO A: " + (Math.round(a2*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha2*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama2*1000.0)/1000.0)));
            System.out.println("");
        }
    }
    
    //METODO PARA LA OPCION C DE LA PENALIZACION FACIL
    public void opcioncf(){
        Scanner sc = new Scanner(System.in);
        double lci3, ancyai, ancybi;
        int a3 = 18;
        double c3, alpha3,beta3;
        int b3 = 25;
        int gama3 = 30;
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado A = 18                                                ===");
        System.out.println("===Lado B = 25                                                ===");
        System.out.println("===Ángulo entre A y B = 30°                                   ===");
        System.out.println("=================================================================");
        //SE LE PIDEN LOS DATOS AL USUARIO
        System.out.print("¿Cuál es el valor del lado C?(APROXIME A 3 DECIMALES ) :  ");
        lci3 = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"A\" y \"C\"? (REDONDEE A 3 DECIMALES) (EN GRADOS) : ");
        ancyai = sc.nextDouble();
        System.out.print("¿Cuál es el valor del ángulo entre \"B\" y \"C\"? (REDONDEE A 3 DECIMALES) (EN GRADOS) : ");
        ancybi = sc.nextDouble();      
        
        //SE PROGRAMA PARA QUE EL PROGRAMA ENCUENTRE LA RESPUESTA CORRECTA
        c3 = Math.sqrt(((b3*b3)+(a3*a3)-2*b3*a3*(Math.cos(Math.toRadians(gama3)))));
        alpha3 = Math.toDegrees(Math.acos(((a3*a3)-(b3*b3)+(c3*c3))/(2*a3*c3)));
        beta3 = Math.toDegrees(Math.acos(((b3*b3)-(a3*a3)+(c3*c3))/(2*b3*c3)));
        
        //SE VALIDA AL RESPUESTA DEL SISTEMA CON LA DEL USUARIO
        if ((Math.round(lci3*1000.0)/1000.0) == (Math.round(c3*1000.0)/1000.0) && (Math.round(ancyai*1000.0)/1000.0) == ((Math.round(alpha3*1000.0)/1000.0)) && (Math.round(ancybi*1000.0)/1000.0) == (Math.round(beta3*1000.0)/1000.0)) {
            System.out.println("===========");
            System.out.println("ES CORRECTO");
            System.out.println("===========");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO C: " + lci3);
            System.out.println("    ANGULO ENTRE A Y C: " + ancyai);
            System.out.println("    ANGULO ENTRE B Y C: " + ancybi);
            System.out.println("");
            System.out.println("LA RESPUESTA DEL SISTEMA: ");
            System.out.println("    LADO B: " + (Math.round(c3*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha3*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta3*1000.0)/1000.0)));
            System.out.println("");
        }else{
            System.out.println("=============");
            System.out.println("ES INCORRECTO");
            System.out.println("=============");
            System.out.println("SUS RESPUESTAS SON: ");
            System.out.println("    LADO B: " + lci3);
            System.out.println("    ANGULO ENTRE A Y C: " + ancyai);
            System.out.println("    ANGULO ENTRE B Y C: " + ancybi);
            System.out.println("");
            System.out.println("LA RESPUESTA CORRECTA ES: ");
            System.out.println("    LADO B: " + (Math.round(c3*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha3*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta3*1000.0)/1000.0)));
            System.out.println("");
        }
    }
    
    
    //-----------------------------------------PENALIZACIÓN INTERMEDIA-------------------------------------
    
    //------------------OPCION A---------------
    //MATRIZ A
    static int[][] mai1 = {{7,48,5,0,1},{57,8,4,6,14},{0,5,6,78,15},{21,14,8,19,54},{32,20,26,47,12}};
    //MATRIZ B
    static int[][] mbi1 = {{9,5,2,1,8},{4,2,3,47,8},{48,55,32,19,6},{7,56,32,14,8},{32,87,0,1,7}};
    //MATRIZ INGRESADO Y RESULTADO
    static int[][] mri1, mri1c;
    
    //------------------OPCION B---------------
    //MATRIZ A
    static int[][] mai2 = {{4,9,7,45,18},{7,51,26,8,38},{48,26,37,21,19},{1,0,6,8,1},{2,19,55,25,15}};
    //MATRIZ B
    static int[][] mbi2 = {{0,2,15,1,66},{21,48,62,7,33},{4,88,0,68,4},{25,18,24,7,55},{24,15,36,5,98}};
    //MATRIZ INGRESADO Y RESULTADO
    static int[][] mri2, mri2c;
    
    //------------------OPCION C---------------
    //MATRIZ A
    static int[][] mai3 = {{0,1,15,5,36},{1,78,65,32,4},{48,66,39,0,55},{14,98,63,20,15},{11,39,84,7,1}};
    //MATRIZ B
    static int[][] mbi3 = {{78,25,66,48,98},{0,45,2,3,1},{2,9,14,10,20},{35,87,65,2,32},{25,8,4,9,39}};
    //MATRIZ INGRESADO Y RESULTADO
    static int[][] mri3, mri3c;
   
    //METODO PARA EL MENU DE LA PENALIZACION INTERMEDIA
    public static void penalizacionIntermedia() {
        Scanner sc = new Scanner(System.in);
        Random rf = new Random();
        int opp = 1+rf.nextInt((3-1)+1);
        System.out.println("=================================================");
        System.out.println("===     ¡HAS CAIDO EN UNA PENALIZACIÓN!       ===");
        System.out.println("===          MODALIDAD: INTERMEDIA            ===");
        System.out.println("=================================================");
        switch (opp) {
            //CASO PARA RESOLVER EL PROBLEMA INTERMEDIO DE LA OPCION A
            case 1:
                System.out.println("=================================================");
                System.out.println("=== Obten la Suma de las Matrices A y B       ===");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ A                                  ===");
                System.out.println("");
                //SE MUESTRA EN LA PANTALLA LA MATRIZ A
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mai1[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ B                                  ===");
                System.out.println("");
                //SE MUESTRA EN LA PANTALLA LA MATRIZ B
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mbi1[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //SE IMPRIME EN PANTALLA LA FORMA DE INGRESAR LOS DATOS DE LA MATRIZ DEL USUARIO
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("===Ingresar el resultado de la siguiente forma con lo que le piden:===");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("[" + i + "," + j + "]" + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //SE LE SOLICITA AL USUARIO INGRESAR LOS DATOS PARA COLOCARLOS EN LA MATRIZ
                mri1 = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("Ingresar el valor de [" + i + "," + j + "] : ");
                        mri1[i][j] = sc.nextInt();
                    }
                }

                //LE MUESTRA AL USUARIO LA MATRIZ QUE INGRESÓ
                System.out.println("====================================");
                System.out.println("SU MATRIZ ES: ");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri1[i][j] + "\t|");
                    }
                    System.out.println("");
                }

                //EL PROGRAMA REALIZA EL CALCULO DE LA SUMA DE MATRICES
                mri1c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri1c[i][j] = mai1[i][j] + mbi1[i][j];
                    }
                }

                //VERIFICA SI LA MATRIZ INGRESADA POR EL USUARIO ES LA MISMA QUE LA DEL SISTEMA Y SI ES CORRECTO SERA VERDADERO SINO SERA FALSO
                boolean correctoi1 = false;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (mri1[i][j] == mri1c[i][j]) {
                            correctoi1 = true;
                        } else {
                            correctoi1 = false;
                        }
                    }
                }
                if (correctoi1 == true) {
                    System.out.println("");
                    System.out.println("========================");
                    System.out.println("LA RESPUESTA ES CORRECTA");

                } else {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("LA RESPUESTA ES INCORRECTA");
                }

                //MOSTRARA EN PANTALLA LA RESPUESTA CORRECTA DEL SISTEMA
                System.out.println("LA RESPUESTA CORRECTA ES: ");
                System.out.println("");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri1c[i][j] + "\t|");
                    }
                    System.out.println("");
                }
                System.out.println("");
                System.out.println("");
                break;

            //EN ESTE CASO SERA LAS OPERACIONES POR MEDIO DE LA OPCION B
            case 2:
                System.out.println("=================================================");
                System.out.println("=== Obten la Suma de las Matrices A y B       ===");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ A                                  ===");
                System.out.println("");
                //SE PONE EN PANTALLA LA MATRIZ A
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mai2[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ B                                  ===");
                System.out.println("");
                //SE PONE EN PANTALLA LA MATRIZ B
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mbi2[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //SE MOSTRARA EN PANTALLA LA FORMA DE INGRESAR LOS DATOS A LA MATRIZ
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("===Ingresar el resultado de la siguiente forma con lo que le piden:===");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("[" + i + "," + j + "]" + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //LE PEDIRA AL USUARIO INGRESAR LOS VALORES ADENTRO DE LA MATRIZ
                mri2 = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("Ingresar el valor de [" + i + "," + j + "] : ");
                        mri2[i][j] = sc.nextInt();
                    }
                }

                //EN LA PANTALLA SE MOSTRARA LA MATRIZ INGRESADA POR EL USUARIO
                System.out.println("====================================");
                System.out.println("SU MATRIZ ES: ");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri2[i][j] + "\t|");
                    }
                    System.out.println("");
                }

                //EL SISTEMA REALIZA LA OPERACION DE SUMA ENTRE MATRICES
                mri2c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri2c[i][j] = mai2[i][j] + mbi2[i][j];
                    }
                }

                //VERIFICA SI EL RESULTADO DEL USUARIO ES LA MISMA QUE LA DEL SISTEMA
                boolean correctoi2 = false;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (mri2[i][j] == mri2c[i][j]) {
                            correctoi2 = true;
                        } else {
                            correctoi2 = false;
                        }
                    }
                }
                if (correctoi2 == true) {
                    System.out.println("");
                    System.out.println("========================");
                    System.out.println("LA RESPUESTA ES CORRECTA");

                } else {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("LA RESPUESTA ES INCORRECTA");
                }

                //IMPRIME EN PANTALLA LA RESPUESTA CORRECTA
                System.out.println("LA RESPUESTA CORRECTA ES: ");
                System.out.println("");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri2c[i][j] + "\t|");
                    }
                    System.out.println("");
                }
                System.out.println("");
                System.out.println("");
                break;

            //EN ESTE CASO IMPRIMIRA LAS ACCIONES DE LA OPCION C
            case 3:
                System.out.println("=================================================");
                System.out.println("=== Obten la Suma de las Matrices A y B       ===");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ A                                  ===");
                System.out.println("");
                //SE MUESTRA EN PANTALLA LA MATRIZ A
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mai3[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("=== MATRIZ B                                  ===");
                System.out.println("");
                //SE MUESTRA EN PANTALLA LA MATRIZ B
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mbi3[i][j] + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //LE MOSTRARA AL USUARIO COMO INGRESAR LOS DATOS A LA MATRIZ
                System.out.println("");
                System.out.println("=================================================");
                System.out.println("===Ingresar el resultado de la siguiente forma con lo que le piden:===");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("[" + i + "," + j + "]" + "\t|");
                    }
                    System.out.println("\n-----------------------------------------");
                }

                //PEDIRA LOS DATOS AL USUARIO PARA GUARDARLO EN LA MATRIZ
                mri3 = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print("Ingresar el valor de [" + i + "," + j + "] : ");
                        mri3[i][j] = sc.nextInt();
                    }
                }

                //LE MOSTRARÁ AL USUARIO LA MATRIZ A LA CUAL LE INGRESÓ LOS DATOS
                System.out.println("====================================");
                System.out.println("SU MATRIZ ES: ");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri3[i][j] + "\t|");
                    }
                    System.out.println("");
                }

                //EL SISTEMA REALIZA EL CALCULO DE LA SUMATORIA DE MATRICES
                mri3c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri3c[i][j] = mai3[i][j] + mbi3[i][j];
                    }
                }

                //EL SISTEMA VERIFICA SI LA RESPUESTA DEL USUARIO ES LA MISMA A LA DEL SISTEMA
                boolean correctoi3 = false;
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (mri3[i][j] == mri3c[i][j]) {
                            correctoi3 = true;
                        } else {
                            correctoi3 = false;
                        }
                    }
                }
                if (correctoi3 == true) {
                    System.out.println("");
                    System.out.println("========================");
                    System.out.println("LA RESPUESTA ES CORRECTA");

                } else {
                    System.out.println("");
                    System.out.println("==========================");
                    System.out.println("LA RESPUESTA ES INCORRECTA");
                }

                //LE MOSTRARÁ EN PANTALLA LA RESPUESTA CORRECTA
                System.out.println("LA RESPUESTA CORRECTA ES: ");
                System.out.println("");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(mri3c[i][j] + "\t|");
                    }
                    System.out.println("");
                }
                System.out.println("");
                break;
        }

    }
    
    
    //-----------------------------------------PENALIZACIÓN DÍFICIL-------------------------------------
    //METODO PARA EL MENU DE LA PENALIZACION DÍFICIL    
    public static void penalizaciondificil() {
        Random rf = new Random();
        int opc = 1+rf.nextInt((3-1)+1);
        System.out.println("=================================================");
        System.out.println("===     ¡HAS CAIDO EN UNA PENALIZACIÓN!       ===");
        System.out.println("===            MODALIDAD: DÍFCIL              ===");
        System.out.println("=================================================");
        switch (opc) {
            case 1:
                opcionad();
                break;
            case 2:
                opcionbd();
                break;
            case 3:
                opcioncd();
                break;
        }
    }
    
    //METODO PARA LA OPCION A DE LA PENALIZACION DÍFICIL
    public static void opcionad() {
        //MATRICES A Y B DEFINIDAS
        double[][] matriza = {{5, 10, 1, 3}, {9, 14, 2, 6}, {7, 8, 15, 3}, {6, 8, 9, 2}};
        double[][] matrizb = {{5, 13, 9, 4}, {1, 9, 6, 3}, {8, 11, 69, 33}, {25, 6, 7, 4}};
        //MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu = new double[4][4];
        //MATRIZ RESULTADO
        double[][] matrizr = new double[4][4];
        //MATRIZ IDENTIDAD E INVERSA
        double[][] matrizi = new double[4][4];
        double pivote, extremos;
        Scanner leer = new Scanner(System.in);

        //MOSTRANDO LA INFORMACION EN LA PANTALLA PARA EL USUARIO
        System.out.println("=================================================");
        System.out.println("===  Obten la División de las Matrices A y B  ===");
        System.out.println("===                 (A/B)                     ===");
        System.out.println("=== ¿Cómo se calcula?                         ===");
        System.out.println("=== La división de dos matrices es la         ===");
        System.out.println("=== multiplicación de una matriz por la matriz===");
        System.out.println("=== inversa de la matriz divisora             ===");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ A                                  ===");
        System.out.println("");
        //SE MUESTRA EN PANTALLA LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriza[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ B                                  ===");
        System.out.println("");
        //SE MUESTRA EN PANTALLA LA MATRIZ B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //INSTRUCCIONES PARA LA FORMA DE INGRESAR LOS DATOS DEL USUARIO
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("===Ingresa los valores de tu respuesta con lo ===");
        System.out.println("===que corresponde en lo que se muestra en    ===");
        System.out.println("===pantalla APROX A TRES DECIMALES Y CON SIGNO:==");
        System.out.println("=================================================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + i + "," + j + "]" + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //SOLICITA LOS DATOS AL USUARIO Y LOS INGRESA A LA MATRIZ
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese el valor de la casilla [" + i + "," + j + "]: ");
                matriziu[i][j] = leer.nextDouble();
            }
        }
        
        //MUESTRA LA MATRIZ INGRESADA POR EL USUARIO
        System.out.println("USTED INGRESÓ ESTA MATRIZ:");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriziu[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }

        //---------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA---------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizi[i][j] = 1;
                } else {
                    matrizi[i][j] = 0;
                }
            }
        }

        //SE DEJA COMENTADO COMO ESTAN LAS MATRICES POR EL MOMENTO PARA LOS REPORTES
        /*
        //MUESTRA EL PANTALLA LA METRIZ B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
        }
        //MUESTRA EN PANTALLA LA MATRIZ IDENTIDAD
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] + "\t|");
            }
            System.out.println("");
        }
         */
        
        //SE APLICA GAUUS JORDAN PARA ENCONTRAR LA MATRIZ INVERSA DE B
        for (int i = 0; i < 4; i++) {
            //PASO 1: IDENTIFICAR CUAL ES EL PIVOTE
            pivote = matrizb[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizb[i][j] = matrizb[i][j] / pivote;
                matrizi[i][j] = matrizi[i][j] / pivote;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizb[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizb[k][j] = matrizb[k][j] - extremos * matrizb[i][j];
                        matrizi[k][j] = matrizi[k][j] - extremos * matrizi[i][j];
                    }

                }
            }
        }
        
        //PARA LOS REPORTES
        /*        
        //IMPRIMIR LA MATRIZ INVERSA
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] +"\t|");
            }
            System.out.println("");
        }
        */
        
        //MULTIPLICACION DE LA MATRIZ INVERSA DE B CON LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    matrizr[i][j] += matriza[i][k] * matrizi[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        System.out.println("");
        
        //COMPARA SI LA MATRIZ HECHA POR EL SISTEMA ES IGUAL A LA MATRIZ INGRESADA POR EL USUARIO
        boolean correcto = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((Math.round(matrizr[i][j] * 1000.0) / 1000.0) == matriziu[i][j]) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            }
        }
        if (correcto == true) {
            System.out.println("========================");
            System.out.println("SU RESPUESTA ES CORRECTA");
        } else {
            System.out.println("==========================");
            System.out.println("SU RESPUESTA ES INCORRECTA");
        }
        System.out.println("");
    }
    
    //METODO PARA LA OPCION B DE LA PENALIZACION DÍFICIL  
    public static void opcionbd() {
        //DEFINIENDO LA MATRIZ A
        double[][] matriza = {{1, 12, 9, 8}, {7, 6, 3, 2}, {0, 5, 6, 14}, {6, 9, 6, 10}};
        //DEFINIENDO LA MATRIZ B
        double[][] matrizb = {{8, 19, 20, 4}, {12, 33, 6, 8}, {4, 5, 9, 7}, {8, 22, 14, 6}};
        //MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu = new double[4][4];
        //MATRIZ DE RESULTADO ( POR EL SISTEMA)
        double[][] matrizr = new double[4][4];
        //MATRIZ IDENTIDAD E INVERSA
        double[][] matrizi = new double[4][4];
        double pivote, extremos;
        Scanner leer = new Scanner(System.in);

        //MOSTRANDO LA INFORMACION EN LA PANTALLA PARA EL USUARIO
        System.out.println("=================================================");
        System.out.println("===  Obten la División de las Matrices A y B  ===");
        System.out.println("===                 (A/B)                     ===");
        System.out.println("=== ¿Cómo se calcula?                         ===");
        System.out.println("=== La división de dos matrices es la         ===");
        System.out.println("=== multiplicación de una matriz por la matriz===");
        System.out.println("=== inversa de la matriz divisora             ===");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ A                                  ===");
        System.out.println("");
        //SE MUESTRA EN PANTALLA LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriza[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        //SE MUESTRA EN PANTALLA LA MATRIZ B
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ B                                  ===");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        
        //DA LAS INSTRUCCIONES DE COMO INGRESAR LOS VALORES DE LA MATRIZ
        System.out.println("=================================================");
        System.out.println("===Ingresa los valores de tu respuesta con lo ===");
        System.out.println("===que corresponde en lo que se muestra en    ===");
        System.out.println("===pantalla APROX A TRES DECIMALES Y CON SIGNO:==");
        System.out.println("=================================================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + i + "," + j + "]" + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //EL USUARIO INGRESA LOS VALORES DE SU RESPUESTA
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese el valor de la casilla [" + i + "," + j + "]: ");
                matriziu[i][j] = leer.nextDouble();
            }
        }
        
        //MUESTRA EN PANTALLA LA MATRIZ INGRESADA POR EL USUARIO
        System.out.println("USTED INGRESÓ ESTA MATRIZ:");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriziu[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }

        //----------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA----------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizi[i][j] = 1;
                } else {
                    matrizi[i][j] = 0;
                }
            }
        }

        //SE DEJA COMENTADO COMO ESTAN LAS MATRICES PARA LOS REPORTES
        /*
        //MUESTRA EL PANTALLA LA MATRIZ B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
        }
        //MUESTRA EN PANTALLA LA MATRIZ IDENTIDAD
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] + "\t|");
            }
            System.out.println("");
        }
         */
        
        //REALIZA LA OPERACIÓN DE GAUSS JORDAN PARA ENCONTRAR LA MATRIZ IDENTIDAD
        for (int i = 0; i < 4; i++) {
            //PASO 1: IDENTIFICAR CUAL ES EL PIVOTE
            pivote = matrizb[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizb[i][j] = matrizb[i][j] / pivote;
                matrizi[i][j] = matrizi[i][j] / pivote;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizb[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizb[k][j] = matrizb[k][j] - extremos * matrizb[i][j];
                        matrizi[k][j] = matrizi[k][j] - extremos * matrizi[i][j];
                    }

                }
            }
        }

        /*
        
        //IMPRIMIR LA MATRIZ INVERSA
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] +"\t|");
            }
            System.out.println("");
        }
         */
        
        
        //MULTIPLICACION DE LA MATRIZ INVERSA CON LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    matrizr[i][j] += matriza[i][k] * matrizi[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        
        //VERIFICA SI LA MATRIZ INGRESADA POR EL USUARIO ES LA MISMA A LA DEL RESULTADO DEL SISTEMA
        boolean correcto = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((Math.round(matrizr[i][j] * 1000.0) / 1000.0) == matriziu[i][j]) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            }
        }
        if (correcto == true) {
            System.out.println("========================");
            System.out.println("SU RESPUESTA ES CORRECTA");
        } else {
            System.out.println("==========================");
            System.out.println("SU RESPUESTA ES INCORRECTA");
        }
        System.out.println("");
    }

    //METODO PARA LA OPCION C DE LA PENALIZACION DÍFICIL
    public static void opcioncd() {
        //SE DEFINE LA MATRIZ A Y B
        double[][] matriza = {{5, 9, 14, 5}, {6, 0, 5, 3}, {1, 14, 68, 8}, {7, 5, 3, 9}};
        double[][] matrizb = {{0, 9, 7, 19}, {2, 30, 5, 48}, {1, 31, 2, 5}, {15, 8, 4, 3}};
        //SE CREA LA MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu = new double[4][4];
        //SE CREA LA MATRIZ RESULTADO
        double[][] matrizr = new double[4][4];
        //SE CREA LA MATRIZ IDENTIDAD E INVERSA
        double[][] matrizi = new double[4][4];
        double pivote, extremos;
        Scanner leer = new Scanner(System.in);

        //MOSTRANDO LA INFORMACION EN LA PANTALLA PARA EL USUARIO
        System.out.println("=================================================");
        System.out.println("===  Obten la División de las Matrices A y B  ===");
        System.out.println("===                 (A/B)                     ===");
        System.out.println("=== ¿Cómo se calcula?                         ===");
        System.out.println("=== La división de dos matrices es la         ===");
        System.out.println("=== multiplicación de una matriz por la matriz===");
        System.out.println("=== inversa de la matriz divisora             ===");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ A                                  ===");
        System.out.println("");
        //SE MUESTRA LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriza[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //SE MUESTRA LA MATRIZ B
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("=== MATRIZ B                                  ===");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //SE DAN LAS INSTRUCCIONES PARA QUE EL USUARIO INGRESE SUS RESPUESTAS
        System.out.println("");
        System.out.println("=================================================");
        System.out.println("===Ingresa los valores de tu respuesta con lo ===");
        System.out.println("===que corresponde en lo que se muestra en    ===");
        System.out.println("===pantalla APROX A TRES DECIMALES Y CON SIGNO:==");
        System.out.println("=================================================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("[" + i + "," + j + "]" + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //EL SISTEMA LE PEDIRA AL USUARIO INGRESAR LOS VALORES DE SU MATRIZ
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("Ingrese el valor de la casilla [" + i + "," + j + "]: ");
                matriziu[i][j] = leer.nextDouble();
            }
        }
        
        //MOSTRARA LA MATRIZ INGRESADA POR EL USUARIO
        System.out.println("USTED INGRESÓ ESTA MATRIZ:");
        System.out.println("");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matriziu[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }

        //----------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA----------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizi[i][j] = 1;
                } else {
                    matrizi[i][j] = 0;
                }
            }
        }

        //SE DEJA COMENTADO COMO ESTAN LAS MATRICES PARA LOS REPORTES
        /*
        //MUESTRA EL PANTALLA LA MATRIZ B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
        }
        //MUESTRA EN PANTALLA LA MATRIZ IDENTIDAD
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] + "\t|");
            }
            System.out.println("");
        }
         */
        /*
        
        System.out.println("ANTES DEL CAMBIO DE FILAS");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j != matrizb[0].length; ++j) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
        }
         */
 
        //CAMBIA LA FILA 1 Y 2 DE LA MATRIZ B Y LA MATRIZ IDENTIDAD
        double aux;
        for (int j = 0; j < 4; j++) {
            aux = matrizb[0][j];
            matrizb[0][j] = matrizb[1][j];
            matrizb[1][j] = aux;
        }
        
        for (int j = 0; j < 4; j++) {
            aux = matrizi[0][j];
            matrizi[0][j] = matrizi[1][j];
            matrizi[1][j] = aux;
        }
        /*
        System.out.println("DESPUES DEL CAMBIO DE FILAS");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j != matrizb[0].length; ++j) {
                System.out.print(matrizb[i][j] + "\t|");
            }
            System.out.println("");
        }
         */
        
        //HACE EL PROCEDIMIENTO PARA APLICAR GAUSS JORDAN
        for (int i = 0; i < 4; i++) {
            //PASO 1: IDENTIFICAR CUAL ES EL PIVOTE
            pivote = matrizb[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizb[i][j] = matrizb[i][j] / pivote;
                matrizi[i][j] = matrizi[i][j] / pivote;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizb[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizb[k][j] = matrizb[k][j] - extremos * matrizb[i][j];
                        matrizi[k][j] = matrizi[k][j] - extremos * matrizi[i][j];
                    }

                }
            }
        }

        /*
        //IMPRIMIR LA MATRIZ INVERSA
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(matrizi[i][j] + "\t|");
            }
            System.out.println("");
        }
        */
        
        //MULTIPLICACION DE LA MATRIZ INVERSA CON LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    matrizr[i][j] += matriza[i][k] * matrizi[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        
        //SE COMPARA SI LA MATRIZ INGRESADA POR EL USUARIO ES LA MISMA QUE LA MATRIZ RESULTADO
        boolean correcto = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((Math.round(matrizr[i][j] * 1000.0) / 1000.0) == matriziu[i][j]) {
                    correcto = true;
                } else {
                    correcto = false;
                }
            }
        }
        if (correcto == true) {
            System.out.println("========================");
            System.out.println("SU RESPUESTA ES CORRECTA");
        } else {
            System.out.println("==========================");
            System.out.println("SU RESPUESTA ES INCORRECTA");
        }
        System.out.println("");
        System.out.println("");
    }

}
