
package ch.hearc.chatvideo.gui;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JPanelBottom extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBottom(JFrameChat jFrameChat)
		{
		super(BoxLayout.X_AXIS);

		parent = jFrameChat;
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
		labelPseudo = new Label("Pseudo :");
		inputPseudo = new JTextField();
		inputMessage = new JTextField();
		buttonSend = new JButton("Send");

		// JComponent : add
		add(labelPseudo);
		add(inputPseudo);
		add(Box.createHorizontalStrut(5));
		add(inputMessage);
		add(Box.createHorizontalStrut(5));
		add(buttonSend);

		}

	private void control()
		{
		buttonSend.addActionListener(new ActionListener()
			{

			@Override
			public void actionPerformed(ActionEvent e)
				{
				String s = inputMessage.getText();
				parent.sendMessage(s);
				inputMessage.setText("");
				}
			});
		}

	private void appearance()
		{
		inputPseudo.setPreferredSize(new Dimension(100, 26));
		inputPseudo.setMaximumSize(new Dimension(100, 26));
		inputPseudo.setMinimumSize(new Dimension(100, 26));

		//Debug
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	private Label labelPseudo;
	private JTextField inputPseudo;
	private JTextField inputMessage;
	private JButton buttonSend;
	private JFrameChat parent;
	}
