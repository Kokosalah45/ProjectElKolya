package Controllers;

public class assignmentsTableClass {
    int id,course_id;
    String deadline,title;

    public assignmentsTableClass(int id, int course_id, String deadline, String title) {
        this.id = id;
        this.course_id = course_id;
        this.deadline = deadline;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
