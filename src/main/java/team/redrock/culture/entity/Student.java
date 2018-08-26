package team.redrock.culture.entity;

public class Student {
    private String openID;
    private String stuID;
    private String college;
    private int clazzID;

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getClazzID() {
        return clazzID;
    }

    public void setClazzID(int clazzID) {
        this.clazzID = clazzID;
    }
}
