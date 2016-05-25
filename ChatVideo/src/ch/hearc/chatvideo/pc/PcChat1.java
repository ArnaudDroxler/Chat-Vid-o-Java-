
package ch.hearc.chatvideo.pc;

import java.rmi.RemoteException;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcChat1 extends PcChat
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	protected Chat_I connect(String ip)
		{
		Chat_I textarea;
		try
			{
			RmiURL rmiURL = new RmiURL(PcChat2.RMI_ID, RMI_PORT);
			int delayms = 1000;
			int nbTentatives = 1000;
			textarea = (Chat_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayms, nbTentatives);
			return textarea;
			}
		catch (RemoteException e)
			{
			System.err.println("[PcChat1]: connect: erreur de connexion");
			e.printStackTrace();
			}
		return null;
		}

	@Override
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

	public final RmiURL rmiUrl = new RmiURL(RMI_ID, RMI_PORT);

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int RMI_PORT = RmiTools.PORT_RMI_DEFAUT;
	public static final String RMI_ID = PcChat1.class.getName() + "MAXIME";

	}
