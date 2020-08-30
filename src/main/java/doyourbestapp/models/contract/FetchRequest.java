package doyourbestapp.models.contract;

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
     *
     */
    private FetchRequestType fetchRequestType = FetchRequestType.ALL;
    /**
     * User id
     */
    private int id;
    /**
     * optional: if not provided, means today's date.
     */
    private int day;
    /**
     * optional: if not provided, means current month.
     */
    private int month;
    /**
     * optional: if not provided, means current year.
     */
    private int year;

    @Override
    public String toString() {
        return "FetchRequest{" +
                "id=" + id +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}


