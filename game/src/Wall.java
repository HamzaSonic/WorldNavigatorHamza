public class Wall implements Side{

    private int side;
    public Wall(int side) {
        this.side=side;
    }

    @Override
    public String toString() {
        return "Plain Wall! what a waste of time :(";
    }

    @Override
    public int use() {
        System.out.println(toString());
        return -1;
    }
}
