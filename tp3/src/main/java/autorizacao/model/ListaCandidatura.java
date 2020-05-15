package autorizacao.model;

import pot.model.Candidatura;

import java.util.ArrayList;
import java.util.List;

public class ListaCandidatura {

    private Candidatura candidatura;
    List<Candidatura> listaCandidaturas = new ArrayList<Candidatura>();

    public List<Candidatura> getListaCandidaturas() {
        return listaCandidaturas;
    }

    public boolean add(Candidatura c) {
        listaCandidaturas.add(c);
        return true;
    }
    public Candidatura get(int index) {
        return listaCandidaturas.get(index);
    }

    public Candidatura getCandidaturaByID(String candidaturaId){
        for (Candidatura candidatura : listaCandidaturas){
            if (candidatura.hasId(candidaturaId)) {
                return candidatura;
            }
        }
        return null;
    }
    
    public boolean validaCandidatura(Candidatura candidatura){
        if(candidatura==null){
            return false;
        }
        return true;
    }
    
    public boolean addCandidatura(Candidatura candidatura){
        return this.listaCandidaturas.add(candidatura);
    }

}
