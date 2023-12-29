public class Time {
    private int hrs;
    private int mins;
    private int secs;

    public Time() {
        hrs = 0;
        mins = 0;
        secs = 0;
    }

    public Time(int h, int m, int s) {
        hrs = h;
        mins = m;
        secs = s;
    }

    public void setTime(int h, int m, int s) {
        hrs = h >= 0 && h < 24 ? h : 0;
        mins = m >= 0 && m < 60 ? m : 0;
        secs = s >= 0 && s < 60 ? s : 0;
    }

    public int getHours() {
        return hrs;
    }

    public int getMinutes() {
        return mins;
    }

    public int getSeconds() {
        return secs;
    }

    public String toString() {
        return hrs + ":" + mins + ":" + secs;
    }

    public void printMilitary() {
        System.out.print((hrs < 10 ? "0" : "") + hrs + ":");
        System.out.print((mins < 10 ? "0" : "") + mins + ":");
        System.out.println((secs < 10 ? "0" : "") + secs);
    }

    public void printStandard() {
        System.out.print((hrs == 0 || hrs == 12 ? "12" : hrs % 12) + ":");
        System.out.print((mins < 10 ? "0" : "" + mins) + ":");
        System.out.print((secs < 10 ? "0" : "") + secs);
        System.out.println(hrs < 12 ? "AM" : "PM");
    }

    public boolean equals(Object o) {
        if (o instanceof Time) {
            Time t = (Time) o;
            return hrs == t.hrs && mins == t.mins && secs == t.secs;
        } else
            return false;
    }

    public boolean lessThan(Time t) {
        return (hrs < t.hrs) || (hrs == t.hrs && mins < t.mins) || (hrs == t.hrs && mins == t.mins && secs < t.secs);
    }

    public boolean greaterThan(Time t) {
        return !lessThan(t);
    }

    public boolean notEquals(Time t) {
        return !equals(t);
    }

    public boolean lessOrEquals(Time t) {
        return lessThan(t) || equals(t);
    }

    public boolean greaterOrEquals(Time t) {
        return greaterThan(t) || equals(t);
    }

    public void advanceSecs() {
        secs++;
        if (secs > 59) {
            secs = 0;
            advanceMins();
        }
    }

    public void advanceMins() {
        mins++;
        if (mins > 59) {
            mins = 0;
            advanceHrs();
        }

    }

    public void advanceHrs() {
        hrs++;
        if (hrs > 23)
            hrs = 0;

    }

    public void copy(Time t) {
        hrs = t.hrs;
        mins = t.mins;
        secs = t.secs;
    }

    public Time getCopy() {
        return new Time(hrs, mins, secs);
    }

    public String toMilitary() {
        return String.format("%02d:%02d:%02d", hrs, mins, secs);
    }

    public String toStandard() {
        return String.format("%02d:%02d:%02d%s", hrs == 0 || hrs == 12 ? 12 : hrs % 12, mins, secs,
                hrs < 12 ? "AM" : "PM");
    }

}