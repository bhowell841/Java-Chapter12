import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class TheaterRevenue extends JFrame {
	private JTextField txtAdultPrice;
	private JTextField txtChildPrice;
	private JTextField txtAdultSold;
	private JTextField txtChildSold;
	private final double THEATER_CUT = 0.2;
	
	//constructor
	public TheaterRevenue(){
		setupFrame();
} // end constructor

private void setupFrame(){
	 
		setTitle("Theater Ticket Revenue");
		getContentPane().setLayout(null);

		JPanel pnlAdult = new JPanel();
		pnlAdult.setBounds(10, 11, 197, 195);
		getContentPane().add(pnlAdult);
		pnlAdult.setLayout(null);

		JLabel lblAdultPrice = new JLabel("Price of an adult ticket:");
		lblAdultPrice.setBounds(10, 11, 177, 14);
		pnlAdult.add(lblAdultPrice);

		txtAdultPrice = new JTextField();
		txtAdultPrice.setBounds(10, 36, 177, 20);
		pnlAdult.add(txtAdultPrice);
		txtAdultPrice.setColumns(10);

		JLabel lblAdultSold = new JLabel("Number of adult tickets sold:");
		lblAdultSold.setBounds(10, 80, 187, 60);
		pnlAdult.add(lblAdultSold);

		txtAdultSold = new JTextField();
		txtAdultSold.setBounds(52, 151, 86, 20);
		pnlAdult.add(txtAdultSold);
		txtAdultSold.setColumns(10);

		JPanel pnlChild = new JPanel();
		pnlChild.setBounds(227, 11, 197, 195);
		getContentPane().add(pnlChild);
		pnlChild.setLayout(null);

		JLabel lblChildPrice = new JLabel("Price of a child ticket:");
		lblChildPrice.setBounds(10, 11, 177, 14);
		pnlChild.add(lblChildPrice);

		txtChildPrice = new JTextField();
		txtChildPrice.setBounds(10, 36, 177, 20);
		pnlChild.add(txtChildPrice);
		txtChildPrice.setColumns(10);

		JLabel lblChildSold = new JLabel("Number of child tickets sold:");
		lblChildSold.setBounds(10, 80, 187, 54);
		pnlChild.add(lblChildSold);

		txtChildSold = new JTextField();
		txtChildSold.setBounds(52, 151, 86, 20);
		pnlChild.add(txtChildSold);
		txtChildSold.setColumns(10);

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(170, 217, 89, 23);
		getContentPane().add(btnCalculate);
		
		// listener event to check for button click
				btnCalculate.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						//get data from text fields
						String adultPrice = txtAdultPrice.getText();
						String childPrice = txtChildPrice.getText();
						String adultSales = txtAdultSold.getText();
						String childSales = txtChildSold.getText();
						
						// calculations
						double adultNet = Double.parseDouble(adultPrice) + Double.parseDouble(adultSales);
						double childNet = Double.parseDouble(childPrice) + Double.parseDouble(childSales);
						
						double adultGross = adultNet * THEATER_CUT;
						double childGross = childNet * THEATER_CUT;
						
						double totalNet = adultNet + childNet;
						double totalGross = totalNet * THEATER_CUT;
						
						// Display the calculations
						JOptionPane.showMessageDialog(null, String.format("Adult Net: $%,.2f\n" + 
						"Child Net: $%,.2f\n" + "Total Net: $%,.2f\n" + "Adult Gross: $%,.2f\n" + 
						"Child Gross: $%,.2f\n" + "Total Gross: $%,.2f\n", adultNet, childNet, totalNet, adultGross, childGross, totalGross));
					}
					
				});
	}  //end setupFrame

//Main method
	public static void main(String[] args){
	TheaterRevenue amc = new TheaterRevenue();
	
	// set size of window
			amc.setSize(450, 300);
			// what to do when clicking x
			amc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//  make it visible
			amc.setVisible(true);
	}  // end Main
	
}  //end class
