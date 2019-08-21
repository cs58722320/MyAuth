package com.ugg.authserver.mapper;

import com.ugg.authserver.entity.CrmSysUserRole;
import com.ugg.authserver.entity.CrmSysUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CrmSysUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int countByExample(CrmSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int deleteByExample(CrmSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int insert(CrmSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int insertSelective(CrmSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    List<CrmSysUserRole> selectByExample(CrmSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    CrmSysUserRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int updateByExampleSelective(@Param("record") CrmSysUserRole record, @Param("example") CrmSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int updateByExample(@Param("record") CrmSysUserRole record, @Param("example") CrmSysUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int updateByPrimaryKeySelective(CrmSysUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table crm_sys_user_role
     *
     * @mbggenerated Sat Jun 08 00:10:05 CST 2019
     */
    int updateByPrimaryKey(CrmSysUserRole record);
}