package wawer.kamil.financetaskremastered.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {

    public static void uploadFile(MultipartFile multipartFile) {
        try {
            File file = new File("src/main/resources/" + multipartFile.getOriginalFilename());
            String pa = file.getAbsolutePath();
            Path path = Paths.get(pa);
            byte[] bytes = multipartFile.getBytes();
            Files.write(path, bytes);
        } catch (
                IOException e) {
            System.out.println(e);
        }
    }

    public static void removeFile(MultipartFile multipartFile) {
        File file = new File("src/main/resources/" + multipartFile.getOriginalFilename());
        file.delete();
    }

}
