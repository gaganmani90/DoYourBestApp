package doyourbestapp.models.contract;

import doyourbestapp.models.util.AppConstants;
import lombok.Builder;
import lombok.Data;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
@Builder
@Data
public class FetchRequest implements Request {
    /**
     * User id
     */
    private int id = AppConstants.DEFAULT_ID;


    @Override
    public String toString() {
        return "FetchRequest{" +
                "id=" + id + '}';
    }
}


