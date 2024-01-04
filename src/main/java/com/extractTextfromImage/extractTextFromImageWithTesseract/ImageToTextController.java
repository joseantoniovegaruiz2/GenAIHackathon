package com.extractTextfromImage.extractTextFromImageWithTesseract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class ImageToTextController {
     @Autowired
     private TesseractService tesseractService;
    @PostMapping(value="/getocr",consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
    public String getOCR( @PathVariable("image") MultipartFile image) throws IOException {
        return tesseractService.getOCR(image.getInputStream());
    }
}
