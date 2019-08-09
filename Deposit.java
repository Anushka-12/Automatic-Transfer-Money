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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class Deposit extends JFrame {

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
					Deposit frame = new Deposit();
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
	public Deposit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 614, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPOSIT MONEY");
		lblNewLabel.setFont(new Font("Poor Richard", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(186, 32, 218, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ACCOUNT NO:");
		lblNewLabel_1.setFont(new Font("Plantagenet Cherokee", Font.ITALIC, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(35, 126, 140, 28);
		contentPane.add(lblNewLabel_1);
		
		tfacc = new JTextField();
		tfacc.setBounds(210, 126, 227, 28);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("AMOUNT :");
		lblNewLabel_2.setFont(new Font("Plantagenet Cherokee", Font.ITALIC, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(53, 230, 100, 28);
		contentPane.add(lblNewLabel_2);
		
		tfamount = new JTextField();
		tfamount.setBounds(210, 230, 227, 28);
		contentPane.add(tfamount);
		tfamount.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PIN NUMBER :");
		lblNewLabel_3.setFont(new Font("Plantagenet Cherokee", Font.ITALIC, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(35, 320, 140, 28);
		contentPane.add(lblNewLabel_3);
		
		tfpin = new JTextField();
		tfpin.setBounds(210, 320, 227, 28);
		contentPane.add(tfpin);
		tfpin.setColumns(10);
		
		JButton btnNewButton = new JButton("Deposit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=Integer.parseInt(tfacc.getText());
				int amount=Integer.parseInt(tfamount.getText());
				int pin=Integer.parseInt(tfpin.getText());
				try
				{
					Connection con=DBInfo.getConn();
					String query="update atm_info set Amount=Amount+"+amount+" where Account_No="+account+" and Pin_No="+pin;
					PreparedStatement ps=con.prepareStatement(query);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Amount Deposited");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Narkisim", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(189, 401, 179, 36);
		contentPane.add(btnNewButton);
	}

}
