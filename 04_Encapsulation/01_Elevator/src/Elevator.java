public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return this.currentFloor;
    }

    public void moveDown() {
        this.currentFloor = this.currentFloor > minFloor ? this.currentFloor - 1 : this.currentFloor;
    }

    public void moveUp() {
        this.currentFloor = this.currentFloor < maxFloor ? this.currentFloor + 1 : this.currentFloor;
    }

    public void move(int floor) {
        if ((floor < this.minFloor) | (floor > this.maxFloor)) {
            System.out.println("Wrong floor");
        }
        else {
            if (this.currentFloor < floor) {
                while (this.currentFloor < floor) {
                    moveUp();
                    System.out.println("Floor " + this.currentFloor);
                }
            }
            else if (this.currentFloor > floor) {
                while (this.currentFloor > floor) {
                    moveDown();
                    System.out.println("Floor " + this.currentFloor);
                }
            }
        }
    }
}
