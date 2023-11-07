public class teste {
    public static void main(String[] args) {
        grafo<String> x = new grafo<String>();

        x.adicionaPagina("www.siteA.com.br");
        x.adicionaPagina("www.siteB.com.br");
        x.adicionaPagina("www.siteC.com.br");
        x.adicionaPagina("www.siteD.com.br");
        x.adicionaPagina("www.siteE.com.br");
        x.adicionaPagina("www.siteF.com.br");
        x.adicionaPagina("www.siteG.com.br");


        x.adicionarLink("www.siteA.com.br", "www.siteB.com.br");
        x.adicionarLink("www.siteB.com.br", "www.siteC.com.br");
        x.adicionarLink("www.siteA.com.br", "www.siteC.com.br");
        x.adicionarLink("www.siteC.com.br", "www.siteD.com.br");
        x.adicionarLink("www.siteA.com.br", "www.siteD.com.br");
        x.adicionarLink("www.siteD.com.br", "www.siteE.com.br");
        x.adicionarLink("www.siteD.com.br", "www.siteF.com.br");
        x.adicionarLink("www.siteE.com.br", "www.siteG.com.br");
        x.adicionarLink("www.siteF.com.br", "www.siteG.com.br");

        x.mostraVertices();
        x.mostraArestas();

        System.out.println("-----------------------------------");

        x.BuscaEmLargura("www.siteC.com.br");

        System.out.println("-----------------------------------");

        System.out.println(x.b("www.siteB.com.br", "www.siteG.com.br"));

        System.out.println("-----------------------------------");

        x.removeVertice("www.siteA.com.br");
        x.mostraVertices();
        x.mostraArestas();

        System.out.println("-----------------------------------");

        x.removeVertice2("www.siteC.com.br");
        x.mostraVertices();
        x.mostraArestas();

    }
}
