package domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import domain.basics.enums.NivelOperador;
import domain.basics.profile.Operador;
import domain.dao.generics.DAOGeneric;
import domain.exceptions.DAOException;

public class DAOOperador extends DAOGeneric<Operador> implements IDAOOperador{

	public DAOOperador(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Operador buscaOperadorPorLoginSenhaNivel(String login, String senha, NivelOperador nivel) throws DAOException {
		try {
			TypedQuery<Operador> result = entityManager.createQuery("SELECT o FROM Operador o WHERE o.login = :login AND o.senha = :senha AND o.nivelOperador = :nivel", Operador.class);
			result.setParameter("login", login);
			result.setParameter("senha", senha);
			result.setParameter("nivel", nivel);
			
			Operador operador = result.getSingleResult();
			
			return operador;
		} catch (Exception e) {
			throw new DAOException("Falha ao consultar Usuário.");
		}
	}
	
	

}
