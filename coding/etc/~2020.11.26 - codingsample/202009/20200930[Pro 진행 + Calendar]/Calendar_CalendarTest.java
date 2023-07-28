import java.util.Calendar;

public class Calendar_CalendarTest {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        // 1) 현재 달력정보를 가져온다.

        System.out.println("현재 시각은     = " + cal.getTime());
        System.out.println("오늘의 요일     = " + cal.get(Calendar.DAY_OF_WEEK));
        System.out.println("오늘의 달       = " + cal.get(Calendar.MONTH));
        System.out.println("오늘의 일       = " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("현재 시간       = " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("현재 분         = " + cal.get(Calendar.MINUTE));
        System.out.println("현재 초         = " + cal.get(Calendar.SECOND));
        System.out.println("이번 년도       = " + cal.get(Calendar.YEAR));
        // 2) 가져온 달력정보를 출력한다.

        cal.add(Calendar.SECOND, 120);
        System.out.println("2분 증가        = " + cal.getTime());
        cal.roll(Calendar.SECOND, 60);
        System.out.println("roll 예제       = " + cal.getTime());
        // 3) 현재 시각에서 시간초를 더하거나 뺄 수 있다. 
        // ex) 초가 120초 증가되면 60초가 넘어갔기 때문에 120초 증가하는 식으로, add는 다른 범위에 영향을 끼침
        //      하지만 roll은 다른 값에 영향을 주지 않아서 60초를 증가하면 아무런 영향을 주지 못한다.

        Calendar cal2 = Calendar.getInstance();
        Calendar cal3 = Calendar.getInstance();
        cal2.set(1982, 9 ,30);
        cal3.set(2020, 9 ,30);
        System.out.println(cal2.before(cal3));
        System.out.println(cal3.after(cal2));
        // 4) before와 after로 시간간의 비교를 할 수 있다.
        // 5) set을 통해 특정 시간을 Calendar값으로 설정할 수 있다.
    }
}
