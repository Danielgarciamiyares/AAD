package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="peregrino")
public class Peregrino 
{
	/*Variables*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false,unique=true)
	private String nombre;
	
	@Column(nullable=false)
	private String nacionalidad;
	
	/*Relaciones*/
		/*Peregrino-Carnet*/
		@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy = "peregrino")
		private Carnet carnet;
		
		/*Peregrino-Parada(Tabla intermedia)*/
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="peregrino")
		private List<PeregrinoParada> paradas;
		
		/*Peregrino-Estancia*/
		@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="peregrino")
		private List<Estancia> estancias;
	
	/*Constructores*/
	public Peregrino() 
	{
		
	}	
	public Peregrino(Long id, String nombre, String nacionalidad, Carnet carnet, List<PeregrinoParada> paradas,List<Estancia> estancias) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
		this.carnet = carnet;
		this.paradas = paradas;
		this.estancias = estancias;
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
	public String getNacionalidad() 
	{
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) 
	{
		this.nacionalidad = nacionalidad;
	}
	public Carnet getCarnet() 
	{
		return carnet;
	}
	public void setCarnet(Carnet carnet) 
	{
		this.carnet = carnet;
	}
	
	public List<PeregrinoParada> getParadas() 
	{
		return paradas;
	}
	public void setParadas(List<PeregrinoParada> paradas)
	{
		this.paradas = paradas;
	}
	
	public List<Estancia> getEstancias() 
	{
		return estancias;
	}
	public void setEstancias(List<Estancia> estancias)
	{
		this.estancias = estancias;
	}
	/*Metodos*/
	@Override
	public int hashCode() 
	{
		return Objects.hash(carnet, estancias, id, nacionalidad, nombre, paradas);
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
		Peregrino other = (Peregrino) obj;
		return Objects.equals(carnet, other.carnet) && Objects.equals(estancias, other.estancias)
				&& Objects.equals(id, other.id) && Objects.equals(nacionalidad, other.nacionalidad)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(paradas, other.paradas);
	}
	@Override
	public String toString() 
	{
		return "Peregrino [id=" + id + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", carnet=" + carnet
				+ ", paradas=" + paradas + ", estancias=" + estancias + "]";
	}
}
