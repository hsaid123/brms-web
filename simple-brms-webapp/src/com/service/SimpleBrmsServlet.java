package com.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.acme.insurance.Driver;
import org.acme.insurance.Policy;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;

/**
 * Servlet implementation class SimpleBrmsServlet
 */
public class SimpleBrmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleBrmsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driverAge = request.getParameter("age");
		String accidents = request.getParameter("accidents");
		String tickets = request.getParameter("tickets");
		String score = request.getParameter("score");
		String vehicleYear = request.getParameter("vehicleYear");
		String policyType = request.getParameter("policyType");

		Driver driver = new Driver();
		Policy policy = new Policy();

		driver.setAge(Integer.parseInt(driverAge));
		driver.setCreditScore(Integer.parseInt(score));
		driver.setDriverName("TestDriver");
		driver.setNumberOfAccidents(Integer.parseInt(accidents));
		driver.setNumberOfTickets(Integer.parseInt(tickets));

		policy.setDriver(driver);
		policy.setPolicyType(policyType);
		policy.setPrice(0);
		policy.setPriceDiscount(0);
		policy.setVehicleYear(Integer.parseInt(vehicleYear));

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
		

	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	                                        "Transitional//EN\">\n" +
	                "<HTML>\n" +
	                "<HEAD><TITLE>Policy Price</TITLE></HEAD>\n" +
	                "<BODY>\n" +
	                "<H1>The insurance policy prise is: </H1>\n" +price+
	                "</BODY></HTML>");
	
	    out.flush();
	
	}

	private KnowledgeBase readKnowledgeBaseFromBinary() {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		//kbuilder.add(ResourceFactory.newClassPathResource("ex01_helloBPM.bpmn"), ResourceType.BPMN2);
	    kbuilder.add(ResourceFactory.newClassPathResource("org.acme.insurance.pricing.pkg"), ResourceType.PKG);
		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		return kbase;
	}	


}
