/**
 * Copyright 2014 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.ecod.watson;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.ibm.watson.developer_cloud.concept_expansion.v1.ConceptExpansion;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Concept;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.ConceptExpansionDataset;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job;
import com.ibm.watson.developer_cloud.concept_expansion.v1.model.Job.Status;


public class ConceptExpansionTest  {

public static void main(String[] args) throws UnsupportedEncodingException {

	ConceptExpansion cet = new ConceptExpansion();	
	try {
		cet.setUsernameAndPassword(
				"ac92b6e3-8f72-4f0b-8940-117e63cfc3f4",
                "wcA4Tj1vMJmA"
				);
		cet.setEndPoint("https://gateway.watsonplatform.net/concept-expansion-beta/api");
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	String []seeds = new String[]{"motrin","tylenol","aspirin"};
	String label = "medicine";
	cet.setDataset(ConceptExpansionDataset.MT_SAMPLES);

	Job job = cet.createJob(label, seeds);
	Status status = cet.getJobStatus(job);

	while (status == Status.AWAITING_WORK || status == Status.IN_FLIGHT) {
		status = cet.getJobStatus(job);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	if (status == Status.DONE) {
		List<Concept> concepts = cet.getJobResult(job);
		for (int i = 0; i < concepts.size(); i++) {
			Concept element = concepts.get(i);
			System.out.println(element);
		}
		
	} else {
		System.out.println("The concept couldn't be expanded");
	}
}
}
