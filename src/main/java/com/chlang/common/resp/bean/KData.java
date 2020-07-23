package com.chlang.common.resp.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author chenlang
 * @date 2020/7/19 1:22 下午
 **/
public class KData {

    private Long id;

    private String date;

    private String code;

    private BigDecimal open;

    private BigDecimal high;

    private BigDecimal low;

    private BigDecimal close;

    private BigDecimal preclose;

    private Long volume;

    private BigDecimal amount;

    private Byte adjustflag;

    private BigDecimal turn;

    private Byte tradestatus;

    private BigDecimal pctchg;

    private BigDecimal pettm;

    private BigDecimal psttm;

    private BigDecimal pcfncfttm;

    private BigDecimal pbmrq;

    private Byte isst;

    private String codeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getPreclose() {
        return preclose;
    }

    public void setPreclose(BigDecimal preclose) {
        this.preclose = preclose;
    }

    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Byte getAdjustflag() {
        return adjustflag;
    }

    public void setAdjustflag(Byte adjustflag) {
        this.adjustflag = adjustflag;
    }

    public BigDecimal getTurn() {
        return turn;
    }

    public void setTurn(BigDecimal turn) {
        this.turn = turn;
    }

    public Byte getTradestatus() {
        return tradestatus;
    }

    public void setTradestatus(Byte tradestatus) {
        this.tradestatus = tradestatus;
    }

    public BigDecimal getPctchg() {
        return pctchg;
    }

    public void setPctchg(BigDecimal pctchg) {
        this.pctchg = pctchg;
    }

    public BigDecimal getPettm() {
        return pettm;
    }

    public void setPettm(BigDecimal pettm) {
        this.pettm = pettm;
    }

    public BigDecimal getPsttm() {
        return psttm;
    }

    public void setPsttm(BigDecimal psttm) {
        this.psttm = psttm;
    }

    public BigDecimal getPcfncfttm() {
        return pcfncfttm;
    }

    public void setPcfncfttm(BigDecimal pcfncfttm) {
        this.pcfncfttm = pcfncfttm;
    }

    public BigDecimal getPbmrq() {
        return pbmrq;
    }

    public void setPbmrq(BigDecimal pbmrq) {
        this.pbmrq = pbmrq;
    }

    public Byte getIsst() {
        return isst;
    }

    public void setIsst(Byte isst) {
        this.isst = isst;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
