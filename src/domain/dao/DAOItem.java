package domain.dao;

import javax.persistence.EntityManager;

import domain.basics.Item;
import domain.dao.generics.DAOGeneric;
/**
 * 
 * @author gustavo
 *
 */
public class DAOItem extends DAOGeneric<Item> implements IDAOItem{

	public DAOItem(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
