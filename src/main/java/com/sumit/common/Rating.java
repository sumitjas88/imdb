package com.sumit.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sumit.util.RatingTypeSerializer;

@JsonSerialize(using = RatingTypeSerializer.class)
public enum Rating {
    G ("G", "General Audiences"),
    PG ("PG", "Parental Guidance Suggested"),
    PG13 ("PG-13", "Parental Guidance Cautioned"),
    R ("R", "Restricted"),
    NC17 ("NC-17", "No One 17 and Under Admitted");

    private String code;
    private String description;


    Rating(String code, String description){
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
