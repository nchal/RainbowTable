package fr.uds.info006.rainbowtable;

import java.math.BigInteger;

public class Element implements Comparable<Element> {

	private BigInteger debut;
	private BigInteger fin;

	public BigInteger getDebut() {
		return debut;
	}

	public void setDebut(BigInteger debut) {
		this.debut = debut;
	}

	public BigInteger getFin() {
		return fin;
	}

	public void setFin(BigInteger fin) {
		this.fin = fin;
	}

	@Override
	public int compareTo(Element e) {
		return e.getFin().compareTo(this.getFin());
	}

	public String save() {
		return getDebut() + ";" + getFin();
	}

}
