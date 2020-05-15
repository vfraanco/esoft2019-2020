/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author lol
 */
public class EspecificarAreaAtividadeController
{
    private Plataforma m_oPlataforma;
    private AreaAtividade m_oAreaAtividade;
    public EspecificarAreaAtividadeController()
    {
        if(!AplicacaoPOT.getInstance().getSessaoAtual().isLoggedInComPapel(Constantes.PAPEL_ADMINISTRATIVO))
            throw new IllegalStateException("Utilizador não Autorizado");
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
    }
    
    
    public boolean novaAreaAtividade(String strCodigo, String strDescricaoBreve, String strDescricaoDetalhada)
    {
        try
        {
            this.m_oAreaAtividade = this.m_oPlataforma.novaAreaAtividade(strCodigo, strDescricaoBreve,strDescricaoDetalhada);
            return this.m_oPlataforma.validaAreaAtividade(this.m_oAreaAtividade);
        }
        catch(RuntimeException ex)
        {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            this.m_oAreaAtividade = null;
            return false;
        }
    }
   
    
    public boolean registaAreaAtividade()
    {
        return this.m_oPlataforma.registaAreaAtividade(this.m_oAreaAtividade);
    }

    public String getAreaAtividadeString()
    {
        return this.m_oAreaAtividade.toString();
    }
}
