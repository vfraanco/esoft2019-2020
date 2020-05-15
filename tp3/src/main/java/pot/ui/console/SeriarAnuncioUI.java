package pt.ipp.isep.dei.esoft.pot.ui.console;

import pot.controller.SeriarAnuncioController;
import pot.model.*;
import pot.ui.console.utils.Utils;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class SeriarAnuncioUI {

    private Organizacao organizacao;
    private SeriarAnuncioController seriacaoController;

    public void run()
    {
        System.out.println("\nSeriar Anuncio:");

        if(introduzDados())
        {
            apresentaDados();

            if (Utils.confirma("Confirma os dados introduzidos? (S/N)")) {
                if (seriacaoController.registaSeriacao()) {
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
     Date data = Utils.readDateFromConsole("Data(dd-MM-yyyy):");
     Time tempo = Utils.readTimeFromConsole("Horas(HH:MM):");
     int contColab = 0;
     int contador = 0;

     List<Colaborador> listaColaboradores = seriacaoController.getListaColaboradores();
     while (Utils.confirma("Deseja selecionar outros participantes? S/N") && contColab < listaColaboradores.size()){
         String colaboradorId = "";
         Colaborador colab = (Colaborador) Utils.apresentaESeleciona(listaColaboradores, "Selecione o colaborador:");
         if (colab != null){
             colaboradorId = colab.getColabooradorId();
         }
         contColab++;

     }

     List<Candidatura> listaCandidatura = seriacaoController.getListaCandidatura();
     List<Classificacao> listaResultado = seriacaoController.getListaResultado();
     while (contador < listaCandidatura.size()) {
         String candidaturaId = "";
         Candidatura cand = (Candidatura) Utils.apresentaESeleciona(listaCandidatura, "Selecione a candidatura a classificar:");
         if (cand != null) {
             candidaturaId = cand.getCandidaturaId();
         }
         contador++;
         int resultado = (int) Utils.readIntegerFromConsole("Insira a classificação da candidatura selecionada:");
         Classificacao classificacao = new Classificacao(resultado, cand);
         listaResultado.add(classificacao);
     }
        return seriacaoController.novaSeriacao(data, tempo, listaResultado, listaColaboradores);
    }

    private void apresentaDados()
    {
        System.out.println("\n Informação a Registar:\n" + this.seriacaoController.getSeriacaoString());
    }

    private void validaUtilizador(){
        organizacao = seriacaoController.getInstance();
    }
}
