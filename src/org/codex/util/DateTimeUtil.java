package org.codex.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ʱ�乤����
 * @author zhangqi5
 *
 */
public class DateTimeUtil {
	
	public static final String DATA_FORMAT_yyyy_MM_dd = "yyyy-MM-dd";
	public static final String DATA_FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * ��ȡ��ʼʱ��ͽ���ʱ��֮�����Ȼ������
	 * @param startTime
	 * @param targetTime
	 * @return
	 * @throws ParseException
	 */
	public static int getWeekNum(String startTime, String targetTime) throws ParseException{
		SimpleDateFormat sdfFormat = new SimpleDateFormat(DATA_FORMAT_yyyy_MM_dd);
		Date dateValue1 = sdfFormat.parse(startTime);
		Date dateValue2 = sdfFormat.parse(targetTime);
		
		//���㿪ʼ����ǰһ�����յ�����
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateValue1);
		cal.add(Calendar.WEEK_OF_MONTH, -1);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date previousSunday = cal.getTime();
		 
		//����������ڵ������յ�����
		cal.setTime(dateValue2);
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		Date lastSunday = cal.getTime();

		return (DateTimeUtil.getDateDiff(lastSunday, previousSunday))/7;
	}
	
	/**
	 * ��ȡ��������֮����������
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDateDiff(Date date1, Date date2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);
		Long lngDiff = (c1.getTime().getTime() - c2.getTime().getTime()) / (24 * 3600 * 1000);
		return (lngDiff.intValue());
	}
}
