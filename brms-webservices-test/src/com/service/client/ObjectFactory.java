
package com.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculatePolicyCost_QNAME = new QName("http://www.com.service", "calculatePolicyCost");
    private final static QName _CalculatePolicyCostResponse_QNAME = new QName("http://www.com.service", "calculatePolicyCostResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculatePolicyCostResponse }
     * 
     */
    public CalculatePolicyCostResponse createCalculatePolicyCostResponse() {
        return new CalculatePolicyCostResponse();
    }

    /**
     * Create an instance of {@link CalculatePolicyCost }
     * 
     */
    public CalculatePolicyCost createCalculatePolicyCost() {
        return new CalculatePolicyCost();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePolicyCost }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.com.service", name = "calculatePolicyCost")
    public JAXBElement<CalculatePolicyCost> createCalculatePolicyCost(CalculatePolicyCost value) {
        return new JAXBElement<CalculatePolicyCost>(_CalculatePolicyCost_QNAME, CalculatePolicyCost.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePolicyCostResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.com.service", name = "calculatePolicyCostResponse")
    public JAXBElement<CalculatePolicyCostResponse> createCalculatePolicyCostResponse(CalculatePolicyCostResponse value) {
        return new JAXBElement<CalculatePolicyCostResponse>(_CalculatePolicyCostResponse_QNAME, CalculatePolicyCostResponse.class, null, value);
    }

}
