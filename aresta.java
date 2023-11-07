public class aresta<TIPO> {
    private vertice<TIPO> pagina1;
    private vertice<TIPO> pagina2;

    public aresta(vertice<TIPO> pagina1, vertice<TIPO> pagina2){
        this.pagina1 = pagina1;
        this.pagina2 = pagina2;
    }

    public vertice<TIPO> getPagina1(){
        return pagina1;
    }
    public void setPagina1(vertice<TIPO> pagina1){
        this.pagina1 = pagina1;
    }
    public vertice<TIPO> getPagina2(){
        return pagina2;
    }
    public void setPagina2(vertice<TIPO> pagina2){
        this.pagina2 = pagina2;
    }
}


