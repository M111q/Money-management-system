package money2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddProductButton extends JPanel implements ActionListener{

	private JButton addProductBtn;
	public static final int HEIGHT = 300;
	public static final int WIDTH = 600;
	public AddProductButton() {
		addProductBtn = new JButton("Dodaj produkt");


		addProductBtn.addActionListener(this);

		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		add(addProductBtn);

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if(source == addProductBtn)
			setBackground(Color.GREEN);
			

	}

}
