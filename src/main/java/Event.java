public class Event extends Task{
    protected String date;

    public Event(String description) {
        super(description.substring(6, description.indexOf("/") - 1));
        this.date = description.substring(description.indexOf("/") + 4);
    }

    public String toString() {
        return "[E]" + super.toString() + " (at: " + date + ")";
    }

    public String inputFormat() {
        return "event " + description + "/at " + date;
    }
}
