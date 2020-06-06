package TP_02;

import javax.*;
import javax.swing.JFrame;

public class Banco {
	
	static Cliente[] cli;	
	
	public static void main(String[] args) {
		
		
		//ArrayUserLoad
		cli= Cliente.cargaClientes();
		
		//SendVector
		Pantalla_banco.pasaClientes(cli);
		
		//Screen
		Pantalla_banco ingreso_banco=new Pantalla_banco();
		ingreso_banco.setBounds(0,0,350,300);
		ingreso_banco.setTitle("Ingreso a Cuenta Bancaria");
		ingreso_banco.setVisible(true);
		ingreso_banco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		}
	
	}




 
