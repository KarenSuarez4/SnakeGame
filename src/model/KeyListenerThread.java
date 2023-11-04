package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyListenerThread extends Thread implements KeyListener {
	private int keyCode;
	
	public KeyListenerThread(JFrame myFrame) {
		myFrame.addKeyListener(this);
		keyCode = 39;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyCode = e.getKeyCode();
	}

	public int getKeyCode() {
		return keyCode;
	}
}
