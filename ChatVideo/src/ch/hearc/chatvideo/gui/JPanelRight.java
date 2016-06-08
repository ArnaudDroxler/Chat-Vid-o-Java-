
package ch.hearc.chatvideo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ch.hearc.chatvideo.pc.video.VideoTools;
import ch.hearc.chatvideo.pc.video.VideoTools_I;
import ch.hearc.chatvideo.testvideo.JPanelVideo;

public class JPanelRight extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRight(VideoTools _localVideo, VideoTools_I _remoteVideo)
		{
		super(BoxLayout.Y_AXIS);
		localVideo = _localVideo;
		remoteVideo = _remoteVideo;
		geometry();
		control();
		appearance();
		}

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

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
		buttonConnect = new JButton("Video");
		buttonDisconnet = new JButton("Disconnect");
		panelLocalVideo = new JPanelVideo(localVideo);
		panelRemoteVideo = new JPanelVideo(remoteVideo);

		// JComponent : add
		add(buttonConnect);
		}

	private void control()
		{
		buttonConnect.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				add(panelRemoteVideo);
				add(panelLocalVideo);
				remove(buttonConnect);
				add(buttonDisconnet);
				}
			});

		buttonDisconnet.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				remove(panelLocalVideo);
				remove(panelRemoteVideo);
				remove(buttonDisconnet);
				add(buttonConnect);

				}
			});
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton buttonConnect;
	private JButton buttonDisconnet;
	private JPanel panelLocalVideo;
	private JPanel panelRemoteVideo;
	private VideoTools localVideo;
	private VideoTools_I remoteVideo;
	}
