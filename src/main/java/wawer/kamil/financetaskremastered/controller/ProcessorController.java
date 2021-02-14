package wawer.kamil.financetaskremastered.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import wawer.kamil.financetaskremastered.model.xml.AccountsXml;
import wawer.kamil.financetaskremastered.service.ProcessorService;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;

@RestController
@RequestMapping(path = "processor")
@RequiredArgsConstructor
public class ProcessorController {

    private final ProcessorService processorService;

    @PostMapping
    public ResponseEntity<AccountsXml> getFile(@RequestParam(value = "file", required = true) MultipartFile multipartFile) throws IOException, XMLStreamException {
        return ResponseEntity.ok(processorService.welcomeEndpoint(multipartFile));
    }

    @GetMapping
    public ResponseEntity<AccountsXml> getFile1(@RequestParam(value = "file", required = false) MultipartFile multipartFile) throws IOException, XMLStreamException {
        return ResponseEntity.ok(processorService.welcomeEndpoint());
    }
}
