package pot.model;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import autorizacao.model.ListaCandidatura;

public class Anuncio {

    private int periodoPub;
    private int periodoCand;
    private int periodoSer;
    private Tarefa tarefa;
    private Seriacao seriacao;
    private List<Seriacao> listaSeriacao;
    private String anuncioId;
    private static int contadorAnuncio = 0;
    private List<Anuncio> listaAnunciosElegiveis;
    private ListaCandidatura listaCandidatura;

    int perPub, perApr, perSer;
    String tipoReg;
        
        public Anuncio(int perPub, int perApr, int perSer, String tipoReg) {
            if ( (perPub == 0) || (perApr == 0) || (perSer == 0) ||
                        (tipoReg == null) || (tipoReg.isEmpty()))
                    throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

                this.perPub = perPub;
                this.perApr = perApr;
                this.perSer = perSer;
                this.tipoReg = tipoReg;
                contadorAnuncio++;
                this.anuncioId = String.valueOf(contadorAnuncio);
        }

    //SeriarAnuncio
    // <editor-fold defaultstate="collapsed">
    public Seriacao novaSeriacaoAnuncio (Date data, Time
        hora, List<Classificacao> listaResultado, List < Colaborador > listaParticipantes){
            return new Seriacao(data, hora, listaResultado, listaParticipantes);
        }

        public boolean validaSeriacao (Seriacao seriacao){
            if (seriacao == null) {
                return false;
            }
            for (Seriacao src : listaSeriacao) {
                if (src.equals(seriacao)) {
                    return false;
                }
            }
            return true;
        }

        public boolean registaSeriacao (Seriacao seriacao){
            if (validaSeriacao(seriacao)) {
                return addSeriacao(seriacao);
            }
            return false;
        }

    public String getAnuncioId() {
            return anuncioId;
    }

    public boolean hasId(String ancId) {
            return this.anuncioId.equalsIgnoreCase(ancId);
    }

    private boolean addSeriacao (Seriacao seriacao){
            return listaSeriacao.add(seriacao);
        }
    // </editor-fold>

    public boolean addAnuncio(Anuncio anuncioElegivel){
            return this.listaAnunciosElegiveis.add(anuncioElegivel);
    }
    
    public Anuncio getAnuncio(){
            return null;
    }
    
    public Anuncio selectAnuncio(){
            return null;
    }
}
