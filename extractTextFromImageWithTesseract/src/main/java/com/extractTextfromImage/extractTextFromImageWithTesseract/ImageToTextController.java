package com.extractTextfromImage.extractTextFromImageWithTesseract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageToTextController {
     @Autowired
     private TesseractService tesseractService;
    @PostMapping("/getocr")
    public String getOCR(@RequestParam MultipartFile image) throws IOException {
        return tesseractService.getOCR(image.getInputStream());
    }
}
