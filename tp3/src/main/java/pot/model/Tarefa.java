package pot.model;

import java.util.Objects;

public class Tarefa {

    private static String ref;
    private String desig;
    private String descInf;
    private String descTec;
    private double duracao;
    private double custo;

    public Tarefa(String ref, String desig, String descInf, String descTec, double duracao, double custo){
        if ( (ref == null) || (desig == null) || (descInf == null) || (duracao == 0) || (custo == 0) ||
                (ref.isEmpty())|| (desig.isEmpty()) || (descInf.isEmpty()) || (descTec.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.ref = ref;
        this.desig = desig;
        this.descInf = descInf;
        this.descTec = descTec;
        this.duracao = duracao;
        this.custo = custo;
    }

    public static String getCod() {
        return ref;
    }
    
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Tarefa trf = (Tarefa)o;
        return (Objects.equals(ref, trf.ref));
    }

    @Override
    public String toString()
    {
        return String.format("%s - %s - %s -%s - %1$,.2f - %1$,.2f - %s", this.ref, this.desig, this.descInf,
                this.descTec, this.duracao, this.custo);
    }
}
