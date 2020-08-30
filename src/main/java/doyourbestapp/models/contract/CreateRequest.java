package doyourbestapp.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

/**
 * @author shivanidwivedi on 05/08/20
 * @project DoYourBest
 */
@Builder
@Data
@Entity
@Table(name="RETRODAYS")
public class CreateRequest implements Request {
    /**
     * If EDIT, then it means that user edited past data. We should also expect date in EDI case
     */
    private RequestType requestType = RequestType.CREATE;
    /**
     * mandatory: this indicates if you did your best today
     */
    @Column(name="is_best_day")
    private boolean isBestDay;
    /**
     * Optional: if not provided, it should remain empty
     */
    @Column(name="note")
    private String note;
    /**
     * optional: if not provided it should be set to today's date
     */
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name="day_date")
    private String date;
    /**
     * User id
     */
    @Id
    @GeneratedValue
    private int id;

    @Override
    public String toString() {
        return "CreateRequest{" +
                "requestType=" + requestType +
                ", isBestDay=" + isBestDay +
                ", note='" + note  +
                ", date='" + date +
                ", id=" + id +
                '}';
    }
}
/**
 *
 */
enum RequestType {
    EDIT, CREATE
}
