package Entidades;

import java.io.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import Extras.Extras;

public class Peregrino 
{
	/*Variables*/
	private static long id=0;
	private String nombre;
	private String nacionalidad;
	
	private String contrasena;
	private Perfil perfil;
	public static Set<Parada> Paradas=new HashSet<Parada>();
	public static Set<Estancia> Estancias=new HashSet<Estancia>();
    public static File ficheroper =new File(".\\src\\main\\java\\Ficheros\\credenciales.txt");
	/*Getters y Setters*/
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	public String getNacionalidad() 
	{
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) 
	{
		this.nacionalidad = nacionalidad;
	}
	public String getContrasena() 
	{
		return contrasena;
	}
	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	public Perfil getPerfil() 
	{
		return perfil;
	}
	public void setPerfil(Perfil perfil) 
	{
		this.perfil = perfil;
	}
	public static Set<Parada> getParadas() 
	{
		return Paradas;
	}
	public static void setParadas(Set<Parada> paradas) 
	{
		Paradas = paradas;
	}
	public static Set<Estancia> getEstancias() 
	{
		return Estancias;
	}
	public static void setEstancias(Set<Estancia> estancias) 
	{
		Estancias = estancias;
	}
	/*Constructores*/
	public Peregrino() 
	{
		super();
	}
	public Peregrino(long id, String nombre, String nacionalidad) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
	}
	
	public Peregrino(String nombre,String contrasena, Perfil perfil, long id) {
		super();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.perfil = perfil;
		this.id=id;
	}
	/*Métodos*/
	public static void nuevoPeregrino() 
	{
		Scanner scn;
		boolean valido=false;
		
		do {
			try 
			{
				scn=new Scanner(System.in);
				System.out.println("Introduzca el id de la parada inicial");
				long idParada=scn.nextLong();		
				scn.nextLine();

				if(Extras.comprobarIdParada(idParada))//s.getId()/*id parada de paradas.dat*/) 
				{
					do 
					{
						System.out.println("Introduzca el nombre del nuevo peregrino");
						String nombre=scn.nextLine();
	
						if(Extras.comprobarNombrePer(nombre)) 
						{
							System.out.println("El nombre ya está en uso");
							valido=false;
						}
						else 
						{
							System.out.println("Introduzca la contraseña  del nuevo peregrino");
							String contrasena=scn.nextLine();
							
							System.out.println("Introduzca la nacionalidad del nuevo peregrino");
							String nacionalidad=scn.nextLine();
							
							Perfil perfil=Perfil.PEREGRINO;
							
					        long a;
					        a = Extras.calcularIdPer();

//							Carnet.nuevoCarnet(a,p);
							
		        			 try 
		        			 {
		 				        ficheroper.createNewFile();
		 				        FileWriter writer = new FileWriter(ficheroper,true);
						        BufferedWriter bw = new BufferedWriter (writer);
								
								Peregrino per=new Peregrino(nombre,contrasena,perfil,a);
								Parada.Peregrinos.add(per);
								
				        		 if (ficheroper.exists()) 
				        		 {
							        bw.write(per.toString());
							        bw.close();
							        writer.close();					      
				        		 }
							}
		        			catch (IOException e) 
		        			{
								System.out.println("No se ha podido crear el fichero: "+e.getMessage());  
							}
							valido=true;
						}
					}
					while(!valido);
					valido=true;
				}
				else 
				{
					System.out.println("El id de la parada no es correcto, inrodúzcalo de nuevo");
					valido=false;
				}
			}
			catch (InputMismatchException e) 
			{
				System.out.println(e.getMessage());
			}
			catch (NumberFormatException e) 
			{
				System.out.println(e.getMessage());
			}
		}
		while(!valido);
	}
	@Override
	public String toString() 
	{
		/*nombre contraseña perfil id*/
		return nombre+" "+contrasena+" "+perfil+" "+id+"\n";
	}
}