package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the BusinessAddressPerson type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "BusinessAddressPeople")
@Index(name = "byPerson", fields = {"personID"})
@Index(name = "byBusinessAddress", fields = {"businessAddressID"})
public final class BusinessAddressPerson implements Model {
  public static final QueryField ID = field("BusinessAddressPerson", "id");
  public static final QueryField PERSON = field("BusinessAddressPerson", "personID");
  public static final QueryField BUSINESS_ADDRESS = field("BusinessAddressPerson", "businessAddressID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="Person", isRequired = true) @BelongsTo(targetName = "personID", type = Person.class) Person person;
  private final @ModelField(targetType="BusinessAddress", isRequired = true) @BelongsTo(targetName = "businessAddressID", type = BusinessAddress.class) BusinessAddress businessAddress;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Person getPerson() {
      return person;
  }
  
  public BusinessAddress getBusinessAddress() {
      return businessAddress;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private BusinessAddressPerson(String id, Person person, BusinessAddress businessAddress) {
    this.id = id;
    this.person = person;
    this.businessAddress = businessAddress;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      BusinessAddressPerson businessAddressPerson = (BusinessAddressPerson) obj;
      return ObjectsCompat.equals(getId(), businessAddressPerson.getId()) &&
              ObjectsCompat.equals(getPerson(), businessAddressPerson.getPerson()) &&
              ObjectsCompat.equals(getBusinessAddress(), businessAddressPerson.getBusinessAddress()) &&
              ObjectsCompat.equals(getCreatedAt(), businessAddressPerson.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), businessAddressPerson.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getPerson())
      .append(getBusinessAddress())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("BusinessAddressPerson {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("person=" + String.valueOf(getPerson()) + ", ")
      .append("businessAddress=" + String.valueOf(getBusinessAddress()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static PersonStep builder() {
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
  public static BusinessAddressPerson justId(String id) {
    return new BusinessAddressPerson(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      person,
      businessAddress);
  }
  public interface PersonStep {
    BusinessAddressStep person(Person person);
  }
  

  public interface BusinessAddressStep {
    BuildStep businessAddress(BusinessAddress businessAddress);
  }
  

  public interface BuildStep {
    BusinessAddressPerson build();
    BuildStep id(String id);
  }
  

  public static class Builder implements PersonStep, BusinessAddressStep, BuildStep {
    private String id;
    private Person person;
    private BusinessAddress businessAddress;
    @Override
     public BusinessAddressPerson build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new BusinessAddressPerson(
          id,
          person,
          businessAddress);
    }
    
    @Override
     public BusinessAddressStep person(Person person) {
        Objects.requireNonNull(person);
        this.person = person;
        return this;
    }
    
    @Override
     public BuildStep businessAddress(BusinessAddress businessAddress) {
        Objects.requireNonNull(businessAddress);
        this.businessAddress = businessAddress;
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
    private CopyOfBuilder(String id, Person person, BusinessAddress businessAddress) {
      super.id(id);
      super.person(person)
        .businessAddress(businessAddress);
    }
    
    @Override
     public CopyOfBuilder person(Person person) {
      return (CopyOfBuilder) super.person(person);
    }
    
    @Override
     public CopyOfBuilder businessAddress(BusinessAddress businessAddress) {
      return (CopyOfBuilder) super.businessAddress(businessAddress);
    }
  }
  
}
