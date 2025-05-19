package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Menu {
	double x,y;
	Gondolf mago;
	Hechizos[] hechizos; 
	int enemigosMuertos;
	int enemigosRestantes;
	Entorno entorno;
	Image imagen;
	double ancho, alto, escala;
	
	public Menu (Hechizos[] hechizo, Entorno e, Gondolf g) {
		this.enemigosMuertos = 0;
		this.enemigosRestantes = 50;
		this.hechizos = hechizo;
		this.entorno = e;
		this.mago = g;
		
		this.imagen = Herramientas.cargarImagen("MenuMadera.png");
		this.alto = imagen.getHeight(null) * this.escala;
		this.ancho = imagen.getWidth(null) * this.escala;
		this.escala = 1.7;

	}
	
	
	public void dibujarMenu() {
		entorno.dibujarImagen(this.imagen, entorno.ancho()-entorno.alto()/8.7, entorno.alto()/2, 0,this.escala);
	}
	
	public void dibujarHpEnergia() {
		entorno.cambiarFont("Arial", 18, Color.white); 
		entorno.escribirTexto("NUMERO", 660, 420);
		entorno.escribirTexto("EMERGIA", 660, 450);
		//AGREGAR LA BARRA DE VIDA
	}
	

	
}
