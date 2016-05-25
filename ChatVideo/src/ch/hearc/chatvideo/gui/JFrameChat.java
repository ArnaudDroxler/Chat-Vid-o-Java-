
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameChat extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameChat()
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
		bottom = new JPanelBottom();
		right = new JPanelRight();
		top = new JPanelTop();
		center = new JTextField();
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		add(center, BorderLayout.CENTER);
		add(right, BorderLayout.EAST);
		add(top, BorderLayout.NORTH);
		add(bottom, BorderLayout.SOUTH);
		}

	private void control()
		{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

	private void appearance()
		{
		setSize(600, 400);
		setLocationRelativeTo(null); // frame centrer
		setVisible(true); // last!
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	// Tools
	private JPanelBottom bottom;
	private JPanelRight right;
	private JPanelTop top;
	private JTextField center;
	}
