package data;

public class LoginBean {

    private String fig;
    private String msg;


    public LoginBean(String fig, String msg) {
        this.fig = fig;
        this.msg = msg;
    }

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
