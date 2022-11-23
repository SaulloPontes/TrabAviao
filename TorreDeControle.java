import java.util.Objects;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;

public class TorreDeControle {


    Pista pistaUm = new Pista(2,1);
    Pista pistaDois = new Pista(2,2);
    Pista pistaTres = new Pista(1,3);

    Scanner sc = new Scanner(System.in);

    public  TorreDeControle(){

    }


    public void controleAterrizagem() throws Exception {

        String chegou;
        int id=1;
        while (true){
            System.out.println("=========================================================================================");
            System.out.println("chegou avião?");
            chegou = sc.nextLine();
            if(Objects.equals(chegou, "n")){
                break;
            }
            Date data = new Date();
            Calendar x = Calendar.getInstance();
            x.setTime(data);
            int seg = x.get(Calendar.SECOND);


            if(pistaUm.getTotalDeAviaoParaAterrizar()==pistaDois.getTotalDeAviaoParaAterrizar()){

                this.pistaUm.setTotalDeAviaoParaAterrizar(pistaUm.getTotalDeAviaoParaAterrizar()+1);

                if(pistaUm.filaUm.getTotalDeAvioes()==pistaUm.filaDois.getTotalDeAvioes()){
                    pistaUm.filaUm.entrarNaFila(id,seg);
                }else if(pistaUm.filaUm.getTotalDeAvioes()>pistaUm.filaDois.getTotalDeAvioes()){
                    pistaUm.filaDois.entrarNaFila(id,seg);
                }else{
                    pistaUm.filaUm.entrarNaFila(id,seg);
                }

            }else if(pistaUm.getTotalDeAviaoParaAterrizar()>pistaDois.getTotalDeAviaoParaAterrizar()){

                this.pistaDois.setTotalDeAviaoParaAterrizar(pistaDois.getTotalDeAviaoParaAterrizar()+1);

                if(pistaDois.filaUm.getTotalDeAvioes()==pistaDois.filaDois.getTotalDeAvioes()){
                    pistaDois.filaUm.entrarNaFila(id,seg);
                }else if(pistaDois.filaUm.getTotalDeAvioes()>pistaDois.filaDois.getTotalDeAvioes()){
                    pistaDois.filaDois.entrarNaFila(id,seg);
                }else{
                    pistaDois.filaUm.entrarNaFila(id,seg);
                }
            }else{

                pistaUm.setTotalDeAviaoParaAterrizar(pistaUm.getTotalDeAviaoParaAterrizar()+1);

                if(pistaUm.filaUm.getTotalDeAvioes()==pistaUm.filaDois.getTotalDeAvioes()){
                    pistaUm.filaUm.entrarNaFila(id,seg);
                }else if(pistaUm.filaUm.getTotalDeAvioes()>pistaUm.filaDois.getTotalDeAvioes()){
                    pistaUm.filaDois.entrarNaFila(id,seg);
                }else{
                    pistaUm.filaUm.entrarNaFila(id,seg);
                }
            }

            this.autorizarAterrizagem(pistaUm);
            this.autorizarAterrizagem(pistaDois);


            pistaUm.filaUm.perderCombustivel(pistaTres);
            pistaUm.filaDois.perderCombustivel(pistaTres);
            pistaDois.filaUm.perderCombustivel(pistaTres);
            pistaDois.filaDois.perderCombustivel(pistaTres);




            System.out.println("====================PISTA:"+ pistaUm.getNumeroDaPista());
            System.out.println("FILA 1:");
            pistaUm.filaUm.verFila();
            System.out.println("===========================");
            System.out.println("FILA 2:");
            pistaUm.filaDois.verFila();
            System.out.println("====================PISTA:"+ pistaDois.getNumeroDaPista());
            System.out.println("FILA 1:");
            pistaDois.filaUm.verFila();
            System.out.println("===========================");
            System.out.println("FILA 2:");
            pistaDois.filaDois.verFila();
            id++;

        }
        System.out.println("total de aviões que aterrizaram com sem reserva de combustivel: "+pistaTres.getAvioesSemReserva());
    }






    public void autorizarAterrizagem(Pista pista) throws Exception {


        Aviao av;

        if(!pista.filaUm.fila_vazia()){
            Aviao av1 = pista.filaUm.retornar_posicao(0);

            if(av1.combustivel%5==0 ){
                av = pista.filaUm.sairDaFila();
                System.out.println("Na pista " +pista.getNumeroDaPista()+ " o avião aterrizou "+av);
            }

        }

        if(!pista.filaDois.fila_vazia()){

            Aviao av2 = pista.filaDois.retornar_posicao(0);
            if(av2.combustivel%5==0){
                av = pista.filaDois.sairDaFila();
                System.out.println("Na pista " +pista.getNumeroDaPista()+" o avião aterrizou "+av);
            }

        }






    }

}
