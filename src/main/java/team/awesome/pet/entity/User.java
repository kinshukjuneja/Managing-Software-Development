package team.awesome.pet.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;
    private long phone;
    private String email;
    private String address;
    private List<Pet> claimPets;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        claimPets = new ArrayList<>();
    }

    public User() {}

    /**
     * @return the id
     */
    public int getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param password the password to set
     */
    public void setShelter(String password) {
        this.password = password;
    }


    /**
     *
     * @return the phone
     */
    public Long getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(Long phone) {
        this.phone = phone;
    }

    /**
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return list of claimPets
     */
    public List<Pet> getClaimPets() {
        return claimPets;
    }

    /**
     * @param pet the pet claimed by user are added
     */
    public void addClaimPets(Pet pet) {
       claimPets.add(pet);
    }
}


