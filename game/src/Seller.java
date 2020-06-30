import java.util.ArrayList;
import java.util.Scanner;

public class Seller implements Side {

    private int buyPrice;
    private ArrayList<Integer> keys ;
    private ArrayList<Integer> values ;
    private int flash;
    private int side;

    public Seller(int side) {
        this.side=side;
        keys=new ArrayList<>();
        values=new ArrayList<>();
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    public void setKeys(int key, int value) {
        keys.add(key);
        values.add(value);
    }

    public void setFlash(int f) {
        flash = f;

    }


    public int getBuyPrice() {
        return buyPrice;
    }

    public boolean hasFlash() {
        return flash!=-1;
    }
    public int hasKey(int key){
        if (keys.size()==0) return -1;
        for(int i=0;i<keys.size();i++){
            if (keys.get(i)==key) return i;
        }
        return -1;
    }
    public void printList() {
        if (keys.size() > 0) {
            for (int i = 0; i < keys.size(); i++)
                System.out.println("the key i have is " + keys.get(i) + "and the price is " + values.get(i));
        } else System.out.println("I have no keys");
        if (hasFlash()) System.out.println("also i have flashlight and the it's price is "+flash );
    }

    public void sell(int key) {
        if (Player.getInstance().hasKey(key)) {
            System.out.println("I bought the key "+key +" from you for "+buyPrice+" $");
            Player.getInstance().addMoney(buyPrice);

        }else {
            System.out.println("sorry you don't have the key");

        }


    }

    public void buy(int key) {
        if (hasKey(key)!=-1 && Player.getInstance().getMoney()>values.get(hasKey(key))){
            System.out.println("You bought the key successfully :D ");
            Player.getInstance().addMoney(-1*values.get(hasKey(key)));
            Player.getInstance().addKey(key);

        }

    }
    public void buyFlash(){
        if (hasFlash())
        if (Player.getInstance().getMoney() >= flash ){
            Player.getInstance().setFlashlight(true);
            Player.getInstance().addMoney(-1*flash);
            System.out.println("you bought the flashlight :D");

        }else System.out.println("sorry you don't have enough money ");
    }


    @Override
    public int use() {
        Scanner in =new Scanner(System.in);
        boolean stay=true;
        while(stay) {
            System.out.println("please enter what you want to do ");
            System.out.println("List : l/L");
            System.out.println("Buy : b/B");
            System.out.println("Sell :  s/S");
            System.out.println("buy Flashlight : f/F");
            System.out.println("exit : e/E");
            char input = in.next().charAt(0);
            if (input <= 'A') input += 32;
            switch (input) {
                case 'l':
                    printList();
                    break;
                case 'b':
                    System.out.println("please enter the id for the key you want to buy");
                    int k=in.nextInt();
                    buy(k);
                    break;
                case 's':
                    System.out.println("please enter the key you want to sell");
                    k=in.nextInt();
                    sell(k);
                    break;
                case 'f':
                    buyFlash();
                    break;
                case 'e':
                    stay=false;
                    break;
            }

        }
        return -1;

    }
}
