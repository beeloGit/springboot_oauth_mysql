package com.oauth2.oaut2demo.controller;

import com.oauth2.oaut2demo.Modals.User;
import com.oauth2.oaut2demo.Wrappers.LoginWrapper;
import com.oauth2.oaut2demo.Wrappers.UserWrapper;
import com.oauth2.oaut2demo.enums.ResponseEnum;
import com.oauth2.oaut2demo.services.UserService;
import com.oauth2.oaut2demo.utill.OauthDemoCoreUtill;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oauth2.oaut2demo.response.GenericAPIResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private ResourceBundle messageBundle = ResourceBundle.getBundle("messages");
    /**
     * @return Response with User detail.
     * @author Hassan Naseer
     * @description API will return User detail.
     * @since 26-10-2019
     */
    @ApiOperation(httpMethod = "POST", value = "User LoggedIn",
            notes = "This method will return logged in User",
            produces = "application/json", nickname = "Logging In User",
            response = GenericAPIResponse.class, protocols = "https")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Logged in User fetched", response = GenericAPIResponse.class),
            @ApiResponse(code = 401, message = "Oops, your fault. You are not authorized to access.", response = GenericAPIResponse.class),
            @ApiResponse(code = 403, message = "Oops, your fault. You are forbidden.", response = GenericAPIResponse.class),
            @ApiResponse(code = 404, message = "Oops, my fault System did not find your desire resource.", response = GenericAPIResponse.class),
            @ApiResponse(code = 500, message = "Oops, my fault. Something went wrong on the server side.", response = GenericAPIResponse.class)})
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public ResponseEntity<?> login(HttpServletRequest request,
                                   @RequestBody LoginWrapper loginWrapper) {

        logger.info("LoggedIn User API - getLoggedInUser API initiated.");
        String loggedInUser = loginWrapper.getUserName();
        GenericAPIResponse response = new GenericAPIResponse();
        response.setResponseMessage(messageBundle.getString("user.login.error"));
        response.setResponseCode(ResponseEnum.USER_LOGGEDIN_FAILED.getValue());
        response.setResponseStatus(ResponseEnum.ERROR.getValue());
        response.setResponseData(null);

        try {
            if (OauthDemoCoreUtill.isValidObject(loggedInUser)) {
                logger.info("LoggedIn User API - fetching user from DB.");
                User user = userService.findByUserName(loggedInUser);
                if (OauthDemoCoreUtill.isValidObject(user)) {
                    logger.info("LoggedIn User API - user successfully fetched...");
                    UserWrapper userWrapper = userService.buildLoggedInUserWrapper(user);
                        if (BCrypt.checkpw(loginWrapper.getPassword(), user.getPassword())) {
                            response.setResponseMessage(messageBundle.getString("user.loggedIn.fetched.success"));
                            response.setResponseCode(ResponseEnum.USER_ACCESS_GRANTED.getValue());
                            response.setResponseStatus(ResponseEnum.SUCCESS.getValue());
                            response.setResponseData(userWrapper);
                            logger.info("User Logged in successfully...");
                            return new ResponseEntity<>(response, HttpStatus.OK);
                        }
                }
            }
        } catch (Exception ex) {
            logger.error("User Logged In failed.", ex.fillInStackTrace());
            response.setResponseStatus(ResponseEnum.ERROR.getValue());
            response.setResponseCode(ResponseEnum.EXCEPTION.getValue());
            response.setResponseMessage(messageBundle.getString("exception.occurs"));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation("Load Private")
    @ApiResponses(value = {
            @ApiResponse(code = 100,message = "100 is the Message"),
            @ApiResponse(code = 200,message = "Success Response"),
            @ApiResponse(code = 401,message = "Unauthorize User"),
            @ApiResponse(code = 403,message = "Forbidden"),
            @ApiResponse(code = 404,message = "Not Found")
    })
    @RequestMapping(value = "/private", method = RequestMethod.GET)
    public String privateArea() {
        userService.generateBcryptHashKey("dingdong22");
        return "private";
    }
}
