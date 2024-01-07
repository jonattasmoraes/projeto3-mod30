package test.java.dao;

import java.util.Collection;

import main.java.dao.IProdutoDAO;
import main.java.domain.Produto;
import main.java.exceptions.TipoChaveNaoEncontradaException;

public class ProdutoDaoMock implements IProdutoDAO {

	@Override
	public Boolean cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		return true;
	}

	@Override
	public void excluir(String valor) {
	}

	@Override
	public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {
	}

	@Override
	public Produto consultar(String valor) {
		Produto produto = new Produto();
		produto.setCodigo(valor);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		return null;
	}

}
