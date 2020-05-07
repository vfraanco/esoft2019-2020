/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ipp.isep.dei.esoft.pot.ui.console;

import pt.ipp.isep.dei.esoft.pot.controller.RegistarOrganizacaoController;
import pt.ipp.isep.dei.esoft.pot.ui.console.utils.Utils;

/**
 *
 * @author lol
 */
public class RegistarOrganizacaoUI
{
    private RegistarOrganizacaoController m_controller;
    public RegistarOrganizacaoUI()
    {
        m_controller = new RegistarOrganizacaoController();
    }

    public void run()
    {
        System.out.println("\nRegistar Organizacao:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (m_controller.registaOrganizacao()) {
                    System.out.println("Registo efetuado com sucesso.");
                } else {
                    System.out.println("Não foi possivel concluir o registo com sucesso.");
                }
            }
        }
        else
        {
            System.out.println("Ocorreu um erro. Operação cancelada.");
        }
    }
    
    private boolean introduzDados() {
        String strNome = Utils.readLineFromConsole("Nome da Organização: ");
        String strNIF = Utils.readLineFromConsole("NIF: ");
        String strWebsite = Utils.readLineFromConsole("Website: ");
        String strTelefone = Utils.readLineFromConsole("Telefone: ");
        String strEmail = Utils.readLineFromConsole("EMail: ");
        System.out.println("\nEndereço Postal:");
        String strLocal = Utils.readLineFromConsole("Rua/Av.: ");
        String strCodPostal = Utils.readLineFromConsole("Cod. Postal: ");
        String strLocalidade = Utils.readLineFromConsole("Localidade: ");
        System.out.println("\nInformação do Gestor (i.e. de quem procede ao registo):");  
        String strNomeGestor = Utils.readLineFromConsole("Nome da Gestor: ");
        String strFuncao = Utils.readLineFromConsole("Função Desempenhada: ");
        String strTelefoneGestor = Utils.readLineFromConsole("Telefone: ");
        String strEmailGestor = Utils.readLineFromConsole("EMail: ");
        String strPwd = Utils.readLineFromConsole("Palavra-Passe: ");
        
        return m_controller.novaOrganizacao(strNome, strNIF, strWebsite, strTelefone, strEmail,
                strLocal, strCodPostal, strLocalidade, strNomeGestor, strFuncao, 
                strEmailGestor, strTelefoneGestor, strPwd);
    }
    
    private void apresentaDados() 
    {
        System.out.println("\n Informação a Registar:\n" + m_controller.getOrganizacaoString());
    }
}
