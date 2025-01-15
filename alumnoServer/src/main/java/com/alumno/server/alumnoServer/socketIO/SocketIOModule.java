package com.alumno.server.alumnoServer.socketIO;

import java.util.ArrayList;
import java.util.List;

import com.alumno.server.alumnoServer.dataBase.entity.Alumno;
import com.alumno.server.alumnoServer.socketIO.config.Events;
import com.alumno.server.alumnoServer.socketIO.model.MessageInput;
import com.alumno.server.alumnoServer.socketIO.model.MessageOutput;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

/**
 * Server control main configuration class
 */
public class SocketIOModule {

	// The server
	private SocketIOServer server = null;

	public SocketIOModule(SocketIOServer server) {
		super();
		this.server = server;

		// Default events (for control the connection of clients)
		server.addConnectListener(onConnect());
		server.addDisconnectListener(onDisconnect());

		// Custom events
		server.addEventListener(Events.ON_LOGIN.value, MessageInput.class, this.login());
		server.addEventListener(Events.ON_GET_ALL.value, MessageInput.class, this.getAll());
		server.addEventListener(Events.ON_LOGOUT.value, MessageInput.class, this.logout());
		
		server.addEventListener(Events.ON_TELEFONO_ENCONTRADO.value, null, null);
	}

	// Default events

	private ConnectListener onConnect() {
		return (client -> {
			client.joinRoom("default-room");
			System.out.println("New connection, Client: " + client.getRemoteAddress());
		});
	}

	private DisconnectListener onDisconnect() {
		return (client -> {
			client.leaveRoom("default-room");
			System.out.println(client.getRemoteAddress() + " disconected from server");
		});
	}

	// Custom events

	private DataListener<MessageInput> login() {
		return ((client, data, ackSender) -> {
			System.out.println("Client from " + client.getRemoteAddress() + " wants to login");

			// The JSON message from MessageInput
			String message = data.getMessage();

			// We parse the JSON into an JsonObject
			// The JSON should be something like this: {"message": "patata"}
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
			String userName = jsonObject.get("message").getAsString();

			// We access to database and...
			// Let's say it answers with this...
			Alumno alumno = new Alumno(0, userName, "potato", "pass", 20);

			// We parse the answer into JSON
			String answerMessage = gson.toJson(alumno);

			// ... and we send it back to the client inside a MessageOutput
			MessageOutput messageOutput = new MessageOutput(answerMessage);
			client.sendEvent(Events.ON_LOGIN_ANSWER.value, messageOutput);
		});
	}

	private DataListener<MessageInput> getAll() {
		return ((client, data, ackSender) -> {
			// This time, we simply write the message in data
			System.out.println("Client from " + client.getRemoteAddress() + " wants to getAll");

			// We access to database and... we get a bunch of people
			List<Alumno> alumnos = new ArrayList<Alumno>();
			alumnos.add(new Alumno(0, "patata", "potato", "pass", 20));
			alumnos.add(new Alumno(1, "patata2", "potato2", "pass2", 22));
			alumnos.add(new Alumno(2, "patata3", "potato3", "pass3", 23));

			// We parse the answer into JSON
			String answerMessage = new Gson().toJson(alumnos);

			// ... and we send it back to the client inside a MessageOutput
			MessageOutput messageOutput = new MessageOutput(answerMessage);
			client.sendEvent(Events.ON_GET_ALL_ANSWER.value, messageOutput);
		});
	}

	private DataListener<MessageInput> logout() {
		return ((client, data, ackSender) -> {
			// This time, we simply write the message in data
			System.out.println("Client from " + client.getRemoteAddress() + " wants to logout");

			// The JSON message from MessageInput
			String message = data.getMessage();

			// We parse the JSON into an JsonObject
			// The JSON should be something like this: {"message": "patata"}
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(message, JsonObject.class);
			String userName = jsonObject.get("message").getAsString();

			// We do something on dataBase? ¯_(ツ)_/¯

			System.out.println(userName + " loged out");
		});
	}
	
	// Server control 

	public void start() {
		server.start();
		System.out.println("Server started...");
	}

	public void stop() {
		server.stop();
		System.out.println("Server stopped");
	}
}
