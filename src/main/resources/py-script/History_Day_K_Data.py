#!/usr/bin/env python3
import baostock as bs
import pandas as pd
import pymysql
import datetime

#获取某天的所有股票k线数据
def getOneDayStockDate(datrStr):
    #### 获取当前所有的股票 ####
    rs = bs.query_all_stock(day=datrStr)
    k_total = 0
    while (rs.error_code == '0') & rs.next():
        k_total = k_total + 1
        stock = rs.get_row_data()
        # 获取每只股票的k线
        rs1 = bs.query_history_k_data_plus(stock[0],
        "date,code,open,high,low,close,preclose,volume,amount,adjustflag,turn,tradestatus,pctChg,peTTM,psTTM,pcfNcfTTM,pbMRQ,isST",
        start_date=datrStr, end_date=datrStr,
        frequency="d", adjustflag="2")

        while (rs1.error_code == '0') & rs1.next():
            kd = rs1.get_row_data()
            kd[2] = str(round(float(kd[2]),4))
            kd[3] = str(round(float(kd[3]),4))
            kd[4] = str(round(float(kd[4]),4))
            kd[5] = str(round(float(kd[5]),4))
            kd[6] = str(round(float(kd[6]),4))
            if kd[7]== '' :
                kd[7]='0'
            elif kd[7] == 0:
                kd[7]='0'
            if kd[8]== '' :
                kd[8]='0.000000'
            elif kd[8] == 0:
                kd[8]='0.000000'
            if kd[10]== '' :
                kd[10]='0.000000'
            elif kd[10] == 0:
                kd[10]='0.000000'
            if kd[12]== '' :
                kd[12]='0.000000'
            elif kd[12] == 0:
                kd[12]='0.000000'
            # print(kd)
            sql = 'insert into history_day_k_data(`date`,`code`,`open`,`high`,`low`,`close`,`preclose`,`volume`,`amount`,`adjustflag`,`turn`,`tradestatus`,`pctChg`,`peTTM`,`psTTM`,`pcfNcfTTM`,`pbMRQ`,`isST`)VALUES ("'+\
            kd[0]+'","'+kd[1]+'","'+kd[2]+'","'+kd[3]+'","'+kd[4]+'","'+kd[5]+'","'+kd[6]+'","'+kd[7]+'","'+kd[8]+'","'+kd[9]+'","'+kd[10]+'","'+kd[11]+'","'+kd[12]+'","'+kd[13]+'","'+kd[14]+'","'+kd[15]+'","'+kd[16]+'","'+kd[17]+'")'

            cursor.execute(sql)
            db.commit()
    return k_total

# 链接数据库
db = pymysql.connect(host="localhost",user='root',password='root',db='Baostock',port=3306)
cursor = db.cursor()
#### 登陆系统 ####
lg = bs.login()
# 获取数据库k线数据的最后一天
sql = 'select hdkd.date from history_day_k_data hdkd order by hdkd.date desc limit 1'
cursor.execute(sql)
row = cursor.fetchone()
db_lastDate = row[0]
dt = datetime.datetime.strptime(db_lastDate, "%Y-%m-%d")
db_lastDate_next_date = (dt + datetime.timedelta(days=1)).strftime("%Y-%m-%d")
now_date = datetime.datetime.now().strftime("%Y-%m-%d")
date_tmp = db_lastDate_next_date

# 遍历每一天，获取每一天的k线数据
while True :
    if(date_tmp > now_date):
        break
    
    print("正在获取%sk线数据...." % (date_tmp))
    k_total = getOneDayStockDate(date_tmp)
    print("已获取%sk线数据完成，总共：%d 条数据" % (date_tmp,k_total))

    dt1 = datetime.datetime.strptime(date_tmp, "%Y-%m-%d")
    date_tmp = (dt1 + datetime.timedelta(days=1)).strftime("%Y-%m-%d")

#### 登出系统 ####
bs.logout()