public class Aircraft {

    private String model;
    private String type;
    private int speed = 800;

    public Aircraft(String model, String type) {
        this.model = model;
        this.type = type;
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
