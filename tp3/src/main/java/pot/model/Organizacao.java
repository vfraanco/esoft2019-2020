
package pot.model;

import autorizacao.model.ListaColaboradores;
import autorizacao.model.ListaTarefa;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author paulomaio
 */
public class Organizacao
{
    private String m_strNome;
    private String m_strNIF;
    private String m_strWebsite;
    private String m_strTelefone;
    private String m_strEmail;
    private Colaborador m_oGestor;
    private Set<Colaborador> m_lstColaboradores = new HashSet<Colaborador>();
    private List<Tarefa> m_lstTarefas;
    private ListaColaboradores listaColaboradores;
            
    
    public Organizacao(String strNome, String strNIF, String strWebsite, String strTelefone, 
            String strEmail, Colaborador oColaborador)
    {
        if ( (strNome == null) || (strNIF == null) || (strTelefone == null) ||
                (strEmail == null) || (oColaborador == null) ||
                (strNome.isEmpty())|| (strNIF.isEmpty()) || (strTelefone.isEmpty()) || 
                (strEmail.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strNome = strNome;
        this.m_strNIF = strNIF;
        this.m_strWebsite = strWebsite;
        this.m_strTelefone = strTelefone;
        this.m_strEmail = strEmail;
        this.m_oGestor = oColaborador;
        this.m_lstColaboradores.add(oColaborador);
       
    }
    
    public Colaborador getGestor() {
        return this.m_oGestor;
    }
   
    public String getEmail() {
        return m_strEmail;
    }

    public String getM_strNIF() {
        return m_strNIF;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strNIF);
        return hash;
    }
    
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/
        
        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Organizacao obj = (Organizacao) o;
        return (Objects.equals(m_strNIF, obj.m_strNIF));
    }
    
    @Override
    public String toString() {
        String str = String.format("%s - %s - %s - %s - %s - %s - %s", this.m_strNome, this.m_strNIF, this.m_strWebsite, this.m_strTelefone, this.m_strEmail, this.m_oGestor.toString());
        return str;
    }

    //RegistarOrganizacao
    public ListaColaboradores novaListaColaboradores() {
        return new ListaColaboradores();
    }
    
    public static Colaborador novoColaborador(String strNome, String strFuncao, String strTelefone, String strEmail) {
        return new Colaborador(strNome,strFuncao,strTelefone,strEmail);
    }


    //Tarefa

    // <editor-fold defaultstate="collapsed">

    public static Tarefa novaTarefa(String ref, String desig, String descInf, String descTec, double duracao, double custo) {
        return new Tarefa(ref, desig, descInf, descTec, duracao, custo);
    }

    public boolean validaTarefa(Tarefa oTarefa) {
        if(oTarefa==null){
            return false;
        }
        for (Tarefa trf: m_lstTarefas){
            if(trf.equals(oTarefa)){
                return false;
            }
        }
        return true;
    }
    
    public Tarefa getListaTarefa() {
        return ListaTarefa.getTarefaByCod(Tarefa.getCod());
    }
    
    public boolean registaTarefa(Tarefa oTarefa) {
        if (validaTarefa(oTarefa)){
            return addTarefa(oTarefa);
        }
        return false;
    }

    private boolean addTarefa(Tarefa oTarefa) {
        return m_lstTarefas.add(oTarefa);
    }
    
    
    public boolean validaColaborador(Colaborador colab){
        if(colab==null){
            return false;
        }
        return true;
    }
    
    public boolean addColaborador(Colaborador oColaborador){
        return this.m_lstColaboradores.add(oColaborador);
    }
    
    public boolean registaColaborador(Colaborador oColaborador){
        if(validaColaborador(oColaborador)){
            this.addColaborador(oColaborador);
        }
        return false;
    }

    //SeriarAnuncio
    // <editor-fold defaultstate="collapsed">
    public ListaColaboradores getListaColaboradores(){
        return listaColaboradores;
    }

    public boolean tensColaboradorComEmail(String emailUtil){
        if(getListaColaboradores().getListaColaboradores().contains(emailUtil)){
            return true;
        }
        return false;
    }
}
