import java.io.Serializable;

public class Project implements Serializable {

    private String name;
    private String description;
    private String manager;
    private String status;

    public Project(String name, String description, String manager) {
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.status = "Created";
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getManager() {
        return manager;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
