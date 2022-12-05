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
            while (auxiliar.proximo_no!=null){
                auxiliar = auxiliar.proximo_no;
            }
            auxiliar.proximo_no = novo;

            this.setTotalDeAvioes(getTotalDeAvioes()+1);
        }
    }

    public Aviao sairDaFila(){
        Aviao removido = null;
        if(fila_vazia()){
            System.out.println("Fila vazia");
        }else{
            removido = inicio_fila;
            inicio_fila = inicio_fila.proximo_no;
        }
        if(totalDeAvioes>0){
            this.setTotalDeAvioes(getTotalDeAvioes()-1);
        }
        return removido;

    }




    public void verFila(){
        Aviao aviaoAtual;
        aviaoAtual = inicio_fila;
        while(aviaoAtual != null){
            System.out.println(aviaoAtual);
            aviaoAtual = aviaoAtual.proximo_no;
        }
    }



    public Aviao removerPosicao(int i){
        Aviao removido = null;
        Aviao auxiliar;
        int indice =0;
        if(fila_vazia() || i<=0){
            removido = sairDaFila();
        }else{
            removido = auxiliar = inicio_fila;

            while (indice<i && removido!=null){
                auxiliar = removido;
                removido = removido.proximo_no;
                indice++;
            }

            if(removido!=null){
                auxiliar.proximo_no = removido.proximo_no;
            }


        }
        if(totalDeAvioes>0){
            this.setTotalDeAvioes(getTotalDeAvioes()-1);
        }
        return removido;
    }


    public void furarFila(int id, int comb, int i){

        Aviao novo = new Aviao(id,comb);
        Aviao auxiliar = inicio_fila;
            int indice = 0;
            while(indice<i && auxiliar!=null){
                auxiliar = auxiliar.proximo_no;
                indice = indice + 1;
            }
            if(auxiliar==null){
                entrarNaFila(id,comb);
            }else{
                novo.proximo_no = auxiliar.proximo_no;
                auxiliar.proximo_no = novo;
            }

        this.setTotalDeAvioes(getTotalDeAvioes()+1);
    }

    public Aviao retornar_posicao(int pos) throws Exception {


        if(fila_vazia()){
            throw new Exception("fila vazia");
        }else{
            Aviao removido = this.removerPosicao(pos);
            int id = removido.ID;
            int comb= removido.combustivel;
            this.furarFila(id,comb,pos);
            return removido;
        }


    }

    public void perderCombustivel(Pista pistaReserva){
        Aviao aviaoAtual;
        Aviao removido;
        aviaoAtual = inicio_fila;
        int posicao =0;

        while(aviaoAtual != null){

            if(aviaoAtual.combustivel<=15){
               removido= this.removerPosicao(posicao);
              int id = removido.ID;
              int comb = removido.combustivel;
              pistaReserva.filaUm.entrarNaFila(id,comb);
              System.out.println("O avião:"+removido+" usou a pista:"+pistaReserva.getNumeroDaPista()+" e aterrizou,pois estava com pouco combustivel: "+removido.combustivel+" de combustivel");
              pistaReserva.filaUm.sairDaFila();
              pistaReserva.setAvioesSemReserva(pistaReserva.getAvioesSemReserva()+1);
            }


            aviaoAtual.combustivel = aviaoAtual.combustivel-5;

            aviaoAtual = aviaoAtual.proximo_no;
            posicao++;
        }
    }



}