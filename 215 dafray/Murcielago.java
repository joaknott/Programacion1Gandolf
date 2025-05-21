package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Murcielago {
	double x, y ;
	int HP;
	int danio;
	double alto;
	double ancho;
	double velocidad;
	Image imagen;
	double escala;
	double angulo;
	Gondolf mago;
	
	public Murcielago(Entorno e, Gondolf g) {
		this.x = 650;
		this.y = -50;
		this.HP = 1;
		this.danio = 10;
		this.mago = g;
		//this.imagen = Herramientas.cargarImagen("");
		//this.alto = imagen.getHeight(null) * escala;
		//this.ancho = imagen.getWidth(null) * escala;
		this.escala = 1.0;
		this.angulo = 0;
		this.velocidad = 3;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public void cambiarAngulo(double x2, double y2){
		this.angulo = Math.atan2(y2 - this.y, x2 - this.x);
	}
	
	public void mover() {
		this.x += Math.cos(this.angulo)*this.velocidad;
		this.y += Math.sin(this.angulo)*this.velocidad;
	}
	void colisionMago() {
		if(colisionMurcielago(this.mago.alto, this.mago.ancho,this.mago.getX(), this.mago.getY())) {
			if (this.mago.iFrames == 0) {
				this.mago.HP = this.mago.HP - this.danio;
				this.mago.iFrames = 150;
			}
		}
				
	}
	private boolean colisionMurcielago(double alto, double ancho, double x, double y) { //valido para todo tipo de enemigo
		
		if(getX()+(this.mago.ancho/2)+ancho >= x && //extiende el radio y solo chequea la posicion absoluta del enemigo
		   getX()-(this.mago.ancho/2)-ancho <= x &&
		   getY()+(this.mago.alto/2)+alto >= y &&
		   getY()-(this.mago.alto/2)-alto <= y) {
				return true;
		}	
		return false; //método normalizado
	}
	
}
