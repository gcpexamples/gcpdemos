package com.example.bootdemo;


import com.google.cloud.ReadChannel;
import com.google.cloud.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;

@RestController("/files")
public class BucketController {

    @Autowired
    private Storage storage;

    @GetMapping("/names")
    public String fetchContent() throws Exception{
        StringBuilder builder = new StringBuilder();
        try(ReadChannel channel=storage.reader("vinproject7-securedbucket","names.txt")){
            ByteBuffer buffer= ByteBuffer.allocate(32*1024);
            int readBytes;
            while((readBytes=channel.read(buffer))>0){
                buffer.flip();
                String data=new String(buffer.array(),0,readBytes);
                builder.append(data);
            }
        }
        return builder.toString();
    }


}