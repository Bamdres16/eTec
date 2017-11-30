package com.tec.baseDatos;



public class ListaEnlazada<M> {
	
	private NodoMensajes<M> primero;
	int indice;

	
	public ListaEnlazada (){
		this.primero = null;
	}
	
	public NodoMensajes<M> getPrimero() {
		return primero;
	}
	
	public void setFirst(NodoMensajes<M> primero){
		this.primero = primero;
	}
	
	public void insertarFinal(M id){
		if (this.primero == null){
			this.primero = new NodoMensajes<M> (id);
			
			
		} else{
			NodoMensajes<M> temporal = this.primero;
			while (temporal.getSiguiente()!= null){
				temporal = temporal.getSiguiente();
				
			}
			temporal.setSiguiente(new NodoMensajes<M>(id));
			
		}
	}
	
	public void mostrar(){
		NodoMensajes<M> temp = this.primero;
		
		while(temp != null){
		
			System.out.println(temp.getValor());
			
			temp = temp.getSiguiente();
		}
		
		
	}
	
	public void eliminar(){
		NodoMensajes<M> temp = this.primero;

		while(temp.getSiguiente().getSiguiente() != null){
			temp = temp.getSiguiente();
		}
		temp.setSiguiente(null);
	}

}
