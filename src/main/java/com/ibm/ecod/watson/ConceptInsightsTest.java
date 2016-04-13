/**
 * Copyright 2015 IBM Corp. All Rights Reserved.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ibm.ecod.watson;

import com.ibm.watson.developer_cloud.concept_insights.v2.ConceptInsights;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Annotations;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Concepts;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.Graph;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.RequestedFields;
import com.ibm.watson.developer_cloud.concept_insights.v2.model.ScoredConcept;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConceptInsightsTest {
  public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
    final ConceptInsights service = new ConceptInsights();
    service.setEndPoint("https://gateway.watsonplatform.net/concept-insights/api");
    service.setUsernameAndPassword(
      // Bluemix Watson Content Insights service account username from env variables
      "a425694b-f06a-4956-886d-e2e9e66d7c65",
      // Bluemix Watson Content Insights service account password from env variables
      "FPhRNXvLnJ9m");

    final Annotations annotations = service.annotateText(Graph.WIKIPEDIA, "NY JUG session is on Cognitive Computing using Java");

    System.out.println(annotations);


    List<ScoredConcept> scoredConceptList = annotations.getAnnotations();

    for (ScoredConcept scoredConcept : scoredConceptList) {
      System.out.println("Scored Concepts:");
      System.out.println(scoredConcept);
      final Map<String, Object> params = new HashMap<String, Object>();
      final List<String> ids = new ArrayList<String>();
      ids.add(scoredConcept.getConcept()
                           .getId());
      params.put(ConceptInsights.IDS, ids);
      params.put(ConceptInsights.LIMIT, 10);
      params.put(ConceptInsights.LEVEL, 1);
      final RequestedFields fs = new RequestedFields();
      fs.include("abstract");
      params.put(ConceptInsights.CONCEPT_FIELDS, fs);
      Concepts concepts = service.getConceptRelatedConcepts(scoredConcept.getConcept(), params);
      System.out.println("Related Concepts:");
      System.out.println(concepts);
    }
  }

}

