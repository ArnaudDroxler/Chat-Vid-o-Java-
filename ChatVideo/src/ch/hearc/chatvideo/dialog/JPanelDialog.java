
package ch.hearc.chatvideo.dialog;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import ch.hearc.chatvideo.pc.PcChat;

public class JPanelDialog extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelDialog(PcChat chat, JFrameDialog parent)
		{
		super(BoxLayout.Y_AXIS);
		this.chat = chat;
		this.parent = parent;
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
		labelIp = new JLabel("IP : ");
		inputIp = new JTextField("127.0.0.1");
		labelPseudo = new JLabel("Pseudo : ");
		inputPseudo = new JTextField("Moi");
		connect = new JButton("Connect");

		// JComponent : add
		Box boxIp = Box.createHorizontalBox();
		boxIp.add(labelIp);
		boxIp.add(inputIp);

		Box boxPseudo = Box.createHorizontalBox();
		boxPseudo.add(labelPseudo);
		boxPseudo.add(inputPseudo);

		add(boxIp);
		add(Box.createVerticalStrut(4));
		add(boxPseudo);
		add(Box.createVerticalStrut(4));
		add(connect);

		}

	private void control()
		{
		connect.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				savePreferences();
				chat.clientSide(inputIp.getText(), inputPseudo.getText());
				parent.setVisible(false);
				}

			});

		}

	private void appearance()
		{
		inputPseudo.setPreferredSize(new Dimension(100, 26));
		inputPseudo.setMaximumSize(new Dimension(100, 26));
		inputPseudo.setMinimumSize(new Dimension(100, 26));

		inputIp.setPreferredSize(new Dimension(100, 26));
		inputIp.setMaximumSize(new Dimension(100, 26));
		inputIp.setMinimumSize(new Dimension(100, 26));

		loadPreferences();
		}

	private void loadPreferences()
		{
		String pseudo = PREFERENCES.get("pseudo", "Moi");
		String ip = PREFERENCES.get("ip", "127.0.0.1");
		inputPseudo.setText(pseudo);
		inputIp.setText(ip);
		}

	private void savePreferences()
		{
		PREFERENCES.put("pseudo", inputPseudo.getText());
		PREFERENCES.put("ip", inputIp.getText());
		}


	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	private JLabel labelIp;
	private JLabel labelPseudo;
	private JTextField inputIp;
	private JTextField inputPseudo;
	private JButton connect;
	private PcChat chat;
	private JFrameDialog parent;

	/*------------------------------*\
	|*			  Static			*|
	\*------------------------------*/

	private static final Preferences PREFERENCES = Preferences.userNodeForPackage(JPanelDialog.class);
	}
