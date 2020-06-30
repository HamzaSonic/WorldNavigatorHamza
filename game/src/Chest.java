import java.util.ArrayList;
import java.util.Scanner;

public class Chest implements Openable,Side {
    private int key;
    private ArrayList<Integer> keys;
    private int money;
    private boolean flashlight;
    private int side;


    public Chest(int side) {
        this.side=side;
        keys=new ArrayList<>();

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void getMoney() {
        Player.getInstance().addMoney(money);
        money=0;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean hasFlashlight() {
        return flashlight;
    }

    public void setFlashlight(int flashlight) {
        this.flashlight= flashlight != -1;
    }
    public void addKey(int key){
        keys.add(key);
    }
    public void getKeys(){
        for(int i=0;i<keys.size();i++){
            Player.getInstance().addKey(keys.get(i));

        }
        keys.clear();
        System.out.println("congrats you got the keys check your list :D");
    }

    @Override
    public boolean isOpen() {
        return key==-1;
    }

    @Override
    public void open(boolean key) {

        if (key)  {
            this.key=-1;
            System.out.println("chest Opened :D");

        }
        else System.out.println("You don't have the key please find it :(");

    }

    @Override
    public int use() {
        System.out.println("let me check this chest? y/n");
        Scanner in =new Scanner(System.in);
        char chest =in.next().charAt(0);
        if (chest=='y') {
            if (isOpen()) {
                System.out.println("the chest is open let me collect the items");
                getKeys();
                getMoney();
                System.out.println("success");
            }else {
                System.out.println("let me check the key ");
                int kk = getKey();
                open(Player.getInstance().hasKey(kk));
                System.out.println("I opened the chest let me collect the items");
                getMoney();
                getKeys();
                System.out.println("success :D");

            }
        }

        return -1;
    }
}
