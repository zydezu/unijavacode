package project;

import java.util.HashSet;
import java.util.Set;

public class Project {
    String uid;
    String title;
    Set<String> collaborators = new HashSet<>();

    public Project(String uid, String title) {
        this.uid = uid;
        this.title = title;
    }

    public Set<String> getCollaborators() {
        return collaborators;
    }

    public boolean addCollaborator(String workerID) {
        if (collaborators.contains(workerID)) {
            return false;
        }
        collaborators.add(workerID);
        return true;
    }

    public boolean removeCollaborator(String workerID) {
        if (!collaborators.contains(workerID)) {
            return false;
        }
        collaborators.remove(workerID);
        return true;
    }
}
