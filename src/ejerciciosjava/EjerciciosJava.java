/*
 * Autor; Marta Márquez Olalla
   Ejercicios básicos de Java.
 */
package ejerciciosjava;

import java.util.Arrays;


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
    
    //Ejercicio del isograma.
    
    public boolean isograma(String iso){
        String cadena = " ";//Guardaremos los chars a comprobar.
        cadena=cadena.toLowerCase();//ponemos el stirng a lowercase para evitar problemas con mayúsculas.
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
     
    //Ejercicio del acrónimo.
    
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
       //Ejercicio del calendario.
    
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
    
    //Ejercicio de la cadena de palabras.
    
    public boolean escalera(char[][] listaPalabras){
        boolean presente=false;  //Declaramos un booleano que nos va a ayudar a determinar cuantas letras cambian.
        
       for(int j=0;j<listaPalabras.length;j++){
           presente=false; //El booleano se inicia a false cada vez que demos una vuelta del bucle externo.
        for(int i=0;i<listaPalabras[i].length;i++){
            if(j+1<listaPalabras.length && presente==true && listaPalabras[j][i]!=listaPalabras[j+1][i]){ 
               return false;  //La primera condición protege de outofbounds. El booleano comprueba si hay chars distintos en
            }                 //filas consiguientes cuando ya se ha detectado un char distinto. Retorna false en ese caso.
            
            if(j+1<listaPalabras.length && listaPalabras[j][i]!=listaPalabras[j+1][i]){
              presente=true; //La primera condición nos protege del outofbounds. Comprueba si hay chars distintos en filas
           }                 //consiguientes y situa el booleano a true en caso de hayarlo.
            
            
           System.out.println(listaPalabras[j][i]);  //Comprobación en consola.
        }
       }
    return true;  //Una vez que hayamos terminado el bucle y este no haya retornado false por no haber encontrado
                  //la condición, devuelve true.
    }
    
    //Ejercicio de la cadena de ADN.
    
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
         
         return auxiliar; //Retornamos el valor que nos haya dado el programa.
       }
     
    //Ejercicio de strstr. String y substring.
     
     public int strstr(String str1, String str2){
        String toLowerCase = str1.toLowerCase();  //Ponemos los strings a lowercase para evitar problemas.
        String toLowerCase1 = str2.toLowerCase();
         int auxiliar=0;  //Declaramos el auxiliar donde vamos a guardar el resultado.
         int pos=0; //Declaramos un segundo int que será la posición de los char en el segundo string.
         
         for(int i=0; i<str1.length();i++){
           if(str1.charAt(i)==str2.charAt(pos) && str1.contains(str2)){  //En caso que encontremos el substring, devuelve la posición donde
             auxiliar=i;                                                 //se encuentra el primer char del substring.
           }else{
            auxiliar=-1;                                                 //En caso contrario el int auxiliar lo pasamos a -1.
           }
         
         }
    
         return auxiliar; //Retornamos el auxiliar con la posición del substring o con -1 en caso de no haber substring.
     }
     
     public boolean mudanzasJava(boolean[][] camion, int ancho, int alto){
         int a=0;
         int b=0;
         
         for(int j=0;j<camion.length;j++){
            for(int i=0;i<camion[0].length;i++){
              while(j+1<camion.length && camion[j][i]==false){
                  b+=10;

                  while(i+1<camion[0].length && camion[j][i]==false){
                   a+=10;
                   i++;
                   j++;
                   
                 }
              }  
            }
         }
         
         if(a==ancho && b==alto || a==alto && b==ancho){
            return true;
         }else{
           return false;
         }
         
     }
     
     public int rpn (String[] cadena){ 
         int[] auxiliar={0,0,0,0,0,0,0,0,0}; //Declaramos un array de ints donde vamos a guardar los valores y resultados de operaciones
         int contador=0; //posición en el array vacío (auxiliar).
         int operacion=0; //Donde vamos a hacer los cálculos.
         int aux=0;
         boolean fallo=false; //booleano que vamos a usar en caso de error.
         
         for(int i=0;i<cadena.length;i++){
             if(contador>=3 && (!cadena[i].equals("+") && !cadena[i].equals("-") && !cadena[i].equals("*") && !cadena[i].equals("/"))){
                System.out.println("error!"); //Mensaje de error en caso que no se pueda hacer una operación.
                fallo=true; //fallo lo ponemos a true.
             }
            if(!cadena[i].equals("+") && !cadena[i].equals("-") && !cadena[i].equals("*") && !cadena[i].equals("/")){
                    aux=Integer.valueOf(cadena[i]); //Cuando nos encontremos con un número le cambiamos el valor de String a int
                    auxiliar[contador]+=aux; //Guardamos el valor en el array de ints que hemos declarado.
                    contador++; //Sumamos uno a contador.
                    
            }else{ //En caso que nos encontremos con un operador.
              if(cadena[i].equals("+")){
                 operacion=auxiliar[contador-2]+auxiliar[contador-1]; //Cogeremos los dos valores guardados en la pila y haremos la operación.
                 auxiliar[contador-2]=0; //Sacamos los dos valores de la pila situando su valor en las posiciones correctas a 0.
                 auxiliar[contador-1]=0;
                 contador-=2; //Contador lo reseteamos a la posición del primer número de la operación.
                 auxiliar[contador]=operacion; //Guardamos en esa posición el valor que nos ha dado la operación.
                 contador++; //Sumamos 1 a contador para poder guardar valores en la siguente posición en el array.
                 
              }        
              if(cadena[i].equals("*")){
                 operacion=auxiliar[contador-2]*auxiliar[contador-1];
                 auxiliar[contador-2]=0;
                 auxiliar[contador-1]=0;
                 contador-=2;
                 auxiliar[contador]=operacion;
                 contador++;
                 
              }
              if(cadena[i].equals("-")){
                 operacion=auxiliar[contador-2]-auxiliar[contador-1];
                 auxiliar[contador-2]=0;
                 auxiliar[contador-1]=0;
                 contador-=2;
                 auxiliar[contador]=operacion;
                 contador++;
              }
              if(cadena[i].equals("/")){
                 operacion=auxiliar[contador-2]/auxiliar[contador-1];
                 auxiliar[contador-2]=0;
                 auxiliar[contador-1]=0;
                 contador-=2;
                 auxiliar[contador]=operacion;
                 contador++;
              }
              
              
            }
         
         }
        
         if(fallo==true){ //En caso que hayamos encontrado un fallo, retornamos 0.
           return 0;     
         }else{
         return operacion; //Retornamos el valor de la operación.
         }
     
     }
     
     //Clash Royale
         public boolean chequeaAtaque(int[][] piezas, int ataque) {

        for (int j = 0; j < piezas.length; j++) {
            for (int i = 0; i < piezas[0].length; i++) {

                if (j != ataque && piezas[j][6]==0) {
                    if (piezas[ataque][2] == piezas[j][2] && piezas[ataque][3] == piezas[j][3]) {

                        piezas[j][1] = -4;
                    }

                    if ((piezas[j][2] == piezas[ataque][2] - 1 && piezas[j][3] == piezas[ataque][3] - 1)
                            || (piezas[j][2] == piezas[ataque][2] + 1 && piezas[j][3] == piezas[ataque][3] - 1)
                            || (piezas[j][2] == piezas[ataque][2] - 1 && piezas[j][3] == piezas[ataque][3] + 1)
                            || (piezas[j][2] == piezas[ataque][2] + 1 && piezas[j][3] == piezas[ataque][3] + 1)) {

                        piezas[j][1] = -1;
                    }
                    if ((piezas[j][2] == piezas[ataque][2] - 1 && piezas[j][3] == piezas[ataque][3])
                            || (piezas[j][2] == piezas[ataque][2] + 1 && piezas[j][3] == piezas[ataque][3])
                            || (piezas[j][2] == piezas[ataque][2] && piezas[j][3] == piezas[ataque][3] - 1)
                            || (piezas[j][2] == piezas[ataque][2] && piezas[j][3] == piezas[ataque][3] + 1)) {

                        piezas[j][1] = -2;
                    }

                    if (piezas[j][1] < 0) {
                        return true;
                    }
                    
                    System.out.println(piezas[j][1]);
                }
            }
        }

        return false;

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
        System.out.println(ejercicio7.escalera(listaPalabras));*/
       
      /* EjerciciosJava ejercicio8=new EjerciciosJava();
       //String a="ACGT";
       //String b="TGCA";
       //String a="A-C-G-T-ACGT";
       //String b="TTGGCCAATGCA";
       String a="GGGA-GTATATCTGGACT"; //Esta cadena no es la original del enunciado. Se ha modificado para hacer pruebas y el
       String b="CCCTACTTA-AGA-CGGA"; //resultado que da es 8 puesto que tiene 3 nucleótidos desparejados y 2 mutaciones.
       System.out.println(ejercicio8.costeErrores(a, b));*/
      
      /*EjerciciosJava ejercicio9=new EjerciciosJava();
      String str1="variable";
      String str2="ajo";
      System.out.println(ejercicio9.strstr(str1,str2));*/
      
      /*EjerciciosJava ejercicio10=new EjerciciosJava();
      int ancho=20;
      int alto=30;
      boolean[][] camion={
			 {true,	true,	true,	false,	false,	true,	true,	true},
			 {true,	true,	true,	false,	false,	true,	true,	true},
			 {true,	true,	true,	false,	false,	true,	true,	true},
			 {true,	true,	true,	true,	true,	true,	false,	false },
			 {true,	true,	true,	true,	true,	true,	false,	false }
								};
      System.out.println(ejercicio10.mudanzasJava(camion, ancho, alto));*/
     
    /* EjerciciosJava ejercicio11= new EjerciciosJava();
     String[] cadena={"3","2","+","7","*","15","21","-","-"};
     System.out.println(ejercicio11.rpn(cadena));*/
    
    EjerciciosJava ejercicio12= new EjerciciosJava();
    int[][] arena= new int[14][18];
    int[][] piezas={
                   {2, 211, 9, 3, 1, 1, 0},
                   {67, 950, 9, 4, 1, 1, 1},
                   {257, 100, 9, 4, 0, 0, 0}
                      };
    System.out.println(ejercicio12.chequeaAtaque(piezas, 2));
      
}
    
}
