package repositorios;

import java.util.ArrayList;

import exceptions.ContaExisteException;
import exceptions.ContaInexistenteException;
import store.Conta;

public class ContasArrayList {
    private ArrayList<Conta> contas;
    private int index;

    private boolean verificaExistencia(String usuario){
        for(int i=0; i < this.contas.size(); i++){
            String email = this.contas.get(i).getEmail();
            if(email.equals(usuario)){
                this.index = i;
                return true;
            }
        }
        return false;
    }

    public void adicionaConta(Conta conta) throws ContaExisteException{
        boolean contaExiste = verificaExistencia(conta.getEmail());

        if(!contaExiste){
            this.contas.add(conta);
        }
        else{
            throw new ContaExisteException();
        }
    }

    public void removeConta(Conta conta) throws ContaInexistenteException{
        boolean contaExiste = verificaExistencia(conta.getEmail());

        if(contaExiste){
            this.contas.remove(conta);
        }
        else{
            throw new ContaInexistenteException();
        }
    }

    public void atualizaConta(Conta conta) throws ContaInexistenteException{
        boolean contaExiste = verificaExistencia(conta.getEmail());

        if(contaExiste){

        }
        else{
            throw new ContaInexistenteException();
        }
    }

    Conta consultaConta(String usuario) throws ContaInexistenteException{
        boolean contaExiste = verificaExistencia(usuario);

        if(contaExiste){
            return contas.get(this.index);
        }
        else{
            throw new ContaInexistenteException();
        }
    }

    public ArrayList<Conta> getContas(){
        return contas;
    }
}
