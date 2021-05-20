package Controllers;
public class courseTableClass
{
    private int id,creditHours;
    String name,semester;
    double passPercentage,excPercentage;

    public courseTableClass(int id,String name, int creditHours, double passPercentage, double excPercentage, String semester) {
        this.id = id;
        this.name = name;
        this.creditHours = creditHours;
        this.passPercentage = passPercentage;
        this.excPercentage = excPercentage;
        this.semester = semester;



    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getPass_Percentage() {
        return passPercentage;
    }

    public void setPass_Percentage(double pass_Percentage) {
        this.passPercentage = pass_Percentage;
    }

    public double getExcPercentage() {
        return excPercentage;
    }

    public void setExcPercentage(double excPercentage) {
        this.excPercentage = excPercentage;
    }
}