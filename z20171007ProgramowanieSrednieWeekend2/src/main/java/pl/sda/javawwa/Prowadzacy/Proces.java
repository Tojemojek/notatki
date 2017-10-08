package pl.sda.javawwa.Prowadzacy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

/**
 * Ilustracja zagadnienia synchronizacji na poziomie procesu.
 * 
 * @author mj
 *
 */
public class Proces {
	
	private static File semafor = new File("semafor.lock");
	
	static{
		semafor.deleteOnExit();
	}

	public static void main(String[] args) throws Exception {
		dopiszDoPliku(args);
	}

	private static void dopiszDoPliku(String[] args) throws IOException, InterruptedException {
		while (true) {
			if (sprobojZablokowac()) {
				System.out.println("Zablokowalem, bede pisal");
				zapisz(args);
				usunBlokade();
				break;
			} else {
				System.out.println("Oczekuje na zwolnienie blokady");
			}
		}
		System.out.println("Zakonczylem pisanie");
	}

	private static void usunBlokade() {
		semafor.delete();
	}

	private static void zapisz(String[] args) throws IOException {
		Path sciezka = Paths.get("plikZapisu.txt");
		if(!sciezka.toFile().exists()){
			sciezka.toFile().createNewFile();
		}
		Files.write(Paths.get("plikZapisu.txt"), Arrays.asList(args), Charset.defaultCharset(), StandardOpenOption.APPEND);
	}

	private static boolean sprobojZablokowac() throws IOException {
		return semafor.createNewFile();
	}
}
