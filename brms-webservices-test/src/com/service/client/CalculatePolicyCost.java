
package com.service.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculatePolicyCost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculatePolicyCost">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfAccidents" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="numberOfTickets" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creditScore" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vehicleYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="policyType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculatePolicyCost", propOrder = {
    "age",
    "numberOfAccidents",
    "numberOfTickets",
    "creditScore",
    "vehicleYear",
    "policyType"
})
public class CalculatePolicyCost {

    protected int age;
    protected int numberOfAccidents;
    protected int numberOfTickets;
    protected int creditScore;
    protected int vehicleYear;
    protected String policyType;

    /**
     * Gets the value of the age property.
     * 
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     */
    public void setAge(int value) {
        this.age = value;
    }

    /**
     * Gets the value of the numberOfAccidents property.
     * 
     */
    public int getNumberOfAccidents() {
        return numberOfAccidents;
    }

    /**
     * Sets the value of the numberOfAccidents property.
     * 
     */
    public void setNumberOfAccidents(int value) {
        this.numberOfAccidents = value;
    }

    /**
     * Gets the value of the numberOfTickets property.
     * 
     */
    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    /**
     * Sets the value of the numberOfTickets property.
     * 
     */
    public void setNumberOfTickets(int value) {
        this.numberOfTickets = value;
    }

    /**
     * Gets the value of the creditScore property.
     * 
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * Sets the value of the creditScore property.
     * 
     */
    public void setCreditScore(int value) {
        this.creditScore = value;
    }

    /**
     * Gets the value of the vehicleYear property.
     * 
     */
    public int getVehicleYear() {
        return vehicleYear;
    }

    /**
     * Sets the value of the vehicleYear property.
     * 
     */
    public void setVehicleYear(int value) {
        this.vehicleYear = value;
    }

    /**
     * Gets the value of the policyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPolicyType() {
        return policyType;
    }

    /**
     * Sets the value of the policyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPolicyType(String value) {
        this.policyType = value;
    }

}
