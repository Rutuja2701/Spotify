package Spotify;
	import java.awt.Color;
	import java.awt.Cursor;
	import java.awt.Image;
	import java.awt.Toolkit;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPasswordField;
	import javax.swing.JTextField;

	public class LoginPage {
		
		JFrame frame;
		JTextField unInput;
		JPasswordField psInput;
		
			public static void main(String[] args) {
				LoginPage login = new LoginPage();
			}
		
		
		public LoginPage() {
			createFrame();
			createField();
			createButton();
		}
		
		public void createFrame()
		{
			frame = new JFrame("Login");
			frame.setLayout(null);
			frame.setSize(500,300);
			Image img = Toolkit.getDefaultToolkit().getImage("D:\\FileHandle\\Internship Logo\\QSPLogo.jpg\\");
	        frame.getContentPane().setBackground(Color.white);
			frame.setIconImage(img);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		
		public void createField()
		{
			
			JLabel un = new JLabel("Username: ");
			un.setBounds(90, 50, 100, 40);
			frame.add(un);
			
			unInput = new JTextField();
			unInput.setBounds(160, 63, 140, 20);
			frame.add(unInput);
			
			JLabel ps = new JLabel("Password: ");
			ps.setBounds(90, 80, 100, 40);
			frame.add(ps);
			
			psInput = new JPasswordField();
			psInput.setBounds(160, 93, 140, 20);
			frame.add(psInput);
			
			JLabel createAccount = new JLabel("Don't have an account");
			createAccount.setBounds(90, 120, 300, 20);
			frame.add(createAccount);
			createAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			createAccount.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e)
				{
					createAccount account = new createAccount();
				}
			});
			
		}
		
		public void createButton()
		{
			JButton btn1 = new JButton("Login");
			btn1.setBounds(150, 143, 80, 20);
			frame.add(btn1);
			
			btn1.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					String username = unInput.getText();
					char[] password = psInput.getPassword();
					String pass = new String(password);
					try {
						if(createAccount.userName.equals(username) && createAccount.password.equals(pass))
						{
							JOptionPane.showMessageDialog(frame, "Login successfull...!", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Invalid Credential", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch (NullPointerException np) {
						JOptionPane.showMessageDialog(frame, "Account Not Created..!", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
	}

