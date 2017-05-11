package com.example.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Source code from Andy Feng
 * https://www.codeproject.com/Tips/1040097/Create-a-Simple-Web-Server-in-Java-HTTP-Server
 */
public class SimpleHttpServer {

	private HttpServer server;

	public void start(int port) {
		try {

			server = HttpServer.create(new InetSocketAddress(port), 0);
			System.out.println("Server started at " + port);

			// Creating HTTP context
			server.createContext("/", new com.example.server.Handlers.RootHandler());
			server.createContext("/echoHeader", new Handlers.EchoHeaderHandler());
			server.createContext("/echoGet", new Handlers.EchoGetHandler());
			server.createContext("/echoPost", new Handlers.EchoPostHandler());
			server.createContext("/getJSON", new Handlers.EchoGetJSONHandler());
			server.createContext("/devices", new Handlers.EchoGetJSONHandler());
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void Stop() {
		server.stop(0);
		System.out.println("server stopped");
	}
}
