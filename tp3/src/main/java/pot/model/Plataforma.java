
package pot.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import autorizacao.AutorizacaoFacade;
import autorizacao.model.RegistoAnuncios;
import autorizacao.model.RegistoOrganizacoes;

/**
 *
 * @author Paulo Maio <pam@isep.ipp.pt>
 */
public class Plataforma {

    private String designacao;
    private final AutorizacaoFacade m_oAutorizacao;
    private final Set<Organizacao> m_lstOrganizacoes;
    private final Set<CompetenciaTecnica> m_lstCompetencias;
    private RegistoOrganizacoes registoOrganizacoes;
    private RegistoAnuncios registoAnuncios;


    public Plataforma(String strDesignacao) {
        if ((strDesignacao == null)
                || (strDesignacao.isEmpty())) {
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        }

        this.designacao = strDesignacao;

        this.m_oAutorizacao = new AutorizacaoFacade();

        this.m_lstOrganizacoes = new HashSet<>();
        this.m_lstCompetencias = new HashSet<>();
    }

    public RegistoOrganizacoes getRegistoOrganizacoes(){
        return registoOrganizacoes;
    }

    public RegistoAnuncios getRegistoAnuncios(){
        return registoAnuncios;
    }

    /**
    public AutorizacaoFacade getAutorizacaoFacade() {
        return this.m_oAutorizacao;
    }


     * public CompetenciaTecnica getCompetenciaTecnicaById(String cod) {
    
        for(CompetenciaTecnica compTec : this.m_lstCompetencias)
        {
            if (compTec.hasId(cod))
            {
                return compTec;
            }
        }
        return null;
    }

    public AreaAtividade getAreaById(String AreaID) {
        for (AreaAtividade oAreaAtiv : this.m_lstAreasAtividade) {
            if (oAreaAtiv.hasId(AreaID)) {
                return oAreaAtiv;
            }
        }
        return null;
    }
    

    public boolean validaCompetenciaTecnica(CompetenciaTecnica compTec)
    {
        boolean bRet = true;
        
        if (m_lstAreasAtividade.contains(compTec.getArea()) == false) {
            bRet = false;
        }
        return bRet;
    }
    
    public List<CompetenciaTecnica> getCompetenciasTecnicas() {
        List<CompetenciaTecnica> lc = new ArrayList<>();
        lc.addAll(this.m_lstCompetencias);
        return lc;
    }

    //Tarefa
    // <editor-fold defaultstate="collapsed">
    public List<CategoriaTarefa> getCategoria() {
        List<CategoriaTarefa> listaCat = new ArrayList<>();
        listaCat.addAll(this.m_lstCategorias);
        return listaCat;
    }

    public CategoriaTarefa getCategoriaTarefaById(String catId) {
        for (CategoriaTarefa oCategoria : this.m_lstCategorias) {
            if (oCategoria.hasId(catId)){
                return oCategoria;
            }
        }

        return null;
    }

    public Organizacao getOrganizacaoByEmailUtilizador(String emailUtlz) {
        return null;
    }   

    
    public boolean registerCategoriaTarefa(CategoriaTarefa categoria){
        if(validateCategoriaTarefa(categoria) == true){
            return (addCategoriaTarefa(categoria));
        }
        return false;
    }
    
    public boolean validateCategoriaTarefa(CategoriaTarefa categoria){
        boolean bRet = true;
        if (m_lstAreasAtividade.contains(categoria.getArea()) == false) {
            bRet = false;
        }
        return bRet;
    }
    
    private boolean addCategoriaTarefa(CategoriaTarefa categoria){
        return m_lstCategorias.add(categoria);
    }

     **/


}
