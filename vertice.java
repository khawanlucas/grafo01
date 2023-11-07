import java.util.ArrayList;
public class vertice<TIPO> {
    private TIPO pagina;
    private ArrayList<aresta<TIPO>> linkSaida;
    private ArrayList<aresta<TIPO>> linkEntrada;

    public vertice(TIPO pagina){
        this.pagina = pagina;
        this.linkEntrada = new ArrayList<>();
        this.linkSaida = new ArrayList<>();
    }

    public TIPO getPagina() {
        return pagina;
    }

    public void setPagina(TIPO pagina) {
        this.pagina = pagina;
    }

    public ArrayList<aresta<TIPO>> getLinkSaida() {
        return linkSaida;
    }

    public void setLinkSaida(ArrayList<aresta<TIPO>> links) {
        this.linkSaida = links;
    }

    public void adicionaLinkSaida(aresta<TIPO> l){
        this.linkSaida.add(l);
    }

    public ArrayList<aresta<TIPO>> getLinkEntrada() {
        return linkEntrada;
    }

    public void setLinkEntrada(ArrayList<aresta<TIPO>> linkEntrada) {
        this.linkEntrada = linkEntrada;
    }

    public void adicionaLinkEntrada(aresta<TIPO> l){
        this.linkEntrada.add(l);
    }
}

