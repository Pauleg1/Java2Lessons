package HomeWork1.obstacle;

import HomeWork1.participants.Participants;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void passTheObstacle(Participants participants) {
        participants.heightJump(height);
    }
}
