package pot.controller;

import autorizacao.model.*;
import pot.model.*;
import pot.ui.console.utils.Utils;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SeriarAnuncioController {

    private Plataforma plataforma;
    private Organizacao organizacao;
    private Seriacao seriacao;
    private Anuncio anuncio;
    private RegistoAnuncios registoAnuncios;
    private Candidatura candidatura;
    private ListaCandidatura listaCandidatura;
    private Classificacao classificacao;
    private ListaClassificacoes listaClassificacoes;
    private ListaColaboradores listaColaboradores;


    public SeriarAnuncioController() {

        registoAnuncios = plataforma.getRegistoAnuncios();
        listaCandidatura =  candidatura.getListaCandidatura();
        listaClassificacoes = classificacao.getListaClassificacoes();
        listaColaboradores = organizacao.getListaColaboradores();
    }

    public Organizacao getInstance(){
        try{
            AplicacaoPOT app = AplicacaoPOT.getInstance();
            SessaoUtilizador utlz = app.getSessaoAtual();
            String emailUtlz = utlz.getEmailUtilizador();
            RegistoOrganizacoes registoOrganizacoes = plataforma.getRegistoOrganizacoes();
            return this.organizacao = registoOrganizacoes.getOrganizacaoByEmailUtilizador(emailUtlz);
        }catch(Exception e){
            System.out.println("Organização não encontrada");
        }
        return null;
    }

    public boolean novaSeriacao(Date data, Time hora, List<Classificacao> listaResultado, List<Colaborador> listaParticipantes){
        try
        {
           this.seriacao = this.anuncio.novaSeriacaoAnuncio(data, hora, listaResultado, listaParticipantes);
           return this.anuncio.validaSeriacao(this.seriacao);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.seriacao = null;
            return false;
        }
    }

    public List<Anuncio> getRegistoAnuncios(){
        return plataforma.getRegistoAnuncios().getRegistoAnuncio();
    }

    public Anuncio getAnuncioByID(String anuncioId){
        for (Anuncio anc : plataforma.getRegistoAnuncios().getRegistoAnuncio()){
            if (anc.hasId(anuncioId)){
                return anc;
            }
        }
        return null;
    }

    public List<Candidatura> getListaCandidatura(){
        return candidatura.getListaCandidatura().getListaCandidaturas();
    }

    public Candidatura getCandidaturaByID(String candidaturaId){
        for (Candidatura cnd : candidatura.getListaCandidatura().getListaCandidaturas()){
            if (cnd.hasId(candidaturaId)){
                return cnd;
            }
        }
        return null;
    }

    public boolean novaClassificacao(int resultado, Candidatura candidatura){
        try
        {
            this.classificacao = this.listaClassificacoes.novaClassificacao(resultado, candidatura);
            return this.listaClassificacoes.validaClassificacao(this.classificacao);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.classificacao = null;
            return false;
        }
    }
    public List<Classificacao> getListaResultado(){
        return classificacao.getListaClassificacoes().ordenaClassificacoes();
    }

    public List<Colaborador> getColaboradores(){
        return organizacao.getListaColaboradores().getListaColaboradores();
    }


    public String getSeriacaoString() {
        return this.seriacao.toString();
    }

    public Anuncio getAnunciosPorSeriarAutomaticos(){

    }


    public boolean addParticipante(){


    }


    public boolean registaProcessoSeriacao(){
        return this.anuncio.registaSeriacao(this.seriacao);
    }
}
