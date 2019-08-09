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

public class OptionsATM_Services extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsATM_Services frame = new OptionsATM_Services();
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
	public OptionsATM_Services() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 616, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Services Provided");
		lblNewLabel.setFont(new Font("Castellar", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 22, 447, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BALANCE INQUIRY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BalanceInquiry bal=new BalanceInquiry();
				bal.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Algerian", Font.ITALIC, 19));
		btnNewButton.setBounds(20, 147, 202, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("WITHDRAWAL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Withdrawal withdraw=new Withdrawal();
				withdraw.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Algerian", Font.ITALIC, 19));
		btnNewButton_1.setBounds(20, 266, 202, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TRANSFER MONEY");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TransferMoney transfer=new TransferMoney();
				transfer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Algerian", Font.ITALIC, 19));
		btnNewButton_2.setBounds(208, 372, 202, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DEPOSIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Deposit deposit=new Deposit();
				deposit.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Algerian", Font.ITALIC, 19));
		btnNewButton_3.setBounds(363, 147, 202, 43);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("PIN CHANGE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PinChange pin=new PinChange();
				pin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Algerian", Font.ITALIC, 19));
		btnNewButton_4.setBounds(363, 266, 202, 40);
		contentPane.add(btnNewButton_4);
	}

}
