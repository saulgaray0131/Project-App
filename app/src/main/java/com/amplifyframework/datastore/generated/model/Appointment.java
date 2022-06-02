package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the Appointment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Appointments", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
@Index(name = "byBusinessAddress", fields = {"businessaddressID"})
public final class Appointment implements Model {
  public static final QueryField ID = field("Appointment", "id");
  public static final QueryField APPOINTMENT_DATE_TIME = field("Appointment", "AppointmentDateTime");
  public static final QueryField PRICE_CHARGED = field("Appointment", "PriceCharged");
  public static final QueryField BUSINESSADDRESS_ID = field("Appointment", "businessaddressID");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="AWSDateTime", isRequired = true) Temporal.DateTime AppointmentDateTime;
  private final @ModelField(targetType="Int", isRequired = true) Integer PriceCharged;
  private final @ModelField(targetType="ID", isRequired = true) String businessaddressID;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public Temporal.DateTime getAppointmentDateTime() {
      return AppointmentDateTime;
  }
  
  public Integer getPriceCharged() {
      return PriceCharged;
  }
  
  public String getBusinessaddressId() {
      return businessaddressID;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Appointment(String id, Temporal.DateTime AppointmentDateTime, Integer PriceCharged, String businessaddressID) {
    this.id = id;
    this.AppointmentDateTime = AppointmentDateTime;
    this.PriceCharged = PriceCharged;
    this.businessaddressID = businessaddressID;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Appointment appointment = (Appointment) obj;
      return ObjectsCompat.equals(getId(), appointment.getId()) &&
              ObjectsCompat.equals(getAppointmentDateTime(), appointment.getAppointmentDateTime()) &&
              ObjectsCompat.equals(getPriceCharged(), appointment.getPriceCharged()) &&
              ObjectsCompat.equals(getBusinessaddressId(), appointment.getBusinessaddressId()) &&
              ObjectsCompat.equals(getCreatedAt(), appointment.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), appointment.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getAppointmentDateTime())
      .append(getPriceCharged())
      .append(getBusinessaddressId())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Appointment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("AppointmentDateTime=" + String.valueOf(getAppointmentDateTime()) + ", ")
      .append("PriceCharged=" + String.valueOf(getPriceCharged()) + ", ")
      .append("businessaddressID=" + String.valueOf(getBusinessaddressId()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static AppointmentDateTimeStep builder() {
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
  public static Appointment justId(String id) {
    return new Appointment(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      AppointmentDateTime,
      PriceCharged,
      businessaddressID);
  }
  public interface AppointmentDateTimeStep {
    PriceChargedStep appointmentDateTime(Temporal.DateTime appointmentDateTime);
  }
  

  public interface PriceChargedStep {
    BusinessaddressIdStep priceCharged(Integer priceCharged);
  }
  

  public interface BusinessaddressIdStep {
    BuildStep businessaddressId(String businessaddressId);
  }
  

  public interface BuildStep {
    Appointment build();
    BuildStep id(String id);
  }
  

  public static class Builder implements AppointmentDateTimeStep, PriceChargedStep, BusinessaddressIdStep, BuildStep {
    private String id;
    private Temporal.DateTime AppointmentDateTime;
    private Integer PriceCharged;
    private String businessaddressID;
    @Override
     public Appointment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Appointment(
          id,
          AppointmentDateTime,
          PriceCharged,
          businessaddressID);
    }
    
    @Override
     public PriceChargedStep appointmentDateTime(Temporal.DateTime appointmentDateTime) {
        Objects.requireNonNull(appointmentDateTime);
        this.AppointmentDateTime = appointmentDateTime;
        return this;
    }
    
    @Override
     public BusinessaddressIdStep priceCharged(Integer priceCharged) {
        Objects.requireNonNull(priceCharged);
        this.PriceCharged = priceCharged;
        return this;
    }
    
    @Override
     public BuildStep businessaddressId(String businessaddressId) {
        Objects.requireNonNull(businessaddressId);
        this.businessaddressID = businessaddressId;
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
    private CopyOfBuilder(String id, Temporal.DateTime appointmentDateTime, Integer priceCharged, String businessaddressId) {
      super.id(id);
      super.appointmentDateTime(appointmentDateTime)
        .priceCharged(priceCharged)
        .businessaddressId(businessaddressId);
    }
    
    @Override
     public CopyOfBuilder appointmentDateTime(Temporal.DateTime appointmentDateTime) {
      return (CopyOfBuilder) super.appointmentDateTime(appointmentDateTime);
    }
    
    @Override
     public CopyOfBuilder priceCharged(Integer priceCharged) {
      return (CopyOfBuilder) super.priceCharged(priceCharged);
    }
    
    @Override
     public CopyOfBuilder businessaddressId(String businessaddressId) {
      return (CopyOfBuilder) super.businessaddressId(businessaddressId);
    }
  }
  
}
