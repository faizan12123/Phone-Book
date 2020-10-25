// Author: Faizan Hussain
public class PersonClass {
    private PersonClass left;
    private PersonClass right;
    private String phoneNumber;
    private String name;
    public PersonClass(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void setLeft(PersonClass left) {
        this.left = left;
    }
    public void setRight(PersonClass right) {
        this.right = right;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public PersonClass getLeft() {
        return left;
    }
    public PersonClass getRight() {
        return right;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}