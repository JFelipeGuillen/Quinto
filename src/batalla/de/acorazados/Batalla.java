//INTEGRANTES:

//Guillén Mirabá José Felipe    
//Quimis Mendoza Jonathan Andy
//Victor Hugo Varas Roca

//CURSO:
//2-2

package batalla.de.acorazados;

abstract class Batalla {
public static int[][] Barcos=new int[10][10];
private static int BarcosPersona=0;
private static int BarcosCompu=0;
public static void destruirBarJug(){
BarcosPersona--;
}
public static void destruirBarCom(){
BarcosCompu--;
}
public static void colocarBarJug(){
BarcosPersona++;
}
public static void colocarBarCom(){
BarcosCompu++;
}
public static int getBarJug(){
return BarcosPersona;
}
public static int getBarCom(){
return BarcosCompu;
}
public static void reubicar(){
BarcosCompu=0;
BarcosPersona=0;
}
}
