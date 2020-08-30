package doyourbestapp.models.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shivanidwivedi on 06/08/20
 * @project DoYourBest
 */
public class DateUtility {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateUtility.class);

    public static boolean isValidDate(String dateToValidate) {
        SimpleDateFormat sdf = new SimpleDateFormat(AppConstants.DATE_FORMAT);
        try {
            Date date1 = sdf.parse(dateToValidate);
            Date nowDate = new Date();

            if (StringUtils.isEmpty(dateToValidate) || date1.after(nowDate)) {
                return false;
            }
            sdf.setLenient(false);

        } catch (ParseException e) {
            LOGGER.error("Invalid date format: {}", dateToValidate);
            return false;
        }
        return true;
    }

    public static Date toDate(String date) throws ParseException {
        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        return date1;
    }
}
