package data;

public class UserBean {

    private String userName;
    private String account;
    private String img;
    private String gender;
    private String hobbies;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }


    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", account='" + account + '\'' +
                ", img='" + img + '\'' +
                ", gender='" + gender + '\'' +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
