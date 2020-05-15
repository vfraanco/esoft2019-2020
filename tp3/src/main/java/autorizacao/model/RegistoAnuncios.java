
package autorizacao.model;

import pot.model.Anuncio;

import java.util.List;

public class RegistoAnuncios {

    int perPub, perApr, perSer;
    String tipoReg;
    private List<Anuncio> listaAnuncios;
    private List<Anuncio> lstAnunciosPorSeriar;
    private Anuncio anuncio;

    public Anuncio novoAnuncio(int perPub, int perApr, int perSer, String tipoReg) {
        return new Anuncio(perPub, perApr, perSer, tipoReg);
    }

    public List<Anuncio> getAnuncioPorSeriarAutomatico(){
        return lstAnunciosPorSeriar;
    }

    /**
    public boolean validaAnuncio(Anuncio an) {
    }
    
    public boolean registaAnuncio(Anuncio an) {
        if (this.validaAnuncio(an)) {
            return addAnuncio(an);
        }
        return false;
    }
    
    public boolean addAnuncio(Anuncio an) {
        return listaAnuncios.add(an);
    }
    
    public List<Anuncio> getListaAnuncios(){
        return listaAnuncios;
    }

    public List<Anuncio> getRegistoAnuncio() {
        return listaAnuncios;
    }

    public Anuncio getAnuncioByID(String anuncioId){
       for (Anuncio anuncio : this.listaAnuncios) {
           if (anuncio.hasId(anuncioId)){
               return anuncio;
           }
       }
       return null;
    }
     **/
}