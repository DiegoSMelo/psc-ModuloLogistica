package domain.facade;

import domain.rn.IRNCliente;
import domain.rn.IRNOperador;
import domain.rn.RNCliente;
import domain.rn.RNOperador;

public class Fachada{
	
	public IRNCliente rnCliente;
	public IRNOperador rnOperador;
	
	public Fachada(){
		rnCliente = new RNCliente();
		rnOperador = new RNOperador();
	}
	
	
	
}
