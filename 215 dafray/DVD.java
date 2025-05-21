package juego;

import entorno.Entorno;

public class DVD {
	private double x,y;
	int HP,danio;
	boolean dentroPantalla;	
	private double factorX;
	private double factorY;
	double ancho;
	double alto;
	Gondolf mago;

	
	Entorno entorno;
	
	//test	
	DVD(Entorno e,Gondolf g, double xInicial, int factorX){ //factorX determina si su movimiento inicial es izquierda o derecha
		this.x = xInicial; //cambiar a valores random en constructor
		this.y = 350;
		this.HP = 2;
		this.danio = 10;
		this.dentroPantalla = false;
		this.entorno = e;
		this.factorX = 3 * factorX;
		this.factorY = 2;
		this.mago = g;
		
		
		
		this.ancho = 50; //cambiar a variables genericas al opnerle imagen
		this.alto = 50;
		
	}
	
	void colisionMago() {
		if(colisionDVD(this.mago.alto, this.mago.ancho,this.mago.getX(), this.mago.getY())) {
			if (this.mago.iFrames == 0) {
				this.mago.HP = this.mago.HP - this.danio;
				this.mago.iFrames = 150;
			}
		}
				
	}
	private boolean colisionDVD(double alto, double ancho, double x, double y) { //valido para todo tipo de enemigo
		
		if(getX()+(this.mago.ancho/2)+ancho >= x && //extiende el radio y solo chequea la posicion absoluta del enemigo
		   getX()-(this.mago.ancho/2)-ancho <= x &&
		   getY()+(this.mago.alto/2)+alto >= y &&
		   getY()-(this.mago.alto/2)-alto <= y) {
				return true;
		}	
		return false; //método normalizado
	}

	
	void movimiento(){

		setX(getX()+this.factorX);
		setY(getY()+this.factorY);
		
		if(this.dentroPantalla == true) { //asumo que siempre al tocar un borde hay una sola colision posible
			if (x>=600-(this.ancho/2) || x<=0+(this.ancho/2)) {
				this.factorX = this.factorX*-1; //cambio el sentido de crecimiento de X
				if(Math.random() >=0.9) { //pequeña chance de también cambiar Y
					this.factorY = this.factorY*-1;
					if (this.factorY>=0 && this.factorY<10 ) { //adicionalmente, aumento la velocidad de Y hasta máximo 10
						this.factorY = this.factorY+0.3;
					}
					this.factorY = this.factorY-0.3;
				}
			}
			if (y>=600-(this.alto/2) || y<=0+(this.alto/2)) { //viceversa
				this.factorY = this.factorY*-1;
				if(Math.random() >=0.9) {
					this.factorX = this.factorX*-1;
					if (this.factorX>=0 && this.factorX<10 ) {
						this.factorX = this.factorX+0.3;
					}
					this.factorX = this.factorX-0.3;
				}
			}
			
			return;
		}
			
		if(this.dentroPantalla == false && x>0+(this.ancho/2) && x<600-(this.ancho/2)&& y>0+(this.alto/2) && y<600-(this.alto/2)) {
			this.dentroPantalla = true; //solo necesita entrar una vez en pantalla
		}
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
	
	
}
