package models;

public abstract class AbstractPlayer {
	//Propiedades o Atributos
	protected Mano mano;
	protected Mesa mesa;
	protected double puntos;
	protected String nombre;
	protected double dinero;
	
	//Constructores
	/**
	 * Construye un jugador abstracto con una mano vacia, 0 puntos y 50 de dinero
	 * @param mesa La mesa a la que pertenece este jugador
	 * @param nombre Nombre del jugador
	 */
	public AbstractPlayer(Mesa mesa, String nombre) {
		super();
		this.mano = new Mano();
		this.mesa = mesa;
		this.puntos = 0;
		this.nombre = nombre;
		this.dinero = 50;
	}
	
	//Métodos
	/**
	 * Devuelve el nombre del jugador
	 * @return El nombre del jugador
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Indica que es el turno de jugar de un jugador
	 * @param puntosRival Los puntos del rival
	 */
	abstract void jugarTurnoSyM(double puntosRival);
	
}
