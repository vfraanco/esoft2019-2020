
<<<<<<< HEAD:tp3/src/main/java/pot/model/CompetenciaTecnica.java
package pot.model;
=======
package pt.ipp.isep.dei.esoft.pot.model;
>>>>>>> 700808663fac799cc5f30492eba09e48cb0226ff:src/main/java/pt/ipp/isep/dei/esoft/pot/model/CompetenciaTecnica.java

import java.util.Objects;


public class CompetenciaTecnica
{
    private String m_strId;
    private String m_strDescricaoBreve;
    private String m_strDescricaoDetalhada;
    private AreaAtividade m_oAreaAtividade;
    
    public CompetenciaTecnica(String cod, String dsBreve, String dsDet, AreaAtividade areaAtiv)
    {
        if ( (cod == null) || (dsBreve == null) || (dsDet == null) ||
                (areaAtiv == null) || (cod.isEmpty())|| (dsBreve.isEmpty()) || (dsDet.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");
        
        this.m_strId = cod;
        this.m_strDescricaoBreve = dsBreve;
        this.m_strDescricaoDetalhada = dsDet;
        m_oAreaAtividade = areaAtiv;
    }
    
    public AreaAtividade getArea() {
        return m_oAreaAtividade;
    }
    
    public boolean hasId(String cod)
    {
        return this.m_strId.equalsIgnoreCase(cod);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
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
        CompetenciaTecnica obj = (CompetenciaTecnica) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }
    
    @Override
    public String toString()
    {
        return String.format("%s - %s - %s  - Área Atividade: %s", this.m_strId, this.m_strDescricaoBreve, this.m_strDescricaoDetalhada, this.m_oAreaAtividade.toString());
    }
    
}
