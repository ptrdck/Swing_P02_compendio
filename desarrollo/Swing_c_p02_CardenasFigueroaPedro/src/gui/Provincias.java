/**
 * Provincias.java
 * 22 nov 2023 13:19:21
 * @author Pedro Patricio Cárdenas Figueroa
 */
package gui;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Provincias.
 */
public class Provincias {
	
	/** The provincias. */
	private ArrayList<String> provincias;
	
	/**
	 * Instantiates a new provincias.
	 */
	public Provincias() {
		//Inicializamos el array
		provincias = new ArrayList<>();
		agregarProvincias();
		
	}

	/**
	 * agregamos las provincias de manera alfabética.
	 */
	private void agregarProvincias() {
		// Agregar todas las provincias de España al ArrayList
        
		provincias.add("----- Seleccione una provincia ----");
		provincias.add("Álava");
        provincias.add("Albacete");
        provincias.add("Alicante");
        provincias.add("Almería");
        provincias.add("Asturias");
        provincias.add("Ávila");
        provincias.add("Badajoz");
        provincias.add("Barcelona");
        provincias.add("Burgos");
        provincias.add("Cáceres");
        provincias.add("Cádiz");
        provincias.add("Cantabria");
        provincias.add("Castellón");
        provincias.add("Ciudad Real");
        provincias.add("Córdoba");
        provincias.add("Cuenca");
        provincias.add("Gerona");
        provincias.add("Granada");
        provincias.add("Guadalajara");
        provincias.add("Guipúzcoa");
        provincias.add("Huelva");
        provincias.add("Huesca");
        provincias.add("Islas Balears");
        provincias.add("Jaén");
        provincias.add("La Coruña");
        provincias.add("La Rioja");
        provincias.add("Las Palmas");
        provincias.add("León");
        provincias.add("Lérida");
        provincias.add("Lugo");
        provincias.add("Madrid");
        provincias.add("Málaga");
        provincias.add("Murcia");
        provincias.add("Navarra");
        provincias.add("Orense");
        provincias.add("Palencia");
        provincias.add("Pontevedra");
        provincias.add("Salamanca");
        provincias.add("Segovia");
        provincias.add("Sevilla");
        provincias.add("Soria");
        provincias.add("Tarragona");
        provincias.add("Santa Cruz de Tenerife");
        provincias.add("Teruel");
        provincias.add("Toledo");
        provincias.add("Valencia");
        provincias.add("Valladolid");
        provincias.add("Vizcaya");
        provincias.add("Zamora");
        provincias.add("Zaragoza");
		
	}

	/**
	 * Gets the provincias.
	 *
	 * @return el provincias
	 */
	public ArrayList<String> getProvincias() {
		return provincias;
	}

}
