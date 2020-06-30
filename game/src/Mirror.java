import java.util.Scanner;

public class Mirror   implements Dircoverable,Side{

    private boolean hasKey;
    private int key;
    private int side;

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Mirror(int side) {
        this.side=side;
    }


    @Override
    public String toString() {
        return "I see my silhouette";
    }

    @Override
    public boolean check() {
        return hasKey;
    }

    @Override
    public void getKey() {
        if (hasKey) Player.getInstance().addKey(key); else System.out.println("Nothing behind the mirror");

    }

    @Override
    public int use() {
        System.out.println(toString());
        System.out.println("check the mirror y/n");
        Scanner in =new Scanner(System.in);
        char input =in.next().charAt(0);
        if (input=='y'){
            boolean keyP=check();
            if(keyP){
                System.out.println("I found a key");
                getKey();
            }else System.out.println("no keys, what a waste of time :(");
        }
        return -1;
    }
}
