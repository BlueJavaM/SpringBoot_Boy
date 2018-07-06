package com.bluepro.boy.repository;

import com.bluepro.boy.domain.Boy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 *@Author: XieLiang
 *@Date : 2018/7/4
 *@Comment :
 */
public interface BoyRepository extends JpaRepository<Boy,Integer> {

    List<Boy> findBoyByJjSize(String jjSize);
}
