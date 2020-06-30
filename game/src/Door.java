import java.util.Scanner;

public class Door  implements Openable,Side {
    private int key;
    private int connectedTo;
    private int side;

    public Door(int side) {
        this.side=side;
    }
    public void setKey(int key){
        this.key=key;
    }
    public void setConnectedTo(int id ){
        connectedTo=id;
    }

    public int getKey() {
        return key;
    }

    public int getConnectedTo() {
        return connectedTo;
    }

    @Override
    public boolean isOpen() {
        return key == -1;
    }

    @Override
    public void open(boolean key) {
        if (key)  {
            this.key=-1;
            System.out.println("Door Opened :D");

        }
        else System.out.println("You don't have the key please find it :(");



    }

    @Override
    public int use() {
        System.out.println("let me check this door :O");
        if (getKey()!= -1){
            System.out.println("the door is locked let me check if i have the key ");
            open(Player.getInstance().hasKey(getKey())) ;
        }else System.out.println("the door is already opened");
        System.out.println("do you want to go through this door ? y/n");
        Scanner in =new Scanner(System.in);
        char inp =in.next().charAt(0);
        if (inp=='y') return getConnectedTo();else return -1;
    }
}
