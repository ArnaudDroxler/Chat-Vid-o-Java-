
package ch.hearc.chatvideo.pc;

import ch.hearc.chatvideo.dialog.JFrameDialog;
import ch.hearc.chatvideo.pc.chat.Chat_I;
import ch.hearc.chatvideo.pc.chat.SharedJtextArea;
import ch.hearc.chatvideo.pc.video.VideoTools_I;

public abstract class PcChat implements Runnable
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void run()
		{
		serverSide();
		new JFrameDialog(this);

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

	public abstract void clientSide(String ip, String pseudo);

	protected abstract Chat_I connectChat(String ip);

	protected abstract VideoTools_I connectVideo(String ip);

	protected abstract void serverSide();

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//INPUT
	protected SharedJtextArea localChat;

	}
