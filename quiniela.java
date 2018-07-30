import java.util.Arrays;
import java.util.Scanner;
import java.util.InputMismatchException;

public class quiniela {

    // metodo que comprueba si un valor existe ya dentro de un array

    public static boolean contains(int[] arr, int item) {
        for (int n : arr) {
           if (item == n) {
              return true;
           }
        }
        return false;
     }

     //Metodo que recorre un array (de maquina o del usuario) y devuelve los valores elegidos

     public static void quiniela(int[] maquina, String tipo){

        System.out.println(tipo);
        System.out.println("----------------------------------");

        for(int i=0; i<maquina.length -1; i++ ){

            System.out.println("numero "+ (i + 1) +" elegido por "+tipo+ " " + maquina[i]);
            
        }


     }

     // Metodo que comprueba el boleto, pasando los arrays generado por la maquina y por el usuario

     public static void comprobarBoleto(int[] arrayMaquina, int[] arrayUsuario){

        int aciertos = 0;

        for(int l = 0; l<arrayMaquina.length -1; l++){

            if(contains(arrayMaquina, arrayUsuario[l])){
                aciertos++;
            }

        }

        System.out.println("*********************************");
        System.out.println("tienes "+aciertos+ " aciertos");
     }



    public static void main(String args[]){ // Metodo main para probar el programa

        int [] numeros = new int [7];
        int [] numerosUsuario = new int [7];
        int numeroalea = 0;
        Scanner sc = new Scanner(System.in);
        int numerointroducido = 0;

        for(int i=0; i<6; i++){

            System.out.println("introduzca un numero del 1 al 49");

            try{ //bloque try catch para capturar algunos tipos de error, como introducir Strings en lugar de numeros

            numerointroducido = sc.nextInt();

            }catch(InputMismatchException error){
                System.out.println("hubo un error con el tipo de dato introducido, por favor vuelva a ejecutar el programa");
                System.exit(0);
            }
            catch(Exception e){
                System.out.println("por favor introduzca un valor valido");
                System.exit(0);
            }
           
 



            while(numerointroducido >49 || numerointroducido <1 || contains(numerosUsuario, numerointroducido)){
                System.out.println("Por favor introduzca un valor de numero entre 1 y 49 o un numero no repetido");
                numerointroducido = sc.nextInt();
            }

            numerosUsuario[i] = numerointroducido;

            numeroalea = (int) (Math.random() * 49 + 1);


            if(contains(numeros, numeroalea)){

            numeroalea = (int) (Math.random() * 49 + 1);    
            numeros[i] = numeroalea;
            }

            numeros[i] = numeroalea;


        }

        quiniela(numeros, "la maquina");
        System.out.println();
        quiniela(numerosUsuario, "el usuario");

        comprobarBoleto(numeros, numerosUsuario);

    }

}