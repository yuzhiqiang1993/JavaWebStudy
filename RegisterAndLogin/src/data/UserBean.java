package data;

import java.util.List;

public class UserBean {


    private String account;
    private String pwd;
    private String img;
    private String gender;
    private List<String> hobbies;


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", img='" + img + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
