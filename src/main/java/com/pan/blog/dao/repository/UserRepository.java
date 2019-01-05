package com.pan.blog.dao.repository;

import com.pan.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by FantasticPan on 2018/11/23.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户姓名分页查询用户列表
     *
     * @param name
     * @param pageable
     * @return
     */
    //Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户帐号查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 根据名称列表查询
     * @param usernames
     * @return
     */
    //List<User> findByUsernameIn(Collection<String> usernames);
}
