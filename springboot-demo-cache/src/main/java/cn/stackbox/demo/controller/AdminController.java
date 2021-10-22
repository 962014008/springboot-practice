package cn.stackbox.demo.controller;

import cn.stackbox.demo.config.CustomApplicationContext;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description 监视系统缓存数据
 */
@Controller
public class AdminController {

    /**
     * 返回项目ehcache缓存的所有数据
     */
    @RequestMapping(value = {"/ehcache/print"})
    @ResponseBody
    public String printEhcache() {
        JSONObject json = new JSONObject();
        //获取spring管理的EhCacheCacheManager对象
        EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager) CustomApplicationContext.getBean("appEhCacheCacheManager");
        CacheManager cacheManager = ehCacheCacheManager.getCacheManager();
        //获取所有缓存类型
        String[] cacheNames = cacheManager.getCacheNames();

        for (String cacheName : cacheNames) {
            //过滤不匹配的ehcache
//            if (StringUtils.isNotEmpty(request.getCache()) && !request.getCache().equals(cacheName)) {
//                continue;
//            }
            //获取缓存
            Cache cacheObject = cacheManager.getCache(cacheName);
            JSONArray jsonArray = new JSONArray();
            List keyList = cacheObject.getKeys();
            if (keyList != null && keyList.size() > 0) {
                for (Object key : keyList) {
                    JSONObject jsonObject = new JSONObject();
                    Element element = cacheObject.get(key);
                    jsonObject.put((String) key, element);
                    jsonArray.add(jsonObject);
                }
            }
            json.put(cacheName, jsonArray);
        }

        return json.toJSONString();
    }
}