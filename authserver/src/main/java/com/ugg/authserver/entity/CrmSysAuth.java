package com.ugg.authserver.entity;

import java.util.Date;

public class CrmSysAuth {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.role_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Integer roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.access_path
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private String accessPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.version
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Integer version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.is_deleted
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Boolean isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.create_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Integer createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.create_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.update_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Integer updateUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth.update_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.id
     *
     * @return the value of crm_sys_auth.id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.id
     *
     * @param id the value for crm_sys_auth.id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.role_id
     *
     * @return the value of crm_sys_auth.role_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.role_id
     *
     * @param roleId the value for crm_sys_auth.role_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.access_path
     *
     * @return the value of crm_sys_auth.access_path
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public String getAccessPath() {
        return accessPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.access_path
     *
     * @param accessPath the value for crm_sys_auth.access_path
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setAccessPath(String accessPath) {
        this.accessPath = accessPath == null ? null : accessPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.version
     *
     * @return the value of crm_sys_auth.version
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.version
     *
     * @param version the value for crm_sys_auth.version
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.is_deleted
     *
     * @return the value of crm_sys_auth.is_deleted
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.is_deleted
     *
     * @param isDeleted the value for crm_sys_auth.is_deleted
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.create_user_id
     *
     * @return the value of crm_sys_auth.create_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.create_user_id
     *
     * @param createUserId the value for crm_sys_auth.create_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.create_time
     *
     * @return the value of crm_sys_auth.create_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.create_time
     *
     * @param createTime the value for crm_sys_auth.create_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.update_user_id
     *
     * @return the value of crm_sys_auth.update_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.update_user_id
     *
     * @param updateUserId the value for crm_sys_auth.update_user_id
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth.update_time
     *
     * @return the value of crm_sys_auth.update_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth.update_time
     *
     * @param updateTime the value for crm_sys_auth.update_time
     *
     * @mbggenerated Tue Jul 02 15:21:40 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}