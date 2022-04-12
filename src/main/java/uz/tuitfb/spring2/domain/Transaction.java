package uz.tuitfb.spring2.domain;

public class Transaction {
    private Long id;

    private Double amont;

    private String reaseans;

    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmont() {
        return amont;
    }

    public void setAmont(Double amont) {
        this.amont = amont;
    }

    public String getReaseans() {
        return reaseans;
    }

    public void setReaseans(String reaseans) {
        this.reaseans = reaseans;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
