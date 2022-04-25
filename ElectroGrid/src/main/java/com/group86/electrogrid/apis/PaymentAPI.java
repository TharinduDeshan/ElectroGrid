package com.group86.electrogrid.apis;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group86.electrogrid.models.Payment;
import com.group86.electrogrid.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import org.springframework.beans.factory.annotation.Autowired;

import com.group86.electrogrid.models.User;
import com.group86.electrogrid.repositories.UserRepository;

@Path("/api/payment")
public class PaymentAPI {
	
	@Autowired
    PaymentRepository paymentRepository;
	
    

    @POST
    @Path("/create_payment")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createPayment(Payment payment){

        paymentRepository.save(payment);
        printPayment(payment);

        String ret = "Payment ID : "+ Long.toString(payment.getId()) + "<br>" +
                "Units : "+ payment.getUnits() + "<br>" +
                "Unit Price : "+ Float.toString(payment.getUnitPrice());

        return ret;
    }
    
    @GET
    @Path("/getpayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Payment getUserById(@PathParam("id") Long id){
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent()){
            return payment.get();
            //String jsonString = JSON.toJSONString(user);
            //return Response.status(Response.Status.OK).entity(jsonString).build();
        }else{
            return null;
        }
    }

    @GET
    @Path("/getallpayments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Payment> GetAllUsers(){
         return paymentRepository.findAll();
    }
    
    @POST
    @Path("/update_payment")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updatePayment(Payment payment){

    	paymentRepository.save(payment);
        printPayment(payment);

        return getString(payment)+ "<br>Updated" ;
    }


    @GET
    @Path("/deletepayment/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deletePayment(@PathParam("id") Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isPresent()) {
        	paymentRepository.delete(payment.get());
            return getString(payment.get())+ "<br> Deleted Successfully";
        } else {
            return "Field not exists with id : "+ id;
        }
    }


    public void printPayment(Payment payment){
        System.out.println("User ID : "+ payment.getId());
        System.out.println("Units : "+ payment.getUnits());
        System.out.println("Unit Price : "+ payment.getUnitPrice());
    }

    public String getString(Payment payment){
        return  "User ID : "+ Long.toString(payment.getId()) + "<br>" +
                "Units : "+ payment.getUnits() + "<br>" +
                "Unit Price : "+ Float.toString(payment.getUnitPrice());
    }

}
