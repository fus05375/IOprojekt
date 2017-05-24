import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa wczytująca dane z pliku, dzieląca na tablice oraz haszująca PIN
 *
 */
public class Load {
    private List<String> pname = new ArrayList<String>();
    private List<String > PIN = new ArrayList<String>();
    private List<String> epocList = new ArrayList<String>();
    private List<String> numberList = new ArrayList<String>();
    private List<String > money = new ArrayList<String>();
    private List<String> type = new ArrayList<String>();
    private ArrayList<Client> clients = new ArrayList<Client>();

    public void loadBook(String fileName) throws NoSuchAlgorithmException {
        try {
            String s;
            FileReader fr = new FileReader(fileName);
            Scanner plik = new Scanner(fr);
                  /* W tym wypadku pętla się wykonuje dopóki trafia na dowolną wartość */
            while (plik.hasNext()) {
                s = plik.nextLine();
                String[] parts = s.split(",");
                String epoc = parts[0];
                epocList.add(epoc);
                String no = parts[1];
                numberList.add(no);
                String name = parts[2];
                pname.add(name);
                String pin = parts[3];
                PIN.add(pin);
                String cash = parts[4];
                money.add(cash);
                String typeOf = parts[5];
                type.add(typeOf);
            }
            for (int i = 0; i <=pname.size()-1; i++) {     //dla calosci projektu
//            for (int i = 0; i <= 10; i++) {
                clients.add(new Client(pname.get(i), PIN.get(i), money.get(i), type.get(i)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /* Funkcja haszująca */
    public String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    /* Funkcja, która szuka w bazie danego rekordu */
    public boolean clientDoesntExist(String tmpClient, List<Client> ClientList  ){
        for( int i=0;i<=ClientList.size()-1;i++) {
            if (tmpClient.equals(ClientList.get(i).getName())) {

                System.out.println("Istnieje");
                return false;
            }
        }
        System.out.println("NIE Istnieje");
        return true;
    }

    /* Funkcja, która szuka w bazie danego rekordu i ustawia dany obiekt */
    public Client findClient(String tmpClient, List<Client> ClientList){
        for( int i=0;i<=ClientList.size()-1;i++) {
            if (tmpClient.equals(ClientList.get(i).getName())) {
//                System.out.println("Klient ustawiony");
                return ClientList.get(i);
            }
        }
//        System.out.println("NIE Ustawiony");
        return null;

    }
}



