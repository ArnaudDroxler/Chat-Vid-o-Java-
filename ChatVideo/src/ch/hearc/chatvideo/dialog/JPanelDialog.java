
package ch.hearc.chatvideo.dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public JPanelDialog(PcChat chat)
		{
		super(BoxLayout.X_AXIS);
		this.chat = chat;
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
		add(labelIp);
		add(inputIp);
		add(Box.createHorizontalStrut(5));
		add(labelPseudo);
		add(inputPseudo);
		add(connect);
		}

	private void control()
		{
		connect.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				chat.clientSide(inputIp.getText(), inputPseudo.getText());

				}
			});
		}

	private void appearance()
		{
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
	PcChat chat;
	}
