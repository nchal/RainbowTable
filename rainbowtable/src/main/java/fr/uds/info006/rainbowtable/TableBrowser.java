package fr.uds.info006.rainbowtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Classe de recherche dans le fichier</br> Pour l'algo, allez voir dans
 * l'énoncé.
 * http://www.lama.univ-savoie.fr/~lachaud/Cours/INFO006/Tests/doc/html
 * /tp1.html}
 */
public class TableBrowser {

	public static void main(String[] args) {

		StringBuilder builder = new StringBuilder();

		try (BufferedReader reader = new BufferedReader(new FileReader(
				new File(Thread.currentThread().getContextClassLoader()
						.getResource("table.txt").toURI())))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
			}

		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
