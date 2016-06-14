
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

	public JPanelRight(VideoTools _localVideo, VideoTools_I _remoteVideo, JFrameChat _parent)
		{
		super(BoxLayout.Y_AXIS);
		parent = _parent;
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

		box = Box.createHorizontalBox();
		// JComponent : add
		add(Box.createVerticalGlue());
		add(buttonConnect);
		add(Box.createVerticalGlue());

		}

	private void control()
		{
		buttonConnect.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				removeAll();
				add(Box.createVerticalGlue());
				add(panelRemoteVideo);
				add(panelLocalVideo);
				add(Box.createVerticalStrut(5));
				box.add(buttonDisconnet);
				add(box);
				add(Box.createVerticalGlue());
				parent.setLocation(0, 0);
				parent.setSize(1200, 800);
				}
			});

		buttonDisconnet.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				removeAll();
				add(Box.createVerticalGlue());
				add(buttonConnect);
				add(Box.createVerticalGlue());
				parent.setSize(600, 400);
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
	private Box box;
	private JFrameChat parent;
	}
