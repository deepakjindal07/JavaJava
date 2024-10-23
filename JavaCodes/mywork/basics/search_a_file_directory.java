package basics;

import java.io.File;
import java.io.FilenameFilter;

class MyFilenameFilter implements FilenameFilter {

	String initials;

	public MyFilenameFilter(String initials) {
		this.initials = initials;
	}

	@Override
	public boolean accept(File dir, String name) {
		return name.startsWith(initials);
	}
}

public class search_a_file_directory {

	public static void main(String[] args) {

		File directory = new File("/home/user/");

		MyFilenameFilter filter = new MyFilenameFilter("file.cpp");

		String[] flist = directory.list(filter);

		if (flist == null) {
			System.out.println("Empty directory or directory does not exists.");
		} else {

			for (String element : flist) {
				System.out.println(element + " found");
			}
		}
	}
}
