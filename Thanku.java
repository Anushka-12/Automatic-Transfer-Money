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

public class Thanku extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thanku frame = new Thanku();
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
	public Thanku() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 611, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THANK YOU!!");
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(128, 77, 317, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Avail More Services");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OptionsATM_Services option=new OptionsATM_Services();
				option.setVisible(true);
				Thanku thanku=new Thanku();
				thanku.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 22));
		btnNewButton.setBounds(128, 223, 338, 58);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Log Out From The Session");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
				Thanku thanku=new Thanku();
				thanku.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 22));
		btnNewButton_1.setBounds(128, 345, 338, 58);
		contentPane.add(btnNewButton_1);
	}

}
