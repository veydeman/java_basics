public class Aircraft {

    private String model;
    private String type;
    private int speed;

    public Aircraft(String model, String type, int speed) {
        this.model = model;
        this.type = type;
        this.speed = speed;
    }

    public String getModel() {
        return this.model;
    }

    public String getType() {
        return this.type;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
