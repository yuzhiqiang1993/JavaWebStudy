package data;

public class LoginResponse {

    /*状态  0表示成功 否则表示失败*/
    private String fig;
    /*信息*/
    private String msg;

    public String getFig() {
        return fig;
    }

    public void setFig(String fig) {
        this.fig = fig;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
