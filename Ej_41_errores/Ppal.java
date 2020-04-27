package ui;

import Entidades.Empleados;
import javax.swing.JOptionPane;

public class Ppal {

	static String nombre;
	static String apellido;
	static int cantHsTrabajadas;
	static Empleados[] emp=new Empleados[3];
	
	
	
	public static void main(String args[]) {
		
		String error=".";
		
		for(int a=0;a<3;a++) {
			
			try { 	if(a==0 || error!=null) {  // error!=null --> error en las iteraciones anteriores.
				
						JOptionPane.showMessageDialog(null,"Carga de empleados");
						JOptionPane.showMessageDialog(null, "Ingrese los datos del empleado"+(a+1));
						carga();
						emp[a]= cargaEmp(nombre, apellido, cantHsTrabajadas);
						
				 		}
			}	
			
			catch(NullPointerException e) {
				error="No ingreso todos los datos pedidos";
				JOptionPane.showMessageDialog(null, error, "ATENCIÓN", JOptionPane.ERROR_MESSAGE);
				a--;
			}
			
			catch(NumberFormatException e) {
				error="Debe ingresar unicamente números.";
				JOptionPane.showMessageDialog(null, error, "ATENCIÓN", JOptionPane.ERROR_MESSAGE);
				a--;
				
			}
			
		}
		
		
		
		
		JOptionPane.showMessageDialog(null, "Listado de empleados --->");
		listarEmpleados();		
	}


	
	
	private static void listarEmpleados() {
		for(int j=0;j<3;j++){
			
			System.out.println("\n");
			System.out.println("\n");
			
			System.out.println("\n Nombre: "+emp[j].getNombre()+
							   "\n Apellido: "+emp[j].getApellido()+
							   "\n Cant de horas trabajadas: "+ emp[j].getCantHsTrabajadas()+
								"\n Cant de horas simples: "+ emp[j].getCantHsSimples()+
								"\n Cant de horas extras: "+ emp[j].getCantHsExcedentes()+
								"\n Sueldo Basico: $"+ ((emp[j].getCantHsSimples()*25)+ (emp[j].getCantHsExcedentes()*30))+ 
								"\n Descuentos: $"+ ((emp[j].getCantHsSimples()*25)*0.195)+ 
								"\n Premio: $"+ emp[j].getPremio()+
								"\n A cobrar: $"+ emp[j].getaCobrar());
		}
	}


	private static Empleados cargaEmp(String nombre,String apellido,int cantHsTrabajadas) {
		Empleados e= new Empleados(nombre,apellido,cantHsTrabajadas);
		return e;
	}


	private static void carga() {
		nombre=JOptionPane.showInputDialog("Ingrese nombre del empleado: ");
		apellido=JOptionPane.showInputDialog("Ingrese apellido del empleado: ");
		cantHsTrabajadas=(Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantdad de horas trabajadas del empleado: ")));
	}
}
