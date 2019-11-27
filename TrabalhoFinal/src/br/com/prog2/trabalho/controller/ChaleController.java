package br.com.prog2.trabalho.controller;
import java.util.List;
import br.com.prog2.trabalho.negocio.Chale;
import br.com.prog2.trabalho.persistencia.ChaleDAOImp;
public class ChaleController {
	public String inserir(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.inserir(cha);
	}
	
	public String alterar(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.alterar(cha);
	}
	
	public String excluir(Chale cha) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.excluir(cha);
	}
	
	public List<Chale> listarTodos(){
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.listarTodos();
	}
	
	public Chale pesquisarPorCod(String codChale) {
		ChaleDAOImp dao = new ChaleDAOImp();
		return dao.pesquisarPorCod(codChale);
	}
}
