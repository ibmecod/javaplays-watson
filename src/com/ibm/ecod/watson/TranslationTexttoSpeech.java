package com.ibm.ecod.watson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.ibm.watson.developer_cloud.language_translation.v2.LanguageTranslation;
import com.ibm.watson.developer_cloud.language_translation.v2.model.TranslationResult;
import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.Voice;

public class TranslationTexttoSpeech {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        LanguageTranslation translator = new LanguageTranslation();
        translator.setUsernameAndPassword("f6e7b2cc-d28a-46df-a384-35c18001d959", "nAAikJICvCXC");
        
        TextToSpeech synthesizer = new TextToSpeech();
        synthesizer.setUsernameAndPassword("22ea9aaf-3002-4a4a-ad5c-f1203c8fe534", "gA9MS4t9pNGU");
        
        String myText = "Coding at New York Java User Group.";
        TranslationResult translationResult = translator.translate(myText, "en", "es");
        String translation = translationResult.getTranslations().get(0).getTranslation();
        System.out.println("Translation= " + translation);
        InputStream in = synthesizer.synthesize(translation, Voice.ES_LAURA, "audio/wav");
        Files.copy(in, Paths.get("output.wav"), StandardCopyOption.REPLACE_EXISTING);
	}
	

}
