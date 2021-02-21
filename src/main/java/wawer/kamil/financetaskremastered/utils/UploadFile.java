package wawer.kamil.financetaskremastered.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class UploadFile {

    public static InputStream uploadFile(MultipartFile multipartFile) {
        try {
            return multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Internal error");
    }
}
