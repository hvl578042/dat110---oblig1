package no.hvl.dat110.messaging;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.Socket;

import no.hvl.dat110.TODO;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		// TODO
		// create TCP socket for client and connection
		// create connection object

		Socket clientSocket;
		Connection connection = null;
		try {
			clientSocket = new Socket(server, port);
			connection = new Connection(clientSocket);
		}

		catch (IOException ex) {
			ex.printStackTrace();
		}

		return connection;
	}
}
