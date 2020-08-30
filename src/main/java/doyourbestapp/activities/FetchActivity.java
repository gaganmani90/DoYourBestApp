package doyourbestapp.activities;

import doyourbestapp.models.cache.CreateActivityCache;
import doyourbestapp.models.contract.FetchRequest;
import doyourbestapp.models.contract.FetchRequestType;
import doyourbestapp.models.contract.FetchResponse;
import doyourbestapp.models.RetroCalendarInventory;
import doyourbestapp.models.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
@Service
public class FetchActivity implements Activity<FetchRequest, FetchResponse> {
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchActivity.class);

    @Autowired
    CreateActivityCache doYourBestCache;

    @Autowired
    RetroCalendarInventory retroCalendarInventory;

    @Override
    public boolean validate(FetchRequest request) {
       // if (request.getId() <= 0) {
         //   return false;
        //}
        return true;
    }

    @Override
    public FetchResponse processRequest(FetchRequest fetchRequest) {
        switch (FetchRequestType.ALL) {
            case ALL:
                return FetchResponse.builder()
                        .retroCalendarInventory(retroCalendarInventory)
                        .build();
            case DAY:
                break;
            case MONTH:
                break;
            case YEAR:
                break;
        }
        return null;
    }

    @Override
    public FetchResponse errorResponse() {
        return FetchResponse.builder().errorMessage(AppConstants.INVALID_REQUEST_MESSAGE).build();
    }


}
