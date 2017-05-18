public class Client {
    private String name;
    private String PIN;
    private float money;// 1000 reszta to operacje
    private String operation;

    float CashForStart = 1000;
    float amountOfCash;

    public Client(String name, String PIN, float money, String operation) {
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

    public float getMoney() {return money;}


    public float operations() {
        switch (operation) {
            case "income":
                amountOfCash = CashForStart + money;
                break;

            case "outcome":
                amountOfCash = CashForStart - money;
                break;

            default:
                System.out.println("Wrong operation type");
                break;
        }
        return amountOfCash;
    }

    public String getRaport (){
        return name +" "+ amountOfCash;
    }




}
