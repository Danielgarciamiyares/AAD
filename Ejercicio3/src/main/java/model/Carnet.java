package model;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.*;


@Entity
@Table(name="carnet")
public class Carnet 
{
	/*Variables*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@JoinColumn(name="")
	private Long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)/*Coge solamnete la fecha*/
	private LocalDate fechaexp;
	
	@Column(nullable=false)
	private Double distancia;
	
	@Column(nullable=false)
	private Integer nvips;
	/*Relaciones*/
		/*Carnet-Parada*/
		@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "carnet")
		private Parada parada;
		
	/*Constructores*/
	public Carnet() 
	{
		
	}
	public Carnet(Long id, LocalDate fechaexp, Double distancia, Integer nvips, Parada parada)
	{
		super();
		this.id = id;
		this.fechaexp = fechaexp;
		this.distancia = distancia;
		this.nvips = nvips;
		this.parada = parada;
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
	public LocalDate getFechaexp() 
	{
		return fechaexp;
	}
	public void setFechaexp(LocalDate fechaexp) 
	{
		this.fechaexp = fechaexp;
	}
	public Double getDistancia() 
	{
		return distancia;
	}
	public void setDistancia(Double distancia) 
	{
		this.distancia = distancia;
	}
	public Integer getNvips()
	{
		return nvips;
	}
	public void setNvips(Integer nvips)
	{
		this.nvips = nvips;
	}
	public Parada getParada() 
	{
		return parada;
	}
	public void setParada(Parada parada)
	{
		this.parada = parada;
	}
	/*Metodos*/
	@Override
	public int hashCode() 
	{
		return Objects.hash(distancia, fechaexp, id, nvips, parada);
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
		Carnet other = (Carnet) obj;
		return Objects.equals(distancia, other.distancia) && Objects.equals(fechaexp, other.fechaexp)
				&& Objects.equals(id, other.id) && Objects.equals(nvips, other.nvips)
				&& Objects.equals(parada, other.parada);
	}
	@Override
	public String toString() 
	{
		return "Carnet [id=" + id + ", fechaexp=" + fechaexp + ", distancia=" + distancia + ", nvips=" + nvips
				+ ", parada=" + parada + "]";
	}

	
	
	
}
