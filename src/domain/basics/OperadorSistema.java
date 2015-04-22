package domain.basics;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OperadorSistema {
	
	@Id @GeneratedValue
	private Long codigo;
	@Column(unique=true, nullable=false)
	private String matricula;
	@Column(unique=true, nullable=false)
	private String cpf;
	@Column(nullable=false)
	private String nome;
	@Embedded
	private Endereco endereco;
	private String telefone;
	@ManyToOne
	private PontoEstrategico pontoEstrategico;
	
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public PontoEstrategico getPontoEstrategico() {
		return pontoEstrategico;
	}
	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		this.pontoEstrategico = pontoEstrategico;
	}
	
	
	
}
