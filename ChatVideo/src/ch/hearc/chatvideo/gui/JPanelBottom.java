package ch.hearc.chatvideo.gui;

import java.awt.Dimension;
import java.awt.Label;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;

public class JPanelBottom extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelBottom()
		{
		super(BoxLayout.X_AXIS);

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
		// rien
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

	}
