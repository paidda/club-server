package com.javaclimb.club.dao;

import com.javaclimb.club.domain.form.ActiveForm;
import com.javaclimb.club.domain.form.ClubForm;
import com.javaclimb.club.domain.vo.ActiveVO;
import com.javaclimb.club.domain.vo.ClubVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActiveMapper {

    List<ActiveVO> getActiveList(ActiveForm activeForm);
}
