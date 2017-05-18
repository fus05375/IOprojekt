import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Load {

   private List<String> pname = new ArrayList<String>();
    private List<String> PIN = new ArrayList<String>();
    private List<String> money = new ArrayList<String>();
    private List<String> type = new ArrayList<String>();

    public ArrayList<Client> getClients() {
        return clients;
    }

    private ArrayList<Client> clients = new ArrayList<Client>();

    public void loadBook(String fn) throws IOException {

        String s;
        FileReader fr = new FileReader(fn);
        Scanner plik = new Scanner(fr);
                  /* W tym wypadku pętla się wykonuje dopóki trafia na dowolną wartość */
        while (plik.hasNext()) {
            s = plik.nextLine();
            String[] parts = s.split(",");
            String epoc = parts[0];
            String no = parts[1];

            String name = parts[2];
            pname.add(name);
            String pin = parts[3];
            PIN.add(pin);
            String cash = parts[4];
            money.add(cash);
            String typeOf = parts[5];
            type.add(typeOf);
        }

//        for (int i = 0; i <=pname.size()-1; i++) {     //dla calosci projektu
        for (int i = 0; i <=100; i++) {
            clients.add(new Client(pname.get(i), PIN.get(i), Float.parseFloat(money.get(i)), type.get(i)));

        }

    }
    public boolean clientExist(String tmpClient, List<Client> ClientList  ){
       for( int i=0;i<=ClientList.size()-1;i++) {
           if (tmpClient == ClientList.get(i).getName()) {
               System.out.println("Istnieje");
               return true;
           }
       }
        System.out.println("NIE Istnieje");
        return false;
    }
    public Client findClient(String tmpClient, List<Client> ClientList){
        for( int i=0;i<=ClientList.size()-1;i++) {
            if (tmpClient == ClientList.get(i).getName()) {
                System.out.println("Klient ustawiony");
                return ClientList.get(i);
            }
        }
        System.out.println("NIE Ustawiony");
        return null;

    }

}



