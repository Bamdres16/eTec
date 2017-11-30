package com.tec.baseDatos;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.json.XML;
import org.json.simple.JSONArray;

public class Registros {
	static NodoMensajes<String> current;
	public static ListaEnlazada<String> registros = new ListaEnlazada<>();
	public static String xml;
	private static org.json.simple.JSONObject results = new org.json.simple.JSONObject();
	public static JSONArray registrosJ = new JSONArray();

	public static void  GuardarDatos(org.json.simple.JSONObject usuario) {

		JSONObject json = new JSONObject(usuario.toJSONString());
		xml = XML.toString(json);

		registros.insertarFinal(xml);

		System.out.println(xml);

	}

	@SuppressWarnings("unchecked")
	public  static org.json.simple.JSONObject getUsuarios() {

		current = registros.getPrimero();
		registrosJ = new JSONArray();
		while (current != null) {

			JSONObject usuarioJ = XML.toJSONObject(current.getValor());
			org.json.simple.JSONObject user = new org.json.simple.JSONObject();
			user.put("name", usuarioJ.get("name"));
			user.put("username", usuarioJ.get("username"));
			user.put("password", usuarioJ.get("password"));
			user.put("email", usuarioJ.get("email"));

			registrosJ.add(user);

			current = current.getSiguiente();

		}
		results = new org.json.simple.JSONObject();
		results.put("results", registrosJ);

		return results;
	}
}
