
package ch.hearc.chatvideo.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

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
		localVideo = new JPanelVideo(_localVideo);
		remoteVideo = new JPanelVideo(_remoteVideo);
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

		buttonVideo = new JButton("Video");

		// JComponent : add
		add(buttonVideo);
		add(remoteVideo);
		add(localVideo);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JButton buttonVideo;
	private JPanelVideo localVideo;
	private JPanelVideo remoteVideo;
	}
