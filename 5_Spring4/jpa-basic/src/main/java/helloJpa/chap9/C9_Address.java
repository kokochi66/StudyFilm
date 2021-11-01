package helloJpa.chap9;

import javax.persistence.Embeddable;

@Embeddable
public class C9_Address {
    private  String city;
    private String street;
    private String zipcode;

    public C9_Address() {

    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
