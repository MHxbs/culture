package team.redrock.culture.entity;

public class User {

    private String openid;
    private String nickname;
    private int sex;
    private String headimgurl;
    private int personalAmount;
    private int leftTimes;
    private String college;

    public int getPersonalAmount() {
        return personalAmount;
    }

    public void setPersonalAmount(int personalAmount) {
        this.personalAmount = personalAmount;
    }

    public int getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(int leftTimes) {
        this.leftTimes = leftTimes;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }
}
