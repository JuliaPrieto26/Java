package TP_02;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javafx.event.ActionEvent;
import java.awt.*;

public class Pantalla_banco extends JFrame implements ActionListener{   
	
	private JButton boton1, boton2,boton3;
	private JLabel text,passtx;
	private JTextField usu;
	private JPasswordField pin;
	private static Cliente[] user=new Cliente[4];
	
	
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

	public void actionPerformed(java.awt.event.ActionEvent e) {
	  
		pasaClientes(user);
		
		if(e.getSource()==boton1) {
												
			char[] contraseña=pin.getPassword();
			String usuario=usu.getText();
	
			validaIngreso(contraseña, usuario);  
			
			desactiva();
			
			setTitle("Bienvenid@ "+usuario);
			JOptionPane.showMessageDialog(this, "Bienvenido");			
			
			}
		      
		
		if(e.getSource()==boton2){
			   usu.setText("");
		       pin.setText(""); 
		  }
									   
		if(e.getSource()==boton3){
			   System.exit(0);	   
		   }
											    
	}
 

		private void validaIngreso(char[] contraseña, String usuario) {
			
			//Regular expressions
			 if( usuario.equals("") || contraseña.equals("") ){
			 	JOptionPane.showInternalMessageDialog(this, "Por favor complete todos los campos");
			 }
			 else if(!usuario.matches("\\d{8,20}")) {
				 	JOptionPane.showInternalMessageDialog(this, "Nombre de usuario incorrecto. Debe contener enre 8 y 20 caracteres.");
			 }
			 else if( ! (String.valueOf(contraseña)).matches( "[a-zA-Z0-9]{8}" ) ) {
				 	JOptionPane.showInternalMessageDialog(this, "Contraseña incorrecta. Debe tener 8 caracteres.");
			 }
			 
			
			 
			 
			 //User existence
		    else if (usuario==user[1].getUsuario() || usuario==user[2].getUsuario() ||
		    		 usuario==user[3].getUsuario() || usuario==user[4].getUsuario() ) {
				 
		    	 
		    	
		    	//User correct and password incorrect c1
		    	
				 if((user[1].getUsuario().equals(usuario))) {
					 
					 if(!(user[1].getClave()).equals(contraseña)) {	
						 
						 JOptionPane.showInternalMessageDialog(this, "Contraseña incorrecta");
					 		}
				 		} 
			 		
			  	
				//User correct and password incorrect c2
				 
				 if((user[2].getUsuario().equals(usuario))) {
					 
					 if(!(user[2].getClave()).equals(contraseña)) {	
						 
						JOptionPane.showInternalMessageDialog(this, "Contraseña incorrecta");
							}
				 		} 
			 		
		    
					//User correct and password incorrect c3
				 
					 if((user[3].getUsuario().equals(usuario))) {
						 
						 if(!(user[3].getClave()).equals(contraseña)) {	
							 
							 JOptionPane.showInternalMessageDialog(this, "Contraseña incorrecta");
							 	}
					 		} 
						
					//User correct and password incorrect c4
					 
					if((user[4].getUsuario().equals(usuario))) {
						 
						 if(!(user[4].getClave()).equals(contraseña)) {	
							 
							  JOptionPane.showInternalMessageDialog(this, "Contraseña incorrecta");
							  	}
							} 
					}
		
				 
			 }
		
		private void desactiva() {
			usu.setVisible(false);
			text.setVisible(false);
			pin.setVisible(false);
			passtx.setVisible(false);
			boton1.setVisible(false);
			boton2.setVisible(false);
			boton3.setVisible(false);
		   }

	

		
		
		
	public static void pasaClientes(Cliente[] cli) {
		
		for(int i=0; i<4; i++) 
			user[i]=cli[i];
		
	}

}
