package team.awesome.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userID;
  @Column(name = "user_name")
  private String userName;
  @Column(name = "password")
  private String password;
  // Will need a field for confirm_password here?
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "phone")
  private long phone;
  @Column(name = "email")
  private String email;
  @Column(name = "address")
  private String address;

  public User() {}

  public User(int id, String name, String password, String firstName, String lastName, long phone,
      String email, String address) {
    super();
    this.userID = id;
    this.userName = name;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.address = address;
  }

  public int getId() {
    return this.userID;
  }

  public void setId(int id) {
    this.userID = id;
  }

  public String getUsername() {
    return this.userName;
  }

  public void setUsername(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public long getPhone() {
    return this.phone;
  }

  public void setPhone(long phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

}


