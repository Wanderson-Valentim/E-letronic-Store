package repositorios;

import java.util.ArrayList;

import exceptions.ContaExisteException;
import exceptions.ContaInexistenteException;
import interfacesRepositorios.IContasArrayList;
import store.Conta;

public class ContasArrayList implements IContasArrayList{
    private ArrayList<Conta> contas;
    private int index;

    public ContasArrayList(){
        contas = new ArrayList<Conta>();
        index = 0;
    }

    @Override
    public boolean verificaExistencia(String usuario){
        for(int i=0; i < this.contas.size(); i++){
            String email = this.contas.get(i).getEmail();
            if(email.equals(usuario)){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    @Override
    public void adicionaConta(Conta conta) throws ContaExisteException{
        boolean contaExiste = verificaExistencia(conta.getEmail());

        if(!contaExiste){
            this.contas.add(conta);
        }
        else{
            throw new ContaExisteException();
        }
    }

    @Override
    public void removeConta(Conta conta) throws ContaInexistenteException{
        boolean contaExiste = verificaExistencia(conta.getEmail());

        if(contaExiste){
            this.contas.remove(conta);
        }
        else{
            throw new ContaInexistenteException();
        }
    }

    @Override
    public Conta consultaConta(String usuario) throws ContaInexistenteException{
        boolean contaExiste = verificaExistencia(usuario);

        if(contaExiste){
            return contas.get(this.index);
        }
        else{
            throw new ContaInexistenteException();
        }
    }

    @Override
    public ArrayList<Conta> getContas(){
        return contas;
    }
}
