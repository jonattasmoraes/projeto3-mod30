package main.java.services;

import main.java.dao.IClienteDAO;
import main.java.domain.Cliente;
import main.java.exceptions.DAOException;
import main.java.exceptions.MaisDeUmRegistroException;
import main.java.exceptions.TableException;
import main.java.services.generic.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

	public ClienteService(IClienteDAO clienteDAO) {
		super(clienteDAO);
		// this.clienteDAO = clienteDAO;
	}

	@Override
	public Cliente buscarPorCPF(Long cpf) throws DAOException {
		try {
			return this.dao.consultar(cpf);
		} catch (MaisDeUmRegistroException | TableException e) {
			e.printStackTrace();
		}
		return null;
	}
}
