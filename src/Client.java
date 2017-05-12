public class Client {
    private String name;
    private String PIN;
    private float money;// 1000 reszta to operacje

    public Client(String name, String PIN, float money) {
        this.name = name;
        this.PIN = PIN;
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public String getPIN() {
        return PIN;
    }

    public float getMoney() {

        return money;
    }
    public void wyplac(int kwota){
        if(kwota>money) {
            System.out.println("Nie masz wystarczająco środków na koncie!");
            return;
        }
        money= money - kwota;
        System.out.println("Wypłaciłeś: "+ kwota);
        System.out.println("Twoje saldo wynosi: "+money);
    }

    public void wplac(int kwota){
        if(kwota<=0) {
            System.out.println("Nie możesz wpłacić ujemnej wartości!");
            return;
        }
        money= money+kwota;
        System.out.println("Wpłaciłeś: "+ kwota);
        System.out.println("Twoje saldo wynosi: "+money);
    }

}
