package server;

import RMIAPI.ProjectManagement;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class ProjectManagementServer extends UnicastRemoteObject implements  ProjectManagement {

    private ArrayList<Project> projects = new ArrayList<>();

    protected ProjectManagementServer() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("//localhost/projectManagement", new ProjectManagementServer());
        System.out.println("Server is running...");
    }

    @Override
    public void createProject(String projectName, String projectDescription, String projectManager) throws RemoteException {
        Project project = new Project(projectName, projectDescription, projectManager);
        projects.add(project);
    }

    @Override
    public void updateProjectStatus(String projectName, String newStatus) throws RemoteException {
        for (Project project : projects) {
            if (project.getName().equals(projectName)) {
                project.setStatus(newStatus);
                break;
            }
        }
    }

    @Override
    public ArrayList<Project> getProjects() throws RemoteException {
        return projects;
    }
}

