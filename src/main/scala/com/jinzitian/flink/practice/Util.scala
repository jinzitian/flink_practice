package com.jinzitian.flink.practice

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

import java.security.MessageDigest

/**
  * Created by jinzitian on 2019/03/27.
  */
object Util {

  //计算n天前、后日期
  def dayBeforeOrAfter(target_date:String, n:Int, action:String = "before"):String = {
    val cal = Calendar.getInstance()
    val fm = new SimpleDateFormat("yyyy-MM-dd")
    val date = fm.parse(target_date)
    cal.setTime(date)
    val day = cal.get(Calendar.DATE)

    if (action == "before"){
      cal.set(Calendar.DATE,  day - n)
    }else if(action == "after"){
      cal.set(Calendar.DATE,  day + n)
    }else{
      throw new Exception("action must be before or after")
    }

    val day_before = fm.format(cal.getTime)
    day_before
  }

  //得到md5加密后的字符串
  def md5(s:String):String={
    val digest = MessageDigest.getInstance("MD5")
    val md5hash1 = digest.digest(s.getBytes).map("%02x".format(_)).mkString
    md5hash1
  }

  //日期转换时间戳
  def date_to_timestamp(date:String):String={
    val fm = new SimpleDateFormat("yyyy-MM-dd")
    val dt = fm.parse(date)
    dt.getTime.toString
  }
  //时间戳转日期
  def timestamp_to_date(timeStamp:String):String ={
    //timeStamp = "1523973291000"
    val fm = new SimpleDateFormat("yyyy-MM-dd")
    val date = new Date(timeStamp.toLong)
    val date_str = fm.format(date)
    date_str
  }

}
