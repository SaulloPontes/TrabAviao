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

        Random numeroAleatorio = new Random();

        while (true){
            System.out.println("=========================================================================================");


            data = new Date();
            cal = Calendar.getInstance();
            cal.setTime(data);
            seg = cal.get(Calendar.SECOND);

            if(seg%2==1){

                int qtdAviao = numeroAleatorio.nextInt((3 - 0) + 1) + 0;

                System.out.println("======================= chegou: "+qtdAviao+" avião para aterrizar =======================");
                while (qtdAviao>0){

                    id++;
                    int combustivel = numeroAleatorio.nextInt((100 - 10) + 1) + 10;
                    Aviao av = new Aviao(id,combustivel);

                    System.out.println("chegou o avião para aterrizar:"+av);

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

                    qtdAviao--;
                }

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

                this.pistaEmergencia(pistaUm,pistaTres);
                this.pistaEmergencia(pistaDois,pistaTres);

                this.autorizarAterrizagem(pistaUm);
                this.autorizarAterrizagem(pistaDois);


                pistaUm.filaUm.perderCombustivel();
                pistaUm.filaDois.perderCombustivel();
                pistaDois.filaUm.perderCombustivel();
                pistaDois.filaDois.perderCombustivel();



            }


            Aviao aviaoDecolando;




            if(seg%2==0){

                int qtdAviao = numeroAleatorio.nextInt((3 - 0) + 1) + 0;

                System.out.println("======================= chegou: "+qtdAviao+" avião para Decolar =======================");

                while(qtdAviao>0){
                    id++;

                    System.out.println("Avião chegou para decolar ID:"+id);

                    if(pistaUm.filaDecolagem.getTotalDeAvioes() == pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                        pistaUm.filaDecolagem.entrarNaFila(id,1000);
                    }else if(pistaUm.filaDecolagem.getTotalDeAvioes() > pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() > pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                        pistaDois.filaDecolagem.entrarNaFila(id,1000);
                    }else if (pistaUm.filaDecolagem.getTotalDeAvioes()> pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() > pistaTres.filaDecolagem.getTotalDeAvioes()){
                        pistaTres.filaDecolagem.entrarNaFila(id,1000);
                    }

                    qtdAviao--;
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
                         aviaoDecolando = pistaUm.filaDecolagem.sairDaFila();
                        if(aviaoDecolando!=null){
                            System.out.println("DECOLOU:"+aviaoDecolando);
                        }
                    }else if(pistaUm.filaDecolagem.getTotalDeAvioes() < pistaDois.filaDecolagem.getTotalDeAvioes() && pistaUm.filaDecolagem.getTotalDeAvioes() < pistaTres.filaDecolagem.getTotalDeAvioes() && pistaDois.filaDecolagem.getTotalDeAvioes() == pistaTres.filaDecolagem.getTotalDeAvioes()){
                         aviaoDecolando = pistaDois.filaDecolagem.sairDaFila();
                        if(aviaoDecolando!=null){
                            System.out.println("DECOLOU:"+aviaoDecolando);
                        }
                    }else{
                         aviaoDecolando = pistaTres.filaDecolagem.sairDaFila();
                        if(aviaoDecolando!=null){
                            System.out.println("DECOLOU:"+aviaoDecolando);
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

        int comb;
        Aviao av;

        if(!pista.filaUm.fila_vazia()){

              comb = pista.filaUm.retornar_posicao(0).combustivel;


            if(comb<=30){
               av = pista.filaUm.sairDaFila();

                System.out.println("Na pista " +pista.getNumeroDaPista()+ " o avião aterrizou:"+av);
                if(pista.getTotalDeAviaoParaAterrizar()>0){
                    pista.setTotalDeAviaoParaAterrizar(pista.getTotalDeAviaoParaAterrizar()-1);
                }
            }


        }

        if(!pista.filaDois.fila_vazia()){

            comb = pista.filaDois.retornar_posicao(0).combustivel;


            if(comb<=30){
                av = pista.filaDois.sairDaFila();

                System.out.println("Na pista " +pista.getNumeroDaPista()+ " o avião aterrizou:"+av);
                if(pista.getTotalDeAviaoParaAterrizar()>0){
                    pista.setTotalDeAviaoParaAterrizar(pista.getTotalDeAviaoParaAterrizar()-1);
                }
            }

        }

    }


    public  void pistaEmergencia(Pista pista,Pista reserva){

        Fila filaUmATT = new Fila() ;
        Fila filaDoisATT = new Fila();

        Aviao av;
        int pos = 0;
        int totalAviaoFilaUm = pista.filaUm.getTotalDeAvioes();
        int totalAviaoDoisUm = pista.filaDois.getTotalDeAvioes();

        while (totalAviaoFilaUm>0){

           av = pista.filaUm.retornar_posicao(pos);

           if(av.combustivel<=15){
               System.out.println("AVIÃO COM POUCO COMBUSTIVEL!, usou a pista 3, "+ av);
               reserva.filaUm.entrarNaFila(av.ID,av.combustivel);
               reserva.setAvioesSemReserva(reserva.getAvioesSemReserva()+1);
           }else{
               filaUmATT.entrarNaFila(av.ID,av.combustivel);
           }

            totalAviaoFilaUm--;
            pos++;
        }
        pos = 0;
        while (totalAviaoDoisUm>0){

            av = pista.filaDois.retornar_posicao(pos);

            if(av.combustivel<=15){
                System.out.println("AVIÃO COM POUCO COMBUSTIVEL!, usou a pista 3, "+ av);
                reserva.filaUm.entrarNaFila(av.ID,av.combustivel);
                reserva.filaUm.sairDaFila();
                reserva.setAvioesSemReserva(reserva.getAvioesSemReserva()+1);
            }else{
                filaDoisATT.entrarNaFila(av.ID,av.combustivel);
            }

            totalAviaoDoisUm--;
            pos++;
        }

        pista.filaUm = filaUmATT;
        pista.filaDois = filaDoisATT;
    }


}