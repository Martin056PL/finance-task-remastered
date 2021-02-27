package wawer.kamil.financetaskremastered.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.service.ProcessorService;
import wawer.kamil.financetaskremastered.utils.UploadFile;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@RestController
@RequestMapping(path = "processor")
@RequiredArgsConstructor
public class ProcessorController {

    private final ProcessorService processorService;

    @PostMapping
    public ResponseEntity<Resource> getFile(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException, XMLStreamException {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(processorService.welcomeEndpoint(multipartFile));
    }
}
