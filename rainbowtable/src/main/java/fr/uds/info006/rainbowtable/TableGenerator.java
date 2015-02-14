package fr.uds.info006.rainbowtable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe qui génère le fichier avec la liste des index triés</br> Il faut lancé
 * cette classe une fois (ça prend mass temps normalement)</br>Pour avoir plus
 * de chance de réussite, il faut jouer avec les variables M et T mais ça prend
 * plus de temps.
 */
public class TableGenerator {

	public static void main(String[] args) {

		int m = 2000;
		int t = 1000;

		List<Element> elements = new ArrayList<Element>();

		System.out.println("Creation graphs....");

		for (int i = 0; i < m; i++) {

			Element e = new Element();
			BigInteger random = CryptoUtils.genRand();
			e.setDebut(random);
			e.setFin(random);

			for (int j = 0; j < t; j++) {

				e.setFin(CryptoUtils.i2i(e.getFin()));
			}

			elements.add(e);
		}

		System.out.println("Tri list....");

		Collections.sort(elements);

		System.out.println("Save File");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(
				new File(Thread.currentThread().getContextClassLoader()
						.getResource("table.txt").toURI())))) {

			for (Element element : elements) {
				writer.append(element.save());
			}

		} catch (IOException | URISyntaxException e) {

			e.printStackTrace();
		}
	}
}
