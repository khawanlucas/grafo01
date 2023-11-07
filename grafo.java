import java.util.ArrayList;
public class grafo<TIPO> {
    private ArrayList<vertice<TIPO>> paginas;
    private ArrayList<aresta<TIPO>> links;

    public grafo(){
        this.paginas = new ArrayList<vertice<TIPO>>();
        this.links = new ArrayList<aresta<TIPO>>();
    }

    public void adicionaPagina(TIPO dado){
        vertice<TIPO> novaPagina = new vertice<TIPO>(dado);
        this.paginas.add(novaPagina);
    }

    public void adicionarLink(TIPO dado1, TIPO dado2){
        vertice<TIPO> p1 = this.getVertice(dado1);
        vertice<TIPO> p2 = this.getVertice(dado2);
        if(p1 != null && p2 != null){
            aresta<TIPO> link = new aresta<TIPO>(p1, p2);
            p1.adicionaLinkSaida(link);
            p2.adicionaLinkEntrada(link);
            this.links.add(link);
        }
    }

    private vertice<TIPO> getVertice(TIPO dado){
        vertice<TIPO> vertice = null;
        for(int i=0; i<this.paginas.size(); i++){
            if(this.paginas.get(i).getPagina().equals(dado)){
                vertice = this.paginas.get(i);
                break;
            }
        }
        return vertice;
    }
    private boolean existeAresta(TIPO v1, TIPO v2){
        vertice<TIPO> ver1 = this.getVertice(v1);
        vertice<TIPO> ver2 = this.getVertice(v2);
        if(ver1 == null && ver2 == null){
            return false;
        }
        for(int i=0; i<this.links.size(); i++){
            if(this.links.get(i).getPagina1().equals(ver1) && this.links.get(i).getPagina2().equals(ver2)){
                return true;
            }
        }
        return false;
    }

    public void BuscaEmLargura(TIPO dado1){
        ArrayList<vertice<TIPO>> marcados = new ArrayList<>();
        ArrayList<vertice<TIPO>> fila = new ArrayList<>();
        vertice<TIPO> atual = this.getVertice(dado1);
        marcados.add(atual);
        System.out.println(atual.getPagina());
        fila.add(atual);
        while(fila.size() > 0){
            vertice<TIPO> visitado = fila.get(0);
            for(int i = 0; i < visitado.getLinkSaida().size();i++){
                vertice<TIPO> proximo = visitado.getLinkSaida().get(i).getPagina2();
                if(!marcados.contains(proximo)){
                    marcados.add(proximo);
                    System.out.println(proximo.getPagina());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public ArrayList<TIPO> b(TIPO a, TIPO c) {
        return buscaEmProfundidade(a, c, new ArrayList<>());
    }
    private ArrayList<TIPO> buscaEmProfundidade(TIPO atual, TIPO destino, ArrayList<TIPO> caminho) {
        caminho.add(atual);

        if (atual.equals(destino)) {
            return caminho;
        }

        vertice<TIPO> ve = getVertice(atual);
        for (aresta<TIPO> aresta : ve.getLinkSaida()) {
            if(aresta !=null){
                TIPO proximoVertice = aresta.getPagina2().getPagina();
                if(proximoVertice!=null){
                    if (!caminho.contains(proximoVertice)) {
                        ArrayList<TIPO> resultado = buscaEmProfundidade(proximoVertice, destino, new ArrayList<>(caminho));
                        if (resultado != null) {
                            return resultado;
                        }
                    }
                }
            }
        }

        return null;
    }

    public void mostraVertices(){
        StringBuilder x = new StringBuilder();
        x.append("[");
        for(vertice<TIPO> v : this.paginas){
            x.append(v.getPagina());
            if(!this.paginas.get(this.paginas.size() - 1).equals(v)){
                x.append(", ");
            }
        }
        x.append("]");
        System.out.println(x);
    }

    public void mostraArestas(){
        for(aresta<TIPO> aresta : this.links){
            StringBuilder x = new StringBuilder();
            x.append("[ " + aresta.getPagina1().getPagina() + ", " + aresta.getPagina2().getPagina() + " ]");
            System.out.println(x);
        }
    }

    public void removeVertice(TIPO c){
        vertice ver = this.getVertice(c);
        ArrayList<aresta<TIPO>> linkaux = new ArrayList<>(this.links);
        for(aresta<TIPO> aresta : linkaux){
            if(aresta.getPagina1().equals(ver) || aresta.getPagina2().equals(ver)){
                this.links.remove(aresta);
            }
        }
        this.paginas.remove(ver);
    }

    public void removeVertice2(TIPO c){
        ArrayList<aresta<TIPO>> linkaux = new ArrayList<>(this.links);
        for(aresta<TIPO> aresta : linkaux){
            if(aresta.getPagina1().equals(this.getVertice(c))){
                for(aresta<TIPO> aux : this.getVertice(c).getLinkEntrada()){
                    if(!this.existeAresta(aux.getPagina1().getPagina(), aresta.getPagina2().getPagina())){
                        this.adicionarLink(aux.getPagina1().getPagina(), aresta.getPagina2().getPagina());
                    }
                }
                this.links.remove(aresta);
            }
            if(aresta.getPagina2().equals(this.getVertice(c))){
                for(aresta<TIPO> aux : this.getVertice(c).getLinkSaida()){
                    if(!this.existeAresta(aresta.getPagina1().getPagina(), aux.getPagina2().getPagina())){
                        this.adicionarLink(aresta.getPagina1().getPagina(), aux.getPagina2().getPagina());
                    }
                }
                this.links.remove(aresta);
            }
        }
        this.paginas.remove(this.getVertice(c));
    }
    }





