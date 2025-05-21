package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Roca {
	private double x;
	private double y;
	double ancho;
	double alto;
	Image imagen;
	double escala;
	Entorno entorno;
	
	public Roca(Entorno e,double posX, double posY) {
		this.x = posX;
		this.y = posY;
		this.entorno = e;
		
		//this.imagen = Herramientas.cargarImagen(null);
		//this.ancho = imagen.getWidth(null) * escala;
		//this.alto = imagen.getHeight(null) * escala;
		this.escala = 1.0;

	}
	

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
}
