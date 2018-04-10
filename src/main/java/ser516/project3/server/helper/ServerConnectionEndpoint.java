package ser516.project3.server.helper;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

import ser516.project3.model.MessageModel;
import ser516.project3.server.controller.ServerController;
import ser516.project3.utilities.MessageEncoder;
import ser516.project3.utilities.ServerCommonData;

/**
 * The Web server socket endpoint class for the server application
 *
 * @author User
 */
@ServerEndpoint(value = "/server", encoders = {MessageEncoder.class})
public class ServerConnectionEndpoint {
    final static Logger logger = Logger.getLogger(ServerConnectionEndpoint.class);
    private static int connectionCount = 0;
    private static double timeElapsed = 0;
	
    /**
	 * Method containing logic to start sending the message json based on the value
     * of auto send flag. If the flag is false, just send the json once, 
     * else keep sending based on the interval
     * @param session - web socket session
	 */	
    @OnOpen
    public void onOpen(final Session session) throws IOException {
    	connectionCount++;
    	double syncTimeElapsed = 0;
        try {
        	logger.info("New Client connected :::: " + session.getBasicRemote());
            ServerController.getInstance().getConsoleController().getConsoleModel().
            	logMessage("Client Connected");
            ServerCommonData serverCommonDataObject = ServerCommonData.getInstance();
            while (true) {
                boolean isShouldSend = ServerController.getInstance().getTopController().
                			getTopModel().isShouldSendData();
                boolean isAutoRepeat = ServerController.getInstance().getTopController().
                			getTopModel().isAutoRepeatCheckBoxChecked();
                if (isShouldSend) {
                	MessageModel messageModel = new MessageModel();
                	messageModel = serverCommonDataObject.getMessage();
                	messageModel.setTimeStamp(syncTimeElapsed);
                    session.getBasicRemote().sendObject(messageModel);
//                    double timeElapsed = ServerCommonData.getInstance().getMessage().
//                        getTimeStamp();
                    double dataInterval = ServerCommonData.getInstance().getMessage().
                        getInterval()/connectionCount;
                    timeElapsed = timeElapsed + dataInterval;
                    ServerCommonData.getInstance().getMessage().setTimeStamp(
                        timeElapsed + dataInterval);
                    ServerController.getInstance().getTimerController().updateTimeStamp((int)timeElapsed);
                    syncTimeElapsed = syncTimeElapsed + dataInterval * connectionCount;
                    if (!isAutoRepeat)
                      ServerController.getInstance().getTopController().getTopModel().setShouldSendData(false);
                }
                Thread.sleep((long) (serverCommonDataObject.getMessage().getInterval() * 1000));
            }

        } catch (IOException | EncodeException | InterruptedException e) {
            logger.error("Error occurred in onOpen method :::: " + e.getStackTrace());
            ServerController.getInstance().getConsoleController().getConsoleModel().
            	logMessage("Error occurred while connecting to client");
        }
    }
    
	
    /**
	 * Method containing logic on what to do when message from client is received
	 * @param session - web socket session 
	 */	
    @OnMessage
    public void onMessage(String message, Session session) {

    }
    
    /**
	 * Method containing logic on what to do when session is closed
	 * @param session - web socket session
	 * @param closeReason - web socket close reason
	 */
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info("onClose: " + closeReason);
        connectionCount--;
        try {
            session.getBasicRemote().sendText("Connection closed");
        } catch (IOException e) {
            logger.error("Error occurred while sending text::::" + e.getStackTrace());
        }
    }

    /**
	 * Method containing logic on what to do error occurs
	 * @param session - web socket session
	 * @param throwable - Throwable object
	 */
    @OnError
    public void onError(Session session, Throwable throwable) {
        logger.error("Error occurred in Server Endpoint");
    }
}