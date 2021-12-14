package models;

import java.util.Scanner;

import enums.modoDeJuego;

public class SieteyMedia extends AbstractGame{

	//Constructor
	/**
	 * Construye un SieteyMedia desde 0
	 */
	public SieteyMedia() {
		super();
	}
	
	
	//Métodos
	@Override
	/**
	 * Inicializa el metodo bienvenida();
	 */
	public void start() {
		bienvenida();
	}
	
	@SuppressWarnings("resource")
	@Override
	/**
	 * Inicializa e imprime el Menú principal del juego
	 */
	public void bienvenida() {
		String resp = "";
		Scanner sc = new Scanner (System.in);
		do {
			System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
			System.out.println("┃░░░░░░░░░░░░░░░░░░░░░ MENÚ 7 Y MEDIA ░░░░░░░░░░░░░░░░░░░░┃");
			System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
			System.out.println("┃     Bienvenid@ al 7 y Media, seleccione una opcion      ┃");
			System.out.println("┃                 del menú a continuación:                ┃");
			System.out.println("┃                                                         ┃");
			System.out.println("┃ A »» ¿Cómo jugar?                                       ┃");
			System.out.println("┃ B »» Nueva Partida                                      ┃");
			System.out.println("┃                                                         ┃");
			System.out.println("┃ C »» Salir                                              ┃");
			System.out.println("┃                                                         ┃");
			System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
				
			System.out.print("\n  • »» Respuesta: ");
			resp = sc.next().toUpperCase();
					
			switch (resp) {
					
				case "A": //Cómo Jugar
					comoJugar();
					break;
					
				case "B": //Nueva partida					
					menuNuevaPartida();
					break;
						
				case "C": //Salir
					salir();
					break;
						
				default:
					err0r();
					break;	
			} 
		}while(resp.equals("A") || resp.equals("B") || !resp.equals("C"));		
	}

	/**
	 * Inicializa una nueva partida y muestra el menú de la misma para seleccionar 
	 * la configuración de preferencia como el modo de juego, entre otras cuestiones
	 */
	@SuppressWarnings("resource")
	public void menuNuevaPartida() {
		
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░░░ NUEVA PARTIDA ░░░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃        A continuación selecciona un modo de juego:      ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┃ A »» UnoVsCPU                                           ┃");
		System.out.println("┃ B »» Multiplayer ~ (Próximamente)                       ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String respModo = "";
		do {
		System.out.print("\n  • »» Respuesta: ");
		Scanner scNP = new Scanner (System.in);
		respModo = scNP.next().toUpperCase();
		
			switch (respModo) {
			
			case "A": //Modo UnoVsCPU
				setModoUnoVsCPU();
				
				this.jugadores.add(crearCPU());
				this.jugadores.add(crearJugador());
				AbstractPlayer cpu = this.jugadores.get(0);
				AbstractPlayer hm = this.jugadores.get(1);
				cpu.puntos = 0;
				hm.puntos = 0;
				
				double apuesta = 0;
				boolean jugar = false;
				if(hm.dinero >= 5) {
					jugar = true;
					apuesta = apostar();
					hm.dinero -= apuesta;
					hm.jugarTurnoSyM(0);
				} else {
					jugar = false;
					noMoney();
				}
				
				
				if(jugar) { //Si el jugador pudo hacer una apuesta...
					if(hm.puntos <= 7.5) { //Comprueba si mi jugador tiene posibilidad de ganar
						cpu.jugarTurnoSyM(hm.puntos); //Si tiene posibilidad de ganar, hará jugar a la CPU
						if(cpu.puntos <= 7.5) {//Si la cpu tiene posibilidad de ganar
							if(hm.puntos > cpu.puntos) { //Si le gana el jugador a la cpu
								winner(apuesta);
								hm.dinero += apuesta*2;
							} else { //Si gana la cpu
								loser();
							}
						} else { //Si la cpu se paso de 7.5
							winner(apuesta);
							hm.dinero += apuesta*2;
						}
						
						if(hm.puntos == cpu.puntos) {//En caso de empate
							empate(apuesta);
						}
						
					} else { //Si no tiene posibilidad de ganar porque ya perdio
						loser();
					}
				}
				
				break;
				
			case "B": //Modo Multiplayer
				setModoMultiplayer();
				noDisponible();
				break;
				
			default:
				err0r();
				
			}
		}while(!respModo.equals("A") || respModo.equals("B"));
	}
	
	/**
	 * Imprime un error, por juego indisponible
	 */
	public static void err0r() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>> El valor indicado, no corresponde <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>  a una de las opciones del menú   <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│ ");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Imprime un mensaje de despedida
	 */
	public static void salir() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│                                                         │");
		System.out.println("│    Oh, que triste verte partir... Vuelve pronto crack   │");
		System.out.println("│                                                         │");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Imprime un menú que da una explicación breve y simple de como jugar
	 */
	public static void comoJugar() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│    El juego consiste en obtener siete puntos y medio,   │");
		System.out.println("│            o acercarse a ello lo más posible.           │");
		System.out.println("│   Las cartas valen tantos puntos como su valor facial,  │");
		System.out.println("│       excepto las figuras, que valen medio punto        │");
		System.out.println("│        Cada jugador irá robando cartas en orden         │");
		System.out.println("│    E irá acumulando puntos según la carta que obtenga   │");
		System.out.println("│                                                         │");
		System.out.println("│                                                         │");
		System.out.println("│Si quieres saber más, busca más info en Internet crack :)│");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Actualiza el modo de juego a UnoVsCPU
	 */
	public void setModoUnoVsCPU() {
		this.modo = modoDeJuego.UnoVsCPU;
	}
	
	/**
	 * Actualiza el modo de juego a Multiplayer
	 */
	public void setModoMultiplayer() {
		this.modo = modoDeJuego.MultiPlayer;
	}
	
	/**
	 * Muestra un menú indicando el modo de juego seleccionado
	 * Posteriormente pedirá al usuario un nombre con el que se creara
	 * un jugador nuevo.
	 * @return El jugador creado
	 */
	@SuppressWarnings("resource")
	public AbstractPlayer crearJugador() {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░░░░ NUEVA PARTIDA ░░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃                                                         ┃");
		System.out.println("┃           Has seleccionado el módo "+this.modo+"             ┃");
		System.out.println("┃            A continuación indica tu nombre              ┃");
		System.out.println("┃               y luego indica tu apuesta                 ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		System.out.print("\n • »» Nombre: ");
		Scanner sc = new Scanner (System.in);
		String nombre = sc.next();
		
		AbstractPlayer j1 = new HumanPlayer(this.mesa, nombre);
		return j1;
		
	}
	
	/**
	 * Crea un jugador CPU
	 * @return El jugador creado
	 */
	public AbstractPlayer crearCPU() {
		AbstractPlayer cpu = new CPUPlayer(this.mesa, "CPU");
		return cpu;
	}
	
	/**
	 * Imprime un mensaje de modo de juego no disponible
	 */
	public static void noDisponible() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│       >>>>   Este modo de juego todavía no   <<<<       │");
		System.out.println("│ ¡Ups! >>>>     se encuentra disponible.      <<<< ¡Ups! │");
		System.out.println("│       >>>>       Vuelve a Intentarlo         <<<<       │ ");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Mostrará cuanto dinero tiene el usuario y
	 * Pedirá al usuario indicar cuanto dinero quiere apostar
	 * @return Devuelve la cantidad de dinero apostada
	 */
	@SuppressWarnings("resource")
	public double apostar() {
		double apuesta;
		do {
			System.out.println(" • »» Dinero: "+(this.jugadores.get(1).dinero));
			System.out.print(" • »» Apuesta: ");
			Scanner sc = new Scanner (System.in);
			apuesta = Double.parseDouble(sc.next());
		
			if(apuesta < 10) {
				 err0rApuesta();
			}
			
			if (apuesta > this.jugadores.get(1).dinero) {
				noEresMillonario();
			}
			
		}while(apuesta < 10 || apuesta > this.jugadores.get(1).dinero);
			return apuesta;
	}
	
	/**
	 * Imprime un mensaje de que el usuario no tiene suficiente dinero para
	 * iniciar una partida nueva
	 */
	public static void noMoney() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│       >>>>  Al parecer no tienes suficiente  <<<<       │");
		System.out.println("│ ¡Ups! >>>>    dinero para jugar otra vez     <<<< ¡Ups! │");
		System.out.println("│       >>>>   Recarga y vuelve a intentarlo   <<<<       │");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
	
	/**
	 * Imprime un mensaje de que el usuario ha ganada
	 * y le muestra cuanto dinero ganí
	 * @param apuesta La apuesta que realiza el jugador
	 */
	public static void winner(double apuesta) {
		System.out.println("\n╔══════════════════════════════════════════════════════════╗");
		System.out.println("║ $$$$$$ >>>>     ¡Felicidades has ganado!     <<<< $$$$$$ ║");
		System.out.println("║ WINNER >>>>     Has duplicado tu apuesta     <<<< WINNER ║");
		System.out.println("║ $$$$$$ >>>>         Has ganado: "+apuesta*2+"         <<<< $$$$$$ ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝\n");
	}

	/**
	 * Imprime un mensaje de que el usuario ha perdido
	 */
	public static void loser() {
		System.out.println("\n╔══════════════════════════════════════════════════════════╗");
		System.out.println("║ ###### >>>>      ¡Oh no... has perdido!      <<<< ###### ║");
		System.out.println("║ LOSER  >>>>       Pero no te desanimes       <<<<  LOSER ║");
		System.out.println("║ ###### >>>>       Vuelve a intentarlo        <<<< ###### ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝\n");
	}
	
	/**
	 * Imprime un mensaje de que hubo un empate
	 * @param apuesta La apuesta que realiza el jugador
	 */
	public static void empate(double apuesta) {
		System.out.println("\n╔══════════════════════════════════════════════════════════╗");
		System.out.println("║  %%%%% >>>>    Al parecer tenemos un empate   <<<< %%%%% ║");
		System.out.println("║   TIE  >>>>  por lo que recuperas tu apuesta  <<<<  TIE  ║");
		System.out.println("║  %%%%% >>>>        Has recuperado: "+apuesta+"$        <<<< %%%%% ║");
		System.out.println("╚══════════════════════════════════════════════════════════╝\n");
	}
	
	/**
	 * Imprime un mensaje de err0r por intentar apostar menos de 10$
	 */
	public static void err0rApuesta() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>>       Debes apostar al menos      <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>        10$ para poder jugar       <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>        Vuelve a intentarlo        <<<< ERR0R!│");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯\n");
	}
	
	/**
	 * Imprime un mensaje de err0r por intentar apostar más de lo que tienes
	 */
	public static void noEresMillonario() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>>    No cuentas con esa cantidad    <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>      de dinero en tu cuenta.      <<<< ERR0R!│");
		System.out.println("│ERR0R! >>>>        Vuelve a intentarlo        <<<< ERR0R!│");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯\n");
	}
	
	
}
