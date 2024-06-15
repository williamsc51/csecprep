package io.cxcprep.utility;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ViewHelpers {

    public Boolean fileExist(String x){
        String basePath = "src/main/resources/static/images/";
        String ext = ".png";
        String filePath = basePath + x + ext;
        Path path = Paths.get(filePath);

        return Files.exists(path);
    }

    public String normalizeTitle(String title){
        return title.replaceAll("_", " ");
    }
}
