<<<<<<< HEAD
package proyectoIII.tomaInfo;

import proyectoIII.registro.ListaEnlazada;
import proyectoIII.registro.NodoMensajes;

public class InfoServer {
	NodoMensajes<String> current;
	NodoMensajes<String> temp;
	
	public void getInfoMensajes(ListaEnlazada<String> listaMensajes) {
		current = listaMensajes.getPrimero();
		while (current != null) {
			System.out.println("/");
			System.out.println(current.getValor());
			System.out.println("/");
			current = current.getSiguiente();
		}
		
	}
	
	public void getContactos(ListaEnlazada<String> listaContactos) {
		temp = listaContactos.getPrimero();
		while (temp != null) {
			System.out.println("/");
			System.out.println(temp.getValor());
			System.out.println("/");
			temp = temp.getSiguiente();
		}
		
	}
	

}
=======
package proyectoIII.tomaInfo;

import proyectoIII.registro.ListaEnlazada;
import proyectoIII.registro.NodoMensajes;

public class InfoServer {
	NodoMensajes<String> current;
	NodoMensajes<String> temp;
	
	public void getInfoMensajes(ListaEnlazada<String> listaMensajes) {
		current = listaMensajes.getPrimero();
		while (current != null) {
			System.out.println("/");
			System.out.println(current.getValor());
			System.out.println("/");
			current = current.getSiguiente();
		}
		
	}
	
	public void getContactos(ListaEnlazada<String> listaContactos) {
		temp = listaContactos.getPrimero();
		while (temp != null) {
			System.out.println("/");
			System.out.println(temp.getValor());
			System.out.println("/");
			temp = temp.getSiguiente();
		}
		
	}
	

}
>>>>>>> 51c485d4905c5841efaf8d425e0d576c81422589
