package vip.epss.domain;
/**
 * 宿舍打分
 */
public class HistScore {
    private Integer id;
    //宿舍号
    private Integer roomId;
    //分数
    private double histScore;
    //打分日期
    private String date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public double getHistScore() {
        return histScore;
    }

    public void setHistScore(double histScore) {
        this.histScore = histScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}