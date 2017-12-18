package Domain;

public class Profile {
private int memberNumber;
private String name;
private String birthDate;

    public Profile(int memberNumber, String name, String birthDate) {
        this.memberNumber = memberNumber;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
