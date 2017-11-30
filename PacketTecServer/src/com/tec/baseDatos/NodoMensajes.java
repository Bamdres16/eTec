package com.tec.baseDatos;



public class NodoMensajes<R> {
	private NodoMensajes<R> siguiente;
	private R valor;
	
	public NodoMensajes(R valor){
		this.valor = valor;
		this.siguiente = null;
	}
	
	public NodoMensajes(R valor, NodoMensajes<R> siguiente){
		this(valor);
		this.siguiente = siguiente;
	}
	
	


	public NodoMensajes<R> getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoMensajes<R> siguiente) {
		this.siguiente = siguiente;
	}
	public R getValor() {
		return valor;
	}
	public void setValor(R valor) {
		this.valor = valor;
	}
	
	
	

	

}
