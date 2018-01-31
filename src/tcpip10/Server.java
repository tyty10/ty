

package tcpip10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream in = null;
		InputStreamReader inr = null;
		BufferedReader br = null;
		try {
			serverSocket = new ServerSocket(7777);
			InetAddress ia = InetAddress.getLocalHost();
			System.out.println(ia.getHostName());
			System.out.println(ia.getHostAddress());
			System.out.println("Start Server ");
			
			
			while(true) {
			socket = serverSocket.accept();
			System.out.println("Client Connected");
			
			//receive data
			in = socket.getInputStream();
			inr = new InputStreamReader(in);
			br = new BufferedReader(inr);
			String receiveStr = br.readLine();
			System.out.println(receiveStr);
						
			System.out.println("End Server");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				br.close();
				inr.close();
				in.close();
				socket.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
