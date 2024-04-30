package project;

import java.util.HashSet;
import java.util.Set;

public class Worker {
    String uid;
    String name;
    Set<String> projects = new HashSet<>();

    public Worker(String uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public Set<String> getProjects() {
        return projects;
    }

    public boolean addProject(String projectID) {
        if (projects.contains(projectID)) {
            return false;
        }
        projects.add(projectID);
        return true;
    }

    public boolean removeProject(String projectID) {
        if (!projects.contains(projectID)) {
            return false;
        }
        projects.remove(projectID);
        return true;
    }
}