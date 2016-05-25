
package ch.hearc.chatvideo.gui;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelTop extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelTop()
		{
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
		labelIp = new JLabel("IP :");
		inputIp = new JTextField();
		labelPort = new JLabel("Port :");
		inputPort = new JTextField("1099");
		connect = new JButton("Connect");

		boxIp = new Box(BoxLayout.X_AXIS);
		boxPort = new Box(BoxLayout.X_AXIS);
		// Layout : Specification
			{

			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		boxIp.add(labelIp);
		boxIp.add(inputIp);
		boxPort.add(labelPort);
		boxPort.add(inputPort);
		boxPort.add(connect);
		add(boxIp);
		add(boxPort);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		setBackground(Color.CYAN);
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

	private Box boxIp;
	private Box boxPort;
	}
