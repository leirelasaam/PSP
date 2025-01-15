package com.alumno.server.alumnoServer.socketIO.config;

/**
 * The events our server is willing to listen or able to send
 */
public enum Events {

	ON_LOGIN ("onLogin"),
	ON_GET_ALL ("onGetAll"),
    ON_LOGOUT ("onLogout"),
    ON_LOGIN_ANSWER ("onLoginAnswer"),
	ON_GET_ALL_ANSWER ("onGetAllAnswer"),
	ON_TELEFONO_ENCONTRADO("onTelefonoEncontrado");
	
	public final String value;

	private Events(String value) {
		this.value = value;
	}
}
