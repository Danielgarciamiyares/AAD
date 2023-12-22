package model;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="estancia")
public class Estancia 
{
	/*Variables*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (nullable=false)
	@Temporal (TemporalType.DATE)
	private LocalDate  fecha;
	
	@Column(nullable=false)
	private Boolean vip;
	/*Relaciones*/
		/*Estancia-Parada*/
		@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL,mappedBy = "estancia")
		private Parada parada;
		
		/*Estancia-Peregrino*/
		@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
		@JoinColumn(name="peregrino")
		private Peregrino peregrino;
	
	/*Constructores*/
	public Estancia() 
	{
		
	}
	public Estancia(Long id, LocalDate fecha, Boolean vip, Parada parada, Peregrino peregrino) 
	{
		super();
		this.id = id;
		this.fecha = fecha;
		this.vip = vip;
		this.parada = parada;
		this.peregrino = peregrino;
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
	public LocalDate getFecha()
	{
		return fecha;
	}
	public void setFecha(LocalDate fecha) 
	{
		this.fecha = fecha;
	}
	public Boolean getVip() 
	{
		return vip;
	}
	public void setVip(Boolean vip)
	{
		this.vip = vip;
	}
	public Parada getParada()
	{
		return parada;
	}
	public void setParada(Parada parada) 
	{
		this.parada = parada;
	}
	public Peregrino getPeregrino() 
	{
		return peregrino;
	}
	public void setPeregrino(Peregrino peregrino) 
	{
		this.peregrino = peregrino;
	}
	/*Metodos*/
	@Override
	public int hashCode() 
	{
		return Objects.hash(fecha, id, parada, peregrino, vip);
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
		Estancia other = (Estancia) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id)
				&& Objects.equals(parada, other.parada) && Objects.equals(peregrino, other.peregrino)
				&& Objects.equals(vip, other.vip);
	}
	@Override
	public String toString()
	{
		return "Estancia [id=" + id + ", fecha=" + fecha + ", vip=" + vip + ", parada=" + parada + ", peregrino="
				+ peregrino + "]";
	}
	
}
