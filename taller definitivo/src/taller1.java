import ucn.*;
import java.io.IOException;
import java.util.Random;
public class taller1 {
	
public static void main(String[] args) throws IOException {
		//Vectores de entrada
		 String[] luchadores = new String[1000];
		 String[] genero = new String[1000];
		 String[] estatus = new String[1000];
		 String[] marca = new String[1000];
		    int[] POW = new int[1000];
		    int[] TGH = new int[1000];
		    int[] SPD = new int[1000];
		    int[] CHA = new int[1000];
		 String[] especialidad = new String[1000];
		 String[] nombreDelLuchadorSeleccionado = new String[1000];
		 String[] nombreDelOponente = new String[1000];
		 String[] tipoDeLucha = new String[1000];
		 String[] resultados = new String[1000];
		 
		int contador = cargarDatos(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad);
		menuPrincipal(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador,nombreDelLuchadorSeleccionado,nombreDelOponente,tipoDeLucha,resultados);

	}//Main

public static int cargarDatos(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[]) throws IOException{
		ArchivoEntrada roster = new ArchivoEntrada("RosterWWE.txt");
		int contador = 0;
		for (int i = 0; !roster.isEndFile(); i++) {
			Registro reg = roster.getRegistro();
			luchadores[contador] = reg.getString();
			genero[contador] = reg.getString();
			estatus[contador] = reg.getString();
			marca[contador] = reg.getString();
			POW[contador] = reg.getInt();
			TGH[contador] = reg.getInt();
			SPD[contador] = reg.getInt();
			CHA[contador] = reg.getInt();
			especialidad[contador] = reg.getString();
			contador ++;
			}//Ciclo for para cargar datos
		roster.close();
	    return contador;
	}//Cargar los datos del taller

public static void menuPrincipal(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador,String nombreDelLuchadorSeleccionado[],String nombreDelOponente[],String tipoDeLucha[],String resultados[]) throws IOException{
	boolean menu = true;
	StdOut.println("Bienvenido a WWE FuX Edition");	
	while(menu){
		StdOut.println("Menu Principal :");
		StdOut.println("1.-Desplegar Luchadores\n2.-Ordenar Base de Datos\n3.-WWE Wargame Alfa\n4.-Cerrar Programa\n");
		StdOut.println("Escriba el numero de la opcion que desee y presion enter:");
		String opcion = StdIn.readString() + StdIn.readLine();
		try{
			Integer.parseInt(opcion);
		}catch(NumberFormatException ex){
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		int opcionDef = Integer.parseInt(opcion);
		if (opcionDef >= 5 || opcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 4 porfavor");
			continue;
			}
		switch(opcionDef){
		case 1:
			subMenu1(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			subMenu2(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);			
			break;
		case 3 :
			wweWargame(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador,nombreDelLuchadorSeleccionado,nombreDelOponente,tipoDeLucha,resultados);	
			break;
		case 4:	
			break;
		}
		
		if(opcionDef == 4){
			break;
		}
	}//Fin del while
	
}//Menu Principal

public static void subMenu1(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	boolean submenu = true;
	StdOut.println("Escogio la opcion desplegar luchadores");	
	while(submenu){
		StdOut.println("Elija una de las siguientes opciones:");
		StdOut.println(
				"1.-Desplegar todos los luchadores actuales\n2.-Desplegar por marca\n3.-Desplegar segun estatus\n4.-Salir\n");
		String subopcion = StdIn.readString() + StdIn.readLine();
		try {
			Integer.parseInt(subopcion);
		} catch (NumberFormatException ex) {
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		int subopcionDef = Integer.parseInt(subopcion);
		if (subopcionDef >= 5 || subopcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		switch(subopcionDef){
		case 1:
			imprimirLuchadores(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			subMenu1Marcas(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 3 :
			subMenu1Estatus(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 4:
			StdOut.println("Volviendo al Menu Principal......");
			break;
		}
		if(subopcionDef == 4){
			break;
		}
	}
}//Submenu de la opcion "Desplegar Luchadores"

public static void imprimirLuchadores(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
		StdOut.println("Luchadores:");
		for (int i = 0; i<contador ; i++) {
			StdOut.println("-" + luchadores[i]);
		}
	StdOut.println("Volviendo al submenu...");
}//Imprime los luchadores

public static void subMenu1Marcas(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	boolean subMenuMarca = true;
	StdOut.println("Escogio la opcion desplegar por marca");	
	while(subMenuMarca){
		StdOut.println("Seleccione Marca:");
		StdOut.println("1.-RAW\n2.-SMACKDOWN\n3.-NXT");
		String subopcion = StdIn.readString() + StdIn.readLine();
		try {
			Integer.parseInt(subopcion);
		} catch (NumberFormatException ex) {
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 3 porfavor");
			continue;
		}
		int subopcionDef = Integer.parseInt(subopcion);
		if (subopcionDef >= 4 || subopcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 3 porfavor");
			continue;
		}
		switch(subopcionDef){
		case 1:
			RAW(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			smackdown(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 3 :
			NXT(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		}
		if(subopcionDef == 1||subopcionDef == 2||subopcionDef == 3){
			break;
		}
	}
}//Submenu de las marcas

public static void RAW(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Luchadores de RAW:");
	for (int i = 0; i<contador ; i++) {
		if (marca[i].equalsIgnoreCase("RAW") ){
			StdOut.println(luchadores[i]+"-"+estatus[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);
		     
		}
	}
StdOut.println("Volviendo al submenu...");
}//RAW

public static void smackdown(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Luchadores de Smackdown:");
	for (int i = 0; i<contador ; i++) {
		if (marca[i].equalsIgnoreCase("Smackdown") ){
			StdOut.println(luchadores[i]+"-"+estatus[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);		     
		}
	}
	StdOut.println("Volviendo al submenu...");
}//Smackdown

public static void NXT(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Luchadores de NXT:");
	for (int i = 0; i<contador ; i++) {
		if (marca[i].equalsIgnoreCase("NXT") ){
			StdOut.println(luchadores[i]+"-"+estatus[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);		     
		}
	}

}//NXT

public static void subMenu1Estatus(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	boolean subMenuMarca = true;
	StdOut.println("Escogio la opcion desplegar por estatus");	
	while(subMenuMarca){
		StdOut.println("Seleccione estatus:");
		StdOut.println("1.-Leyenda\n2.-Superestrella\n3.-Midcarter\n4.-Jobber");
		String subopcion = StdIn.readString() + StdIn.readLine();
		try {
			Integer.parseInt(subopcion);
		} catch (NumberFormatException ex) {
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		int subopcionDef = Integer.parseInt(subopcion);
		if (subopcionDef >= 5 || subopcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		switch(subopcionDef){
		case 1:
			leyenda(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			superestrella(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 3 :
			midcarter(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 4 :
			jobber(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
		}
		if(subopcionDef == 1||subopcionDef == 2||subopcionDef == 3||subopcionDef == 4){
			break;
		}
	}
}//Submenu de los estatus

public static void leyenda(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Leyendas:");
	for (int i = 0; i<contador ; i++) {
		if (estatus[i].equalsIgnoreCase("Leyenda") ){
			StdOut.println(luchadores[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);
		}
	}
StdOut.println("Volviendo al submenu...");
}//Leyenda		

public static void superestrella(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Superestrellas:");
	for (int i = 0; i<contador ; i++) {
		if (estatus[i].equalsIgnoreCase("Superestrella") ){
			StdOut.println(luchadores[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);		     
		}
	}
StdOut.println("Volviendo al submenu...");
}//Superestrella

public static void midcarter(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Midcarters:");
	for (int i = 0; i<contador ; i++) {
		if (estatus[i].equalsIgnoreCase("Midcarter") ){
			StdOut.println(luchadores[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);		     
		}
	}
StdOut.println("Volviendo al submenu...");
}//Midcarter

public static void jobber(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	StdOut.println("Jobbers:");
	for (int i = 0; i<contador ; i++) {
		if (estatus[i].equalsIgnoreCase("Jobber") ){
			StdOut.println(luchadores[i]+"-"+"POW "+""+POW[i]+""+" TGH "+""+TGH[i]+""+" SPD "+""+SPD[i]+""+" CHA "+CHA[i]+"-"+"Especialidad:"+""+especialidad[i]);		     
		}
	}
StdOut.println("Volviendo al submenu...");
}//Jobber

public static void subMenu2(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	boolean submenu = true;
	StdOut.println("Escogio la opcion ordenar base de datos");	
	while(submenu){
		StdOut.println("Elija una de las siguientes opciones:");
		StdOut.println(
				"1.-Ordenar luchadores alfabeticamente por Nombre (A-Z) \n2.-Ordenar luchadores segun stat (De menos a mas) ");
		String subopcion = StdIn.readString() + StdIn.readLine();
		try {
			Integer.parseInt(subopcion);
		} catch (NumberFormatException ex) {
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 2 porfavor");
			continue;
		}
		int subopcionDef = Integer.parseInt(subopcion);
		if (subopcionDef >= 5 || subopcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 2 porfavor");
			continue;
		}
		switch(subopcionDef){
		case 1:
			ordenarAlfabeticamente(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			ordenarStat(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		}
		if(subopcionDef == 1||subopcionDef ==2){
			break;
		}
	}
}//Submenu2

public static void ordenarAlfabeticamente(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	for(int i=0;i<contador;i++){
		for(int j=i+1;j<contador;j++){
		if(luchadores[i].compareToIgnoreCase(luchadores[j])<0){
			String aux = luchadores[i];
			luchadores[i] = luchadores[j];
			luchadores[j] = aux;
			 aux = genero[i];
			genero[i] = genero[j];
			genero[j] = aux;
			 aux = estatus[i];
			estatus[i] = estatus[j];
			estatus[j] = aux;
			 aux = marca[i];
			marca[i] = marca[j];
			marca[j] = aux;
			int aux2 = POW[i];
			POW[i] = POW[j];
			POW[j] = aux2;
			 aux2 = TGH[i];
			TGH[i] = TGH[j];
			TGH[j] = aux2;
			 aux2 = SPD[i];
			SPD[i] = SPD[j];
			SPD[j] = aux2;
			 aux2 = CHA[i];
			CHA[i] = CHA[j];
			CHA[j] = aux2;
		}
	}
		}
}//Ordenar alfabeticamente

public static void ordenarStat(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	boolean submenu = true;
	StdOut.println("Escogio la opcion ordenar por estatus");	
	while(submenu){
		StdOut.println("Elija un estatus:");
		StdOut.println(
				"1.-POW(Poder) \n2.-TGH(Dureza)\n3.-SPD(Velocidad)\n4.-CHA(Carisma)");
		String subopcion = StdIn.readString();
		try {
			Integer.parseInt(subopcion);
		} catch (NumberFormatException ex) {
			StdOut.println("Error,No escribio un numero, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		int subopcionDef = Integer.parseInt(subopcion);
		if (subopcionDef >= 5 || subopcionDef <= 0) {
			StdOut.println("Error, Escoja una numero entre 1 y 4 porfavor");
			continue;
		}
		switch(subopcionDef){
		case 1:
			POW(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 2:	
			TGH(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 3:
			SPD(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		case 4:
			CHA(luchadores,genero,estatus,marca,POW,TGH,SPD,CHA,especialidad,contador);
			break;
		}
		if(subopcionDef == 1||subopcionDef ==2||subopcionDef == 3||subopcionDef == 4){
			break;
		}
	}
}

public static void POW(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	for(int i=0;i<contador;i++){
		for(int j=i+1;j<contador;j++){
		if(POW[i]>POW[j]){
			String aux = luchadores[i];
			luchadores[i] = luchadores[j];
			luchadores[j] = aux;
			 aux = genero[i];
			genero[i] = genero[j];
			genero[j] = aux;
			 aux = estatus[i];
			estatus[i] = estatus[j];
			estatus[j] = aux;
			 aux = marca[i];
			marca[i] = marca[j];
			marca[j] = aux;
			int aux2 = POW[i];
			POW[i] = POW[j];
			POW[j] = aux2;
			 aux2 = TGH[i];
			TGH[i] = TGH[j];
			TGH[j] = aux2;
			 aux2 = SPD[i];
			SPD[i] = SPD[j];
			SPD[j] = aux2;
			 aux2 = CHA[i];
			CHA[i] = CHA[j];
			CHA[j] = aux2;
		}
	}
		}
	StdOut.println("Se han ordenado los luchadores segun su poder");
	StdOut.println("Volviendo al menu principal...");
}

public static void TGH(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	for(int i=0;i<contador;i++){
		for(int j=i+1;j<contador;j++){
		if(TGH[i]>TGH[j]){
			String aux = luchadores[i];
			luchadores[i] = luchadores[j];
			luchadores[j] = aux;
			 aux = genero[i];
			genero[i] = genero[j];
			genero[j] = aux;
			 aux = estatus[i];
			estatus[i] = estatus[j];
			estatus[j] = aux;
			 aux = marca[i];
			marca[i] = marca[j];
			marca[j] = aux;
			int aux2 = POW[i];
			POW[i] = POW[j];
			POW[j] = aux2;
			 aux2 = TGH[i];
			TGH[i] = TGH[j];
			TGH[j] = aux2;
			 aux2 = SPD[i];
			SPD[i] = SPD[j];
			SPD[j] = aux2;
			 aux2 = CHA[i];
			CHA[i] = CHA[j];
			CHA[j] = aux2;
		}
	}
		}
	StdOut.println("Se han ordenado los luchadores segun su dureza");
	StdOut.println("Volviendo al menu principal...");
}

public static void SPD(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	for(int i=0;i<contador;i++){
		for(int j=i+1;j<contador;j++){
		if(SPD[i]>SPD[j]){
			String aux = luchadores[i];
			luchadores[i] = luchadores[j];
			luchadores[j] = aux;
			 aux = genero[i];
			genero[i] = genero[j];
			genero[j] = aux;
			 aux = estatus[i];
			estatus[i] = estatus[j];
			estatus[j] = aux;
			 aux = marca[i];
			marca[i] = marca[j];
			marca[j] = aux;
			int aux2 = POW[i];
			POW[i] = POW[j];
			POW[j] = aux2;
			 aux2 = TGH[i];
			TGH[i] = TGH[j];
			TGH[j] = aux2;
			 aux2 = SPD[i];
			SPD[i] = SPD[j];
			SPD[j] = aux2;
			 aux2 = CHA[i];
			CHA[i] = CHA[j];
			CHA[j] = aux2;
		}
	}
		
		}
	StdOut.println("Se han ordenado los luchadores segun su velocidad");
	StdOut.println("Volviendo al menu principal...");
}

public static void CHA(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador) throws IOException{
	for(int i=0;i<contador;i++){
		for(int j=i+1;j<contador;j++){
		if(CHA[i]>CHA[j]){
			String aux = luchadores[i];
			luchadores[i] = luchadores[j];
			luchadores[j] = aux;
			 aux = genero[i];
			genero[i] = genero[j];
			genero[j] = aux;
			 aux = estatus[i];
			estatus[i] = estatus[j];
			estatus[j] = aux;
			 aux = marca[i];
			marca[i] = marca[j];
			marca[j] = aux;
			int aux2 = POW[i];
			POW[i] = POW[j];
			POW[j] = aux2;
			 aux2 = TGH[i];
			TGH[i] = TGH[j];
			TGH[j] = aux2;
			 aux2 = SPD[i];
			SPD[i] = SPD[j];
			SPD[j] = aux2;
			 aux2 = CHA[i];
			CHA[i] = CHA[j];
			CHA[j] = aux2;
		}
	}
		}
	StdOut.println("Se han ordenado los luchadores segun su carisma");
	StdOut.println("Volviendo al menu principal...");
}
/**
 * 
 * @param luchadores
 * @param genero
 * @param estatus
 * @param marca
 * @param POW
 * @param TGH
 * @param SPD
 * @param CHA
 * @param especialidad
 * @param contador
 * @throws IOException
 */
public static void wweWargame(String luchadores[],String genero[],String estatus[],String marca[],int POW[],int TGH[],int SPD[],int CHA[],String especialidad[],int contador,String nombreDelLuchadorSeleccionado[],String nombreDelOponente[],String tipoDeLucha[],String resultados[]) throws IOException{
	StdOut.println("Bienvenido a WWE wargame alfa");
	StdOut.println("En este minijuego");
	boolean lucha = true;
	String luchadoresDelAlfa[] = new String[3];
	for(int i=0;i<3;i++){
		StdOut.println("Ingrese luchador"+(i+1)+":");
		while(lucha){		
			luchadoresDelAlfa[i] = StdIn.readString() + StdIn.readLine();
			try{
				Integer.parseInt(luchadoresDelAlfa[i]);
				StdOut.println("Error, escribio un numero, ingrese un luchador porfavor");
				StdOut.println("Ingrese luchador "+(i+1)+" :");
				continue;
				
			}catch(NumberFormatException ex){
				StdOut.println("Luchador "+(i+1)+" seleccionado");
				StdOut.println("Buscando luchador seleccionado...");
				int j;
				for(j=0;j<contador;j++){
					if(luchadores[j].equalsIgnoreCase(luchadoresDelAlfa[i])){
						StdOut.println("Luchador encontrado");
						break;
					}
				}
				if(i==1){
				if(luchadoresDelAlfa[1].equalsIgnoreCase(luchadoresDelAlfa[0])){
					StdOut.println("Error, a elegido al mismo luchador 2 veces");
					StdOut.println("Ingrese luchador "+(i+1)+":");
					continue;
				}
				}
				if(i==2){
				if(luchadoresDelAlfa[2].equalsIgnoreCase(luchadoresDelAlfa[1])){
					StdOut.println("Error, a elegido al mismo luchador 2 veces");
					StdOut.println("Ingrese luchador "+(i+1)+":");
					continue;
				}
				if(luchadoresDelAlfa[2].equalsIgnoreCase(luchadoresDelAlfa[0])){
					StdOut.println("Error, a elegido al mismo luchador 2 veces");
					StdOut.println("Ingrese luchador "+(i+1)+":");
					continue;
				}
				}
				if(j==contador){
					StdOut.println("Luchador no encontrado");
					StdOut.println("Ingrese luchador "+(i+1)+" :");
					continue;
				}
				break;
			}
			
			}
			
		}//Fin de escoger luchadores
	for(int i=0;i<3;i++){
		for(int j=0;j<contador;j++){
			if(luchadores[j].equalsIgnoreCase(luchadoresDelAlfa[i])){
				StdOut.println(luchadores[j]+"-"+genero[j]+"-"+"POW "+""+POW[j]+""+" TGH "+""+TGH[j]+""+" SPD "+""+SPD[j]+""+" CHA "+CHA[j]+"-"+"Especialidad:"+""+especialidad[j]);
				break;
			}else{
				continue;
			}
		
		}
	}//Imprimir los luchadores con sus stats
	String batallas[]= new String [4];
	batallas[0] = ("POW");
	batallas[1] = ("TGH");
	batallas[2] = ("SPD");
	batallas[3] = ("CHA");
	Random numeroAzar = new Random();
	int batalla = numeroAzar.nextInt(4);
	StdOut.println("La batalla a pelear sera de: "+batallas[batalla]);
	String luchadorDef = "";
	while(lucha){
		StdOut.println("Escoja uno de los luchadores escogido anteriormente porfavor");
		luchadorDef = StdIn.readString() + StdIn.readLine();
		try{
			Integer.parseInt(luchadorDef);
			StdOut.println("Error, escribio un numero");
			continue;
		}catch(Exception ex){
			if(luchadorDef.equalsIgnoreCase(luchadoresDelAlfa[0])||luchadorDef.equalsIgnoreCase(luchadoresDelAlfa[1])||luchadorDef.equalsIgnoreCase(luchadoresDelAlfa[2])){
				StdOut.println("Luchador "+luchadorDef+" seleccionado");
				break;
			}else{
				StdOut.println("No escogio un luchador valido");
				continue;
			}
			
		}
		
	}//Escoger un luchador de los 3
	Random luchadorAzar = new Random();
	int luchadorX = luchadorAzar.nextInt(contador);
	String luchadorAzarDef = luchadores[luchadorX];	
	String genero1 = "";
	String genero2 = "";
	while(lucha){	
	if(luchadorDef.equalsIgnoreCase(luchadorAzarDef)){
		luchadorX = numeroAzar.nextInt(contador);
		luchadorAzarDef = luchadores[luchadorX];
		continue;
		}
	for(int i=0;i<contador;i++){
		if(luchadores[i].equalsIgnoreCase(luchadorDef)){
			genero1 = genero[i];
		}
		if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
			genero2 = genero[i];
			
		}
	}
	if(genero1.equalsIgnoreCase(genero2)){
		continue;
	}if(genero1.equalsIgnoreCase(genero2)){
		break;
	}
	}//Comparar generos y elegir al luchador al azar
	StdOut.println("El luchador oponente de "+luchadorDef+" es;");
	StdOut.println(luchadorAzarDef);
	int stat1 = 0;
	int stat2 = 0;
	String resultado = "";
	if(batalla == 0){
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				stat1 = POW[i];
			if(especialidad[i].equalsIgnoreCase("POW")){
				stat1 = POW[i]+ 15;
			}
			}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				stat2 = POW[i];
				if(especialidad[i].equalsIgnoreCase("POW")){
					stat2 = POW[i]+ 15;
				}
			}
		}//Si la especialidad es POW, se suman 15 ademas de guardar el stat
		StdOut.println("Las stats de los luchadores son las siguientes:");
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				StdOut.println("El luchador escogido "+luchadorDef+" tiene "+stat1+" de poder(POW)");
				}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				StdOut.println("El luchador oponente "+luchadorAzarDef+" tiene "+stat2+" de poder(POW)");
				}
		}
		if(stat1>stat2){
			StdOut.println("El luchador ganador es: "+luchadorDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Victoria";
		}
		if(stat1<stat2){
			StdOut.println("El luchador ganador es: "+luchadorAzarDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Derrota";
		}
		if(stat1==stat2){
			StdOut.println("Los luchadores han empatado al tener el mismo stat");
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Empate";
		}
	}if(batalla == 1){
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				stat1 = TGH[i];
			if(especialidad[i].equalsIgnoreCase("TGH")){
				stat1 = TGH[i]+ 15;
			}
			}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				stat2 = TGH[i];
				if(especialidad[i].equalsIgnoreCase("TGH")){
				stat2 = TGH[i]+ 15;
				}
			}
		}//Si la especialidad es TGH, se suman 15 ademas de guardar el stat
		StdOut.println("Las stats de los luchadores son las siguientes:");
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				StdOut.println("El luchador escogido "+luchadorDef+" tiene "+stat1+" de dureza(TGH)");
				}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				StdOut.println("El luchador oponente "+luchadorAzarDef+" tiene "+stat2+" de dureza(TGH)");
				}
		}
		if(stat1>stat2){
			StdOut.println("El luchador ganador es: "+luchadorDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Victoria";
		}
		if(stat1<stat2){
			StdOut.println("El luchador ganador es: "+luchadorAzarDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Derrota";
		}
		if(stat1==stat2){
			StdOut.println("Los luchadores han empatado al tener el mismo stat");
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal...");
			resultado = "Empate";
		}
	}
	if(batalla == 2){
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				stat1 = SPD[i];
			if(especialidad[i].equalsIgnoreCase("SPD")){
				stat1 = SPD[i]+ 15;
			}
			}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				stat2 = SPD[i];
				if(especialidad[i].equalsIgnoreCase("SPD")){
					stat2 = SPD[i]+ 15;
				}
			}
		}//Si la especialidad es SPD, se suman 15 ademas de guardar el stat
		StdOut.println("Las stats de los luchadores son las siguientes:");
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				StdOut.println("El luchador escogido "+luchadorDef+" tiene "+stat1+" de velocidad(SPD)");
				}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				StdOut.println("El luchador oponente "+luchadorAzarDef+" tiene "+stat2+" de velocidad(SPD)");
				}
		}
		if(stat1>stat2){
			StdOut.println("El luchador ganador es: "+luchadorDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Victoria";
		}
		if(stat1<stat2){
			StdOut.println("El luchador ganador es: "+luchadorAzarDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Derrota";
		}
		if(stat1==stat2){
			StdOut.println("Los luchadores han empatado al tener el mismo stat");
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Empate";
		}
	}
	if(batalla == 3){
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				stat1 = CHA[i];
			if(especialidad[i].equalsIgnoreCase("CHA")){
				stat1 = CHA[i]+ 15;
			}
			}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				stat2 = CHA[i];
				if(especialidad[i].equalsIgnoreCase("CHA")){
					stat2 = CHA[i]+ 15;
				}
			}
		}//Si la especialidad es CHA, se suman 15 ademas de guardar el stat
		StdOut.println("Las stats de los luchadores son las siguientes:");
		for(int i=0;i<contador;i++){
			if(luchadores[i].equalsIgnoreCase(luchadorDef)){
				StdOut.println("El luchador escogido "+luchadorDef+" tiene "+stat1+" de carisma(CHA)");
				}
			if(luchadores[i].equalsIgnoreCase(luchadorAzarDef)){
				StdOut.println("El luchador oponente "+luchadorAzarDef+" tiene "+stat2+" de carisma(POW)");
				}
		}
		if(stat1>stat2){
			StdOut.println("El luchador ganador es: "+luchadorDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Victoria";
		}
		if(stat1<stat2){
			StdOut.println("El luchador ganador es: "+luchadorAzarDef);
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Derrota";
		}
		if(stat1==stat2){
			StdOut.println("Los luchadores han empatado al tener el mismo stat");
			StdOut.println("Gracias por jugar WWE Wargame Alfa");
			StdOut.println("Volviendo al menu principal");
			resultado = "Empate";
		}
	}
	
}//WarGameAlfa






}//Clase