package com.springboot.elasticsearch;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "products")
public class Employee {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "name")
    private String firstName;

    @Field(type = FieldType.Text, name = "description")
    private String lastName;

    @Field(type = FieldType.Double, name = "price")
    private String age;

}
