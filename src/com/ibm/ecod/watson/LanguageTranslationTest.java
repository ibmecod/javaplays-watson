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


import java.io.FileNotFoundException;
import java.net.URISyntaxException;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;

public class LanguageTranslationTest {

	public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
		LanguageTranslation service = new LanguageTranslation();
		service.setEndPoint("https://gateway.watsonplatform.net/language-translation/api");
		service.setUsernameAndPassword("93eee768-c0fc-4789-8ccf-6ef9b77f0942", "WFrWJcAK2ql4");

		TranslationResult translationResult = service.translate("Welcome to IBM Bluemix Watson Language Translation Service Snippet created by EcoDCNC team", "en", "es");

		System.out.println(translationResult);
	}

}

