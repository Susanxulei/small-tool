package cn.edu.nju.context;

/**
 * Created by njucjc on 2018/12/20.
 */
public class ContextParser {
    public synchronized Context parseContext(int id, String pattern) {
        String [] fields = pattern.split(",");
        String timestamp = fields[0];
        String plateNumber = fields[1];
        double longitude = Double.parseDouble(fields[2]);
        double latitude = Double.parseDouble(fields[3]);
        double speed = Double.parseDouble(fields[4]);
        int status = Integer.parseInt(fields[6]);

        return new Context(id, timestamp, plateNumber, longitude, latitude, speed, status);
    }
}
