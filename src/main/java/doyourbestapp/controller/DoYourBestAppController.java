package doyourbestapp.controller;

import doyourbestapp.activities.CreateActivity;
import doyourbestapp.activities.FetchActivity;
import doyourbestapp.models.contract.CreateRequest;
import doyourbestapp.models.contract.CreateResponse;
import doyourbestapp.models.contract.FetchRequest;
import doyourbestapp.models.contract.FetchResponse;
import doyourbestapp.models.contract.Response;
import doyourbestapp.models.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author shivanidwivedi on 29/07/20
 * @project DoYourBest
 */

@RestController
public class DoYourBestAppController {


    private static final Logger LOGGER= LoggerFactory.getLogger(DoYourBestAppController.class);
    /**
     * Main activity thta processes create/edit requests
     */
    @Autowired
    CreateActivity createActivity;

    /**
     * Main activity that processes fetch requests
     */
    @Autowired
    FetchActivity fetchActivity;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Response> createUserFeed(@RequestBody CreateRequest createRequest) throws ParseException {
        LOGGER.info("create request: {}", createRequest.toString());
        CreateResponse createResponse = createActivity.process(createRequest);
        if(!createResponse.isSuccess()) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/fetch")
    public FetchResponse fetchUserData() throws ParseException {
        FetchRequest fetchRequest = FetchRequest.builder().id(AppConstants.DEFAULT_ID).build(); //empty request
        LOGGER.info("/fetch request: {}", fetchRequest.toString());
        FetchResponse fetchResponse = fetchActivity.process(fetchRequest);
        return fetchResponse;
    }

    @GetMapping(value = "/fetch/{id}")
    public FetchResponse fetchById(@PathVariable int id) throws ParseException {
        FetchRequest fetchRequest = FetchRequest.builder().id(id).build(); //empty request
        LOGGER.info("/fetch request: {}", fetchRequest.toString());
        FetchResponse fetchResponse = fetchActivity.process(fetchRequest);
        return fetchResponse;
    }

}
