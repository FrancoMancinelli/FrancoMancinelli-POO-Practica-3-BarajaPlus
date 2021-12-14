package models;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer {
	
	//Constructor
	/**
	 * Construye un jugador al cual hay que asignarle un nombre y una mesa
	 * @param mesa Mesa donde participará el jugador
	 * @param nombre Nombre que tendrá el jugador
	 */
	public HumanPlayer(Mesa mesa, String nombre) {
		super(mesa, nombre);		
	}

	@SuppressWarnings("resource")
	@Override
	/**
	 * Indica que es el turno del jugador seleccionado para jugar. 
	 * Luego imprimirá un menú de juego hasta que decida plantarse
	 * Si alcanza 7.5 o más puntos se plantará automáticamente
	 */
	void jugarTurnoSyM(double puntosRival) {
		boolean finished = false;
		String resp = "";
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                                                         ┃");
		System.out.println("┃               TURNO PARA JUGAR DE "+this.nombre.toUpperCase());
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

		do {
			System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃░░░░░░░░░░░░░░░░░░░░ PANEL DE JUEGO ░░░░░░░░░░░░░░░░░░░░░┃");
			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┃                                                         ┃");
			System.out.println("┃            A continuación indica la acción              ┃");
			System.out.println("┃                  que quieras realizar:                  ┃");
			System.out.println("┃                                                         ┃");
			System.out.println("┃           1 »» Robar Carta | 2 »» Plantarse             ┃");
			System.out.println("┃                                                         ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");
			
			do {
				System.out.print("\n• »» Respuesta: ");
				Scanner sc = new Scanner (System.in);
				resp = sc.next();
				
				if (resp.equals("2") && this.puntos == 0) {
					err0rPlantarse();
				}
			
			} while(resp.equals("2") && this.puntos == 0);
			
			switch(resp) {
			
			case "1":
				robarCarta();
				break;
				
			case "2":
				finished = true;
				System.out.println("  »» Te has plantado con: "+this.puntos+" puntos");
				break;
				
			default:
				err0rMenu();
			}
			
			if(this.puntos >= 7.5) {
				finished = true;
				System.out.println("  »» Te has plantado automáticamente con: "+this.puntos);

			}
			
		} while (!finished);
	}
	
	/**
	 * Roba una carta, menciona cual es y suma su valor a la puntuación del jugador
	 * Seguido a ello mostrará la puntuación total
	 */
	public void robarCarta() {
		Carta c = this.mesa.robarCartaDeBaraja();
		System.out.println("  »» Has robado la carta: "+ c.getNombreCarta());
		this.puntos += c.Valor7yMedio();
		System.out.println("  »» Tu puntuación actual es: "+this.puntos);
	}
	
	/**
	 * Imprime un mensaje de error por querer plantarse sin antes haber robado carta
	 */
	public static void err0rPlantarse() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>>   Parece que no puedes plantarte  <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>     asegurate de haber robado     <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>    primero al menos una carta.    <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Imprime un mensaje de error por seleccionar un valor incorrecto del menú
	 */
	public static void err0rMenu() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>> El valor indicado, no corresponde <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>  a una de las opciones del menú   <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
}
