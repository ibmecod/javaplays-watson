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

import java.io.File;

import com.ibm.watson.developer_cloud.natural_language_classifier.v1.NaturalLanguageClassifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classification;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier;
import com.ibm.watson.developer_cloud.natural_language_classifier.v1.model.Classifier.Status;

/**
 * Tests Bluemix Natural Language Classifier service.
 * Create folder "input" in your working directory.
 * Copy "input/NaturalLanguageClassifierTest.csv" file to "input" folder.
 * 
 * Correction to exercise instruction.
 * REMOVE OLD WRAPPER LIBRARY FROM THE PROJECT
 * Use this version of Watson Java wrapper library.
 * java-wrapper-1.1.1-jar-with-dependencies.jar
 * 
 */
public class NaturalLanguageClassifierTest
{
	public static void main(String[] args)
	{
		int elapsed = 0;
		String classifierId = null;
		boolean interrupted = false;
		NaturalLanguageClassifier service = new NaturalLanguageClassifier();
		service.setUsernameAndPassword
		(
				// account username from VCAP_SERVICES env variable of the Watson Natural Language Classifier service instance
				"3bfd3aca-d07f-47b8-8e31-455c62fa1bed",
				// account password from VCAP_SERVICES env variable of the Watson Natural Language Classifier service instance
				"r9h8X4e1ysNl"
		);
		service.setEndPoint("https://gateway.watsonplatform.net/natural-language-classifier/api");

		Classifier classifier =
				service.createClassifier
				(
						// Note Classifier name must be unique for each user ! Use your initials and last 4 digits of your phone number to make sure
						"sk4251",
						"en",
						new File("input/NaturalLanguageClassifierTest.csv")
				);
		
		classifierId = classifier.getId();
		System.out.println("Classifier created with id " + classifierId);

		System.out.println("Waiting for classifier to be trained (it will take about 4 minutes) ...");
		while (classifier.getStatus() == Status.TRAINING)
		{
			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException e)
			{
				System.err.println("Terminated before classifier status changed ! Cleaning up and exiting ");
				interrupted = true;
				break;
			}
			elapsed += 10;
			// Refresh classifier status
			classifier = service.getClassifier(classifierId);
			System.out.println(elapsed + " seconds elapsed, Status: " + classifier.getStatusDescription());
		}

		if (!interrupted)
		{
			System.out.println("Classifier successfully trained");

			//System.out.println("Querying classifier with \"Is it going to rain soon?\"");
			//Classification classification = service.classify(classifierId, "Is it going to rain soon?");
			//System.out.println("Results:");
			//System.out.println(classification);
			System.out.println("Querying classifier with \"What will be the temperature today?\"");
			Classification classification2 = service.classify(classifierId, "What will be the temperature today?");
			System.out.println("Results:");
			System.out.println(classification2);
		}

		if (classifier != null)
		{
			service.deleteClassifier(classifierId);

		}

	}
}
