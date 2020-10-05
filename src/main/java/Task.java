public class Task { //
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /*
    Returns tick or X symbols depending on whether task is done or not
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /*
    Marks task as done
     */
    public void markDone() {
        isDone = true;
    }


    public String toString() {
        return ("[" + this.getStatusIcon() + "] " + description);
    }

    public String getDescription() {
        return description;
    }


    /*
    Placeholder function. Formats the class based on the type, so can add back to list from saved file
     */
    public String formatInput() {
        return "";
    }


}