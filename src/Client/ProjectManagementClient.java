package Client;

import RMIAPI.ProjectManagement;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectManagementClient {

    public static void main(String[] args) throws Exception {
        ProjectManagement projectManagement = (ProjectManagement) Naming.lookup("//localhost/projectManagement");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Create Project");
            System.out.println("2. Update Project Status");
            System.out.println("3. Get All Projects");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter project name: ");
                    String projectName = scanner.nextLine();
                    System.out.print("Enter project description: ");
                    String projectDescription = scanner.nextLine();
                    System.out.print("Enter project manager: ");
                    String projectManager = scanner.nextLine();
                    projectManagement.createProject(projectName, projectDescription, projectManager);
                    break;
                case 2:
                    System.out.print("Enter project name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new project status: ");
                    String status = scanner.nextLine();
                    projectManagement.updateProjectStatus(name, status);
                    break;
                case 3:
                    ArrayList<Project> projects = (ArrayList<Project>) projectManagement.getProjects();
                    System.out.println("All Projects: ");
                    for (Project project : projects) {
                        System.out.println(project.getName() + ", " + project.getDescription() + ", " + project.getManager() + ", " + project.getStatus());
                    }
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

