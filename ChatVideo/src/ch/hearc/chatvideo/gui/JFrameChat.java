
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import ch.hearc.chatvideo.gui.tools.JPanelDecorator;
import ch.hearc.chatvideo.pc.Chat_I;
import ch.hearc.chatvideo.pc.SharedJtextArea;

public class JFrameChat extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameChat(Chat_I _remoteChat, SharedJtextArea _localChat, String _pseudo)
		{
		this.remoteChat = _remoteChat;
		this.localChat = _localChat;
		this.pseudo = _pseudo;

		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	public void sendMessage(String s)
		{
		s = pseudo + " : " + s + "\n";
		try
			{
			remoteChat.send(s);
			localChat.append(s);
			}
		catch (RemoteException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}

		}

	/*------------------------------*\
	|*				Set				*|
	\*------------------------------*/

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Private						*|
	\*------------------------------------------------------------------*/

	private void geometry()
		{
		// JComponent : Instanciation
		//On instancier ici le textarea
		bottom = new JPanelBottom(this);
		right = new JPanelRight();

		JPanelDecorator pDBottom = new JPanelDecorator(bottom, 4);
		JPanelDecorator pDRight = new JPanelDecorator(right, 4);
		JPanelDecorator pDCenter = new JPanelDecorator(localChat, 4);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		add(pDCenter, BorderLayout.CENTER);
		add(pDRight, BorderLayout.EAST);
		add(pDBottom, BorderLayout.SOUTH);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTextArea localChat;
	private JPanelBottom bottom;
	private JPanelRight right;
	private Chat_I remoteChat;
	private String pseudo;
	}
