package com.service.client;

import com.service.client.BPMNWebService;
import com.service.client.BPMNWebService_Service;

public class WebServiceClientTest {

	/**
	 * @param args
	 */	
	public static void main(String[] args) {
		BPMNWebService_Service bpmnService = new BPMNWebService_Service();
		BPMNWebService bpmnWebService = bpmnService.getBPMNWebServicePort();
		Double result = bpmnWebService.calculatePolicyCost(30, 1, 2, 650, 2004, "Auto");
        System.out.println("The result is "+result);
	}

}
