package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Department {
    String name;
    Map<String, Worker> workers;
    Map<String, Project> projects;

    public Department(String name) {
        this.name = name;
        workers = new HashMap<>();
        projects = new HashMap<>();
    }

    public Worker getWorker(String uid) throws InvalidIDException {
        if (workers.containsKey(uid)) {
            return workers.get(uid);
        }
        throw new InvalidIDException("No worker with ID: " + uid + " exists.");
    }

    public Project getProject(String uid) throws InvalidIDException {
        if (projects.containsKey(uid)) {
            return projects.get(uid);
        }
        throw new InvalidIDException("No project with ID: " + uid + " exists.");
    }

    public Project createProject(String uid, String title) throws InvalidIDException {
        if (projects.containsKey(uid)) {
            throw new InvalidIDException("A project with ID: " + uid + " already exists.");
        }
        Project newProject = new Project(uid, title);
        projects.put(uid, newProject);
        return newProject;
    }

    public Worker createWorker(String uid, String name) throws InvalidIDException {
        if (workers.containsKey(uid)) {
            throw new InvalidIDException("A worker with ID: " + uid + " already exists.");
        }
        Worker newWorker = new Worker(uid, name);
        workers.put(uid, newWorker);
        return newWorker;
    }

    public Project addCollaborator(String pID, String wID) throws InvalidIDException {
        if (!workers.containsKey(wID) || !projects.containsKey(pID)) {
            throw new InvalidIDException("A worker/project specified doesn't exist");
        }
        Project currentProject = projects.get(pID);
        Worker currentWorker = workers.get(wID);
        currentProject.addCollaborator(wID);
        currentWorker.addProject(pID);
        return currentProject;
    }

    public Set<String> getConnectionCircle(String wID) throws InvalidIDException {
        Set<String> connections = new HashSet<>();
        Worker currentWorker = getWorker(wID);
        List<String> projectsToLookAt = new ArrayList<>();
        List<String> workersSeen = new ArrayList<>();
        List<String> projectsSeen = new ArrayList<>();

        currentWorker.projects.forEach((project) -> {
            projectsToLookAt.add(project);
        });
        while (!projectsToLookAt.isEmpty()) {
            String currentProject = projectsToLookAt.get(0);
            projectsToLookAt.remove(0);
            List<String> workersToLookAt = new ArrayList<>();
            getProject(currentProject).collaborators.forEach((worker) -> {
                if (!workersSeen.contains(worker)) {
                    connections.add(worker);
                    workersToLookAt.add(worker);
                }
            });
            while (!workersToLookAt.isEmpty()) {
                currentWorker = getWorker(workersToLookAt.get(0));
                workersToLookAt.remove(0);
                currentWorker.projects.forEach((project) -> {
                    if (!projectsSeen.contains(project)) {
                        projectsToLookAt.add(project);
                        projectsSeen.add(project);
                    }
                });
            }
        }

        return connections;
    }

    public static void main(String[] args) throws InvalidIDException {
        Department department = new Department("My company");
        department.createWorker("1", "Dave");
        department.createWorker("2", "Bob");
        department.createWorker("3", "Jill");
        department.createWorker("4", "Boy");
        department.createWorker("9", "booo");
        department.createWorker("10", "boooooy");
        department.createProject("1", "Epic");
        department.createProject("2", "bbborag");
        department.createProject("3", "aaaaa");
        department.createProject("5", "akakak");
        department.addCollaborator("1", "1");
        department.addCollaborator("2", "2");
        department.addCollaborator("2", "3");
        department.addCollaborator("1", "2");
        department.addCollaborator("5", "2");
        department.addCollaborator("5", "9");
        department.addCollaborator("5", "10");
        // System.err.println(department.getWorker("1").getProjects());

        System.err.println(department.getConnectionCircle("1"));
    }
}
