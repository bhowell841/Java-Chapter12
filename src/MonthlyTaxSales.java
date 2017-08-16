import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*Brendan Howell
 * CSC-251
 * Monthly Tax Sales Assignment
 * 
 * Create a GUI application that allows 
 * the user to enter the total sales for 
 * the month into a text field and calculate 
 * the county sales tax, state sales tax, 
 * and total sales tax.
 */
public class MonthlyTaxSales extends JFrame{
	private JPanel panel;
	private JLabel messageLabel;
	private JTextField salesTextField;
	private JButton calcButton;
	private int WINDOW_WIDTH = 350;
	private int WINDOW_HEIGHT = 100;
	private final double COUNTY_TAX = 0.04;
	private final double STATE_TAX = 0.02;
	

	public MonthlyTaxSales(){
		setTitle("Tax Calculator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildPanel();
		add(panel);
		setVisible(true);
	}

	private void buildPanel() {
		// Create the label, textfield and calcbutton
		messageLabel = new JLabel("Enter the months total sales:");
		salesTextField = new JTextField(10);
		calcButton = new JButton("Calculate");
		calcButton.addActionListener(new CalcButtonListener ());
		
		//  Create the panel and add the components
		panel = new JPanel();
		panel.add(messageLabel);
		panel.add(salesTextField);
		panel.add(calcButton);
	}  //End Method
	
	private class CalcButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			String input;
			double totalTax;
			double stateTax;
			double countyTax;
			
			input = salesTextField.getText();
			
			// Calculate the taxes
			countyTax = Double.parseDouble(input) * COUNTY_TAX;
			stateTax = Double.parseDouble(input) * STATE_TAX;
			totalTax = stateTax + countyTax;
			
			// Display the calculations
			JOptionPane.showMessageDialog(null, String.format("County Taxes: $%,.2f\n" + 
			"State Taxes: $%,.2f\n" + "Total Taxes: $%,.2f", countyTax, stateTax, totalTax));
			
		}  //End actionPerformed
	}  //End CalcbuttonListener
	// Main method
	public static void main(String[] args){
	new MonthlyTaxSales();
	}
}  //End Class
