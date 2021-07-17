package com.pandy.elasticsearch.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Document(indexName = "user")
@Data
public class User  implements Serializable {

    @Id
    private String id;

    private String name;

    private Integer age;

    private String address;
}
