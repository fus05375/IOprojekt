import java.security.NoSuchAlgorithmException;

public class Client {

    private String name;
    private String PIN;
    String money;// 1000 reszta to operacje
    int wrongPin=0;
    float amountOfCash = 1000;
    Load l;

    public String getOperation() {
        return operation;
    }

    String operation;
    boolean block = false;



    public boolean isBlock() {
        return block;
    }


    public Client(String name, String PIN, String money, String operation) throws NoSuchAlgorithmException {
        this.name = name;
        this.PIN = PIN;
        this.money = money;
        this.operation = operation;

    }


    public String getName() {
        return name;
    }

    public String getPIN() {
        return PIN;
    }

    public String getMoney() {return money;}


    public float operations(String operation, float money ) {

            switch (operation) {
                case "income":

                        if (money >= 0)
                            amountOfCash = amountOfCash + money; // przy wplacie liczby dodatnie
                        else {
                            System.out.println("Sth bad with money!!");
                            return amountOfCash;
                        }
                        break;


                case "outcome":
                    if (money >= 0 && amountOfCash >= 0 && money <= amountOfCash) {
                        amountOfCash = amountOfCash - money;
                    } else {
                        System.out.println("Not enough cash");
                        return amountOfCash;
                    }
                    break;
                case "ACCOUNT":
                    System.out.println(amountOfCash);
                    break;

                default:
                    System.out.println("Wrong operation type");
                    return amountOfCash;
            }
            return amountOfCash;
    }

    public String getRaport (){
        return name +" "+ amountOfCash;
    }

    public void wrongPin(){
        System.out.println("Wrong PIN");
        wrongPin++;
        if(wrongPin>=3){
            System.out.println("Account Blocked!!!");
            block=true;

        }
    }

}
