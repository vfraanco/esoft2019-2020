package autorizacao.model;

import pot.model.Colaborador;

import java.util.List;

public class ListaColaboradores {

   private List<Colaborador> listaColaboradores;

   public ListaColaboradores() {
      this.listaColaboradores = getListaColaboradores();
   }

   public boolean add(Colaborador colab){
      listaColaboradores.add(colab);
      return true;
   }

   public List<Colaborador> getListaColaboradores(){
      return listaColaboradores;
   }

   public Colaborador getColaboradorByID(String colaboradorID){
      for (Colaborador colaborador : listaColaboradores){
         if (colaborador.hasId(colaboradorID)){
            return colaborador;
         }
      }
      return null;
   }

   public boolean tensColaboradorComEmail(String emailUtlz){
      boolean found = false;
      for(Colaborador clb : listaColaboradores){
         if (emailUtlz.equalsIgnoreCase(clb.getEmail())){
            found = true;
         }
      }
      return false;
   }
}
