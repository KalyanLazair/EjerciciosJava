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
    //Lo resolvemos con dos bucles for separados.
    
    public boolean palindromo(String frase){
       String cadena1=" ";  //String donde se va a guardar la cadena sin espacios, de izquierda a derecha.
       String cadena2=" ";  //String donde se va a guardar la cadena sin espacios de derecha a izquierda.
       
               //EL primer bucle analiza el String frase de izquierda a derecha.
       for(int i=0;i<frase.length(); i++){ 
          if(frase.charAt(i) != ' '){  //En caso de que el char en posición i sea distinto de espacio, guarda el char en cadena1.
            cadena1+=frase.charAt(i);
          }
            System.out.println(cadena1);
  
       }
       //Analiza la frase de derecha a izquierda.
       for(int j=frase.length()-1; j>=0; j--){
           if(frase.charAt(j) != ' '){  //En caso que el char en posición i sea distinto de espacio, guarda el char en cadena2.
           cadena2+=frase.charAt(j);
           }
               System.out.println(cadena2);     
       }
       
       if(cadena1.equals(cadena2)){ //Si los dos strings son iguales, retorna true.
         return true;
       }else{
         return false;
       }
       
    }
    
    public boolean isograma(String iso){
        String cadena = " ";//Guardaremos los chars a comprobar.
        cadena.toLowerCase();//ponemos el stirng a lowercase para evitar problemas con mayúsculas.
        String caracter=" ";//Guardaremos el char a comprobar en cada momento.
           
        for(int i=0; i<iso.length(); i++){
            
            caracter=iso.substring(i,i+1);  //Char a comprobar.
            
           if(cadena.contains(caracter)){ //Si el string cadena contiene ya el char a analizar, devolvemos false.
               return false;
           }else if(i<iso.length()){  //En caso contrario y mientras la i sea menor a la longitud del string que le estamos pasando
             cadena+=iso.substring(i,i+1);  //Le sumamos el char al string auxiliar.
           }
           
           System.out.println(cadena);         //Comprobación.
        } 
        return true;  //Retorna true en caso que no haya ningún char repetido.
    }
    
    /*Ejercicio del anagrama.*/
    
    public boolean anagrama(String palabra1, String palabra2){
            palabra1.toLowerCase();//Ponemos ambos strings a lowercase por sistema para evitar problemas con mayúsculas.
            palabra2.toLowerCase();
            String cadena="";//string auxiliar donde vamos a guardar el resultado.
            int contador=0; //contador para determinar la posición de los char y poder recorrer todo el string con un while.
            boolean presente=false; //booleano que cambiará a true cuando detecte la letra, para parar el bucle while.
            
            
            for(int i=0; i<palabra1.length();i++){
                contador=0;         //se resetean los valores al inicio de una nueva vuelta del bucle.
                presente=false;
                
              if(palabra1.length() != palabra2.length()){ //Si las longitudes varían, devuelve false.
                return false;
              }
              while(contador<palabra1.length() && presente==false){  //Condiciones del bucle while que se va a ejecutar con intención
                 if(palabra1.charAt(i)==palabra2.charAt(contador)){  //de comprobar cada char dentro de cada vuelta del bucle, creando
                   cadena+=palabra1.substring(i,i+1);                //un nuevo string con las letra recolocadas.
                   presente=true;
                 }
                 contador++;
              System.out.println(cadena);
              }
              
            }
           
            if(cadena.equals(palabra1)){  //Si el nuevo string cadena es igual a string palabra1 devuelve true.
               return true;
            }
            return false;
    }
    
    
    public String acronimo(String acro){
       String cadena="";
       String primera=""; //donde vamos a guardar la primera letra.
       
       for(int i=0; i<acro.length();i++){
           //si los primeros chars del string no corresponden con ninguno de estos guardamos en primera la primera letra del string.
         if(!acro.substring(0,1).equals("y") && !acro.substring(0,1).equals("e") &&
                 !acro.substring(0,2).equals("de") && !acro.substring(0,2).equals("la") && !acro.substring(0,3).equals("las")){
            primera=acro.substring(0,1);
         }
         //Si nos encontramos un espacio y acto seguido no hay ninguna de esas palabras, suma uno a i y guarda el substring en la posición
         //i,i+1.
         if(acro.charAt(i)==' ' && (!acro.substring(i+1,i+2).equals("y") && !acro.substring(i+1,i+2).equals("e") &&
                 !acro.substring(i+1,i+3).equals("de") && !acro.substring(i+1,i+3).equals("la") && !acro.substring(i+1,i+4).equals("las"))){
          i++;
          cadena+=acro.substring(i,i+1);
         }
           
       }
        //Retornamos la suma del string primera y el string cadena.
       return primera+cadena;
    }
       /*Usar dos bucles for.*/ 
    public String calendario(int n){
       String auxiliar=""; //string donde vamos a guardar el calendario.
       int contador=1; //inicio del calendario.
       
       //Usamos un bucle for anidado.        
        for(int j=0;j<50;j++){
            
         for(int i=0; i<7; i++){
           if(i<n){//si la i es menor al parámetro n que le pasamos, guarda xx espacio en auxiliar.
            auxiliar+="xx ";
           }else {
               //n ya ha hecho su trabajo. Lo ponemos a 0 para que deje de cumplirse la condición anterior.
             n=0; 
             if(contador<10){ //si contador menor que diez, le sumamos a auxiliar un 0, el número de contador y un espacio.
               auxiliar+="0"+contador+" ";
             }else{ //En caso contrario sumamos simplemente contador y el espacio a auxiliar.
             auxiliar+=contador+" ";
             }
             contador++;  //cada vuelta de bucle aumenta el valor de contador en uno. De esta manera imprimimos el calendario.
             if(contador==32){ //Cuando contador llegue a 32
                 while(i<6){ //mientras la i sea menor a 6, imprime XX para poner las xx del final del calendario y suma 1 a i.
                  auxiliar+="xx ";
                  i++;
                 }
                    return auxiliar; //retornamos auxiliar y así el bucle termina.
                } 
         
           }
       
        }
         auxiliar+="\n"; //con esto hacemos el salto de linea al mostrar el resultado por consola.
        }
       
       return auxiliar; //retornamos auxiliar.
    }
    
    public boolean escalera(char listaPalabras){
        System.out.println(listaPalabras);
    return false;
    }
    
     public int costeErrores(String a, String b){
         int auxiliar=0; //declaramos un int auxiliar donde vamos a guardar los valores que nos de el programa.
            
         for(int i=0;i<a.length();i++){
             
           if(a.charAt(i)=='-' || b.charAt(i)=='-'){ //Cuando nos encontremos en cualquiera de los strings con - se añade 2.
              auxiliar+=2;
           }
           if(b.charAt(i)!='-' && (a.charAt(i)=='A' && b.charAt(i)!='T') ||    //En caso de que el string b no sea un - y las parejas
                   b.charAt(i)!='-' && (a.charAt(i)=='T' && b.charAt(i)!='A')){ //no correspondan con el nucleótido, se añade 1.
             auxiliar+=1;
             
           }
           if(b.charAt(i)!='-' && (a.charAt(i)=='C' && b.charAt(i)!='G') ||     //Lo mismo que en el caso anterior.
                   b.charAt(i)!='-' && (a.charAt(i)=='G' && b.charAt(i)!='C')){
             auxiliar+=1;
             
           }
         }
         
         return auxiliar;
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
      
      /*EjerciciosJava ejercicio4= new EjerciciosJava();
      String palabra1="amoro";
      String palabra2="morao";
      System.out.println(ejercicio4.anagrama(palabra1,palabra2));*/
      
      
      /*EjerciciosJava ejercicio5=new EjerciciosJava();
      //String acro="Alta Velocidad Española";
      String acro="Tecnología de la Información y de las Comunicaciones";
      System.out.println(ejercicio5.acronimo(acro));
    */
       
   /* EjerciciosJava ejercicio6=new EjerciciosJava();
      int n=6;
      System.out.println(ejercicio6.calendario(n));*/
      
     /* EjerciciosJava ejercicio7=new EjerciciosJava();
      	char	[][]	listaPalabras	={
					{'P',	'A',	'T',	'A'},
					{'P',	'A',	'T',	'O'},
					{'R',	'A',	'T',	'O'},
					{'R',	'A',	'M',	'O'},
					{'G',	'A',	'M',	'O'},
					{'G',	'A',	'T',	'O'},
					{'M',	'A',	'T',	'O'},
								};
       // System.out.println(ejercicio7.escalera(listaPalabras));*/
       
       EjerciciosJava ejercicio8=new EjerciciosJava();
       //String a="ACGT";
       //String b="TGCA";
       //String a="A-C-G-T-ACGT";
       //String b="TTGGCCAATGCA";
       String a="GGGA-GTATATCTGGACT"; //Esta cadena no es la original del enunciado. Se ha modificado para hacer pruebas y el
       String b="CCCTACTTA-AGA-CGGA"; //resultado que da es 8 puesto que tiene 3 nucleótidos desparejados y 2 mutaciones.
       System.out.println(ejercicio8.costeErrores(a, b));
      
}
    
}
