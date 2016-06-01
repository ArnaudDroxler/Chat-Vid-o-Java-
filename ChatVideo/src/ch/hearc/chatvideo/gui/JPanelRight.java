
package ch.hearc.chatvideo.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import ch.hearc.chatvideo.testvideo.JPanelTestVideo;

public class JPanelRight extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelRight()
		{
		super(BoxLayout.Y_AXIS);
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
		//videoCLient = new JPanelTestVideo();
		//videoServeur = new JPanelTestVideo();

		// JComponent : add

		//add(videoCLient);
		add(buttonVideo);
		//add(videoServeur);
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
	private JPanelTestVideo videoCLient;
	private JPanelTestVideo videoServeur;
	}
