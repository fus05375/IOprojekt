import java.util.Random;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.io.PrintWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        long timestamp = 0;
        int no = 0;
        String name = "";
        String PIN = "";
        double money = 1000.00;
        String type = "";

        makeFile(timestamp, no, name, PIN, money, type);
    }

    public static long getTimestamp() {
        long timestamp = System.currentTimeMillis();
//        long timestamp = System.currentTimeMillis()/100L;
        return timestamp;
    }

    public static String getName() {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWXYZ".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 12; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String pname = sb.toString();
        return pname;
    }

    public static String getPIN() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String PIN = String.format("%05d", num);
        return PIN;
    }

    public static double getMoney() {
        Random random = new Random();
        double rangeMin = 0.01;
        double rangeMax = 1000.00;
        double money = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
        money = Double.parseDouble(new DecimalFormat("#.00").format(money));
        return money;
    }

    public static String getType() {
        String[] words = {"outcome", "income", "ACCOUNT"};
        String type = words[(int) (Math.random() * words.length)];
        return type;
    }

    public static void makeFile(long timestamp, int no, String pname, String PIN, double money, String type) {
        try {
            PrintWriter writer = new PrintWriter("random-data-generator.txt", "UTF-8");
            for (int i = 0; i < 100; i++) {
                timestamp = getTimestamp();
                no = i + 1;
                pname = getName();
                PIN = getPIN();
                money = getMoney();
                type = getType();
                writer.println(timestamp + "," + no + "," + pname + "," + PIN + "," + money + "," + type);
            }
            writer.close();
        } catch (IOException e) {
            //do sth
        }
    }
}
