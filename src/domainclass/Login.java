package domainclass;

import java.util.*;
import java.io.*;

public class Login { 

		private String username;
		private String password;		
		
		public String getUsername() {
			return this.username;
		}

		public String getPassword() {
			return this.password;
		}

		// retrieve username & password from .txt file
		public void initialAccount(String filepath) {
		
		
			try {
				Scanner x = new Scanner(new File(filepath));
				x.useDelimiter("[,\n]");

				while (x.hasNext()) {
					this.username = x.next();
					this.password = x.next();
				}
			} catch (Exception e) {
				System.out.println("initialAccount login.txt has error!");
			}
		}

	// validate input from user
		public boolean validateLogin(String username, String password) {

			try {
				if (username.trim().equals(this.username) && password.trim().equals(this.password))
					return true;
			} catch (Exception e) {
				System.out.println("verifyLogin has error.");
			}
			return false;
		
		// here

		}
		public static void main(String[] args) {
			new Login();
		}
}

