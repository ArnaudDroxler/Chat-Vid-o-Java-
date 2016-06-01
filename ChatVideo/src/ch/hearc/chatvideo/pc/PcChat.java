
package ch.hearc.chatvideo.pc;

import java.rmi.RemoteException;

import ch.hearc.chatvideo.dialog.JFrameDialog;
import ch.hearc.chatvideo.gui.JFrameChat;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

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

	public void clientSide(String ip, String pseudo)
		{
		work();
		}

	protected void work()
		{
		new JFrameChat(shared);
		}

	protected SharedJtextArea connect(String ip)
		{
		return shared;
		}

	protected void serverSide()
		{
		shared = new SharedJtextArea();
		try
			{
			RmiTools.shareObject(shared, rmiUrl);
			}
		catch (RemoteException e)
			{
			System.err.println("[PcChat]: serverSide: instanciation textArea");
			e.printStackTrace();
			}
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//INPUT
	protected SharedJtextArea shared;
	protected RmiURL rmiUrl;

	}
