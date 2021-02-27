package wawer.kamil.financetaskremastered.utils;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.exception.InvalidFileTypeException;

import java.io.*;

@Data
@Component
public class UploadFile {

    @Value("${outputFilePath}")
    private String outputPath;

    @Value("${requiredFileType}")
    private static String requiredFileType;



    public InputStream uploadXmlFile(MultipartFile multipartFile) {
        if(UploadFile.isUploadedFileTypeCorrect(multipartFile)){
            throw new InvalidFileTypeException();
        }
        try {
            return multipartFile.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Internal error");
    }

    public InputStreamResource downloadXmlFile() throws FileNotFoundException {
        File file = new File(outputPath);
        try {
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return resource;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        throw new FileNotFoundException("File Exception");
    }

    private static boolean isUploadedFileTypeCorrect(MultipartFile multipartFile){
        return !multipartFile.getContentType().equals(requiredFileType);
    }
}
