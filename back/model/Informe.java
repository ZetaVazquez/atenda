package model;

public class Informe {
	private double facturacion;
	private double descontos;
	private double coste;
	private double beneficio;
	private double iva;
	public Informe() {
		super();
	}
	public double getFacturacion() {
		return facturacion;
	}
	public Informe setFacturacion(double facturacion) {
		this.facturacion = facturacion;
		return this;
	}
	public double getDescontos() {
		return descontos;
	}
	public Informe setDescontos(double descontos) {
		this.descontos = descontos;
		return this;
	}
	public double getCoste() {
		return coste;
	}
	public Informe setCoste(double coste) {
		this.coste = coste;
		return this;
	}
	public double getBeneficio() {
		return beneficio;
	}
	public Informe setBeneficio(double beneficio) {
		this.beneficio = beneficio;
		return this;
	}
	public double getIva() {
		return iva;
	}
	public Informe setIva(double iva) {
		this.iva = iva;
		return this;
	}
}
