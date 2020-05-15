package pot.model;

import autorizacao.model.ListaClassificacoes;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;

//Falta um método para obter listaClassificacoes
public class Seriacao {

    private Date data;
    private Time hora;
    private List<Classificacao> listaResultado;
    private List<Colaborador> listaParticipantes;

    public Seriacao (Date data, Time hora, List<Classificacao> listaResultado, List<Colaborador> listaParticipantes){
        if ( ( data == null) || (hora == null) || ( listaResultado == null) || (listaParticipantes == null))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.data = data;
        this.hora = hora;
        this.listaResultado = getListaResultado();
        this.listaParticipantes = listaParticipantes;
    }

    public List<Classificacao> getListaResultado() {
        ListaClassificacoes lst = new ListaClassificacoes();
        return listaResultado = lst.ordenaClassificacoes();
    }

    public boolean add(Colaborador colaborador){
        return this.listaParticipantes.add(colaborador);
    }

    @Override
    public boolean equals(Object o) {
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
        Seriacao seriacao = (Seriacao) o;
        return Objects.equals(listaResultado, seriacao.listaResultado) &&
                Objects.equals(listaParticipantes, seriacao.listaParticipantes);
    }

    @Override
    public String toString() {
        return "Seriacao{" +
                "data=" + data +
                ", hora=" + hora +
                ", listaResultado=" + listaResultado +
                ", listaParticipantes=" + listaParticipantes +
                '}';
    }
}
