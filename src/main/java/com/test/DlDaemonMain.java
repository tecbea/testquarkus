package com.test;

import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.quarkus.runtime.Startup;
import io.quarkus.scheduler.Scheduled;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import jakarta.websocket.ClientEndpointConfig;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

@Startup
@Singleton
public class DlDaemonMain extends Endpoint {

	private static final Logger log = Logger.getLogger("DlDaemonMain");


	/**
	 * 
	 */
	@PostConstruct
	void onStart() {

	
	}

	@Override
	public void onOpen(Session session, EndpointConfig config) {
		// TODO Auto-generated method stub
		log.info("yahoo");
	}
	
	/**
	 * 
	 */
	@Scheduled(every = "10s", delay = 10, delayUnit = TimeUnit.SECONDS)
	void tick() {
 		
		//
		// connect FAIL
		//
		try {
 
			String websocketUri = "wss://localhost:8443/ws/test";

			
			ClientEndpointConfig.Configurator configurator = new ClientEndpointConfig.Configurator() {

			};

			ClientEndpointConfig config = ClientEndpointConfig.Builder.create().configurator(configurator).build();

			log.log(Level.INFO, "TRY : " + websocketUri);

			WebSocketContainer wsContainer = ContainerProvider.getWebSocketContainer();
			wsContainer.setAsyncSendTimeout(2000);
			wsContainer.setDefaultMaxSessionIdleTimeout(2000);
			wsContainer.connectToServer(this, config, URI.create(websocketUri));

			log.log(Level.INFO, "CONECTED : " + websocketUri);
			return;

		} catch (Exception e) {
			log.log(Level.SEVERE, "" + e.toString());
		}

		
		
		
		
		//
		// connect OK
		//
		try {
			String websocketUri = "ws://localhost:8080/ws/test";

			ClientEndpointConfig.Configurator configurator = new ClientEndpointConfig.Configurator() {

			};

			ClientEndpointConfig config = ClientEndpointConfig.Builder.create().configurator(configurator).build();

			log.log(Level.INFO, "TRY : " + websocketUri);

			WebSocketContainer wsContainer = ContainerProvider.getWebSocketContainer();
			wsContainer.setAsyncSendTimeout(2000);
			wsContainer.setDefaultMaxSessionIdleTimeout(2000);
			wsContainer.connectToServer(this, config, URI.create(websocketUri));

			log.log(Level.INFO, "CONECTED : " + websocketUri);
			return;

		} catch (Exception e) {
			log.log(Level.SEVERE, "" + e.toString());
		}
 
		
	}
	
	
}