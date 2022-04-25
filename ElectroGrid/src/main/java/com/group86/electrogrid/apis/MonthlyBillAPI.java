package com.group86.electrogrid.apis;


import java.util.Optional;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.group86.electrogrid.models.MonthlyBill;
import com.group86.electrogrid.models.Payment;
import com.group86.electrogrid.models.UserValues;
import com.group86.electrogrid.repositories.MonthlyBillRepository;
import com.group86.electrogrid.repositories.UserValuesRepository;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Path("/api/calc")
public class MonthlyBillAPI {
	
	@Autowired
    MonthlyBillRepository monthlyBillRepository;
	UserValuesRepository userValuesRepository;
	
    @POST
    @Path("/create_bill")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createMonthlyBill(MonthlyBill monthlyBill){

    	monthlyBillRepository.save(monthlyBill);
         printMonthlyBill(monthlyBill);

        String ret = "Payment ID : "+ Long.toString(monthlyBill.getId()) + "<br>" +
        		"Units : "+ monthlyBill.getUnits();

        return ret;
    }

    public void printMonthlyBill(MonthlyBill monthlyBill){
        System.out.println("User ID : "+ monthlyBill.getId());
        System.out.println("Units : "+ monthlyBill.getUnits());
    }
    
    public String getString(MonthlyBill monthlyBill){
        return  "ID : "+ Long.toString(monthlyBill.getId()) + "<br>" +
                "Units : "+ monthlyBill.getUnits();
    }
    
    
    
    @GET
    @Path("/getuservalue/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserValues getUserValueById(@PathParam("id") Long id){
        Optional<UserValues> userValue = userValuesRepository.findById(id);
        if(userValue.isPresent()){
            return userValue.get();
            //String jsonString = JSON.toJSONString(user);
            //return Response.status(Response.Status.OK).entity(jsonString).build();
        }else{
            return null;
        }
    }
    
    
//    @GET
//    @Path("/calc/{id}")
//    public String calc(@PathParam("id") String id){
//        return "You have typed -> <br>1."+ input1 + "<br>2." + input2;
//    }
    
    

//    public static void main(String[] args) {
//
//    	double Total;
//    	Float units = 0;
//    	
//
//    }
//    
//    public static Float calcTotal(Float Tot) {
//    	double T = Tot * 7.85;
//    	
//    	return T;
//    }


}
