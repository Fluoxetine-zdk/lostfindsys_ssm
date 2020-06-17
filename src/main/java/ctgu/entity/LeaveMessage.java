package ctgu.entity;

public class LeaveMessage {
    private int id;
    private String username;
    private String leavetime;
    private String leavemessage;
    private int msgid;

    @Override
    public String toString() {
        return "LeaveMessage{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", leavetime='" + leavetime + '\'' +
                ", leavemessage='" + leavemessage + '\'' +
                ", msgid=" + msgid +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLeavetime() {
        return leavetime;
    }

    public void setLeavetime(String leavetime) {
        this.leavetime = leavetime;
    }

    public String getLeavemessage() {
        return leavemessage;
    }

    public void setLeavemessage(String leavemessage) {
        this.leavemessage = leavemessage;
    }

    public int getMsgid() {
        return msgid;
    }


}
