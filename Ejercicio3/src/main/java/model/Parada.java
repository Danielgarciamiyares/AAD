package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="parada")
public class Parada 
{
	/*Variables*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private Character region;
	/*Relaciones*/
		/*Parada-Peregrino*/
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="parada")
		private List<PeregrinoParada>peregrinos;
	
	/*Constructores*/
	public Parada()
	{
		
	}
	public Parada(Long id, String nombre, Character region, List<PeregrinoParada> peregrinos) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.region = region;
		this.peregrinos = peregrinos;
	}
	/*Getters y Setters*/
	public Long getId() 
	{
		return id;
	}
	public void setId(Long id) 
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
	public Character getRegion()
	{
		return region;
	}
	public void setRegion(Character region)
	{
		this.region = region;
	}
	public List<PeregrinoParada> getPeregrinos() 
	{
		return peregrinos;
	}
	public void setPeregrinos(List<PeregrinoParada> peregrinos)
	{
		this.peregrinos = peregrinos;
	}
	/*Metodos*/
	@Override
	public int hashCode() 
	{
		return Objects.hash(id, nombre, peregrinos, region);
	}
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parada other = (Parada) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(peregrinos, other.peregrinos) && Objects.equals(region, other.region);
	}
	@Override
	public String toString()
	{
		return "Parada [id=" + id + ", nombre=" + nombre + ", region=" + region + ", peregrinos=" + peregrinos + "]";
	}
	
}
