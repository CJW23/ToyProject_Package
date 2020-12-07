package com.cjw.inflearntest;

public class Study {
    private StudyStatus status = StudyStatus.DRAFT;
    private int limit;

    public Study() { }
    public Study(int limit) {
        if(limit < 0) {
            throw new IllegalArgumentException("0보다 작음");
        }
        this.limit = limit;
    }
    public StudyStatus getStatus() {
        return this.status;
    }
    public int getLimit() {
        return this.limit;
    }
}
