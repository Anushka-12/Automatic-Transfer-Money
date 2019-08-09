import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
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
	public AdminOptions() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 621, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME ADMIN");
		lblNewLabel.setFont(new Font("SimSun-ExtB", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(153, 41, 269, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add New User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_User add=new Add_User();
				add.setVisible(true);
				AdminOptions adop=new AdminOptions();
				adop.setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Sylfaen", Font.ITALIC, 22));
		btnNewButton.setBounds(56, 201, 192, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete User");
		btnNewButton_1.setFont(new Font("Sylfaen", Font.ITALIC, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteUser del=new DeleteUser();
				del.setVisible(true);
				AdminLogin adlo=new AdminLogin();
				adlo.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(352, 201, 183, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateUser upd=new UpdateUser();
				upd.setVisible(true);
				AdminLogin adlo=new AdminLogin();
				adlo.setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Sylfaen", Font.ITALIC, 22));
		btnNewButton_2.setBounds(205, 342, 183, 55);
		contentPane.add(btnNewButton_2);
	}

}
