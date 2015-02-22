package fr.uds.info006.rainbowtable;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.Random;

import org.apache.commons.codec.digest.DigestUtils;

public class CryptoUtils {

	public static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final BigInteger alphabetLength = new BigInteger(
			String.valueOf(alphabet.length()));
	public static final int size = 5;
	public static final BigInteger powValue = alphabetLength.pow(size);

	public static final int M_PARAM = 80000;
	public static final int T_PARAM = 1000;

	public static String i2c(BigInteger indice) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < size; i++) {

			BigInteger modulo = indice.mod(alphabetLength);
			builder.insert(0, alphabet.charAt(modulo.intValue()));
			indice = indice.divide(alphabetLength);
		}

		return builder.toString();
	}

	public static BigInteger c2h(String clair) {

		return new BigInteger(DigestUtils.md5(clair));
	}

	public static BigInteger h2i(BigInteger hash, BigInteger decalage) {

		BigInteger hashDecale = hash.add(decalage);

		return hashDecale.mod(powValue);
	}

	public static BigInteger i2i(BigInteger indice, BigInteger decalage) {

		return h2i(c2h(i2c(indice)), decalage);
	}

	public static BigInteger genRand() {

		BigDecimal random = new BigDecimal(new Random().nextDouble());
		random = random.movePointRight(random.precision() + 1);
		BigInteger newIndice = random.toBigInteger().mod(powValue);
		return newIndice;
	}
}
