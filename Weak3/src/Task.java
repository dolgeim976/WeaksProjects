public class Task {
    private final String description;
    private final int priority;
    private final StatusTask status;

    public Task(String description, int priority, StatusTask status) {
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public StatusTask getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "description='" + description + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}
