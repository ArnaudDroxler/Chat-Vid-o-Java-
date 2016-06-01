
package ch.hearc.chatvideo.pc;

import java.rmi.RemoteException;

import ch.hearc.chatvideo.gui.JFrameChat;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcChat2 extends PcChat
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void clientSide(String ip, String pseudo)
		{
		Chat_I remoteChat = connect(ip);
		new JFrameChat(remoteChat, localChat, pseudo);
		}

	@Override
	protected Chat_I connect(String ip)
		{
		Chat_I remoteChat;
		try
			{
			RmiURL rmiURL = new RmiURL(PcChat1.RMI_ID, RMI_PORT);
			int delayms = 1000;
			int nbTentatives = 1000;
			remoteChat = (Chat_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayms, nbTentatives);
			return remoteChat;
			}
		catch (RemoteException e)
			{
			System.err.println("[PcChat2]: connect: erreur de connexion");
			e.printStackTrace();
			}
		return null;
		}

	@Override
	protected void serverSide()
		{
		localChat = new SharedJtextArea();
		try
			{
			RmiTools.shareObject(localChat, rmiUrl);
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

	private final RmiURL rmiUrl = new RmiURL(RMI_ID, RMI_PORT);

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int RMI_PORT = RmiTools.PORT_RMI_DEFAUT;
	public static final String RMI_ID = PcChat2.class.getName() + "MAXIME";
	private SharedJtextArea localChat;
	}
