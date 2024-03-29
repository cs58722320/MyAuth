package com.ugg.authserver.entity;

import java.util.Date;

public class CrmSysAuthLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.user_name
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.ip_addr
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private String ipAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.create_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private Integer createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.create_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.update_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private Integer updateUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column crm_sys_auth_log.update_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.id
     *
     * @return the value of crm_sys_auth_log.id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.id
     *
     * @param id the value for crm_sys_auth_log.id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.user_name
     *
     * @return the value of crm_sys_auth_log.user_name
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.user_name
     *
     * @param userName the value for crm_sys_auth_log.user_name
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.ip_addr
     *
     * @return the value of crm_sys_auth_log.ip_addr
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public String getIpAddr() {
        return ipAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.ip_addr
     *
     * @param ipAddr the value for crm_sys_auth_log.ip_addr
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.create_user_id
     *
     * @return the value of crm_sys_auth_log.create_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.create_user_id
     *
     * @param createUserId the value for crm_sys_auth_log.create_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.create_time
     *
     * @return the value of crm_sys_auth_log.create_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.create_time
     *
     * @param createTime the value for crm_sys_auth_log.create_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.update_user_id
     *
     * @return the value of crm_sys_auth_log.update_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.update_user_id
     *
     * @param updateUserId the value for crm_sys_auth_log.update_user_id
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column crm_sys_auth_log.update_time
     *
     * @return the value of crm_sys_auth_log.update_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column crm_sys_auth_log.update_time
     *
     * @param updateTime the value for crm_sys_auth_log.update_time
     *
     * @mbggenerated Tue Jul 23 15:33:47 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}