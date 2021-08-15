package pra1;
//IMPORTAR LAS LIBRERIAS CORRESPONDIENTES
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
        System.out.println("============================================");
        System.out.println("=========== ESCALERAS MATEMÁTICAS ==========");
        System.out.println("==         =======================        ==");
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
        //Se genera este for para que genere la fila de abajo hacia arriba
        for (int i = 16-1; i >=0; i--) {
            //Salto de linea para saltar a la siguiente fila
            System.out.println("");
            //Si el numero de fila es par entonces solo muestre en esa columna unicamente espacios
            if (i % 2 == 0) {
                //En todas las columnas va a imprimir espacios
                for (int j = 0; j < 8; j++) {
                        //System.out.print("[" + i + "," + j + "] = "  + (j+1) + " | ");
                        //System.out.print(((j + 1) + (8 * i)) + " | ");
                        System.out.print("   |");
                }
                System.out.println("");
                System.out.print("--------------------------------");
            }else{
                //De lo contrario por medio del switch se ejecutara el orden de los numeros en cada columna
                switch(i){
                    case 1:
                        //En la primera fila sera de izquierda a derecha
                        for (int j = 8 - 1; j >= 0; j--) {
                            //System.out.print("[" + i + "," + j + "] = "  + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-1))) + "  |");
                        }
                        break;
                    case 3:
                        //En la segunda fila se ejecuta de derecha a izquierda
                        for (int j = 0; j < 8; j++) {
                            //System.out.print("[" + i + "," + j + "] = " + (j+1) + " | ");
                            if (((j + 1) + (8 * (i-2)))==9) {
                                System.out.print(((j + 1) + (8 * (i-2))) + "  |");
                            }else{
                                System.out.print(((j + 1) + (8 * (i-2))) + " |");
                            }                            
                        }
                        break;
                    case 5:
                        //En la tercera fila se ejecutara de izquierda a derecha
                        for (int j = 8 - 1; j >= 0; j--) {
                            //System.out.print("[" + i + "," + j + "] = "  + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-3))) + " |");
                        }
                        break;
                    case 7:
                        //En la cuarta fila se ejecutara de derecha a izquierda
                        for (int j = 0; j < 8; j++) {
                            //System.out.print("[" + i + "," + j + "] = " + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-4))) + " |");
                        }
                        break;
                    case 9:
                        //En la quinta fila se ejecutara de izquierda a derecha
                        for (int j = 8 - 1; j >= 0; j--) {
                            //System.out.print("[" + i + "," + j + "] = "  + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-5))) + " |");
                        }
                        break;
                    case 11:
                        //En la sexta fila se ejecutara de derecha a izquierda
                        for (int j = 0; j < 8; j++) {
                            //System.out.print("[" + i + "," + j + "] = " + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-6))) + " |");
                        }
                        break;
                    case 13:
                        //En la septima fila se ejecutara de izquierda a derecha
                        for (int j = 8 - 1; j >= 0; j--) {
                            //System.out.print("[" + i + "," + j + "] = "  + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-7))) + " |");
                        }
                        break;
                    case 15:
                        //Por ultimo en la octava fila se ejecutara de derecha a izquierda
                        for (int j = 0; j < 8; j++) {
                            //System.out.print("[" + i + "," + j + "] = " + (j+1) + " | ");
                            System.out.print(((j + 1) + (8 * (i-8))) + " |");
                        }
                        break;
                }
            }                       
        }
    }
}
