
package ch.hearc.chatvideo.pc.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat_I extends Remote
	{
	public void exit() throws RemoteException;
	public void send(String s) throws RemoteException;
	}
