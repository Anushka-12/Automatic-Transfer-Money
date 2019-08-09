import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class TransferMoney extends JFrame {

	private JPanel contentPane;
	private JTextField tfacc;
	private JTextField tfamount;
	private JTextField tfpin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransferMoney frame = new TransferMoney();
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
	public TransferMoney() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Transfer Money");
		lblNewLabel.setFont(new Font("High Tower Text", Font.BOLD, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 31, 260, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No. to transfer money :");
		lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_1.setBounds(10, 135, 224, 42);
		contentPane.add(lblNewLabel_1);
		
		tfacc = new JTextField();
		tfacc.setBounds(244, 142, 299, 30);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_2.setBounds(33, 223, 201, 27);
		contentPane.add(lblNewLabel_2);
		
		tfamount = new JTextField();
		tfamount.setBounds(244, 223, 299, 30);
		contentPane.add(tfamount);
		tfamount.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PIN NUMBER:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Georgia", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(33, 316, 201, 27);
		contentPane.add(lblNewLabel_3);
		
		tfpin = new JTextField();
		tfpin.setBounds(244, 318, 299, 27);
		contentPane.add(tfpin);
		tfpin.setColumns(10);
		
		JButton btnNewButton = new JButton("TRANSFER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=Integer.parseInt(tfacc.getText());
				int amount=Integer.parseInt(tfamount.getText());
				int pin=Integer.parseInt(tfpin.getText());
				try
				{
					Connection con=DBInfo.getConn();
					String query="update atm_info set Amount=Amount+"+amount+" where Account_No="+account+" and Amount=Amount-"+amount+
							" where Pin_No="+pin;
					PreparedStatement ps=con.prepareStatement(query);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Transfer Completed!!");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Shruti", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(188, 389, 168, 42);
		contentPane.add(btnNewButton);
	}

}
