package money2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

	public MyFrame() {
		super("Money Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//setSize(640,480);
		//setLocation(200, 200);
		
		//setLayout(new FlowLayout());
		//add(new JButton("Przycisk 1"));
		//add(new JButton("Przycisk 2"));
		//add(new JButton("Przycisk 3"));

		JPanel buttonAddProduct = new AddProductButton();
		add(buttonAddProduct);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}
}