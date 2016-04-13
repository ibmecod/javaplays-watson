package com.ibm.ecod.watson;

import java.io.File;

import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageKeywords;

public class AlchemyVisionTest {

  public static void main(String[] args) {
    AlchemyVision service = new AlchemyVision();
    service.setApiKey("f4b85e6505edfd8532a43e5409d66504cdb4b74a");

    File image = new File("src/IMG_0982.jpg");
    ImageKeywords keywords = service.getImageKeywords(image, true, true);

    System.out.println(keywords);
  }

}
