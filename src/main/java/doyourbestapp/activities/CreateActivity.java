package doyourbestapp.activities;

import doyourbestapp.models.RetroCalendarInventory;
import doyourbestapp.models.RetroCalender;
import doyourbestapp.models.RetroDay;
import doyourbestapp.models.contract.CreateRequest;
import doyourbestapp.models.contract.CreateResponse;
import doyourbestapp.models.util.AppConstants;
import doyourbestapp.models.util.DateUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */

/**
 * Responsible for the create request process. Whenever a request from user comes in, this class would process the request by creating a new entry.
 */
@Service
public class CreateActivity implements Activity<CreateRequest, CreateResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateActivity.class);

    @Autowired
    RetroCalendarInventory retroCalendarInventory;

    @Override
    public boolean validate(CreateRequest request) throws ParseException {
        if (request.getId() <= 0) {
            return false;
        }
        if (!DateUtility.isValidDate(request.getDate())) {
            return false;
        }
        return true;
    }



    @Override
    public CreateResponse processRequest(CreateRequest createRequest) throws ParseException {
        RetroDay retroDay = transform(createRequest);
        int userId = createRequest.getId();

        LOGGER.info("Inside Create activity process");
       // FetchResponse response = FetchResponse.builder().value(retroDay.toString()).build();
        if (retroCalendarInventory.getUserDaysMap().containsKey(userId)) { //user already exist in the inventory
            RetroCalender currentCalender = retroCalendarInventory.getUserDaysMap().get(userId); // get the user's calender
            RetroDay sameDay = currentCalender.getSameDay(retroDay); // check if the day already exists in the calender
            /*
            if the day already exists in the calender
             */
            if (sameDay != null) {
                // update the day with the new values
                sameDay.setMyBestDay(retroDay.isMyBestDay());
                sameDay.setNote(retroDay.getNote());
            } else
                // if it is a new day, add it to the calender
                retroCalendarInventory.addToCalendar(retroDay);
            /*
            if the request is from new user (User not present in the map)
             */
        } else {
            // create new calender for the user
            RetroCalender retroCalender = new RetroCalender();
            retroCalender.addDay(retroDay); // add day to the calender
            retroCalendarInventory.getUserDaysMap().put(createRequest.getId(), retroCalender); // make entry to the map
        }

        return CreateResponse.builder()
                .isSuccess(true)
                .build();
    }

    @Override
    public CreateResponse errorResponse() {
        return CreateResponse.builder().errorMessage(AppConstants.INVALID_REQUEST_MESSAGE).build();
    }

    private static RetroDay transform(CreateRequest request) throws ParseException {
        Date date = DateUtility.toDate(request.getDate());
        RetroDay retroDay = RetroDay.builder().isMyBestDay(request.isBestDay())
                .note(request.getNote())
                .userId(request.getId())
                .date(date)
                .build();
        return retroDay;
    }


}