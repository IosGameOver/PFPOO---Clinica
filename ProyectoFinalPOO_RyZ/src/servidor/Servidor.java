package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor extends Thread {

	public static void main(String[] args) {
		ServerSocket sfd = null;
		try {
			sfd = new ServerSocket(8000);
		} catch (IOException ioe) {
			System.out.println("Comunicación rechazada. "+ioe);
			System.exit(1);
		}
		
		while(true) {
			try {
				Socket nsfd = sfd.accept();
				System.out.println("Conexión aceptada de: "+nsfd.getInetAddress());
				DataInputStream entrada = new DataInputStream(nsfd.getInputStream());
				DataOutputStream salida = new DataOutputStream(new FileOutputStream(new File ("clinica_respaldo.dat")));
				
				int unByte;
				try {
					while ((unByte = entrada.read()) != -1) {
						salida.write(unByte);
						entrada.close();
						salida.close();
						System.out.println("Escribiendo");
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (IOException ioe) {
				System.out.println("Error: "+ioe);
			}
		}
	}

}
