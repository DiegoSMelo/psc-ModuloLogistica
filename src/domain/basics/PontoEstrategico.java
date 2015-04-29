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
	private Integer capacidadePorPreteleira;
	
	@Column(nullable=false)
	private Integer capacidadeAtualPorPrateleira;
	
	
	
	
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
	public Integer getCapacidadePorPreteleira() {
		return capacidadePorPreteleira;
	}
	public void setCapacidadePorPreteleira(Integer capacidadePorPreteleira) {
		this.capacidadePorPreteleira = capacidadePorPreteleira;
	}
	public Integer getCapacidadeAtualPorPrateleira() {
		return capacidadeAtualPorPrateleira;
	}
	public void setCapacidadeAtualPorPrateleira(Integer capacidadeAtualPorPrateleira) {
		this.capacidadeAtualPorPrateleira = capacidadeAtualPorPrateleira;
	}
	

	
	
	
}
