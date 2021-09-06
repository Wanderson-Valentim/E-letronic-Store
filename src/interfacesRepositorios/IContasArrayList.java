package interfacesRepositorios;

import store.Conta;
import java.util.ArrayList;
import exceptions.ContaExisteException;
import exceptions.ContaInexistenteException;

public interface IContasArrayList {
     boolean verificaExistencia(String usuario);
     void adicionaConta(Conta conta)  throws ContaExisteException;
     void removeConta(Conta conta)  throws ContaInexistenteException;
     Conta consultaConta(String usuario)  throws ContaInexistenteException;
     ArrayList<Conta> getContas();
}
