
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Load {

    public static void main(String[] args) throws IOException {

        List<String> pname = new ArrayList<String>();
        List<String> PIN = new ArrayList<String>();
        List<String> money = new ArrayList<String>();
        List<String> type = new ArrayList<String>();


        String s;

        FileReader fr = new FileReader("generator2.txt");
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

        ArrayList<Client> clients = new ArrayList<Client>();
        for (int i = 0; i < 100; i++) {
            clients.add(new Client(pname.get(i), PIN.get(i), Float.parseFloat(money.get(i))));

        }


        System.out.print(clients.get(0).getMoney()+" ");
        clients.get(0).wplac(66);
        System.out.print(clients.get(0).getMoney());
    }
}




