package proyectosxml;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name="paises")

public class paises implements Serializable
{
	private static final long serialVersionUID=1L;
	/*Variables*/
	private ArrayList<pais>paises=new ArrayList<pais>();
	/*Constructor*/
	public paises() 
	{
		super();
	}
	/*Get y Set*/
	@XmlElementWrapper(name="paises")
	@XmlElement(name="pais")
	public ArrayList<pais> getPaises() 
	{
		return paises;
	}
	public void setPaises(ArrayList<pais> paises) 
	{
		this.paises = paises;
	}
	
}
