
package ch.hearc.chatvideo.pc.video;

import java.awt.image.BufferedImage;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamResolution;

public class VideoTools implements VideoTools_I
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public VideoTools()
		{
		if (!webcam.isOpen())
			{
			webcam.setViewSize(WebcamResolution.VGA.getSize());
			webcam.open();
			}
		}

	/*------------------------------*\
	|*				Get				*|
	\*------------------------------*/

	@Override
	public BufferedImage getImage()
		{
		return webcam.getImage();
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/
	private static final Webcam webcam = Webcam.getDefault();
	}
