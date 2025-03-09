package pl.edu.pjwstk.s30900.s30900System.worker;

import org.springframework.stereotype.Service;

@Service
public class WorkerService {
    private final WorkerStorage workerStorage;

    public WorkerService(WorkerStorage workerStorage) {
        this.workerStorage = workerStorage;
    }

    public Worker findByWorkerID(int workerID) {
        Worker selectedWorker = null;
        for (Worker worker : workerStorage.getWorkers()) {
            if (worker.getWorkerID() == workerID) {
                selectedWorker = worker;
            }
        }
        if (selectedWorker == null) {
            throw new RuntimeException("No worker with ID " + workerID + " found");
        }
        return selectedWorker;
    }
}
