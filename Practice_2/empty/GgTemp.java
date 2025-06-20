package empty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GgTemp {

	public static void main(String[] args) throws IOException {

		// File file = new File ("textfile.txt");
		FileReader reader = new FileReader("empty/textfile.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line;
		//while ((line = bufferedReader.readLine()) != null)
		//{
		//	System.out.println(line);
		//}
		line= bufferedReader.readLine();
		System.out.println(line);
		reader.close();
	}

}
