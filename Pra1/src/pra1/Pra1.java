package pra1;
//IMPORTAR LAS LIBRERIAS CORRESPONDIENTES
import java.util.Random;
import java.util.Scanner;
import java.io.*;

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
    //Variables para reportar y se manda a llamar la clase reportaje
    StringBuilder lapiz = new StringBuilder();
    Reportaje report = new Reportaje();
    FileWriter fichero;
    PrintWriter pw;
    
    public void bitacora(int pos, int dado){
        fichero = null;
        pw = null;
        try {
            fichero = new FileWriter("Bitacora.html");
            pw = new PrintWriter(fichero);
            pw.println("<!doctype html>\n" +
"<html lang=\"en\">\n" +
"  <head>\n" +
"    <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
"  <title>Reporte 2 - Bitacora </title>\n" +
"  </head>\n" +
"  \n" +
"  <body class=\"bg-warning text-white\">\n" +
"    <div class=\"container-xl mt-6 border bg-dark text-white\">\n" +
"        <h1 ><center>Reporte 2</center></h1>\n" +
"    </div>\n" +
"    <h1 class = \"text-dark\"><center>Bitácora</center></h1>\n"
                    + "<div class=\"container-xl mt-6 border bg-primary text-white\">\n" +
"        <h5> 0. Inicia la aplicacion</h5>");
            for (int i = 1; i < pos; i++) {
                pw.println("<h5>" + i + ". Ficha en la posicion " + i);
                pw.println("<h5> Dado: " + dado + "</h5>");
            }
            pw.println("<h5>65. Fin del juego </h5>");
            finbitacora();
            System.out.println("Bitacora fue creada con exito");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    //Metodo para la parte inicial del documento de reportaje
    public void inicior1(){
        lapiz.append("<!doctype html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"utf-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
"    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
"    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
"    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\n" +
"    <title>Reporte1</title>\n" +
"</head>\n" +
"\n" +
"<body class=\"bg-success\">\n" +
"    <div class=\"container-xl mt-6 border bg-dark text-white\">\n" +
"        <h1>\n" +
"            <center>Reporte 1</center>\n" +
"        </h1>\n" +
"    </div>\n" +
"    <div class=\"container-xl mt-6 border bg-warning\">\n" +
"        <h1>\n" +
"            <center>Operaciones en el juego</center>\n" +
"        </h1>\n" +
"    </div>\n" +
"    <div class=\"container-xl mt-6 border bg-primary text-white\">");
    }
    
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
                        r1();
                        break;
                    //OPCION SALIR
                    case 4:
                        System.out.println("============================================");
                        System.out.println("==         Adiós, vuelve pronto :3        ==");
                        break;
                    //SI NINGUNA DE LAS ANTERIORES SE CUMPLE ENTONCES MOSTRARA UN MENSAJE DE ERROR
                    default:
                        System.out.println("INGRESA LA OPCIÓN CORRECTA");
                        emenu1();
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
    public void emenu1(){
        lapiz.append("<div class=\"container p-3 my-3 bg-danger text-white\">\n" +
"        <h4>\n" +
"            <center>Ha ingresado una opcion incorrecta</center>\n" +
"        </h4>\n" +
"    </div>");
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
        int o = 0;
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
            try{
            
            //MENU PARA DAR INSTRUCCIONES DEL JUEGO
            System.out.println("¿Que quiere hacer?");
            System.out.println("1. Tirar el dado");
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
                bitacora(base, d);
                
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
            }catch(Exception e){
                leer.nextLine();
                System.out.println("INGRESE SOLO ENTEROS");
            }            
        } while (o == 1 || o !=1);        
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
        int a1 = 15;
        double b1, beta1,gama1;
        int c1 = 20;
        int alpha1 = 25;
    public void opcionaf(){
        double lbi1, ancybi, anaybi;
        Scanner sc = new Scanner(System.in);        
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado A = 15                                                ===");
        System.out.println("===Lado C = 20                                                ===");
        System.out.println("===Ángulo entre A y C = 25°                                   ===");
        System.out.println("=================================================================");
        //LA PROGRAMACIÓN DEL CALCULO HECHO EN EL PROGRAMA PARA LA RESPUESTA CORRECTA
        b1 = Math.sqrt(((a1*a1)+(c1*c1)-2*a1*c1*(Math.cos(Math.toRadians(alpha1)))));
        beta1 = Math.toDegrees(Math.acos(((b1*b1)-(a1*a1)+(c1*c1))/(2*b1*c1)));
        gama1 = Math.toDegrees(Math.acos(((b1*b1)+(a1*a1)-(c1*c1))/(2*b1*a1)));
            System.out.println("    LADO B: " + (Math.round(b1*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta1*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama1*1000.0)/1000.0)));
            System.out.println("");
    }
    
    //METODO PARA REPORTAR LA PENALIZACION A
    public void repoopaaf(){
        lapiz.append("<h2>Penalización Fácil</h2>\n" +
"        <p class=\"text-body\">Aplicar Ley de Cosenos utilizando los valores dados:</p>\n" +
"        <h5 class=\"text-body\">Datos:</h5>\n" +
"        <p></p>\n" +
"        <img src=\"triangulo.png\" class=\"mx-auto d-block\">\n" +
"        <p></p>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado A</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \"> " + a1 + "</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado C</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \"> " + c1 +"</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Ángulo &alpha;</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">" + alpha1 +"</div>\n" +
"        </div>\n" +
"        <p></p>\n" +
"        <h5>\n" +
"            <center>\n" +
"                <dl> ¿Cómo se resuelve?</dl>\n" +
"            </center>\n" +
"        </h5>\n" +
"\n" +
"        <p>1. Obteniendo la formula de ley de cosenos:</p>\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl>Lado B: </dl>\n" +
"        </h4>\n" +
"        <h3>\n" +
"            <center>b&sup2; = a&sup2; + c&sup2; - 2ac <i>cos</i>&alpha; </center>\n" +
"        </h3>\n" +
"        <p></p>\n" +
"        <p>2. Despejada para encontrar \"b\" quedaría así: </p>\n" +
"        <h3></h3>\n" +
"        <h3>\n" +
"            <center>b = &#8730;( a&sup2; + c&sup2; - 2ac <i>cos</i>&alpha;) </center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo datos sería:</p>\n" +
"        <h3>\n" +
"            <center>b = &#8730;( (" + a1 +")&sup2; + (" + c1 +")&sup2; - 2*" + a1 +"*"+ c1 +"* <i>cos</i>(" + alpha1 +")) </center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del lado \"b\" es:</p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center>b = " + (Math.round(b1*1000.0)/1000.0) +" </center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &beta;: </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &beta;:</p>\n" +
"        <h3>\n" +
"            <center>a&sup2; = b&sup2; + c&sup2; - 2bc <i>cos</i>&beta; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&beta;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &beta; = <i>arccos</i> (<sup>(b&sup2; + c&sup2; - a&sup2;)</sup>/<sub>2bc</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &beta; = <i>arccos</i> (<sup>((" + (Math.round(b1*1000.0)/1000.0) +")&sup2; + (" + c1 +")&sup2; - (" + a1 +")&sup2;)</sup>/<sub>2(" + (Math.round(b1*1000.0)/1000.0) +")(" + c1 +")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&beta;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &beta; = " + (Math.round(beta1*1000.0)/1000.0) +"°</center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &gamma; : </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &gamma; :</p>\n" +
"        <h3>\n" +
"            <center>c&sup2; = a&sup2; + b&sup2; - 2ab <i>cos</i>&gamma; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&gamma;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &gamma; = <i>arccos</i> (<sup>(a&sup2; + b&sup2; - c&sup2;)</sup>/<sub>2ab</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &gamma; = <i>arccos</i> (<sup>((" + a1 +")&sup2; + (" + (Math.round(b1*1000.0)/1000.0) +")&sup2; - (" + c1 +")&sup2;)</sup>/<sub>2(" + a1 +")(" + (Math.round(b1*1000.0)/1000.0) +")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&gamma;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &gamma; = " + (Math.round(gama1*1000.0)/1000.0) +"°</center>\n" +
"        </h3>");
    }
    
    //METODO PARA LA OPCION B DE LA PENALIZACION FACIL
        int b2 = 10;
        double a2, alpha2,gama2;
        int c2 = 25;
        int beta2 = 30;
    public void opcionbf(){
        Scanner sc = new Scanner(System.in);
        double lai2, ancyai, anaybi;
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado B = 10                                                ===");
        System.out.println("===Lado C = 25                                                ===");
        System.out.println("===Ángulo entre B y C = 30°                                   ===");
        System.out.println("=================================================================");    
        
        //SE REALIZA LA PROGRAMACIÓN PARA ENCONTRAR LA RESPUESTA CORRECTA
        a2 = Math.sqrt(((b2*b2)+(c2*c2)-2*b2*c2*(Math.cos(Math.toRadians(beta2)))));
        alpha2 = Math.toDegrees(Math.acos(((a2*a2)-(b2*b2)+(c2*c2))/(2*a2*c2)));
        gama2 = Math.toDegrees(Math.acos(((b2*b2)+(a2*a2)-(c2*c2))/(2*b2*a2)));
            System.out.println("LA RESPUESTA DEL SISTEMA: ");
            System.out.println("    LADO A: " + (Math.round(a2*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha2*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE A Y B: " + ((Math.round(gama2*1000.0)/1000.0)));
            System.out.println("");
    }
    
    public void repoopbbf(){
        lapiz.append("<h2>Penalización Fácil</h2>\n" +
"        <p class=\"text-body\">Aplicar Ley de Cosenos utilizando los valores dados:</p>\n" +
"        <h5 class=\"text-body\">Datos:</h5>\n" +
"        <p></p>\n" +
"        <img src=\"triangulo.png\" class=\"mx-auto d-block\">\n" +
"        <p></p>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado B</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">"+ b2 +"</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado C</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">"+ c2 +"</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Ángulo &beta;</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">"+ beta2 +"</div>\n" +
"        </div>\n" +
"        <p></p>\n" +
"        <p>1. Obteniendo la formula de ley de cosenos:</p>\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl>Lado A: </dl>\n" +
"        </h4>\n" +
"        <h3>\n" +
"            <center>a&sup2; = b&sup2; + c&sup2; - 2bc <i>cos</i>&beta; </center>\n" +
"        </h3>\n" +
"        <p></p>\n" +
"        <p>2. Despejada para encontrar \"a\" quedaría así: </p>\n" +
"        <h3></h3>\n" +
"        <h3>\n" +
"            <center>a = &#8730;( b&sup2; + c&sup2; - 2bc <i>cos</i>&beta;) </center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo datos sería:</p>\n" +
"        <h3>\n" +
"            <center>a = &#8730;( ("+ b2 +")&sup2; + ("+ c2 +")&sup2; - 2("+ b2 +")("+ c2 +") <i>cos</i>("+ beta2 +")) </center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del lado \"a\" es:</p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center>a = "+ (Math.round(a2*1000.0)/1000.0) +" </center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &alpha; : </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &alpha; :</p>\n" +
"        <h3>\n" +
"            <center>b&sup2; = a&sup2; + c&sup2; - 2ac <i>cos</i>&alpha; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&alpha;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &alpha; = <i>arccos</i> (<sup>(a&sup2; + c&sup2; - b&sup2;)</sup>/<sub>2ac</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &alpha; = <i>arccos</i> (<sup>(("+ (Math.round(a2*1000.0)/1000.0) +")&sup2; + ("+ c2 +")&sup2; - ("+ b2 +")&sup2;)</sup>/<sub>2("+ (Math.round(a2*1000.0)/1000.0) +")("+ c2 +")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&alpha;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &alpha; = "+ (Math.round(alpha2*1000.0)/1000.0) +"°</center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &gamma; : </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &gamma; :</p>\n" +
"        <h3>\n" +
"            <center>c&sup2; = a&sup2; + b&sup2; - 2ab <i>cos</i>&gamma; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&gamma;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &gamma; = <i>arccos</i> (<sup>(a&sup2; + b&sup2; - c&sup2;)</sup>/<sub>2ab</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &gamma; = <i>arccos</i> (<sup>(("+ (Math.round(a2*1000.0)/1000.0) +")&sup2; + ("+ b2 +")&sup2; - ("+ c2 +")&sup2;)</sup>/<sub>2("+ (Math.round(a2*1000.0)/1000.0) +")("+ b2 +")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&gamma;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &gamma; = "+ (Math.round(gama2*1000.0)/1000.0) +"°</center>\n" +
"        </h3>");
    }
    
    //METODO PARA LA OPCION C DE LA PENALIZACION FACIL
        int a3 = 18;
        double c3, alpha3,beta3;
        int b3 = 25;
        int gama3 = 30;
    public void opcioncf(){
        Scanner sc = new Scanner(System.in);
        double lci3, ancyai, ancybi;        
        System.out.println("=================================================================");
        System.out.println("===                       LEY DE COSENOS                      ===");
        System.out.println("=================================================================");
        System.out.println("===Se le presentan los valores dados de un triangulo oblicuo: ===");
        System.out.println("===Lado A = 18                                                ===");
        System.out.println("===Lado B = 25                                                ===");
        System.out.println("===Ángulo entre A y B = 30°                                   ===");
        System.out.println("=================================================================");     
        
        //SE PROGRAMA PARA QUE EL PROGRAMA ENCUENTRE LA RESPUESTA CORRECTA
        c3 = Math.sqrt(((b3*b3)+(a3*a3)-2*b3*a3*(Math.cos(Math.toRadians(gama3)))));
        alpha3 = Math.toDegrees(Math.acos(((a3*a3)-(b3*b3)+(c3*c3))/(2*a3*c3)));
        beta3 = Math.toDegrees(Math.acos(((b3*b3)-(a3*a3)+(c3*c3))/(2*b3*c3)));
            System.out.println("LA RESPUESTA DEL SISTEMA: ");
            System.out.println("    LADO B: " + (Math.round(c3*1000.0)/1000.0));
            System.out.println("    ANGULO ENTRE A Y C: " + ((Math.round(alpha3*1000.0)/1000.0)));
            System.out.println("    ANGULO ENTRE B Y C: " + ((Math.round(beta3*1000.0)/1000.0)));
            System.out.println("");
    }
    
    //REPORTE DE LA OPCION C
    public void repoopccf(){
        lapiz.append("<h2>Penalización Fácil</h2>\n" +
"        <p class=\"text-body\">Aplicar Ley de Cosenos utilizando los valores dados:</p>\n" +
"        <h5 class=\"text-body\">Datos:</h5>\n" +
"        <p></p>\n" +
"        <img src=\"triangulo.png\" class=\"mx-auto d-block\">\n" +
"        <p></p>\n" +
"        <div class=\"row\">\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado A</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">" + a3 + "</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Lado B</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">" + b3 + "</div>\n" +
"            <div class=\"col-sm-4\" style=\"background-color:blueviolet;\">Ángulo &gamma;</div>\n" +
"            <div class=\"col-sm-8 text-body\" style=\"background-color:grey; \">" + gama3 + "</div>\n" +
"        </div>\n" +
"        <p></p>\n" +
"        <p>1. Obteniendo la formula de ley de cosenos:</p>\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl>Lado C: </dl>\n" +
"        </h4>\n" +
"        <h3>\n" +
"            <center>c&sup2; = a&sup2; + b&sup2; - 2ab <i>cos</i>&gamma; </center>\n" +
"        </h3>\n" +
"        <p></p>\n" +
"        <p>2. Despejada para encontrar \"c\" quedaría así: </p>\n" +
"        <h3></h3>\n" +
"        <h3>\n" +
"            <center>c = &#8730;( a&sup2; + b&sup2; - 2ab <i>cos</i>&gamma;) </center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo datos sería:</p>\n" +
"        <h3>\n" +
"            <center>c = &#8730;( (" + a3 + ")&sup2; + (" + b3 + ")&sup2; - 2(" + a3 + ")(" + b3 + ") <i>cos</i>(" + gama3 + ");) </center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del lado \"c\" es:</p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center>c = " + (Math.round(c3*1000.0)/1000.0) + " </center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &alpha; : </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &alpha; :</p>\n" +
"        <h3>\n" +
"            <center>b&sup2; = a&sup2; + c&sup2; - 2ac <i>cos</i>&alpha; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&alpha;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &alpha; = <i>arccos</i> (<sup>(a&sup2; + c&sup2; - b&sup2;)</sup>/<sub>2ac</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &alpha; = <i>arccos</i> (<sup>((" + a3 + ")&sup2; + (" + (Math.round(c3*1000.0)/1000.0) + ")&sup2; - (" + b3 + ")&sup2;)</sup>/<sub>2(" + a3 + ")(" + (Math.round(c3*1000.0)/1000.0) + ")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&alpha;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &alpha; =" + (Math.round(alpha3*1000.0)/1000.0) + "°</center>\n" +
"        </h3>\n" +
"\n" +
"        <h4 class=\"text-danger\">\n" +
"            <dl> Ángulo &beta;: </dl>\n" +
"        </h4>\n" +
"        <p>1. Se obtiene la formula que contenga &beta;:</p>\n" +
"        <h3>\n" +
"            <center>a&sup2; = b&sup2; + c&sup2; - 2bc <i>cos</i>&beta; </center>\n" +
"        </h3>\n" +
"        <p>2. Despejada para encontrar \"&beta;\" quedaría asi: </p>\n" +
"        <h3>\n" +
"            <center> &beta; = <i>arccos</i> (<sup>(b&sup2; + c&sup2; - a&sup2;)</sup>/<sub>2bc</sub>)</center>\n" +
"        </h3>\n" +
"        <p>3. Sustituyendo los valores quedaria asi: </p>\n" +
"        <h3>\n" +
"            <center> &beta; = <i>arccos</i> (<sup>((" + b3 + ")&sup2; + (" + (Math.round(c3*1000.0)/1000.0) + ")&sup2; - " + a3 + "&sup2;)</sup>/<sub>2(" + b3 + ")(" + (Math.round(c3*1000.0)/1000.0) + ")</sub>)</center>\n" +
"        </h3>\n" +
"        <p>4. El resultado del ángulo \"&beta;\" es: </p>\n" +
"        <h3 class=\"text-body\">\n" +
"            <center> &beta; = " + (Math.round(beta3*1000.0)/1000.0) + " °</center>\n" +
"        </h3>\n     +"
        + "<p></p>\n" +
"        <p></p>");
    }
    
    
    //-----------------------------------------PENALIZACIÓN INTERMEDIA-------------------------------------
    
    //------------------OPCION A---------------
    //MATRIZ A
    int[][] mai1 = {{7,48,5,0,1},{57,8,4,6,14},{0,5,6,78,15},{21,14,8,19,54},{32,20,26,47,12}};
    //MATRIZ B
    int[][] mbi1 = {{9,5,2,1,8},{4,2,3,47,8},{48,55,32,19,6},{7,56,32,14,8},{32,87,0,1,7}};
    //MATRIZ INGRESADO Y RESULTADO
    int[][] mri1, mri1c;
    
    //------------------OPCION B---------------
    //MATRIZ A
    int[][] mai2 = {{4,9,7,45,18},{7,51,26,8,38},{48,26,37,21,19},{1,0,6,8,1},{2,19,55,25,15}};
    //MATRIZ B
    int[][] mbi2 = {{0,2,15,1,66},{21,48,62,7,33},{4,88,0,68,4},{25,18,24,7,55},{24,15,36,5,98}};
    //MATRIZ INGRESADO Y RESULTADO
    int[][] mri2, mri2c;
    
    //------------------OPCION C---------------
    //MATRIZ A
    int[][] mai3 = {{0,1,15,5,36},{1,78,65,32,4},{48,66,39,0,55},{14,98,63,20,15},{11,39,84,7,1}};
    //MATRIZ B
    int[][] mbi3 = {{78,25,66,48,98},{0,45,2,3,1},{2,9,14,10,20},{35,87,65,2,32},{25,8,4,9,39}};
    //MATRIZ INGRESADO Y RESULTADO
    int[][] mri3, mri3c;
   
    //METODO PARA EL MENU DE LA PENALIZACION INTERMEDIA
    public void penalizacionIntermedia() {
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
                //EL PROGRAMA REALIZA EL CALCULO DE LA SUMA DE MATRICES
                mri1c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri1c[i][j] = mai1[i][j] + mbi1[i][j];
                    }
                }

                //MOSTRARA EN PANTALLA LA RESPUESTA CORRECTA DEL SISTEMA
                System.out.println("LA RESPUESTA DEL SISTEMA ES: ");
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

                //EL SISTEMA REALIZA LA OPERACION DE SUMA ENTRE MATRICES
                mri2c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri2c[i][j] = mai2[i][j] + mbi2[i][j];
                    }
                }
                //IMPRIME EN PANTALLA LA RESPUESTA CORRECTA
                System.out.println("LA RESPUESTA DEL SISTEMA ES: ");
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
                
                //EL SISTEMA REALIZA EL CALCULO DE LA SUMATORIA DE MATRICES
                mri3c = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        mri3c[i][j] = mai3[i][j] + mbi3[i][j];
                    }
                }
                //LE MOSTRARÁ EN PANTALLA LA RESPUESTA CORRECTA
                System.out.println("LA RESPUESTA DEL SISTEMA ES: ");
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
    
    //REPORTE DE LA OPCION A DE PENALIZACION INTERMEDIA
    public void piar1(){
        lapiz.append("<h2>Penalización Intermedia</h2>\n" +
"        <p class=\"text-body\">Se obtienen las siguientes matrices y tiene que hacer la siguiente operación: </p>\n" +
"        <h6 class=\"text-body\">\n" +
"            <center>A + B</center>\n" +
"        </h6>\n" +
"        <p class=\"text-body\">1. Se obtienen los siguientes datos</p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mai1[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mbi1[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>2. Se procede a hacer los cálculos de esta manera </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t A[" + i + "," + j + "] + B [" + i + "," + j + "]" +"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>3. Asi se veria la matriz con los valores de la Matriz A y B </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mai1[i][j] + " + " + mbi1[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>4. El resultado de la matriz resultado es: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A+B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mri1c[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
    }
    
    //REPORTE DE LA PENALIZACION B DE PENALIZACION INTERMEDIA
        public void pibr1(){
        lapiz.append("<h2>Penalización Intermedia</h2>\n" +
"        <p class=\"text-body\">Se obtienen las siguientes matrices y tiene que hacer la siguiente operación: </p>\n" +
"        <h6 class=\"text-body\">\n" +
"            <center>A + B</center>\n" +
"        </h6>\n" +
"        <p class=\"text-body\">1. Se obtienen los siguientes datos</p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mai2[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mbi2[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>2. Se procede a hacer los cálculos de esta manera </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t A[" + i + "," + j + "] + B [" + i + "," + j + "]" +"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>3. Asi se veria la matriz con los valores de la Matriz A y B </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mai2[i][j] + " + " + mbi2[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>4. El resultado de la matriz resultado es: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A+B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mri2c[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
    }
        
        //REPORTE DE LA OPCION C DE LA PENALIZACION INTERMEDIA
        public void picr1(){
        lapiz.append("<h2>Penalización Intermedia</h2>\n" +
"        <p class=\"text-body\">Se obtienen las siguientes matrices y tiene que hacer la siguiente operación: </p>\n" +
"        <h6 class=\"text-body\">\n" +
"            <center>A + B</center>\n" +
"        </h6>\n" +
"        <p class=\"text-body\">1. Se obtienen los siguientes datos</p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mai3[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t"+mbi3[i][j]+"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>2. Se procede a hacer los cálculos de esta manera </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t A[" + i + "," + j + "] + B [" + i + "," + j + "]" +"\n");
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>3. Asi se veria la matriz con los valores de la Matriz A y B </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz Resultado</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mai3[i][j] + " + " + mbi3[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p>4. El resultado de la matriz resultado es: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A+B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 5; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 5; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + mri3c[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>\n");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
    }
    
    //-----------------------------------------PENALIZACIÓN DÍFICIL-------------------------------------
    //METODO PARA EL MENU DE LA PENALIZACION DÍFICIL    
    public void penalizaciondificil() {
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
        //MATRICES A Y B DEFINIDAS
        double[][] matriza1 = {{5, 10, 1, 3}, {9, 14, 2, 6}, {7, 8, 15, 3}, {6, 8, 9, 2}};
        double[][] matrizbp1 = {{5, 13, 9, 4}, {1, 9, 6, 3}, {8, 11, 69, 33}, {25, 6, 7, 4}};
        //MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu1 = new double[4][4];
        //MATRIZ RESULTADO
        double[][] matrizr1 = new double[4][4];
        //MATRIZ IDENTIDAD E INVERSA
        double[][] matrizin1 = new double[4][4];
        double[][] inversa1 = new double[4][4];
        double pivote1;
    double[][] matrizb1 = {{5, 13, 9, 4}, {1, 9, 6, 3}, {8, 11, 69, 33}, {25, 6, 7, 4}};
    public void opcionad() {    
        double extremos;
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
                System.out.print(matriza1[i][j] + "\t|");
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
                System.out.print(matrizb1[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        //---------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA---------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizin1[i][j] = 1;
                } else {
                    matrizin1[i][j] = 0;
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
            pivote1 = matrizb1[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizb1[i][j] = matrizb1[i][j] / pivote1;
                matrizin1[i][j] = matrizin1[i][j] / pivote1;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizb1[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizb1[k][j] = matrizb1[k][j] - extremos * matrizb1[i][j];
                        matrizin1[k][j] = matrizin1[k][j] - extremos * matrizin1[i][j];
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
        inversa1 = matrizin1;
        //MULTIPLICACION DE LA MATRIZ INVERSA DE B CON LA MATRIZ A
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    matrizr1[i][j] += matriza1[i][k] * matrizin1[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr1[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        
        System.out.println("");
        System.out.println("");
    }
    
    double[][] matrizid = new double[4][4];
    public void reop1d(){
        lapiz.append("<h2>Penalización Dificil</h2>\n" +
"        <p> Se tiene que realizar la división de matrices en esta forma:</p>\n" +
"        <h6>\n" +
"            <center>A / B</center>\n" +
"        </h6>\n" +
"        <p>1. Se obtienen los siguientes datos: </p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matriza1[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizbp1[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <h6>2. Se calcula la matriz inversa de B</h6>\n" +
"        <p>2.1 Se agrega la matriz identidad de B</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizbp1[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se mira si los pivotes son distintos de 0 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    if (matrizb1[i][j] == 0) {
                        lapiz.append("<td class=\" table-dark text-danger\"> \n");
                        lapiz.append("\t" + matrizbp1[i][j]);
                        lapiz.append("</td>\n");
                    }else{
                        lapiz.append("<td class=\" table-dark\"> \n");
                        lapiz.append("\t" + matrizbp1[i][j]);
                        lapiz.append("</td>\n");
                    }                    
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizbp1[i][j]);
                    lapiz.append("</td>\n");
                }
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se dividen los pivotes dentro de su fila para obtener 1 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    lapiz.append("<td class=\" table-dark\"> \n");
                    lapiz.append("\t" + matrizbp1[i][j] + " / " + matrizbp1[i][j]);
                    lapiz.append("</td>\n");                   
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizbp1[i][j] + " / " + matrizbp1[i][i]);
                    lapiz.append("</td>\n");
                }
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j] + " / " + matrizbp1[i][i]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.3. Se trata la manera de que la matiz B se convierta en la matriz Identidad y la matriz identidad de\n" +
"            respuesta\n" +
"            de la matriz inversa: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Inversa</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td class=\" table-dark\"> \n");
                lapiz.append("\t" + (Math.round(inversa1[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>3. Esta es la matriz inversa de B:</p>\n" +
"        <h4 class=\"text-danger\">Matriz Inversa de la Matriz B</h4>\n" +
"        <table class=\"table table-bordered table-dark\">\n" +
"            <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizin1[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"        </table>");
        lapiz.append("<p></p>\n" +
"        <p>4. Se multiplica la matriz A con la matriz B</p>\n" +
"        <p> A = Matriz A</p>\n" +
"        <P> BI = Matriz Inversa de B</P>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Operacion de la multiplicacion de matrices</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>A[0,0] * BI[0,0] + A[0,1] * BI[1,0] + A[0,2] * BI[2,0] + A[0,3] *BI[3,0]</td>\n" +
"                        <td>A[0,0] * BI[0,1] + A[0,1] * BI[1,1] + A[0,2] * BI[2,1] + A[0,3] *BI[3,1]</td>\n" +
"                        <td>A[0,0] * BI[0,2] + A[0,1] * BI[1,2] + A[0,2] * BI[2,2] + A[0,3] *BI[3,2]</td>\n" +
"                        <td>A[0,0] * BI[0,3] + A[0,1] * BI[1,3] + A[0,2] * BI[2,3] + A[0,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[1,0] * BI[0,0] + A[1,1] * BI[1,0] + A[1,2] * BI[2,0] + A[1,3] *BI[3,0]</td>\n" +
"                        <td>A[1,0] * BI[0,1] + A[1,1] * BI[1,1] + A[1,2] * BI[2,1] + A[1,3] *BI[3,1]</td>\n" +
"                        <td>A[1,0] * BI[0,2] + A[1,1] * BI[1,2] + A[1,2] * BI[2,2] + A[1,3] *BI[3,2]</td>\n" +
"                        <td>A[1,0] * BI[0,3] + A[1,1] * BI[1,3] + A[1,2] * BI[2,3] + A[1,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[2,0] * BI[0,0] + A[2,1] * BI[1,0] + A[2,2] * BI[2,0] + A[2,3] *BI[3,0]</td>\n" +
"                        <td>A[2,0] * BI[0,1] + A[2,1] * BI[1,1] + A[2,2] * BI[2,1] + A[2,3] *BI[3,1]</td>\n" +
"                        <td>A[2,0] * BI[0,2] + A[2,1] * BI[1,2] + A[2,2] * BI[2,2] + A[2,3] *BI[3,2]</td>\n" +
"                        <td>A[2,0] * BI[0,3] + A[2,1] * BI[1,3] + A[2,2] * BI[2,3] + A[2,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[3,0] * BI[0,0] + A[3,1] * BI[1,0] + A[3,2] * BI[2,0] + A[3,3] *BI[3,0]</td>\n" +
"                        <td>A[3,0] * BI[0,1] + A[3,1] * BI[1,1] + A[3,2] * BI[2,1] + A[3,3] *BI[3,1]</td>\n" +
"                        <td>A[3,0] * BI[0,2] + A[3,1] * BI[1,2] + A[3,2] * BI[2,2] + A[3,3] *BI[3,2]</td>\n" +
"                        <td>A[3,0] * BI[0,3] + A[3,1] * BI[1,3] + A[3,2] * BI[2,3] + A[3,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>4. Este es el resultado de la división de matrices</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A/B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizr1[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>\n" +
"        <p></p>");
    }
    
    //METODO PARA LA OPCION B DE LA PENALIZACION DÍFICIL  
    //DEFINIENDO LA MATRIZ A
        double[][] matriza2 = {{1, 12, 9, 8}, {7, 6, 3, 2}, {0, 5, 6, 14}, {6, 9, 6, 10}};
        //DEFINIENDO LA MATRIZ B
        double[][] matrizb2 = {{8, 19, 20, 4}, {12, 33, 6, 8}, {4, 5, 9, 7}, {8, 22, 14, 6}};
        //MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu2 = new double[4][4];
        //MATRIZ DE RESULTADO ( POR EL SISTEMA)
        double[][] matrizr2 = new double[4][4];
        //MATRIZ IDENTIDAD E INVERSA
        double[][] matrizin2 = new double[4][4];
        double pivote2;
    public void opcionbd() {
        double[][] matrizbn2 = {{8, 19, 20, 4}, {12, 33, 6, 8}, {4, 5, 9, 7}, {8, 22, 14, 6}};
        double extremos;
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
                System.out.print(matriza2[i][j] + "\t|");
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
                System.out.print(matrizb2[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        
        //----------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA----------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizin2[i][j] = 1;
                } else {
                    matrizin2[i][j] = 0;
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
            pivote2 = matrizbn2[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizbn2[i][j] = matrizbn2[i][j] / pivote2;
                matrizin2[i][j] = matrizin2[i][j] / pivote2;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizbn2[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizbn2[k][j] = matrizbn2[k][j] - extremos * matrizbn2[i][j];
                        matrizin2[k][j] = matrizin2[k][j] - extremos * matrizin2[i][j];
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
                    matrizr2[i][j] += matriza2[i][k] * matrizin2[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr2[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        
        System.out.println("");
    }

    public void reop2d(){
        lapiz.append("<h2>Penalización Dificil</h2>\n" +
"        <p> Se tiene que realizar la división de matrices en esta forma:</p>\n" +
"        <h6>\n" +
"            <center>A / B</center>\n" +
"        </h6>\n" +
"        <p>1. Se obtienen los siguientes datos: </p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matriza2[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizb2[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <h6>2. Se calcula la matriz inversa de B</h6>\n" +
"        <p>2.1 Se agrega la matriz identidad de B</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizb2[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se mira si los pivotes son distintos de 0 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    if (matrizb1[i][j] == 0) {
                        lapiz.append("<td class=\" table-dark text-danger\"> \n");
                        lapiz.append("\t" + matrizb2[i][j]);
                        lapiz.append("</td>\n");
                    }else{
                        lapiz.append("<td class=\" table-dark\"> \n");
                        lapiz.append("\t" + matrizb2[i][j]);
                        lapiz.append("</td>\n");
                    }                    
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizb2[i][j]);
                    lapiz.append("</td>\n");
                }
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se dividen los pivotes dentro de su fila para obtener 1 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    lapiz.append("<td class=\" table-dark\"> \n");
                    lapiz.append("\t" + matrizb2[i][j] + " / " + matrizb2[i][j]);
                    lapiz.append("</td>\n");                   
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizb2[i][j] + " / " + matrizb2[i][i]);
                    lapiz.append("</td>\n");
                }
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j] + " / " + matrizb2[i][i]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.3. Se trata la manera de que la matiz B se convierta en la matriz Identidad y la matriz identidad de\n" +
"            respuesta\n" +
"            de la matriz inversa: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Inversa</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td class=\" table-dark\"> \n");
                lapiz.append("\t" + (Math.round(matrizin2[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>3. Esta es la matriz inversa de B:</p>\n" +
"        <h4 class=\"text-danger\">Matriz Inversa de la Matriz B</h4>\n" +
"        <table class=\"table table-bordered table-dark\">\n" +
"            <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizin2[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"        </table>");
        lapiz.append("<p></p>\n" +
"        <p>4. Se multiplica la matriz A con la matriz B</p>\n" +
"        <p> A = Matriz A</p>\n" +
"        <P> BI = Matriz Inversa de B</P>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Operacion de la multiplicacion de matrices</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>A[0,0] * BI[0,0] + A[0,1] * BI[1,0] + A[0,2] * BI[2,0] + A[0,3] *BI[3,0]</td>\n" +
"                        <td>A[0,0] * BI[0,1] + A[0,1] * BI[1,1] + A[0,2] * BI[2,1] + A[0,3] *BI[3,1]</td>\n" +
"                        <td>A[0,0] * BI[0,2] + A[0,1] * BI[1,2] + A[0,2] * BI[2,2] + A[0,3] *BI[3,2]</td>\n" +
"                        <td>A[0,0] * BI[0,3] + A[0,1] * BI[1,3] + A[0,2] * BI[2,3] + A[0,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[1,0] * BI[0,0] + A[1,1] * BI[1,0] + A[1,2] * BI[2,0] + A[1,3] *BI[3,0]</td>\n" +
"                        <td>A[1,0] * BI[0,1] + A[1,1] * BI[1,1] + A[1,2] * BI[2,1] + A[1,3] *BI[3,1]</td>\n" +
"                        <td>A[1,0] * BI[0,2] + A[1,1] * BI[1,2] + A[1,2] * BI[2,2] + A[1,3] *BI[3,2]</td>\n" +
"                        <td>A[1,0] * BI[0,3] + A[1,1] * BI[1,3] + A[1,2] * BI[2,3] + A[1,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[2,0] * BI[0,0] + A[2,1] * BI[1,0] + A[2,2] * BI[2,0] + A[2,3] *BI[3,0]</td>\n" +
"                        <td>A[2,0] * BI[0,1] + A[2,1] * BI[1,1] + A[2,2] * BI[2,1] + A[2,3] *BI[3,1]</td>\n" +
"                        <td>A[2,0] * BI[0,2] + A[2,1] * BI[1,2] + A[2,2] * BI[2,2] + A[2,3] *BI[3,2]</td>\n" +
"                        <td>A[2,0] * BI[0,3] + A[2,1] * BI[1,3] + A[2,2] * BI[2,3] + A[2,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[3,0] * BI[0,0] + A[3,1] * BI[1,0] + A[3,2] * BI[2,0] + A[3,3] *BI[3,0]</td>\n" +
"                        <td>A[3,0] * BI[0,1] + A[3,1] * BI[1,1] + A[3,2] * BI[2,1] + A[3,3] *BI[3,1]</td>\n" +
"                        <td>A[3,0] * BI[0,2] + A[3,1] * BI[1,2] + A[3,2] * BI[2,2] + A[3,3] *BI[3,2]</td>\n" +
"                        <td>A[3,0] * BI[0,3] + A[3,1] * BI[1,3] + A[3,2] * BI[2,3] + A[3,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>4. Este es el resultado de la división de matrices</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A/B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizr2[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>\n" +
"        <p></p>");
    }
    
    //METODO PARA LA OPCION C DE LA PENALIZACION DÍFICIL
    //SE DEFINE LA MATRIZ A Y B
        double[][] matriza3 = {{5, 9, 14, 5}, {6, 0, 5, 3}, {1, 14, 68, 8}, {7, 5, 3, 9}};
        double[][] matrizb3 = {{0, 9, 7, 19}, {2, 30, 5, 48}, {1, 31, 2, 5}, {15, 8, 4, 3}};
        //SE CREA LA MATRIZ INGRESADA POR EL USUARIO
        double[][] matriziu3 = new double[4][4];
        //SE CREA LA MATRIZ RESULTADO
        double[][] matrizr3 = new double[4][4];
        //SE CREA LA MATRIZ IDENTIDAD E INVERSA
        double[][] matrizin3 = new double[4][4];
        double pivote3;
    public void opcioncd() {        
        double extremos;
        double[][] matrizbn3 = matrizb3;
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
                System.out.print(matriza3[i][j] + "\t|");
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
                System.out.print(matrizb3[i][j] + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }

        //----------PROCEDIMIENTO DEL CALCULO EN EL SISTEMA----------
        //MATRIZ IDENTIDAD DE B
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizin3[i][j] = 1;
                } else {
                    matrizin3[i][j] = 0;
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
            aux = matrizbn3[0][j];
            matrizbn3[0][j] = matrizbn3[1][j];
            matrizbn3[1][j] = aux;
        }
        
        for (int j = 0; j < 4; j++) {
            aux = matrizin3[0][j];
            matrizin3[0][j] = matrizin3[1][j];
            matrizin3[1][j] = aux;
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
            pivote3 = matrizb3[i][i];
            //PASO 2: CONVERTIR TODOS LOS PIVOTES A 1
            for (int j = 0; j < 4; j++) {
                //Se divide toda la fila con el valor del pivote
                matrizbn3[i][j] = matrizbn3[i][j] / pivote3;
                matrizin3[i][j] = matrizin3[i][j] / pivote3;
            }

            //PASO 3: OPERACIONES ENTRE FILAS
            for (int k = 0; k < 4; k++) {
                //SE PONE I SEA DIFERENTE QUE K PARA QUE NO TOQUE LOS 1 DE LA MATRIZ B
                if (i != k) {
                    //LOS EXTREMOS SON LOS NUMEROS QUE ESTAN EN LAS COLUMNAS QUE NO FORMAN PARTE DE LOS 1 EN DIAGONAL 
                    extremos = matrizbn3[k][i];
                    for (int j = 0; j < 4; j++) {
                        //VA A RECORRER TODA LA FILA RESTANDO CON LA FILA DE CADA PIVOTE HASTA FORMAR EN LA MATRIZ B
                        //COMO LA MATRIZ IDENTIDAD Y LA MATRIZ IDENTIDAD SE TRANSFORMA A LA MATRIZ INVERSA
                        matrizbn3[k][j] = matrizbn3[k][j] - extremos * matrizbn3[i][j];
                        matrizin3[k][j] = matrizin3[k][j] - extremos * matrizin3[i][j];
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
                    matrizr3[i][j] += matriza3[i][k] * matrizin3[k][j];
                }
            }
        }
        
        // IMPRIMIR LA MATRIZ DE RESULTADO A 3 DECIMALES
        System.out.println("");
        System.out.println("LA MATRIZ RESUELTA DEL SISTEMA: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print((Math.round(matrizr3[i][j] * 1000.0) / 1000.0) + "\t|");
            }
            System.out.println("");
            System.out.println("---------------------------------");
        }
        System.out.println("");
        System.out.println("");
    }
    
    public void reop3d(){
        lapiz.append("<h2>Penalización Dificil</h2>\n" +
"        <p> Se tiene que realizar la división de matrices en esta forma:</p>\n" +
"        <h6>\n" +
"            <center>A / B</center>\n" +
"        </h6>\n" +
"        <p>1. Se obtienen los siguientes datos: </p>\n" +
"        <h5>Datos:</h5>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz A</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matriza3[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<div class=\"container\">\n" +
"            <h4 class=\"text-dark\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizb3[i][j]);
                lapiz.append("</td>\n");
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <h6>2. Se calcula la matriz inversa de B</h6>\n" +
"        <p>2.1 Se agrega la matriz identidad de B</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr>");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizb3[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se mira si los pivotes son distintos de 0 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    if (matrizb1[i][j] == 0) {
                        lapiz.append("<td class=\" table-dark text-danger\"> \n");
                        lapiz.append("\t" + matrizb3[i][j]);
                        lapiz.append("</td>\n");
                    }else{
                        lapiz.append("<td class=\" table-dark\"> \n");
                        lapiz.append("\t" + matrizb3[i][j]);
                        lapiz.append("</td>\n");
                    }                    
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizb3[i][j]);
                    lapiz.append("</td>\n");
                }
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.2. Se dividen los pivotes dentro de su fila para obtener 1 </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Indentidad</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    lapiz.append("<td class=\" table-dark\"> \n");
                    lapiz.append("\t" + matrizb3[i][j] + " / " + matrizb3[i][j]);
                    lapiz.append("</td>\n");                   
                }else{
                    lapiz.append("<td> \n");
                    lapiz.append("\t" + matrizb3[i][j] + " / " + matrizb3[i][i]);
                    lapiz.append("</td>\n");
                }
            }
            for (int j = 0; j < 4; j++) {
                if (i == j) {
                    matrizid[i][j] =1 ;
                }else{
                    matrizid[i][j] = 0;
                }
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j] + " / " + matrizb3[i][i]);
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>2.3. Se trata la manera de que la matiz B se convierta en la matriz Identidad y la matriz identidad de\n" +
"            respuesta\n" +
"            de la matriz inversa: </p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Matriz B | Matriz Inversa</h4>\n" +
"            <table class=\"table table-bordered \">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + matrizid[i][j]);
                lapiz.append("</td>\n");
            }
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td class=\" table-dark\"> \n");
                lapiz.append("\t" + (Math.round(matrizin3[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>3. Esta es la matriz inversa de B:</p>\n" +
"        <h4 class=\"text-danger\">Matriz Inversa de la Matriz B</h4>\n" +
"        <table class=\"table table-bordered table-dark\">\n" +
"            <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizin3[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"        </table>");
        lapiz.append("<p></p>\n" +
"        <p>4. Se multiplica la matriz A con la matriz B</p>\n" +
"        <p> A = Matriz A</p>\n" +
"        <P> BI = Matriz Inversa de B</P>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-danger\">Operacion de la multiplicacion de matrices</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>\n" +
"                    <tr>\n" +
"                        <td>A[0,0] * BI[0,0] + A[0,1] * BI[1,0] + A[0,2] * BI[2,0] + A[0,3] *BI[3,0]</td>\n" +
"                        <td>A[0,0] * BI[0,1] + A[0,1] * BI[1,1] + A[0,2] * BI[2,1] + A[0,3] *BI[3,1]</td>\n" +
"                        <td>A[0,0] * BI[0,2] + A[0,1] * BI[1,2] + A[0,2] * BI[2,2] + A[0,3] *BI[3,2]</td>\n" +
"                        <td>A[0,0] * BI[0,3] + A[0,1] * BI[1,3] + A[0,2] * BI[2,3] + A[0,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[1,0] * BI[0,0] + A[1,1] * BI[1,0] + A[1,2] * BI[2,0] + A[1,3] *BI[3,0]</td>\n" +
"                        <td>A[1,0] * BI[0,1] + A[1,1] * BI[1,1] + A[1,2] * BI[2,1] + A[1,3] *BI[3,1]</td>\n" +
"                        <td>A[1,0] * BI[0,2] + A[1,1] * BI[1,2] + A[1,2] * BI[2,2] + A[1,3] *BI[3,2]</td>\n" +
"                        <td>A[1,0] * BI[0,3] + A[1,1] * BI[1,3] + A[1,2] * BI[2,3] + A[1,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[2,0] * BI[0,0] + A[2,1] * BI[1,0] + A[2,2] * BI[2,0] + A[2,3] *BI[3,0]</td>\n" +
"                        <td>A[2,0] * BI[0,1] + A[2,1] * BI[1,1] + A[2,2] * BI[2,1] + A[2,3] *BI[3,1]</td>\n" +
"                        <td>A[2,0] * BI[0,2] + A[2,1] * BI[1,2] + A[2,2] * BI[2,2] + A[2,3] *BI[3,2]</td>\n" +
"                        <td>A[2,0] * BI[0,3] + A[2,1] * BI[1,3] + A[2,2] * BI[2,3] + A[2,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                    <tr>\n" +
"                        <td>A[3,0] * BI[0,0] + A[3,1] * BI[1,0] + A[3,2] * BI[2,0] + A[3,3] *BI[3,0]</td>\n" +
"                        <td>A[3,0] * BI[0,1] + A[3,1] * BI[1,1] + A[3,2] * BI[2,1] + A[3,3] *BI[3,1]</td>\n" +
"                        <td>A[3,0] * BI[0,2] + A[3,1] * BI[1,2] + A[3,2] * BI[2,2] + A[3,3] *BI[3,2]</td>\n" +
"                        <td>A[3,0] * BI[0,3] + A[3,1] * BI[1,3] + A[3,2] * BI[2,3] + A[3,3] *BI[3,3]</td>\n" +
"                    </tr>\n" +
"                </tbody>\n" +
"            </table>\n" +
"        </div>");
        lapiz.append("<p></p>\n" +
"        <p>4. Este es el resultado de la división de matrices</p>\n" +
"        <div class=\"container\">\n" +
"            <h4 class=\"text-body\">Matriz Resultado A/B</h4>\n" +
"            <table class=\"table table-bordered table-dark\">\n" +
"                <tbody>");
        for (int i = 0; i < 4; i++) {
            lapiz.append("<tr> \n");
            for (int j = 0; j < 4; j++) {
                lapiz.append("<td> \n");
                lapiz.append("\t" + (Math.round(matrizr3[i][j]*1000.0)/1000.0));
                lapiz.append("</td>\n");                
            }
            lapiz.append("</tr>");
        }
        lapiz.append("</tbody>\n" +
"            </table>\n" +
"        </div>\n" +
"        <p></p>");
    }
    //METODO PARA UNIR EL REPORTE AL LLAMAR LOS METODOS
    public void r1(){
        inicior1();
        if (b1 != 0 && beta1 !=0 && gama1 !=0) {
            repoopaaf();
        }
        if (a1 !=0 && alpha2 !=0 && gama2 !=0) {
            repoopbbf();
        }
        if (c1 != 0 && alpha3 != 0 && beta3 != 0) {
            repoopccf();
        }
        if (mri1c != null) {
            piar1();
        }
        if (mri2c != null) {
            pibr1();
        }
        if (mri3c != null) {
            picr1();
        }
        if (matrizr1 != null ) {                
            reop1d();
        }
        if (matrizr2 != null) {
            reop2d();
        }
        if (matrizr3 !=null) {
            reop3d();
        }
        finaldoc1();
        report.archivonuevo(lapiz.toString(), "Reporte1.html");
    }
    public void finaldoc1(){
        lapiz.append("\"<div class=\\\"container p-3 my-3 bg-warning text-body\\\">\\n\" +\n" +
"\"        <h4>\\n\" +\n" +
"\"            <center>Opcion de Pausa no disponible :c</center>\\n\" +\n" +
"\"        </h4>\\n\" +\n" +
"\"    </div>\\n\" +\n" +
"\"    <div class=\\\"container p-3 my-3 bg-warning text-body\\\">\\n\" +\n" +
"\"        <h4>\\n\" +\n" +
"\"            <center>Opcion de Reanudar juego no disponible :c</center>\\n\" +\n" +
"\"        </h4>\\n\" +\n" +
"\"    </div>\"");
        lapiz.append("</div>\n" +
"    <p></p>\n" +
"    <div class=\"container p-3 my-3 bg-dark text-white\">\n" +
"        <h4>Reporte 1 - Practica 1 IPC1-D</h4>\n" +
"        <p>Reporte generado por el programa del alumno Rodrigo Alejandro Hernández de León</p>\n" +
"        <p> Carnet: 201900042</p>\n" +
"    </div>\n" +
"</body>\n" +
"\n" +
"</html>");
    }
    public void errorr1(){
        lapiz.append("<div class=\"container p-3 my-3 bg-warning text-body\">\n" +
"        <h4>\n" +
"            <center>NO HA INICIADO EL JUEGO O NO ENTRO A ESTA PENALIZACION</center>\n" +
"        </h4>\n" +
"    </div>");
    }
    public void finbitacora(){
        
        pw.println("<div class=\"container p-3 my-3 bg-dark text-white\">\n" +
"        <h4>Reporte 2 - Practica 1 IPC1-D</h4>\n" +
"      <p>Bitácora generada por el programa del alumno Rodrigo Alejandro Hernández de León</p>\n" +
"      <p> Carnet: 201900042</p>\n" +
"    </div>\n" +
"  </body>\n" +
"</html>");
    }
}
