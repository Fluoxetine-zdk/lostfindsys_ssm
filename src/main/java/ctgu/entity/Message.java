package ctgu.entity;

import java.sql.Date;

public class Message {
    private int id;
    private String username;
    private String description;
    private int class_message;
    private String address;
    private int bastus;
    private int reward;
    private String createdate;

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", class_message=" + class_message +
                ", address='" + address + '\'' +
                ", bastus=" + bastus +
                ", reward=" + reward +
                ", createdate='" + createdate + '\'' +
                '}';
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getClass_message() {
        return class_message;
    }

    public void setClass_message(int class_message) {
        this.class_message = class_message;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBastus() {
        return bastus;
    }

    public void setBastus(int bastus) {
        this.bastus = bastus;
    }
}
