package Extras;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import Entidades.Parada;
import Entidades.Peregrino;
import Entidades.Perfil;

public class Extras 
{
	/*Mira cual es el id mas alto del perfil peregrino en el fichero credenciales y le añade 1 al siguiente(autoincrementa)*/
	public static long calcularIdPer()/*llamar calcularIdPer*/ 
	{
		long sigId=1;
		long id=1;
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                	String[] values = line.split(" ");
                    if(values[2].equals("PEREGRINO")) 
                    {
                    	id = Long.parseLong(values[3]);
                    	for(sigId=0;id>=sigId;sigId++) 
                    	{
                    		
                    	}
                    }
                }
          	}
            catch (EOFException e) 
            {
                e.getMessage();
            } 
            catch (FileNotFoundException e) 
            {
                e.getMessage();
            }
            catch (IOException e) 
            {
                e.getMessage();
            }
		return sigId;
	}
	/*Mira cual es el id mas alto del perfil admin_paradas en el fichero credenciales y le añade 1 al siguiente(autoincrementa)*/
	public static long calcularIdAdminParada() 
	{
		long sigId=1;
		long id=1;
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("ADMIN_PARADA")) 
                    {
                    	id = Long.parseLong(values[3]);
                    	for(sigId=0;id>=sigId;sigId++) 
                    	{
                    		
                    	}
                    }
                }
          	}
            catch (EOFException e) 
            {
                e.getMessage();
            } 
            catch (FileNotFoundException e) 
            {
                e.getMessage();
            }
            catch (IOException e) 
            {
                e.getMessage();
            }
		return sigId;
	}
	/*Mira cual es el id mas alto de las parada en el fichero paradas y le añade 1 al siguiente(autoincrementa)*/
	public static long calcularIdParada() 
	{
		long sigId=1;
		long id=1;
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Parada.ficheropar.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                	String[] values = line.split(" ");
                	id = Long.parseLong(values[0]);
                	for(sigId=0;id>=sigId;sigId++) 
                	{
                		
                	}
                }
          	}
            catch (EOFException e) 
            {
                e.getMessage();
            } 
            catch (FileNotFoundException e) 
            {
                e.getMessage();
            }
            catch (IOException e) 
            {
                e.getMessage();
            }
		return sigId;
	}
	
	
	/*Comprueba si el valor introducido existe en el fichero ficheropar*/
	public static boolean comprobarIdParada(long idParada) 
	{
		boolean ret=false;
		long id;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Parada.ficheropar.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                	id = Long.parseLong(values[0]);
                	if(id==idParada)
                	{
                		ret=true;
                		break;
                	}
                	
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt*/
	public static boolean comprobarNombrePer(String nombrePer) 
	{
		boolean ret=false;
		String nombre;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("PEREGRINO")) 
                    {
	                	nombre =values[0];
	                	if(nombre.equals(nombrePer))
	                	{
	                		ret=true;
	                	}
	                	break;
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	
	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt y si es asi comprueba la contraseña*/
	public static boolean comprobarContrasenaPer(String nombrePer,String contrasenaPer) 
	{
		boolean ret=false;
		String nombre;
		String contrasena;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("PEREGRINO")) 
                    {
                	nombre =values[0];
	                	if(nombre.equals(nombrePer))
	                	{
	                    	contrasena =values[1];
	                    	if(contrasena.equals(contrasenaPer))
	                    	{
	                    		ret=true;
	                    	}
	                    	break;
	                	}
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}

	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt*/
	public static boolean comprobarNombreAdminPar(String nombreAdminPar) 
	{
		boolean ret=false;
		String nombre;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("ADMIN_PARADA")) 
                    {
	                	nombre =values[0];
	                	if(nombre.equals(nombreAdminPar))
	                	{
	                		ret=true;
	                		break;
	                	}
	                	
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	
	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt y si es asi comprueba la contraseña*/
	public static boolean comprobarContrasenaAdminPar(String nombreAdminPar,String contrasenaAdminPar) 
	{
		boolean ret=false;
		String nombre;
		String contrasena;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
                //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("ADMIN_PARADA")) 
                    {
                	nombre =values[0];
	                	if(nombre.equals(nombreAdminPar))
	                	{
	                    	contrasena =values[1];
	                    	if(contrasena.equals(contrasenaAdminPar))
	                    	{
	                    		ret=true;
	                    		break;
	                    	}
	                	}
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	
	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt*/
	public static boolean comprobarNombreAdminGen(String nombreAdminGen) 
	{
		boolean ret=false;
		String nombre;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("ADMIN_GENERAL")) 
                    {
	                	nombre =values[0];
	                	if(nombre.equals(nombreAdminGen))
	                	{
	                		ret=true;
	                	}
	                	break;
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	
	/*Comprueba si el nombre pasado por parámetro está en credenciales.txt y si es asi comprueba la contraseña*/
	public static boolean comprobarContrasenaAdminGen(String nombreAdminGen,String contrasenaAdminGen) 
	{
		boolean ret=false;
		String nombre;
		String contrasena;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Peregrino.ficheroper.toPath()).toArray(new String[0]);
                //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                    if(values[2].equals("ADMIN_GENERAL")) 
                    {
                	nombre =values[0];
	                	if(nombre.equals(nombreAdminGen))
	                	{
	                    	contrasena =values[1];
	                    	if(contrasena.equals(contrasenaAdminGen))
	                    	{
	                    		ret=true;
	                    	}
	                    	break;
	                	}
                    }
                }
          	}
            catch (EOFException e) 
            {
               System.out.println(e.getMessage());
            } 
            catch (FileNotFoundException e) 
            {
            	System.out.println(e.getMessage());
            }
            catch (IOException e) 
            {
            	System.out.println(e.getMessage());
            }
		return ret;
	}
	
	
	/*Comprueba si el nombre pasado por parámetro está en padadas.dat*/
	public static boolean comprobarNombreParada(String nombreParada) 
	{
		boolean ret=false;
		String nombre;
		
            try 
            {
                //Obtiene array de lineas contenidas en archivo.
                String[] lines = Files.readAllLines(Parada.ficheropar.toPath()).toArray(new String[0]);
               //Analiza cada linea y la compara.

                for (String line : lines) 
                {
                    String[] values = line.split(" ");
                	nombre =values[1];
                	if(nombre.equals(nombreParada))
                	{
                		ret=true;
                		break;
                	}
                }
          	}
            catch (EOFException e) 
            {
               e.getMessage();
            } 
            catch (FileNotFoundException e) 
            {
            	e.getMessage();
            }
            catch (IOException e) 
            {
            	e.getMessage();
            }
		return ret;
	}
	
	

}