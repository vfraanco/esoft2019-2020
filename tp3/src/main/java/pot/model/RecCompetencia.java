package pot.model;

public class RecCompetencia {

    private CompetenciaTecnica competencia;
    private String data;
    private String grau_prof;
    
    public RecCompetencia(CompetenciaTecnica comptec, String data, String grau_prof){
        this.competencia = comptec;
        this.data = data;
        this.grau_prof = grau_prof;
    }
}
