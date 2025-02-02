package com.regex.blog.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String fieldName;
    Integer fieldValue;
    
    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue){

        super(String.format("%s Not Found With %s : %s", resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue= fieldValue;
    }

}
