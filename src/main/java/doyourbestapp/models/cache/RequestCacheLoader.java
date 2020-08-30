package doyourbestapp.cache;

import com.google.common.cache.CacheLoader;
import doyourbestapp.contract.FetchResponse;
import doyourbestapp.activities.CreateActivity;
import doyourbestapp.models.RetroDay;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
public class RequestCacheLoader extends CacheLoader<RetroDay, FetchResponse> {

    @Autowired
    CreateActivity createActivity;
    @Override

    public FetchResponse load(RetroDay createRequest) throws Exception {
        System.out.println("expensive call");
        return null;
    }
}
