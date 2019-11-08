//Name: Nicholas Drazso
//Date: March 18, 2019
//Program Description: This program will utilize a ceasar cipher with either an inputed shift or a default shift of -3 with a message or file input

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class secretSafe {

	//Member variables for shift and different stages of encryption for various types of input
	int shift;
	static String encryptedWord, decryptedWord, encryptedFile, decryptedFile;



	public static void main (String args[]) throws FileNotFoundException {

		//Creates secretSafe object 
		secretSafe ss = new secretSafe(1);

	
	}

	//Defaults shift to -3
	public secretSafe() {
		this.shift = -3;

	}

	//Creates shift given an inputed number 
	public secretSafe(int s) {
		this.shift = s;
	}

	//Encrypts message by converting string into char array then individually manipulating letters
	public String encrypt (String message) {


		char[] letters = message.toCharArray();

		for (int i = 0; i < message.length(); i++) {

			//Leaves spaces alone so they will remain spaces in the output
			if (letters[i] != ' ') {

				//Lower case option
				if (Character.isLowerCase(letters[i])) {
					
					//Assigns letter a number value and adds the shift 
					int character = (int)(letters[i]) + (shift % 26);

					//These two statements will bring the int value back into the range of the alphabet if it has left it
					if (character < 97) 
						character += 26;

					else if (character > 122) 
						character -= 26;


					//Reassigns the location in the char array with the new letter
					letters[i] = (char)(character);
				}

				//Upper case option
				else {
					
					//Assigns letter a number value and adds the shift 
					int character = (int)(letters[i]) + (shift % 26);

					//These two statements will bring the int value back into the range of the alphabet if it has left it
					if (character < 65) 
						character += 26;

					else if (character > 90) 
						character -= 26;

					//Reassigns the location in the char array with the new letter
					letters[i] = (char)(character);
				}
			}
		}

		
		//Saves and returns the encrypted string
		encryptedWord = String.valueOf(letters);

		return encryptedWord;
	}


	//Decrypts message
	public String decrypt (String code) {


		char[] letters = code.toCharArray();

		for (int i = 0; i < code.length(); i++) {
			
			//Ignores spaces since they were never encrypted
			if (letters[i] != ' ') {

				//Lower case option
				if (Character.isLowerCase(letters[i])) {
					
					//Subtracts shift
					int character = (int)(letters[i]) - (shift % 26);

					//These two will bring the number value back into the range of the alphabet if the number exceeds the bounds of the alphabet numerically
					if (character < 97) {
						character += 26;
					}

					else if (character > 122) {
						character -= 26;
					}

					//Overwrites char array position with decrypted letter
					letters[i] = (char)(character);
				}

				//Upper case option
				else {
					
					//Subtracts shift
					int character = (int)(letters[i]) - (shift % 26);

					//These two will bring the number value back into the range of the alphabet if the number exceeds the bounds of the alphabet numerically
					if (character < 65) {
						character += 26;
					}

					else if (character > 90) {
						character -= 26;
					}

					//Overwrites char array position with decrypted letter
					letters[i] = (char)(character);
				}

			}
		}

		//Saves and returns decrypted string
		decryptedWord = String.valueOf(letters);

		return decryptedWord;
	}

	//Encrypts file input 
	public String encryptFile (String inFile) throws FileNotFoundException {

		//Creates scanner for file input and string to store information in file
		Scanner scanner = new Scanner(new File(inFile));
		String message = "";

		//Reads in file
		message = scanner.nextLine();

		//Saves and returns encrypted file
		encryptedFile = encrypt(message);

		return encryptedFile;
	}

	//Decrypts file input
	public String decryptFile (String inFile) throws FileNotFoundException {

		//Saves encrypted file to string
		String word = inFile;
		
		//Saves and returns decrypted file
		decryptedFile = decrypt(word);
		
		return decryptedFile;
	}
}