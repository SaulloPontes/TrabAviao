public class Aviao {

    int ID;
    int combustivel;
    Aviao proximo_no;



    public  Aviao(int ID,int combustivel){


        this.ID = ID;
        this.combustivel = combustivel;
        this.proximo_no = null;
    }



    @Override
    public String toString() {
        return "ID:"+ID +" tempo de combustivel:"+combustivel;
    }
}