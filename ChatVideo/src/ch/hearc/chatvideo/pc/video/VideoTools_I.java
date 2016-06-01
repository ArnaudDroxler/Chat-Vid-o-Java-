
package ch.hearc.chatvideo.pc.video;

import java.awt.image.BufferedImage;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface VideoTools_I extends Remote
	{

	public BufferedImage getImage() throws RemoteException;
	}
