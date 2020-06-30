public class Room {
    public Side[] sides;
    private int id ;
    private boolean lightOn;
    private boolean hasLightButton;

    public boolean canWalk() {
        return lightOn;
    }

    public void setLightOn(boolean lightOn) {
        this.lightOn = lightOn;
    }

    public boolean isHasLightButton() {
        return hasLightButton;
    }

    public void setHasLightButton(boolean hasLightButton) {
        this.hasLightButton = hasLightButton;
    }

    public Room(int id,boolean lightOn,boolean hasLightButton){
        sides=new Side[4];
        this.id=id;
        this.hasLightButton=hasLightButton;
        this.lightOn=lightOn;
    }




}
