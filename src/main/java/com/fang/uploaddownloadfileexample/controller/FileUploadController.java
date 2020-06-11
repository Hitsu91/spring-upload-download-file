package com.fang.uploaddownloadfileexample.controller;

import com.fang.uploaddownloadfileexample.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    private FileStorageService fs;

    @Autowired
    public FileUploadController(FileStorageService fs) {
        this.fs = fs;
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam MultipartFile file) {
        return fs.salvaFile(file);
    }

    @GetMapping("/download/{fileName}")
    public Resource downloadFile(@PathVariable String fileName) {
        return fs.loadFile(fileName);
    }
}
