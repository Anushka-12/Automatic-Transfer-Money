import java.awt.BorderLayout;
import java.sql.*;
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

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 26, 166, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME:");
		lblNewLabel_1.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(47, 133, 112, 35);
		contentPane.add(lblNewLabel_1);
		
		tf1 = new JTextField();
		tf1.setBounds(196, 133, 304, 32);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD:");
		lblNewLabel_2.setFont(new Font("PMingLiU-ExtB", Font.ITALIC, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(47, 264, 112, 26);
		contentPane.add(lblNewLabel_2);
		
		tf2 = new JTextField();
		tf2.setBounds(196, 255, 304, 35);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=tf1.getText();
				String pass=tf2.getText();
				try
				{
				Connection con=DBInfo.getConn();
				int flag=0;
				String query="Select * from admin_info";
				PreparedStatement ps=con.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String uname=rs.getString(1);
					String password=rs.getString(2);
					if(uname.equals(username)&& password.equals(pass))
					{
						flag=1;
						break;
					}
				}
				if(flag==1)
				{
					AdminOptions adop=new AdminOptions();
					adop.setVisible(true);
					AdminLogin adl=new AdminLogin();
					adl.setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
				}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(197, 375, 150, 35);
		contentPane.add(btnNewButton);
	}
}
