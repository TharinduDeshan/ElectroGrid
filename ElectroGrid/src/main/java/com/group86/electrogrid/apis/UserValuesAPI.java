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

import org.springframework.beans.factory.annotation.Autowired;

import com.group86.electrogrid.models.UserValues;
import com.group86.electrogrid.repositories.UserValuesRepository;

@Path("/api/userval")
public class UserValuesAPI {
	
	@Autowired
    UserValuesRepository userValuesRepository;
	
//    @GET
//    @Path("/getuservalue/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public UserValues getUserValueById(@PathParam("id") Long id){
//        Optional<UserValues> userValue = userValuesRepository.findById(id);
//        if(userValue.isPresent()){
//            return userValue.get();
//            //String jsonString = JSON.toJSONString(user);
//            //return Response.status(Response.Status.OK).entity(jsonString).build();
//        }else{
//            return null;
//        }
//    }

    @GET
    @Path("/getalluservalues")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserValues> GetAllUserValues(){
         return userValuesRepository.findAll();
    }

    @POST
    @Path("/create_user_value")
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUser(UserValues userValues){

        userValuesRepository.save(userValues);
        printUserValues(userValues);

        String ret = "ID : "+ Long.toString(userValues.getId()) + "<br>" +
                "Name : "+ userValues.getName() + "<br>" +
        		"Units : "+ userValues.getUnits();

        return ret;
    }


    @POST
    @Path("/update_user")
    @Consumes(MediaType.APPLICATION_JSON)
    public String updateUser(UserValues userValues){

        userValuesRepository.save(userValues);
        printUserValues(userValues);

        return getString(userValues)+ "<br>Updated" ;
    }


    @GET
    @Path("/deleteuservalues/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(@PathParam("id") Long id) {
        Optional<UserValues> userValues = userValuesRepository.findById(id);
        if (userValues.isPresent()) {
            userValuesRepository.delete(userValues.get());
            return getString(userValues.get())+ "<br> Deleted Successfully";
        } else {
            return "User not exists with id : "+ id;
        }
    }

    public void printUserValues(UserValues userValues){
        System.out.println("ID : "+ userValues.getId());
        System.out.println("Username : "+ userValues.getName());
        System.out.println("Password : "+ userValues.getUnits());
    }

    public String getString(UserValues userValues){
        return  "ID : "+ Long.toString(userValues.getId()) + "<br>" +
                "Name : "+ userValues.getName() + "<br>" +
                "Units : "+ userValues.getUnits();
    }
    
    
    @GET
    @Path("/getuservalue/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserValues getUserValueById(@PathParam("id") Long id){
        Optional<UserValues> userValues = userValuesRepository.findById(id);
        if(userValues.isPresent()){
           return userValues.get();
           
           
            
            //String jsonString = JSON.toJSONString(user);
            //return Response.status(Response.Status.OK).entity(jsonString).build();
        }else{
            return null;
        }
    }
    

}
