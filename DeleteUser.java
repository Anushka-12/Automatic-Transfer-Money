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
public class DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField tfacc;
	private JTextField tfname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 599, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDeleteUser = new JLabel("DELETE USER");
		lblDeleteUser.setFont(new Font("SimSun-ExtB", Font.BOLD, 24));
		lblDeleteUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteUser.setBounds(198, 27, 179, 42);
		contentPane.add(lblDeleteUser);
		
		JLabel lblNewLabel = new JLabel("Account No:");
		lblNewLabel.setFont(new Font("Traditional Arabic", Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 143, 117, 36);
		contentPane.add(lblNewLabel);
		
		tfacc = new JTextField();
		tfacc.setBounds(198, 143, 254, 26);
		contentPane.add(tfacc);
		tfacc.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Traditional Arabic", Font.ITALIC, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(45, 254, 117, 19);
		contentPane.add(lblName);
		
		tfname = new JTextField();
		tfname.setBounds(198, 247, 254, 26);
		contentPane.add(tfname);
		tfname.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int account=Integer.parseInt(tfacc.getText());
				String name=tfname.getText();
				try
				{
					Connection con=DBInfo.getConn();
					String query="delete from atm_info where Account_No=? and Name=?";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, account);
					ps.setString(2, name);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "User Deleted");
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Sakkal Majalla", Font.BOLD, 24));
		btnDelete.setBounds(205, 358, 147, 42);
		contentPane.add(btnDelete);
	}

}
