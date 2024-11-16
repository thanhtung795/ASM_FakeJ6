package org.example.ps27852_lab8.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface UploadService {
   File save(MultipartFile file, String folder) ;

}
