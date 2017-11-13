package team.awesome.pet.model;

import lombok.Builder;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents an user
 *
 */
@Builder
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

  /**
   * Create an user using the required fields: id, username, password, first name, last name, phone,
   * email and address
   *
   * @param id the id of an user
   * @param name the name of an user
   * @param password the password of an user
   * @param firstName the first name of an user
   * @param lastName the last name of an user
   * @param phone the phone of an user
   * @param email the email of an user
   * @param address the address of an user
   */
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

  /**
   *
   * @return the id of an user
   */
  public int getId() {
    return this.userID;
  }

  /**
   *
   * @param id the id of an user to be set
   */
  public void setId(int id) {
    this.userID = id;
  }

  /**
   *
   * @return the username of an user
   */
  public String getUsername() {
    return this.userName;
  }

  /**
   *
   * @param userName the username of an user to be set
   */
  public void setUsername(String userName) {
    this.userName = userName;
  }

  /**
   *
   * @return the password of an user
   */
  public String getPassword() {
    return this.password;
  }

  /**
   *
   * @param password the password of an user to be set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   *
   * @return the first name of an user
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   *
   * @param firstName the first name of an user to be set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   *
   * @return the last name of an user
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   *
   * @param lastName the last name of an user to be set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   *
   * @return the phone of an user
   */
  public long getPhone() {
    return this.phone;
  }

  /**
   *
   * @param phone the phone of an user to be set
   */
  public void setPhone(long phone) {
    this.phone = phone;
  }

  /**
   *
   * @return the email of an user
   */
  public String getEmail() {
    return this.email;
  }

  /**
   *
   * @param email the email of an user to be set
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   *
   * @return the address of an user
   */
  public String getAddress() {
    return this.address;
  }

  /**
   *
   * @param address the address of an user to be set
   */
  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{" +
            "userID=" + userID + ", " +
            "userName='" + userName + '\'' + ", " +
            "password='" + password + '\'' + ", " +
            "firstName='" + firstName + '\'' + ", " +
            "lastName='" + lastName + '\'' + ", " +
            "phone=" + phone + ", " +
            "email='" + email + '\'' + ", " +
            "address='" + address + '\'' +
            '}';
  }
}


