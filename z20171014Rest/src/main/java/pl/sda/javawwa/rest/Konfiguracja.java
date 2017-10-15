package pl.sda.javawwa.rest;

import org.glassfish.jersey.server.ResourceConfig;
import pl.sda.javawwa.rest.uslugi.kalkulatorekRest.Kalkulator;
import pl.sda.javawwa.rest.uslugi.prostySklepRest.rest.SklepSerwis;


public class Konfiguracja extends ResourceConfig {
	public Konfiguracja() {
		register(Kalkulator.class);
		register(SklepSerwis.class);
	}
}
