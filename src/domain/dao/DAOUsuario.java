package domain.dao;

import javax.persistence.EntityManager;

import domain.basics.Usuario;
import domain.dao.generics.DAOGeneric;

public class DAOUsuario extends DAOGeneric<Usuario> implements IDAOUsuario{

	public DAOUsuario(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
