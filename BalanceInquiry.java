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
public class BalanceInquiry extends JFrame {

	private JPanel contentPane;
	private JTextField tfacc;
	private JTextField tfpin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BalanceInquiry frame = new BalanceInquiry();
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
	public BalanceInquiry() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 612, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Balance Inquiry");
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(90, 27, 384, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(82, 140, 94, 29);
		contentPane.add(lblNewLabel_1);
		
		tfacc = new JTextField();
		tfacc.setBounds(186, 140, 274, 29);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PIN NO. :");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		lblNewLabel_2.setBounds(90, 239, 86, 29);
		contentPane.add(lblNewLabel_2);
		
		tfpin = new JTextField();
		tfpin.setBounds(191, 239, 269, 29);
		contentPane.add(tfpin);
		tfpin.setColumns(10);
		
		JButton btnNewButton = new JButton("SHOW BALANCE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=Integer.parseInt(tfacc.getText());
				int pin=Integer.parseInt(tfpin.getText());
				try
				{
					Connection con=DBInfo.getConn();
					String query="Select amount from atm_info where Account_No="+account+" and Pin_No="+pin;
					PreparedStatement ps=con.prepareStatement(query);
					ResultSet res=ps.executeQuery();
					res.next();
					JOptionPane.showMessageDialog(null, "Your balance is "+res.getInt("Amount"));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Felix Titling", Font.BOLD, 21));
		btnNewButton.setBounds(186, 362, 261, 38);
		contentPane.add(btnNewButton);
	}
}
