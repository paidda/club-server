package com.javaclimb.club.dao;

import com.javaclimb.club.domain.form.ActiveUserForm;
import com.javaclimb.club.domain.vo.ActiveUserVO;
import com.javaclimb.club.domain.vo.MyActiveVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveUserMapper {

    List<MyActiveVO> myActiveUserList(ActiveUserForm activeUserForm);

    List<ActiveUserVO>  getActiveUserList(ActiveUserForm activeUserForm);
}
