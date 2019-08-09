import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Add_User extends JFrame {

	private JPanel contentPane;
	private JTextField tfacc;
	private JTextField tfname;
	private JTextField tfadd;
	private JTextField tfmobile;
	private JTextField tfpin;
	private JTextField tfamount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_User frame = new Add_User();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add_User() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 624, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD USER");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(171, 21, 224, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No:");
		lblNewLabel_1.setBounds(48, 116, 103, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setBounds(48, 177, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(48, 239, 103, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile");
		lblNewLabel_4.setBounds(48, 295, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		tfacc = new JTextField();
		tfacc.setBounds(195, 113, 278, 27);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		tfname = new JTextField();
		tfname.setBounds(195, 177, 278, 27);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		tfadd = new JTextField();
		tfadd.setBounds(195, 236, 278, 27);
		contentPane.add(tfadd);
		tfadd.setColumns(10);
		
		tfmobile = new JTextField();
		tfmobile.setBounds(195, 292, 278, 27);
		contentPane.add(tfmobile);
		tfmobile.setColumns(10);
		
		JLabel lblPinNumber = new JLabel("Pin Number");
		lblPinNumber.setBounds(48, 357, 87, 14);
		contentPane.add(lblPinNumber);
		
		tfpin = new JTextField();
		tfpin.setBounds(195, 351, 278, 27);
		contentPane.add(tfpin);
		tfpin.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(48, 411, 46, 14);
		contentPane.add(lblAmount);
		
		tfamount = new JTextField();
		tfamount.setBounds(195, 401, 278, 27);
		contentPane.add(tfamount);
		tfamount.setColumns(10);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=(Integer.parseInt(tfacc.getText()));
				String name=tfname.getText();
				String address=tfadd.getText();
				int mobile=Integer.parseInt(tfmobile.getText());
				int pin=Integer.parseInt(tfpin.getText());
				int amount=Integer.parseInt(tfamount.getText());
				try
				{
					Connection con=DBInfo.getConn();
					String query="insert into atm_info values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, account);
					ps.setString(2, name);
					ps.setString(3, address);
					ps.setInt(4, mobile);
					ps.setInt(5, pin);
					ps.setInt(6, amount);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Inserted");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnAddCustomer.setBounds(131, 479, 325, 50);
		contentPane.add(btnAddCustomer);
	}
}
