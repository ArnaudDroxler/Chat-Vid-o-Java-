
package ch.hearc.chatvideo.pc.chat;

import java.rmi.RemoteException;

import javax.swing.JTextArea;

public class SharedJtextArea extends JTextArea implements Chat_I
	{

	@Override
	public void send(String s)
		{
		this.append(s);
		}

	@Override
	public void exit() throws RemoteException
		{
		System.exit(0);
		}
	}
