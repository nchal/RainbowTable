package fr.uds.info006.rainbowtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class test {

	public static void main(String[] args) throws URISyntaxException,
			IOException {

		File f = new File(Thread.currentThread().getContextClassLoader()
				.getResource("table.txt").toURI());

		// File f2 = new File("C:\\Users\\nicolas\\Desktop\\test.txt");

		System.out.println(f.exists());
		System.out.println(f.canWrite());

		// System.out.println(f2.exists());
		// System.out.println(f2.canWrite());
		//
		// if (!f2.exists()) {
		// f2.createNewFile();
		// }

		// System.out.println(f2.exists());
		// System.out.println(f2.canWrite());

		FileWriter fileWriter = new FileWriter(f);
		// FileWriter fileWriter2 = new FileWriter(f2);

		fileWriter.write("toto");

		// fileWriter2.write("tata");

		// PrintWriter printWriter = new PrintWriter(f2);

		// printWriter.println("toto");

		FileReader fileReader = new FileReader(f);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println(bufferedReader.readLine());

		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
		}
	}
}
