package com.example.vehicle.vehiclee.controller;

import com.example.vehicle.vehiclee.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import java.sql.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@ComponentScan("com.example.vehicle.vehiclee.controller")
public class Vehiclecontroller {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);

        return "home";
    }
    @RequestMapping(value= "/welcome", method = RequestMethod.POST)

    public String welcome(Model model,@RequestParam("userName") String userName) {

        System.out.println("welcome Page Requested,"+userName);
        model.addAttribute("greeting", "Welcome "+ userName  + "  to Vehiclee!");
        model.addAttribute("tagline", "The amazing vehicle Network");

        return "welcome";
    }

    @RequestMapping(value= "/success", method = RequestMethod.POST)
    public String order(Model model,@RequestParam("Vehicle_Type") String Vehicle_Type, @RequestParam("model_no") String model_no , @RequestParam("people_capacity") String people_capacity) {
        System.out.println("Success Page Requested,");
        System.out.println("Saving vehicle info : "+ Vehicle_Type);
        System.out.println("Saving vehicle info : "+ model_no);
        System.out.println("Saving vehicle info : "+ people_capacity);

        try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                String dburl="jdbc:mysql://127.0.0.1:3306/Vehiclee?verifyServerCertificate=false&useSSL=true&autoReconnect=true";
                Connection con=DriverManager.getConnection(dburl +"&user=root"+"&password=abc@123");
                String query ="INSERT INTO vehicle(vehicle_type,model,capacity)" +" values (?,?,?)";
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, Vehicle_Type);
                preparedStmt.setString (2, model_no);
                preparedStmt.setString(3,people_capacity);
                preparedStmt.execute();
                System.out.println("vehicle info saved: ");
         /*   String msg= "Your_Vehicle_registered_successfully";
            String toContact="9999219860" ;
            String contact= "9632454433";
            String smsurl="https://smsapi.engineeringtgr.com/send/?";
            URL url = new URL(smsurl+"Mobile="+contact+"&Password=divya1308&Message="+msg+"&To="+toContact+"&Key=jyotiZahLb1Xc3svMRmKFN57pg");
            URLConnection urlcon = url.openConnection();
            InputStream stream = urlcon.getInputStream();
            int i;
            String response="";
            while ((i = stream.read()) != -1) {
                response+=(char)i;
            }
            if(response.contains("success")){
                System.out.println("Successfully send SMS");
                //your code when message send success
            }else{
                System.out.println(response);
                System.out.println("Msg sending Failed !");
                //your code when message not send
            }*/
        } /*catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Exception Msg sending Failed !");
        }*/
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQLException while saving !");
        }
        //model.addAttribute("object", "Bag");
        //model.addAttribute("wishlist", "check Your Wishlist");
        return "success";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String user(@Validated User user, Model model) {
        System.out.println("register page  Requested");
        //model.addAttribute("userName", user.getUserName());
        return "register";
    }
}
