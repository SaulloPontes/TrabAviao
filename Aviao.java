public class Aviao {

    int ID;
    int combustivel;
    Aviao proximo_aviao;



    public  Aviao(int ID,int combustivel){


        this.ID = ID;
        this.combustivel = combustivel;
        this.proximo_aviao = null;
    }



    @Override
    public String toString() {
        return "ID:"+ID +" tempo de combustivel:"+combustivel;
    }
}