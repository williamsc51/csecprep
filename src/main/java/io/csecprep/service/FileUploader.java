package io.csecprep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploader {

    public String upload(MultipartFile file, String folder){
        String basePath = "src/main/resources/static/images/";
        String fileName = file.getOriginalFilename();
        String filePath = folder+fileName;
        Path path = Path.of(basePath+filePath);

        try{
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return filePath;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "FAILED";
    }

}
