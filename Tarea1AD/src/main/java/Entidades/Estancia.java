package Entidades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Estancia 
{
	/*Variables*/
	private static long id=0;
	private LocalDate fecha;
	private boolean vip=false;
	/*Getters y Setters*/
	public long getId() 
	{
		return id;
	}
	public void setId(long id) 
	{
		this.id = id;
	}
	public LocalDate getFecha() 
	{
		return fecha;
	}
	public void setFecha(LocalDate fecha) 
	{
		this.fecha = fecha;
	}
	public boolean isVip() 
	{
		return vip;
	}
	public void setVip(boolean vip) 
	{
		this.vip = vip;
	}
	/*Constructores*/
	public Estancia() 
	{
		super();
	}
	public Estancia(long id, LocalDate fecha, boolean vip) 
	{
		super();
		this.id = id;
		this.fecha = fecha;
		this.vip = vip;
	} 
	/*Metodos*/
	
	public static void nuevaEstancia() 
	{
		Scanner scn=new Scanner(System.in);
		
        long a;
        a = id+1;
		LocalDate fecha=LocalDate.now();
		System.out.println("¿La estancia es VIP?");
		boolean vip=scn.nextBoolean();
		
		Estancia est=new Estancia(a,fecha,vip);
		Peregrino.Estancias.add(est);
	}
		
}