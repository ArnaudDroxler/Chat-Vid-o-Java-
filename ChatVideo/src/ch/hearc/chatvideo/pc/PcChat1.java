
package ch.hearc.chatvideo.pc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;

import ch.hearc.chatvideo.gui.JFrameChat;
import ch.hearc.chatvideo.pc.chat.Chat_I;
import ch.hearc.chatvideo.pc.chat.SharedJtextArea;
import ch.hearc.chatvideo.pc.video.VideoTools;
import ch.hearc.chatvideo.pc.video.VideoTools_I;

import com.bilat.tools.reseau.rmi.RmiTools;
import com.bilat.tools.reseau.rmi.RmiURL;

public class PcChat1 extends PcChat
	{

	/*------------------------------------------------------------------*\
	|*							Methodes Public							*|
	\*------------------------------------------------------------------*/

	@Override
	public void clientSide(String _ip, String pseudo)
		{
		InetAddress ip;
		try
			{
			ip = InetAddress.getByName(_ip);
			Chat_I remoteChat = connectChat(ip);
			VideoTools_I remoteVideo = connectVideo(ip);
			new JFrameChat(this,remoteChat, localChat,remoteVideo,localVideo, pseudo);
			}
		catch (UnknownHostException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}


		}

	@Override
	protected VideoTools_I connectVideo(InetAddress ip)
		{
		VideoTools_I remoteVideo;

		try
			{
			RmiURL rmiURL = new RmiURL(PcChat2.RMI_ID_VIDEO,ip, RMI_PORT);
			int delayms = 1000;
			int nbTentatives = 15;
			remoteVideo = (VideoTools_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayms, nbTentatives);
			return remoteVideo;
			}
		catch (RemoteException e)
			{
			e.printStackTrace();
			}
		return null;
		}

	@Override
	protected Chat_I connectChat(InetAddress ip)
		{
		Chat_I remoteChat;
		try
			{
			RmiURL rmiURL = new RmiURL(PcChat2.RMI_ID_CHAT,ip, RMI_PORT);
			int delayms = 1000;
			int nbTentatives = 1000;
			remoteChat = (Chat_I)RmiTools.connectionRemoteObjectBloquant(rmiURL, delayms, nbTentatives);
			return remoteChat;
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
		localChat = new SharedJtextArea();
		localVideo = VideoTools.getInstance();
		try
			{
			RmiTools.shareObject(localChat, rmiUrlChat);
			RmiTools.shareObject(localVideo, rmiUrlVideo);
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

	private final RmiURL rmiUrlChat = new RmiURL(RMI_ID_CHAT, RMI_PORT);
	private final RmiURL rmiUrlVideo = new RmiURL(RMI_ID_VIDEO, RMI_PORT);

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	public static final int RMI_PORT = RmiTools.PORT_RMI_DEFAUT;
	public static final String RMI_ID_CHAT = PcChat1.class.getName() + "CHAT";
	public static final String RMI_ID_VIDEO = PcChat1.class.getName() + "VIDEO";
	private SharedJtextArea localChat;
	private VideoTools localVideo;

	}
