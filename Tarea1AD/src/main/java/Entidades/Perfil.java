package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Extras.Extras;

public enum Perfil 
{
	INVITADO,PEREGRINO,ADMIN_PARADA,ADMIN_GENERAL;
	
	/*Metodos*/
	public static Perfil selecPerfil() /*Login*/
	{
		Perfil ret=INVITADO;
		boolean valido=false;
		int eleccion=0;
		
		do 
		{
			try 
			{
				Scanner scn=new Scanner(System.in);
				System.out.println("Seleccione el tipo de usuario:\n 1.Peregrino\n 2.Administrador de una parada\n 3.Administrador general");
				eleccion=scn.nextInt();
				scn.nextLine();
				if(eleccion<1||eleccion>3) 
				{
					System.out.println("Opcion no valida");
					valido=false;
				}
				else 
				{
					switch (eleccion) 
					{
						case 1: //Peregrino
						{
							do 
							{
								System.out.println("Usuario");
								String usuario;
								do 
								{	
									usuario=scn.nextLine();
									if(Extras.comprobarNombrePer(usuario)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("El usuario no existe,introdúzcalo de nuevo");
										valido=false;
									}
								}
								while(!valido);
								
								System.out.println("Contraseña");
								String contrasena;
								do 
								{
									contrasena=scn.nextLine();
									if(Extras.comprobarContrasenaPer(usuario,contrasena)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("La contraseña introducida no es correcta,introdúzcala de nuevo");
										valido=false;
									}
								}
								while(!valido);
								do 
								{
									boolean sesion=true;
									ret=PEREGRINO;
									/*menuPergrino*/
									System.out.println("Menu: ");
									System.out.println("1.Exportar carnet en XML");
									System.out.println("2.Alojarse");
									System.out.println("3.Cerrar sesión");
									int seleccion=scn.nextInt();
									scn.nextLine();
									
									if(seleccion<1||seleccion>3) 
									{
										System.out.println("Opción no válida");
										valido=false;
									}
									else 
									{
										switch (seleccion) 
										{
											case 1:/*Exportar carnet en XML*/
											System.out.println("Exportado");
											valido=false;/*Para volver a selecionar*/
											break;

											case 2:/*Alojarse*/
											System.out.println("Esta opción no esta disponible en este momento");
											valido=false;/*Por que no esta disponible*/
											break;
											
											case 3:/*Logout*/
											System.out.println("Cerrando sesión");
											sesion=false;
											valido=true;
											break;
										}
									}
								}
								while(!valido);							
							}
							while(!valido);
							break;
						}
						case 2: //Admin parada
						{
							do 
							{
								System.out.println("Usuario");
								String usuario;
								do 
								{	
									usuario=scn.nextLine();
									if(Extras.comprobarNombreAdminPar(usuario)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("El usuario no existe,introdúzcalo de nuevo");
										valido=false;
									}
								}
								while(!valido);
								System.out.println("Contraseña");
								String contrasena;
								do 
								{
									contrasena=scn.nextLine();
									if(Extras.comprobarContrasenaAdminPar(usuario,contrasena)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("La contraseña introducida no es correcta,introdúzcala de nuevo");
										valido=false;
									}
								}
								while(!valido);
								do 
								{	/*menuAdminParada*/
									boolean sesion=true;
									ret=ADMIN_PARADA;
									System.out.println("Menu: ");
									System.out.println("1.Exportar datos parada");
									System.out.println("2.Alojarse");
									System.out.println("3.Cerrar sesión");
									int seleccion=scn.nextInt();
									scn.nextLine();
									
									if(seleccion<1||seleccion>3) 
									{
										System.out.println("Opción no válida");
										valido=false;
									}
									else 
									{
										switch (seleccion) 
										{
											case 1:/*Exportar datos de parada*/
												
//					 				        File ficheroper =new File(".\\src\\main\\java\\Ficheros\\paradas.dat");
//					 				        ficheroper.createNewFile();
////									        FileReader reader = new FileReader(ficheroper);
////									        BufferedReader br = new BufferedReader (reader);
//									        
//					 				        FileWriter writer = new FileWriter(ficheroper,true);
//									        BufferedWriter bw = new BufferedWriter (writer);	
//												
//											System.out.println("Exportados");
											
											System.out.println("Esta opción no está disponible");
											valido=false;/*Para volver a selecionar*/
											break;

											case 2:/*Alojarse*/
											System.out.println("Esta opción no está disponible en este momento");
											valido=false;/*Por que no esta disponible*/
											break;
											
											case 3:/*Logout*/
											System.out.println("Cerrando sesión");
											sesion=false;
											valido=true;
											break;
										}
									}	
								}
								while(!valido);	
							}
							while(!valido);
							break;
						}
						case 3: //Admin general
						{
							do 
							{
								System.out.println("Usuario");
								String usuario;
								do 
								{	
									usuario=scn.nextLine();
									if(Extras.comprobarNombreAdminGen(usuario)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("El usuario no existe,introdúzcalo de nuevo");
										valido=false;
									}
								}
								while(!valido);
								System.out.println("Contraseña");
								String contrasena;
								do 
								{
									contrasena=scn.nextLine();
									if(Extras.comprobarContrasenaAdminGen(usuario,contrasena)) 
									{
										valido=true;
									}
									else
									{
										System.out.println("La contraseña introducida no es correcta,introdúzcala de nuevo");
										valido=false;
									}
								}
								while(!valido);
								do 
								{	/*menuAdminGeneral*/
									boolean sesion=true;
									ret=ADMIN_GENERAL;
									System.out.println("Menu: ");
									System.out.println("1.Registrar nueva parada");
									System.out.println("2.Cerrar sesión");
									int seleccion=scn.nextInt();
									scn.nextLine();
									
									if(seleccion<1||seleccion>2) 
									{
										System.out.println("Opción no válida");
										valido=false;
									}
									else 
									{
										switch (seleccion) 
										{
											case 1:/*Exportar datos de parada*/
											System.out.println("Creando parada");
											Parada.nuevaParada();
											valido=false;/*Para volver a selecionar*/
											break;
											
											case 2:/*Logout*/
											System.out.println("Cerrando sesión");
											sesion=false;
											valido=true;
											break;
										}
									}	
								}
								while(!valido);
							}
							while(!valido);
							break;
						}
					}
					valido=true;
				}
			}
			catch (Exception e) 
			{
				System.out.println("Algo extraño sucedio: "+e.getMessage());
				valido=false;
			}
		}
		while(!valido);
		return ret;
	}
	
	
	
	public static void nuevoAdminParadas() 
	{
		Scanner scn=new Scanner(System.in);
		
        long a;
        a = Extras.calcularIdAdminParada();
		
		System.out.println("Introduzca el nombre del nuevo administrador de parada");
		String nombre=scn.nextLine();
		
		System.out.println("Introduzca la contraseña del nuevo administrador de parada");
		String contrasena=scn.nextLine();
		
		Perfil perfil=Perfil.ADMIN_PARADA;
		

		

		try 
		{
			Peregrino.ficheroper.createNewFile();
			FileWriter writer = new FileWriter(Peregrino.ficheroper,true);
		    BufferedWriter bw = new BufferedWriter (writer);
		      
		    String adminParada=(nombre+" "+contrasena+" "+perfil+" "+Long.toString(a)+"\n");
		     
	        bw.write(adminParada);
	        bw.close();
	        writer.close();
		 }
		catch (IOException e) 
		{
			System.out.println("No se ha podido crear el fichero: "+e.getMessage());  
		}
		 
	}
	
	public static void nuevoAdmin() 
	{
		
		Scanner scn=new Scanner(System.in);
		
        long a;
        a = -3;
		
		System.out.println("Introduzca el nombre del nuevo administrador general");
		String nombre=scn.nextLine();
		
		System.out.println("Introduzca la contraseña del nuevo administrador general");
		String contrasena=scn.nextLine();
		
		Perfil perfil=Perfil.ADMIN_GENERAL;

		try 
		{
			Peregrino.ficheroper.createNewFile();
			FileWriter writer = new FileWriter(Peregrino.ficheroper,true);
		    BufferedWriter bw = new BufferedWriter (writer);
		      
		    String adminGeneral=(nombre+" "+contrasena+" "+perfil+" "+Long.toString(a)+"\n");
		     
	        bw.write(adminGeneral);
	        bw.close();
	        writer.close();
		 }
		catch (IOException e) 
		{
			System.out.println("No se ha podido guardar en el fichero: "+e.getMessage());  
		}
	}
	
	
	
	


}