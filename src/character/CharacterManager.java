package character;

import base.PrisonSimulation;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class CharacterManager {
    private Set<Worker> workers = new HashSet<>();


    public Set<Worker> getWorkers() {
        return workers;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public void update(Graphics2D g2d) {
        for (Worker worker : PrisonSimulation.characterManager.getWorkers())
            worker.paintComponent(g2d);
    }

}
