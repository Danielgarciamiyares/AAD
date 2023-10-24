package Entidades;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Extras.Extras;

public class Parada 
{
	/*Variables*/
	private static long id=0;
	private String nombre;
	private char region;
	
	private String nombreadm;
	private String contrasena;
	public static Set<Peregrino> Peregrinos=new HashSet<Peregrino>();
    public static File ficheropar =new File(".\\src\\main\\java\\Ficheros\\paradas.dat");
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
	public char getRegion() 
	{
		return region;
	}
	public void setRegion(char region) 
	{
		this.region = region;
	}
	
	public String getNombreadm() 
	{
		return nombreadm;
	}
	public void setNombreadm(String nombreadm) 
	{
		this.nombreadm = nombreadm;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) 
	{
		this.contrasena = contrasena;
	}
	public static Set<Peregrino> getPeregrinos() 
	{
		return Peregrinos;
	}
	public static void setPeregrinos(Set<Peregrino> peregrinos) 
	{
		Peregrinos = peregrinos;
	}
	/*Constructores*/
	public Parada() 
	{
		super();
	}
	public Parada(long id, String nombre, char region) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
	}
	
	public Parada(long id, String nombre, char region, String nombreadm, String contrasena) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.region = region;
		this.nombreadm = nombreadm;
		this.contrasena = contrasena;
	}
	/*Métodos*/
	
//    public static long paradaID () {
//        return id++;
//    }
	public static void nuevaParada() 
	{
		Scanner scn=new Scanner(System.in);
		boolean valido=false;
		
		do {
			System.out.println("Introduza el nombre de la nueva parada");
			String nombre=scn.nextLine();

		
			if(Extras.comprobarNombreParada(nombre)) 
			{
				System.out.println("El nombre de la parada ya está en uso,por favor introduzca un nombre distinto");
				valido=false;
			}
			else 
			{
				
				System.out.println("Introduzca la región de la nueva parada");
				char region=scn.nextLine().charAt(0);

				do 
				{
					System.out.println("Nombre de admin parada");
					String nombreadm;
					do
					{	
						nombreadm=scn.nextLine();
						if(Extras.comprobarNombreAdminPar(nombreadm)) 
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
					
					System.out.println("Contraseña de admin parada");
					String contrasenapar;
					do 
					{	
						contrasenapar=scn.nextLine();
						if(Extras.comprobarContrasenaAdminPar(nombreadm,contrasenapar)) 
						{
							valido=true;
						}
						else
						{
							System.out.println("La contraseña no es correcta, introdúzcala de nuevo");
							valido=false;
						}
					}
					while(!valido);
					System.out.println("La parada es válida");

       			 try 
       			 {
			        ficheropar.createNewFile();
			        FileOutputStream writer = new FileOutputStream(ficheropar,true);
			        BufferedOutputStream bos = new BufferedOutputStream (writer);
					
			        long a;
			        a = Extras.calcularIdParada();
					
					Parada p=new Parada(a,nombre,region,nombreadm,contrasenapar);
					Peregrino.Paradas.add(p);
					
	        		 if (ficheropar.exists()) 
	        		 {
				        bos.write(p.toString().getBytes());
				        bos.close();
				        writer.close();
	        		 }
				}
       			catch (IOException e) 
       			{
						System.out.println("No se ha podido crear el fichero: "+e.getMessage());  
				}
					valido=true;
				}
				while(!valido);
			}
		}
		while(!valido);
	}
	@Override
	public String toString() {
		return id+" "+nombre+" "+region+" "+nombreadm+" "+contrasena+"\n";
	}
}