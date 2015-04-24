package domain.basics.profile;

import javax.persistence.Column;
import javax.persistence.Entity;

import domain.basics.enums.NivelOperador;

@Entity
public class Operador extends Usuario{
	
	@Column(unique=true)
	private String cpf;
	private NivelOperador nivelOperador;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public NivelOperador getNivelOperador() {
		return nivelOperador;
	}

	public void setNivelOperador(NivelOperador nivelOperador) {
		this.nivelOperador = nivelOperador;
	}
	
	
}
