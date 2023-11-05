package com.functionalprogramming.Model;

import java.time.Instant;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import java.io.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Book")
public class Book implements Serializable{
    @Id
    private long id;
    private String name;
    private String description;
    private String autherName;
    private Date recordDay=Date.from(Instant.now());
}
