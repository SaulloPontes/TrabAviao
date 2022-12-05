import java.util.Objects;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TorreDeControle {


    Pista pistaUm = new Pista(2,1);
    Pista pistaDois = new Pista(2,2);
    Pista pistaTres = new Pista(1,3);

    Scanner sc = new Scanner(System.in);

    public  TorreDeControle(){

    }


    public void controlePista() throws Exception {

        String encerrar;
        int id=0;
        int seg;
        Date data;
        Calendar cal;
        Aviao av1;
        Aviao av2;
        while (true){
            System.out.println("=========================================================================================");


            data = new Date();
            cal = Calendar.getInstance();
            cal.setTime(data);
            seg = cal.get(Calendar.SECOND);

            if(seg%2==1){

                id++;


                Random aleatorio = new Random();
                int combustivel = aleatorio.nextInt((100 - 10) + 1) + 10;

                Aviao ex = new Aviao(id,combustivel);

                System.out.println("chegou o avião para aterrizar, ID:"+ex.ID);

                if(pistaUm.getTotalDeAviaoParaAterrizar()==pistaDois.getTotalDeAviaoParaAterrizar()){

                    this.pistaUm.setTotalDeAviaoParaAterrizar(pistaUm.getTotalDeAviaoParaAterrizar()+1);

                    if(pistaUm.filaUm.getTotalDeAvioes()<pistaUm.filaDois.getTotalDeAvioes()){
                        pistaUm.filaUm.entrarNaFila(id,combustivel);
                    }else if(pistaUm.filaUm.getTotalDeAvioes()>pistaUm.filaDois.getTotalDeAvioes()){
                        pistaUm.filaDois.entrarNaFila(id,combustivel);
                    }else {
                        pistaUm.filaUm.entrarNaFila(id,combustivel);
                    }

                }else if(pistaUm.getTotalDeAviaoParaAterrizar()>pistaDois.getTotalDeAviaoParaAterrizar()){

                    this.pistaDois.setTotalDeAviaoParaAterrizar(pistaDois.getTotalDeAviaoParaAterrizar()+1);

                    if(pistaDois.filaUm.getTotalDeAvioes()<pistaDois.filaDois.getTotalDeAvioes()){
                        pistaDois.filaUm.entrarNaFila(id,combustivel);
                    }else if(pistaDois.filaUm.getTotalDeAvioes()>pistaDois.filaDois.getTotalDeAvioes()){
                        pistaDois.filaDois.entrarNaFila(id,combustivel);
                    }else{
                        pistaDois.filaUm.entrarNaFila(id,combustivel);
                    }
                }else{

                    this.pistaUm.setTotalDeAviaoParaAterrizar(pistaUm.getTotalDeAviaoParaAterrizar()+1);

                    if(pistaUm.filaUm.getTotalDeAvioes()<pistaUm.filaDois.getTotalDeAvioes()){
                        pistaUm.filaUm.entrarNaFila(id,combustivel);
                    }else if(pistaUm.filaUm.getTotalDeAvioes()>pistaUm.filaDois.getTotalDeAvioes()){
                        pistaUm.filaDois.entrarNaFila(id,combustivel);
                    }else {
                        pistaUm.filaUm.entrarNaFila(id,combustivel);
                    }
                }


                this.autorizarAterrizagem(pistaUm);
                this.autorizarAterrizagem(pistaDois);

                pistaUm.filaUm.perderCombustivel(pistaTres);
                pistaUm.filaDois.perderCombustivel(pistaTres);
                pistaDois.filaUm.perderCombustivel(pistaTres);
                pistaDois.filaDois.perderCombustivel(pistaTres);






                System.out.println("====================PISTA:"+ pistaUm.getNumeroDaPista());
                System.out.println("FILA 1 DE ATERRIZAGEM:");
                pistaUm.filaUm.verFila();
                System.out.println("===========================");
                System.out.println("FILA 2 DE ATERRIZAGEM:");
                pistaUm.filaDois.verFila();
                System.out.println("====================PISTA:"+ pistaDois.getNumeroDaPista());
                System.out.println("FILA 1 DE ATERRIZAGEM:");
                pistaDois.filaUm.verFila();
                System.out.println("===========================");
                System.out.println("FILA 2 DE ATERRIZAGEM:");
                pistaDois.filaDois.verFila();


            }




            Aviao x;

            if(seg%2==0){

                id++;
                if(pistaUm.filaDecolagem.getTotalDeAvioes() == pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                    pistaUm.filaDecolagem.entrarNaFila(id,1000);
                }else if(pistaUm.filaDecolagem.getTotalDeAvioes() > pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() > pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                    pistaDois.filaDecolagem.entrarNaFila(id,1000);
                }else if (pistaUm.filaDecolagem.getTotalDeAvioes()> pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() > pistaTres.filaDecolagem.getTotalDeAvioes()){
                    pistaTres.filaDecolagem.entrarNaFila(id,1000);
                }

                System.out.println("====================PISTA:"+ pistaUm.getNumeroDaPista());
                System.out.println("FILA DE DECOLAGEM:");
                pistaUm.filaDecolagem.verFila();
                System.out.println("====================PISTA:"+ pistaDois.getNumeroDaPista());
                System.out.println("FILA DE DECOLAGEM:");
                pistaDois.filaDecolagem.verFila();
                System.out.println("====================PISTA:"+ pistaTres.getNumeroDaPista());
                System.out.println("FILA DE DECOLAGEM:");
                pistaTres.filaDecolagem.verFila();

                if(seg>=30  ){

                    if(pistaUm.filaDecolagem.getTotalDeAvioes() == pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                         x = pistaUm.filaDecolagem.sairDaFila();
                        if(x!=null){
                            System.out.println("DECOLOU:"+x);
                        }
                    }else if(pistaUm.filaDecolagem.getTotalDeAvioes() < pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() < pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                         x = pistaDois.filaDecolagem.sairDaFila();
                        if(x!=null){
                            System.out.println("DECOLOU:"+x);
                        }
                    }else{
                         x = pistaTres.filaDecolagem.sairDaFila();
                        if(x!=null){
                            System.out.println("DECOLOU:"+x);
                        }
                    }

                }
            }












            System.out.println("encerrar aeroporto[s/n]?");
            encerrar = sc.nextLine();

            if(Objects.equals(encerrar, "s")){
                System.out.println("total de aviões que aterrizaram com sem reserva de combustivel: "+pistaTres.getAvioesSemReserva());
                break;
            }



        }

    }






    public void autorizarAterrizagem(Pista pista) throws Exception {


        Aviao av;

        if(!pista.filaUm.fila_vazia()){
            Aviao av1 = pista.filaUm.retornar_posicao(0);

            if(av1.combustivel<=30){
                av = pista.filaUm.sairDaFila();
                System.out.println("Na pista " +pista.getNumeroDaPista()+ " o avião aterrizou "+av);
                if(pista.getTotalDeAviaoParaAterrizar()>0){
                    pista.setTotalDeAviaoParaAterrizar(pista.getTotalDeAviaoParaAterrizar()-1);
                }
            }

        }

        if(!pista.filaDois.fila_vazia()){

            Aviao av2 = pista.filaDois.retornar_posicao(0);
            if(av2.combustivel<=30){
                av = pista.filaDois.sairDaFila();
                System.out.println("Na pista " +pista.getNumeroDaPista()+" o avião aterrizou "+av);
                if(pista.getTotalDeAviaoParaAterrizar()>0){
                    pista.setTotalDeAviaoParaAterrizar(pista.getTotalDeAviaoParaAterrizar()-1);
                }
            }

        }





    }



}