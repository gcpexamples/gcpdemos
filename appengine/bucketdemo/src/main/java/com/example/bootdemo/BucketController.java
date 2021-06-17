package com.example.bootdemo;


import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;

@RequestMapping("/files")
@RestController
public class BucketController {

    @Autowired
    private Storage storage;

    @GetMapping("/trainees")
    public String fetchTrainees() throws Exception {
        StringBuilder builder = new StringBuilder();
        try (ReadChannel channel = storage.reader("vinproject7-securedbucket", "names.txt")) {
            InputStream input = Channels.newInputStream(channel);
            BufferedInputStream bin = new BufferedInputStream(input);
            byte[] buffer = new byte[64 * 1000];
            int readCount;
            while ((readCount = bin.read(buffer)) > 0) {
                System.out.println("read bytes="+readCount);
                String readString = new String(buffer,0,readCount);
                builder.append(readString);
            }
        }
        return builder.toString();
    }


}