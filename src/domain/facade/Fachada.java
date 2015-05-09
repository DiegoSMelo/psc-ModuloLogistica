package domain.facade;

import domain.rn.RNCliente;
import domain.rn.RNOperador;
import domain.rn.RNPontoEstrategico;

public class Fachada{
	
	public RNCliente rnCliente;
	public RNOperador rnOperador;
	public RNPontoEstrategico rnPontoEstrategico;
	
	public Fachada(){
		rnCliente = new RNCliente();
		rnOperador = new RNOperador();
		rnPontoEstrategico = new RNPontoEstrategico();
	}
	
	
	
}
