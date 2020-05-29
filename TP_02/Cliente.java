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
	
	public static Cliente[] cargaClientes() {

		Cliente[] cli= {
						
						new Cliente("usuario1","contras1", 1111, 126165000, 2222, 28944),
						new Cliente("usuario2","contras2", 3333, 305600, 3333, 38549110),
						new Cliente("usuario3","contras3", 4444, 40050, 5555, 9900),
						new Cliente("usuario4","contras4", 6666, 607400, 7777, 70800) };
		
		return cli;
		}
				
		
		
	}

