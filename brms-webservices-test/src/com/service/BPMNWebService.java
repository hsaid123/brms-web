package com.service;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.WebParam;

import org.acme.insurance.Driver;
import org.acme.insurance.Policy;

import org.drools.KnowledgeBase;

import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

@WebService(targetNamespace = "http://www.com.service", serviceName = "BPMNWebService")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class BPMNWebService {
	@WebMethod
	@WebResult(name = "price")
	public Double calculatePolicyCost(@WebParam(name = "age") int age,
			@WebParam(name = "numberOfAccidents") int numberOfAccidents,
			@WebParam(name = "numberOfTickets") int numberOfTickets,
			@WebParam(name = "creditScore") int creditScore,
			@WebParam(name = "vehicleYear") int vehicleYear,
			@WebParam(name = "policyType") String policyType) {

		Driver driver = new Driver();
		Policy policy = new Policy();

		driver.setAge(age);
		driver.setCreditScore(creditScore);
		driver.setDriverName("TestDriver");
		driver.setNumberOfAccidents(numberOfAccidents);
		driver.setNumberOfTickets(numberOfTickets);

		policy.setDriver(driver);
		policy.setPolicyType(policyType);
		policy.setPrice(0);
		policy.setVehicleYear(vehicleYear);

		KnowledgeBase knowledgeBase = readKnowledgeBaseFromBinary();
		StatefulKnowledgeSession ksession = knowledgeBase
				.newStatefulKnowledgeSession();

		FactHandle driverFH = ksession.insert(driver);
		FactHandle policyFH = ksession.insert(policy);
		ksession.startProcess("org.acme.insurance.pricing.policyquotecalculationprocess");

		Double price = new Double(policy.getPrice());
		ksession.retract(driverFH);
		ksession.retract(policyFH);
		ksession.dispose();

	   return price;

	}

//	private KnowledgeBase readKnowledgeBase() {
//		KnowledgeAgent agent = KnowledgeAgentFactory
//				.newKnowledgeAgent("MyAgent");
//		
//		agent.applyChangeSet(ResourceFactory
//				.newClassPathResource("mychangeset.xml"));
//		
//
//		
//		KnowledgeBase knowledgeBase = agent.getKnowledgeBase();
//		return knowledgeBase;
//	}
	
	
	private KnowledgeBase readKnowledgeBaseFromBinary() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		//kbuilder.add(ResourceFactory.newClassPathResource("ex01_helloBPM.bpmn"), ResourceType.BPMN2);
	    kbuilder.add(ResourceFactory.newClassPathResource("org.acme.insurance.pricing.pkg"), ResourceType.PKG);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		return kbase;
	}	
	

}
