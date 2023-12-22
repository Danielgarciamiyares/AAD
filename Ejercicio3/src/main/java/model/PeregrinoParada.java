package model;

import jakarta.persistence.*;

@Entity 
@Table (name="peregrinoparada")
public class PeregrinoParada 
{
	/*Variables*/
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPeregrinoParada;
	
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="idPeregrino")
    private Peregrino peregrino;
	

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="idParada")
    private Parada parada;
    
}
