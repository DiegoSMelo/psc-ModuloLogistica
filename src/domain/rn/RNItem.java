package domain.rn;

import java.util.List;

import domain.basics.Item;
import domain.basics.enums.Situacao;
import domain.dao.IDAOItem;
import domain.dao.factory.DAOFactory;
import domain.exceptions.DAOException;

/**
 * 
 * @author gustavo
 *
 */
public class RNItem {
	private IDAOItem daoItem;

	public RNItem(){
		this.daoItem = DAOFactory.getDaoItem();
	}
	
	
	public void salvar(Item item){
		if (item.getCodigo() == null || this.daoItem.consultarPorId(item.getCodigo()) == null) {
			item.setSituacao(Situacao.ATIVO);
			this.daoItem.inserir(item);
		}else{
			this.daoItem.alterar(item);
		}
	}
	
	public void deletar(Item item){		
		item.setSituacao(Situacao.INATIVO);
		this.daoItem.alterar(item);
	}
	
	public Item consultarPorId(Long codigo){
		return this.daoItem.consultarPorId(codigo);
	}
	
	public List<Item> listarItensPorSituacao(Situacao situacao) throws DAOException{
		return this.daoItem.listarItensPorSituacao(situacao);
	}
	
	public List<Item> listarItensPorSituacao(Situacao situacao, Integer indiceInicial, Integer quantidade) throws DAOException{
		return this.daoItem.listarItensPorSituacao(situacao, indiceInicial, quantidade);
	}
	
	public List<Item> listarTodosItens(){
		return this.daoItem.consultarTodos();
	}
}
