package fr.uds.info006.rainbowtable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.util.ArrayList;

/**
 * Classe de recherche dans le fichier</br> Pour l'algo, allez voir dans
 * l'énoncé.
 * http://www.lama.univ-savoie.fr/~lachaud/Cours/INFO006/Tests/doc/html
 * /tp1.html}
 */
public class TableBrowser {
	static int p=0;
	static int q=0;
	public static void main(String[] args) {
		

		StringBuilder builder = new StringBuilder();
		ArrayList<Element> table = new ArrayList<Element>();
		try (BufferedReader reader = new BufferedReader(new FileReader(
				new File(Thread.currentThread().getContextClassLoader()
						.getResource("table.txt").toURI())))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				table.add(new Element(line.split(";")[0],line.split(";")[1]));
			}

		} catch (IOException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(builder);
		BigInteger y = new BigInteger("16274152309920345780");
		cracker(table,y);
	}
	
	private static String cracker(ArrayList<Element> table, BigInteger y){
		String clair="";
		BigInteger indice;
		for (int t = TableGenerator.t -1;t>0;--t)
		{
			BigInteger decalage=BigInteger.valueOf(t);
			indice = CryptoUtils.h2i(y,decalage);
			
			for(int k= t+1;k<=TableGenerator.t -1;++k)
			{
				BigInteger bk=BigInteger.valueOf(k);
				indice = CryptoUtils.i2i(bk);
			}
			if(search(table,indice))
			{
				for(int m = p;m>=q;++m)
				{
					if(CheckAlert(clair,table,m))
					{
						return clair;
					}
				}
			}
			
		}
		return clair;
	}
	
	private static boolean search(ArrayList<Element> table, BigInteger indice){
		int indiceCourant;
		int debut=0;
		int fin=TableGenerator.m;
		boolean trouve =false;
		while (!trouve && debut<= fin)
		{
			indiceCourant = (debut+fin)/2;
			if (table.get(indiceCourant).getFin().compareTo(indice)==0)
			{
				trouve =true;
			}
			else{
				if (table.get(indiceCourant).getFin().compareTo(indice)==-1)
				{
					fin = indiceCourant-1;
				}
				else
				{
					debut = indiceCourant+1;
				}
			}
			
		}
		if(trouve)
		{
			
			while (table.get(debut).getFin().compareTo(indice)==0)
			{
				debut--;
			}
			while (table.get(fin).getFin().compareTo(indice)==0)
			{
				fin++;
			}
			p=debut;
			q=fin;

			return true;
		}
		else{
			return false;
		}
	}
	private static boolean CheckAlert(String clair, ArrayList<Element> table, int indice){
		//TODO 
		return false;
	}
	
	
}
