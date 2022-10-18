package general;

import java.io.File;
import java.io.IOException;

public class RenameFiles {

	public static void main(String[] args) throws IOException {
		// Create an object of the File class
		// Replace the file path with path of the directory
		File folder = new File("C:\\Users\\gaura\\Downloads\\System Design - Alex Xu");

		if (folder.isDirectory()) {
			File files[] = folder.listFiles();

			for (File currentFile : files) {
				String renamed = currentFile.getName().replace("-", " ");// remove dash
				renamed = changeFirstToCaps(renamed); // change to first letter of name to Uppercase
				renamed = addDotAfterNumbers(renamed);//add dot after numbers 
				String path = currentFile.getPath().substring(0, currentFile.getPath().lastIndexOf(File.separator) + 1);

				File renamedFile = new File(path + renamed);
				boolean flag = currentFile.renameTo(renamedFile);
				if (!flag)
					System.out.println("Operation Failed");
			}
		}

	}

	static String changeFirstToCaps(String str) {

		char[] c = str.toCharArray();

		boolean space = true;

		for (int i = 0; i < c.length; i++) {

			Character current = c[i];
			if (space)
				c[i] = Character.toUpperCase(current);

			if (current.equals(' ')) {
				space = true;
			} else
				space = false;

		}

		return new String(c);
	}

	static String addDotAfterNumbers(String str) {

		char[] c = str.toCharArray();
		boolean space = false;
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < c.length; i++) {

			Character current = c[i];
			if (current == ' ' && Character.isDigit(c[i - 1])) {
				sb.append('.');
				sb.append(current);
			} else
				sb.append(current);
		}
		return sb.toString();
	}
}
