package main.java.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.java.dao.generic.GenericDAO;
import main.java.domain.Cliente;

public class ClienteDAO extends GenericDAO<Cliente, Long> implements IClienteDAO {

	public ClienteDAO() {
		super();
	}

	@Override
	public Class<Cliente> getTipoClasse() {
		return Cliente.class;
	}

	@Override
	public void atualiarDados(Cliente entity, Cliente entityCadastrado) {
		entityCadastrado.setCidade(entity.getCidade());
		entityCadastrado.setCpf(entity.getCpf());
		entityCadastrado.setEnd(entity.getEnd());
		entityCadastrado.setEstado(entity.getEstado());
		entityCadastrado.setNome(entity.getNome());
		entityCadastrado.setNumero(entity.getNumero());
		entityCadastrado.setTel(entity.getTel());
		entityCadastrado.setTipo(entity.getTipo());
	}

	@Override
	protected String getQueryInsercao() {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO TB_CLIENTE ");
		sb.append("(ID, NOME, CPF, TEL, ENDERECO, NUMERO, CIDADE, ESTADO, TIPO) ");
		sb.append("VALUES (nextval('sq_cliente'),?,?,?,?,?,?,?,?)");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryInsercao(PreparedStatement stm, Cliente entity) throws SQLException {
		stm.setString(1, entity.getNome());
		stm.setLong(2, entity.getCpf());
		stm.setLong(3, entity.getTel());
		stm.setString(4, entity.getEnd());
		stm.setLong(5, entity.getNumero());
		stm.setString(6, entity.getCidade());
		stm.setString(7, entity.getEstado());
		stm.setString(8, entity.getTipo());
	}

	@Override
	protected String getQueryExclusao() {
		return "DELETE FROM TB_CLIENTE WHERE CPF = ?";
	}

	@Override
	protected void setParametrosQueryExclusao(PreparedStatement stmExclusao, Long valor) throws SQLException {
		stmExclusao.setLong(1, valor);
	}

	@Override
	protected String getQueryAtualizacao() {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE TB_CLIENTE ");
		sb.append("SET NOME = ?,");
		sb.append("TEL = ?,");
		sb.append("ENDERECO = ?,");
		sb.append("NUMERO = ?,");
		sb.append("CIDADE = ?,");
		sb.append("ESTADO = ?,");
		sb.append("TIPO = ?");
		sb.append(" WHERE CPF = ?");
		return sb.toString();
	}

	@Override
	protected void setParametrosQueryAtualizacao(PreparedStatement stmUpdate, Cliente entity) throws SQLException {
		stmUpdate.setString(1, entity.getNome());
		stmUpdate.setLong(2, entity.getTel());
		stmUpdate.setString(3, entity.getEnd());
		stmUpdate.setLong(4, entity.getNumero());
		stmUpdate.setString(5, entity.getCidade());
		stmUpdate.setString(6, entity.getEstado());
		stmUpdate.setString(7, entity.getTipo());
		stmUpdate.setLong(7, entity.getCpf());
	}

	@Override
	protected void setParametrosQuerySelect(PreparedStatement stmSelect, Long valor) throws SQLException {
		stmSelect.setLong(1, valor);
	}

}
