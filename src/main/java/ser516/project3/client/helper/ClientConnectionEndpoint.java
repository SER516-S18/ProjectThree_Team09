package ser516.project3.client.helper;

import java.io.IOException;

import javax.swing.*;
import javax.websocket.*;

import org.apache.log4j.Logger;

import ser516.project3.model.*;
import ser516.project3.client.controller.ControllerFactory;
import ser516.project3.constants.ClientConstants;
import ser516.project3.utilities.MessageDecoder;
import ser516.project3.utilities.MessageFormatConverter;
import ser516.project3.utilities.ServerCommonData;

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
			session.getBasicRemote().sendText(ServerCommonData.getInstance().getMessage().toString());
		} catch (IOException ex) {
			logger.error("Exception in onOpen method::::" + ex.getMessage());
		}
	}

	@OnMessage
	public void processMessage(MessageModel messageModelBean, Session session) {
		logger.info("Received data:::: " + messageModelBean);
		PerformanceMetricDataObservable.getInstance().addToListValues(MessageFormatConverter.convertMessageToPeformanceMetrics(messageModelBean));
		ExpressionsDataObservable.getInstance().addToListValues(MessageFormatConverter.convertMessageToExpressionsData(messageModelBean));
		FaceExpressionsObservable.getInstance().setMessageBean(messageModelBean);
		HeaderObservable.getInstance().setHeaderData(messageModelBean.getTimeStamp(), messageModelBean.getInterval());
	}

	@OnError
	public void processError(Throwable t) {

		logger.error("Error occurred in Client End Point");
		t.printStackTrace();
	}

	@OnClose
	public void processClose(Session userSession, CloseReason reason) {
		logger.error("On Close called");
		if (reason.getReasonPhrase().length() > 0) {
			final JDialog dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			JOptionPane.showMessageDialog(dialog, ClientConstants.SERVER_STOPPED_MESSAGE, ClientConstants.ERROR_STRING, JOptionPane.ERROR_MESSAGE);
			ControllerFactory.getInstance().getClientController().stopClientConnector();
		}
	}
	
}
