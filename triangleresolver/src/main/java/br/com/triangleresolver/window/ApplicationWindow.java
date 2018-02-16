package br.com.triangleresolver.window;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.triangleresolver.TriangleResolver;

public class ApplicationWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTextField input;

	public ApplicationWindow() {
		configJFrame();
	}

	private void configJFrame() {
		setLayout(new FlowLayout());
		this.input = new JTextField();
		this.input.setColumns(50);
		add(input);
		JButton button = new JButton("Resultado");

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String triangleArray = input.getText();

				try {
					TriangleResolver triangleResolver = new TriangleResolver(triangleArray);
					JOptionPane.showMessageDialog(null, triangleResolver.maxTotal());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);

				}

			}

		});

		add(button);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {

		ApplicationWindow applicationWindow = new ApplicationWindow();
		applicationWindow.setVisible(true);
		applicationWindow.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
