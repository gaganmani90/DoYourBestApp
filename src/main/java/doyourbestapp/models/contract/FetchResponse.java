package doyourbestapp.contract;

import doyourbestapp.models.RetroCalendarInventory;
import doyourbestapp.models.RetroCalender;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
@Data
@Builder
public class FetchResponse implements Response {
    private String errorMessage;
    private RetroCalendarInventory retroCalendarInventory;
}
