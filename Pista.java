public class Pista {


    private int prateleirasDeEsperaDeAterrissagem;
    private int numeroDaPista;
    private  int totalDeAviaoParaAterrizar;

    private int avioesSemReserva;

    Fila filaUm;
    Fila filaDois;

    Fila filaDecolagem;

    private int totalDeAviaoParaDecolar;


    public  Pista(int prateleirasDeEsperaDeAterrissagem,int numeroPista){

        this.prateleirasDeEsperaDeAterrissagem = prateleirasDeEsperaDeAterrissagem;
        this.numeroDaPista = numeroPista;
        this.totalDeAviaoParaAterrizar =0;
        this.totalDeAviaoParaDecolar=0;
        this.avioesSemReserva=0;
        this.filaDecolagem = new Fila();
        if(this.prateleirasDeEsperaDeAterrissagem>=2){
            this.filaUm = new Fila();
            this.filaDois = new Fila();
        }else {
            this.filaUm = new Fila();
        }

    }

    public int getTotalDeAviaoParaDecolar() {
        return totalDeAviaoParaDecolar;
    }

    public void setTotalDeAviaoParaDecolar(int totalDeAviaoParaDecolar) {
        this.totalDeAviaoParaDecolar = totalDeAviaoParaDecolar;
    }

    public int getAvioesSemReserva() {
        return avioesSemReserva;
    }

    public void setAvioesSemReserva(int avioesSemReserva) {
        this.avioesSemReserva = avioesSemReserva;
    }

    public int getTotalDeAviaoParaAterrizar() {
        return totalDeAviaoParaAterrizar;
    }

    public void setTotalDeAviaoParaAterrizar(int totalDeAviaoParaAterrizar) {
        this.totalDeAviaoParaAterrizar = totalDeAviaoParaAterrizar;
    }

    public int getPrateleirasDeEsperaDeAterrissagem() {
        return prateleirasDeEsperaDeAterrissagem;
    }

    public void setPrateleirasDeEsperaDeAterrissagem(int prateleirasDeEsperaDeAterrissagem) {
        this.prateleirasDeEsperaDeAterrissagem = prateleirasDeEsperaDeAterrissagem;
    }

    public int getNumeroDaPista() {
        return numeroDaPista;
    }

    public void setNumeroDaPista(int numeroDaPista) {
        this.numeroDaPista = numeroDaPista;
    }



    @Override
    public String toString() {
        return "prateleira(s):"+ prateleirasDeEsperaDeAterrissagem + " numero da pista:"+numeroDaPista;
    }
}
