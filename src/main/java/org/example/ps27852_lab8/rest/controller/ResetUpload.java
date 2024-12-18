package org.example.ps27852_lab8.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.service.UploadService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class ResetUpload {


    private final UploadService uploadService;


    @PostMapping("/rest/upload/{folder}")
    public JsonNode upload(@PathParam("file")MultipartFile file,
                           @PathVariable("folder") String folder){
        File saveFile = uploadService.save(file,folder);
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name",saveFile.getName());
        node.put("size",saveFile.length());
        return node;
    }

}
