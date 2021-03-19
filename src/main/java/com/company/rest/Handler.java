package com.company.rest;

import com.amazonaws.services.cloudsearchv2.model.ResourceNotFoundException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

// Handler value: example.Handler
public class Handler implements RequestHandler<MyRequest, String> {

    public String handleRequest(MyRequest event, Context context) {
        AmazonDynamoDB adb = AmazonDynamoDBClientBuilder.defaultClient();
        DynamoDBMapper mapper = new DynamoDBMapper(adb);
        LambdaLogger logger = context.getLogger();
        String method = event.getHttpFunction();
        APIObjects obj = event.getObject();
        obj.setKey((long) event.getId());
        APIObjects DBobj;
        if(obj instanceof User){
            switch (method) {
                case ("GET"):
                    DBobj = mapper.load(obj.getClass() ,obj.getKey());
                    if (DBobj == null) {
                        throw new ResourceNotFoundException("Resource Not Found " + obj.getKey());
                    }
                    return "";
                case ("PUT"):
                    break;
                default:
                    //do something
            }
        }
        else if(obj instanceof Building){
            switch (method) {
                case ("GET"):
                    break;
                case ("PUT"):
                    break;
                default:
                    //do something
            }
        }
        else if(obj instanceof Elevator){
            switch (method) {
                case ("GET"):
                    break;
                case ("PUT"):
                    break;
                default:
                    //do something
            }
        }


        /*
        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(event));
        logger.log("EVENT TYPE: " + event.getClass().toString());*/
        return " ";
    }
}