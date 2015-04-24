package domain.basics.profile;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Operador extends Usuario{
	
	@Column(unique=true)
	private String cpf;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
