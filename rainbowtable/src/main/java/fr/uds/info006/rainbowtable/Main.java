package fr.uds.info006.rainbowtable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

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

		StringBuilder builder = new StringBuilder();

		try (PrintWriter writer = new PrintWriter(new File(Thread
				.currentThread().getContextClassLoader()
				.getResource("table.txt").toURI()))) {

			for (Element element : elements) {
				writer.println(element.save());
				builder.append(element.save() + "\n");
			}

			writer.print(builder);
			System.out.println(builder);

		} catch (IOException | URISyntaxException e) {

			e.printStackTrace();
		}
	}
}
