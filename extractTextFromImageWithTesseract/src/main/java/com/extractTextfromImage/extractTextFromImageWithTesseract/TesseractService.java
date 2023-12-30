package com.extractTextfromImage.extractTextFromImageWithTesseract;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;



@Service
public class TesseractService {
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

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        file.transferTo(convFile);
        return convFile;
    }

}
