package doyourbestapp.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import doyourbestapp.contract.FetchResponse;
import doyourbestapp.models.RetroDay;
import lombok.Getter;

/**
 * @author shivanidwivedi on 03/08/20
 * @project DoYourBest
 */
@Getter
public class CreateActivityCache {
    private LoadingCache<RetroDay, FetchResponse> cacheEntry;
    private static CreateActivityCache doYourBestCache;

    private CreateActivityCache() {
        init();
    }

    public static CreateActivityCache getInstance() {
        if (doYourBestCache == null) {
            doYourBestCache = new CreateActivityCache();
        }
        return doYourBestCache;
    }

    public void init() {
        cacheEntry = CacheBuilder.newBuilder()
                .maximumSize(100)
                .recordStats()
                .build(new RequestCacheLoader());
    }

    public void printCacheStats() {
        System.out.println(this.cacheEntry.stats().toString());

    }
}
