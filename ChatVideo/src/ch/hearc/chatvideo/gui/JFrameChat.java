
package ch.hearc.chatvideo.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import ch.hearc.chatvideo.gui.tools.JPanelDecorator;
import ch.hearc.chatvideo.pc.SharedJtextArea;

public class JFrameChat extends JFrame
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JFrameChat(SharedJtextArea remote)
		{
		this.shared = remote;
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
		bottom = new JPanelBottom(shared);
		right = new JPanelRight();

		JPanelDecorator pDBottom = new JPanelDecorator(bottom, 4);
		JPanelDecorator pDRight = new JPanelDecorator(right, 4);

		// Layout : Specification
			{
			BorderLayout borderLayout = new BorderLayout();
			setLayout(borderLayout);

			// borderLayout.setHgap(20);
			// borderLayout.setVgap(20);
			}

		add(shared, BorderLayout.CENTER);
		add(pDRight, BorderLayout.EAST);
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

	private JPanelBottom bottom;
	private JPanelRight right;
	private SharedJtextArea shared;
	}
