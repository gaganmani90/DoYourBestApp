package doyourbestapp.models.contract;

import lombok.Builder;
import lombok.Data;

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
