#!/usr/bin/env python3

import baostock as bs
import pandas as pd
import pymysql

# 链接数据库
db = pymysql.connect(host="localhost",user='root',password='root',db='Baostock',port=3306)
cursor = db.cursor()

#### 登陆系统 ####
lg = bs.login()
# 显示登陆返回信息
print('login respond error_code:'+lg.error_code)
print('login respond  error_msg:'+lg.error_msg)

#### 获取当前所有的股票 ####
rs = bs.query_all_stock(day="2020-07-10")
all_stock_code = []
while (rs.error_code == '0') & rs.next():
    stock = rs.get_row_data()
    # 获取一条记录，将记录合并在一起
    sql = 'insert into stock(code,code_name,tradeStatus)VALUES ("'+stock[0]+'","'+stock[2]+'","'+stock[1]+'")'
    print(sql)
    cursor.execute(sql)
    db.commit()

cursor.close()
print('Import done!')
bs.logout()