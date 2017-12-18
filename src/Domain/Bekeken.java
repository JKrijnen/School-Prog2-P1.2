package Domain;


public class Bekeken {
    private int memberNumber;
    private String userName;
    private int seen;
    private int percentage;

    public Bekeken(int membernumber, String userName, int seen, int percentage) {
        this.memberNumber = membernumber;
        this.userName = userName;
        this.seen = seen;
        this.percentage = percentage;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSeen() {
        return seen;
    }

    public void setSeen(int seen) {
        this.seen = seen;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
