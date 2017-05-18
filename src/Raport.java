import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fus05 on 16.05.2017.
 */
public class Raport  {
    private List<String> pname = new ArrayList<String>();
    private List<String> money = new ArrayList<String>();


    public void setRaport(List<Client> clients){
        try{
            PrintWriter writer = new PrintWriter("fn", "UTF-8");
            for( int i=0;i<clients.size()-1;i++){
            writer.println(clients.get(i).getRaport());
            }
            writer.close();


        } catch (IOException e) {
            System.out.println("Error in setRaport");
        }
    }



}
