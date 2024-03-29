package com.ugg.authserver.mapper;

import com.ugg.authserver.entity.CrmSysAuth;
import com.ugg.authserver.entity.CrmSysAuthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmSysAuthMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int countByExample(CrmSysAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int deleteByExample(CrmSysAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int insert(CrmSysAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int insertSelective(CrmSysAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    List<CrmSysAuth> selectByExample(CrmSysAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    CrmSysAuth selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") CrmSysAuth record, @Param("example") CrmSysAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int updateByExample(@Param("record") CrmSysAuth record, @Param("example") CrmSysAuthExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int updateByPrimaryKeySelective(CrmSysAuth record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_auth
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    int updateByPrimaryKey(CrmSysAuth record);
}