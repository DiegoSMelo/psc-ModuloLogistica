package domain.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.primefaces.context.RequestContext;

import domain.basics.PontoEstrategico;
import domain.basics.enums.NivelOperador;
import domain.basics.enums.Situacao;
import domain.basics.enums.UF;
import domain.basics.profile.Endereco;
import domain.basics.profile.Operador;
import domain.exceptions.DAOException;
import domain.facade.Fachada;
import domain.util.Mensagens;



@ManagedBean
public class BeanPontoEstrategico {
	private PontoEstrategico novoPontoEstrategico;
	private List<PontoEstrategico> listaPontoEstrategicos;
	private Fachada fachada;
	
	public List<PontoEstrategico> getListaPontoEstrategicos() {
		return listaPontoEstrategicos;
	}

	public void setListaPontoEstrategicos(List<PontoEstrategico> listaPontoEstrategicos) {
		this.listaPontoEstrategicos = listaPontoEstrategicos;
	}


	public PontoEstrategico getPontoEstrategico() {
		if (this.novoPontoEstrategico.getEndereco() == null) {
			this.novoPontoEstrategico.setEndereco(new Endereco());
		}
		return novoPontoEstrategico;
	}

	public void setPontoEstrategico(PontoEstrategico pontoEstrategico) {
		if (this.novoPontoEstrategico.getEndereco() == null) {
			this.novoPontoEstrategico.setEndereco(new Endereco());
		}
		this.novoPontoEstrategico = pontoEstrategico;
	}
	
	public BeanPontoEstrategico(){
		this.novoPontoEstrategico = new PontoEstrategico();
		this.fachada = new Fachada();
		try {
			this.listaPontoEstrategicos = fachada.rnPontoEstrategico.listarPontosEstrategicosPorSituacao(Situacao.ATIVO);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public String salvarPontoEstrategico(){
		try {
			
			this.fachada.rnPontoEstrategico.salvar(getPontoEstrategico());
		} catch (DAOException e) {
			RequestContext.getCurrentInstance().execute("alert('" + Mensagens.m3 + "');");
		}
		return "/psc-ModuloLogistica/pontoEstrategico/index.xhtml?faces-redirect=true";
	}

	public void deletarPontoEstrategico(){
		this.fachada.rnPontoEstrategico.deletar(getPontoEstrategico());
	}
	
	public PontoEstrategico buscarPontoEstrategicoPorCNPJ(String cnpj) throws DAOException {
		return this.fachada.rnPontoEstrategico.buscarPontoEstrategicoPorCNPJ(cnpj);
	}

	public List<PontoEstrategico> listarPontosEstrategicosPorSituacao(Situacao situacao) throws DAOException {
		return this.fachada.rnPontoEstrategico.listarPontosEstrategicosPorSituacao(situacao);
	}
 
}
