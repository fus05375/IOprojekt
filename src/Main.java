import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        int nrOperacji=0;
        Load load = new Load();
        load.loadBook("TestyAkceptacyjneGrupaF.csv");
        Raport raport = new Raport();


        List<Client> ClientBase = new ArrayList<Client>();
        for (int i = 0; i <= (load.getClients().size()) - 1; i++) {


            /* Jeżeli w naszej bazie nie ma klienta - dodajemy, jeżeli jest - operujemy */
            if (load.clientDoesntExist(load.getClients().get(i).getName(), ClientBase)) {
                ClientBase.add(load.getClients().get(i));


                /* Po dodaniu klienta robimy pierwszą operację, wpierw znajdujemy klienta, następnie operacja*/
                Client client = load.findClient(load.getClients().get(i).getName(), ClientBase);


                /* Przypadek gdy zamiast zmiennej typu float, mamy string. Catch łapie błąd, ustawia operacje na 0*/
                try {
                    client.operations(load.getClients().get(i).getOperation(), Float.parseFloat(load.getClients().get(i).getMoney()));
                    nrOperacji++;
                    System.out.println(nrOperacji);
                    System.out.println(client.getRaport());
                }catch (NumberFormatException e){
                    System.out.println("zły format");
                    client.operations(load.getClients().get(i).getOperation(), 0);
                    nrOperacji++;
                    System.out.println(nrOperacji);
                    System.out.println(client.getRaport());
                }


            }else{
                    /* Ustawiamy znacznik na klienta z naszej bazy */
                Client client = load.findClient(load.getClients().get(i).getName(),ClientBase);


                    /* Porównanie Pinu */
                if (load.getClients().get(i).getPIN().equals(client.getPIN())&&client.isBlock()==false){

                    try {
                        client.operations(load.getClients().get(i).getOperation(), Float.parseFloat(load.getClients().get(i).getMoney()));
                        nrOperacji++;
                        System.out.println(nrOperacji);
                        System.out.println(client.getRaport());
                    }catch (NumberFormatException e){
                        System.out.println("zły format danych wejściowych");
                        client.operations(load.getClients().get(i).getOperation(), 0);
                        nrOperacji++;
                        System.out.println(nrOperacji);
                        System.out.println(client.getRaport());
                    }

                    /* Przypisanie zablokowania konta */
                }else{
                    client.wrongPin();
                    nrOperacji++;
                    System.out.println(nrOperacji);
                }
            }

        }
            raport.setRaport(ClientBase);


        System.out.println(load.sha256(ClientBase.get(1).getPIN()));
        System.out.println(load.sha256(load.getClients().get(1).getPIN()));



    }
}
