package heigvd.ch.segfaultapi.model;

public class Discussion {
    private String sujet;
    // TODO: 2019-03-18 référence vers message racine
    //private Message& racine;

    public Discussion (String sujet) {
        this.sujet = sujet;
    }

    public String getSujet() {
        return sujet;
    }
}
