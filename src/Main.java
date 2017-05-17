import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        Load load = new Load();
        load.loadBook("DataInputGroupF.csv");
        Raport raport = new Raport();
        List<Client> ClientList = new ArrayList<Client>();


        load.getClients().size();
        //int nrOperacji=0;
        for(int i=0;i<=(load.getClients().size())-1;i++){
            load.getClients().get(i).operations();
            ClientList.add(load.getClients().get(i));
            raport.setRaport(ClientList);


            }
        }

//        System.out.println(load.getClients().get(2).getRaport());
//        System.out.println(load.getClients().get(2).operations());
//        System.out.println(load.getClients().get(2).getRaport());





    }


