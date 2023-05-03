package RMIAPI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public abstract class ProjectManagement implements Remote {
    public abstract void createProject(String projectName, String projectDescription, String projectManager) throws RemoteException;
    public abstract void updateProjectStatus(String projectName, String newStatus) throws RemoteException;
    public abstract ArrayList<Project> getProjects() throws RemoteException;

    private class Project {
        public Object getName() {
            return null;
        }
    }
}

