package com.group86.electrogrid.apis;


import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.text.SimpleDateFormat;
import java.util.Date;


@Path("/api/test")
public class TestAPI {

    @GET
    @Path("/hello")
    public String hello(){
        return  "Hello From Server";
    }

    @GET
    @Path("/time")
    public String time(){
        String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new Date());
        return timeStamp;
    }

    @GET
    @Path("/echo/{input1}/{input2}")
    public String echo(@PathParam("input1") String input1 , @PathParam("input2") String input2 ){
        return "You have typed -> <br>1."+ input1 + "<br>2." + input2;
    }



}
