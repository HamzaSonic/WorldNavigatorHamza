import java.util.Scanner;

public class Paint  implements Dircoverable,Side {

    private int key;
    private int side;
    private boolean hasKey;


    public Paint(int side) {
        this.side=side;
    }


    @Override
    public String toString() {
        return "What a nice painting ";
    }

    @Override
    public boolean check() {
        return hasKey;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    @Override
    public void getKey() {
        if (hasKey) Player.getInstance().addKey(key);
        else System.out.println("Nothing behind the painting");

    }

    @Override
    public int use() {
        System.out.println(toString());
        System.out.println("check the painting y/n");
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
