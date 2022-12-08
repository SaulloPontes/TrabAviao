public class Fila {

    Aviao inicio_fila;
    private int totalDeAvioes;


    public  Fila(){
        this.inicio_fila = null;
        this.totalDeAvioes =0;
    }

    public int getTotalDeAvioes() {
        return totalDeAvioes;
    }

    public void setTotalDeAvioes(int totalDeAvioes) {
        this.totalDeAvioes = totalDeAvioes;
    }

    public boolean fila_vazia(){

        if(this.inicio_fila ==null){
            return  true;
        }else {
            return false;
        }
    }



    public  void entrarNaFila(int ID,int tempoCombustivel){
        Aviao novo = new Aviao(ID,tempoCombustivel);
        if(fila_vazia()){
            inicio_fila = novo;
        }else{
            Aviao auxiliar = inicio_fila;
            while (auxiliar.proximo_aviao !=null){
                auxiliar = auxiliar.proximo_aviao;
            }
            auxiliar.proximo_aviao = novo;

        }
        this.setTotalDeAvioes(getTotalDeAvioes()+1);
    }

    public Aviao sairDaFila(){
        Aviao removido = null;
        if(fila_vazia()){
            System.out.println("Fila vazia");
        }else{
            removido = inicio_fila;
            inicio_fila = inicio_fila.proximo_aviao;
        }
        if(this.getTotalDeAvioes()>0){
            this.setTotalDeAvioes(getTotalDeAvioes()-1);
        }
        return removido;

    }




    public void verFila(){
        Aviao aviaoAtual;
        aviaoAtual = inicio_fila;
        while(aviaoAtual != null){
            System.out.println(aviaoAtual);
            aviaoAtual = aviaoAtual.proximo_aviao;
        }
    }



    public Aviao retornar_posicao(int pos){
        Aviao aviaoAtual;
        Aviao retorno = null;
        aviaoAtual = inicio_fila;
        int cont=0;
        while(aviaoAtual != null){

            if(cont==pos){
                retorno = aviaoAtual;
                break;
            }
            aviaoAtual = aviaoAtual.proximo_aviao;
            cont++;
        }
        return retorno;
    }

    public void perderCombustivel(){

        Aviao aviaoAtual;

        aviaoAtual = inicio_fila;

        while(aviaoAtual != null){

            aviaoAtual.combustivel = aviaoAtual.combustivel-5;
            aviaoAtual = aviaoAtual.proximo_aviao;

        }
    }


}



