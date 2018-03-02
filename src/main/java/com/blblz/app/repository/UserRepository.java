package com.blblz.app.repository;

import com.blblz.app.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author WeiYangDong
 * @date 2018/3/2 17:27
 * @deprecated {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的存储方式 -> Map
     */
    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户
     * @param user {@link User} 对象
     * @return 保存成功返回<code>true</code>,否则返回<code>false</code>
     */
    public boolean saveUser(User user){
        //ID从1开始
        Integer id = idGenerator.incrementAndGet();
//        repository.put(id,user);
        //put方法成功返回null
        user.setId(id);
        return repository.put(id,user) == null;
    }
}
