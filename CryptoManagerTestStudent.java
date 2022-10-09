
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("ABACUS"));
		assertTrue(CryptoManager.isStringInBounds("\"ALGEBRAIC\""));
		assertFalse(CryptoManager.isStringInBounds("omega"));
		assertFalse(CryptoManager.isStringInBounds("{SQUIBBLE"));
		assertFalse(CryptoManager.isStringInBounds("\"IF YOURE NEAR MONTGOMERY COLLEGE GERMANTOWN CAMPUS YOU SHOULD STOP BY THE PHO81 { THEYRE SOUP IS REALLY GOOD I HIGHLY RECOMMEND IT\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("adios", 69));
		assertEquals("HIJ", CryptoManager.caesarEncryption("DEF", 4));
		assertEquals("\'%0%&%7%D+36(", CryptoManager.caesarEncryption("CALABASA GORD", 420));
		assertEquals("29A.C", CryptoManager.caesarEncryption("HOWDY", 106));
		assertEquals("VGUVKPI", CryptoManager.caesarEncryption("TESTING", 2));
		assertEquals("XLMW$QE]$SV$QE]$RSX$FI$ERSXLIV$XIWX", CryptoManager.caesarEncryption("THIS MAY OR MAY NOT BE ANOTHER TEST", 4));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager.caesarDecryption("VGUVKPI", 2));
		assertEquals("THIS IS GETTIND TEDIUS", CryptoManager.caesarDecryption(".\"#-:#-:!_..#(^:._^#/-", 666));
		assertEquals("GOODBYE EVERYONE", CryptoManager.caesarDecryption("KSSHF]I$IZIV]SRI", 196));
		assertEquals("THIS IS NOT ANOTHER TEST", CryptoManager.caesarDecryption("VJKU\"KU\"PQV\"CPQVJGT\"VGUV", 2));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("+MT(!S)Z^", CryptoManager.bellasoEncryption("TESTARINO", "WHAT A LONG CIPHER NERD"));
		assertEquals("PP'T2(R_E'V$\"E!", CryptoManager.bellasoEncryption("HAPPY CHANNUKAH", "HOWDY"));
		assertEquals("WTJ&3)LYGR !T!/MA>U,UX&4", CryptoManager.bellasoEncryption("THIS IS NOT ANOTHER TEST", "CLASS 999"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTARINO", CryptoManager.bellasoDecryption("+MT(!S)Z^", "WHAT A LONG CIPHER NERD"));
		assertEquals("HAPPY CHANNUKAH", CryptoManager.bellasoDecryption("PP'T2(R_E'V$\"E!", "HOWDY"));
		assertEquals("THIS IS NOT ANOTHER TEST", CryptoManager.bellasoDecryption("WTJ&3)LYGR !T!/MA>U,UX&4", "CLASS 999"));

	}

}
