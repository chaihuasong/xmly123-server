package com.htz.xmly.entries;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "xmly123_2021")
public class VisitCount {
    @Id
    private String id;
    private String date;
    private String type;
    private long count;
}
