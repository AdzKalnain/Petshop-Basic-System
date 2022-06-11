package bscs2b_group4;

import java.io.*;
import java.util.*;

public class TransactionDataManagement {	
	public static void createObjectFile(Object data, String filename) {
			File outFile;
			FileOutputStream outFileStream;
			ObjectOutputStream outObjectStream;

			try {
				outFile = new File("record.dat");
				outFileStream = new FileOutputStream(outFile);
				outObjectStream = new ObjectOutputStream(outFileStream);

				outObjectStream.writeObject(data);

				outObjectStream.close();
			} catch (FileNotFoundException e) {
				System.out.print("File not found.");
			} catch (IOException e) {
				System.out.print("ERROR:" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
			}
		}

	public static ArrayList readObjectFile(String filename) {
			File inFile;
			FileInputStream inFileStream;
			ObjectInputStream inObjectStream;

			ArrayList list = new ArrayList();

			try {
				inFile = new File(filename);
				inFileStream = new FileInputStream(inFile);
				inObjectStream = new ObjectInputStream(inFileStream);

				list = (ArrayList) inObjectStream.readObject();

				inObjectStream.close();
			} catch (FileNotFoundException e) {
				System.out.print("File not found.");
			} catch (ClassNotFoundException e) {
				System.out.println("Class is not found in the file");
			} catch (IOException e) {
				System.out.print("ERROR:" + e.getMessage());
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Something went wrong...");
			}
			return list;
		}
}
