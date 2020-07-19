package com.chlang.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`stock`")
public class Stock implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private Integer id;

    /**
     * 证券代码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 证券名称
     */
    @Column(name = "`code_name`")
    private String codeName;

    /**
     * 交易状态(1：正常交易 0：停牌）
     */
    @Column(name = "`tradeStatus`")
    private Byte tradestatus;

    /**
     * 创建日期
     */
    @Column(name = "`createDate`")
    private Date createdate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取证券代码
     *
     * @return code - 证券代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置证券代码
     *
     * @param code 证券代码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取证券名称
     *
     * @return code_name - 证券名称
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置证券名称
     *
     * @param codeName 证券名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * 获取交易状态(1：正常交易 0：停牌）
     *
     * @return tradeStatus - 交易状态(1：正常交易 0：停牌）
     */
    public Byte getTradestatus() {
        return tradestatus;
    }

    /**
     * 设置交易状态(1：正常交易 0：停牌）
     *
     * @param tradestatus 交易状态(1：正常交易 0：停牌）
     */
    public void setTradestatus(Byte tradestatus) {
        this.tradestatus = tradestatus;
    }

    /**
     * 获取创建日期
     *
     * @return createDate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Stock other = (Stock) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getCodeName() == null ? other.getCodeName() == null : this.getCodeName().equals(other.getCodeName()))
            && (this.getTradestatus() == null ? other.getTradestatus() == null : this.getTradestatus().equals(other.getTradestatus()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getCodeName() == null) ? 0 : getCodeName().hashCode());
        result = prime * result + ((getTradestatus() == null) ? 0 : getTradestatus().hashCode());
        result = prime * result + ((getCreatedate() == null) ? 0 : getCreatedate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", codeName=").append(codeName);
        sb.append(", tradestatus=").append(tradestatus);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}