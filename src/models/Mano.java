package models;

import java.util.List;
import java.util.Scanner;

public class Mano extends Baraja{

	//Constructores
	/**
	 * Construye una mano vacia
	 */
	public Mano() {
		super();
	}
	
	//Métodos
	/**
	 * Lista las cartas que hay en la Mano con su nombre y número
	 */
	public void listarCartas() {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░ LISTADO DE CARTAS ░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫\n");
		int i = 1;
		for(Carta c : this.listaCartas) {
			System.out.println("  "+ i + " »» " + c.getNombreCarta());
			i++;
		}
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

	}
	
	/**
	 * Agrega una carta a la mano
	 * @param c Carta a agregar
	 */
	public void addCarta(Carta c) {
		this.listaCartas.add(c);
	}
	
	/**
	 * Agrega varias cartas a la mano
	 * @param lista Listado de cartas a agregar
	 */
	public void addVariasCartas(List<Carta> lista) {
		for (int i = 0; i < lista.size(); i++) {
			Carta c = lista.get(i);
			this.listaCartas.add(c);
		}
	}
	
	
	/**
	 * Lista las cartas de la mano y permite elegir una de ellas
	 * @return c La carta elegida
	 */
	
	@SuppressWarnings("resource")
	/**
	 * Muestra todas las cartas enumeradas y permite seleccionar una
	 * @return Devuelve la carta seleccionada
	 */
	public Carta elegirCarta() {
		listarCartas();
		boolean error = true;
		
		do {
			System.out.print("• »» Elige una carta:");
			Scanner sc = new Scanner(System.in);
			int respuesta = Integer.parseInt(sc.next());
		
			if (respuesta >= 1 && respuesta <= this.listaCartas.size()) {
				error = false;
				return this.listaCartas.get(respuesta-1);
			} else {
				System.out.println("\n╭──────────────────────────────────────────────────────────╮");
				System.out.println("│ERR0R! >>>> El número indicado, no corresponde <<<< ERR0R!│");
				System.out.println("│ERR0R! >>>>  a una carta de las opciones (1-"+this.listaCartas.size()+") <<<< ERR0R!│");
				System.out.println("│ERR0R! >>>>         Vuelve a Intentarlo        <<<< ERR0R!│");
				System.out.println("╰――――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
			}
		} while(error);
		
		return null;
	}
	
	/**
	 * Borra todas las cartas dentro de la mano
	 */
	public void borrarMano() {
		this.listaCartas.clear();
	}
	
	
	
}
