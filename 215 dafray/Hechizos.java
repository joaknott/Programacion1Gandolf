package juego;

import java.awt.Image;
import entorno.Entorno;

public class Hechizos {
	String nombre;
	int danio;
	int costo;
	double radio;
	boolean seleccionado;
	Gondolf mago;
	
	DVD[] dvd;
	
//	Image imag;
//	double ancho;
//	double alto;
//	double escala;
	Entorno entorno;


	Hechizos(Entorno e,Gondolf g, String nombre, int danio, int costo,double radio,DVD[] d){
		this.nombre = nombre;
		this.danio = danio;
		this.costo = costo;
		this.radio = radio;
		this.entorno = e;
		this.dvd = d;
		this.mago = g;

		this.seleccionado = false;
		
//		this.imag = imag;							//agregar imag y escala al constructor
//		this.escala = escala;
//		this.ancho = imag.getWidth(null) * escala;
//		this.alto = imag.getHeight(null) * escala;
	}
	void lanzarHechizo() { //juego llama a este metodo
		if(entorno.estaPresionado(1) && this.seleccionado == true) {
			this.mago.Energia =- this.costo; //consumo la energia/mana
			this.seleccionado = false;
			lanzarHechizo(this.dvd);
			
			//agregar mas enemigos
		}
	}
	
	private void lanzarHechizo(DVD[] enemigo) { //clonar para otra clase de enemigo
		
			for(int i = 0; i < enemigo.length ; i++ ) {			
				if(colision(enemigo[i].alto, enemigo[i].ancho, enemigo[i].getX(), enemigo[i].getY())) { 
					enemigo[i].HP = enemigo[i].HP - this.danio; 
					System.out.println("wack");
					
				}
			}		
		
	}
	
	boolean colision(double alto, double ancho, double x, double y) { //valido para todo tipo de enemigo
			
			if(entorno.mouseX()+(this.radio/2)+ancho >= x && //extiende el radio y solo chequea la posicion absoluta del enemigo
			   entorno.mouseX()-(this.radio/2)-ancho <= x &&
			   entorno.mouseY()+(this.radio/2)+alto >= y &&
			   entorno.mouseY()-(this.radio/2)-alto <= y) {
					return true;
			}	
			return false; //método normalizado
		}
}