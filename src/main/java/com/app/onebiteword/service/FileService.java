package com.app.onebiteword.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private final static String UPLOAD_FILE_DIR = System.getProperty("user.home");

    public ResponseEntity<Resource> getDataFile(
            String fileName,
            String fileInfo
    ) {
        if ("".equals(fileInfo))
            return ResponseEntity.ok().body(null);

        String uploadPath = UPLOAD_FILE_DIR + "/obw";
        String uploadFile = uploadPath + "/" + fileName + ".json";

        checkDirectory(uploadPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(uploadFile, false))) {
            writer.write(fileInfo);

            Path path = Path.of(uploadPath, fileName);

            if (Files.exists(path)) {
                Resource fileResource = new FileSystemResource(path.toFile());

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName)
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(fileResource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().body(null);
    }

    private void checkDirectory(String filePath) {
        Path path = Paths.get(filePath);

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
