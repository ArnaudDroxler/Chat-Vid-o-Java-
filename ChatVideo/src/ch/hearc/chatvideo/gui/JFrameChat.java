
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import ch.hearc.chatvideo.gui.tools.JPanelDecorator;
import ch.hearc.chatvideo.pc.chat.Chat_I;
import ch.hearc.chatvideo.pc.chat.SharedJtextArea;
import ch.hearc.chatvideo.pc.video.VideoTools;
import ch.hearc.chatvideo.pc.video.VideoTools_I;

public class JFrameChat extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameChat(Chat_I _remoteChat, SharedJtextArea _localChat, VideoTools_I _remoteVideo, VideoTools _localVideo, String _pseudo)
		{
		this.remoteChat = _remoteChat;
		this.localChat = _localChat;
		this.pseudo = _pseudo;
		this.remoteVideo = _remoteVideo;
		this.localVideo = _localVideo;

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
		right = new JPanelRight(localVideo,remoteVideo,this);

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
	private JPanelBottom bottom;
	private JPanelRight right;
	private JTextArea localChat;
	private Chat_I remoteChat;
	private VideoTools localVideo;
	private VideoTools_I remoteVideo;
	private String pseudo;
	}
