
/*
 * 
 */

package com.service.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.12-patch-02
 * Mon Jun 11 18:24:32 PDT 2012
 * Generated source version: 2.2.12-patch-02
 * 
 */


@WebServiceClient(name = "BPMNWebService", 
                  wsdlLocation = "http://localhost:8080/mavenized-brms-webapp/bpmn-service?wsdl",
                  targetNamespace = "http://www.com.service") 
public class BPMNWebService_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://www.com.service", "BPMNWebService");
    public final static QName BPMNWebServicePort = new QName("http://www.com.service", "BPMNWebServicePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/mavenized-brms-webapp/bpmn-service?wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from http://localhost:8080/mavenized-brms-webapp/bpmn-service?wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public BPMNWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BPMNWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BPMNWebService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns BPMNWebService
     */
    @WebEndpoint(name = "BPMNWebServicePort")
    public BPMNWebService getBPMNWebServicePort() {
        return super.getPort(BPMNWebServicePort, BPMNWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BPMNWebService
     */
    @WebEndpoint(name = "BPMNWebServicePort")
    public BPMNWebService getBPMNWebServicePort(WebServiceFeature... features) {
        return super.getPort(BPMNWebServicePort, BPMNWebService.class, features);
    }

}
