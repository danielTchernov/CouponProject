package com.daniel.server.enums;

// for client
public enum ErrorType {

    GENERAL_ERROR(1, "General error", true),
    INVALID_AMOUNT_OF_CHILDREN(2 ,"Invalid amount of children" , false),
    WRONG_USERNAME(3,"Invalid username", false),
    WRONG_PASSWORD(4,"Invalid Password", false),
    WRONG_LENGTH(5,"Wrong length, should be between 5-10 charectors.", false),
    USERNAME_OCCUPIED(6,"Username occupied", false),
    CATEGORY_EXIST(7, "CategoryEntity Exist", false),
    COUPON_EXIST(8, "CouponEntity Exist", false),
    DATE_ERROR(9, "Date Error", false),
    PRICE_ERROR(10,"Price too low", false),
    COMPANY_NAME_ERROR(11,"CompanyEntity already exist", false),
    BAD_PHONE(12, "Bad Phone", false),
    BAD_ADDRESS(13, "Bad address", false),
    BAD_AMOUNT(14, "Bad amount", false),
    BAD_ID(15,"Bad ID", false),
    SIZE_BAD_PASSWORD(16, "Too Long/Short password", false),
    BAD_USERNAME(17, "Not allowed charecters in the username field", false),
    BAD_USER_OR_PASSWORD(18, "Wrong username or password" , false),
    ACCESS_FORBIDEN(19, "Access forbiden, only admin can access it." , false),
    PHONE_ALREADY_EXIST(20, "Phone number already registered.", false),
    NO_CATEGORY_FOUND(21, "No category found", false);

    private int errorNumber;
    private String errorMessage;
    private boolean isShowStackTrace;

    ErrorType(int errorNumber, String errorMessage, boolean isShowStackTrace) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
        this.isShowStackTrace = isShowStackTrace;
    }

    ErrorType(int errorNumber, String errorMessage) {
        this.errorNumber = errorNumber;
        this.errorMessage = errorMessage;
    }

    ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorNumber() {
        return errorNumber;
    }

    public boolean isShowStackTrace() {
        return isShowStackTrace;
    }
}