package domain.facade;

import java.util.List;

import domain.basics.Item;
import domain.basics.enums.Situacao;
import domain.exceptions.DAOException;
import domain.rn.RNItem;

public class FachadaItem {
	
	public RNItem rnItem;
	
	public FachadaItem(){
		this.rnItem = new RNItem();
	}
	
	public void salvar(Item item){
		rnItem.salvar(item);
	}
	
	public void deletar(Item item){		
		rnItem.deletar(item);
	}
	
	public Item consultarPorId(Long codigo){
		return rnItem.consultarPorId(codigo);
	}
	
	public List<Item> listarItensPorSituacao(Situacao situacao) throws DAOException{
		return rnItem.listarItensPorSituacao(situacao);
	}
	
	public List<Item> listarItensPorSituacao(Situacao situacao, Integer indiceInicial, Integer quantidade) throws DAOException{
		return rnItem.listarItensPorSituacao(situacao, indiceInicial, quantidade);
	}
	
	public List<Item> listarTodosItens(){
		return rnItem.listarTodosItens();
	}
}
