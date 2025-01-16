package Spotify;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class createAccount {

	JFrame frame;
	JTextField name; // Class-level variable for username
	static JPasswordField password; // Class-level variable for password
	static String passWord;
	static String userName;

	public static void main(String[] args) {
		createAccount ca = new createAccount();
	}

	// create constructor
	public createAccount() {
		createFrame();
		createFields();
		createButtons();
	}

	public void createFrame() {
		frame = new JFrame("Spotify");
		frame = new JFrame("Create Account");
		frame.setLayout(null);

		frame.getContentPane().setBackground(Color.white);
		Image icon = Toolkit.getDefaultToolkit().getImage("R:\\swingss\\spotify.png");
		frame.setIconImage(icon);

		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public void createFields() {

		JLabel createAcc = new JLabel("Create Account");
		createAcc.setBounds(130, 10, 100, 40);
		frame.add(createAcc);

		// Username label & textfield
		JLabel label1 = new JLabel("Username ");
		label1.setBounds(80, 50, 80, 20);
		frame.add(label1);

		name = new JTextField(20); // Assigning to class-level variable
		name.setBounds(180, 50, 150, 20);
		frame.add(name);

		// Password label & textfield
		JLabel label2 = new JLabel("Password");
		label2.setBounds(80, 90, 80, 20);
		frame.add(label2);

		password = new JPasswordField(20); // Assigning to class-level variable
		password.setBounds(180, 90, 150, 20);
		frame.add(password);

		// Email field & textfield
		JLabel label3 = new JLabel("Email");
		label3.setBounds(80, 130, 80, 20);
		frame.add(label3);
		JTextField textField3 = new JTextField(20);
		textField3.setBounds(180, 130, 150, 20);
		frame.add(textField3);

		// DOB field & textfield
		JLabel label4 = new JLabel("DOB");
		label4.setBounds(80, 170, 80, 20);
		frame.add(label4);
		JTextField textField4 = new JTextField(20);
		textField4.setBounds(180, 170, 150, 20);
		frame.add(textField4);
	}

	public void createButtons() {
		// Sign-up button
		JButton signup = new JButton("Sign-Up");
		signup.setBounds(100, 210, 80, 20);
		frame.add(signup);

		// Cancel button
		JButton cancel = new JButton("Cancel");
		cancel.setBounds(200, 210, 80, 20);
		frame.add(cancel);

		// ActionListener for the sign-up button
		ActionListener acl = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = name.getText(); // Accessing the name variable
				char[] pass = password.getPassword(); // Accessing the password variable

				if (validateUserName(username)) {
					userName = username;

					if (validatePassword(pass)) {
						passWord = new String(pass);
						JOptionPane.showMessageDialog(frame, "Account created successfully!", "SUCCESS",
								JOptionPane.YES_OPTION);
					} else {
						JOptionPane.showMessageDialog(frame, "OOPS,Invalid PASSWORD", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Invalid USERNAME", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		};

		signup.addActionListener(acl);
	}

	public boolean validateUserName(String name) {
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);

			if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
				return false;
			}
		}

		return true;
	}

	public boolean validatePassword(char[] pass) {
		boolean splChar, upper, lower, digit;

		splChar = upper = lower = digit = false;

		if (pass.length >= 8) {
			for (int i = 0; i < pass.length; i++) {
				char ch = pass[i];

				if (ch >= 'a' && ch <= 'z') {
					lower = true;

				} else if (ch >= 'A' && ch <= 'Z') {
					upper = true;

				} else if (ch >= '0' && ch <= '9') {
					digit = true;

				}

				else {
					splChar = true;
				}

				if (upper && lower && digit && splChar) {
					break;
				}
			}

			return upper && lower && digit && splChar;
		}
		return false;
	}
}
