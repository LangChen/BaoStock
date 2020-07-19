package com.chlang.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`history_day_k_data`")
public class HistoryDayKData implements Serializable {
    /**
     * 主键
     */
    @Id
    @Column(name = "`id`")
    private Long id;

    /**
     * 交易所行情日期	
     */
    @Column(name = "`date`")
    private String date;

    /**
     * 证券代码
     */
    @Column(name = "`code`")
    private String code;

    /**
     * 开盘价
     */
    @Column(name = "`open`")
    private BigDecimal open;

    /**
     * 最高价
     */
    @Column(name = "`high`")
    private BigDecimal high;

    /**
     * 最低价
     */
    @Column(name = "`low`")
    private BigDecimal low;

    /**
     * 收盘价
     */
    @Column(name = "`close`")
    private BigDecimal close;

    /**
     * 前收盘价
     */
    @Column(name = "`preclose`")
    private BigDecimal preclose;

    /**
     * 成交量
     */
    @Column(name = "`volume`")
    private Long volume;

    /**
     * 成交额
     */
    @Column(name = "`amount`")
    private BigDecimal amount;

    /**
     * 复权状态
     */
    @Column(name = "`adjustflag`")
    private Byte adjustflag;

    /**
     * 换手率
     */
    @Column(name = "`turn`")
    private BigDecimal turn;

    /**
     * 交易状态
     */
    @Column(name = "`tradestatus`")
    private Byte tradestatus;

    /**
     * 涨跌幅(百分比)
     */
    @Column(name = "`pctChg`")
    private BigDecimal pctchg;

    /**
     * 滚动市盈率
     */
    @Column(name = "`peTTM`")
    private BigDecimal pettm;

    /**
     * 滚动市销率
     */
    @Column(name = "`psTTM`")
    private BigDecimal psttm;

    /**
     * 滚动市现率
     */
    @Column(name = "`pcfNcfTTM`")
    private BigDecimal pcfncfttm;

    /**
     * 市净率
     */
    @Column(name = "`pbMRQ`")
    private BigDecimal pbmrq;

    /**
     * 是否ST
     */
    @Column(name = "`isST`")
    private Byte isst;

    /**
     * 导入时间
     */
    @Column(name = "`createDate`")
    private Date createdate;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取交易所行情日期	
     *
     * @return date - 交易所行情日期	
     */
    public String getDate() {
        return date;
    }

    /**
     * 设置交易所行情日期	
     *
     * @param date 交易所行情日期	
     */
    public void setDate(String date) {
        this.date = date;
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
     * 获取开盘价
     *
     * @return open - 开盘价
     */
    public BigDecimal getOpen() {
        return open;
    }

    /**
     * 设置开盘价
     *
     * @param open 开盘价
     */
    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    /**
     * 获取最高价
     *
     * @return high - 最高价
     */
    public BigDecimal getHigh() {
        return high;
    }

    /**
     * 设置最高价
     *
     * @param high 最高价
     */
    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    /**
     * 获取最低价
     *
     * @return low - 最低价
     */
    public BigDecimal getLow() {
        return low;
    }

    /**
     * 设置最低价
     *
     * @param low 最低价
     */
    public void setLow(BigDecimal low) {
        this.low = low;
    }

    /**
     * 获取收盘价
     *
     * @return close - 收盘价
     */
    public BigDecimal getClose() {
        return close;
    }

    /**
     * 设置收盘价
     *
     * @param close 收盘价
     */
    public void setClose(BigDecimal close) {
        this.close = close;
    }

    /**
     * 获取前收盘价
     *
     * @return preclose - 前收盘价
     */
    public BigDecimal getPreclose() {
        return preclose;
    }

    /**
     * 设置前收盘价
     *
     * @param preclose 前收盘价
     */
    public void setPreclose(BigDecimal preclose) {
        this.preclose = preclose;
    }

    /**
     * 获取成交量
     *
     * @return volume - 成交量
     */
    public Long getVolume() {
        return volume;
    }

    /**
     * 设置成交量
     *
     * @param volume 成交量
     */
    public void setVolume(Long volume) {
        this.volume = volume;
    }

    /**
     * 获取成交额
     *
     * @return amount - 成交额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置成交额
     *
     * @param amount 成交额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取复权状态
     *
     * @return adjustflag - 复权状态
     */
    public Byte getAdjustflag() {
        return adjustflag;
    }

    /**
     * 设置复权状态
     *
     * @param adjustflag 复权状态
     */
    public void setAdjustflag(Byte adjustflag) {
        this.adjustflag = adjustflag;
    }

    /**
     * 获取换手率
     *
     * @return turn - 换手率
     */
    public BigDecimal getTurn() {
        return turn;
    }

    /**
     * 设置换手率
     *
     * @param turn 换手率
     */
    public void setTurn(BigDecimal turn) {
        this.turn = turn;
    }

    /**
     * 获取交易状态
     *
     * @return tradestatus - 交易状态
     */
    public Byte getTradestatus() {
        return tradestatus;
    }

    /**
     * 设置交易状态
     *
     * @param tradestatus 交易状态
     */
    public void setTradestatus(Byte tradestatus) {
        this.tradestatus = tradestatus;
    }

    /**
     * 获取涨跌幅(百分比)
     *
     * @return pctChg - 涨跌幅(百分比)
     */
    public BigDecimal getPctchg() {
        return pctchg;
    }

    /**
     * 设置涨跌幅(百分比)
     *
     * @param pctchg 涨跌幅(百分比)
     */
    public void setPctchg(BigDecimal pctchg) {
        this.pctchg = pctchg;
    }

    /**
     * 获取滚动市盈率
     *
     * @return peTTM - 滚动市盈率
     */
    public BigDecimal getPettm() {
        return pettm;
    }

    /**
     * 设置滚动市盈率
     *
     * @param pettm 滚动市盈率
     */
    public void setPettm(BigDecimal pettm) {
        this.pettm = pettm;
    }

    /**
     * 获取滚动市销率
     *
     * @return psTTM - 滚动市销率
     */
    public BigDecimal getPsttm() {
        return psttm;
    }

    /**
     * 设置滚动市销率
     *
     * @param psttm 滚动市销率
     */
    public void setPsttm(BigDecimal psttm) {
        this.psttm = psttm;
    }

    /**
     * 获取滚动市现率
     *
     * @return pcfNcfTTM - 滚动市现率
     */
    public BigDecimal getPcfncfttm() {
        return pcfncfttm;
    }

    /**
     * 设置滚动市现率
     *
     * @param pcfncfttm 滚动市现率
     */
    public void setPcfncfttm(BigDecimal pcfncfttm) {
        this.pcfncfttm = pcfncfttm;
    }

    /**
     * 获取市净率
     *
     * @return pbMRQ - 市净率
     */
    public BigDecimal getPbmrq() {
        return pbmrq;
    }

    /**
     * 设置市净率
     *
     * @param pbmrq 市净率
     */
    public void setPbmrq(BigDecimal pbmrq) {
        this.pbmrq = pbmrq;
    }

    /**
     * 获取是否ST
     *
     * @return isST - 是否ST
     */
    public Byte getIsst() {
        return isst;
    }

    /**
     * 设置是否ST
     *
     * @param isst 是否ST
     */
    public void setIsst(Byte isst) {
        this.isst = isst;
    }

    /**
     * 获取导入时间
     *
     * @return createDate - 导入时间
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置导入时间
     *
     * @param createdate 导入时间
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
        HistoryDayKData other = (HistoryDayKData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getOpen() == null ? other.getOpen() == null : this.getOpen().equals(other.getOpen()))
            && (this.getHigh() == null ? other.getHigh() == null : this.getHigh().equals(other.getHigh()))
            && (this.getLow() == null ? other.getLow() == null : this.getLow().equals(other.getLow()))
            && (this.getClose() == null ? other.getClose() == null : this.getClose().equals(other.getClose()))
            && (this.getPreclose() == null ? other.getPreclose() == null : this.getPreclose().equals(other.getPreclose()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getAdjustflag() == null ? other.getAdjustflag() == null : this.getAdjustflag().equals(other.getAdjustflag()))
            && (this.getTurn() == null ? other.getTurn() == null : this.getTurn().equals(other.getTurn()))
            && (this.getTradestatus() == null ? other.getTradestatus() == null : this.getTradestatus().equals(other.getTradestatus()))
            && (this.getPctchg() == null ? other.getPctchg() == null : this.getPctchg().equals(other.getPctchg()))
            && (this.getPettm() == null ? other.getPettm() == null : this.getPettm().equals(other.getPettm()))
            && (this.getPsttm() == null ? other.getPsttm() == null : this.getPsttm().equals(other.getPsttm()))
            && (this.getPcfncfttm() == null ? other.getPcfncfttm() == null : this.getPcfncfttm().equals(other.getPcfncfttm()))
            && (this.getPbmrq() == null ? other.getPbmrq() == null : this.getPbmrq().equals(other.getPbmrq()))
            && (this.getIsst() == null ? other.getIsst() == null : this.getIsst().equals(other.getIsst()))
            && (this.getCreatedate() == null ? other.getCreatedate() == null : this.getCreatedate().equals(other.getCreatedate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getOpen() == null) ? 0 : getOpen().hashCode());
        result = prime * result + ((getHigh() == null) ? 0 : getHigh().hashCode());
        result = prime * result + ((getLow() == null) ? 0 : getLow().hashCode());
        result = prime * result + ((getClose() == null) ? 0 : getClose().hashCode());
        result = prime * result + ((getPreclose() == null) ? 0 : getPreclose().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getAdjustflag() == null) ? 0 : getAdjustflag().hashCode());
        result = prime * result + ((getTurn() == null) ? 0 : getTurn().hashCode());
        result = prime * result + ((getTradestatus() == null) ? 0 : getTradestatus().hashCode());
        result = prime * result + ((getPctchg() == null) ? 0 : getPctchg().hashCode());
        result = prime * result + ((getPettm() == null) ? 0 : getPettm().hashCode());
        result = prime * result + ((getPsttm() == null) ? 0 : getPsttm().hashCode());
        result = prime * result + ((getPcfncfttm() == null) ? 0 : getPcfncfttm().hashCode());
        result = prime * result + ((getPbmrq() == null) ? 0 : getPbmrq().hashCode());
        result = prime * result + ((getIsst() == null) ? 0 : getIsst().hashCode());
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
        sb.append(", date=").append(date);
        sb.append(", code=").append(code);
        sb.append(", open=").append(open);
        sb.append(", high=").append(high);
        sb.append(", low=").append(low);
        sb.append(", close=").append(close);
        sb.append(", preclose=").append(preclose);
        sb.append(", volume=").append(volume);
        sb.append(", amount=").append(amount);
        sb.append(", adjustflag=").append(adjustflag);
        sb.append(", turn=").append(turn);
        sb.append(", tradestatus=").append(tradestatus);
        sb.append(", pctchg=").append(pctchg);
        sb.append(", pettm=").append(pettm);
        sb.append(", psttm=").append(psttm);
        sb.append(", pcfncfttm=").append(pcfncfttm);
        sb.append(", pbmrq=").append(pbmrq);
        sb.append(", isst=").append(isst);
        sb.append(", createdate=").append(createdate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}