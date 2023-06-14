
import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class clientText {

	public static void main(String[] args) {
		
		ClientTextFrame clientTextFrame = new ClientTextFrame();
		String text = "Hello World";
		try {
			
		// Launch client-side frame
		clientTextFrame.setVisible(true);
			
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

		// Update the status of the connection
		clientTextFrame.updateConnectionStatus(socket.isConnected());
		System.out.println(socket.isConnected());

		// Write text for server
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		
		// send text
		printWriter.println(text);
		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader
				(new InputStreamReader(socket.getInputStream()));

		// display words count
		String totalWord = bufferedReader.readLine();
		clientTextFrame.updateTotalWord(totalWord);
	

		// Close everything
		bufferedReader.close();
		socket.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}