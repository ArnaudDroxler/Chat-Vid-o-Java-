
package ch.hearc.chatvideo.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		inputMessage = new JTextField();
		buttonSend = new JButton("Send");

		// JComponent : add

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
				sendMessage();
				}
			});

		inputMessage.addKeyListener(new KeyAdapter()
			{


			@Override
			public void keyPressed(KeyEvent e)
				{
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					{
					sendMessage();
					}
				}
			});
		}

	public void sendMessage()
		{
		String s = inputMessage.getText();
		parent.sendMessage(s);
		inputMessage.setText("");
		}

	private void appearance()
		{

		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JTextField inputMessage;
	private JButton buttonSend;
	private JFrameChat parent;

	}
