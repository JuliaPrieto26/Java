package TP_02;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.*;
import java.awt.ActiveEvent.*;
import javax.swing.*;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.xml.internal.ws.api.server.Container;


public class Pantalla_banco extends JFrame implements ActionListener{   
	
	private JButton boton1, boton2,boton3, boton4, boton5;
	private JLabel text,passtx;
	private JTextField usu;
	private JPasswordField pin;
	private int intentos=0;
	private static Cliente[] user=new Cliente[4];
	Cliente usuValidado;
	private JRadioButton btnCA, btnCC, btnConsultar,
	 					 btnExtraer, btnTransferencia, btnDepositar;

	
	public Pantalla_banco(){
	
		
		setLayout(null);
		text= new JLabel("Usuario");
		text.setBounds(5, 1, 100, 100);
		add(text);
		
		passtx=new JLabel("Contraseña");
		passtx.setBounds(5, 1, 200, 200);
		add(passtx);
		
		usu=new JTextField(20);
		usu.setBounds(100, 40, 100, 30);
		add(usu);
		
		pin=new JPasswordField(8);
		pin.setBounds(100, 80, 100, 30);
		add(pin);
		 
		boton1=new JButton("Aceptar");
		boton1.setBounds(10, 150, 90, 30);
		add(boton1);
		boton1.addActionListener(this);
		
		boton2=new JButton("Borrar");
		boton2.setBounds(110, 150, 90, 30);
		add(boton2);
		boton2.addActionListener(this);
		 
		boton3=new JButton("Salir");
		 boton3.setBounds(210, 150, 90, 30);
		add(boton3);
		boton3.addActionListener(this);
		
	 } 

	public void actionPerformed(ActionEvent e) {
		
	try {
		
		boolean validado1, validado2;
		
		pasaClientes(user);
		
		if(e.getSource()==boton1) {
			
				
			validado1= validaIngreso1();
			
			if(validado1==false) intentos++;
			
			if(validado1==true && intentos<3) {
				
				validado2=validaIngreso2();
				if(validado2==false) intentos++;
				
				else {
					desactiva();
					setTitle("MENÚ DE OPERACIONES"); 
					pantallaOperaciones(); 
						}
					}
			if(intentos>=3){
				
				desactiva();
				JOptionPane.showMessageDialog(this, "Se suspenden los privilegios de usuario tras fallar 3 veces consecutivas");
				System.exit(0);
					} 
				
			}
		      
		
		if(e.getSource()==boton2){
			   usu.setText("");
		       pin.setText(""); 
		  }
									   
		if(e.getSource()==boton3){
			   System.exit(0);	   
		   }
		
		if(e.getSource()==boton4){
			
			
			if(btnCC.isSelected()==true && btnExtraer.isSelected()==true) {
				
				extraccionCC();	
				}
			
			if(btnCC.isSelected()==true && btnTransferencia.isSelected()==true) {
				
				transferenciaCC();
			}
			
			if((btnCC.isSelected()==true) && btnDepositar.isSelected()==true) {
				
				depositaCC();
			}
			
			if((btnCC.isSelected() == true) && btnConsultar.isSelected() ==true) {
				
				JOptionPane.showMessageDialog(this, "El saldo de su Cuenta Corriente es:     " + usuValidado.getSaldoCtaCte() );
			}
			
			if((btnCA.isSelected()==true) && btnExtraer.isSelected()==true) {
				
				extraccionCA();
			}
			
			if((btnCA.isSelected()==true) && btnDepositar.isSelected()==true) {
				
				depositaCA();
			}
			
			if((btnCA.isSelected()==true) && btnTransferencia.isSelected()==true) {
				
				transferenciaCA();
			}
			
			if((btnCA.isSelected()==true) && btnConsultar.isSelected()==true) {
				
				JOptionPane.showMessageDialog(this, "El saldo de su Cuenta Corriente es:     " + usuValidado.getSaldoCajaAhorro() );		
					}	
		}
		
		if(e.getSource()==boton5){
			System.exit(0);	
				}
	
		}
	catch(NullPointerException error) {
    		
    	}       	
	catch(NumberFormatException error) {
		
		}
		
	}
 
		//Regular expressions
		private boolean validaIngreso1() {
			
			
			boolean validado1=true;
			
			
			 if( usu.getText().equals("") || String.valueOf(pin.getPassword()).equals("") ){
				validado1=false; 
				JOptionPane.showMessageDialog (this, "Por favor complete todos los campos"); 
			 }
	 
			 else if(!usu.getText().matches("[a-zA-Z0-9]{8,20}")) {
				 
				 validado1=false; 
				 JOptionPane.showMessageDialog(this, "Nombre de usuario incorrecto. Debe contener entre 8 y 20 caracteres.");
			 }
			 else if( ! (String.valueOf(pin.getPassword())).matches( "[a-zA-Z0-9]{8}" ) ) {
				 
				 validado1=false; 
				 JOptionPane.showMessageDialog(this, "Contraseña incorrecta. Debe tener 8 caracteres.");
			 }
		return validado1;
		}
			
		//User existence
		private boolean validaIngreso2() {
			 
			boolean validado2=false;
		//  String usuario=usu.getText();
	    //	char[] contraseña=pin.getPassword();
				 
	  /*
		 if (usuario==user[0].getUsuario() || usuario==user[1].getUsuario() ||
			 usuario==user[2].getUsuario() || usuario==user[3].getUsuario() ) { 	*/
			    	
			for(int i=0; i<user.length; i++) {
			    		 
			     if((String.copyValueOf(pin.getPassword()).equals(user[i].getClave())) && usu.getText().contentEquals(user[i].getUsuario())){
			    		 
			    	usuValidado= user[i];
			    	validado2=true; 
			    		 	}
			    		}
			
			     if(validado2 == false) {
			    		
			    	JOptionPane.showMessageDialog(this, "Contraseña o usuario ingresado incorrecto");
			     	pin.setText("");
			     	usu.setText("");	
			    			
			     	}
			    return validado2; 
			  } 
				
		
		//Create Radio Button
		private void pantallaOperaciones() {
			
			
			//Buttons
			boton4=new JButton("Aceptar");
			boton4.setBounds(60, 220, 100, 30);
			add(boton4);
			boton4.addActionListener(this);
		
			boton5=new JButton("Salir");
			boton5.setBounds(180, 220, 100, 30);
			add(boton5);
			boton5.addActionListener(this);
			repaint();
			
			java.awt.Container container=getContentPane();
			container.setLayout(null);       
					
		    //Create Radio Buttons 
			
			setLayout(null);
			btnCA = new JRadioButton("CAJA DE AHORRO", true);
			btnCA.setBounds(10, 25, 200, 20);
			container.add(btnCA);
			btnCA.addActionListener(this);
					
			btnCC = new JRadioButton("CUENTA CORRIENTE",true);
			btnCC.setBounds(10, 50, 200, 20);
			container.add(btnCC);
			btnCC.addActionListener(this);
			
			//Group 1 Radio Buttons.
			ButtonGroup tipoCtaGroup= new ButtonGroup();					
			tipoCtaGroup.add(btnCA);										
			tipoCtaGroup.add(btnCC);	
			tipoCtaGroup.clearSelection();
			
		    btnConsultar = new JRadioButton("Consultar saldo",true);
		    btnConsultar.setBounds(10, 90, 200, 30);
		    container.add(btnConsultar);  
		    btnConsultar.addActionListener(this);
		    
		    
		    btnExtraer = new JRadioButton("Extracción",true);   
		    btnExtraer.setBounds(10, 120, 200, 30);
		    container.add(btnExtraer);
		    btnExtraer.addActionListener(this);
		
		    btnTransferencia = new JRadioButton("Trasferencia",true);
		    btnTransferencia.setBounds(10, 150, 200, 30);
		    container.add(btnTransferencia);
		    btnTransferencia .addActionListener(this);
		    
		    
		    btnDepositar = new JRadioButton("Depositar",true);
		    btnDepositar.setBounds(10, 180, 200, 30);
		    container.add(btnDepositar);
		    btnDepositar.addActionListener(this);
		    
		
		    //Group 2 Radio Buttons
		    ButtonGroup group = new ButtonGroup();
		    group.add(btnExtraer);
		    group.add(btnTransferencia);
		    group.add(btnDepositar);
		    group.add(btnConsultar);
		    group.clearSelection();
	
			
		}
		
		
		//Operations
		
		private void extraccionCC() {
				
		int	montoAExt= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCtaCte() + 
																		  "\n \n Ingrese monto que desea extraer:"));
		if((usuValidado.getSaldoCtaCte()) >= montoAExt) {
			
			usuValidado.actualizarCCext(montoAExt);
			JOptionPane.showMessageDialog(this, "Usted ha extraido un monto de  " + montoAExt + "  pesos." +
											  "\n \n Ahora, su saldo disponible en su Cuenta Corriente es: " + usuValidado.getSaldoCtaCte() ); 
					  	
			}
		else {
			JOptionPane.showMessageDialog(this, "Su saldo es insuficiente");
			}
		}
		
		
		private void extraccionCA() {
			
			int	montoAExt= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCajaAhorro() + 
																			  "\n \n Ingrese monto que desea extraer:"));
			if((usuValidado.getSaldoCajaAhorro()) >= montoAExt) {
				
				usuValidado.actualizarCAext(montoAExt);
				JOptionPane.showMessageDialog(this, "Usted ha extraido un monto de  " + montoAExt + "  pesos." +
												  "\n \n Ahora, su saldo disponible en su Caja de Ahorro es: " + usuValidado.getSaldoCajaAhorro() ); 
						  	
			}
			else {
				JOptionPane.showMessageDialog(this, "Su saldo es insuficiente");
			}
		}

		
		private void depositaCC() {
			
			int	montoADepositar= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCtaCte() + 
																			  "\n \n Ingrese monto que desea depositar:"));
							
				usuValidado.actualizarCCdep(montoADepositar);
				JOptionPane.showMessageDialog(this, "Usted ha depositado un monto de  " + montoADepositar + "  pesos." +
												  "\n \n Ahora, su saldo disponible en su Caja de Ahorro es: " + usuValidado.getSaldoCtaCte() ); 
						  	
			}
			
		
		private void depositaCA(){
			
			int	montoADepositar= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCajaAhorro() + 
					  "\n \n Ingrese monto que desea depositar:"));

			usuValidado.actualizarCAdep(montoADepositar);
			JOptionPane.showMessageDialog(this, "Usted ha depositado un monto de  " + montoADepositar + "  pesos." +
			"\n \n Ahora, el saldo disponible en su Caja de Ahorro es: " + usuValidado.getSaldoCajaAhorro() ); 

		}
		
		
		private void transferenciaCC() {
			
			boolean existe=false;
			
			while(existe==false) {
				
						String usuATransferir= JOptionPane.showInputDialog(this, "Ingrese nombre de usuario ha quien le desea transferir: "); 

						for(int i=0; i<user.length; i++) {
				    		 
						     if(user[i].getUsuario().equals(usuATransferir)){
						    		
						    	 existe=true;
						    	 realizaTransferenciaCC(usuATransferir);
						    	 break;
						    	  }
							}
						
						if(existe == false) {
							existe=true;
							JOptionPane.showMessageDialog(this, "Usuario ingresado inexistente");
						}
			}
			existe=true;
		}
		
				private void realizaTransferenciaCC(String usuATransferir) {
				
					int	montoATransferir= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCtaCte() + 
																							 "\n \n Ingrese monto que desea transferir a " + 
																							  usuATransferir +" : \n"));
					if(montoATransferir <= usuValidado.getSaldoCtaCte()) {
						
						
						usuValidado.actualizarCCext(montoATransferir);
						JOptionPane.showMessageDialog(this, "Transferencia realizada con exito.\n" +
															"Usted ha depositado un monto de  " + montoATransferir + "  pesos" +
								 							" en la cuenta del " + usuATransferir + "." +
															"\n Ahora, el saldo disponible en su Cuenta Corriente es: " + usuValidado.getSaldoCtaCte());
					 }
					else { 
						JOptionPane.showMessageDialog(this, "Saldo insuficiente");
							} 
				
			}
				
		private void transferenciaCA() {
		
			boolean existe=false;	
			while(existe==false) {
				
						String usuATransferir= JOptionPane.showInputDialog(this, "Ingrese nombre de usuario ha quien le desea transferir: "); 

						for(int i=0; i<user.length; i++) {
				    		 
						     if(user[i].getUsuario().equals(usuATransferir)){
						    		
						    	 existe=true;
						    	 realizaTransferenciaCA(usuATransferir);
						    	 break;
						    	  }
							}
						
						if(existe == false) {
							existe=true;
							JOptionPane.showMessageDialog(this, "Usuario ingresado inexistente");
						}
			}
			existe=true;
		}
		
				private void realizaTransferenciaCA(String usuATransferir) {
				
					int	montoATransferir= Integer.parseInt(JOptionPane.showInputDialog(this, "Su saldo disponible es: "+ usuValidado.getSaldoCajaAhorro() + 
																							 "\n \n Ingrese monto que desea transferir a " + 
																							  usuATransferir +" : \n"));
					if(montoATransferir <= usuValidado.getSaldoCajaAhorro()) {
						
						
						usuValidado.actualizarCAext(montoATransferir);
						JOptionPane.showMessageDialog(this, "Transferencia realizada con exito.\n" +
															"Usted ha depositado un monto de  " + montoATransferir + "  pesos" +
								 							" en la cuenta del " + usuATransferir + "." +
															"\n Ahora, el saldo disponible en su Caja de Ahorro es: " + usuValidado.getSaldoCajaAhorro());
					 }
					else { 
						JOptionPane.showMessageDialog(this, "Saldo insuficiente");
							} 
				
			}
			
				
		//Empty textField 
		private void desactiva() {
			usu.setVisible(false);
			text.setVisible(false);
			pin.setVisible(false);
			passtx.setVisible(false);
			boton1.setVisible(false);
			boton2.setVisible(false);
			boton3.setVisible(false);
		   }

		//Users
		public static void pasaClientes(Cliente[] cli) {
			
			for(int i=0; i<4; i++) 
				user[i]=cli[i];
			
		}

}
