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
import com.ibm.watson.developer_cloud.message_resonance.v1.model.Resonance;
import com.ibm.watson.developer_cloud.question_and_answer.v1.QuestionAndAnswer;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.Answer;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.QuestionAndAnswerDataset;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonAnswer;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.EvidenceRequest;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.Pipeline;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonQuestion;


import java.util.List;

public class QuestionAndAnswerTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		QuestionAndAnswer qat = new QuestionAndAnswer();
		try {
			qat.setUsernameAndPassword(
					"27cfb41f-345e-42c9-a91e-e84400b3b1cd",
                    "gOUT5N8ZQbcj"
					);
			qat.setEndPoint("https://gateway.watsonplatform.net/question-and-answer-beta/api");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		qat.setDataset(QuestionAndAnswerDataset.HEALTHCARE);
		WatsonAnswer watsonAnswers = qat.ask("What is Migrane?");

		System.out.println(watsonAnswers);
		
	}

	

}
