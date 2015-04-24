package domain.dao.generics;
 
import java.util.List;
 
public interface IDAOGeneric<Entidade> {
 
    public void inserir(Entidade entidade);
     
    public void alterar(Entidade entidade);
     
    public void remover(Entidade entidade);
     
    public Entidade consultarPorId(Integer id);
     
    public List<Entidade> consultarTodos();
     
    public List<Entidade> consultarTodos(Integer indiceInicial,   Integer quantidade);
     
 
}