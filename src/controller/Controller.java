package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Board;
import model.Dir;
import model.Game;
import model.Hunter;

public class Controller extends JPanel implements KeyListener{
	JButton north,south,east,west;
	Game game;
	JTextField textField;
	public Controller(Game g){
		textField = new JTextField(10);
		north = new JButton("North");
		south = new JButton("South");
		east = new JButton("East");
		west = new JButton("West");
		north.addActionListener( new NorthActionListener());
		west.addActionListener( new WestActionListener());
		east.addActionListener( new EastActionListener());
		south.addActionListener( new SouthActionListener());
		
		this.setLayout(new BorderLayout());	
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(textField, BorderLayout.CENTER);
		game = g;
	}

	private class NorthActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			game.fireArrow(Dir.NORTH);
			textField.setText("ARROW FIRED!");
		}
	}
	private class SouthActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.fireArrow(Dir.SOUTH);
			textField.setText("ARROW FIRED!");
		}
	}
	private class EastActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.fireArrow(Dir.EAST);
			textField.setText("ARROW FIRED!");
		}
	}
	private class WestActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0){
			game.fireArrow(Dir.WEST);
			textField.setText("ARROW FIRED!");
		}
	}

	@Override
	public void keyPressed(KeyEvent ke){
		if(ke.getKeyCode() == KeyEvent.VK_UP){
			textField.setText(game.getCurrentTile());
			game.move(Dir.NORTH);
		}
		if(ke.getKeyCode() == KeyEvent.VK_DOWN){
			game.move(Dir.SOUTH);
			textField.setText(game.getCurrentTile());
		}
		if(ke.getKeyCode() == KeyEvent.VK_LEFT){
			game.move(Dir.WEST);
			textField.setText(game.getCurrentTile());
		}
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT){
			game.move(Dir.EAST);
			textField.setText(game.getCurrentTile());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
