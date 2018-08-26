package team.redrock.culture.domain;

public enum ResultEnum {
    SUCCESS(200,"成功"),SERVERERRO(500,"服务器错误"),
    PARAERRO(100,"参数错误"),WRONGANSWER(101,"答案错误"),
    EMPTYTIMES(102,"次数已经用完");

    private final int status;
    private final String msg;

    ResultEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
