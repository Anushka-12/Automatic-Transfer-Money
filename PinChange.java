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
public class PinChange extends JFrame {

	private JPanel contentPane;
	private JTextField tfacc;
	private JTextField tfpinold;
	private JTextField tfpinnew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PinChange frame = new PinChange();
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
	public PinChange() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 604, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PIN CHANGE");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(166, 32, 224, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No:");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.ITALIC, 21));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(54, 126, 153, 32);
		contentPane.add(lblNewLabel_1);
		
		tfacc = new JTextField();
		tfacc.setBounds(219, 126, 224, 32);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("OLD PIN :");
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.ITALIC, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(54, 224, 138, 32);
		contentPane.add(lblNewLabel_2);
		
		tfpinold = new JTextField();
		tfpinold.setBounds(219, 224, 224, 32);
		contentPane.add(tfpinold);
		tfpinold.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NEW PIN :");
		lblNewLabel_3.setFont(new Font("Rockwell Condensed", Font.ITALIC, 21));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(54, 316, 138, 24);
		contentPane.add(lblNewLabel_3);
		
		tfpinnew = new JTextField();
		tfpinnew.setBounds(219, 308, 224, 32);
		contentPane.add(tfpinnew);
		tfpinnew.setColumns(10);
		
		JButton btnNewButton = new JButton("CHANGE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=Integer.parseInt(tfacc.getText());
				int oldpin=Integer.parseInt(tfpinold.getText());
				int newpin=Integer.parseInt(tfpinnew.getText());
				try
				{
					Connection con=DBInfo.getConn();
					String query="update atm_info set Pin_No="+newpin+" where Account_No="+account+" and Pin_No="+oldpin;
					PreparedStatement ps=con.prepareStatement(query);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Pin Number Updated");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Ravie", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(190, 393, 200, 40);
		contentPane.add(btnNewButton);
	}

}
