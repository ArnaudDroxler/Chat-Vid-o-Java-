
package ch.hearc.chatvideo.gui;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import ch.hearc.chatvideo.gui.tools.JPanelDecorator;
import ch.hearc.chatvideo.pc.chat.Chat_I;

public class JPanelCenter extends JPanel
	{

	/*------------------------------------------------------------------*\
	|*							Constructeurs							*|
	\*------------------------------------------------------------------*/

	public JPanelCenter(Chat_I _shared, JTextArea _textArea)
		{
		textArea = _textArea;
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
		JPanelDecorator pDTextArea = new JPanelDecorator(textArea, 4);
		// Layout : Specification
			{
			FlowLayout flowlayout = new FlowLayout(FlowLayout.CENTER);
			setLayout(flowlayout);

			// flowlayout.setHgap(20);
			// flowlayout.setVgap(20);
			}

		// JComponent : add
		add(pDTextArea);
		}

	private void control()
		{
		// rien
		}

	private void appearance()
		{
		// rien
		}

	/*------------------------------------------------------------------*\
	|*							Attributs Private						*|
	\*------------------------------------------------------------------*/

	//Input
	private JTextArea textArea;
	}
