package doyourbestapp.models.contract;

import doyourbestapp.models.RetroCalendarInventory;
import lombok.Builder;
import lombok.Data;

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
