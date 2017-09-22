import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BMI extends JPanel {

	private static final long serialVersionUID = 5878266815205052871L;

	private final Dimension PANEL_SIZE = new Dimension(300, 200);
	private final Color BACKGROUND_COLOR = Color.white;
	private JTextField weight;
	private JTextField height;
	private JLabel resultDescription;
	private JLabel bmi;

	public BMI() {
		setPreferredSize(PANEL_SIZE);
		setBackground(BACKGROUND_COLOR);

		JPanel bmiPanel = createBmiPanel();
		add(bmiPanel);

		JPanel bmiButton = createBmiButton();
		add(bmiButton);

	}

	private JPanel createBmiPanel() {
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(PANEL_SIZE.width, 2 * PANEL_SIZE.height / 3));

		JLabel weightLabel = new JLabel("Bodyweight (kg): ");
		weight = new JTextField(12);
		JLabel heightLabel = new JLabel("Height (m): ");
		height = new JTextField(12);
		resultDescription = new JLabel("Result Description");
		resultDescription.setFont(new Font("Ariel", Font.BOLD, 15));
		bmi = new JLabel("Body Mass Index: ___");
		bmi.setFont(new Font("Ariel", Font.BOLD, 17));

		textPanel.add(weightLabel);
		textPanel.add(weight);
		textPanel.add(heightLabel);
		textPanel.add(height);
		textPanel.add(bmi);
		textPanel.add(resultDescription);

		return textPanel;
	}

	private JPanel createBmiButton() {
		JPanel panelButton = new JPanel();
		panelButton.setPreferredSize(new Dimension(PANEL_SIZE.width, PANEL_SIZE.height / 3));
		panelButton.setBackground(Color.blue);

		JButton calculateBmi = new JButton("Calculate BMI");
		panelButton.add(calculateBmi);
		JButton reset = new JButton("Reset");
		panelButton.add(reset);

		CustomListener listener = new CustomListener(calculateBmi, reset);
		reset.addActionListener(listener);
		calculateBmi.addActionListener(listener);

		return panelButton;
	}

	private class CustomListener implements ActionListener {
		private JButton bmiButton, resetButton;

		public CustomListener(JButton bmi, JButton clear) {
			bmiButton = bmi;
			resetButton = clear;
		}

		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == bmiButton) {
				String text = height.getText();
				double h = Double.parseDouble(text);
				text = weight.getText();
				double w = Double.parseDouble(text);
				System.out.println("Waga = " + w + ", Wzrost = " + h);
				double result = Math.round(w / (h * h));
				if (result > 0 && result == 15) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Very severely underweight");
				} else if (result > 15 && result <= 16) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Severely underweight");
				} else if (result > 16 && result <= 18.5) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Underweight");
				} else if (result > 18.5 && result <= 25) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Normal (healthy weight)");
				} else if (result > 25 && result <= 30) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Overweight");
				} else if (result > 30 && result <= 35) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Obese Class I (Moderately obese)");
				} else if (result > 35 && result <= 40) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Obese Class II (Severely obese)");
				} else if (result > 40) {
					bmi.setText("Body Mass Index: " + result);
					resultDescription.setText("Obese Class III (Very severely obese)");
				}

			} else if (event.getSource() == resetButton) {
				height.setText("");
				weight.setText("");
				resultDescription.setText("Result Description");
				bmi.setText("Body Mass Index: ---");
			}
		}
	}
}
