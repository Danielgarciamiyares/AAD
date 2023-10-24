package proyectosxml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LecturaJAXB 
{

    public static void main(String[] argsd) {
    	paises ret = null;
    	try {
    		File fichero=new File("");
			JAXBContext contexto = JAXBContext.newInstance(paises.class);
			Unmarshaller u = contexto.createUnmarshaller();
			ret = (paises) u.unmarshal(fichero) ;
			
		} catch (JAXBException e) {
			System.out.println("Se ha producido una JAXBException: "+ e.getMessage());
			e.printStackTrace();
			ret = null;
		}
    	
    }
	
}
