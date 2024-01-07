package main.java.services;

import main.java.domain.Cliente;
import main.java.exceptions.DAOException;
import main.java.services.generic.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {

	Cliente buscarPorCPF(Long cpf) throws DAOException;

}
