package com.tec.messages;



public class EntidadMensaje {
	private String remitente;
	private String message;
	private String id;
	private String destinatario;

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void identificador(String id) {
		this.id = id;
	}

	public String getIde() {
		return id;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

}
