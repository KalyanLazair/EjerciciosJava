/*
 * Autor; Marta Márquez Olalla
   Ejercicios básicos de Java.
 */
package ejerciciosjava;

import java.util.Arrays;

/**
 *
 * @author Thomas
 */
public class EjerciciosJava {
//Los corchetes son para saber que estamos trabajando con un array de ints.
    /*numeroMáximo lo comparamos con el número que hay en i en ese momento. Si es menor que el número i
    el valor de numeroMaximo cambia. 0 es menor que 50. Hacemos una segunda pasada con el bucle. 50 no es menor
    que 31, por lo que se mantiene. Etc.
    Cuando termine el bucle nos retorna el new int con el valor de numeroMaximo. El 0 es para el segundo valor.*/
    public int[] maximo(int[] listaNumeros){
        int numeroMaximo = 0;
        int maximoDos = 0;
        for(int i=0;i<listaNumeros.length; i++){
               if(numeroMaximo < listaNumeros[i]){  
                     numeroMaximo = listaNumeros[i];                                          
               }                                                
        }
        for(int i=0;i<listaNumeros.length; i++){
            if(maximoDos<listaNumeros[i] && listaNumeros[i]<numeroMaximo){
                     maximoDos = listaNumeros[i];
            }
        }
        return new int[]{numeroMaximo,maximoDos};
       
    }                                                
    //Tenemos que declarar un segundo int que vamos a comparar tanto con los valores de listaNumeros
    //como con numeroMaximo.
    
    //Otra forma de resolverlo. Con una única vuelta de bucle FOR.
    /*Public int[] maximo(int [] listaNumeros){
        int[] numerosMaximos = (0,0);  //De esta manera ya declaramos los dos números y le damos un valor.
                                       //Los números estarán en la posición 0 y 1.
        for(int i=0; i<listaNumeros.length; i++){
           if(numerosMaximos[0] < listaNumeros[i]){
                 numerosMaximos[1] = numerosMaximos[0]; 
                 numerosMaximos[0] = listaNumeros[i];
           }else if(numerosMaximos[1] < listaNumeros[i]){
                 numerosMaximos[1] = listaNumeros[i];
    }
    }
    }
    
    */
    
    //Segundo ejercicio. Declaramos un método que nos devuelva true si el string es un palíndromo.
    
    public boolean palindromo(String frase){
       String cadena1=" ";
       String cadena2=" ";
               
       for(int i=0;i<frase.length(); i++){ 
          if(frase.charAt(i) != ' '){
            cadena1+=frase.charAt(i);
          }
            System.out.println(cadena1);
  
       }
       for(int j=frase.length()-1; j>=0; j--){
           if(frase.charAt(j) != ' '){
           cadena2+=frase.charAt(j);
           }
               System.out.println(cadena2);     
       }
       
       if(cadena1.equals(cadena2)){
         return true;
       }else{
         return false;
       }
       
    }
    
    public boolean isograma(String iso){
        String cadena = " ";
        cadena.toLowerCase();
        String caracter=" ";
           
        for(int i=0; i<iso.length(); i++){
            
            caracter=iso.substring(i,i+1);
            
           if(cadena.contains(caracter)){
               return false;
           }else if(i<iso.length()){
             cadena+=iso.substring(i,i+1);
           }
           
           System.out.println(cadena);         
        } 
        return true;
    }
    
    public boolean anagrama(String palabra1, String palabra2){
            palabra1.toLowerCase();
            palabra2.toLowerCase();
            String cadena="";
            String caracter="";
            
            for(int i=0; i<palabra1.length();i++){
                
                caracter=palabra2.substring(i,i+1);
                
               if(palabra1.length()!=palabra2.length()){
                   return false;
               }
               if(!palabra1.contains(caracter)){
                 return false;  
               }
               
               
            
            }
            if(cadena.equals(palabra1)){
               return true;
            }
            return false;
    }
    
    
    public String acronimo(String acro){
       String cadena="";
       String primera="";
       
       for(int i=0; i<acro.length();i++){
         if(!acro.substring(0,1).equals("y") && !acro.substring(0,1).equals("e") &&
                 !acro.substring(0,2).equals("de") && !acro.substring(0,2).equals("la") && !acro.substring(0,3).equals("las")){
            primera=acro.substring(0,1);
         }
         
         if(acro.charAt(i)==' ' && (!acro.substring(i+1,i+2).equals("y") && !acro.substring(i+1,i+2).equals("e") &&
                 !acro.substring(i+1,i+3).equals("de") && !acro.substring(i+1,i+3).equals("la") && !acro.substring(i+1,i+4).equals("las"))){
          i++;
          cadena+=acro.substring(i,i+1);
         }
           
       }
        
       return primera+cadena;
    }
        
    
    
    
    public static void main(String[] args) {
        /*EjerciciosJava ejercicio1 = new EjerciciosJava();
        int[] listaNumeros = {50, 31, 27, 2, 5, 99, 12};
        System.out.println(Arrays.toString(ejercicio1.maximo(listaNumeros)));*/
    
        /*EjerciciosJava ejercicio2 = new EjerciciosJava();
        String frase = ("acaso hubo buhos aca");
        System.out.println(ejercicio2.palindromo(frase));*/
        
      /* EjerciciosJava ejercicio3 = new EjerciciosJava();
       //String iso =("murcielago");
       String iso =("perro");
       System.out.println(ejercicio3.isograma(iso));*/
      
      EjerciciosJava ejercicio4= new EjerciciosJava();
      String palabra1="amoro";
      String palabra2="morao";
      System.out.println(ejercicio4.isograma(palabra2));
      System.out.println(ejercicio4.isograma(palabra1));
    }
      
      /*EjerciciosJava ejercicio5=new EjerciciosJava();
      //String acro="Alta Velocidad Española";
      String acro="Tecnología de la Información y de las Comunicaciones";
      System.out.println(ejercicio5.acronimo(acro));
    }*/
}
