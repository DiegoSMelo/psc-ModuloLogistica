package domain.facade;

import domain.rn.RNCliente;
import domain.rn.RNOperador;

public class Fachada{
	
	public RNCliente rnCliente;
	public RNOperador rnOperador;
	
	public Fachada(){
		rnCliente = new RNCliente();
		rnOperador = new RNOperador();
	}
	
	
	
}
