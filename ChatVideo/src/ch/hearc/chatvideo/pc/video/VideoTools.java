
package ch.hearc.chatvideo.pc.video;

import javax.swing.ImageIcon;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class VideoTools implements VideoTools_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public static VideoTools getInstance()
		{
		if (!webcam.isOpen())
			{
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcam.open();
			}
		return instance;
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public ImageIcon getImage()
		{
		return new ImageIcon(webcam.getImage());
		//return webcam.getImage();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private static final Webcam webcam = Webcam.getDefault();
	private static final VideoTools instance = new VideoTools();
	}
