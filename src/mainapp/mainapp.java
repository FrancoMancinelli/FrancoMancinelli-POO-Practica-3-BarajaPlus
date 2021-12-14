package mainapp;

import java.util.ArrayList;
import java.util.Scanner;

import models.AbstractPlayer;
import models.SieteyMedia;

public class mainapp {

	public static void main(String[] args) {
		
		menuInicial();
		
	}//CIERRE MAIN

	/**
	 * Imprime el menú inicial para seleccionar un juego
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static void menuInicial() {
		System.out.println("\n┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃░░░░░░░░░░░░░░░░░░░░░ CENTER GAMES ░░░░░░░░░░░░░░░░░░░░░░┃");
		System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
		System.out.println("┃     Bienvenid@ a Center Games, seleccione que juego     ┃");
		System.out.println("┃               desea jugar a continuacion:               ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┃ A »» El Siete y Media                                   ┃");
		System.out.println("┃ B »» El Tute ~ (Próximamente)                           ┃");
		System.out.println("┃ C »» El Mus ~ (Próximamente)                            ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┃ D »» Salir                                              ┃");
		System.out.println("┃                                                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		String resp = "";
		
		do {
			System.out.print("\n  • »» Respuesta: ");
			Scanner sc = new Scanner (System.in);
			resp = sc.next().toUpperCase();
			
			switch (resp) {
			
				case "A": //Selecciona 7yMedia - Creo un array de jugadores e instancio una nueva clase SieteyMedia
					ArrayList<AbstractPlayer> arrayJugadores = new ArrayList<AbstractPlayer>();
					SieteyMedia sieteYMedia = new SieteyMedia();	
					sieteYMedia.start();
					break;
		
				case "B": //Selecciona Tute
					noDisponible();
					break;
					
				case "C": //Selecciona Mus
					noDisponible();
					break;
					
				case "D": //Salir
					salir();
					break;
					
				default:
					err0rMenus();
					break;
			}
		
		} while(!resp.equals("A") && !resp.equals("D"));
		
	}
	
	/**
	 * Imprime un error, por juego indisponible
	 */
	public static void noDisponible() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│       >>>>      Este juego todavía no se     <<<<       │");
		System.out.println("│ ¡Ups! >>>>        encuentra disponible.      <<<< ¡Ups! │");
		System.out.println("│       >>>>         Vuelve a Intentarlo       <<<<       │");
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
	 * Imprime un error por haber introducido un valor incorrecto como respuesta a un menú
	 */
	public static void err0rMenus() {
		System.out.println("\n╭─────────────────────────────────────────────────────────╮");
		System.out.println("│ERR0R! >>>> El valor indicado, no corresponde <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>  a una de las opciones del menú   <<<< ERR0R!│ ");
		System.out.println("│ERR0R! >>>>        Vuelve a Intentarlo        <<<< ERR0R!│ ");
		System.out.println("╰―――――――――――――――――――――――――――――――――――――――――――――――――――――――――╯");
	}
}
