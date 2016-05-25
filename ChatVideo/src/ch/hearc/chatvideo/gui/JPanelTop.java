
package ch.hearc.chatvideo.gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JPanelTop extends Box
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelTop()
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
		labelIp = new JLabel("IP : ");
		inputIp = new JTextField();
		labelPort = new JLabel("Port : ");
		inputPort = new JTextField("1099");
		connect = new JButton("Connect");

		// JComponent : add
		add(labelIp);
		add(inputIp);
		add(Box.createHorizontalStrut(5));
		add(labelPort);
		add(inputPort);
		add(connect);
		}

	private void control()
		{

		}

	private void appearance()
		{
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools

	private JLabel labelIp;
	private JLabel labelPort;
	private JTextField inputIp;
	private JTextField inputPort;
	private JButton connect;
	}
