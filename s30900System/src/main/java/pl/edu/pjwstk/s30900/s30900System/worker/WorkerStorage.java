package pl.edu.pjwstk.s30900.s30900System.worker;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class WorkerStorage {
    List<Worker> workers = new ArrayList<Worker>();

    public WorkerStorage(List<Worker> workers) {
        this.workers = workers;
        workers.add(new Worker(1, "Bartuś","Chełminiak", "QA Specialist"));
        workers.add(new Worker(2, "Kajtus","Futerkowski", "QA Tester"));
        workers.add(new Worker(3, "Frogtuś","Żabuś", "Junior QA Tester"));
    }

    public List<Worker> getWorkers() {
        return workers;
    }
}
