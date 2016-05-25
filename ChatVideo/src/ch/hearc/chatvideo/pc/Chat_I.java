
package ch.hearc.chatvideo.pc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Chat_I extends Remote
	{

	public void append(String s) throws RemoteException;
	}
