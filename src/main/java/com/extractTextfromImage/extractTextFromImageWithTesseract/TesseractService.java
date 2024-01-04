package com.extractTextfromImage.extractTextFromImageWithTesseract;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;



@Service
public class TesseractService {


  //  @Value("${translation.api.url}")
 //   private String apiUrl;

 //   private final WebClient webClient;

 //   public TesseractService(WebClient.Builder webClientBuilder) {
 //       this.webClient = webClientBuilder.baseUrl(apiUrl).build();
 //   }


    @Autowired
    private Tesseract tesseract;
    public String getOCR(InputStream inputStream) throws IOException {
        BufferedImage image= ImageIO.read(inputStream);
      //  File file = convertMultipartFileToFile(imageFile);
        try{

                return tesseract.doOCR(image);
        }catch(Exception e){
            e.printStackTrace();
        }
    return "failed";

    }



 //   public String translate(String text) {
  //      String jsonBody = "{\"q\":\"" + text + "\",\"source\":\"auto\",\"target\":\"en\",\"format\":\"text\",\"api_key\":\"\"}";

  //      return webClient.post()
 //               .uri("/translate")
 //               .header("Content-Type", "application/json")
  //              .body(BodyInserters.fromValue(jsonBody))
 //               .retrieve()
 //               .bodyToMono(String.class)
 //               .block(); // blocking for simplicity, use reactive programming for non-blocking
 //   }



    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }

}
