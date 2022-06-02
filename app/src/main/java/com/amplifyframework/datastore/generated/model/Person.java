package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Person type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "People", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Person implements Model {
  public static final QueryField ID = field("Person", "id");
  public static final QueryField USERNAME = field("Person", "Username");
  public static final QueryField EMAIL = field("Person", "Email");
  public static final QueryField LAST_NAME = field("Person", "LastName");
  public static final QueryField FIRST_NAME = field("Person", "FirstName");
  public static final QueryField PHONE_NUMBER = field("Person", "PhoneNumber");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Username;
  private final @ModelField(targetType="AWSEmail", isRequired = true) String Email;
  private final @ModelField(targetType="String", isRequired = true) String LastName;
  private final @ModelField(targetType="String", isRequired = true) String FirstName;
  private final @ModelField(targetType="BusinessAddressPerson") @HasMany(associatedWith = "person", type = BusinessAddressPerson.class) List<BusinessAddressPerson> businessaddresss = null;
  private final @ModelField(targetType="AWSPhone", isRequired = true) String PhoneNumber;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getUsername() {
      return Username;
  }
  
  public String getEmail() {
      return Email;
  }
  
  public String getLastName() {
      return LastName;
  }
  
  public String getFirstName() {
      return FirstName;
  }
  
  public List<BusinessAddressPerson> getBusinessaddresss() {
      return businessaddresss;
  }
  
  public String getPhoneNumber() {
      return PhoneNumber;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Person(String id, String Username, String Email, String LastName, String FirstName, String PhoneNumber) {
    this.id = id;
    this.Username = Username;
    this.Email = Email;
    this.LastName = LastName;
    this.FirstName = FirstName;
    this.PhoneNumber = PhoneNumber;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Person person = (Person) obj;
      return ObjectsCompat.equals(getId(), person.getId()) &&
              ObjectsCompat.equals(getUsername(), person.getUsername()) &&
              ObjectsCompat.equals(getEmail(), person.getEmail()) &&
              ObjectsCompat.equals(getLastName(), person.getLastName()) &&
              ObjectsCompat.equals(getFirstName(), person.getFirstName()) &&
              ObjectsCompat.equals(getPhoneNumber(), person.getPhoneNumber()) &&
              ObjectsCompat.equals(getCreatedAt(), person.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), person.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUsername())
      .append(getEmail())
      .append(getLastName())
      .append(getFirstName())
      .append(getPhoneNumber())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Person {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Username=" + String.valueOf(getUsername()) + ", ")
      .append("Email=" + String.valueOf(getEmail()) + ", ")
      .append("LastName=" + String.valueOf(getLastName()) + ", ")
      .append("FirstName=" + String.valueOf(getFirstName()) + ", ")
      .append("PhoneNumber=" + String.valueOf(getPhoneNumber()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static UsernameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Person justId(String id) {
    return new Person(
      id,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Username,
      Email,
      LastName,
      FirstName,
      PhoneNumber);
  }
  public interface UsernameStep {
    EmailStep username(String username);
  }
  

  public interface EmailStep {
    LastNameStep email(String email);
  }
  

  public interface LastNameStep {
    FirstNameStep lastName(String lastName);
  }
  

  public interface FirstNameStep {
    PhoneNumberStep firstName(String firstName);
  }
  

  public interface PhoneNumberStep {
    BuildStep phoneNumber(String phoneNumber);
  }
  

  public interface BuildStep {
    Person build();
    BuildStep id(String id);
  }
  

  public static class Builder implements UsernameStep, EmailStep, LastNameStep, FirstNameStep, PhoneNumberStep, BuildStep {
    private String id;
    private String Username;
    private String Email;
    private String LastName;
    private String FirstName;
    private String PhoneNumber;
    @Override
     public Person build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Person(
          id,
          Username,
          Email,
          LastName,
          FirstName,
          PhoneNumber);
    }
    
    @Override
     public EmailStep username(String username) {
        Objects.requireNonNull(username);
        this.Username = username;
        return this;
    }
    
    @Override
     public LastNameStep email(String email) {
        Objects.requireNonNull(email);
        this.Email = email;
        return this;
    }
    
    @Override
     public FirstNameStep lastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.LastName = lastName;
        return this;
    }
    
    @Override
     public PhoneNumberStep firstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.FirstName = firstName;
        return this;
    }
    
    @Override
     public BuildStep phoneNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber);
        this.PhoneNumber = phoneNumber;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String username, String email, String lastName, String firstName, String phoneNumber) {
      super.id(id);
      super.username(username)
        .email(email)
        .lastName(lastName)
        .firstName(firstName)
        .phoneNumber(phoneNumber);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder lastName(String lastName) {
      return (CopyOfBuilder) super.lastName(lastName);
    }
    
    @Override
     public CopyOfBuilder firstName(String firstName) {
      return (CopyOfBuilder) super.firstName(firstName);
    }
    
    @Override
     public CopyOfBuilder phoneNumber(String phoneNumber) {
      return (CopyOfBuilder) super.phoneNumber(phoneNumber);
    }
  }
  
}
