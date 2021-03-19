package com.company.rest;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class Building implements APIObjects{

    private Long key;
    private double rangeKey;
    private Long version;

    @DynamoDBHashKey
    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }
}
