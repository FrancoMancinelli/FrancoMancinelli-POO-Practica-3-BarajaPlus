package models;

public class CPUPlayer extends AbstractPlayer{

	//Constructor
	/**
	 * Construye un jugador al cual hay que asignarle un nombre y una mesa
	 * @param mesa Mesa donde participará el jugador
	 * @param nombre Nombre que tendrá el jugador
	 */
	public CPUPlayer(Mesa mesa, String nombre) {
		super(mesa, nombre);

	}

	@Override
	/**
	 * Indica que es el turno de la CPU para jugar. 
	 * Además comenzará a robar cartas mientras que su puntuación sea inferior o igual a la del rival con el objetivo de ganarle
	 * Si le sobre pasa en puntos se plantara automáticamente
	 */
	void jugarTurnoSyM(double puntosRival) {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                         ┃");
		System.out.println("┃               TURNO PARA JUGAR DE LA CPU                ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
		do {
			robarCarta();
		}while(this.puntos < puntosRival);
		System.out.println("  »» Se ha plantado con: "+this.puntos);
	}
	
	/**
	 * Roba una carta, menciona cual es y suma su valor a la puntuación del jugador
	 * Seguido a ello mostrará la puntuación total
	 */
	public void robarCarta() {
		Carta c = this.mesa.robarCartaDeBaraja();
		System.out.println("\n  »» La CPU ha robado la carta: "+ c.getNombreCarta());
		this.puntos += c.Valor7yMedio();
		System.out.println("  »» Su puntuación actual es: "+this.puntos+" puntos");
		}
}
