
package ch.hearc.chatvideo.pc;

import ch.hearc.chatvideo.dialog.JFrameDialog;

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

	abstract protected Chat_I connect(String ip);

	protected abstract void serverSide();

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//INPUT
	protected SharedJtextArea localChat;

	}
