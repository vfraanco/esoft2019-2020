package pot.model;

public class CompObrig {

    private boolean m_isObrig;
    private CompetenciaTecnica m_comp;

    public CompObrig(CompetenciaTecnica comp, boolean isObrig) {
        this.m_isObrig = isObrig;
        this.m_comp = comp;
    }
}
