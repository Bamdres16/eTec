package com.tec.baseDatos;

import org.json.XML;
import org.json.simple.JSONArray;
import org.json.JSONObject;

public class Mensajes {
	
	ListaEnlazada<String> mensajes = new ListaEnlazada<>();

 	NodoMensajes <String> temp;
 	NodoMensajes <String> current;
	String xmlM;
	public static JSONArray mensajesJ = new JSONArray();
	private static org.json.simple.JSONObject resultsM = new org.json.simple.JSONObject();
	
	public void guardarMensajes(org.json.simple.JSONObject mensaje) {
		JSONObject json = new JSONObject(mensaje.toJSONString());
		xmlM = XML.toString(json);
		mensajes.insertarFinal(xmlM);
		
		System.out.println(xmlM);
		
	}
	
	@SuppressWarnings("unchecked")
	public org.json.simple.JSONObject getMensajes() {
		
		temp = mensajes.getPrimero();
		mensajesJ = new JSONArray();
		while (temp != null) {
			System.out.println("Entra al ciclo");
			
			System.out.println(temp.getValor());
			
			JSONObject mensajeJ = XML.toJSONObject(temp.getValor());
			org.json.simple.JSONObject user = new org.json.simple.JSONObject();
			
			user.put("destinatario", mensajeJ.get("destinatario"));
			user.put("message", mensajeJ.get("message"));
			user.put("remitente", mensajeJ.get("remitente"));
			user.put("id",mensajeJ.get("id"));
			
			mensajesJ.add(user);
			
			System.out.println("----------");
			System.out.println(XML.toJSONObject(temp.getValor()));
			System.out.println("----------");
			
			
			temp = temp.getSiguiente();
			
		}
		resultsM = new org.json.simple.JSONObject();
		resultsM.put("mensajes", mensajesJ);
		
		
		return resultsM;
	}

}
