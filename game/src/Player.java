import java.util.ArrayList;

public class Player {
    private int money;
    private ArrayList<Integer> keys;
    private boolean flashlight;

     static Player player=new Player();
    private Player() {
        money=30;
        keys=new ArrayList<>();
        flashlight=false;
    }
    public static Player getInstance(){
        return player;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public boolean hasFlashlight() {
        return flashlight;
    }

    public void setFlashlight(boolean flashlight) {
        this.flashlight = flashlight;
    }
    public boolean hasKey(int key){
        for (Integer integer : keys) if (integer == key) return true;
        return false;
    }
    public void addKey(int key){
        keys.add(key);
    }
    public void removeKey(int key ){
        if (keys.size()>0)
            for(int i=0;i<keys.size();i++)
                if (keys.get(i)==key) keys.remove(i);
    }

}
