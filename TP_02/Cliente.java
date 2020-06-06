package TP_02;

public class Cliente {
	
	private String usuario;
	private String clave;
	private int nroCajaAhorro;
	private double saldoCajaAhorro;
	private int nroCtaCte;
	private double saldoCtaCte;
	
	
	//Getters and Setters
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getNroCajaAhorro() {
		return nroCajaAhorro;
	}
	public void setNroCajaAhorro(int nroCajaAhorro) {
		this.nroCajaAhorro = nroCajaAhorro;
	}
	public double getSaldoCajaAhorro() {
		return saldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(double saldoCajaAhorro) {
		this.saldoCajaAhorro = saldoCajaAhorro;
	}
	public int getNroCtaCte() {
		return nroCtaCte;
	}
	public void setNroCtaCte(int nroCtaCte) {
		this.nroCtaCte = nroCtaCte;
	}
	public double getSaldoCtaCte() {
		return saldoCtaCte;
	}
	public void setSaldoCtaCte(double saldoCtaCte) {
		this.saldoCtaCte = saldoCtaCte;
	}
	

	//Constructor
	public Cliente(String usuario, String clave, int nroCajaAhorro,
					double saldoCajaAhorro, int nroCtaCte, double saldoCtaCte){
		
		
		this.setUsuario(usuario);
		this.setClave(clave);
		this.setNroCajaAhorro(nroCajaAhorro);
		this.setSaldoCajaAhorro(saldoCajaAhorro);
		this.setNroCtaCte(nroCtaCte);
		this.setSaldoCtaCte(saldoCtaCte);		
		
	}	
	
	
	public void actualizarCAext(int monto) {
		
		double saldoCAActualizado = this.getSaldoCajaAhorro() - monto;
		this.setSaldoCajaAhorro(saldoCAActualizado);
	}
	
	
	public void actualizarCCext(int monto) {
		
		double saldoCCActualizado = this.getSaldoCtaCte() - monto;
		this.setSaldoCtaCte(saldoCCActualizado);
	}
	
	
	public void actualizarCAdep(int monto) {
		
		double saldoCAActualizado = this.getSaldoCajaAhorro() + monto;
		this.setSaldoCajaAhorro(saldoCAActualizado);
	}
	
	
	public void actualizarCCdep(int monto) {
		
		double saldoCCActualizado = this.getSaldoCtaCte() + monto;
		this.setSaldoCtaCte(saldoCCActualizado);
	}
	
	
	
	
	public static Cliente[] cargaClientes() {

		Cliente[] cli= {
						
						new Cliente("usuario1","contras1", 1111, 1265, 2222, 2894),
						new Cliente("usuario2","contras2", 3333, 30560, 3333, 38549),
						new Cliente("usuario3","contras3", 4444, 4050, 5555, 9900),
						new Cliente("usuario4","contras4", 6666, 607400, 7777, 7085) };
		
		return cli;
		}
				
		
		
	}

