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
	private Integer capacidadePorInventarios;
	
	@Column(nullable=false)
	private Integer capacidadeAtualPorInventarios;
	
	
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
	public Integer getCapacidadePorInventarios() {
		return capacidadePorInventarios;
	}
	public void setCapacidadePorInventarios(Integer capacidadePorInventarios) {
		this.capacidadePorInventarios = capacidadePorInventarios;
	}
	public Integer getCapacidadeAtualPorInventarios() {
		return capacidadeAtualPorInventarios;
	}
	public void setCapacidadeAtualPorInventarios(
			Integer capacidadeAtualPorInventarios) {
		this.capacidadeAtualPorInventarios = capacidadeAtualPorInventarios;
	}

	
	
	
}
