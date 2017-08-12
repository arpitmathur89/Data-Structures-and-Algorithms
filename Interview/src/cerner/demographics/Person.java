package cerner.demographics;

public class Person {

    private String name;
    private Address address;
    private int phoneNo;
    private Gender gender;

    public Person(String name, Address address, int phoneNo, Gender gender) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
