
package autorizacao.model;

import pot.model.Tarefa;

import java.util.List;

public class ListaTarefa {

    private static List<Tarefa> m_lstTarefas;
    
    public static List<Tarefa> getLista() {
        return m_lstTarefas;
    }
    
    public static Tarefa getTarefaByCod(String tCod) {
        for (Tarefa tar : m_lstTarefas) {
            if (tar.getCod() == tCod) {
                return tar;
            }
        }
        return null;
    }
}
