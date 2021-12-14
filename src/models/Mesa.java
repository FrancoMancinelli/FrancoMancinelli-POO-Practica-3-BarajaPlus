package models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
	
	//Propiedades o Atributos
	protected Baraja baraja;

	//Constructores
	/**
	 * Construye una mesa con una baraja la cual inicializa con 40 cartas y barajandolas
	 * @param baraja Baraja que formará parte de nuestra mesa
	 */
	public Mesa(Baraja baraja) {
		super();
		this.baraja = new Baraja(40, true);
	}
	
	//Metodos
	/**
	 * Devuelve un listado de las cartas de la baraja
	 * @return El listado de las cartas
	 */
	public Baraja getBaraja() {
		return this.baraja;
	}
	
	/**
	 * Roba la primer carta de la baraja
	 * @return Devuelve la carta robada
	 */
	public Carta robarCartaDeBaraja() {
		return this.baraja.robar();
	}
	
	/**
	 * Permite robar varias cartas las cuales guardara en un ArrayList 
	 * @param cantidad Cantidad de cartas que se desean robar
	 * @return El ArrayList de cartas robadas
	 */
	public List<Carta> robarVariasCartas(int cantidad) {
		List<Carta> cartasRobadas = new ArrayList<Carta>();
		for (int i = 0; i < cantidad; i++) {
			cartasRobadas.add(this.baraja.robar());
		}
		return cartasRobadas;
	}
	
	/**
	 * Añade una carta dada al final de la baraja
	 * @param c La carta a introducir al final de la baraja
	 */
	public void addCartaABaraja(Carta c) {
		this.baraja.insertarCartaFinal(c);
	}
	
}
