
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        FileReader fileReader=new FileReader("input.txt");
        int noOfRooms=fileReader.read();
        Room []rooms  =new Room[noOfRooms];
        for(int i=0;i<noOfRooms;i++){
            int[] ids =new int[4];

            for(int j=0;j<4;j++){
                int k=fileReader.read();
                ids[j]=k;
            }
            boolean light=false,lightButton=false;
            int f=fileReader.read();
            if (f==1) light=true;
            f=fileReader.read();
            if(f==1) lightButton=true;
            rooms[i]=new Room(i,light,lightButton);
            for(int k=0;k<4;k++){
                System.out.println("sonic");
                switch (ids[k]) {
                    case 0:break;
                    case 1:
                        Seller seller = new Seller(k);
                        int temp = fileReader.read();
                        seller.setBuyPrice(temp);
                        temp = fileReader.read();
                        if (temp != -1) {
                            int key = 0, value;
                            while (key != -1) {
                                key = fileReader.read();
                                if (key == -1) continue;
                                value = fileReader.read();
                                seller.setKeys(key, value);
                            }

                        }
                        temp = fileReader.read();
                        seller.setFlash(temp);
                        rooms[i].sides[k] = seller;
                        break;
                    case 2:
                        Mirror mirror = new Mirror(k);
                        temp = fileReader.read();
                        if (temp == 1) {
                            mirror.setHasKey(true);
                            temp = fileReader.read();
                            mirror.setKey(temp);

                        } else mirror.setHasKey(false);
                        rooms[i].sides[k] = mirror;
                        break;
                    case 3:
                        Paint paint = new Paint(k);
                        temp = fileReader.read();
                        if (temp == 1) {
                            paint.setHasKey(true);
                            temp = fileReader.read();
                            paint.setKey(temp);

                        } else paint.setHasKey(false);
                        rooms[i].sides[k] = paint;
                        break;
                    case 4:
                        Door door = new Door(k);
                        temp = fileReader.read();
                        door.setKey(temp);
                        temp = fileReader.read();
                        door.setConnectedTo(temp);
                        break;
                    case 5:
                        Chest chest = new Chest(k);
                        temp = fileReader.read();
                        chest.setKey(temp);
                        temp = 0;
                        while (temp != -1) {
                            temp = fileReader.read();
                            if (temp != -1) chest.addKey(temp);
                        }
                         temp = fileReader.read();
                        chest.setMoney(temp);
                        temp = fileReader.read();
                        chest.setFlashlight(temp);
                        break;

                }
            }

        }
        /**start play */
        int noOfMoves=0;
        int worstNumberOfMoves=150;
        String [] dir={"south","east","north","west"};
        int currentDir=0;
        while (noOfMoves<worstNumberOfMoves){
            Scanner in =new Scanner(System.in);


        }

        if (noOfMoves==150) System.out.println("you lost");else System.out.println("congrats you won");





    }

}
