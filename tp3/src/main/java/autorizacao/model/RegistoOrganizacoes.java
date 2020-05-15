package autorizacao.model;

import autorizacao.AutorizacaoFacade;
import pot.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegistoOrganizacoes {

    private final AutorizacaoFacade m_oAutorizacao = new AutorizacaoFacade();;
    private final Set<Organizacao> listaOrganizacoes = new HashSet<>();

    public Organizacao novaOrganizacao(String strNome, String strNIF, String strWebsite, String strTelefone, String strEmail, Colaborador oGestor) {
        return new Organizacao(strNome, strNIF, strWebsite, strTelefone, strEmail, oGestor);
    }

    public Organizacao getOrganizacaoByEmailUtilizador(String emailUtil){
        Organizacao orgReturn = null;
        for (Organizacao o : listaOrganizacoes){
            ListaColaboradores lista = o.getListaColaboradores();
            if (lista.tensColaboradorComEmail(emailUtil)){
                orgReturn = o;
            }
        }
        return orgReturn;
    }

    /**
    public boolean registaOrganizacao(Organizacao oOrganizacao, String strPwd) {
        if (this.validaOrganizacao(oOrganizacao, strPwd)) {
            Colaborador oGestor = oOrganizacao.getGestor();
            String strNomeGestor = oGestor.getNome();
            String strEmailGestor = oGestor.getEmail();
            if (this.m_oAutorizacao.registaUtilizadorComPapeis(strNomeGestor, strEmailGestor, strPwd,
                    new String[]{Constantes.PAPEL_GESTOR_ORGANIZACAO, Constantes.PAPEL_COLABORADOR_ORGANIZACAO})) {
                return addOrganizacao(oOrganizacao);
            }
        }
        return false;
    }

    private boolean addOrganizacao(Organizacao oOrganizacao) {
        return listaOrganizacoes.add(oOrganizacao);
    }

    private Organizacao getOrganizacaoByEmail(String emailUtllz) {
        for (Organizacao org : listaOrganizacoes) {
            if (org.getEmail().compareTo(emailUtllz) == 0) {
                return org;
            }
        }
        return null;
    }

    public boolean validaOrganizacao(Organizacao oOrganizacao, String strPwd) {
        boolean bRet = true;

        if (this.m_oAutorizacao.existeUtilizador(oOrganizacao.getGestor().getEmail())) {
            bRet = false;
        }
        if (strPwd == null) {
            bRet = false;
        }
        if (strPwd.isEmpty()) {
            bRet = false;
        }
        if(getListaOrganizacoes().contains(oOrganizacao.getM_strNIF())){
            bRet = false;
        }
        if (getListaOrganizacoes().contains(oOrganizacao.getEmail())){
            bRet = false;
        }

        return true;
    }

    //SeriarAnuncio
    public List<Organizacao> getListaOrganizacoes() {
        return new ArrayList<>(this.listaOrganizacoes);
    }

    public Organizacao get(int index) {
        return getListaOrganizacoes().get(index);
    }


   public boolean registaGestorComoUtilizador(Colaborador colab){
        return true;
   } **/
}
