package user;

public class User {
    public Integer userId;
    public String name;
    public String email;
    public String status;
    public String last_updated;
    public String created_at;

    public User(Integer userId, String name, String email, String status, String last_updated, String created_at) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.status = status;
        this.last_updated = last_updated;
        this.created_at = created_at;
    }
    public User(){}

}
