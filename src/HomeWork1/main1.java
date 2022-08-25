package HomeWork1;

import HomeWork1.obstacle.Obstacle;
import HomeWork1.obstacle.RunTrack;
import HomeWork1.obstacle.Wall;
import HomeWork1.participants.Cat;
import HomeWork1.participants.Human;
import HomeWork1.participants.Participants;
import HomeWork1.participants.Robot;

public class main1 {
    public static void main(String[] args) {
        Participants[] participants = {
                new Cat("Miles", 1000, 3),
                new Cat("Jones", 3200, 5),
                new Human("Robert", 3000, 1),
                new Human("Nikola", 4200, 0),
                new Robot("IDE21", 5000, 0),
                new Robot("AXX24", 6000, 0)
        };

        Obstacle[] obstacles = {
                new RunTrack(2500),
                new Wall(1)
        };

        for (Participants participant : participants) {
            for (Obstacle obstacle : obstacles) {
                obstacle.passTheObstacle(participant);
                if (!participant.isOnDistance()) {
                    break;
                }
            }
        }
    }
}
