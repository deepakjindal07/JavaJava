package random_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample {
	public static void main(String[] args) throws IOException {
		{
			try

			(BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
				String line;
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				System.err.println("File not found: " + e.getMessage());
			}
		}
	}
}
