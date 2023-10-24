package Entidades;

import java.time.LocalDate;

public class Carnet 
{
	/*Variables*/
	private long idperegrino;
	private LocalDate fechaexp;
	private double distancia;
	private int nvips=0;
	private Parada paradaIni;
	
	/*Getters y Setters*/
	public long getIdperegrino() 
	{
		return idperegrino;
	}
	public void setIdperegrino(long idperegrino) 
	{
		this.idperegrino = idperegrino;
	}
	public LocalDate getFechaexp() 
	{
		return fechaexp;
	}
	public void setFechaexp(LocalDate fechaexp) 
	{
		this.fechaexp = fechaexp;
	}
	public double getDistancia() 
	{
		return distancia;
	}
	public void setDistancia(double distancia) 
	{
		this.distancia = distancia;
	}
	public int getNvips() 
	{
		return nvips;
	}
	public void setNvips(int nvips) 
	{
		this.nvips = nvips;
	}
	
	public Parada getParadaIni() 
	{
		return paradaIni;
	}
	public void setParadaIni(Parada paradaIni) 
	{
		this.paradaIni = paradaIni;
	}
	/*Constructores*/
	public Carnet() 
	{
		super();
	}
	public Carnet(long idperegrino,Parada paradaIni) 
	{
		super();
		this.idperegrino = idperegrino;
		this.fechaexp = LocalDate.now();
		this.distancia = 0.0;
		this.nvips = 0;
		this.paradaIni = paradaIni;
	}
	
	/*Metodos*/
	public static void nuevoCarnet(long idper,Parada paradaIni) 
	{
		Carnet c=new Carnet(idper,paradaIni);
	}

}
