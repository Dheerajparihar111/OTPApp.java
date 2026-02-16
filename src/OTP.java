public class OTP {

    private String code;
    private long expiryTime;

    public OTP(String code, long expiryTime) {
        this.code = code;
        this.expiryTime = expiryTime;
    }

    public String getCode() {
        return code;
    }

    public long getExpiryTime() {
        return expiryTime;
    }
}
