package domain.basics;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import domain.basics.profile.Endereco;

@Entity
public class PontoEstrategico {
	
	@Id @GeneratedValue
	private Long codigo;
	
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	private String telefone;
	
	private String email;
	
	@Column(nullable=false)
	private Integer capacidadeTotalDePreteleiras;
	
	@Column(nullable=false)
	private Integer capacidadeAtualDePrateleiras;
	
	
	
	
	public Integer getCapacidadeTotalDePreteleiras() {
		return capacidadeTotalDePreteleiras;
	}
	public void setCapacidadeTotalDePreteleiras(Integer capacidadeTotalDePreteleiras) {
		this.capacidadeTotalDePreteleiras = capacidadeTotalDePreteleiras;
	}
	public Integer getCapacidadeAtualDePrateleiras() {
		return capacidadeAtualDePrateleiras;
	}
	public void setCapacidadeAtualDePrateleiras(Integer capacidadeAtualDePrateleiras) {
		this.capacidadeAtualDePrateleiras = capacidadeAtualDePrateleiras;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public String getTeleone() {
		return telefone;
	}
	public void setTeleone(String teleone) {
		this.telefone = teleone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

	
	
	
}
