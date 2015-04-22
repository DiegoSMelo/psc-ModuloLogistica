package domain.basics;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import domain.basics.enums.SituacaoUsuario;

@Entity
public class Usuario {
	
	@Id @GeneratedValue
	private Long codigo;
	
	@Column(unique=true, nullable=false)
	private String cpf;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	@Embedded
	private Endereco endereco;
	
	@Column(unique=true, nullable=false)
	private String login;
	
	@Column(nullable=false)
	private String senha;
	
	@Enumerated
	private SituacaoUsuario situacao;
	
	@ManyToOne
	private PontoEstrategico pontoEstrategico;
	
	
	
	
	
	public PontoEstrategico getPontoEstrategico() {
		return pontoEstrategico;
	}
	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		this.pontoEstrategico = pontoEstrategico;
	}
	public SituacaoUsuario getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoUsuario situacao) {
		this.situacao = situacao;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	

}