
package ch.hearc.chatvideo.pc.chat;

import javax.swing.JTextArea;

public class SharedJtextArea extends JTextArea implements Chat_I
	{

	@Override
	public void send(String s)
		{
		this.append(s);
		}
	}
