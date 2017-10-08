package pl.mije.sda.java.watki.pliki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Ilustracja dzia³ania w¹tków na przyk³adzie zapisu i odczytu do pliku.
 * Przyk³ad realizowany wstêpnie jako dwie odrêbne aplikacje
 * @author RENT
 *
 */
public class OdczytZapis {
	
	public static void main(String[] args) {
		Thread zapisuj = new Thread(new Zapisuj());
		Thread odczytuj = new Thread(new Odczytuj());
		zapisuj.start();
		odczytuj.start();
	}

}


class Zapisuj implements Runnable{
	
	@Override
	public void run() {
		try{
			while (true) {
				int losowa = generuj();
				zapisz(losowa);
				spij();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static void spij() {
		try {
			Thread.sleep(new Random().nextInt(6) * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void zapisz(int losowa) throws IOException {
		File wyjsciowy = new File("plik.txt");
		wyjsciowy.createNewFile();
		OutputStreamWriter strumien = new OutputStreamWriter(new FileOutputStream(wyjsciowy, true));
		BufferedWriter bw = new BufferedWriter(strumien);
		bw.append(losowa + "\n");
		bw.close();
	}

	private static int generuj() {
		return new Random().nextInt();
	}
}

class Odczytuj implements Runnable{
	
	private static int licznikLini = 0;

	public void run() {
		try{
		while (true) {
			List<String> wartosc = odczytaj();
			wypisz(wartosc);
			spij();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static List<String> odczytaj() throws IOException {
		BufferedReader strumien = new BufferedReader(new FileReader("plik.txt"));
		pominPrzeczytane(strumien);
		return odczytajNieprzeczytane(strumien);
	}

	private static List<String> odczytajNieprzeczytane(BufferedReader strumien) throws IOException {
		List<String> wynik = new ArrayList<>();
		String linia;
		while((linia = strumien.readLine()) != null){
			wynik.add(linia);
			licznikLini++;
		}
		return wynik;
	}

	private static void pominPrzeczytane(BufferedReader strumien) throws IOException {
		for (int i = 0; i < licznikLini; i++) {
			if(strumien.readLine()==null){
				licznikLini = i;
				break;
			}
		}
	}

	private static void wypisz(List<String> wartosc) {
		wartosc.stream().forEach(System.out::println);
	}

	private static void spij() {
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}