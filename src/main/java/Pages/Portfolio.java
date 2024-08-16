package Pages;

public class Portfolio {

    private long portfolioId;
    private String benchmark;
    private String accountNumber;
    private String title1;
    private String title2;
    private String countryProfile;
    private String code1;
    private String code2;
    private String code3;
    private String code4;
    private String firstDate;
    private String shortName;
    private String longName;
    private String portfolioType;
    private String managerName;
    private String lastValidDate;
    private String underLyingId;


    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getCountryProfile() {
        return countryProfile;
    }

    public void setCountryProfile(String countryProfile) {
        this.countryProfile = countryProfile;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public String getCode4() {
        return code4;
    }

    public void setCode4(String code4) {
        this.code4 = code4;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getPortfolioType() {
        return portfolioType;
    }

    public void setPortfolioType(String portfolioType) {
        this.portfolioType = portfolioType;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getLastValidDate() {
        return lastValidDate;
    }

    public void setLastValidDate(String lastValidDate) {
        this.lastValidDate = lastValidDate;
    }

    public String getUnderLyingId() {
        return underLyingId;
    }

    public void setUnderLyingId(String underLyingId) {
        this.underLyingId = underLyingId;
    }

    @Override
    public String toString(){

        return "ClassPojo [benchmark = "+benchmark+", accountNumber = "+accountNumber+", title1 =" +title1+", countryProfile =" +countryProfile+
                ", title ="+title2+", code1 ="+code1+", code2 ="+code2+" ,code3"+code3+" ,code4 ="+code4+" ,firstDate ="+ firstDate+" ,lastValidDate ="+lastValidDate+
                " ,underlyingId ="+underLyingId+" ,portfolioType ="+ portfolioType+" ,portfolioId ="+portfolioId+" ,shortName ="+shortName+
                " ,longName ="+longName+" ,managerName ="+managerName+"]";

    }
}


