
package ch.hearc.chatvideo.pc.video;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.ImageIcon;

public interface VideoTools_I extends Remote
	{
	public ImageIcon getImage() throws RemoteException;
	}
