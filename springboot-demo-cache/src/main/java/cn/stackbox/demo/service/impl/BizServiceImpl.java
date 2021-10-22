/**
 * Project Name:cache
 * Package Name:cn.stackbox.demo.service.impl
 * Date: 2016-12-10 11:51
 */
package cn.stackbox.demo.service.impl;

import cn.stackbox.demo.config.EhCacheConfig;
import cn.stackbox.demo.service.BizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * ClassName: BizServiceImpl <br/>
 * Reason: SomeReason <br/>
 * Date: 2016-12-10 11:51
 *
 * @author SRK.Lyu
 */
@Slf4j
@Service
public class BizServiceImpl implements BizService {

    @Autowired
    EhCacheConfig ehCacheConfig;

    @Override
    public String fetchCurrentTime() {
        log.info("cache2存放的缓存: " + ehCacheConfig.cacheManager().getCache("biz-cache1").getName());
        log.info("============================================测试缓存的访问============================================");
        return (new Date()).toString();
    }

    @Override
    public String fetchCurrentTimeWithRedisCache() {
        return (new Date()).toString();
    }

    @Override
    public String refreshCache() {
        return "removed";
    }

    @Override
    public String fetchCurrentTimeWithKeyGenerator() {
        log.info("cache1存放的缓存: " + ehCacheConfig.cacheManager().getCache("10SecsInfoCache").get("boxKeyGenerator"));
        // log.info("cache1存放的缓存: " + ehCacheConfig.cacheManager().getCache("boxKeyGenerator"));
        return "KeyGenerator:" + (new Date()).toString();
    }

    @Override
    public String refreshAll() {
        return "refresh all";
    }
}
