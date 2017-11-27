<<<<<<< HEAD
package proyectoIII.tomaInfo;

import java.util.ArrayList;
import java.util.List;

import proyectoIII.registro.ListaEnlazada;

public class SimuladorServer {
	
	List<String> listaM = new ArrayList<String>();
	List<String> listaC = new ArrayList<String>();
	static InfoServer SendFromServer = new InfoServer();
	public static ListaEnlazada<String> listaMensajes = new ListaEnlazada<String>();
	public static ListaEnlazada<String> listaContactos = new ListaEnlazada<String>();
	
	
	public void AgregarInfo() {
		
		listaM.add("a");
		listaM.add("b");
		listaM.add("c");
		listaM.add("d");
		listaM.add("e");
		listaM.add("f");
		listaM.add("g");
		
		
		listaC.add("Juan");
		listaC.add("Juancho");
		listaC.add("Alo");
		listaC.add("Pancho");
		listaC.add("Paco");
		
		sendInfoMensajes();
		sendDispositivos();
		
	}
	
	
	public void sendInfoMensajes() {
		for (String t: listaM) {
			listaMensajes.insertarFinal(t);
		}
		
		
		SendFromServer.getInfoMensajes(listaMensajes);
	}
	
	public void sendDispositivos() {
		for(String i: listaC) {
			listaContactos.insertarFinal(i);
		}
		
		SendFromServer.getContactos(listaContactos);
		
	}
		
}
=======
package proyectoIII.tomaInfo;

import java.util.ArrayList;
import java.util.List;

import proyectoIII.registro.ListaEnlazada;

public class SimuladorServer {
	
	List<String> listaM = new ArrayList<String>();
	List<String> listaC = new ArrayList<String>();
	static InfoServer SendFromServer = new InfoServer();
	public static ListaEnlazada<String> listaMensajes = new ListaEnlazada<String>();
	public static ListaEnlazada<String> listaContactos = new ListaEnlazada<String>();
	
	
	public void AgregarInfo() {
		
		listaM.add("a");
		listaM.add("b");
		listaM.add("c");
		listaM.add("d");
		listaM.add("e");
		listaM.add("f");
		listaM.add("g");
		
		
		listaC.add("Juan");
		listaC.add("Juancho");
		listaC.add("Alo");
		listaC.add("Pancho");
		listaC.add("Paco");
		
		sendInfoMensajes();
		sendDispositivos();
		
	}
	
	
	public void sendInfoMensajes() {
		for (String t: listaM) {
			listaMensajes.insertarFinal(t);
		}
		
		
		SendFromServer.getInfoMensajes(listaMensajes);
	}
	
	public void sendDispositivos() {
		for(String i: listaC) {
			listaContactos.insertarFinal(i);
		}
		
		SendFromServer.getContactos(listaContactos);
		
	}
		
}
>>>>>>> 51c485d4905c5841efaf8d425e0d576c81422589
