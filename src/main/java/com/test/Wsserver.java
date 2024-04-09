package com.test;

import java.util.logging.Logger;

import io.vertx.core.eventbus.EventBus;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

// king
//		ws://localhost:8080/ws/test
// 		wss://localhost:8443/ws/test

@ServerEndpoint("/ws/{par1}")
@ApplicationScoped
public class Wsserver {

	private static final Logger log = Logger.getLogger("Wsserver");

	// session
	Session evseSession = null;

	//
	@Inject
	EventBus bus;

	/**
	 * 
	 * @param session
	 * @param par1
	 */
	@OnOpen
	// @Blocking

	public void onOpen(Session session, @PathParam("par1") String par1) {

		log.info("OnOpen " + par1);

	}

	/**
	 * 
	 * @param session
	 * @param par1
	 */
	@OnClose
	public void onClose(Session session, @PathParam("par1") String par1) {
		log.info("onClose " + par1 + "  ");

	}

	/**
	 * 
	 * @param session
	 * @param par1
	 * @param throwable
	 */
	@OnError
	public void onError(Session session, @PathParam("par1") String par1, Throwable throwable) {

		log.info("onError " + par1 + "  " + throwable);

 	}

	/**
	 * 
	 * @param message
	 * @param par1
	 */
	@OnMessage
	public void onMessage(String message, @PathParam("par1") String par1) {
		log.info("onMessage " + par1 + "  ");

	}

}
