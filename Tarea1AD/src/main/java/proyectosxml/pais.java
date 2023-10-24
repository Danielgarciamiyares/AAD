package proyectosxml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="pais")
@XmlType(propOrder = {"id","nombre"})

public class pais implements Serializable
{
	private static final long serialVersionUID=1L;
	/*Variables*/
	private String id;
	private String nombre;
	/*Constructor*/
	public pais() 
	{
		super();
	}
	/*Get y Set*/
	@XmlElement(name="id")
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		this.id = id;
	}
	@XmlElement(name="nombre")
	public String getNombre() 
	{
		return nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}
	
}
