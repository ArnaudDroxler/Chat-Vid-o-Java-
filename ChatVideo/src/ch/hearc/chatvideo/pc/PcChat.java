
package ch.hearc.chatvideo.pc;

import java.rmi.RemoteException;

import ch.hearc.chatvideo.dialog.JFrameDialog;

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

		}

	private void serverSide()
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
	private SharedJtextArea shared;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/
	public RmiURL rmiUrl;

	}
