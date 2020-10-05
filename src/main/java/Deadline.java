public class Deadline extends Task {
    protected String dueDate;

    public Deadline(String description) {
        super(description.substring(9, description.indexOf("/") - 1));
        this.dueDate = description.substring(description.indexOf("/") + 4);
    }

    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDate + ")";
    }

    public String formatInput() {
        return "deadline " + description + "/by " + dueDate;
    }


}
