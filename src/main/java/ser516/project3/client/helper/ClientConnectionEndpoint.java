package ser516.project3.client.helper;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import ser516.project3.client.controller.ExpressionsDataObservable;
import ser516.project3.client.controller.PerformanceMetricDataObservable;
import ser516.project3.model.CoordinatesModel;
import ser516.project3.model.Message;
import ser516.project3.model.MessageDecoder;
import ser516.project3.utilities.MessageFormatConverter;

/**
 * This class acts as an end point of the connection and provides the message
 * bean that is further used to instantiate singleton data objects for
 * performance metrics and expressions.
 * 
 * 
 * @author Varun Srivastava, Manish Tandon
 *
 */
@ClientEndpoint(decoders = { MessageDecoder.class })
public class ClientConnectionEndpoint {

	final static Logger logger = Logger.getLogger(ClientConnectionEndpoint.class);

	@OnOpen
	public void onOpen(Session session) {
		logger.info("Connected to endpoint: " + session.getBasicRemote());
		try {
			session.getBasicRemote().sendText("Test Text");
		} catch (IOException ex) {
			logger.error("Exception in onOpen method::::" + ex.getStackTrace());
		}
	}

	@OnMessage
	public void processMessage(Message messageBean, Session session) {
		PerformanceMetricDataObservable.getInstance().addToListValues(MessageFormatConverter.convertMessageToPeformanceMetrics(messageBean));
		ExpressionsDataObservable.getInstance().addToListValues(MessageFormatConverter.convertMessageToExpressionsData(messageBean));
		logger.info("Received data:::: " + messageBean);
	}

	@OnError
	public void processError(Throwable t) {
		logger.error("Error occurred in Client End Point");
	}

	
}
