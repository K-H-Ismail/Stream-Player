import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;;

@ServerEndpoint(value = "/stream")
public class StreamServer {

	@OnOpen
	public void OnOpen(Session session) {
		System.out.println(session.toString());
	}

	@OnMessage
	public void OnMessage(Session session, byte[] image) {

		ByteBuffer buf = ByteBuffer.wrap(image);

		try {
			session.getBasicRemote().sendBinary(buf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void OnClose(Session session) {
		try {
			session.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
