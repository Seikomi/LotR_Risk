package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadConnexion implements Runnable {

	private ServerSocket serveur;
	protected static AtomicBoolean traitementTermine; //Boolean pouvant �tre modifi� dans n'importe quelle classe li�e au package net
	
	public ThreadConnexion() {
		try {
			this.serveur = new ServerSocket(9876);
		} catch (IOException e) {e.printStackTrace();}
		ThreadConnexion.traitementTermine = new AtomicBoolean(true);
	}
	
	@Override
	public void run() {
		Socket socketEntree = null;
		while (ThreadConnexion.traitementTermine.get()) //V�rifie si une connexion est achev�e ou non
		{
			try {
				socketEntree = this.serveur.accept();
				ThreadConnexion.traitementTermine.set(false);
				System.out.println("Un client avec l'adresse " + socketEntree.getInetAddress().getHostAddress() + " se connecte..");
				System.out.println("Serveur : Allo j'�coute ?");
				new Thread(new ThreadReception(socketEntree.getInputStream())).start();
			} catch (IOException e) {e.printStackTrace();}
		}
		try {
			this.serveur.close();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public static void main(String[] args) {
		new Thread(new ThreadConnexion()).start();
	}

	
}
