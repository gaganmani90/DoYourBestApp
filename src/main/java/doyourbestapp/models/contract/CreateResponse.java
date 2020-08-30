package doyourbestapp.contract;

import doyourbestapp.models.RetroCalendarInventory;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
@Data
@Builder
public class CreateResponse implements Response {
    private String errorMessage;
    private boolean isSuccess;
}
