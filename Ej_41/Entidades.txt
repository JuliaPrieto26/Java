package Entidades;

public class Empleados {
	
	private String nombre;
	private String apellido;
	private int cantHsTrabajadas;
	private int cantHsSimples;
	private int cantHsExcedentes;
	private double sueldoBasico;
	private double premio;
	private double aCobrar;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getCantHsTrabajadas() {
		return cantHsTrabajadas;
	}
	public void setCantHsTrabajadas(int cantHsTrabajadas) {
		this.cantHsTrabajadas = cantHsTrabajadas;
	}
	public int getCantHsSimples() {
		return cantHsSimples;
	}
	public void setCantHsSimples(int cantHsSimples) {
		this.cantHsSimples = cantHsSimples;
	}
	public int getCantHsExcedentes() {
		return cantHsExcedentes;
	}
	public void setCantHsExcedentes(int cantHsExcedentes) {
		this.cantHsExcedentes = cantHsExcedentes;
	}
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}
	public double getPremio() {
		return premio;
	}
	public void setPremio(double premio) {
		this.premio = premio;
	}
	public double getaCobrar() {
		
		double calcula=(this.getCantHsSimples()*25)-((this.getCantHsSimples()*25)*0.195);
		this.setaCobrar(calcula+(this.getCantHsExcedentes()*30)+this.getPremio());

		return aCobrar;
	}
	public void setaCobrar(double aCobrar) {
		this.aCobrar = aCobrar;
	}
	
	
	public Empleados(String nombre, String apellido, int cantHsTrabajadas) {
		
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setCantHsTrabajadas(cantHsTrabajadas);
		
		if(cantHsTrabajadas<=40) {
			
			this.setCantHsSimples(40);
			this.setCantHsExcedentes(cantHsTrabajadas-40);
			this.setPremio(100.00);
		}
		else {
			
			this.setCantHsSimples(cantHsTrabajadas);
			this.setCantHsExcedentes(0);
			this.setPremio(00.00);
		
		}
	}
	
}
