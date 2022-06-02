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

/** This is an auto generated class representing the BusinessAddress type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "BusinessAddresses", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class BusinessAddress implements Model {
  public static final QueryField ID = field("BusinessAddress", "id");
  public static final QueryField ADDRESS = field("BusinessAddress", "Address");
  public static final QueryField CITY = field("BusinessAddress", "City");
  public static final QueryField STATE = field("BusinessAddress", "State");
  public static final QueryField ZIP = field("BusinessAddress", "Zip");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Address;
  private final @ModelField(targetType="String", isRequired = true) String City;
  private final @ModelField(targetType="String", isRequired = true) String State;
  private final @ModelField(targetType="String", isRequired = true) String Zip;
  private final @ModelField(targetType="BusinessAddressPerson") @HasMany(associatedWith = "businessAddress", type = BusinessAddressPerson.class) List<BusinessAddressPerson> People = null;
  private final @ModelField(targetType="Appointment") @HasMany(associatedWith = "businessaddressID", type = Appointment.class) List<Appointment> Appointments = null;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getAddress() {
      return Address;
  }
  
  public String getCity() {
      return City;
  }
  
  public String getState() {
      return State;
  }
  
  public String getZip() {
      return Zip;
  }
  
  public List<BusinessAddressPerson> getPeople() {
      return People;
  }
  
  public List<Appointment> getAppointments() {
      return Appointments;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private BusinessAddress(String id, String Address, String City, String State, String Zip) {
    this.id = id;
    this.Address = Address;
    this.City = City;
    this.State = State;
    this.Zip = Zip;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      BusinessAddress businessAddress = (BusinessAddress) obj;
      return ObjectsCompat.equals(getId(), businessAddress.getId()) &&
              ObjectsCompat.equals(getAddress(), businessAddress.getAddress()) &&
              ObjectsCompat.equals(getCity(), businessAddress.getCity()) &&
              ObjectsCompat.equals(getState(), businessAddress.getState()) &&
              ObjectsCompat.equals(getZip(), businessAddress.getZip()) &&
              ObjectsCompat.equals(getCreatedAt(), businessAddress.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), businessAddress.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAddress())
      .append(getCity())
      .append(getState())
      .append(getZip())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("BusinessAddress {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Address=" + String.valueOf(getAddress()) + ", ")
      .append("City=" + String.valueOf(getCity()) + ", ")
      .append("State=" + String.valueOf(getState()) + ", ")
      .append("Zip=" + String.valueOf(getZip()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static AddressStep builder() {
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
  public static BusinessAddress justId(String id) {
    return new BusinessAddress(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Address,
      City,
      State,
      Zip);
  }
  public interface AddressStep {
    CityStep address(String address);
  }
  

  public interface CityStep {
    StateStep city(String city);
  }
  

  public interface StateStep {
    ZipStep state(String state);
  }
  

  public interface ZipStep {
    BuildStep zip(String zip);
  }
  

  public interface BuildStep {
    BusinessAddress build();
    BuildStep id(String id);
  }
  

  public static class Builder implements AddressStep, CityStep, StateStep, ZipStep, BuildStep {
    private String id;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    @Override
     public BusinessAddress build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new BusinessAddress(
          id,
          Address,
          City,
          State,
          Zip);
    }
    
    @Override
     public CityStep address(String address) {
        Objects.requireNonNull(address);
        this.Address = address;
        return this;
    }
    
    @Override
     public StateStep city(String city) {
        Objects.requireNonNull(city);
        this.City = city;
        return this;
    }
    
    @Override
     public ZipStep state(String state) {
        Objects.requireNonNull(state);
        this.State = state;
        return this;
    }
    
    @Override
     public BuildStep zip(String zip) {
        Objects.requireNonNull(zip);
        this.Zip = zip;
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
    private CopyOfBuilder(String id, String address, String city, String state, String zip) {
      super.id(id);
      super.address(address)
        .city(city)
        .state(state)
        .zip(zip);
    }
    
    @Override
     public CopyOfBuilder address(String address) {
      return (CopyOfBuilder) super.address(address);
    }
    
    @Override
     public CopyOfBuilder city(String city) {
      return (CopyOfBuilder) super.city(city);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder zip(String zip) {
      return (CopyOfBuilder) super.zip(zip);
    }
  }
  
}
