public class OTP {

    private final String code;
    private final long expiryTime;

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
