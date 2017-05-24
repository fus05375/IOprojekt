import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Raport  {

    public void setRaport(List<Client> clients){

        try{
            PrintWriter writer = new PrintWriter("raport ", "UTF-8");
            for( int i=0;i<=clients.size()-1;i++){
                writer.println(clients.get(i).getRaport());
            }
            writer.println("............................");
            writer.close();



        } catch (IOException e) {
            System.out.println("Error in setRaport");
        }
    }



}
