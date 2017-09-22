import javax.swing.JFrame;

public class BMIDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Body Mass Index");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(700, 300);

		BMI bmi = new BMI();

		frame.getContentPane().add(bmi);
		frame.pack();
		frame.setVisible(true);
	}
}
