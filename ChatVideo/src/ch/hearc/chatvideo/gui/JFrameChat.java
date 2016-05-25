
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

import ch.hearc.chatvideo.gui.tools.JPanelDecorator;

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

		JPanelDecorator pDBottom = new JPanelDecorator(bottom, 4);
		JPanelDecorator pDTop = new JPanelDecorator(top, 4);
		JPanelDecorator pDRight = new JPanelDecorator(right, 4);
		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		add(center, BorderLayout.CENTER);
		add(pDRight, BorderLayout.EAST);
		add(pDTop, BorderLayout.NORTH);
		add(pDBottom, BorderLayout.SOUTH);
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
	JPanelBottom bottom;
	JPanelRight right;
	JPanelTop top;
	JTextField center;
	}
