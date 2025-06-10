package basics_large;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Create_File {
	public static void main(String[] args) throws IOException {
		File file = new File("JavaFile.java");

		boolean isFileCreated = file.createNewFile();
		if (isFileCreated) {
			System.out.println("New Java File is created.");
		} else {
			System.out.println("The file already exists.");
		}

		String program = "public class JavaFile { " + "public static void main(String[] args) { "
				+ "System.out.println(\"This is file\");" + "}" + "}";

		try (FileWriter output = new FileWriter("JavaFile.java")) {
			output.write(program);
			System.out.println("Data is written to the file.");
		}
	}
}
