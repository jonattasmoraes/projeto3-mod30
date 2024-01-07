package main.java.dao.generic;

import java.util.HashMap;
import java.util.Map;

public class SingletonMap {

    private static SingletonMap instance;

    /**
     * Contém todos os registros da aplicação.
     * Simula o banco de dados
     */
    private Map<Class<?>, Map<?, ?>> map;

    private SingletonMap() {
        map = new HashMap<>();
    }

    /**
     * Método que garante o retorno de apenas uma instância desse objeto
     *
     * @return SingletonMap
     */
    public static synchronized SingletonMap getInstance() {
        if (instance == null) {
            instance = new SingletonMap();
        }
        return instance;
    }

    public Map<Class<?>, Map<?, ?>> getMap() {
        return this.map;
    }
}
