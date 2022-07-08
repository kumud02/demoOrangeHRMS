package entities.common;

public enum OrangeHRMSEntity {
    USER("USER");

    private String type;

    OrangeHRMSEntity(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
