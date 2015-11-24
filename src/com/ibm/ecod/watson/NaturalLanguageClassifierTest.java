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
 * @author tnevoli
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
				"f7b9f0c5-2d1d-4fde-aab0-7a9786b3b9c0",
				// account password from VCAP_SERVICES env variable of the Watson Natural Language Classifier service instance
				"orj6Gg7EW5WF"
		);
		service.setEndPoint("https://gateway.watsonplatform.net/natural-language-classifier/api");

		Classifier classifier =
				service.createClassifier
				(
						// Note Classifier name must be unique for each user ! Use your initials and last 4 digits of your phone number to make sure
						"classifier-name-goes-here",
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

			System.out.println("Querying classifier with \"Is is going to rain soon?\"");
			Classification classification = service.classify(classifierId, "Is is going to rain soon?");
			System.out.println("Results:");
			System.out.println(classification);
		}

		if (classifier != null)
		{
			service.deleteClassifier(classifierId);

		}

	}
}
