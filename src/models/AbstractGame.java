package models;

import java.util.ArrayList;

import enums.modoDeJuego;

public abstract class AbstractGame {
	//Propiedades o Atributos
	protected Mesa mesa;
	protected ArrayList<AbstractPlayer> jugadores;
	protected modoDeJuego modo;
	protected boolean finished;
	protected int ronda;
	
	//Constructores
	/**
	 * Construye un AbstractGame con una mesa (que tendrá una baraja vacia), un array de jugadores, un modo de juego y un contador de rondas
	 */
	public AbstractGame() {
		super();
		this.mesa = new Mesa(new Baraja());
		this.jugadores = new ArrayList<AbstractPlayer>();
		this.modo = modoDeJuego.Solitario;
		this.finished = false;
		this.ronda = 0;	
	}
	
	//Métodos
	
	
	abstract void bienvenida();
	
	abstract void menuNuevaPartida();
	
	abstract void start();
	
	
	/**
	 * Mezcla la baraja de cartas de la mesa
	 */
	public void barajar() {
		this.mesa.baraja.barajar();
	}
	
	/**
	 * Recorre cada jugador y elimina todas las cartas de su mano
	 */
	public void finish() {
		for(int i = 0; i < this.jugadores.size(); i++) {
			(this.jugadores.get(i)).mano.borrarMano();
		}
	}
}
