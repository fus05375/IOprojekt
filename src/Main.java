import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        Load load = new Load();
        load.loadBook("DataInputGroupFBlad.csv");
        Raport raport = new Raport();
        List<Client> ClientList = new ArrayList<Client>();

        int nrOperacji = 0;
        for (int i = 0; i <= (load.getClients().size()) - 1; i++) {

            ClientList.add(load.getClients().get(i));

            if(load.clientExist(load.getClients().get(i).getName(),ClientList)){
                Client client = load.findClient(load.getClients().get(i).getName(),ClientList);

                if (load.getClients().get(i).getPIN()==client.getPIN()){
                    client.operations();
                    System.out.println("udalosie");
                }
                else{
                    
                }
            }

            nrOperacji++;
            if (nrOperacji == 100) {
                raport.setRaport(ClientList);
                nrOperacji = 0;
            }

        }
//            load.getClients().get(i).operations();
//            ClientList.add(load.getClients().get(i));

        //load.clientExist(load.getClients().get(i).getName(),ClientList);
        //raport.setRaport(ClientList);
//            Client ClientNOWY;
//            ClientNOWY=load.findClient(load.getClients().get(i).getName(),ClientList);
//            System.out.println(ClientNOWY.getRaport());
    }
}



//        System.out.println(load.getClients().get(2).getRaport());
//        System.out.println(load.getClients().get(2).operations());
//        System.out.println(load.getClients().get(2).getRaport());








